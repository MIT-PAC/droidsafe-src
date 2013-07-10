package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.*;
import java.lang.reflect.*;

public abstract class NetObject extends GenericObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.299 -0400", hash_original_method = "C4442EA667C9A2BEB67B2F1E6DC6F09B", hash_generated_method = "DA7CD8F57514C7E6D13831C88B45DC81")
    public  NetObject() {
        super();
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.301 -0400", hash_original_method = "26A4AB68F41643C912C51D77CC375C44", hash_generated_method = "677E0E6F0F97A3C782B688F9989ADB6C")
    public boolean equals(Object that) {
        {
            boolean var07F02797FD62DC585D5DCA22B5D2ED2C_1096674594 = (!this.getClass().equals(that.getClass()));
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
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_784693422 = (fieldName.compareTo("stringRepresentation") == 0);
                    } 
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_1554890990 = (fieldName.compareTo("indentation") == 0);
                    } 
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_1401856673 = (fieldType.isPrimitive());
                            {
                                String fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_431108080 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_78441619 = (f.getInt(this) != g.getInt(that));
                                        } 
                                    } 
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_1799931434 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_774215336 = (f.getShort(this) != g.getShort(that));
                                            } 
                                        } 
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_194982166 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_1147202069 = (f.getChar(this) != g.getChar(that));
                                                } 
                                            } 
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_1310585238 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_1671474609 = (f.getLong(this) != g.getLong(that));
                                                    } 
                                                } 
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_484953939 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_521693637 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } 
                                                    } 
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_367023253 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_528823725 = (f.getDouble(this) != g.getDouble(that));
                                                            } 
                                                        } 
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_1542969001 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_2093227946 = (f.getFloat(this) != g.getFloat(that));
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
                                boolean varAA8F4E7F9752016DF7A866D138AF57F2_994343303 = (g.get(that) == f.get(this));
                                {
                                    boolean var77209C918A38A144D72382BEE175E0D9_2147381761 = (f.get(this) == null && g.get(that) != null);
                                    {
                                        boolean var0C64ED638CF950569CE844619B5AA026_1632192375 = (g.get(that) == null && f.get(that) != null);
                                        {
                                            boolean var40760574C0FFA80349F6AC8002CC0D1A_58961972 = (!f.get(this).equals(g.get(that)));
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
                boolean var5E4EA8E50ECDEEF507D9A4D6EDC4CB5B_908238987 = (myclass.equals(NetObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } 
            } 
        } 
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457770164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457770164;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.303 -0400", hash_original_method = "8D936CCD11169852B60D86BE02120DB8", hash_generated_method = "431C7258D1EF6CDFC0FA87F71A8AD09F")
    public boolean match(Object other) {
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1579251290 = (!this.getClass().equals(other.getClass()));
        } 
        GenericObject that = (GenericObject) other;
        Class<?> hisclass = other.getClass();
        Class<?> myclass = this.getClass();
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
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_177504397 = (fieldName.compareTo("stringRepresentation") == 0);
                    } 
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_204273661 = (fieldName.compareTo("indentation") == 0);
                    } 
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_614594714 = (fieldType.isPrimitive());
                            {
                                String fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_905158568 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_1058440596 = (f.getInt(this) != g.getInt(that));
                                        } 
                                    } 
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_247903031 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_1581535619 = (f.getShort(this) != g.getShort(that));
                                            } 
                                        } 
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_1354565160 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_63918456 = (f.getChar(this) != g.getChar(that));
                                                } 
                                            } 
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_667910487 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_299346165 = (f.getLong(this) != g.getLong(that));
                                                    } 
                                                } 
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_895517887 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_1696471297 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } 
                                                    } 
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_23224778 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_1110739890 = (f.getDouble(this) != g.getDouble(that));
                                                            } 
                                                        } 
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_1103157138 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_1320148429 = (f.getFloat(this) != g.getFloat(that));
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
                                        boolean varAB8B8601C682E475B385ACEEFDCEE72C_441294607 = (((String) hisObj).equals(""));
                                    } 
                                    {
                                        boolean varDE40D545EC09CF05DB34B16AE2D8BFAD_1036156215 = (((String) myObj)
                                .compareToIgnoreCase((String) hisObj)
                                != 0);
                                    } 
                                } 
                                {
                                    boolean varD4734C60F14F54F732C7FBA072E5A071_556156671 = (GenericObject.isMySubclass(myObj.getClass())
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
                                        boolean var23E104026FF8191A6303BED8A98BF008_1553756000 = (GenericObject.isMySubclass(myObj.getClass())
                                && !((GenericObject) myObj).match(hisObj));
                                        {
                                            boolean var2386E6059110DC674FEC38F1CD1B8812_1949423295 = (GenericObjectList.isMySubclass(myObj.getClass())
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
                boolean var5E4EA8E50ECDEEF507D9A4D6EDC4CB5B_85572655 = (myclass.equals(NetObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } 
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535500328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535500328;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.305 -0400", hash_original_method = "8F6462E23806D652AB2FB8FE10D0061F", hash_generated_method = "245BCEC65031341436350A6797CDCBAA")
    public String debugDump() {
        String varB4EAC82CA7396A68D541C85D26508E83_379023986 = null; 
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
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_1815825486 = (fieldName.compareTo("stringRepresentation") == 0);
                } 
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_618452049 = (fieldName.compareTo("indentation") == 0);
                } 
                sprint(fieldName + ":");
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_1810722833 = (fieldType.isPrimitive());
                        {
                            String fname = fieldType.toString();
                            sprint(fname + ":");
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_1249391616 = (fname.compareTo("int") == 0);
                                {
                                    int intfield = f.getInt(this);
                                    sprint(intfield);
                                } 
                                {
                                    boolean varECBE882B00F953257800779B015A044A_1398639910 = (fname.compareTo("short") == 0);
                                    {
                                        short shortField = f.getShort(this);
                                        sprint(shortField);
                                    } 
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_747304215 = (fname.compareTo("char") == 0);
                                        {
                                            char charField = f.getChar(this);
                                            sprint(charField);
                                        } 
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_381879692 = (fname.compareTo("long") == 0);
                                            {
                                                long longField = f.getLong(this);
                                                sprint(longField);
                                            } 
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_907771001 = (fname.compareTo("boolean") == 0);
                                                {
                                                    boolean booleanField = f.getBoolean(this);
                                                    sprint(booleanField);
                                                } 
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_413250403 = (fname.compareTo("double") == 0);
                                                    {
                                                        double doubleField = f.getDouble(this);
                                                        sprint(doubleField);
                                                    } 
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_1800077402 = (fname.compareTo("float") == 0);
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
                            boolean varD5A8092938B037D2C43A6EAD0E6B9173_1403336997 = (GenericObject.class.isAssignableFrom(fieldType));
                            {
                                {
                                    boolean varFF6BA6C3E22248032CA1E2ADDB055F70_989933212 = (f.get(this) != null);
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
                                boolean var3D135DF8A6804404B214F5224E4565F6_1820036005 = (GenericObjectList.class.isAssignableFrom(fieldType));
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1975013994 = (f.get(this) != null);
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
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_896507054 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).getClass().getName() + ":");
                                        } 
                                        {
                                            sprint(fieldType.getName() + ":");
                                        } 
                                    } 
                                    sprint("{");
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1147120339 = (f.get(this) != null);
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
        varB4EAC82CA7396A68D541C85D26508E83_379023986 = stringRepresentation;
        varB4EAC82CA7396A68D541C85D26508E83_379023986.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_379023986;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.306 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "0D3FEC628DF1B4BD65FAAB4874164A48")
    public String debugDump(int indent) {
        String varB4EAC82CA7396A68D541C85D26508E83_803180993 = null; 
        int save = indentation;
        indentation = indent;
        String retval = this.debugDump();
        indentation = save;
        varB4EAC82CA7396A68D541C85D26508E83_803180993 = retval;
        addTaint(indent);
        varB4EAC82CA7396A68D541C85D26508E83_803180993.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_803180993;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.306 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "DE09122F94C7E4D24B9DF9D2D06EA494")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_754948511 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_754948511 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_754948511.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_754948511;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.306 -0400", hash_original_field = "84814EA1316201D7682A1857E6DA438C", hash_generated_field = "46C2887731A82D54499D991777D692CF")

    protected static final String CORE_PACKAGE = PackageNames.CORE_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.306 -0400", hash_original_field = "D44CF5167E8CD4A0B8C7121141E5F5CA", hash_generated_field = "594D4223DA826D2239E3278060CF9C1D")

    protected static final String NET_PACKAGE = PackageNames.NET_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.306 -0400", hash_original_field = "A42FB06745B0689D818929080E18E2A6", hash_generated_field = "F9F431553B7EF5ED564BB76D3511A1C4")

    protected static final String PARSER_PACKAGE = PackageNames.PARSER_PACKAGE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "955EEDB20D590A1A9DC57A6B4C9C2524", hash_generated_field = "E0F49F8A6EC1F0FC10D150214707E15F")

    protected static final String UDP = "udp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "E7E305FD91DFAD258D05CEF692A3FDA3", hash_generated_field = "65B8023757C289C256D8CDF02D79EEAB")

    protected static final String TCP = "tcp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "BB60D14484559A8FB47EEE8E87D56416", hash_generated_field = "10ACFD285BFF968264526433D33B1AB0")

    protected static final String TRANSPORT = "transport";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "8B41FABA7E13C027203E37D1A20ED7C7", hash_generated_field = "ADFC98A2AB6C9BE4ECB3DA0DC42944C8")

    protected static final String METHOD = "method";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "2F525D63281BEC6D002BC4263B4225A0", hash_generated_field = "0BD3E85D4B799F1CA9E1ECA350C946CC")

    protected static final String USER = "user";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "D691F6CBCE83242F8E1801A18FE78496", hash_generated_field = "F56AC3F2C0064F9B98AE234242186C42")

    protected static final String PHONE = "phone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "7C093FAE4691A03AB86E86898A11746D", hash_generated_field = "7A87650302C67C9E28DB90C3D1ED745E")

    protected static final String MADDR = "maddr";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "EEECE76344C3913E85967FB61CC6ACB5", hash_generated_field = "9521875EFD450C64F6E61B84A224F274")

    protected static final String TTL = "ttl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "89D96C07757E423BC566F92B191778CF", hash_generated_field = "19B2449D5B180111495A6203819463E0")

    protected static final String LR = "lr";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "60903E31AE0F2D927C93F88555EA8B06", hash_generated_field = "6F3518A2B8F324537D0A7D82E19056BF")

    protected static final String SIP = "sip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "BB1888B5D56BD607ED3A6833F0434370", hash_generated_field = "2812DB6997C42C0FAEB5CA6CA624A89E")

    protected static final String SIPS = "sips";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "02AC7105BC9267167A7FE52691A37BAB", hash_generated_field = "9E085E7B626954040FA4C29E128B38D1")

    protected static final String TLS = "tls";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.307 -0400", hash_original_field = "86623E8163A910A0C283102686E462A2", hash_generated_field = "0792D95F056BB55ABBA0C958C9203C97")

    protected static final String GRUU = "gr";
}

