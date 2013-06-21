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
    protected int indentation;
    protected String stringRepresentation;
    protected Match matchExpression;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.539 -0400", hash_original_method = "26BB6C9083355DA218DE35B50B1395A1", hash_generated_method = "A848942BE08E69D42E88C40CE7E5C52A")
    @DSModeled(DSC.SAFE)
    protected GenericObject() {
        indentation = 0;
        stringRepresentation = "";
        // ---------- Original Method ----------
        //indentation = 0;
        //stringRepresentation = "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.539 -0400", hash_original_method = "D09804B85BA352DF07D45D843F3B447E", hash_generated_method = "F92F6BD77DCDB90E1802FB01E02B3810")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMatcher(Match matchExpression) {
        dsTaint.addTaint(matchExpression.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null arg!");
        // ---------- Original Method ----------
        //if (matchExpression == null)
            //throw new IllegalArgumentException("null arg!");
        //this.matchExpression = matchExpression;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.539 -0400", hash_original_method = "5F1EBA3A7EC51605C965562331E40E61", hash_generated_method = "9DB5596F3829F8AB3E081DC52CC4D04C")
    @DSModeled(DSC.SAFE)
    public Match getMatcher() {
        return (Match)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.540 -0400", hash_original_method = "2321A1A51988B1008E8A21E8D40DF48D", hash_generated_method = "B897A4CA1FE08F1EEBF33A4D455F5151")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_427278766 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Internal error");
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new RuntimeException("Internal error");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.541 -0400", hash_original_method = "1F4053FE4D1137EC6D445870C27D5323", hash_generated_method = "5537B9A0BC3ABC660CEC589E2555E322")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void merge(Object mergeObject) {
        dsTaint.addTaint(mergeObject.dsTaint);
        {
            boolean var8452B1A6FCDC01269CD81C5100106B81_546643566 = (!mergeObject.getClass().equals(this.getClass()));
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
                        boolean var637F279E29C6409424F01E5C0418E3F5_1088697398 = (Modifier.isPrivate(modifier));
                        {
                            boolean var0B58DE5C191622C96155E8901AAFE780_835173212 = (Modifier.isStatic(modifier));
                            {
                                boolean var657457D35C601506E85A319B7FA165CD_1332603511 = (Modifier.isInterface(modifier));
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
                            boolean varA02EA4574D838DD5C519F1195763C1D8_94111694 = (fieldType.isPrimitive());
                            {
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_1126384155 = (fname.compareTo("int") == 0);
                                    {
                                        int intfield;
                                        intfield = f.getInt(mergeObject);
                                        f.setInt(this, intfield);
                                    } //End block
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_696883471 = (fname.compareTo("short") == 0);
                                        {
                                            short shortField;
                                            shortField = f.getShort(mergeObject);
                                            f.setShort(this, shortField);
                                        } //End block
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_288363078 = (fname.compareTo("char") == 0);
                                            {
                                                char charField;
                                                charField = f.getChar(mergeObject);
                                                f.setChar(this, charField);
                                            } //End block
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_2008345968 = (fname.compareTo("long") == 0);
                                                {
                                                    long longField;
                                                    longField = f.getLong(mergeObject);
                                                    f.setLong(this, longField);
                                                } //End block
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_475553152 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        boolean booleanField;
                                                        booleanField = f.getBoolean(mergeObject);
                                                        f.setBoolean(this, booleanField);
                                                    } //End block
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_1395603471 = (fname.compareTo("double") == 0);
                                                        {
                                                            double doubleField;
                                                            doubleField = f.getDouble(mergeObject);
                                                            f.setDouble(this, doubleField);
                                                        } //End block
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_1594182302 = (fname.compareTo("float") == 0);
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
                boolean varCDC8F41D003E6132167E97CC5CFF7C59_1676258330 = (myclass.equals(GenericObject.class));
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.541 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "F0E7D8491F23CEAF1414472C082DE12E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String getIndentation() {
        char [] chars;
        chars = new char [indentation];
        java.util.Arrays.fill (chars, ' ');
        String var66EDFC1FC307F5C5EB2C8341F6F60CC3_491482045 = (new String (chars));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //char [] chars = new char [indentation];
        //java.util.Arrays.fill (chars, ' ');
        //return new String (chars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.541 -0400", hash_original_method = "81374D32EA999C5E19458011FA3994BB", hash_generated_method = "EAA85029F6BF2164A3398C88CE8189CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sprint(String a) {
        dsTaint.addTaint(a);
        {
            stringRepresentation += getIndentation();
            stringRepresentation += "<null>\n";
        } //End block
        {
            boolean varD8E1029F8F5CABA6ABE68CE554DCCDBF_557616953 = (a.compareTo("}") == 0 || a.compareTo("]") == 0);
        } //End collapsed parenthetic
        stringRepresentation += getIndentation();
        stringRepresentation += "\n";
        {
            boolean varE6EEF37B8568997438402983081D59AC_1021865199 = (a.compareTo("{") == 0 || a.compareTo("[") == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.542 -0400", hash_original_method = "453FE126FB96D6280FF2B67B25D884AF", hash_generated_method = "2E3FFA6B4AE2C9C1EA50B38AD131E0D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sprint(Object o) {
        dsTaint.addTaint(o.dsTaint);
        sprint(o.toString());
        // ---------- Original Method ----------
        //sprint(o.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.542 -0400", hash_original_method = "EF724337BA21340D79134B1646FA7D50", hash_generated_method = "E9B5C9FE793DF754BE9EA374B89720CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sprint(int intField) {
        dsTaint.addTaint(intField);
        sprint(String.valueOf(intField));
        // ---------- Original Method ----------
        //sprint(String.valueOf(intField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.542 -0400", hash_original_method = "8A8752611967BFFBE38D675256F01214", hash_generated_method = "956E76E68CB40046FC823E4320465F7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sprint(short shortField) {
        dsTaint.addTaint(shortField);
        sprint(String.valueOf(shortField));
        // ---------- Original Method ----------
        //sprint(String.valueOf(shortField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.542 -0400", hash_original_method = "B9E7539CD6E988936CBC2F41DE2D2255", hash_generated_method = "0B01810D55D15AD48E8DC1BBF52C1997")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sprint(char charField) {
        dsTaint.addTaint(charField);
        sprint(String.valueOf(charField));
        // ---------- Original Method ----------
        //sprint(String.valueOf(charField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.542 -0400", hash_original_method = "CC6905368951D9D7C183C56D69A53B5E", hash_generated_method = "23E17DFF8E388DC0512992489C28D7D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sprint(long longField) {
        dsTaint.addTaint(longField);
        sprint(String.valueOf(longField));
        // ---------- Original Method ----------
        //sprint(String.valueOf(longField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.543 -0400", hash_original_method = "27E91C5243CD6D4BB691664DB4C3BC19", hash_generated_method = "1C572C7C6E0275A0FF773D380CCECB88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sprint(boolean booleanField) {
        dsTaint.addTaint(booleanField);
        sprint(String.valueOf(booleanField));
        // ---------- Original Method ----------
        //sprint(String.valueOf(booleanField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.543 -0400", hash_original_method = "A8149AFA8BAA8D148E9A9CE1C6489F0C", hash_generated_method = "D2550997A9DF3E203784FE2C7EEABD58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sprint(double doubleField) {
        dsTaint.addTaint(doubleField);
        sprint(String.valueOf(doubleField));
        // ---------- Original Method ----------
        //sprint(String.valueOf(doubleField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.543 -0400", hash_original_method = "96C3F949D4FB0E545745C5388D6DC08E", hash_generated_method = "45215F7B79A93A4A45199847C4CE060A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sprint(float floatField) {
        dsTaint.addTaint(floatField);
        sprint(String.valueOf(floatField));
        // ---------- Original Method ----------
        //sprint(String.valueOf(floatField));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.543 -0400", hash_original_method = "C3665E5B2DC148B3D9AC2D1614738627", hash_generated_method = "CC9960C463BA8ADB2C2953D0609F3E40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dbgPrint() {
        Debug.println(debugDump());
        // ---------- Original Method ----------
        //Debug.println(debugDump());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.543 -0400", hash_original_method = "F3C9E7E4BCD0D7ECC989FFC8CBCF37DF", hash_generated_method = "442D5553EDCFBA6C08A86F7F19F8F7BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dbgPrint(String s) {
        dsTaint.addTaint(s);
        Debug.println(s);
        // ---------- Original Method ----------
        //Debug.println(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.545 -0400", hash_original_method = "B5B25EA3AF1891601BFD267279427EFB", hash_generated_method = "909A5E1DA0EF78A9FAF03248AE75BCBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object that) {
        dsTaint.addTaint(that.dsTaint);
        {
            boolean var07F02797FD62DC585D5DCA22B5D2ED2C_1327040124 = (!this.getClass().equals(that.getClass()));
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
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_1915329389 = (fieldName.compareTo("stringRepresentation") == 0);
                    } //End collapsed parenthetic
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_380384727 = (fieldName.compareTo("indentation") == 0);
                    } //End collapsed parenthetic
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_1577871316 = (fieldType.isPrimitive());
                            {
                                String fname;
                                fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_12756805 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_1193930002 = (f.getInt(this) != g.getInt(that));
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_1321090359 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_141144444 = (f.getShort(this) != g.getShort(that));
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_364415945 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_1823660846 = (f.getChar(this) != g.getChar(that));
                                                } //End collapsed parenthetic
                                            } //End block
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_791818707 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_736998021 = (f.getLong(this) != g.getLong(that));
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_830617417 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_1227935235 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_573054061 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_1046333190 = (f.getDouble(this) != g.getDouble(that));
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_1852440401 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_1894607223 = (f.getFloat(this) != g.getFloat(that));
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
                                boolean varAA8F4E7F9752016DF7A866D138AF57F2_1818031345 = (g.get(that) == f.get(this));
                                {
                                    boolean varD397365BE62D10D7E011B256F8B6D455_508247131 = (f.get(this) == null);
                                    {
                                        boolean var207751DCCBECC5B08EAE9BEAF3ED0EA6_1525168737 = (g.get(that) == null);
                                        {
                                            boolean var0EABF098CA8E2696A8304A37E0D2F9C1_1582545539 = (g.get(that) == null && f.get(this) != null);
                                            {
                                                boolean varE99CF41FD22D6AE43C5A320D0ADAFDF4_1398055762 = (!f.get(this).equals(g.get(that)));
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
                boolean varCDC8F41D003E6132167E97CC5CFF7C59_1737061082 = (myclass.equals(GenericObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.546 -0400", hash_original_method = "EA6AD5335EE18CA3C2D0278C0E091AE5", hash_generated_method = "C95751B5715B51A46B78FCE2DAC4A2B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_733989681 = (!this.getClass().equals(other.getClass()));
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
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_531986774 = (fieldName.compareTo("stringRepresentation") == 0);
                } //End collapsed parenthetic
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_2065808146 = (fieldName.compareTo("indentation") == 0);
                } //End collapsed parenthetic
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_509134549 = (fieldType.isPrimitive());
                        {
                            String fname;
                            fname = fieldType.toString();
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_587395093 = (fname.compareTo("int") == 0);
                                {
                                    {
                                        boolean var4CA69663022635DA9D4B226B8EFD063A_780389767 = (f.getInt(this) != g.getInt(that));
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean varECBE882B00F953257800779B015A044A_961480458 = (fname.compareTo("short") == 0);
                                    {
                                        {
                                            boolean var1818C0AE349B8E9B94D12F42F9192D27_1661943319 = (f.getShort(this) != g.getShort(that));
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_1211821923 = (fname.compareTo("char") == 0);
                                        {
                                            {
                                                boolean varA9225C0F38F0CE651E5840717A73CB98_1305611004 = (f.getChar(this) != g.getChar(that));
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_1580700875 = (fname.compareTo("long") == 0);
                                            {
                                                {
                                                    boolean var682FCF417B627E8F7623C28A936CE964_1729701184 = (f.getLong(this) != g.getLong(that));
                                                } //End collapsed parenthetic
                                            } //End block
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_1970595607 = (fname.compareTo("boolean") == 0);
                                                {
                                                    {
                                                        boolean var6B4A94D318FFDC583C00F3E90D7F247E_1991159674 = (f.getBoolean(this) != g.getBoolean(that));
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_1744869256 = (fname.compareTo("double") == 0);
                                                    {
                                                        {
                                                            boolean var8407698AFEB885A11314D630BB9E8490_1562518450 = (f.getDouble(this) != g.getDouble(that));
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_318248430 = (fname.compareTo("float") == 0);
                                                        {
                                                            {
                                                                boolean varBBC04007B7E490847AA4F63B58E5D60D_1140334828 = (f.getFloat(this) != g.getFloat(that));
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
                                    boolean var32FB3616EAA55BEC408E0E48EF8F9199_843627079 = ((((String) hisObj).trim()).equals(""));
                                } //End collapsed parenthetic
                                {
                                    boolean varD3C11AAADBE52EF7B0D1EB153FA4D292_1648131757 = (((String) myObj)
                            .compareToIgnoreCase((String) hisObj)
                            != 0);
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var4C97BE25056F5D73A11941653F4F33DF_1726494591 = (GenericObject.isMySubclass(myObj.getClass())
                            && !((GenericObject) myObj).match(hisObj));
                                {
                                    boolean varD91F7FE40B718120DD724990CF9E578C_201252005 = (GenericObjectList.isMySubclass(myObj.getClass())
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.547 -0400", hash_original_method = "9A2585B996B0A77325ECBDA944C7F6EB", hash_generated_method = "958F05703C1D5ABF0E97828037030036")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump() {
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
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_1214123960 = (fieldName.compareTo("stringRepresentation") == 0);
                } //End collapsed parenthetic
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_1390327500 = (fieldName.compareTo("indentation") == 0);
                } //End collapsed parenthetic
                sprint(fieldName + ":");
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_1179881404 = (fieldType.isPrimitive());
                        {
                            String fname;
                            fname = fieldType.toString();
                            sprint(fname + ":");
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_1677631587 = (fname.compareTo("int") == 0);
                                {
                                    int intfield;
                                    intfield = f.getInt(this);
                                    sprint(intfield);
                                } //End block
                                {
                                    boolean varECBE882B00F953257800779B015A044A_206885742 = (fname.compareTo("short") == 0);
                                    {
                                        short shortField;
                                        shortField = f.getShort(this);
                                        sprint(shortField);
                                    } //End block
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_1216554027 = (fname.compareTo("char") == 0);
                                        {
                                            char charField;
                                            charField = f.getChar(this);
                                            sprint(charField);
                                        } //End block
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_599671933 = (fname.compareTo("long") == 0);
                                            {
                                                long longField;
                                                longField = f.getLong(this);
                                                sprint(longField);
                                            } //End block
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_102565543 = (fname.compareTo("boolean") == 0);
                                                {
                                                    boolean booleanField;
                                                    booleanField = f.getBoolean(this);
                                                    sprint(booleanField);
                                                } //End block
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_763193438 = (fname.compareTo("double") == 0);
                                                    {
                                                        double doubleField;
                                                        doubleField = f.getDouble(this);
                                                        sprint(doubleField);
                                                    } //End block
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_1402538441 = (fname.compareTo("float") == 0);
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
                            boolean varD5A8092938B037D2C43A6EAD0E6B9173_1637451332 = (GenericObject.class.isAssignableFrom(fieldType));
                            {
                                {
                                    boolean varFF6BA6C3E22248032CA1E2ADDB055F70_586993721 = (f.get(this) != null);
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
                                boolean var3D135DF8A6804404B214F5224E4565F6_2077044531 = (GenericObjectList.class.isAssignableFrom(fieldType));
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_740532251 = (f.get(this) != null);
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
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_2054318644 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).getClass().getName() + ":");
                                        } //End block
                                        {
                                            sprint(fieldType.getName() + ":");
                                        } //End block
                                    } //End collapsed parenthetic
                                    sprint("{");
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_442371246 = (f.get(this) != null);
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
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.547 -0400", hash_original_method = "C8764A7C07CF0ED92D22CFD53801BCA7", hash_generated_method = "575E1BF56B773F360EFDB5FA309B67CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump(int indent) {
        dsTaint.addTaint(indent);
        String retval;
        retval = this.debugDump();
        indentation = 0;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = 0;
        //return retval;
    }

    
    public abstract String encode();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.548 -0400", hash_original_method = "23BD5BF1494AAB1936A4882B6C7896EB", hash_generated_method = "98B1DC7DE2AFB304B4F3EDB2F3087D4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        StringBuffer varD4D4E95342E8847AA75737E4177D1381_2132609356 = (buffer.append(encode()));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return buffer.append(encode());
    }

    
    protected static final String SEMICOLON = Separators.SEMICOLON;
    protected static final String COLON = Separators.COLON;
    protected static final String COMMA = Separators.COMMA;
    protected static final String SLASH = Separators.SLASH;
    protected static final String SP = Separators.SP;
    protected static final String EQUALS = Separators.EQUALS;
    protected static final String STAR = Separators.STAR;
    protected static final String NEWLINE = Separators.NEWLINE;
    protected static final String RETURN = Separators.RETURN;
    protected static final String LESS_THAN = Separators.LESS_THAN;
    protected static final String GREATER_THAN = Separators.GREATER_THAN;
    protected static final String AT = Separators.AT;
    protected static final String DOT = Separators.DOT;
    protected static final String QUESTION = Separators.QUESTION;
    protected static final String POUND = Separators.POUND;
    protected static final String AND = Separators.AND;
    protected static final String LPAREN = Separators.LPAREN;
    protected static final String RPAREN = Separators.RPAREN;
    protected static final String DOUBLE_QUOTE = Separators.DOUBLE_QUOTE;
    protected static final String QUOTE = Separators.QUOTE;
    protected static final String HT = Separators.HT;
    protected static final String PERCENT = Separators.PERCENT;
    protected static final Set<Class<?>> immutableClasses = new HashSet<Class<?>> (10);
    static final String[] immutableClassNames ={
        "String", "Character",
        "Boolean", "Byte", "Short", "Integer", "Long",
        "Float", "Double"
        };
    static {
        try {
            for (int i = 0; i < immutableClassNames.length; i++)
                immutableClasses.add(Class.forName("java.lang." + immutableClassNames [i]));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException ("Internal error", e);
        }
    }
    
}

