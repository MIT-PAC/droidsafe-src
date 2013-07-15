package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import java.lang.reflect.*;

public abstract class NetObject extends GenericObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.127 -0400", hash_original_method = "C4442EA667C9A2BEB67B2F1E6DC6F09B", hash_generated_method = "DA7CD8F57514C7E6D13831C88B45DC81")
    public  NetObject() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.128 -0400", hash_original_method = "26A4AB68F41643C912C51D77CC375C44", hash_generated_method = "B4D06786A2FC005C7BB0B0A690E77818")
    public boolean equals(Object that) {
        addTaint(that.getTaint());
    if(!this.getClass().equals(that.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1196426271 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918069384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_918069384;
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
                            boolean var68934A3E9455FA72420237EB05902327_1323965485 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474360852 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474360852;
                            }
                        } //End block
                        else
    if(fname.compareTo("short") == 0)                        
                        {
    if(f.getShort(this) != g.getShort(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1353954661 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444414438 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_444414438;
                            }
                        } //End block
                        else
    if(fname.compareTo("char") == 0)                        
                        {
    if(f.getChar(this) != g.getChar(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_335956640 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1603664785 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1603664785;
                            }
                        } //End block
                        else
    if(fname.compareTo("long") == 0)                        
                        {
    if(f.getLong(this) != g.getLong(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1481121323 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256989088 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256989088;
                            }
                        } //End block
                        else
    if(fname.compareTo("boolean") == 0)                        
                        {
    if(f.getBoolean(this) != g.getBoolean(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1416453074 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162618792 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_162618792;
                            }
                        } //End block
                        else
    if(fname.compareTo("double") == 0)                        
                        {
    if(f.getDouble(this) != g.getDouble(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1499181958 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_352898202 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_352898202;
                            }
                        } //End block
                        else
    if(fname.compareTo("float") == 0)                        
                        {
    if(f.getFloat(this) != g.getFloat(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_746386307 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_475309037 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_475309037;
                            }
                        } //End block
                    } //End block
                    else
    if(g.get(that) == f.get(this))                    
                    continue;
                    else
    if(f.get(this) == null && g.get(that) != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_559230084 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_332172455 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_332172455;
                    }
                    else
    if(g.get(that) == null && f.get(that) != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_190161277 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1989091123 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1989091123;
                    }
                    else
    if(!f.get(this).equals(g.get(that)))                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1221952694 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144377550 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144377550;
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
        boolean varB326B5062B2F0E69046810717534CB09_1384935821 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1099521270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1099521270;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.132 -0400", hash_original_method = "8D936CCD11169852B60D86BE02120DB8", hash_generated_method = "42AAD3034B3585D4B7CEF42601AD13F1")
    public boolean match(Object other) {
        addTaint(other.getTaint());
    if(other == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1347441105 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097992897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097992897;
        }
    if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_254257702 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634407670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634407670;
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
                            boolean var68934A3E9455FA72420237EB05902327_266253249 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806768912 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_806768912;
                            }
                        } //End block
                        else
    if(fname.compareTo("short") == 0)                        
                        {
    if(f.getShort(this) != g.getShort(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_471431600 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657190178 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_657190178;
                            }
                        } //End block
                        else
    if(fname.compareTo("char") == 0)                        
                        {
    if(f.getChar(this) != g.getChar(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_586154614 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992518791 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992518791;
                            }
                        } //End block
                        else
    if(fname.compareTo("long") == 0)                        
                        {
    if(f.getLong(this) != g.getLong(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_424818370 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762396744 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_762396744;
                            }
                        } //End block
                        else
    if(fname.compareTo("boolean") == 0)                        
                        {
    if(f.getBoolean(this) != g.getBoolean(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_630499343 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_304467032 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_304467032;
                            }
                        } //End block
                        else
    if(fname.compareTo("double") == 0)                        
                        {
    if(f.getDouble(this) != g.getDouble(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_826675311 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_686315193 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_686315193;
                            }
                        } //End block
                        else
    if(fname.compareTo("float") == 0)                        
                        {
    if(f.getFloat(this) != g.getFloat(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1140417258 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660949861 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_660949861;
                            }
                        } //End block
                    } //End block
                    else
                    {
                        Object myObj = f.get(this);
                        Object hisObj = g.get(that);
    if(hisObj != null && myObj == null)                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_286327646 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1424897870 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1424897870;
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
                            boolean var68934A3E9455FA72420237EB05902327_1981873724 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1087070321 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1087070321;
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
                            boolean var68934A3E9455FA72420237EB05902327_1588688185 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1331780899 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1331780899;
                            }
                        } //End block
                        else
    if(GenericObject.isMySubclass(myObj.getClass())
                                && !((GenericObject) myObj).match(hisObj))                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_301547030 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814408720 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_814408720;
                        }
                        else
    if(GenericObjectList.isMySubclass(myObj.getClass())
                                && !((GenericObjectList) myObj).match(hisObj))                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_106475448 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1455117078 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1455117078;
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
        boolean varB326B5062B2F0E69046810717534CB09_1594036887 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_547080154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_547080154;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.135 -0400", hash_original_method = "8F6462E23806D652AB2FB8FE10D0061F", hash_generated_method = "46DA66600D8B109585785E2A70987E01")
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
String var8D11C2D110975896438D6F91C60E6D6F_1924800161 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_1924800161.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_1924800161;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.149 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "3015754AD1277BEBF84036C90F24FB59")
    public String debugDump(int indent) {
        addTaint(indent);
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
String varF9E19AD6135C970F387F77C6F3DE4477_2058239018 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_2058239018.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_2058239018;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.150 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "B6ECE04BF4200EA3734123DBD1261EC5")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_2120514142 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_2120514142.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_2120514142;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.150 -0400", hash_original_field = "84814EA1316201D7682A1857E6DA438C", hash_generated_field = "46C2887731A82D54499D991777D692CF")

    protected static final String CORE_PACKAGE = PackageNames.CORE_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.150 -0400", hash_original_field = "D44CF5167E8CD4A0B8C7121141E5F5CA", hash_generated_field = "594D4223DA826D2239E3278060CF9C1D")

    protected static final String NET_PACKAGE = PackageNames.NET_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.150 -0400", hash_original_field = "A42FB06745B0689D818929080E18E2A6", hash_generated_field = "F9F431553B7EF5ED564BB76D3511A1C4")

    protected static final String PARSER_PACKAGE = PackageNames.PARSER_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.150 -0400", hash_original_field = "955EEDB20D590A1A9DC57A6B4C9C2524", hash_generated_field = "E0F49F8A6EC1F0FC10D150214707E15F")

    protected static final String UDP = "udp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "E7E305FD91DFAD258D05CEF692A3FDA3", hash_generated_field = "65B8023757C289C256D8CDF02D79EEAB")

    protected static final String TCP = "tcp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "BB60D14484559A8FB47EEE8E87D56416", hash_generated_field = "10ACFD285BFF968264526433D33B1AB0")

    protected static final String TRANSPORT = "transport";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "8B41FABA7E13C027203E37D1A20ED7C7", hash_generated_field = "ADFC98A2AB6C9BE4ECB3DA0DC42944C8")

    protected static final String METHOD = "method";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "2F525D63281BEC6D002BC4263B4225A0", hash_generated_field = "0BD3E85D4B799F1CA9E1ECA350C946CC")

    protected static final String USER = "user";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "D691F6CBCE83242F8E1801A18FE78496", hash_generated_field = "F56AC3F2C0064F9B98AE234242186C42")

    protected static final String PHONE = "phone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "7C093FAE4691A03AB86E86898A11746D", hash_generated_field = "7A87650302C67C9E28DB90C3D1ED745E")

    protected static final String MADDR = "maddr";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "EEECE76344C3913E85967FB61CC6ACB5", hash_generated_field = "9521875EFD450C64F6E61B84A224F274")

    protected static final String TTL = "ttl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "89D96C07757E423BC566F92B191778CF", hash_generated_field = "19B2449D5B180111495A6203819463E0")

    protected static final String LR = "lr";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "60903E31AE0F2D927C93F88555EA8B06", hash_generated_field = "6F3518A2B8F324537D0A7D82E19056BF")

    protected static final String SIP = "sip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "BB1888B5D56BD607ED3A6833F0434370", hash_generated_field = "2812DB6997C42C0FAEB5CA6CA624A89E")

    protected static final String SIPS = "sips";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "02AC7105BC9267167A7FE52691A37BAB", hash_generated_field = "9E085E7B626954040FA4C29E128B38D1")

    protected static final String TLS = "tls";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.151 -0400", hash_original_field = "86623E8163A910A0C283102686E462A2", hash_generated_field = "0792D95F056BB55ABBA0C958C9203C97")

    protected static final String GRUU = "gr";
}

