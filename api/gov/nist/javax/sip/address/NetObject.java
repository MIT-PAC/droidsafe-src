package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.GenericObject;
import gov.nist.core.GenericObjectList;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.PackageNames;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;






public abstract class NetObject extends GenericObject {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.089 -0400", hash_original_method = "C4442EA667C9A2BEB67B2F1E6DC6F09B", hash_generated_method = "DA7CD8F57514C7E6D13831C88B45DC81")
    public  NetObject() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.091 -0400", hash_original_method = "26A4AB68F41643C912C51D77CC375C44", hash_generated_method = "941AFE4DB6196BF6E0472C5608A908FF")
    public boolean equals(Object that) {
        addTaint(that.getTaint());
        if(!this.getClass().equals(that.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_688709091 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1613835243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1613835243;
        }
        Class<?> myclass = this.getClass();
        Class<?> hisclass = that.getClass();
        while
(true)        
        {
            Field[] fields = myclass.getDeclaredFields();
            Field[] hisfields = hisclass.getDeclaredFields();
for(int i = 0;i < fields.length;i++)
            {
                Field f = fields[i];
                Field g = hisfields[i];
                int modifier = f.getModifiers();
                if((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)                
                continue;
                Class<?> fieldType = f.getType();
                String fieldName = f.getName();
                if(fieldName.compareTo("stringRepresentation") == 0)                
                {
                    continue;
                } //End block
                if(fieldName.compareTo("indentation") == 0)                
                {
                    continue;
                } //End block
                try 
                {
                    if(fieldType.isPrimitive())                    
                    {
                        String fname = fieldType.toString();
                        if(fname.compareTo("int") == 0)                        
                        {
                            if(f.getInt(this) != g.getInt(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_90037142 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_515944724 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_515944724;
                            }
                        } //End block
                        else
                        if(fname.compareTo("short") == 0)                        
                        {
                            if(f.getShort(this) != g.getShort(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_2135454268 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_353197116 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_353197116;
                            }
                        } //End block
                        else
                        if(fname.compareTo("char") == 0)                        
                        {
                            if(f.getChar(this) != g.getChar(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1123606213 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177369300 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_177369300;
                            }
                        } //End block
                        else
                        if(fname.compareTo("long") == 0)                        
                        {
                            if(f.getLong(this) != g.getLong(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1722348654 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_332953914 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_332953914;
                            }
                        } //End block
                        else
                        if(fname.compareTo("boolean") == 0)                        
                        {
                            if(f.getBoolean(this) != g.getBoolean(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1181288397 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_360815425 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_360815425;
                            }
                        } //End block
                        else
                        if(fname.compareTo("double") == 0)                        
                        {
                            if(f.getDouble(this) != g.getDouble(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_428327299 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313747428 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_313747428;
                            }
                        } //End block
                        else
                        if(fname.compareTo("float") == 0)                        
                        {
                            if(f.getFloat(this) != g.getFloat(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1671138163 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821876041 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_821876041;
                            }
                        } //End block
                    } //End block
                    else
                    if(g.get(that) == f.get(this))                    
                    continue;
                    else
                    if(f.get(this) == null && g.get(that) != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1997506022 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1035885958 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1035885958;
                    }
                    else
                    if(g.get(that) == null && f.get(that) != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_819203753 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110016253 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110016253;
                    }
                    else
                    if(!f.get(this).equals(g.get(that)))                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1504230265 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1261120618 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1261120618;
                    }
                } //End block
                catch (IllegalAccessException ex1)
                {
                    InternalErrorHandler.handleException(ex1);
                } //End block
            } //End block
            if(myclass.equals(NetObject.class))            
            break;
            else
            {
                myclass = myclass.getSuperclass();
                hisclass = hisclass.getSuperclass();
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1115135592 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084409905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084409905;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.096 -0400", hash_original_method = "8D936CCD11169852B60D86BE02120DB8", hash_generated_method = "0B08F13E934F8B93563C9D11AD4CEB17")
    public boolean match(Object other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_636396284 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1302892535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1302892535;
        }
        if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_650440038 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986935083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_986935083;
        }
        GenericObject that = (GenericObject) other;
        Class<?> hisclass = other.getClass();
        Class<?> myclass = this.getClass();
        while
(true)        
        {
            Field[] fields = myclass.getDeclaredFields();
            Field[] hisfields = hisclass.getDeclaredFields();
for(int i = 0;i < fields.length;i++)
            {
                Field f = fields[i];
                Field g = hisfields[i];
                int modifier = f.getModifiers();
                if((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)                
                continue;
                Class<?> fieldType = f.getType();
                String fieldName = f.getName();
                if(fieldName.compareTo("stringRepresentation") == 0)                
                {
                    continue;
                } //End block
                if(fieldName.compareTo("indentation") == 0)                
                {
                    continue;
                } //End block
                try 
                {
                    if(fieldType.isPrimitive())                    
                    {
                        String fname = fieldType.toString();
                        if(fname.compareTo("int") == 0)                        
                        {
                            if(f.getInt(this) != g.getInt(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1161514495 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194921024 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_194921024;
                            }
                        } //End block
                        else
                        if(fname.compareTo("short") == 0)                        
                        {
                            if(f.getShort(this) != g.getShort(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1775816150 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_992680682 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_992680682;
                            }
                        } //End block
                        else
                        if(fname.compareTo("char") == 0)                        
                        {
                            if(f.getChar(this) != g.getChar(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_690224378 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490735928 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490735928;
                            }
                        } //End block
                        else
                        if(fname.compareTo("long") == 0)                        
                        {
                            if(f.getLong(this) != g.getLong(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1995771954 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821016268 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_821016268;
                            }
                        } //End block
                        else
                        if(fname.compareTo("boolean") == 0)                        
                        {
                            if(f.getBoolean(this) != g.getBoolean(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_359189819 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_234139665 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_234139665;
                            }
                        } //End block
                        else
                        if(fname.compareTo("double") == 0)                        
                        {
                            if(f.getDouble(this) != g.getDouble(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1007741282 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591475489 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591475489;
                            }
                        } //End block
                        else
                        if(fname.compareTo("float") == 0)                        
                        {
                            if(f.getFloat(this) != g.getFloat(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1380041015 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1846211227 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1846211227;
                            }
                        } //End block
                    } //End block
                    else
                    {
                        Object myObj = f.get(this);
                        Object hisObj = g.get(that);
                        if(hisObj != null && myObj == null)                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_1568519315 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845815329 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845815329;
                        }
                        else
                        if(hisObj == null && myObj != null)                        
                        continue;
                        else
                        if(hisObj == null && myObj == null)                        
                        continue;
                        else
                        if(hisObj instanceof java.lang.String
                                && myObj instanceof java.lang.String)                        
                        {
                            if(((String) hisObj).equals(""))                            
                            continue;
                            if(((String) myObj)
                                .compareToIgnoreCase((String) hisObj)
                                != 0)                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_579258044 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_429448689 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_429448689;
                            }
                        } //End block
                        else
                        if(GenericObject.isMySubclass(myObj.getClass())
                                && GenericObject.isMySubclass(hisObj.getClass())
                                && myObj.getClass().equals(hisObj.getClass())
                                && ((GenericObject) hisObj).getMatcher()
                                    != null)                        
                        {
                            String myObjEncoded = ((GenericObject) myObj).encode();
                            boolean retval = ((GenericObject) hisObj).getMatcher().match(
                                    myObjEncoded);
                            if(!retval)                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_2009994403 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1522471574 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1522471574;
                            }
                        } //End block
                        else
                        if(GenericObject.isMySubclass(myObj.getClass())
                                && !((GenericObject) myObj).match(hisObj))                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_1461839391 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1031735021 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1031735021;
                        }
                        else
                        if(GenericObjectList.isMySubclass(myObj.getClass())
                                && !((GenericObjectList) myObj).match(hisObj))                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_1790688051 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_650668408 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_650668408;
                        }
                    } //End block
                } //End block
                catch (IllegalAccessException ex1)
                {
                    InternalErrorHandler.handleException(ex1);
                } //End block
            } //End block
            if(myclass.equals(NetObject.class))            
            break;
            else
            {
                myclass = myclass.getSuperclass();
                hisclass = hisclass.getSuperclass();
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_186018477 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2130924283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2130924283;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.126 -0400", hash_original_method = "8F6462E23806D652AB2FB8FE10D0061F", hash_generated_method = "A06086FB1A7FBA01D237EE4E3A341B73")
    public String debugDump() {
        stringRepresentation = "";
        Class<?> myclass = getClass();
        sprint(myclass.getName());
        sprint("{");
        Field[] fields = myclass.getDeclaredFields();
for(int i = 0;i < fields.length;i++)
        {
            Field f = fields[i];
            int modifier = f.getModifiers();
            if((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)            
            continue;
            Class<?> fieldType = f.getType();
            String fieldName = f.getName();
            if(fieldName.compareTo("stringRepresentation") == 0)            
            {
                continue;
            } //End block
            if(fieldName.compareTo("indentation") == 0)            
            {
                continue;
            } //End block
            sprint(fieldName + ":");
            try 
            {
                if(fieldType.isPrimitive())                
                {
                    String fname = fieldType.toString();
                    sprint(fname + ":");
                    if(fname.compareTo("int") == 0)                    
                    {
                        int intfield = f.getInt(this);
                        sprint(intfield);
                    } //End block
                    else
                    if(fname.compareTo("short") == 0)                    
                    {
                        short shortField = f.getShort(this);
                        sprint(shortField);
                    } //End block
                    else
                    if(fname.compareTo("char") == 0)                    
                    {
                        char charField = f.getChar(this);
                        sprint(charField);
                    } //End block
                    else
                    if(fname.compareTo("long") == 0)                    
                    {
                        long longField = f.getLong(this);
                        sprint(longField);
                    } //End block
                    else
                    if(fname.compareTo("boolean") == 0)                    
                    {
                        boolean booleanField = f.getBoolean(this);
                        sprint(booleanField);
                    } //End block
                    else
                    if(fname.compareTo("double") == 0)                    
                    {
                        double doubleField = f.getDouble(this);
                        sprint(doubleField);
                    } //End block
                    else
                    if(fname.compareTo("float") == 0)                    
                    {
                        float floatField = f.getFloat(this);
                        sprint(floatField);
                    } //End block
                } //End block
                else
                if(GenericObject.class.isAssignableFrom(fieldType))                
                {
                    if(f.get(this) != null)                    
                    {
                        sprint(
                            ((GenericObject) f.get(this)).debugDump(
                                indentation + 1));
                    } //End block
                    else
                    {
                        sprint("<null>");
                    } //End block
                } //End block
                else
                if(GenericObjectList.class.isAssignableFrom(fieldType))                
                {
                    if(f.get(this) != null)                    
                    {
                        sprint(
                            ((GenericObjectList) f.get(this)).debugDump(
                                indentation + 1));
                    } //End block
                    else
                    {
                        sprint("<null>");
                    } //End block
                } //End block
                else
                {
                    if(f.get(this) != null)                    
                    {
                        sprint(f.get(this).getClass().getName() + ":");
                    } //End block
                    else
                    {
                        sprint(fieldType.getName() + ":");
                    } //End block
                    sprint("{");
                    if(f.get(this) != null)                    
                    {
                        sprint(f.get(this).toString());
                    } //End block
                    else
                    {
                        sprint("<null>");
                    } //End block
                    sprint("}");
                } //End block
            } //End block
            catch (IllegalAccessException ex1)
            {
                continue;
            } //End block
        } //End block
        sprint("}");
String var8D11C2D110975896438D6F91C60E6D6F_905064026 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_905064026.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_905064026;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "6FB7BA736857F6A3774A94854BEB27A7")
    public String debugDump(int indent) {
        addTaint(indent);
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
String varF9E19AD6135C970F387F77C6F3DE4477_1465052757 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1465052757.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1465052757;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "AA15FD2CDFA2F8F517F7805868526B84")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_1397870199 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_1397870199.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_1397870199;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "84814EA1316201D7682A1857E6DA438C", hash_generated_field = "46C2887731A82D54499D991777D692CF")

    protected static final String CORE_PACKAGE = PackageNames.CORE_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "D44CF5167E8CD4A0B8C7121141E5F5CA", hash_generated_field = "594D4223DA826D2239E3278060CF9C1D")

    protected static final String NET_PACKAGE = PackageNames.NET_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "A42FB06745B0689D818929080E18E2A6", hash_generated_field = "F9F431553B7EF5ED564BB76D3511A1C4")

    protected static final String PARSER_PACKAGE = PackageNames.PARSER_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "955EEDB20D590A1A9DC57A6B4C9C2524", hash_generated_field = "E0F49F8A6EC1F0FC10D150214707E15F")

    protected static final String UDP = "udp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "E7E305FD91DFAD258D05CEF692A3FDA3", hash_generated_field = "65B8023757C289C256D8CDF02D79EEAB")

    protected static final String TCP = "tcp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "BB60D14484559A8FB47EEE8E87D56416", hash_generated_field = "10ACFD285BFF968264526433D33B1AB0")

    protected static final String TRANSPORT = "transport";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "8B41FABA7E13C027203E37D1A20ED7C7", hash_generated_field = "ADFC98A2AB6C9BE4ECB3DA0DC42944C8")

    protected static final String METHOD = "method";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "2F525D63281BEC6D002BC4263B4225A0", hash_generated_field = "0BD3E85D4B799F1CA9E1ECA350C946CC")

    protected static final String USER = "user";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "D691F6CBCE83242F8E1801A18FE78496", hash_generated_field = "F56AC3F2C0064F9B98AE234242186C42")

    protected static final String PHONE = "phone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "7C093FAE4691A03AB86E86898A11746D", hash_generated_field = "7A87650302C67C9E28DB90C3D1ED745E")

    protected static final String MADDR = "maddr";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "EEECE76344C3913E85967FB61CC6ACB5", hash_generated_field = "9521875EFD450C64F6E61B84A224F274")

    protected static final String TTL = "ttl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "89D96C07757E423BC566F92B191778CF", hash_generated_field = "19B2449D5B180111495A6203819463E0")

    protected static final String LR = "lr";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "60903E31AE0F2D927C93F88555EA8B06", hash_generated_field = "6F3518A2B8F324537D0A7D82E19056BF")

    protected static final String SIP = "sip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "BB1888B5D56BD607ED3A6833F0434370", hash_generated_field = "2812DB6997C42C0FAEB5CA6CA624A89E")

    protected static final String SIPS = "sips";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "02AC7105BC9267167A7FE52691A37BAB", hash_generated_field = "9E085E7B626954040FA4C29E128B38D1")

    protected static final String TLS = "tls";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.127 -0400", hash_original_field = "86623E8163A910A0C283102686E462A2", hash_generated_field = "0792D95F056BB55ABBA0C958C9203C97")

    protected static final String GRUU = "gr";
}

