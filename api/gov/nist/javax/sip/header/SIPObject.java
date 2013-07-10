package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.GenericObject;
import gov.nist.core.GenericObjectList;
import gov.nist.core.InternalErrorHandler;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class SIPObject extends GenericObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.593 -0400", hash_original_method = "F2415C91D035ABB45320678077A163BD", hash_generated_method = "90A009E0ECCD723DE48100CDD9B85812")
    protected  SIPObject() {
        super();
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.593 -0400", hash_original_method = "BC21211AABBF5A727CE8CE0C8A5F5ABC", hash_generated_method = "07941E956AE5C75C7E5403F7A3FDE19E")
    public void dbgPrint() {
        super.dbgPrint();
        
        
    }

    
    public abstract String encode();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.593 -0400", hash_original_method = "23BD5BF1494AAB1936A4882B6C7896EB", hash_generated_method = "4DBD279AC19AE3A94008A9C1C64AEA3A")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1897792634 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1897792634 = buffer.append(encode());
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1897792634.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1897792634;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.595 -0400", hash_original_method = "C625D56C28F833180267D6A3AE3C9C8E", hash_generated_method = "83DE499A597B91C911F89CDD567C334D")
    public boolean equals(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_996668594 = (!this.getClass().equals(other.getClass()));
        } 
        SIPObject that = (SIPObject) other;
        Class myclass = this.getClass();
        Class hisclass = other.getClass();
        {
            Field[] fields = myclass.getDeclaredFields();
            {
                boolean var9ADDFA0B18F8F828C161936DB04CEFF2_823828603 = (!hisclass.equals(myclass));
            } 
            Field[] hisfields = hisclass.getDeclaredFields();
            {
                int i = 0;
                {
                    Field f = fields[i];
                    Field g = hisfields[i];
                    int modifier = f.getModifiers();
                    Class fieldType = f.getType();
                    String fieldName = f.getName();
                    {
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_1597879054 = (fieldName.compareTo("stringRepresentation") == 0);
                    } 
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_1103785968 = (fieldName.compareTo("indentation") == 0);
                    } 
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_450272553 = (fieldType.isPrimitive());
                            {
                                String fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_1741161713 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_14026587 = (f.getInt(this) != g.getInt(that));
                                        } 
                                    } 
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_632978897 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_1170349569 = (f.getShort(this) != g.getShort(that));
                                            } 
                                        } 
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_270345826 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_1237097844 = (f.getChar(this) != g.getChar(that));
                                                } 
                                            } 
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_2078546403 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_2030399337 = (f.getLong(this) != g.getLong(that));
                                                    } 
                                                } 
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_2144542424 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_840624044 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } 
                                                    } 
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_612800752 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_1047426010 = (f.getDouble(this) != g.getDouble(that));
                                                            } 
                                                        } 
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_1496117071 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_1877163806 = (f.getFloat(this) != g.getFloat(that));
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
                                boolean varAA8F4E7F9752016DF7A866D138AF57F2_196399766 = (g.get(that) == f.get(this));
                                {
                                    boolean var77209C918A38A144D72382BEE175E0D9_328411212 = (f.get(this) == null && g.get(that) != null);
                                    {
                                        boolean var38EA3AAB13A9E43EC20C16903B7464A5_516450279 = (g.get(that) == null && f.get(this) != null);
                                        {
                                            boolean var40760574C0FFA80349F6AC8002CC0D1A_547594954 = (!f.get(this).equals(g.get(that)));
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    catch (IllegalAccessException ex1)
                    {
                        System.out.println("accessed field " + fieldName);
                        System.out.println("modifier  " + modifier);
                        System.out.println("modifier.private  " + Modifier.PRIVATE);
                        InternalErrorHandler.handleException(ex1);
                    } 
                } 
            } 
            {
                boolean varB5EAA67C83B99E360F39896EE40AADA7_6411106 = (myclass.equals(SIPObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } 
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1534284326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1534284326;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.597 -0400", hash_original_method = "060178C12313F034DC0CE078907A1CE4", hash_generated_method = "31DD8AF822538846751AE9AD30CA9CC0")
    public boolean match(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_855640684 = (!this.getClass().equals(other.getClass()));
        } 
        GenericObject that = (GenericObject) other;
        Class myclass = this.getClass();
        Class hisclass = other.getClass();
        {
            Field[] fields = myclass.getDeclaredFields();
            Field[] hisfields = hisclass.getDeclaredFields();
            {
                int i = 0;
                {
                    Field f = fields[i];
                    Field g = hisfields[i];
                    int modifier = f.getModifiers();
                    Class fieldType = f.getType();
                    String fieldName = f.getName();
                    {
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_1327686886 = (fieldName.compareTo("stringRepresentation") == 0);
                    } 
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_931607498 = (fieldName.compareTo("indentation") == 0);
                    } 
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_684928555 = (fieldType.isPrimitive());
                            {
                                String fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_1324947868 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_305843044 = (f.getInt(this) != g.getInt(that));
                                        } 
                                    } 
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_872453152 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_1454683454 = (f.getShort(this) != g.getShort(that));
                                            } 
                                        } 
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_1077028497 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_1294864906 = (f.getChar(this) != g.getChar(that));
                                                } 
                                            } 
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_1404170471 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_1848767300 = (f.getLong(this) != g.getLong(that));
                                                    } 
                                                } 
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_1946436166 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_1799535230 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } 
                                                    } 
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_659235890 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_346631178 = (f.getDouble(this) != g.getDouble(that));
                                                            } 
                                                        } 
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_2125740081 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_1629923054 = (f.getFloat(this) != g.getFloat(that));
                                                                } 
                                                            } 
                                                            {
                                                                InternalErrorHandler.handleException(
                                "unknown type");
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
                                        boolean varE494E29739BB35A1FB64E1E8FE21BE78_389648036 = ((((String) hisObj).trim()).equals(""));
                                    } 
                                    {
                                        boolean varDE40D545EC09CF05DB34B16AE2D8BFAD_2065168300 = (((String) myObj)
                                .compareToIgnoreCase((String) hisObj)
                                != 0);
                                    } 
                                } 
                                {
                                    boolean var49F0B31231A0DE4891AB287D1C5C305A_341010637 = (hisObj != null
                                && GenericObject.isMySubclass(myObj.getClass())
                                && GenericObject.isMySubclass(hisObj.getClass())
                                && myObj.getClass().equals(hisObj.getClass())
                                && ((GenericObject) hisObj).getMatcher()
                                    != null);
                                    {
                                        String myObjEncoded = ((GenericObject) myObj).encode();
                                        boolean retval = ((GenericObject) hisObj).getMatcher().match(
                                    myObjEncoded);
                                    } 
                                    {
                                        boolean var23E104026FF8191A6303BED8A98BF008_624421229 = (GenericObject.isMySubclass(myObj.getClass())
                                && !((GenericObject) myObj).match(hisObj));
                                        {
                                            boolean var2386E6059110DC674FEC38F1CD1B8812_1676803907 = (GenericObjectList.isMySubclass(myObj.getClass())
                                && !((GenericObjectList) myObj).match(hisObj));
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
                boolean varB5EAA67C83B99E360F39896EE40AADA7_730561149 = (myclass.equals(SIPObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } 
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_818958740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_818958740;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.600 -0400", hash_original_method = "8C7E8103DEE2671781774C37BABA3BB5", hash_generated_method = "32094651D5A83E2957718D5CF66BDA04")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_736442006 = null; 
        stringRepresentation = "";
        Class myclass = getClass();
        sprint(myclass.getName());
        sprint("{");
        Field[] fields = myclass.getDeclaredFields();
        {
            int i = 0;
            {
                Field f = fields[i];
                int modifier = f.getModifiers();
                Class fieldType = f.getType();
                String fieldName = f.getName();
                {
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_2134670497 = (fieldName.compareTo("stringRepresentation") == 0);
                } 
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_1970367400 = (fieldName.compareTo("indentation") == 0);
                } 
                sprint(fieldName + ":");
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_145528313 = (fieldType.isPrimitive());
                        {
                            String fname = fieldType.toString();
                            sprint(fname + ":");
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_1755315776 = (fname.compareTo("int") == 0);
                                {
                                    int intfield = f.getInt(this);
                                    sprint(intfield);
                                } 
                                {
                                    boolean varECBE882B00F953257800779B015A044A_852691479 = (fname.compareTo("short") == 0);
                                    {
                                        short shortField = f.getShort(this);
                                        sprint(shortField);
                                    } 
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_1590662473 = (fname.compareTo("char") == 0);
                                        {
                                            char charField = f.getChar(this);
                                            sprint(charField);
                                        } 
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_1305874629 = (fname.compareTo("long") == 0);
                                            {
                                                long longField = f.getLong(this);
                                                sprint(longField);
                                            } 
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_1312872478 = (fname.compareTo("boolean") == 0);
                                                {
                                                    boolean booleanField = f.getBoolean(this);
                                                    sprint(booleanField);
                                                } 
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_1799974991 = (fname.compareTo("double") == 0);
                                                    {
                                                        double doubleField = f.getDouble(this);
                                                        sprint(doubleField);
                                                    } 
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_964110805 = (fname.compareTo("float") == 0);
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
                            boolean varD5A8092938B037D2C43A6EAD0E6B9173_640907699 = (GenericObject.class.isAssignableFrom(fieldType));
                            {
                                {
                                    boolean varFF6BA6C3E22248032CA1E2ADDB055F70_918734503 = (f.get(this) != null);
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
                                boolean var3D135DF8A6804404B214F5224E4565F6_1514431045 = (GenericObjectList.class.isAssignableFrom(fieldType));
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_816131827 = (f.get(this) != null);
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
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1898885172 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).getClass().getName() + ":");
                                        } 
                                        {
                                            sprint(fieldType.getName() + ":");
                                        } 
                                    } 
                                    sprint("{");
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_2052962093 = (f.get(this) != null);
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
        varB4EAC82CA7396A68D541C85D26508E83_736442006 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_736442006.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_736442006;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.601 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "936D446E6535BF2EEBD60C2D11BEEC91")
    public String debugDump(int indent) {
        String varB4EAC82CA7396A68D541C85D26508E83_981136285 = null; 
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
        varB4EAC82CA7396A68D541C85D26508E83_981136285 = retval;
        addTaint(indent);
        varB4EAC82CA7396A68D541C85D26508E83_981136285.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_981136285;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.601 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "88916FA818A86EF800D6E8B52E84FF3F")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1445292205 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1445292205 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1445292205.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1445292205;
        
        
    }

    
}

