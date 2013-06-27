package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import java.lang.reflect.*;

public abstract class MessageObject extends GenericObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.790 -0400", hash_original_method = "FC3F0C40EB43CAA923D6D6A1BF0E3847", hash_generated_method = "FBD3BECC71E6B7C197BB97EE9FAE87F0")
    protected  MessageObject() {
        super();
        // ---------- Original Method ----------
    }

    
    public abstract String encode();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.790 -0400", hash_original_method = "BC21211AABBF5A727CE8CE0C8A5F5ABC", hash_generated_method = "07941E956AE5C75C7E5403F7A3FDE19E")
    public void dbgPrint() {
        super.dbgPrint();
        // ---------- Original Method ----------
        //super.dbgPrint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.812 -0400", hash_original_method = "0442EC30A54A551F3B539049CBAE5178", hash_generated_method = "77D28736C95986530E4DC87BFD990103")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_761338454 = null; //Variable for return #1
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
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_1569051669 = (fieldName.compareTo("stringRepresentation") == 0);
                } //End collapsed parenthetic
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_590590937 = (fieldName.compareTo("indentation") == 0);
                } //End collapsed parenthetic
                sprint(fieldName + ":");
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_1727852372 = (fieldType.isPrimitive());
                        {
                            String fname;
                            fname = fieldType.toString();
                            sprint(fname + ":");
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_1246091431 = (fname.compareTo("int") == 0);
                                {
                                    int intfield;
                                    intfield = f.getInt(this);
                                    sprint(intfield);
                                } //End block
                                {
                                    boolean varECBE882B00F953257800779B015A044A_1308821592 = (fname.compareTo("short") == 0);
                                    {
                                        short shortField;
                                        shortField = f.getShort(this);
                                        sprint(shortField);
                                    } //End block
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_219533434 = (fname.compareTo("char") == 0);
                                        {
                                            char charField;
                                            charField = f.getChar(this);
                                            sprint(charField);
                                        } //End block
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_1300141945 = (fname.compareTo("long") == 0);
                                            {
                                                long longField;
                                                longField = f.getLong(this);
                                                sprint(longField);
                                            } //End block
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_139818765 = (fname.compareTo("boolean") == 0);
                                                {
                                                    boolean booleanField;
                                                    booleanField = f.getBoolean(this);
                                                    sprint(booleanField);
                                                } //End block
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_1420287615 = (fname.compareTo("double") == 0);
                                                    {
                                                        double doubleField;
                                                        doubleField = f.getDouble(this);
                                                        sprint(doubleField);
                                                    } //End block
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_2042751804 = (fname.compareTo("float") == 0);
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
                            boolean var4710646E1B34209A233C9F238DEA3628_740528799 = (GenericObject.class.isAssignableFrom(
                        fieldType));
                            {
                                {
                                    boolean varFF6BA6C3E22248032CA1E2ADDB055F70_1315071480 = (f.get(this) != null);
                                    {
                                        sprint(
                            ((GenericObject) f.get(this)).debugDump(
                                this.indentation + 1));
                                    } //End block
                                    {
                                        sprint("<null>");
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean varCCEC0D420B9344637ABB81D67CB389F3_800541282 = (GenericObjectList.class.isAssignableFrom(
                        fieldType));
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1782115462 = (f.get(this) != null);
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
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1933493616 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).getClass().getName() + ":");
                                        } //End block
                                        {
                                            sprint(fieldType.getName() + ":");
                                        } //End block
                                    } //End collapsed parenthetic
                                    sprint("{");
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_893842679 = (f.get(this) != null);
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
            } //End block
        } //End collapsed parenthetic
        sprint("}");
        varB4EAC82CA7396A68D541C85D26508E83_761338454 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_761338454.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_761338454;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.813 -0400", hash_original_method = "FAEFAEB9988F2842518A414FFF4FC663", hash_generated_method = "62327E59F6F17989B1E8E6FD9ACF1493")
    public String dbgPrint(int indent) {
        String varB4EAC82CA7396A68D541C85D26508E83_379757009 = null; //Variable for return #1
        int save;
        save = indentation;
        indentation = indent;
        String retval;
        retval = this.toString();
        indentation = save;
        varB4EAC82CA7396A68D541C85D26508E83_379757009 = retval;
        addTaint(indent);
        varB4EAC82CA7396A68D541C85D26508E83_379757009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_379757009;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.toString();
        //indentation = save;
        //return retval;
    }

    
}

