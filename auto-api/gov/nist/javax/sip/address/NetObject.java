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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.410 -0400", hash_original_method = "C4442EA667C9A2BEB67B2F1E6DC6F09B", hash_generated_method = "DA7CD8F57514C7E6D13831C88B45DC81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetObject() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.411 -0400", hash_original_method = "26A4AB68F41643C912C51D77CC375C44", hash_generated_method = "AA5E21A1DCD65920CDE55931B372E821")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object that) {
        dsTaint.addTaint(that.dsTaint);
        {
            boolean var07F02797FD62DC585D5DCA22B5D2ED2C_129350567 = (!this.getClass().equals(that.getClass()));
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
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_703271717 = (fieldName.compareTo("stringRepresentation") == 0);
                    } //End collapsed parenthetic
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_1965545806 = (fieldName.compareTo("indentation") == 0);
                    } //End collapsed parenthetic
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_1848025504 = (fieldType.isPrimitive());
                            {
                                String fname;
                                fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_1432842507 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_1965326886 = (f.getInt(this) != g.getInt(that));
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_1663802691 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_1064085643 = (f.getShort(this) != g.getShort(that));
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_1374709313 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_866659248 = (f.getChar(this) != g.getChar(that));
                                                } //End collapsed parenthetic
                                            } //End block
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_2052200648 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_733459889 = (f.getLong(this) != g.getLong(that));
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_1754003946 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_710881314 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_725559214 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_1334942464 = (f.getDouble(this) != g.getDouble(that));
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_724869088 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_1788568112 = (f.getFloat(this) != g.getFloat(that));
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
                                boolean varAA8F4E7F9752016DF7A866D138AF57F2_1179267769 = (g.get(that) == f.get(this));
                                {
                                    boolean var77209C918A38A144D72382BEE175E0D9_226065764 = (f.get(this) == null && g.get(that) != null);
                                    {
                                        boolean var0C64ED638CF950569CE844619B5AA026_215796029 = (g.get(that) == null && f.get(that) != null);
                                        {
                                            boolean var40760574C0FFA80349F6AC8002CC0D1A_622966982 = (!f.get(this).equals(g.get(that)));
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
                boolean var5E4EA8E50ECDEEF507D9A4D6EDC4CB5B_1433347258 = (myclass.equals(NetObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.413 -0400", hash_original_method = "8D936CCD11169852B60D86BE02120DB8", hash_generated_method = "16AD081E10568A99851DE29B39D682B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varE5000AFAE6691EEE0058A00BC83324BD_1389098914 = (!this.getClass().equals(other.getClass()));
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
                        boolean var7406A77B5C83EDCF5377C17BF1AF8946_2084110937 = (fieldName.compareTo("stringRepresentation") == 0);
                    } //End collapsed parenthetic
                    {
                        boolean var4BC3FF330F550C7BBF44DF279771A596_534086034 = (fieldName.compareTo("indentation") == 0);
                    } //End collapsed parenthetic
                    try 
                    {
                        {
                            boolean varA02EA4574D838DD5C519F1195763C1D8_336838458 = (fieldType.isPrimitive());
                            {
                                String fname;
                                fname = fieldType.toString();
                                {
                                    boolean var4FE1563E48DA3AE81064849A8926BED4_771966517 = (fname.compareTo("int") == 0);
                                    {
                                        {
                                            boolean var9FFD589FB326B48E92092BBEC4F82DC8_1219691159 = (f.getInt(this) != g.getInt(that));
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean var460EE96C7907B5AECEF23E2913477551_1577527409 = (fname.compareTo("short") == 0);
                                        {
                                            {
                                                boolean var61EE094D43808A12BFCF634C6C575280_1907372410 = (f.getShort(this) != g.getShort(that));
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var4E4904AB74B6D2B83A1124020050C226_1729156328 = (fname.compareTo("char") == 0);
                                            {
                                                {
                                                    boolean varED9C2E334F82F90F5E41AE8950CDF3E4_1566227275 = (f.getChar(this) != g.getChar(that));
                                                } //End collapsed parenthetic
                                            } //End block
                                            {
                                                boolean var28DA6C4AF68B340247A24B14D9A5EFA6_432967743 = (fname.compareTo("long") == 0);
                                                {
                                                    {
                                                        boolean varC71C62B8B7ED1D13CF4DAF6B4E8ECDB5_1424000096 = (f.getLong(this) != g.getLong(that));
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean var544FBCB3A6888ED08F519AE301AB6CE2_1280538056 = (fname.compareTo("boolean") == 0);
                                                    {
                                                        {
                                                            boolean var8F07C617E4B46B2300AA4EE12C709278_926267645 = (f.getBoolean(this) != g.getBoolean(that));
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        boolean var8761AD76B1E1D1FE507E180A511DE8F6_1702880783 = (fname.compareTo("double") == 0);
                                                        {
                                                            {
                                                                boolean var22302C3D3326D92671FE4F1EA186F2CA_2138406136 = (f.getDouble(this) != g.getDouble(that));
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                        {
                                                            boolean var790B66226FF0DEFD9E067842BFE0C9AF_1432349799 = (fname.compareTo("float") == 0);
                                                            {
                                                                {
                                                                    boolean var1BD555D51FC2DE23003F271AFA8F6DBD_1312786027 = (f.getFloat(this) != g.getFloat(that));
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
                                        boolean varAB8B8601C682E475B385ACEEFDCEE72C_1127870170 = (((String) hisObj).equals(""));
                                    } //End collapsed parenthetic
                                    {
                                        boolean varDE40D545EC09CF05DB34B16AE2D8BFAD_689041323 = (((String) myObj)
                                .compareToIgnoreCase((String) hisObj)
                                != 0);
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean varD4734C60F14F54F732C7FBA072E5A071_534314080 = (GenericObject.isMySubclass(myObj.getClass())
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
                                        boolean var23E104026FF8191A6303BED8A98BF008_1309277239 = (GenericObject.isMySubclass(myObj.getClass())
                                && !((GenericObject) myObj).match(hisObj));
                                        {
                                            boolean var2386E6059110DC674FEC38F1CD1B8812_835540962 = (GenericObjectList.isMySubclass(myObj.getClass())
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
                boolean var5E4EA8E50ECDEEF507D9A4D6EDC4CB5B_510497456 = (myclass.equals(NetObject.class));
                {
                    myclass = myclass.getSuperclass();
                    hisclass = hisclass.getSuperclass();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.414 -0400", hash_original_method = "8F6462E23806D652AB2FB8FE10D0061F", hash_generated_method = "286C4AEEAF4D0594DDB4679A891BF926")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump() {
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
                    boolean var9553731A42361BF7DC5CCD8CE3EA7CE0_2056101298 = (fieldName.compareTo("stringRepresentation") == 0);
                } //End collapsed parenthetic
                {
                    boolean varAEA832B4D7325A04DB2E217DE472721D_1069658908 = (fieldName.compareTo("indentation") == 0);
                } //End collapsed parenthetic
                sprint(fieldName + ":");
                try 
                {
                    {
                        boolean varEB7331DA69828FA2B551971C05AF6235_1520362462 = (fieldType.isPrimitive());
                        {
                            String fname;
                            fname = fieldType.toString();
                            sprint(fname + ":");
                            {
                                boolean var4CCBD530AB7CEC48FD13CB4D5B1284E0_1194458175 = (fname.compareTo("int") == 0);
                                {
                                    int intfield;
                                    intfield = f.getInt(this);
                                    sprint(intfield);
                                } //End block
                                {
                                    boolean varECBE882B00F953257800779B015A044A_597444602 = (fname.compareTo("short") == 0);
                                    {
                                        short shortField;
                                        shortField = f.getShort(this);
                                        sprint(shortField);
                                    } //End block
                                    {
                                        boolean varFF6F4832473A71F8EC5346F9584CA1A4_518246786 = (fname.compareTo("char") == 0);
                                        {
                                            char charField;
                                            charField = f.getChar(this);
                                            sprint(charField);
                                        } //End block
                                        {
                                            boolean varC3D60E7CA564385C1E6CA965551B84B9_866722030 = (fname.compareTo("long") == 0);
                                            {
                                                long longField;
                                                longField = f.getLong(this);
                                                sprint(longField);
                                            } //End block
                                            {
                                                boolean varDEFD334EAB943FE4F6ADC4A9D68CC2D0_585239278 = (fname.compareTo("boolean") == 0);
                                                {
                                                    boolean booleanField;
                                                    booleanField = f.getBoolean(this);
                                                    sprint(booleanField);
                                                } //End block
                                                {
                                                    boolean var7199B82B3E59A867EA681451AF585474_1252719848 = (fname.compareTo("double") == 0);
                                                    {
                                                        double doubleField;
                                                        doubleField = f.getDouble(this);
                                                        sprint(doubleField);
                                                    } //End block
                                                    {
                                                        boolean varA4C55C1B6673FD16D2CEFF9326676E6A_1332419496 = (fname.compareTo("float") == 0);
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
                            boolean varD5A8092938B037D2C43A6EAD0E6B9173_1698225300 = (GenericObject.class.isAssignableFrom(fieldType));
                            {
                                {
                                    boolean varFF6BA6C3E22248032CA1E2ADDB055F70_1407863426 = (f.get(this) != null);
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
                                boolean var3D135DF8A6804404B214F5224E4565F6_364494799 = (GenericObjectList.class.isAssignableFrom(fieldType));
                                {
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_1945851879 = (f.get(this) != null);
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
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_313659793 = (f.get(this) != null);
                                        {
                                            sprint(f.get(this).getClass().getName() + ":");
                                        } //End block
                                        {
                                            sprint(fieldType.getName() + ":");
                                        } //End block
                                    } //End collapsed parenthetic
                                    sprint("{");
                                    {
                                        boolean var32C4A31DCBD23D1B28FA59D1C0318853_731412477 = (f.get(this) != null);
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
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.415 -0400", hash_original_method = "85620320EA37710A8866ECA4B349D636", hash_generated_method = "CB90B3C48C1EF4D3EF2368F5141833AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump(int indent) {
        dsTaint.addTaint(indent);
        int save;
        save = indentation;
        indentation = indent;
        String retval;
        retval = this.debugDump();
        indentation = save;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int save = indentation;
        //indentation = indent;
        //String retval = this.debugDump();
        //indentation = save;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.415 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "3EB215C2FE83BE1A1716890EF0ACDCA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var002E8E97D996E9DD2E7B0E1B0BD6187C_2029663201 = (this.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    protected static final String CORE_PACKAGE = PackageNames.CORE_PACKAGE;
    protected static final String NET_PACKAGE = PackageNames.NET_PACKAGE;
    protected static final String PARSER_PACKAGE = PackageNames.PARSER_PACKAGE;
    protected static final String UDP = "udp";
    protected static final String TCP = "tcp";
    protected static final String TRANSPORT = "transport";
    protected static final String METHOD = "method";
    protected static final String USER = "user";
    protected static final String PHONE = "phone";
    protected static final String MADDR = "maddr";
    protected static final String TTL = "ttl";
    protected static final String LR = "lr";
    protected static final String SIP = "sip";
    protected static final String SIPS = "sips";
    protected static final String TLS = "tls";
    protected static final String GRUU = "gr";
}

