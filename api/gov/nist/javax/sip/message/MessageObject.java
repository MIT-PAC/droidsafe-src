package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import java.lang.reflect.*;

public abstract class MessageObject extends GenericObject {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.704 -0400", hash_original_method = "FC3F0C40EB43CAA923D6D6A1BF0E3847", hash_generated_method = "FBD3BECC71E6B7C197BB97EE9FAE87F0")
    protected  MessageObject() {
        super();
        // ---------- Original Method ----------
    }

    
    public abstract String encode();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.705 -0400", hash_original_method = "BC21211AABBF5A727CE8CE0C8A5F5ABC", hash_generated_method = "07941E956AE5C75C7E5403F7A3FDE19E")
    public void dbgPrint() {
        super.dbgPrint();
        // ---------- Original Method ----------
        //super.dbgPrint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.706 -0400", hash_original_method = "0442EC30A54A551F3B539049CBAE5178", hash_generated_method = "F1D84C7AF6929FA5C7FDE7EFB21EF8D7")
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
    if(modifier == Modifier.PRIVATE)            
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
    if(GenericObject.class.isAssignableFrom(
                        fieldType))                
                {
    if(f.get(this) != null)                    
                    {
                        sprint(
                            ((GenericObject) f.get(this)).debugDump(
                                this.indentation + 1));
                    } //End block
                    else
                    {
                        sprint("<null>");
                    } //End block
                } //End block
                else
    if(GenericObjectList.class.isAssignableFrom(
                        fieldType))                
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
String var8D11C2D110975896438D6F91C60E6D6F_1346652654 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_1346652654.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_1346652654;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.709 -0400", hash_original_method = "FAEFAEB9988F2842518A414FFF4FC663", hash_generated_method = "92CC2AE7DB0CF3739B76C6C6B8BAFAE3")
    public String dbgPrint(int indent) {
        addTaint(indent);
        int save = indentation;
        indentation = indent;
        String retval = this.toString();
        indentation = save;
String varF9E19AD6135C970F387F77C6F3DE4477_814198364 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_814198364.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_814198364;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.toString();
        //indentation = save;
        //return retval;
    }

    
}

