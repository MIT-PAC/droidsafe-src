package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.*;
import java.io.Serializable;
import java.util.*;

public abstract class GenericObject implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.592 -0400", hash_original_field = "449072E30B43D04B744F22522A880818", hash_generated_field = "3BB4EF50B1D217FA88F0841635612381")

    protected int indentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.592 -0400", hash_original_field = "494C9560B4D085454F43F2CC050768A4", hash_generated_field = "9E5739E35654F3700B4DC02E1276C03E")

    protected String stringRepresentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.592 -0400", hash_original_field = "8A586A72E3C2C66C051718676CE8506A", hash_generated_field = "1FBB25CEF289694DDD0EE719A8EBD93D")

    protected Match matchExpression;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.594 -0400", hash_original_method = "26BB6C9083355DA218DE35B50B1395A1", hash_generated_method = "A848942BE08E69D42E88C40CE7E5C52A")
    protected  GenericObject() {
        indentation = 0;
        stringRepresentation = "";
        // ---------- Original Method ----------
        //indentation = 0;
        //stringRepresentation = "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.595 -0400", hash_original_method = "D09804B85BA352DF07D45D843F3B447E", hash_generated_method = "57A2AD46EF223AEB7DBE089F5BAB8113")
    public void setMatcher(Match matchExpression) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null arg!");
        this.matchExpression = matchExpression;
        // ---------- Original Method ----------
        //if (matchExpression == null)
            //throw new IllegalArgumentException("null arg!");
        //this.matchExpression = matchExpression;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.610 -0400", hash_original_method = "5F1EBA3A7EC51605C965562331E40E61", hash_generated_method = "80137F91B56259A9B995B6276AB1BED3")
    public Match getMatcher() {
        Match varB4EAC82CA7396A68D541C85D26508E83_1453308288 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1453308288 = matchExpression;
        varB4EAC82CA7396A68D541C85D26508E83_1453308288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1453308288;
        // ---------- Original Method ----------
        //return matchExpression;
    }

    
        public static Class<?> getClassFromName(String className) {
        try {
            return Class.forName(className);
        } catch (Exception ex) {
            InternalErrorHandler.handleException(ex);
            return null;
        }
    }

    
        public static boolean isMySubclass(Class<?> other) {
        return GenericObject.class.isAssignableFrom(other);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.612 -0400", hash_original_method = "2321A1A51988B1008E8A21E8D40DF48D", hash_generated_method = "2D0091FBC5B84021A0DA46F870DA9377")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_299763339 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_299763339 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Internal error");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_299763339.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_299763339;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new RuntimeException("Internal error");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.618 -0400", hash_original_method = "1F4053FE4D1137EC6D445870C27D5323", hash_generated_method = "B8FB829A519CF0E5E7CB770448AFE924")
    public void merge(Object mergeObject) {
        {
            boolean var8452B1A6FCDC01269CD81C5100106B81_39271773 = (!mergeObject.getClass().equals(this.getClass()));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad override object");
        } //End collapsed parenthetic
        Class<?> myclass;
        myclass = this.getClass();
        {
            Field[] fields;
            fields = myclass.getDeclaredFields();
            {
                int i;
                i = 0;
                {
                    Field f;
                    f = fields[i];
                    int modifier;
                    modifier = f.getModifiers();
                    {
                        boolean var637F279E29C6409424F01E5C0418E3F5_1138592265 = (Modifier.isPrivate(modifier));
                        {
                            boolean var0B58DE5C191622C96155E8901AAFE780_787221413 = (Modifier.isStatic(modifier));
                            {
                                boolean var657457D35C601506E85A319B7FA165CD_2081351303 = (Modifier.isInterface(modifier));
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    Class<?> fieldType;
                    fieldType = f.getType();
                    String fname;
                    fname = fieldType.toString();
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_1694624210 = (fieldType.isPrimitive());
                            {
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_622533907 = (fname.compareTo("int") == 0);
                                    {
                                        int intfield;
                                        intfield = f.getInt(mergeObject);
                                        f.setInt(this, intfield);
                                    } //End block
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_96164538 = (fname.compareTo("short") == 0);
                                        {
                                            short shortField;
                                            shortField = f.getShort(mergeObject);
                                            f.setShort(this, shortField);
                                        } //End block
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_1805363619 = (fname.compareTo("char") == 0);
                                            {
                                                char charField;
                                                charField = f.getChar(mergeObject);
                                                f.setChar(this, charField);
                                            } //End block
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_1120375313 = (fname.compareTo("long") == 0);
                                                {
                                                    long longField;
                                                    longField = f.getLong(mergeObject);
                                                    f.setLong(this, longField);
                                                } //End block
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_200308288 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        boolean booleanField;
                                                        booleanField = f.getBoolean(mergeObject);
                                                        f.setBoolean(this, booleanField);
                                                    } //End block
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_1141496227 = (fname.compareTo("double") == 0);
                                                        {
                                                            double doubleField;
                                                            doubleField = f.getDouble(mergeObject);
                                                            f.setDouble(this, doubleField);
                                                        } //End block
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_2029025646 = (fname.compareTo("float") == 0);
                                                            {
                                                                float floatField;
                                                                floatField = f.getFloat(mergeObject);
                                                                f.setFloat(this, floatField);
                                                            } //End block
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End block
                            {
                                Object obj;
                                obj = f.get(this);
                                Object mobj;
                                mobj = f.get(mergeObject);
                                {
                                    f.set(this, mobj);
                                } //End block
                                {
                                    GenericObject gobj;
                                    gobj = (GenericObject) obj;
                                    gobj.merge(mobj);
                                } //End block
                                {
                                    f.set(this, mobj);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (IllegalAccessException ex1)
                    {
                        ex1.printStackTrace();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            myclass = myclass.getSuperclass();
            {
                boolean varCDC8F41D003E6132167E97CC5CFF7C59_1662386873 = (myclass.equals(GenericObject.class));
            } //End collapsed parenthetic
        } //End block
        addTaint(mergeObject.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.622 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "61A7182010165ECB5C2A7D936B1D3C46")
    protected String getIndentation() {
        String varB4EAC82CA7396A68D541C85D26508E83_1748638752 = null; //Variable for return #1
        char [] chars;
        chars = new char [indentation];
        java.util.Arrays.fill (chars, ' ');
        varB4EAC82CA7396A68D541C85D26508E83_1748638752 = new String (chars);
        varB4EAC82CA7396A68D541C85D26508E83_1748638752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1748638752;
        // ---------- Original Method ----------
        //char [] chars = new char [indentation];
        //java.util.Arrays.fill (chars, ' ');
        //return new String (chars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.622 -0400", hash_original_method = "81374D32EA999C5E19458011FA3994BB", hash_generated_method = "FA4FB32370C1B95C447FBD170E19607D")
    protected void sprint(String a) {
        {
            stringRepresentation += getIndentation();
            stringRepresentation += "<null>\n";
        } //End block
        {
            boolean varD8E1029F8F5CABA6ABE68CE554DCCDBF_2033396730 = (a.compareTo("}") == 0 || a.compareTo("]") == 0);
        } //End collapsed parenthetic
        stringRepresentation += getIndentation();
        stringRepresentation += a;
        stringRepresentation += "\n";
        {
            boolean varE6EEF37B8568997438402983081D59AC_1040006612 = (a.compareTo("{") == 0 || a.compareTo("[") == 0);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (a == null) {
            //stringRepresentation += getIndentation();
            //stringRepresentation += "<null>\n";
            //return;
        //}
        //if (a.compareTo("}") == 0 || a.compareTo("]") == 0) {
            //indentation--;
        //}
        //stringRepresentation += getIndentation();
        //stringRepresentation += a;
        //stringRepresentation += "\n";
        //if (a.compareTo("{") == 0 || a.compareTo("[") == 0) {
            //indentation++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.630 -0400", hash_original_method = "453FE126FB96D6280FF2B67B25D884AF", hash_generated_method = "8CA9596929A8EE5CFF63128AAD234BDC")
    protected void sprint(Object o) {
        sprint(o.toString());
        addTaint(o.getTaint());
        // ---------- Original Method ----------
        //sprint(o.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.630 -0400", hash_original_method = "EF724337BA21340D79134B1646FA7D50", hash_generated_method = "8E360E95F1B4B5C0877EEC3072FB39C0")
    protected void sprint(int intField) {
        sprint(String.valueOf(intField));
        addTaint(intField);
        // ---------- Original Method ----------
        //sprint(String.valueOf(intField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.630 -0400", hash_original_method = "8A8752611967BFFBE38D675256F01214", hash_generated_method = "09D4B99977BCEAD6319C2E54316C8BDD")
    protected void sprint(short shortField) {
        sprint(String.valueOf(shortField));
        addTaint(shortField);
        // ---------- Original Method ----------
        //sprint(String.valueOf(shortField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.631 -0400", hash_original_method = "B9E7539CD6E988936CBC2F41DE2D2255", hash_generated_method = "BBDCAB22F56BA386B0B86E0A2C72F59E")
    protected void sprint(char charField) {
        sprint(String.valueOf(charField));
        addTaint(charField);
        // ---------- Original Method ----------
        //sprint(String.valueOf(charField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.631 -0400", hash_original_method = "CC6905368951D9D7C183C56D69A53B5E", hash_generated_method = "F710AFBEDA2E0EB486D57E30E6C88DAC")
    protected void sprint(long longField) {
        sprint(String.valueOf(longField));
        addTaint(longField);
        // ---------- Original Method ----------
        //sprint(String.valueOf(longField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.631 -0400", hash_original_method = "27E91C5243CD6D4BB691664DB4C3BC19", hash_generated_method = "25FD161C5C5B5E281901EF862B19D028")
    protected void sprint(boolean booleanField) {
        sprint(String.valueOf(booleanField));
        addTaint(booleanField);
        // ---------- Original Method ----------
        //sprint(String.valueOf(booleanField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.632 -0400", hash_original_method = "A8149AFA8BAA8D148E9A9CE1C6489F0C", hash_generated_method = "E1A33565E4EF7C7DF46C2E9821C3F617")
    protected void sprint(double doubleField) {
        sprint(String.valueOf(doubleField));
        addTaint(doubleField);
        // ---------- Original Method ----------
        //sprint(String.valueOf(doubleField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.636 -0400", hash_original_method = "96C3F949D4FB0E545745C5388D6DC08E", hash_generated_method = "2543DE845676E10E7861789E8679BB8B")
    protected void sprint(float floatField) {
        sprint(String.valueOf(floatField));
        addTaint(floatField);
        // ---------- Original Method ----------
        //sprint(String.valueOf(floatField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.636 -0400", hash_original_method = "C3665E5B2DC148B3D9AC2D1614738627", hash_generated_method = "CC9960C463BA8ADB2C2953D0609F3E40")
    protected void dbgPrint() {
        Debug.println(debugDump());
        // ---------- Original Method ----------
        //Debug.println(debugDump());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.636 -0400", hash_original_method = "F3C9E7E4BCD0D7ECC989FFC8CBCF37DF", hash_generated_method = "B30B6C8F631154417A4BD3A53EBA3870")
    protected void dbgPrint(String s) {
        Debug.println(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Debug.println(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.644 -0400", hash_original_method = "B5B25EA3AF1891601BFD267279427EFB", hash_generated_method = "B388D191501CD7844446DF035A3E9A53")
    public boolean equals(Object that) {
        {
            boolean var07F02797FD62DC585D5DCA22B5D2ED2C_1330222120 = (!this.getClass().equals(that.getClass()));
        } //End collapsed parenthetic
        Class<?> myclass;
        myclass = this.getClass();
        Class<?> hisclass;
        hisclass = that.getClass();
        {
            Field[] fields;
            fields = myclass.getDeclaredFields();
            Field[] hisfields;
            hisfields = hisclass.getDeclaredFields();
            {
                int i;
                i = 0;
                {
                    Field f;
                    f = fields[i];
                    Field g;
                    g = hisfields[i];
                    int modifier;
                    modifier = f.getModifiers();
                    Class<?> fieldType;
                    fieldType = f.getType();
                    String fieldName;
                    fieldName = f.getName();
                    {
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_319365447 = (fieldName.compareTo("stringRepresentation") == 0);
                    } //End collapsed parenthetic
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_1837631058 = (fieldName.compareTo("indentation") == 0);
                    } //End collapsed parenthetic
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_742258896 = (fieldType.isPrimitive());
                            {
                                String fname;
                                fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_608663469 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_777045891 = (f.getInt(this) != g.getInt(that));
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_427438575 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_1935434811 = (f.getShort(this) != g.getShort(that));
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_1642324970 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_1121029050 = (f.getChar(this) != g.getChar(that));
                                                } //End collapsed parenthetic
                                            } //End block
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_1825923553 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_332056505 = (f.getLong(this) != g.getLong(that));
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_1320777526 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_954902823 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_1500794867 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_356776237 = (f.getDouble(this) != g.getDouble(that));
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_1009066796 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_898008597 = (f.getFloat(this) != g.getFloat(that));
                                                                } //End collapsed parenthetic
                                                            } //End block
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean varAA8F4E7F9752016DF7A866D138AF57F2_2049905104 = (g.get(that) == f.get(this));
                                {
                                    boolean varD397365BE62D10D7E011B256F8B6D455_1806353182 = (f.get(this) == null);
                                    {
                                        boolean var207751DCCBECC5B08EAE9BEAF3ED0EA6_964894941 = (g.get(that) == null);
                                        {
                                            boolean var0EABF098CA8E2696A8304A37E0D2F9C1_1417214863 = (g.get(that) == null && f.get(this) != null);
                                            {
                                                boolean varE99CF41FD22D6AE43C5A320D0ADAFDF4_1880362694 = (!f.get(this).equals(g.get(that)));
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    catch (IllegalAccessException ex1)
                    {
                        InternalErrorHandler.handleException(ex1);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean varCDC8F41D003E6132167E97CC5CFF7C59_772733252 = (myclass.equals(GenericObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302172601 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_302172601;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.663 -0400", hash_original_method = "EA6AD5335EE18CA3C2D0278C0E091AE5", hash_generated_method = "E290499C8BFF692A0EBE1E3C0D0B74D5")
    public boolean match(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_618472314 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        GenericObject that;
        that = (GenericObject) other;
        Class<?> myclass;
        myclass = this.getClass();
        Field[] fields;
        fields = myclass.getDeclaredFields();
        Class<?> hisclass;
        hisclass = other.getClass();
        Field[] hisfields;
        hisfields = hisclass.getDeclaredFields();
        {
            int i;
            i = 0;
            {
                Field f;
                f = fields[i];
                Field g;
                g = hisfields[i];
                int modifier;
                modifier = f.getModifiers();
                Class<?> fieldType;
                fieldType = f.getType();
                String fieldName;
                fieldName = f.getName();
                {
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_1877733940 = (fieldName.compareTo("stringRepresentation") == 0);
                } //End collapsed parenthetic
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_2056067275 = (fieldName.compareTo("indentation") == 0);
                } //End collapsed parenthetic
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_348004726 = (fieldType.isPrimitive());
                        {
                            String fname;
                            fname = fieldType.toString();
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_1218646149 = (fname.compareTo("int") == 0);
                                {
                                    {
                                        boolean var4CA69663022635DA9D4B226B8EFD063A_1991073850 = (f.getInt(this) != g.getInt(that));
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean varECBE882B00F953257800779B015A044A_431322840 = (fname.compareTo("short") == 0);
                                    {
                                        {
                                            boolean var1818C0AE349B8E9B94D12F42F9192D27_194635654 = (f.getShort(this) != g.getShort(that));
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_2116137037 = (fname.compareTo("char") == 0);
                                        {
                                            {
                                                boolean varA9225C0F38F0CE651E5840717A73CB98_664562182 = (f.getChar(this) != g.getChar(that));
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_558527737 = (fname.compareTo("long") == 0);
                                            {
                                                {
                                                    boolean var682FCF417B627E8F7623C28A936CE964_478929827 = (f.getLong(this) != g.getLong(that));
                                                } //End collapsed parenthetic
                                            } //End block
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_1080379143 = (fname.compareTo("boolean") == 0);
                                                {
                                                    {
                                                        boolean var6B4A94D318FFDC583C00F3E90D7F247E_378412141 = (f.getBoolean(this) != g.getBoolean(that));
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_30988311 = (fname.compareTo("double") == 0);
                                                    {
                                                        {
                                                            boolean var8407698AFEB885A11314D630BB9E8490_3484753 = (f.getDouble(this) != g.getDouble(that));
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_536608958 = (fname.compareTo("float") == 0);
                                                        {
                                                            {
                                                                boolean varBBC04007B7E490847AA4F63B58E5D60D_512850928 = (f.getFloat(this) != g.getFloat(that));
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                        {
                            Object myObj;
                            myObj = f.get(this);
                            Object hisObj;
                            hisObj = g.get(that);
                            {
                                {
                                    boolean var32FB3616EAA55BEC408E0E48EF8F9199_1855794174 = ((((String) hisObj).trim()).equals(""));
                                } //End collapsed parenthetic
                                {
                                    boolean varD3C11AAADBE52EF7B0D1EB153FA4D292_635466174 = (((String) myObj)
                            .compareToIgnoreCase((String) hisObj)
                            != 0);
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var4C97BE25056F5D73A11941653F4F33DF_414344674 = (GenericObject.isMySubclass(myObj.getClass())
                            && !((GenericObject) myObj).match(hisObj));
                                {
                                    boolean varD91F7FE40B718120DD724990CF9E578C_391201790 = (GenericObjectList.isMySubclass(myObj.getClass())
                            && !((GenericObjectList) myObj).match(hisObj));
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (IllegalAccessException ex1)
                {
                    InternalErrorHandler.handleException(ex1);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2019312382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2019312382;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.667 -0400", hash_original_method = "9A2585B996B0A77325ECBDA944C7F6EB", hash_generated_method = "21D9D0804C2CEFE133C4A15316AA8A0B")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_1870359744 = null; //Variable for return #1
        stringRepresentation = "";
        Class<?> myclass;
        myclass = getClass();
        sprint(myclass.getName());
        sprint("{");
        Field[] fields;
        fields = myclass.getDeclaredFields();
        {
            int i;
            i = 0;
            {
                Field f;
                f = fields[i];
                int modifier;
                modifier = f.getModifiers();
                Class<?> fieldType;
                fieldType = f.getType();
                String fieldName;
                fieldName = f.getName();
                {
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_1803397335 = (fieldName.compareTo("stringRepresentation") == 0);
                } //End collapsed parenthetic
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_115837657 = (fieldName.compareTo("indentation") == 0);
                } //End collapsed parenthetic
                sprint(fieldName + ":");
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_528654135 = (fieldType.isPrimitive());
                        {
                            String fname;
                            fname = fieldType.toString();
                            sprint(fname + ":");
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_828585731 = (fname.compareTo("int") == 0);
                                {
                                    int intfield;
                                    intfield = f.getInt(this);
                                    sprint(intfield);
                                } //End block
                                {
                                    boolean varECBE882B00F953257800779B015A044A_1705076539 = (fname.compareTo("short") == 0);
                                    {
                                        short shortField;
                                        shortField = f.getShort(this);
                                        sprint(shortField);
                                    } //End block
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_1113057179 = (fname.compareTo("char") == 0);
                                        {
                                            char charField;
                                            charField = f.getChar(this);
                                            sprint(charField);
                                        } //End block
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_232655941 = (fname.compareTo("long") == 0);
                                            {
                                                long longField;
                                                longField = f.getLong(this);
                                                sprint(longField);
                                            } //End block
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_736243554 = (fname.compareTo("boolean") == 0);
                                                {
                                                    boolean booleanField;
                                                    booleanField = f.getBoolean(this);
                                                    sprint(booleanField);
                                                } //End block
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_1903434999 = (fname.compareTo("double") == 0);
                                                    {
                                                        double doubleField;
                                                        doubleField = f.getDouble(this);
                                                        sprint(doubleField);
                                                    } //End block
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_1521608636 = (fname.compareTo("float") == 0);
                                                        {
                                                            float floatField;
                                                            floatField = f.getFloat(this);
                                                            sprint(floatField);
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varD5A8092938B037D2C43A6EAD0E6B9173_1553270619 = (GenericObject.class.isAssignableFrom(fieldType));
                            {
                                {
                                    boolean varFF6BA6C3E22248032CA1E2ADDB055F70_2021619777 = (f.get(this) != null);
                                    {
                                        sprint(
                            ((GenericObject) f.get(this)).debugDump(
                                indentation + 1));
                                    } //End block
                                    {
                                        sprint("<null>");
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var3D135DF8A6804404B214F5224E4565F6_638252532 = (GenericObjectList.class.isAssignableFrom(fieldType));
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1535309338 = (f.get(this) != null);
                                        {
                                            sprint(
                            ((GenericObjectList) f.get(this)).debugDump(
                                indentation + 1));
                                        } //End block
                                        {
                                            sprint("<null>");
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1309970894 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).getClass().getName() + ":");
                                        } //End block
                                        {
                                            sprint(fieldType.getName() + ":");
                                        } //End block
                                    } //End collapsed parenthetic
                                    sprint("{");
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1231247925 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).toString());
                                        } //End block
                                        {
                                            sprint("<null>");
                                        } //End block
                                    } //End collapsed parenthetic
                                    sprint("}");
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                catch (IllegalAccessException ex1)
                { }
                catch (Exception ex)
                {
                    InternalErrorHandler.handleException(ex);
                } //End block
            } //End block
        } //End collapsed parenthetic
        sprint("}");
        varB4EAC82CA7396A68D541C85D26508E83_1870359744 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_1870359744.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1870359744;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.679 -0400", hash_original_method = "C8764A7C07CF0ED92D22CFD53801BCA7", hash_generated_method = "248E229A897919490F29E94A8B35C3CF")
    public String debugDump(int indent) {
        String varB4EAC82CA7396A68D541C85D26508E83_1499644581 = null; //Variable for return #1
        indentation = indent;
        String retval;
        retval = this.debugDump();
        indentation = 0;
        varB4EAC82CA7396A68D541C85D26508E83_1499644581 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1499644581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1499644581;
        // ---------- Original Method ----------
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = 0;
        //return retval;
    }

    
    public abstract String encode();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.687 -0400", hash_original_method = "23BD5BF1494AAB1936A4882B6C7896EB", hash_generated_method = "D6AD81A81AFADFB58078552772C228F5")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1599800064 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1599800064 = buffer.append(encode());
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1599800064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1599800064;
        // ---------- Original Method ----------
        //return buffer.append(encode());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.687 -0400", hash_original_field = "D1190824E35A683C05589F1C776EEB98", hash_generated_field = "4B8890FBD872BF70D8F8C7F44DA52EF3")

    protected static String SEMICOLON = Separators.SEMICOLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.687 -0400", hash_original_field = "02A534AF21A6F783F08D86D26579E890", hash_generated_field = "5BBD6AD412C5B75598187A2486B26E8A")

    protected static String COLON = Separators.COLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.687 -0400", hash_original_field = "6C852D8F8039F1F9747489612DAC3C3C", hash_generated_field = "785D4BB980AC2C0D57607CEF4CACF0C0")

    protected static String COMMA = Separators.COMMA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.687 -0400", hash_original_field = "04C5392343613D1101130F746A81D0F3", hash_generated_field = "966CA9FD4E3DF03CAB57666E2072AC14")

    protected static String SLASH = Separators.SLASH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.687 -0400", hash_original_field = "D8EE4E7D0F1EAB2E2745753B5AD2FE8D", hash_generated_field = "A402605784E67C68F1024E7173E45B1B")

    protected static String SP = Separators.SP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.687 -0400", hash_original_field = "3C7C6B82B012EBDA39975B1F72983C28", hash_generated_field = "1544A19534612AF3A94C823834760C09")

    protected static String EQUALS = Separators.EQUALS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.687 -0400", hash_original_field = "B9D394806A580E8DE8984E11AC02BDE2", hash_generated_field = "DBB60C4C8B4DF7C5BCBF7A183A799ACB")

    protected static String STAR = Separators.STAR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.688 -0400", hash_original_field = "4B65D6BACAFDD7AB302810256C42CCB9", hash_generated_field = "29424A3535D892C1F61E917DF2BD1016")

    protected static String NEWLINE = Separators.NEWLINE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.688 -0400", hash_original_field = "4E25B108371C30F889E1B6E8C1046FAB", hash_generated_field = "2C3A924D81FD472B8F727FE6FF2FF522")

    protected static String RETURN = Separators.RETURN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.688 -0400", hash_original_field = "7E16A38DE053150CC3BF00FEBC32CBB3", hash_generated_field = "C71AA757DB9E1D524F2CD1751C3280BC")

    protected static String LESS_THAN = Separators.LESS_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.688 -0400", hash_original_field = "CBC3FB6A2E3BC245B189168F8F698149", hash_generated_field = "2370BD505EDC4CD3493015CD0065760D")

    protected static String GREATER_THAN = Separators.GREATER_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.688 -0400", hash_original_field = "72EE65D27F762C3B2FB94C3FA334B5E4", hash_generated_field = "0FBF28DB29147F4018595211B916920D")

    protected static String AT = Separators.AT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.689 -0400", hash_original_field = "3ACE38B8B42CCCDC519BBD9065EB1D1A", hash_generated_field = "3025CBFFD153EFAB9AE6AACDA714FF72")

    protected static String DOT = Separators.DOT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.689 -0400", hash_original_field = "B2A15792014FB9077E86DD721A8EFBA4", hash_generated_field = "D7A90F6E7785E12E4DFF4AC1D1D8875A")

    protected static String QUESTION = Separators.QUESTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.689 -0400", hash_original_field = "096D0F7D4D4C7B4283D714ECD7F549C3", hash_generated_field = "84D39FE9CC6EA2F087DAFCAAD5A16707")

    protected static String POUND = Separators.POUND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.691 -0400", hash_original_field = "705C7DB0DE742246702AC85CCAA66A2B", hash_generated_field = "2FB9D6B5E4755F98893B3E3F410DFDEE")

    protected static String AND = Separators.AND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.691 -0400", hash_original_field = "B7554C14B11FFE96B375109E44C62935", hash_generated_field = "3212B3E63C9FC51A4D07C7EC73385FF4")

    protected static String LPAREN = Separators.LPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.691 -0400", hash_original_field = "ED8913C274C5CDFEFC62F7A7FE2688CB", hash_generated_field = "EEE245D25868C238D5ADCC7FE3AC60BB")

    protected static String RPAREN = Separators.RPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.691 -0400", hash_original_field = "CD4D1E68FDC871F3D1A212D438F276AF", hash_generated_field = "3601DBFC2F02C2359E6881574222AEA7")

    protected static String DOUBLE_QUOTE = Separators.DOUBLE_QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.691 -0400", hash_original_field = "1084586CDB13332FA26836F7CE2B3817", hash_generated_field = "9467DA16C509432ABB454D6BF78F198A")

    protected static String QUOTE = Separators.QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.691 -0400", hash_original_field = "58E3D5E258B17E5D6D1BDF83FE976FD6", hash_generated_field = "254F51181EE51F41E8F8B36EA27FC73D")

    protected static String HT = Separators.HT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.691 -0400", hash_original_field = "4AEF06B345694E240504FA11CF16C815", hash_generated_field = "3E81D01A700B23F69979D20F8CEE223A")

    protected static String PERCENT = Separators.PERCENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.691 -0400", hash_original_field = "6796B59570731F7B6F84E1F281186777", hash_generated_field = "5EF1786CF984AC1DBD4F2C7F0901DBB2")

    protected static Set<Class<?>> immutableClasses = new HashSet<Class<?>> (10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.691 -0400", hash_original_field = "0903587AC197526F6DF5345E92DCF834", hash_generated_field = "64F13EC28D0C17D6C7C1489E4E90366A")

    static String[] immutableClassNames = ;
    static {
        try {
            for (int i = 0; i < immutableClassNames.length; i++)
                immutableClasses.add(Class.forName("java.lang." + immutableClassNames [i]));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException ("Internal error", e);
        }
    }
    
}

