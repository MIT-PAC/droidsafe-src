package gov.nist.javax.sip.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.*;
import java.lang.reflect.*;

public abstract class MessageObject extends GenericObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.838 -0400", hash_original_method = "FC3F0C40EB43CAA923D6D6A1BF0E3847", hash_generated_method = "FBD3BECC71E6B7C197BB97EE9FAE87F0")
    protected  MessageObject() {
        super();
        
    }

    
    public abstract String encode();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.839 -0400", hash_original_method = "BC21211AABBF5A727CE8CE0C8A5F5ABC", hash_generated_method = "07941E956AE5C75C7E5403F7A3FDE19E")
    public void dbgPrint() {
        super.dbgPrint();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.841 -0400", hash_original_method = "0442EC30A54A551F3B539049CBAE5178", hash_generated_method = "C52FF26A7F7E36550DC4E11DF9ED6E54")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_253742801 = null; 
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
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_8559303 = (fieldName.compareTo("stringRepresentation") == 0);
                } 
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_688685846 = (fieldName.compareTo("indentation") == 0);
                } 
                sprint(fieldName + ":");
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_2078004554 = (fieldType.isPrimitive());
                        {
                            String fname = fieldType.toString();
                            sprint(fname + ":");
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_154928328 = (fname.compareTo("int") == 0);
                                {
                                    int intfield = f.getInt(this);
                                    sprint(intfield);
                                } 
                                {
                                    boolean varECBE882B00F953257800779B015A044A_862069026 = (fname.compareTo("short") == 0);
                                    {
                                        short shortField = f.getShort(this);
                                        sprint(shortField);
                                    } 
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_1015384662 = (fname.compareTo("char") == 0);
                                        {
                                            char charField = f.getChar(this);
                                            sprint(charField);
                                        } 
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_1215214627 = (fname.compareTo("long") == 0);
                                            {
                                                long longField = f.getLong(this);
                                                sprint(longField);
                                            } 
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_936222920 = (fname.compareTo("boolean") == 0);
                                                {
                                                    boolean booleanField = f.getBoolean(this);
                                                    sprint(booleanField);
                                                } 
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_887546990 = (fname.compareTo("double") == 0);
                                                    {
                                                        double doubleField = f.getDouble(this);
                                                        sprint(doubleField);
                                                    } 
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_869434516 = (fname.compareTo("float") == 0);
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
                            boolean var4710646E1B34209A233C9F238DEA3628_1101481833 = (GenericObject.class.isAssignableFrom(
                        fieldType));
                            {
                                {
                                    boolean varFF6BA6C3E22248032CA1E2ADDB055F70_6839635 = (f.get(this) != null);
                                    {
                                        sprint(
                            ((GenericObject) f.get(this)).debugDump(
                                this.indentation + 1));
                                    } 
                                    {
                                        sprint("<null>");
                                    } 
                                } 
                            } 
                            {
                                boolean varCCEC0D420B9344637ABB81D67CB389F3_2080967735 = (GenericObjectList.class.isAssignableFrom(
                        fieldType));
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_164384723 = (f.get(this) != null);
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
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_453969542 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).getClass().getName() + ":");
                                        } 
                                        {
                                            sprint(fieldType.getName() + ":");
                                        } 
                                    } 
                                    sprint("{");
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_2102324421 = (f.get(this) != null);
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
            } 
        } 
        sprint("}");
        varB4EAC82CA7396A68D541C85D26508E83_253742801 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_253742801.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_253742801;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.843 -0400", hash_original_method = "FAEFAEB9988F2842518A414FFF4FC663", hash_generated_method = "FBE4FDCC4C15B1935ED3E1AB39420E04")
    public String dbgPrint(int indent) {
        String varB4EAC82CA7396A68D541C85D26508E83_176036717 = null; 
        int save = indentation;
        indentation = indent;
        String retval = this.toString();
        indentation = save;
        varB4EAC82CA7396A68D541C85D26508E83_176036717 = retval;
        addTaint(indent);
        varB4EAC82CA7396A68D541C85D26508E83_176036717.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_176036717;
        
        
        
        
        
        
    }

    
}

