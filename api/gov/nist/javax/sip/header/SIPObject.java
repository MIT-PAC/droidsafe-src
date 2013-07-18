package gov.nist.javax.sip.header;

// Droidsafe Imports
import gov.nist.core.GenericObject;
import gov.nist.core.GenericObjectList;
import gov.nist.core.InternalErrorHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class SIPObject extends GenericObject {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.449 -0400", hash_original_method = "F2415C91D035ABB45320678077A163BD", hash_generated_method = "90A009E0ECCD723DE48100CDD9B85812")
    protected  SIPObject() {
        super();
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.450 -0400", hash_original_method = "BC21211AABBF5A727CE8CE0C8A5F5ABC", hash_generated_method = "07941E956AE5C75C7E5403F7A3FDE19E")
    public void dbgPrint() {
        super.dbgPrint();
        // ---------- Original Method ----------
        //super.dbgPrint();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract String encode();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.450 -0400", hash_original_method = "23BD5BF1494AAB1936A4882B6C7896EB", hash_generated_method = "DFDDEF7511A9BD4C3806E1BA4634E7ED")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer var7758A6E5CA5A3C31A1AD4D3B1CB2BC22_2063165486 =         buffer.append(encode());
        var7758A6E5CA5A3C31A1AD4D3B1CB2BC22_2063165486.addTaint(taint);
        return var7758A6E5CA5A3C31A1AD4D3B1CB2BC22_2063165486;
        // ---------- Original Method ----------
        //return buffer.append(encode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.453 -0400", hash_original_method = "C625D56C28F833180267D6A3AE3C9C8E", hash_generated_method = "84602015D339249F758BBFE31456FD09")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_557361456 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301421607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301421607;
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
            boolean var68934A3E9455FA72420237EB05902327_691028500 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_118551298 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_118551298;
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
                            boolean var68934A3E9455FA72420237EB05902327_1046076982 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764170146 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764170146;
                            }
                        } //End block
                        else
                        if(fname.compareTo("short") == 0)                        
                        {
                            if(f.getShort(this) != g.getShort(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1987348433 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141170576 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141170576;
                            }
                        } //End block
                        else
                        if(fname.compareTo("char") == 0)                        
                        {
                            if(f.getChar(this) != g.getChar(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1186043982 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1283380289 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1283380289;
                            }
                        } //End block
                        else
                        if(fname.compareTo("long") == 0)                        
                        {
                            if(f.getLong(this) != g.getLong(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_567105785 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_973892479 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_973892479;
                            }
                        } //End block
                        else
                        if(fname.compareTo("boolean") == 0)                        
                        {
                            if(f.getBoolean(this) != g.getBoolean(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1076967734 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_111411886 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_111411886;
                            }
                        } //End block
                        else
                        if(fname.compareTo("double") == 0)                        
                        {
                            if(f.getDouble(this) != g.getDouble(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1076481536 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366819589 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_366819589;
                            }
                        } //End block
                        else
                        if(fname.compareTo("float") == 0)                        
                        {
                            if(f.getFloat(this) != g.getFloat(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1469481578 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213822291 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213822291;
                            }
                        } //End block
                    } //End block
                    else
                    if(g.get(that) == f.get(this))                    
                    continue;
                    else
                    if(f.get(this) == null && g.get(that) != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_556766350 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_405646053 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_405646053;
                    }
                    else
                    if(g.get(that) == null && f.get(this) != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1276772077 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_112979963 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_112979963;
                    }
                    else
                    if(!f.get(this).equals(g.get(that)))                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1866816654 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720645374 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720645374;
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
        boolean varB326B5062B2F0E69046810717534CB09_172287983 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766658687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_766658687;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.458 -0400", hash_original_method = "060178C12313F034DC0CE078907A1CE4", hash_generated_method = "4DF1C487ADE3094556FFE899C15CC9E9")
    public boolean match(Object other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_255448499 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517510635 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_517510635;
        } //End block
        if(!this.getClass().equals(other.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_733224049 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2125156470 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2125156470;
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
                            boolean var68934A3E9455FA72420237EB05902327_153813666 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763055633 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_763055633;
                            }
                        } //End block
                        else
                        if(fname.compareTo("short") == 0)                        
                        {
                            if(f.getShort(this) != g.getShort(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1219555851 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1293885926 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1293885926;
                            }
                        } //End block
                        else
                        if(fname.compareTo("char") == 0)                        
                        {
                            if(f.getChar(this) != g.getChar(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_764131326 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131384509 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131384509;
                            }
                        } //End block
                        else
                        if(fname.compareTo("long") == 0)                        
                        {
                            if(f.getLong(this) != g.getLong(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1395918801 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_559220741 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_559220741;
                            }
                        } //End block
                        else
                        if(fname.compareTo("boolean") == 0)                        
                        {
                            if(f.getBoolean(this) != g.getBoolean(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_1821667622 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_459190953 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_459190953;
                            }
                        } //End block
                        else
                        if(fname.compareTo("double") == 0)                        
                        {
                            if(f.getDouble(this) != g.getDouble(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_848509132 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556778853 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556778853;
                            }
                        } //End block
                        else
                        if(fname.compareTo("float") == 0)                        
                        {
                            if(f.getFloat(this) != g.getFloat(that))                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_663855374 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916228905 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916228905;
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
                        boolean var68934A3E9455FA72420237EB05902327_510596550 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746793874 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746793874;
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
                            boolean var68934A3E9455FA72420237EB05902327_1009108151 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1025740032 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1025740032;
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
                            boolean var68934A3E9455FA72420237EB05902327_1406218976 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_542640240 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_542640240;
                            }
                        } //End block
                        else
                        if(GenericObject.isMySubclass(myObj.getClass())
                                && !((GenericObject) myObj).match(hisObj))                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_848820339 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74590681 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_74590681;
                        }
                        else
                        if(GenericObjectList.isMySubclass(myObj.getClass())
                                && !((GenericObjectList) myObj).match(hisObj))                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_2111851781 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1861569776 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1861569776;
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
        boolean varB326B5062B2F0E69046810717534CB09_310460159 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682602554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682602554;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.461 -0400", hash_original_method = "8C7E8103DEE2671781774C37BABA3BB5", hash_generated_method = "C0CDED104083A96C84619A7CDA54C0CE")
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
String var8D11C2D110975896438D6F91C60E6D6F_1261597753 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_1261597753.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_1261597753;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.463 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "989A55B4CEB4B80F7D39AE4F814777BB")
    public String debugDump(int indent) {
        addTaint(indent);
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
String varF9E19AD6135C970F387F77C6F3DE4477_629488332 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_629488332.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_629488332;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.463 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "9C0B4655B7D6393FB41F4CC4FA1C4B36")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_123782198 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_123782198.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_123782198;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
}

