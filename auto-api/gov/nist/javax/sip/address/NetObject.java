package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import java.lang.reflect.*;

public abstract class NetObject extends GenericObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.541 -0400", hash_original_method = "C4442EA667C9A2BEB67B2F1E6DC6F09B", hash_generated_method = "DA7CD8F57514C7E6D13831C88B45DC81")
    public  NetObject() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.561 -0400", hash_original_method = "26A4AB68F41643C912C51D77CC375C44", hash_generated_method = "44C97B97E433F00C99D5F28CBC7F0011")
    public boolean equals(Object that) {
        {
            boolean var07F02797FD62DC585D5DCA22B5D2ED2C_1090609914 = (!this.getClass().equals(that.getClass()));
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
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_1201991955 = (fieldName.compareTo("stringRepresentation") == 0);
                    } //End collapsed parenthetic
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_1059595262 = (fieldName.compareTo("indentation") == 0);
                    } //End collapsed parenthetic
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_1325477003 = (fieldType.isPrimitive());
                            {
                                String fname;
                                fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_411674927 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_2024442253 = (f.getInt(this) != g.getInt(that));
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_196634976 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_1401986093 = (f.getShort(this) != g.getShort(that));
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_1142054333 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_1464486229 = (f.getChar(this) != g.getChar(that));
                                                } //End collapsed parenthetic
                                            } //End block
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_1713702193 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_114493564 = (f.getLong(this) != g.getLong(that));
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_1609864998 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_601820108 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_862821208 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_234747735 = (f.getDouble(this) != g.getDouble(that));
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_209503857 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_1185305164 = (f.getFloat(this) != g.getFloat(that));
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
                                boolean varAA8F4E7F9752016DF7A866D138AF57F2_1491663629 = (g.get(that) == f.get(this));
                                {
                                    boolean var77209C918A38A144D72382BEE175E0D9_1011938859 = (f.get(this) == null && g.get(that) != null);
                                    {
                                        boolean var0C64ED638CF950569CE844619B5AA026_1246315945 = (g.get(that) == null && f.get(that) != null);
                                        {
                                            boolean var40760574C0FFA80349F6AC8002CC0D1A_4688215 = (!f.get(this).equals(g.get(that)));
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
                boolean var5E4EA8E50ECDEEF507D9A4D6EDC4CB5B_752736669 = (myclass.equals(NetObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784504857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784504857;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.565 -0400", hash_original_method = "8D936CCD11169852B60D86BE02120DB8", hash_generated_method = "1414E261318E6B2DA6F8C96298D2413F")
    public boolean match(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_439443713 = (!this.getClass().equals(other.getClass()));
        } //End collapsed parenthetic
        GenericObject that;
        that = (GenericObject) other;
        Class<?> hisclass;
        hisclass = other.getClass();
        Class<?> myclass;
        myclass = this.getClass();
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
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_728415735 = (fieldName.compareTo("stringRepresentation") == 0);
                    } //End collapsed parenthetic
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_1196246350 = (fieldName.compareTo("indentation") == 0);
                    } //End collapsed parenthetic
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_918851529 = (fieldType.isPrimitive());
                            {
                                String fname;
                                fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_163065700 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_575210059 = (f.getInt(this) != g.getInt(that));
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_289158633 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_1153781738 = (f.getShort(this) != g.getShort(that));
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_620381793 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_506402871 = (f.getChar(this) != g.getChar(that));
                                                } //End collapsed parenthetic
                                            } //End block
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_1073959115 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_1147313373 = (f.getLong(this) != g.getLong(that));
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_1436090656 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_466045193 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_620177850 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_1335719535 = (f.getDouble(this) != g.getDouble(that));
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_1571083029 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_750455532 = (f.getFloat(this) != g.getFloat(that));
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
                                        boolean varAB8B8601C682E475B385ACEEFDCEE72C_1066201822 = (((String) hisObj).equals(""));
                                    } //End collapsed parenthetic
                                    {
                                        boolean varDE40D545EC09CF05DB34B16AE2D8BFAD_207001795 = (((String) myObj)
                                .compareToIgnoreCase((String) hisObj)
                                != 0);
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean varD4734C60F14F54F732C7FBA072E5A071_1413680105 = (GenericObject.isMySubclass(myObj.getClass())
                                && GenericObject.isMySubclass(hisObj.getClass())
                                && myObj.getClass().equals(hisObj.getClass())
                                && ((GenericObject) hisObj).getMatcher()
                                    != null);
                                    {
                                        String myObjEncoded;
                                        myObjEncoded = ((GenericObject) myObj).encode();
                                        boolean retval;
                                        retval = ((GenericObject) hisObj).getMatcher().match(
                                    myObjEncoded);
                                    } //End block
                                    {
                                        boolean var23E104026FF8191A6303BED8A98BF008_593391394 = (GenericObject.isMySubclass(myObj.getClass())
                                && !((GenericObject) myObj).match(hisObj));
                                        {
                                            boolean var2386E6059110DC674FEC38F1CD1B8812_1749039936 = (GenericObjectList.isMySubclass(myObj.getClass())
                                && !((GenericObjectList) myObj).match(hisObj));
                                        } //End collapsed parenthetic
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
            {
                boolean var5E4EA8E50ECDEEF507D9A4D6EDC4CB5B_1721222547 = (myclass.equals(NetObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_804277922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_804277922;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.609 -0400", hash_original_method = "8F6462E23806D652AB2FB8FE10D0061F", hash_generated_method = "2752309A040F4999C6DB5246AF7E6DED")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_1677808317 = null; //Variable for return #1
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
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_1166858124 = (fieldName.compareTo("stringRepresentation") == 0);
                } //End collapsed parenthetic
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_783533537 = (fieldName.compareTo("indentation") == 0);
                } //End collapsed parenthetic
                sprint(fieldName + ":");
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_1607859738 = (fieldType.isPrimitive());
                        {
                            String fname;
                            fname = fieldType.toString();
                            sprint(fname + ":");
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_702211253 = (fname.compareTo("int") == 0);
                                {
                                    int intfield;
                                    intfield = f.getInt(this);
                                    sprint(intfield);
                                } //End block
                                {
                                    boolean varECBE882B00F953257800779B015A044A_1700516980 = (fname.compareTo("short") == 0);
                                    {
                                        short shortField;
                                        shortField = f.getShort(this);
                                        sprint(shortField);
                                    } //End block
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_668390574 = (fname.compareTo("char") == 0);
                                        {
                                            char charField;
                                            charField = f.getChar(this);
                                            sprint(charField);
                                        } //End block
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_1778757783 = (fname.compareTo("long") == 0);
                                            {
                                                long longField;
                                                longField = f.getLong(this);
                                                sprint(longField);
                                            } //End block
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_1909500626 = (fname.compareTo("boolean") == 0);
                                                {
                                                    boolean booleanField;
                                                    booleanField = f.getBoolean(this);
                                                    sprint(booleanField);
                                                } //End block
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_1618143588 = (fname.compareTo("double") == 0);
                                                    {
                                                        double doubleField;
                                                        doubleField = f.getDouble(this);
                                                        sprint(doubleField);
                                                    } //End block
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_967956771 = (fname.compareTo("float") == 0);
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
                            boolean varD5A8092938B037D2C43A6EAD0E6B9173_397337701 = (GenericObject.class.isAssignableFrom(fieldType));
                            {
                                {
                                    boolean varFF6BA6C3E22248032CA1E2ADDB055F70_1612272899 = (f.get(this) != null);
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
                                boolean var3D135DF8A6804404B214F5224E4565F6_366777064 = (GenericObjectList.class.isAssignableFrom(fieldType));
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_2101232982 = (f.get(this) != null);
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
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1078804147 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).getClass().getName() + ":");
                                        } //End block
                                        {
                                            sprint(fieldType.getName() + ":");
                                        } //End block
                                    } //End collapsed parenthetic
                                    sprint("{");
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_530158339 = (f.get(this) != null);
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
        varB4EAC82CA7396A68D541C85D26508E83_1677808317 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_1677808317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1677808317;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.611 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "505F24D4EDADD552431D4D468A812E3D")
    public String debugDump(int indent) {
        String varB4EAC82CA7396A68D541C85D26508E83_451554696 = null; //Variable for return #1
        int save;
        save = indentation;
        indentation = indent;
        String retval;
        retval = this.debugDump();
        indentation = save;
        varB4EAC82CA7396A68D541C85D26508E83_451554696 = retval;
        addTaint(indent);
        varB4EAC82CA7396A68D541C85D26508E83_451554696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_451554696;
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.611 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "005DD8DBD378F56E40666AF242800AB1")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2109628158 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2109628158 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_2109628158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2109628158;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.611 -0400", hash_original_field = "84814EA1316201D7682A1857E6DA438C", hash_generated_field = "6BD96B7D81159CA9D3C2F8540E822C9E")

    protected static String CORE_PACKAGE = PackageNames.CORE_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.611 -0400", hash_original_field = "D44CF5167E8CD4A0B8C7121141E5F5CA", hash_generated_field = "266E40A7C92F2F60493BD51DA7228CD7")

    protected static String NET_PACKAGE = PackageNames.NET_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.611 -0400", hash_original_field = "A42FB06745B0689D818929080E18E2A6", hash_generated_field = "E9185FC38899FDE55486F5AA683BB171")

    protected static String PARSER_PACKAGE = PackageNames.PARSER_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.611 -0400", hash_original_field = "955EEDB20D590A1A9DC57A6B4C9C2524", hash_generated_field = "B77AAB71CF5C3709B0DBFC5D3F01A19E")

    protected static String UDP = "udp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "E7E305FD91DFAD258D05CEF692A3FDA3", hash_generated_field = "03D9EC78C5964688F0F5950E5A3C216F")

    protected static String TCP = "tcp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "BB60D14484559A8FB47EEE8E87D56416", hash_generated_field = "B5A5294E8DE7177AC8E0537CC2C7668B")

    protected static String TRANSPORT = "transport";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "8B41FABA7E13C027203E37D1A20ED7C7", hash_generated_field = "70231C7D666608E434E5450798DAEBC0")

    protected static String METHOD = "method";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "2F525D63281BEC6D002BC4263B4225A0", hash_generated_field = "4E4F912BF692D2F3B0E6CCA92BD44A05")

    protected static String USER = "user";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "D691F6CBCE83242F8E1801A18FE78496", hash_generated_field = "514869AF51FE00B351913F82A9084CA5")

    protected static String PHONE = "phone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "7C093FAE4691A03AB86E86898A11746D", hash_generated_field = "EB92ABAE4F6AF46E986F50A3710CD3DC")

    protected static String MADDR = "maddr";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "EEECE76344C3913E85967FB61CC6ACB5", hash_generated_field = "217C58A7AB8B4C492701C65FAF5D3684")

    protected static String TTL = "ttl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "89D96C07757E423BC566F92B191778CF", hash_generated_field = "C6CD5228F562BBF638A54DA1E224E3DC")

    protected static String LR = "lr";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "60903E31AE0F2D927C93F88555EA8B06", hash_generated_field = "C3768D44FFB405729027FCCB6366B195")

    protected static String SIP = "sip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "BB1888B5D56BD607ED3A6833F0434370", hash_generated_field = "14B6CEF5E5302FB37451088649A7DA6B")

    protected static String SIPS = "sips";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "02AC7105BC9267167A7FE52691A37BAB", hash_generated_field = "C8E81F4CB17101733B0080DCA4C56B05")

    protected static String TLS = "tls";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.612 -0400", hash_original_field = "86623E8163A910A0C283102686E462A2", hash_generated_field = "8C9BEB850251C0B6086B61EB1F9EDA5E")

    protected static String GRUU = "gr";
}

