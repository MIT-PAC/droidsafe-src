package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.GenericObject;
import gov.nist.core.GenericObjectList;
import gov.nist.core.InternalErrorHandler;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class SIPObject extends GenericObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.397 -0400", hash_original_method = "F2415C91D035ABB45320678077A163BD", hash_generated_method = "90A009E0ECCD723DE48100CDD9B85812")
    protected  SIPObject() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.397 -0400", hash_original_method = "BC21211AABBF5A727CE8CE0C8A5F5ABC", hash_generated_method = "07941E956AE5C75C7E5403F7A3FDE19E")
    public void dbgPrint() {
        super.dbgPrint();
        // ---------- Original Method ----------
        //super.dbgPrint();
    }

    
    public abstract String encode();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.398 -0400", hash_original_method = "23BD5BF1494AAB1936A4882B6C7896EB", hash_generated_method = "208E8B8A72D73600AA1860159B874DF6")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer var7758A6E5CA5A3C31A1AD4D3B1CB2BC22_1553383214 =         buffer.append(encode());
        var7758A6E5CA5A3C31A1AD4D3B1CB2BC22_1553383214.addTaint(taint);
        return var7758A6E5CA5A3C31A1AD4D3B1CB2BC22_1553383214;
        // ---------- Original Method ----------
        //return buffer.append(encode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.400 -0400", hash_original_method = "C625D56C28F833180267D6A3AE3C9C8E", hash_generated_method = "F8428AB0E13FC5222FB5DA08A855F4A0")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_179063031 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098948495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098948495;
        }
        SIPObject that = (SIPObject) other;
        Class myclass = this.getClass();
        Class hisclass = other.getClass();
        while
(true)        
        {
            Field[] fields = myclass.getDeclaredFields();
    if(!hisclass.equals(myclass))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1215330159 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899683079 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899683079;
            }
            Field[] hisfields = hisclass.getDeclaredFields();
