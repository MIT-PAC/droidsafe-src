package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.reflect.*;
import java.io.Serializable;
import java.util.*;

public abstract class GenericObject implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.343 -0400", hash_original_field = "449072E30B43D04B744F22522A880818", hash_generated_field = "3BB4EF50B1D217FA88F0841635612381")

    protected int indentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.343 -0400", hash_original_field = "494C9560B4D085454F43F2CC050768A4", hash_generated_field = "9E5739E35654F3700B4DC02E1276C03E")

    protected String stringRepresentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.343 -0400", hash_original_field = "8A586A72E3C2C66C051718676CE8506A", hash_generated_field = "1FBB25CEF289694DDD0EE719A8EBD93D")

    protected Match matchExpression;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.343 -0400", hash_original_method = "26BB6C9083355DA218DE35B50B1395A1", hash_generated_method = "A848942BE08E69D42E88C40CE7E5C52A")
    protected  GenericObject() {
        indentation = 0;
        stringRepresentation = "";
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.343 -0400", hash_original_method = "D09804B85BA352DF07D45D843F3B447E", hash_generated_method = "57A2AD46EF223AEB7DBE089F5BAB8113")
    public void setMatcher(Match matchExpression) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null arg!");
        this.matchExpression = matchExpression;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.344 -0400", hash_original_method = "5F1EBA3A7EC51605C965562331E40E61", hash_generated_method = "62E0B5DFD3A6040BF185DB339B59E47D")
    public Match getMatcher() {
        Match varB4EAC82CA7396A68D541C85D26508E83_1309026868 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1309026868 = matchExpression;
        varB4EAC82CA7396A68D541C85D26508E83_1309026868.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1309026868;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Class<?> getClassFromName(String className) {
        try {
            return Class.forName(className);
        } catch (Exception ex) {
            InternalErrorHandler.handleException(ex);
            return null;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isMySubclass(Class<?> other) {
        return GenericObject.class.isAssignableFrom(other);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.345 -0400", hash_original_method = "2321A1A51988B1008E8A21E8D40DF48D", hash_generated_method = "BD456CC7E5C1872B1A11E1AAB5DA4D35")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1483264779 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1483264779 = super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Internal error");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1483264779.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1483264779;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.346 -0400", hash_original_method = "1F4053FE4D1137EC6D445870C27D5323", hash_generated_method = "A824B9B466B1153AC3E0D994584A9BB6")
    public void merge(Object mergeObject) {
        {
            boolean var8452B1A6FCDC01269CD81C5100106B81_1431617591 = (!mergeObject.getClass().equals(this.getClass()));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad override object");
        } 
        Class<?> myclass = this.getClass();
        {
            Field[] fields = myclass.getDeclaredFields();
            {
                int i = 0;
                {
                    Field f = fields[i];
                    int modifier = f.getModifiers();
                    {
                        boolean var637F279E29C6409424F01E5C0418E3F5_1565542115 = (Modifier.isPrivate(modifier));
                        {
                            boolean var0B58DE5C191622C96155E8901AAFE780_1807231895 = (Modifier.isStatic(modifier));
                            {
                                boolean var657457D35C601506E85A319B7FA165CD_263846912 = (Modifier.isInterface(modifier));
                            } 
                        } 
                    } 
                    Class<?> fieldType = f.getType();
                    String fname = fieldType.toString();
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_236823845 = (fieldType.isPrimitive());
                            {
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_1102642257 = (fname.compareTo("int") == 0);
                                    {
                                        int intfield = f.getInt(mergeObject);
                                        f.setInt(this, intfield);
                                    } 
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_577952682 = (fname.compareTo("short") == 0);
                                        {
                                            short shortField = f.getShort(mergeObject);
                                            f.setShort(this, shortField);
                                        } 
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_552640304 = (fname.compareTo("char") == 0);
                                            {
                                                char charField = f.getChar(mergeObject);
                                                f.setChar(this, charField);
                                            } 
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_132810234 = (fname.compareTo("long") == 0);
                                                {
                                                    long longField = f.getLong(mergeObject);
                                                    f.setLong(this, longField);
                                                } 
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_407538655 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        boolean booleanField = f.getBoolean(mergeObject);
                                                        f.setBoolean(this, booleanField);
                                                    } 
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_746693539 = (fname.compareTo("double") == 0);
                                                        {
                                                            double doubleField = f.getDouble(mergeObject);
                                                            f.setDouble(this, doubleField);
                                                        } 
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_263472816 = (fname.compareTo("float") == 0);
                                                            {
                                                                float floatField = f.getFloat(mergeObject);
                                                                f.setFloat(this, floatField);
                                                            } 
                                                        } 
                                                    } 
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                            {
                                Object obj = f.get(this);
                                Object mobj = f.get(mergeObject);
                                {
                                    f.set(this, mobj);
                                } 
                                {
                                    GenericObject gobj = (GenericObject) obj;
                                    gobj.merge(mobj);
                                } 
                                {
                                    f.set(this, mobj);
                                } 
                            } 
                        } 
                    } 
                    catch (IllegalAccessException ex1)
                    {
                        ex1.printStackTrace();
                    } 
                } 
            } 
            myclass = myclass.getSuperclass();
            {
                boolean varCDC8F41D003E6132167E97CC5CFF7C59_1201908596 = (myclass.equals(GenericObject.class));
            } 
        } 
        addTaint(mergeObject.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.348 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "67D1F87069E6B9FC18571D90878244FA")
    protected String getIndentation() {
        String varB4EAC82CA7396A68D541C85D26508E83_1797223137 = null; 
        char [] chars = new char [indentation];
        java.util.Arrays.fill (chars, ' ');
        varB4EAC82CA7396A68D541C85D26508E83_1797223137 = new String (chars);
        varB4EAC82CA7396A68D541C85D26508E83_1797223137.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1797223137;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.348 -0400", hash_original_method = "81374D32EA999C5E19458011FA3994BB", hash_generated_method = "011EB255B7A2E459D81A08FD7EF7DC7E")
    protected void sprint(String a) {
        {
            stringRepresentation += getIndentation();
            stringRepresentation += "<null>\n";
        } 
        {
            boolean varD8E1029F8F5CABA6ABE68CE554DCCDBF_891236622 = (a.compareTo("}") == 0 || a.compareTo("]") == 0);
        } 
        stringRepresentation += getIndentation();
        stringRepresentation += a;
        stringRepresentation += "\n";
        {
            boolean varE6EEF37B8568997438402983081D59AC_1538284895 = (a.compareTo("{") == 0 || a.compareTo("[") == 0);
        } 
        
        
            
            
            
        
        
            
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.348 -0400", hash_original_method = "453FE126FB96D6280FF2B67B25D884AF", hash_generated_method = "8CA9596929A8EE5CFF63128AAD234BDC")
    protected void sprint(Object o) {
        sprint(o.toString());
        addTaint(o.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.349 -0400", hash_original_method = "EF724337BA21340D79134B1646FA7D50", hash_generated_method = "8E360E95F1B4B5C0877EEC3072FB39C0")
    protected void sprint(int intField) {
        sprint(String.valueOf(intField));
        addTaint(intField);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.349 -0400", hash_original_method = "8A8752611967BFFBE38D675256F01214", hash_generated_method = "09D4B99977BCEAD6319C2E54316C8BDD")
    protected void sprint(short shortField) {
        sprint(String.valueOf(shortField));
        addTaint(shortField);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.349 -0400", hash_original_method = "B9E7539CD6E988936CBC2F41DE2D2255", hash_generated_method = "BBDCAB22F56BA386B0B86E0A2C72F59E")
    protected void sprint(char charField) {
        sprint(String.valueOf(charField));
        addTaint(charField);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.349 -0400", hash_original_method = "CC6905368951D9D7C183C56D69A53B5E", hash_generated_method = "F710AFBEDA2E0EB486D57E30E6C88DAC")
    protected void sprint(long longField) {
        sprint(String.valueOf(longField));
        addTaint(longField);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.349 -0400", hash_original_method = "27E91C5243CD6D4BB691664DB4C3BC19", hash_generated_method = "25FD161C5C5B5E281901EF862B19D028")
    protected void sprint(boolean booleanField) {
        sprint(String.valueOf(booleanField));
        addTaint(booleanField);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.350 -0400", hash_original_method = "A8149AFA8BAA8D148E9A9CE1C6489F0C", hash_generated_method = "E1A33565E4EF7C7DF46C2E9821C3F617")
    protected void sprint(double doubleField) {
        sprint(String.valueOf(doubleField));
        addTaint(doubleField);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.350 -0400", hash_original_method = "96C3F949D4FB0E545745C5388D6DC08E", hash_generated_method = "2543DE845676E10E7861789E8679BB8B")
    protected void sprint(float floatField) {
        sprint(String.valueOf(floatField));
        addTaint(floatField);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.350 -0400", hash_original_method = "C3665E5B2DC148B3D9AC2D1614738627", hash_generated_method = "CC9960C463BA8ADB2C2953D0609F3E40")
    protected void dbgPrint() {
        Debug.println(debugDump());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.350 -0400", hash_original_method = "F3C9E7E4BCD0D7ECC989FFC8CBCF37DF", hash_generated_method = "B30B6C8F631154417A4BD3A53EBA3870")
    protected void dbgPrint(String s) {
        Debug.println(s);
        addTaint(s.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.352 -0400", hash_original_method = "B5B25EA3AF1891601BFD267279427EFB", hash_generated_method = "B58080E0BACAA7BBCCB4833F772D36EA")
    public boolean equals(Object that) {
        {
            boolean var07F02797FD62DC585D5DCA22B5D2ED2C_950090290 = (!this.getClass().equals(that.getClass()));
        } 
        Class<?> myclass = this.getClass();
        Class<?> hisclass = that.getClass();
        {
            Field[] fields = myclass.getDeclaredFields();
            Field[] hisfields = hisclass.getDeclaredFields();
            {
                int i = 0;
                {
                    Field f = fields[i];
                    Field g = hisfields[i];
                    int modifier = f.getModifiers();
                    Class<?> fieldType = f.getType();
                    String fieldName = f.getName();
                    {
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_1507960617 = (fieldName.compareTo("stringRepresentation") == 0);
                    } 
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_785621536 = (fieldName.compareTo("indentation") == 0);
                    } 
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_575217163 = (fieldType.isPrimitive());
                            {
                                String fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_1100458628 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_660644641 = (f.getInt(this) != g.getInt(that));
                                        } 
                                    } 
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_316999116 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_403060498 = (f.getShort(this) != g.getShort(that));
                                            } 
                                        } 
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_2040041430 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_31833757 = (f.getChar(this) != g.getChar(that));
                                                } 
                                            } 
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_712793301 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_882217355 = (f.getLong(this) != g.getLong(that));
                                                    } 
                                                } 
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_722723686 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_161494552 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } 
                                                    } 
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_1039164636 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_129724422 = (f.getDouble(this) != g.getDouble(that));
                                                            } 
                                                        } 
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_2070493635 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_1848525329 = (f.getFloat(this) != g.getFloat(that));
                                                                } 
                                                            } 
                                                        } 
                                                    } 
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                            {
                                boolean varAA8F4E7F9752016DF7A866D138AF57F2_989270555 = (g.get(that) == f.get(this));
                                {
                                    boolean varD397365BE62D10D7E011B256F8B6D455_502280103 = (f.get(this) == null);
                                    {
                                        boolean var207751DCCBECC5B08EAE9BEAF3ED0EA6_513806756 = (g.get(that) == null);
                                        {
                                            boolean var0EABF098CA8E2696A8304A37E0D2F9C1_1131084711 = (g.get(that) == null && f.get(this) != null);
                                            {
                                                boolean varE99CF41FD22D6AE43C5A320D0ADAFDF4_1033175383 = (!f.get(this).equals(g.get(that)));
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    catch (IllegalAccessException ex1)
                    {
                        InternalErrorHandler.handleException(ex1);
                    } 
                } 
            } 
            {
                boolean varCDC8F41D003E6132167E97CC5CFF7C59_1409902861 = (myclass.equals(GenericObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } 
            } 
        } 
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598999756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598999756;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.354 -0400", hash_original_method = "EA6AD5335EE18CA3C2D0278C0E091AE5", hash_generated_method = "B8D433FAEFF0A6565A1DDA28BA9F3001")
    public boolean match(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1886467757 = (!this.getClass().equals(other.getClass()));
        } 
        GenericObject that = (GenericObject) other;
        Class<?> myclass = this.getClass();
        Field[] fields = myclass.getDeclaredFields();
        Class<?> hisclass = other.getClass();
        Field[] hisfields = hisclass.getDeclaredFields();
        {
            int i = 0;
            {
                Field f = fields[i];
                Field g = hisfields[i];
                int modifier = f.getModifiers();
                Class<?> fieldType = f.getType();
                String fieldName = f.getName();
                {
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_217230559 = (fieldName.compareTo("stringRepresentation") == 0);
                } 
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_629906383 = (fieldName.compareTo("indentation") == 0);
                } 
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_985076389 = (fieldType.isPrimitive());
                        {
                            String fname = fieldType.toString();
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_46819852 = (fname.compareTo("int") == 0);
                                {
                                    {
                                        boolean var4CA69663022635DA9D4B226B8EFD063A_261504829 = (f.getInt(this) != g.getInt(that));
                                    } 
                                } 
                                {
                                    boolean varECBE882B00F953257800779B015A044A_434659806 = (fname.compareTo("short") == 0);
                                    {
                                        {
                                            boolean var1818C0AE349B8E9B94D12F42F9192D27_1243275907 = (f.getShort(this) != g.getShort(that));
                                        } 
                                    } 
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_1451219101 = (fname.compareTo("char") == 0);
                                        {
                                            {
                                                boolean varA9225C0F38F0CE651E5840717A73CB98_1529825180 = (f.getChar(this) != g.getChar(that));
                                            } 
                                        } 
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_2143457670 = (fname.compareTo("long") == 0);
                                            {
                                                {
                                                    boolean var682FCF417B627E8F7623C28A936CE964_815952240 = (f.getLong(this) != g.getLong(that));
                                                } 
                                            } 
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_1669821087 = (fname.compareTo("boolean") == 0);
                                                {
                                                    {
                                                        boolean var6B4A94D318FFDC583C00F3E90D7F247E_433781550 = (f.getBoolean(this) != g.getBoolean(that));
                                                    } 
                                                } 
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_2111965347 = (fname.compareTo("double") == 0);
                                                    {
                                                        {
                                                            boolean var8407698AFEB885A11314D630BB9E8490_670996661 = (f.getDouble(this) != g.getDouble(that));
                                                        } 
                                                    } 
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_577586204 = (fname.compareTo("float") == 0);
                                                        {
                                                            {
                                                                boolean varBBC04007B7E490847AA4F63B58E5D60D_192809599 = (f.getFloat(this) != g.getFloat(that));
                                                            } 
                                                        } 
                                                    } 
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                        {
                            Object myObj = f.get(this);
                            Object hisObj = g.get(that);
                            {
                                {
                                    boolean var32FB3616EAA55BEC408E0E48EF8F9199_123284277 = ((((String) hisObj).trim()).equals(""));
                                } 
                                {
                                    boolean varD3C11AAADBE52EF7B0D1EB153FA4D292_1303895768 = (((String) myObj)
                            .compareToIgnoreCase((String) hisObj)
                            != 0);
                                } 
                            } 
                            {
                                boolean var4C97BE25056F5D73A11941653F4F33DF_1540515611 = (GenericObject.isMySubclass(myObj.getClass())
                            && !((GenericObject) myObj).match(hisObj));
                                {
                                    boolean varD91F7FE40B718120DD724990CF9E578C_1477793927 = (GenericObjectList.isMySubclass(myObj.getClass())
                            && !((GenericObjectList) myObj).match(hisObj));
                                } 
                            } 
                        } 
                    } 
                } 
                catch (IllegalAccessException ex1)
                {
                    InternalErrorHandler.handleException(ex1);
                } 
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340843688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340843688;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.356 -0400", hash_original_method = "9A2585B996B0A77325ECBDA944C7F6EB", hash_generated_method = "552007C4D5A5210C6F3E105E2BCE5E32")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_1948977351 = null; 
        stringRepresentation = "";
        Class<?> myclass = getClass();
        sprint(myclass.getName());
        sprint("{");
        Field[] fields = myclass.getDeclaredFields();
        {
            int i = 0;
            {
                Field f = fields[i];
                int modifier = f.getModifiers();
                Class<?> fieldType = f.getType();
                String fieldName = f.getName();
                {
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_712013423 = (fieldName.compareTo("stringRepresentation") == 0);
                } 
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_378667545 = (fieldName.compareTo("indentation") == 0);
                } 
                sprint(fieldName + ":");
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_450349036 = (fieldType.isPrimitive());
                        {
                            String fname = fieldType.toString();
                            sprint(fname + ":");
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_1589711802 = (fname.compareTo("int") == 0);
                                {
                                    int intfield = f.getInt(this);
                                    sprint(intfield);
                                } 
                                {
                                    boolean varECBE882B00F953257800779B015A044A_669433229 = (fname.compareTo("short") == 0);
                                    {
                                        short shortField = f.getShort(this);
                                        sprint(shortField);
                                    } 
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_1083816568 = (fname.compareTo("char") == 0);
                                        {
                                            char charField = f.getChar(this);
                                            sprint(charField);
                                        } 
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_228154233 = (fname.compareTo("long") == 0);
                                            {
                                                long longField = f.getLong(this);
                                                sprint(longField);
                                            } 
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_1417258353 = (fname.compareTo("boolean") == 0);
                                                {
                                                    boolean booleanField = f.getBoolean(this);
                                                    sprint(booleanField);
                                                } 
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_1515178990 = (fname.compareTo("double") == 0);
                                                    {
                                                        double doubleField = f.getDouble(this);
                                                        sprint(doubleField);
                                                    } 
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_614929841 = (fname.compareTo("float") == 0);
                                                        {
                                                            float floatField = f.getFloat(this);
                                                            sprint(floatField);
                                                        } 
                                                    } 
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                        {
                            boolean varD5A8092938B037D2C43A6EAD0E6B9173_1945667936 = (GenericObject.class.isAssignableFrom(fieldType));
                            {
                                {
                                    boolean varFF6BA6C3E22248032CA1E2ADDB055F70_1670002849 = (f.get(this) != null);
                                    {
                                        sprint(
                            ((GenericObject) f.get(this)).debugDump(
                                indentation + 1));
                                    } 
                                    {
                                        sprint("<null>");
                                    } 
                                } 
                            } 
                            {
                                boolean var3D135DF8A6804404B214F5224E4565F6_2059361125 = (GenericObjectList.class.isAssignableFrom(fieldType));
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1652567533 = (f.get(this) != null);
                                        {
                                            sprint(
                            ((GenericObjectList) f.get(this)).debugDump(
                                indentation + 1));
                                        } 
                                        {
                                            sprint("<null>");
                                        } 
                                    } 
                                } 
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_892973999 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).getClass().getName() + ":");
                                        } 
                                        {
                                            sprint(fieldType.getName() + ":");
                                        } 
                                    } 
                                    sprint("{");
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1825517618 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).toString());
                                        } 
                                        {
                                            sprint("<null>");
                                        } 
                                    } 
                                    sprint("}");
                                } 
                            } 
                        } 
                    } 
                } 
                catch (IllegalAccessException ex1)
                { }
                catch (Exception ex)
                {
                    InternalErrorHandler.handleException(ex);
                } 
            } 
        } 
        sprint("}");
        varB4EAC82CA7396A68D541C85D26508E83_1948977351 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_1948977351.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1948977351;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.358 -0400", hash_original_method = "C8764A7C07CF0ED92D22CFD53801BCA7", hash_generated_method = "96ABCBD55C70CE8D0339A4871043641F")
    public String debugDump(int indent) {
        String varB4EAC82CA7396A68D541C85D26508E83_1209352125 = null; 
        indentation = indent;
        String retval = this.debugDump();
        indentation = 0;
        varB4EAC82CA7396A68D541C85D26508E83_1209352125 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1209352125.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1209352125;
        
        
        
        
        
    }

    
    public abstract String encode();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.361 -0400", hash_original_method = "23BD5BF1494AAB1936A4882B6C7896EB", hash_generated_method = "BC62AD21547C9C85A191D628A8662C23")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_2110173655 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2110173655 = buffer.append(encode());
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2110173655.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2110173655;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.362 -0400", hash_original_field = "D1190824E35A683C05589F1C776EEB98", hash_generated_field = "02EC968BA435084EE7ADC81279AB56D8")

    protected static final String SEMICOLON = Separators.SEMICOLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.362 -0400", hash_original_field = "02A534AF21A6F783F08D86D26579E890", hash_generated_field = "6B6A3C0E5AAA12BC4230EF790A3C2476")

    protected static final String COLON = Separators.COLON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.362 -0400", hash_original_field = "6C852D8F8039F1F9747489612DAC3C3C", hash_generated_field = "2C4A8D03DDB954D51E978CD8F8E2DEA4")

    protected static final String COMMA = Separators.COMMA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.362 -0400", hash_original_field = "04C5392343613D1101130F746A81D0F3", hash_generated_field = "8A50D691E37AC9254B7ED2ABCE4AC6D2")

    protected static final String SLASH = Separators.SLASH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.362 -0400", hash_original_field = "D8EE4E7D0F1EAB2E2745753B5AD2FE8D", hash_generated_field = "0CF03E9FD9212362B2D202A36124051A")

    protected static final String SP = Separators.SP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.362 -0400", hash_original_field = "3C7C6B82B012EBDA39975B1F72983C28", hash_generated_field = "AD22F298E6FF482BE0BD697358901610")

    protected static final String EQUALS = Separators.EQUALS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.362 -0400", hash_original_field = "B9D394806A580E8DE8984E11AC02BDE2", hash_generated_field = "2A5C8D44567A1C68D53F48B0CD1AF72E")

    protected static final String STAR = Separators.STAR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.362 -0400", hash_original_field = "4B65D6BACAFDD7AB302810256C42CCB9", hash_generated_field = "99D8C532EFD2EC03350A98B152CEDB7F")

    protected static final String NEWLINE = Separators.NEWLINE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.362 -0400", hash_original_field = "4E25B108371C30F889E1B6E8C1046FAB", hash_generated_field = "5E44FE20A9580182CC4CE4836B87D2F2")

    protected static final String RETURN = Separators.RETURN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "7E16A38DE053150CC3BF00FEBC32CBB3", hash_generated_field = "03472463E2EA98D819ECAC54647D9EEB")

    protected static final String LESS_THAN = Separators.LESS_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "CBC3FB6A2E3BC245B189168F8F698149", hash_generated_field = "EADC9D4C7F8A41AC9253B4399DD9CC22")

    protected static final String GREATER_THAN = Separators.GREATER_THAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "72EE65D27F762C3B2FB94C3FA334B5E4", hash_generated_field = "94E22BF70767B9E5F90C8BEFB48DFB31")

    protected static final String AT = Separators.AT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "3ACE38B8B42CCCDC519BBD9065EB1D1A", hash_generated_field = "C68E946646D329E00948C391567E8245")

    protected static final String DOT = Separators.DOT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "B2A15792014FB9077E86DD721A8EFBA4", hash_generated_field = "C6F6498E0BEB8E9B929D5FF0691C60C5")

    protected static final String QUESTION = Separators.QUESTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "096D0F7D4D4C7B4283D714ECD7F549C3", hash_generated_field = "3931FF01A0452F4B915432DFE1D8342B")

    protected static final String POUND = Separators.POUND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "705C7DB0DE742246702AC85CCAA66A2B", hash_generated_field = "A7C8E60A9ACCF4FC95E42A6FE3CBE98A")

    protected static final String AND = Separators.AND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "B7554C14B11FFE96B375109E44C62935", hash_generated_field = "96B1BA6A04896DF507DBF5F6007D53FF")

    protected static final String LPAREN = Separators.LPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "ED8913C274C5CDFEFC62F7A7FE2688CB", hash_generated_field = "04E1EDA33DBBA7B9CD0B5320DA6E2B15")

    protected static final String RPAREN = Separators.RPAREN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "CD4D1E68FDC871F3D1A212D438F276AF", hash_generated_field = "60970C4DF02E2922FFB2BB3FCBF1CC4C")

    protected static final String DOUBLE_QUOTE = Separators.DOUBLE_QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "1084586CDB13332FA26836F7CE2B3817", hash_generated_field = "36D2B8942300A11E9A202D488BEEC708")

    protected static final String QUOTE = Separators.QUOTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "58E3D5E258B17E5D6D1BDF83FE976FD6", hash_generated_field = "EE0F746E0ADCCF78C293F0BC27A024C1")

    protected static final String HT = Separators.HT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.363 -0400", hash_original_field = "4AEF06B345694E240504FA11CF16C815", hash_generated_field = "E525B1F947054DAAB71F0D7018A0312F")

    protected static final String PERCENT = Separators.PERCENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.364 -0400", hash_original_field = "6796B59570731F7B6F84E1F281186777", hash_generated_field = "23DD3DB933D01AADE0B2C40AA464AC9C")

    protected static final Set<Class<?>> immutableClasses = new HashSet<Class<?>> (10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.364 -0400", hash_original_field = "0903587AC197526F6DF5345E92DCF834", hash_generated_field = "06A0F0FA7C3AA2D1A0C9419E5DAE1A94")

    static final String[] immutableClassNames = {
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

