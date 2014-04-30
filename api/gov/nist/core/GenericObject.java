package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public abstract class GenericObject implements Serializable, Cloneable {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.773 -0500", hash_original_method = "3ADC87FD7E0CE83F45EDE92BAF50BA02", hash_generated_method = "3AAAF751889C9C699791AFC88073E877")
    
public static Class<?> getClassFromName(String className) {
        try {
            return Class.forName(className);
        } catch (Exception ex) {
            InternalErrorHandler.handleException(ex);
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.776 -0500", hash_original_method = "EF8AFE13396C3D5BB8999D24EBF9F5DC", hash_generated_method = "D969C44A303A70CE8E5715D125680212")
    
public static boolean isMySubclass(Class<?> other) {

            return GenericObject.class.isAssignableFrom(other);

    }

    /** Clones the given object.
     *  If the object is a wrapped type, an array, a GenericObject
     *  or a GenericObjectList, it is cast to the appropriate type
     *  and the clone() method is invoked. Else if the object implements
     *  Cloneable, reflection is used to discover and invoke
     *  clone() method. Otherwise, the original object is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.779 -0500", hash_original_method = "919C8056B91C479DBF440A03C3E884A4", hash_generated_method = "35DD9E899C5E71D8C4E8252A016940D1")
    
public static Object makeClone(Object obj) {
        if (obj == null)
            throw new NullPointerException("null obj!");
        Class<?> c = obj.getClass();
        Object clone_obj = obj;
        if (immutableClasses.contains (c))
            return obj;
        else if (c.isArray ()) {
            Class<?> ec = c.getComponentType();
            if (! ec.isPrimitive())
                clone_obj = ((Object []) obj).clone();
            else {
                if (ec == Character.TYPE)
                    clone_obj = ((char []) obj).clone();
                else if (ec == Boolean.TYPE)
                    clone_obj = ((boolean []) obj).clone();
                if (ec == Byte.TYPE)
                    clone_obj = ((byte []) obj).clone();
                else if (ec == Short.TYPE)
                    clone_obj = ((short []) obj).clone();
                else if (ec == Integer.TYPE)
                    clone_obj = ((int []) obj).clone();
                else if (ec == Long.TYPE)
                    clone_obj = ((long []) obj).clone();
                else if (ec == Float.TYPE)
                    clone_obj = ((float []) obj).clone();
                else if (ec == Double.TYPE)
                    clone_obj = ((double []) obj).clone();
            }
        } else if (GenericObject.class.isAssignableFrom (c))
            clone_obj = ((GenericObject) obj).clone();
        else if (GenericObjectList.class.isAssignableFrom (c))
            clone_obj = ((GenericObjectList) obj).clone();
        else if (Cloneable.class.isAssignableFrom (c)) {
            // If a clone method exists for the object, then
            // invoke it
            try {
                Method meth = c.getMethod("clone", (Class[]) null);
                clone_obj = meth.invoke(obj,(Object[]) null);
            } catch (SecurityException ex) {
            } catch (IllegalArgumentException ex) {
                InternalErrorHandler.handleException(ex);
            } catch (IllegalAccessException ex) {
            } catch (InvocationTargetException ex) {
            } catch (NoSuchMethodException ex) {
            }
        }
        return clone_obj;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.697 -0500", hash_original_field = "E9205B48E353C2B1F4B96A83A943F3A0", hash_generated_field = "02EC968BA435084EE7ADC81279AB56D8")

    protected static final String SEMICOLON = Separators.SEMICOLON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.699 -0500", hash_original_field = "D77BD2C56F0ED05DF3619D69EC5649F2", hash_generated_field = "6B6A3C0E5AAA12BC4230EF790A3C2476")

    protected static final String COLON = Separators.COLON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.702 -0500", hash_original_field = "5201C3D18F11737A5DD3460775E883ED", hash_generated_field = "2C4A8D03DDB954D51E978CD8F8E2DEA4")

    protected static final String COMMA = Separators.COMMA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.705 -0500", hash_original_field = "0C18FFF75A726C363F0DB6D598A8E1AD", hash_generated_field = "8A50D691E37AC9254B7ED2ABCE4AC6D2")

    protected static final String SLASH = Separators.SLASH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.707 -0500", hash_original_field = "0F465C1A1C5914A9212A6C1DC851E9B7", hash_generated_field = "0CF03E9FD9212362B2D202A36124051A")

    protected static final String SP = Separators.SP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.710 -0500", hash_original_field = "2DB7282116447C711C852E29F65C28C9", hash_generated_field = "AD22F298E6FF482BE0BD697358901610")

    protected static final String EQUALS = Separators.EQUALS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.713 -0500", hash_original_field = "16A0EB1F3341F8778CCE9E8B90D6DDE3", hash_generated_field = "2A5C8D44567A1C68D53F48B0CD1AF72E")

    protected static final String STAR = Separators.STAR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.715 -0500", hash_original_field = "535F896CBCDC67C062AECC6B8D97F82B", hash_generated_field = "99D8C532EFD2EC03350A98B152CEDB7F")

    protected static final String NEWLINE = Separators.NEWLINE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.718 -0500", hash_original_field = "CE823ACDDD84129449B4E21BF2FF83A6", hash_generated_field = "5E44FE20A9580182CC4CE4836B87D2F2")

    protected static final String RETURN = Separators.RETURN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.720 -0500", hash_original_field = "D15F62FC9A8937755EA0BA75161B9A7F", hash_generated_field = "03472463E2EA98D819ECAC54647D9EEB")

    protected static final String LESS_THAN = Separators.LESS_THAN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.723 -0500", hash_original_field = "3D37A32BEC186FF520FFD38791BDF5EF", hash_generated_field = "EADC9D4C7F8A41AC9253B4399DD9CC22")

    protected static final String GREATER_THAN = Separators.GREATER_THAN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.726 -0500", hash_original_field = "DAEDC9E484E5315814F455409686FE3F", hash_generated_field = "94E22BF70767B9E5F90C8BEFB48DFB31")

    protected static final String AT = Separators.AT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.729 -0500", hash_original_field = "09B222C8B655C77BFC9278CC42ED844D", hash_generated_field = "C68E946646D329E00948C391567E8245")

    protected static final String DOT = Separators.DOT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.731 -0500", hash_original_field = "E6FD69D5C38CE5CD44E0697BF8DED97D", hash_generated_field = "C6F6498E0BEB8E9B929D5FF0691C60C5")

    protected static final String QUESTION = Separators.QUESTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.735 -0500", hash_original_field = "6CCD01656CADA37CEC29F4F620E7B103", hash_generated_field = "3931FF01A0452F4B915432DFE1D8342B")

    protected static final String POUND = Separators.POUND;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.737 -0500", hash_original_field = "3BD4DCA47A0CF037479AC0875C12BF09", hash_generated_field = "A7C8E60A9ACCF4FC95E42A6FE3CBE98A")

    protected static final String AND = Separators.AND;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.740 -0500", hash_original_field = "C0F5D3F991B86901594C17F73AE21724", hash_generated_field = "96B1BA6A04896DF507DBF5F6007D53FF")

    protected static final String LPAREN = Separators.LPAREN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.742 -0500", hash_original_field = "EBA28B5ABEF9F9C40189523E5809ACE7", hash_generated_field = "04E1EDA33DBBA7B9CD0B5320DA6E2B15")

    protected static final String RPAREN = Separators.RPAREN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.745 -0500", hash_original_field = "A3D0DB312B6F76C52BC72B77300EB77C", hash_generated_field = "60970C4DF02E2922FFB2BB3FCBF1CC4C")

    protected static final String DOUBLE_QUOTE = Separators.DOUBLE_QUOTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.748 -0500", hash_original_field = "A012C2C89C3BC94350D794BCFAA61AC6", hash_generated_field = "36D2B8942300A11E9A202D488BEEC708")

    protected static final String QUOTE = Separators.QUOTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.750 -0500", hash_original_field = "46C5ABFAF9FA93391F615FBAF29CAF5D", hash_generated_field = "EE0F746E0ADCCF78C293F0BC27A024C1")

    protected static final String HT = Separators.HT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.753 -0500", hash_original_field = "CFBF7772290813FB9E7FE633CE7D8D3B", hash_generated_field = "E525B1F947054DAAB71F0D7018A0312F")

    protected static final String PERCENT = Separators.PERCENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.756 -0500", hash_original_field = "46B4BE6B9B17663D91BE0CBD6FC895ED", hash_generated_field = "23DD3DB933D01AADE0B2C40AA464AC9C")

    protected static final Set<Class<?>> immutableClasses = new HashSet<Class<?>> (10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.758 -0500", hash_original_field = "7F6677E0154CDB5B80D151A3901979D8", hash_generated_field = "06A0F0FA7C3AA2D1A0C9419E5DAE1A94")

    static final String[] immutableClassNames ={
        "String", "Character",
        "Boolean", "Byte", "Short", "Integer", "Long",
        "Float", "Double"
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.760 -0500", hash_original_field = "286452610CAD998336F0009181E4D242", hash_generated_field = "3BB4EF50B1D217FA88F0841635612381")

    protected int indentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.762 -0500", hash_original_field = "D8755CDD7F030BEFEB89CB6F60C5B2A3", hash_generated_field = "9E5739E35654F3700B4DC02E1276C03E")

    protected String stringRepresentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.765 -0500", hash_original_field = "2A1F5BE09411F9A2D63C355A93433EB0", hash_generated_field = "1FBB25CEF289694DDD0EE719A8EBD93D")

    protected Match matchExpression;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.789 -0500", hash_original_method = "26BB6C9083355DA218DE35B50B1395A1", hash_generated_method = "1EDC7F93E170B3C09DA6CE0C48C88764")
    
protected GenericObject() {
        indentation = 0;
        stringRepresentation = "";
    }

    /** Set the  pattern matcher. To match on the
     * field of a sip message, set the match expression in the match template
     * and invoke the match function. This useful because
     * SIP headers and parameters may appear in different orders and are not
     * necessarily in canonical form. This makes it hard to write a pattern
     * matcher that relies on regular expressions alone.
     * Thus we rely on the following  strategy i.e. To do pattern matching on
     * an incoming message, first parse it, and then construct a match template,
     * filling in the fields that you want to
     * match. The rules for matching are: A null object matches wild card -
     * that is a match template of null matches any parsed SIP object.
     * To match with any subfield, set the match template on a template object
     * of the same type and invoke the match interface.
     * Regular expressions matching implements the gov.nist.sip.Match interface
     * that can be done using the Jakarta regexp package for example.
     * package included herein. This can be used to implement the Match interface
     * <a href=http://www.apache.org> See the APACHE website for documents </a>
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.767 -0500", hash_original_method = "D09804B85BA352DF07D45D843F3B447E", hash_generated_method = "2035B4D23EAE70A6A3BFB7E4AD1AF311")
    
public void setMatcher(Match matchExpression) {
        if (matchExpression == null)
            throw new IllegalArgumentException("null arg!");
        this.matchExpression = matchExpression;
    }

    /** Return the match expression.
     *@return the match expression that has previously been set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.770 -0500", hash_original_method = "5F1EBA3A7EC51605C965562331E40E61", hash_generated_method = "2A30BE8BED95C7D68E8EE546CC02F42B")
    
public Match getMatcher() {
        return matchExpression;
    }

    /** Clones this object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.782 -0500", hash_original_method = "2321A1A51988B1008E8A21E8D40DF48D", hash_generated_method = "CC1B934CC7175FE37AA368A3286E9D4F")
    
public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Internal error");
        }
    }
    /**
     * Recursively override the fields of this object with the fields
     * of a new object. This is useful when you want to genrate a template
     * and override the fields of an incoming SIPMessage with another
     * SIP message that you have already generated.
     *
     * @param mergeObject is the replacement object.  The override
     * obect must be of the same class as this object.
     * Set any fields that you do not want to override as null in the
     * mergeOject object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.786 -0500", hash_original_method = "1F4053FE4D1137EC6D445870C27D5323", hash_generated_method = "86DC407EB44562B96E61143973E33085")
    
public void merge(Object mergeObject) {
        // Base case.
        if (mergeObject == null)
            return;

        if (!mergeObject.getClass().equals(this.getClass()))
            throw new IllegalArgumentException("Bad override object");
                        
        Class<?> myclass = this.getClass();
        while (true) {
            Field[] fields = myclass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                int modifier = f.getModifiers();
                if (Modifier.isPrivate(modifier)) {
                    continue;
                } else if (Modifier.isStatic(modifier)) {
                    continue;
                } else if (Modifier.isInterface(modifier)) {
                    continue;
                }
                Class<?> fieldType = f.getType();
                String fname = fieldType.toString();
                try {
                    // Primitive fields are printed with type: value
                    if (fieldType.isPrimitive()) {
                        if (fname.compareTo("int") == 0) {
                            int intfield = f.getInt(mergeObject);
                            f.setInt(this, intfield);
                        } else if (fname.compareTo("short") == 0) {
                            short shortField = f.getShort(mergeObject);
                            f.setShort(this, shortField);
                        } else if (fname.compareTo("char") == 0) {
                            char charField = f.getChar(mergeObject);
                            f.setChar(this, charField);
                        } else if (fname.compareTo("long") == 0) {
                            long longField = f.getLong(mergeObject);
                            f.setLong(this, longField);
                        } else if (fname.compareTo("boolean") == 0) {
                            boolean booleanField = f.getBoolean(mergeObject);
                            f.setBoolean(this, booleanField);
                        } else if (fname.compareTo("double") == 0) {
                            double doubleField = f.getDouble(mergeObject);
                            f.setDouble(this, doubleField);
                        } else if (fname.compareTo("float") == 0) {
                            float floatField = f.getFloat(mergeObject);
                            f.setFloat(this, floatField);
                        }
                    } else {
                        Object obj = f.get(this);
                        Object mobj = f.get(mergeObject);
                        if (mobj == null)
                            continue;
                        if (obj == null) {
                            f.set(this, mobj);
                            continue;
                        }
                        if (obj instanceof GenericObject) {
                            GenericObject gobj = (GenericObject) obj;
                            gobj.merge(mobj);
                        } else {
                            f.set(this, mobj);
                        }
                    }
                } catch (IllegalAccessException ex1) {
                    ex1.printStackTrace();
                    continue; // we are accessing a private field...
                }
            }
            myclass = myclass.getSuperclass();
            if (myclass.equals(GenericObject.class))
                break;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.791 -0500", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "BDD6C135FB07D8AC261FA4D2B4D2AE55")
    
protected String getIndentation() {
    char [] chars = new char [indentation];
    java.util.Arrays.fill (chars, ' ');
    return new String (chars);
    }

    /**
     * Add a new string to the accumulated string representation.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.794 -0500", hash_original_method = "81374D32EA999C5E19458011FA3994BB", hash_generated_method = "6E75796BB452A27E6E1A9C6465DC6B9F")
    
protected void sprint(String a) {
        if (a == null) {
            stringRepresentation += getIndentation();
            stringRepresentation += "<null>\n";
            return;
        }
        if (a.compareTo("}") == 0 || a.compareTo("]") == 0) {
            indentation--;
        }
        stringRepresentation += getIndentation();
        stringRepresentation += a;
        stringRepresentation += "\n";
        if (a.compareTo("{") == 0 || a.compareTo("[") == 0) {
            indentation++;
        }

    }

    /**
     * Pretty printing function accumulator for objects.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.796 -0500", hash_original_method = "453FE126FB96D6280FF2B67B25D884AF", hash_generated_method = "8CA4F8D911584E4411A35AF482C64908")
    
protected void sprint(Object o) {
        sprint(o.toString());
    }

    /**
     * Pretty printing accumulator function for ints
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.799 -0500", hash_original_method = "EF724337BA21340D79134B1646FA7D50", hash_generated_method = "2332956D49AF497FE8FA51B253C97FFC")
    
protected void sprint(int intField) {
        sprint(String.valueOf(intField));
    }

    /**
     * Pretty printing accumulator function for shorts
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.801 -0500", hash_original_method = "8A8752611967BFFBE38D675256F01214", hash_generated_method = "29594FA8A3C6E9165DB16FC4ED689F89")
    
protected void sprint(short shortField) {
        sprint(String.valueOf(shortField));
    }

    /**
     * Pretty printing accumulator function for chars
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.804 -0500", hash_original_method = "B9E7539CD6E988936CBC2F41DE2D2255", hash_generated_method = "5B38337A863313934C1A55AD7975759E")
    
protected void sprint(char charField) {
        sprint(String.valueOf(charField));

    }

    /**
     * Pretty printing accumulator function for longs
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.806 -0500", hash_original_method = "CC6905368951D9D7C183C56D69A53B5E", hash_generated_method = "CAEDC2A91616CEA25C5EA2B2577D48A7")
    
protected void sprint(long longField) {
        sprint(String.valueOf(longField));
    }

    /**
     * Pretty printing accumulator function for booleans
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.808 -0500", hash_original_method = "27E91C5243CD6D4BB691664DB4C3BC19", hash_generated_method = "8791B26AC5CC9846B3D9143CC0A866BB")
    
protected void sprint(boolean booleanField) {
        sprint(String.valueOf(booleanField));
    }

    /**
     * Pretty printing accumulator function for doubles
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.810 -0500", hash_original_method = "A8149AFA8BAA8D148E9A9CE1C6489F0C", hash_generated_method = "89DA97485B69D7DB8DB5557CA17A7984")
    
protected void sprint(double doubleField) {
        sprint(String.valueOf(doubleField));
    }

    /**
     * Pretty printing accumulator function for floats
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.813 -0500", hash_original_method = "96C3F949D4FB0E545745C5388D6DC08E", hash_generated_method = "F589F19994F3A748881B57DF74381FDF")
    
protected void sprint(float floatField) {
        sprint(String.valueOf(floatField));
    }

    /**
     * Debug printing function.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.816 -0500", hash_original_method = "C3665E5B2DC148B3D9AC2D1614738627", hash_generated_method = "DC22718455CD4E87BAD65DB81258DE08")
    
protected void dbgPrint() {
        Debug.println(debugDump());
    }

    /**
     * Debug printing function.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.819 -0500", hash_original_method = "F3C9E7E4BCD0D7ECC989FFC8CBCF37DF", hash_generated_method = "F59F8E3ABDC9B0D727646709B1D5D654")
    
protected void dbgPrint(String s) {
        Debug.println(s);
    }

    /**
     * An introspection based equality predicate for GenericObjects.
     *@param that is the other object to test against.
     *@return true if the objects are euqal and false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.823 -0500", hash_original_method = "B5B25EA3AF1891601BFD267279427EFB", hash_generated_method = "44AC996741CE1A8293D5C87B547ABF0A")
    
public boolean equals(Object that) {
        if ( that == null ) return false;
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
                        return true;
                    else if (f.get(this) == null)
                        return false;
                    else if (g.get(that) == null)
                        return false;
                    else if (g.get(that) == null && f.get(this) != null)
                        return false;
                    else if (!f.get(this).equals(g.get(that)))
                        return false;
                } catch (IllegalAccessException ex1) {
                    InternalErrorHandler.handleException(ex1);
                }
            }
            if (myclass.equals(GenericObject.class))
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
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.827 -0500", hash_original_method = "EA6AD5335EE18CA3C2D0278C0E091AE5", hash_generated_method = "5C2EDB15CA7FDB2D52A071C21F5DC8CB")
    
public boolean match(Object other) {
        if (other == null)
            return true;
        if (!this.getClass().equals(other.getClass()))
            return false;
        GenericObject that = (GenericObject) other;
        Class<?> myclass = this.getClass();
        Field[] fields = myclass.getDeclaredFields();
        Class<?> hisclass = other.getClass();
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
                        if ((((String) hisObj).trim()).equals(""))
                            continue;
                        if (((String) myObj)
                            .compareToIgnoreCase((String) hisObj)
                            != 0)
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
        return true;
    }

    /**
     * Generic print formatting function:
     * Does depth-first descent of the structure and
     * recursively prints all non-private objects pointed to
     * by this object.
     * <bf>
     * Warning - the following generic string routine will
     * bomb (go into infinite loop) if there are any circularly linked
     * structures so if you have these, they had better be private!
     * </bf>
     * We dont have to worry about such things for our structures
     *(we never use circular linked structures).
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.831 -0500", hash_original_method = "9A2585B996B0A77325ECBDA944C7F6EB", hash_generated_method = "DDF6FCE2F5659819DBDB244DBC4187E6")
    
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
            } catch (Exception ex) {
                InternalErrorHandler.handleException(ex);
            }
        }
        sprint("}");
        return stringRepresentation;
    }

    /**
     * Formatter with a given starting indentation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.834 -0500", hash_original_method = "C8764A7C07CF0ED92D22CFD53801BCA7", hash_generated_method = "AF6F4638872E8DBEAB253224E1EC5A56")
    
public String debugDump(int indent) {
        indentation = indent;
        String retval = this.debugDump();
        indentation = 0;
        return retval;
    }

    /**
     *  Get the string encoded version of this object
     * @since v1.0
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.837 -0500", hash_original_method = "62F9CE492238F967486EB3E8B7CFE75A", hash_generated_method = "5BF421C60268DEDED1E2C31D57984D81")
    
public abstract String encode();

    /**
     * Put the encoded version of this object in the given StringBuffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:48.839 -0500", hash_original_method = "23BD5BF1494AAB1936A4882B6C7896EB", hash_generated_method = "E83555D6561D540C12E200451394DEB5")
    
public StringBuffer encode(StringBuffer buffer) {
        return buffer.append(encode());
    }
    static {
        try {
            for (int i = 0; i < immutableClassNames.length; i++)
                immutableClasses.add(Class.forName("java.lang." + immutableClassNames [i]));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException ("Internal error", e);
        }
    }
    
}