for(int i = 0;i < fields.length;i++)
            {
                Field f = fields[i];
                Field g = hisfields[i];
                int modifier = f.getModifiers();
    if((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)                
                continue;
                Class fieldType = f.getType();
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
                            boolean var68934A3E9455FA72420237EB05902327_1452562137 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982274202 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982274202;
                            }
                        } //End block
                        else
    if(fname.compareTo("short") == 0)                        
                        {
    if(f.getShort(this) != g.getShort(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_902440580 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973359159 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973359159;
                            }
                        } //End block
                        else
    if(fname.compareTo("char") == 0)                        
                        {
    if(f.getChar(this) != g.getChar(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1780468472 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449853096 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_449853096;
                            }
                        } //End block
                        else
    if(fname.compareTo("long") == 0)                        
                        {
    if(f.getLong(this) != g.getLong(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_212192469 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_33290337 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_33290337;
                            }
                        } //End block
                        else
    if(fname.compareTo("boolean") == 0)                        
                        {
    if(f.getBoolean(this) != g.getBoolean(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1354767271 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973071364 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973071364;
                            }
                        } //End block
                        else
    if(fname.compareTo("double") == 0)                        
                        {
    if(f.getDouble(this) != g.getDouble(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_884861589 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1422286221 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1422286221;
                            }
                        } //End block
                        else
    if(fname.compareTo("float") == 0)                        
                        {
    if(f.getFloat(this) != g.getFloat(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1341980626 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1728254929 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1728254929;
                            }
                        } //End block
                    } //End block
                    else
    if(g.get(that) == f.get(this))                    
                    continue;
                    else
    if(f.get(this) == null && g.get(that) != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1014115271 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1271987840 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1271987840;
                    }
                    else
    if(g.get(that) == null && f.get(this) != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1447310916 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_236746308 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_236746308;
                    }
                    else
    if(!f.get(this).equals(g.get(that)))                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1699213268 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_3118267 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_3118267;
                    }
                } //End block
                catch (IllegalAccessException ex1)
                {
                    System.out.println("accessed field " + fieldName);
                    System.out.println("modifier  " + modifier);
                    System.out.println("modifier.private  " + Modifier.PRIVATE);
                    InternalErrorHandler.handleException(ex1);
                } //End block
            } //End block
    if(myclass.equals(SIPObject.class))            
            break;
            else
            {
                myclass = myclass.getSuperclass();
                hisclass = hisclass.getSuperclass();
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1635642110 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836753410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836753410;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.404 -0400", hash_original_method = "060178C12313F034DC0CE078907A1CE4", hash_generated_method = "D8E5994A7800913F2907FD574942319E")
    public boolean match(Object other) {
        addTaint(other.getTaint());
    if(other == null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1431760187 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174196340 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174196340;
        } //End block
    if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1986765726 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1977544714 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1977544714;
        }
        GenericObject that = (GenericObject) other;
        Class myclass = this.getClass();
        Class hisclass = other.getClass();
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
                Class fieldType = f.getType();
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
                            boolean var68934A3E9455FA72420237EB05902327_306206360 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1151038119 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1151038119;
                            }
                        } //End block
                        else
    if(fname.compareTo("short") == 0)                        
                        {
    if(f.getShort(this) != g.getShort(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_96462135 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1877844892 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1877844892;
                            }
                        } //End block
                        else
    if(fname.compareTo("char") == 0)                        
                        {
    if(f.getChar(this) != g.getChar(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_175216727 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443585169 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_443585169;
                            }
                        } //End block
                        else
    if(fname.compareTo("long") == 0)                        
                        {
    if(f.getLong(this) != g.getLong(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_241863076 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1081580350 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1081580350;
                            }
                        } //End block
                        else
    if(fname.compareTo("boolean") == 0)                        
                        {
    if(f.getBoolean(this) != g.getBoolean(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_528685259 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1168919414 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1168919414;
                            }
                        } //End block
                        else
    if(fname.compareTo("double") == 0)                        
                        {
    if(f.getDouble(this) != g.getDouble(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1646997789 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1693982134 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1693982134;
                            }
                        } //End block
                        else
    if(fname.compareTo("float") == 0)                        
                        {
    if(f.getFloat(this) != g.getFloat(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_2025102222 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2011011876 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2011011876;
                            }
                        } //End block
                        else
                        {
                            InternalErrorHandler.handleException(
                                "unknown type");
                        } //End block
                    } //End block
                    else
                    {
                        Object myObj = f.get(this);
                        Object hisObj = g.get(that);
    if(hisObj != null && myObj == null)                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_1187785575 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867205868 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867205868;
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
    if((((String) hisObj).trim()).equals(""))                            
                            continue;
    if(((String) myObj)
                                .compareToIgnoreCase((String) hisObj)
                                != 0)                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_198951106 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2093026178 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2093026178;
                            }
                        } //End block
                        else
    if(hisObj != null
                                && GenericObject.isMySubclass(myObj.getClass())
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
                            boolean var68934A3E9455FA72420237EB05902327_282607840 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649658056 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_649658056;
                            }
                        } //End block
                        else
    if(GenericObject.isMySubclass(myObj.getClass())
                                && !((GenericObject) myObj).match(hisObj))                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_1529409516 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922376815 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_922376815;
                        }
                        else
    if(GenericObjectList.isMySubclass(myObj.getClass())
                                && !((GenericObjectList) myObj).match(hisObj))                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_1308391431 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44344770 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_44344770;
                        }
                    } //End block
                } //End block
                catch (IllegalAccessException ex1)
                {
                    InternalErrorHandler.handleException(ex1);
                } //End block
            } //End block
    if(myclass.equals(SIPObject.class))            
            break;
            else
            {
                myclass = myclass.getSuperclass();
                hisclass = hisclass.getSuperclass();
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1283655679 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1701721617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1701721617;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.407 -0400", hash_original_method = "8C7E8103DEE2671781774C37BABA3BB5", hash_generated_method = "A8F5B732F90CAB36133F68114FFCA5B3")
    public String debugDump() {
        stringRepresentation = "";
        Class myclass = getClass();
        sprint(myclass.getName());
        sprint("{");
        Field[] fields = myclass.getDeclaredFields();
for(int i = 0;i < fields.length;i++)
        {
            Field f = fields[i];
            int modifier = f.getModifiers();
    if((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)            
            continue;
            Class fieldType = f.getType();
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
String var8D11C2D110975896438D6F91C60E6D6F_91847864 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_91847864.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_91847864;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.409 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "9E784F5A1E55B17FF2B7EC47E5633BD1")
    public String debugDump(int indent) {
        addTaint(indent);
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
String varF9E19AD6135C970F387F77C6F3DE4477_862223103 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_862223103.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_862223103;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.409 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "A8F0E6EA96099695703075A86C4A3000")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_2084241096 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_2084241096.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_2084241096;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
}

