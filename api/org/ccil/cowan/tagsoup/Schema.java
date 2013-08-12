package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;






public abstract class Schema {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.189 -0400", hash_original_field = "8188B69D13D5B1ECF8F5A593CC51B318", hash_generated_field = "C61B01F294C72FE231EFE447D1205178")

    private HashMap theEntities = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.189 -0400", hash_original_field = "30AA40A499FF95EFFEFA3A2FE87F822E", hash_generated_field = "2AE92EDACE151B18CC432468ECADC6DB")

    private HashMap theElementTypes = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.189 -0400", hash_original_field = "2AF30FE2A2F8DAA1C3C142E861D2ADB0", hash_generated_field = "0B2F19732EC7E786F963FECFA20F63AD")

    private String theURI = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.189 -0400", hash_original_field = "9FE852E5EB62414F6A2FEAAAA1BE0446", hash_generated_field = "FC283CC8AA8CD94A57C44DB3DEB67DE7")

    private String thePrefix = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.189 -0400", hash_original_field = "E2EAE2344101E1B5A88DA91D8AC09D7D", hash_generated_field = "ED3D267A195694465C51E002655EFB20")

    private ElementType theRoot = null;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.189 -0400", hash_original_method = "D0D844E899EF8830D95ED807F7DF602A", hash_generated_method = "D0D844E899EF8830D95ED807F7DF602A")
    public Schema ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.189 -0400", hash_original_method = "9699024F392D458CCB5B62F4AD905856", hash_generated_method = "B5432464F72FF4BDC517335D3BD849BC")
    public void elementType(String name, int model, int memberOf, int flags) {
        addTaint(flags);
        addTaint(memberOf);
        addTaint(model);
        addTaint(name.getTaint());
        ElementType e = new ElementType(name, model, memberOf, flags, this);
        theElementTypes.put(name.toLowerCase(), e);
        if(memberOf == M_ROOT)        
        theRoot = e;
        // ---------- Original Method ----------
        //ElementType e = new ElementType(name, model, memberOf, flags, this);
        //theElementTypes.put(name.toLowerCase(), e);
        //if (memberOf == M_ROOT) theRoot = e;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.190 -0400", hash_original_method = "7A084406CC3B18F733E08ECB30CF0A86", hash_generated_method = "1123ECB8D49355808E47F8556A8D8FDB")
    public ElementType rootElementType() {
ElementType var9B2C0E9B65FBA794527A7E48FC1AA146_791023593 =         theRoot;
        var9B2C0E9B65FBA794527A7E48FC1AA146_791023593.addTaint(taint);
        return var9B2C0E9B65FBA794527A7E48FC1AA146_791023593;
        // ---------- Original Method ----------
        //return theRoot;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.190 -0400", hash_original_method = "1826BAE4A7A25490C40F3DF9456EC509", hash_generated_method = "A556C657D75E300427B2D2AD2A1BC435")
    public void attribute(String elemName, String attrName,
				String type, String value) {
        addTaint(value.getTaint());
        addTaint(type.getTaint());
        addTaint(attrName.getTaint());
        addTaint(elemName.getTaint());
        ElementType e = getElementType(elemName);
        if(e == null)        
        {
            Error var5BA7B3E6E2902601401BFB9D4A97E73F_1672183127 = new Error("Attribute " + attrName +
				" specified for unknown element type " +
				elemName);
            var5BA7B3E6E2902601401BFB9D4A97E73F_1672183127.addTaint(taint);
            throw var5BA7B3E6E2902601401BFB9D4A97E73F_1672183127;
        } //End block
        e.setAttribute(attrName, type, value);
        // ---------- Original Method ----------
        //ElementType e = getElementType(elemName);
        //if (e == null) {
			//throw new Error("Attribute " + attrName +
				//" specified for unknown element type " +
				//elemName);
			//}
        //e.setAttribute(attrName, type, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.190 -0400", hash_original_method = "C7818769967A7B7D6BCF0765E44CE567", hash_generated_method = "8F8F28852E5AED7122FD7C0944CA9280")
    public void parent(String name, String parentName) {
        addTaint(parentName.getTaint());
        addTaint(name.getTaint());
        ElementType child = getElementType(name);
        ElementType parent = getElementType(parentName);
        if(child == null)        
        {
            Error var51D825AF6A3F667C30D54D0217DEFAF1_1449548266 = new Error("No child " + name + " for parent " + parentName);
            var51D825AF6A3F667C30D54D0217DEFAF1_1449548266.addTaint(taint);
            throw var51D825AF6A3F667C30D54D0217DEFAF1_1449548266;
        } //End block
        if(parent == null)        
        {
            Error var8DEB0F27D2E5DF7645ADE361831D7479_1639964002 = new Error("No parent " + parentName + " for child " + name);
            var8DEB0F27D2E5DF7645ADE361831D7479_1639964002.addTaint(taint);
            throw var8DEB0F27D2E5DF7645ADE361831D7479_1639964002;
        } //End block
        child.setParent(parent);
        // ---------- Original Method ----------
        //ElementType child = getElementType(name);
        //ElementType parent = getElementType(parentName);
        //if (child == null) {
			//throw new Error("No child " + name + " for parent " + parentName);
			//}
        //if (parent == null) {
			//throw new Error("No parent " + parentName + " for child " + name);
			//}
        //child.setParent(parent);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.190 -0400", hash_original_method = "9D058B55598451C1F46B788161F3861A", hash_generated_method = "5947E64AEEF9E0D4D0A89F5DDBFB024A")
    public void entity(String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        theEntities.put(name, new Integer(value));
        // ---------- Original Method ----------
        //theEntities.put(name, new Integer(value));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.190 -0400", hash_original_method = "15E50FC94B256079445190BC5C208F0A", hash_generated_method = "E64B1FFA74FFD9252436682523D02782")
    public ElementType getElementType(String name) {
        addTaint(name.getTaint());
ElementType varCF5D2F602097A6A5D759EF35ED655804_1564334697 =         (ElementType)(theElementTypes.get(name.toLowerCase()));
        varCF5D2F602097A6A5D759EF35ED655804_1564334697.addTaint(taint);
        return varCF5D2F602097A6A5D759EF35ED655804_1564334697;
        // ---------- Original Method ----------
        //return (ElementType)(theElementTypes.get(name.toLowerCase()));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.190 -0400", hash_original_method = "5590AE9B6B63818372EC6D8DB973BC8E", hash_generated_method = "FD0BFF65DF8646A96DB2D2E03C21EEFF")
    public int getEntity(String name) {
        addTaint(name.getTaint());
        Integer ch = (Integer)theEntities.get(name);
        if(ch == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_94319389 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623134601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623134601;
        }
        int var8840ECF1EC2008637062B0463AFB3CF5_1787406939 = (ch.intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485479781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485479781;
        // ---------- Original Method ----------
        //Integer ch = (Integer)theEntities.get(name);
        //if (ch == null) return 0;
        //return ch.intValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.190 -0400", hash_original_method = "1798242D281A34B11A86AFDBABA0D18C", hash_generated_method = "60ADA1064030C59B28411E2D0C277360")
    public String getURI() {
String varD120E2446EDC758A0B021B80981B542D_1641730906 =         theURI;
        varD120E2446EDC758A0B021B80981B542D_1641730906.addTaint(taint);
        return varD120E2446EDC758A0B021B80981B542D_1641730906;
        // ---------- Original Method ----------
        //return theURI;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.191 -0400", hash_original_method = "ED82F113C378B68FF5FAC6A19F5F47F3", hash_generated_method = "840828C8C8C55DFEA0DF61674C063D2E")
    public String getPrefix() {
String var330006D651A016EFE5B589E8B0D40363_385554779 =         thePrefix;
        var330006D651A016EFE5B589E8B0D40363_385554779.addTaint(taint);
        return var330006D651A016EFE5B589E8B0D40363_385554779;
        // ---------- Original Method ----------
        //return thePrefix;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.191 -0400", hash_original_method = "234E680F6FA8586452A8BF7CCF48759A", hash_generated_method = "69EEF406ACDC114BD475EB03C2469E2B")
    public void setURI(String uri) {
        theURI = uri;
        // ---------- Original Method ----------
        //theURI = uri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.191 -0400", hash_original_method = "4CEDB742D62DCBE17383ACF000150A0B", hash_generated_method = "A94536348B3AA801BFBCDF0F0F6703FC")
    public void setPrefix(String prefix) {
        thePrefix = prefix;
        // ---------- Original Method ----------
        //thePrefix = prefix;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.191 -0400", hash_original_field = "FF63A43022DEC37DD51F58188CD43456", hash_generated_field = "9FCDE2F85894A1F88D902902F60C43F2")

    public static final int M_ANY = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.191 -0400", hash_original_field = "574E4B26C98A58EE59DBFA49886A472A", hash_generated_field = "6F158764A73B46F4A4EF45B21BF7FC55")

    public static final int M_EMPTY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.191 -0400", hash_original_field = "FC013B14BD0B00DF1E7B898B8AE82B83", hash_generated_field = "FB18EC4D7B430B5F3DA623CFEF2C73F4")

    public static final int M_PCDATA = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.191 -0400", hash_original_field = "55CD8222CEE238FF1545581882B49736", hash_generated_field = "1CEEB9FAE29B30670902C2BB3F4C57A8")

    public static final int M_ROOT = 1 << 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.191 -0400", hash_original_field = "50716764F8802F6287DB6A3B19DDC1AD", hash_generated_field = "BABC86BDE81AF8887C1078673844A155")

    public static final int F_RESTART = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.191 -0400", hash_original_field = "72B22BB298DFDA6B79192F11BFDBC128", hash_generated_field = "0FA7AC7F743D988121B9D5FEAB58BEF3")

    public static final int F_CDATA = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.191 -0400", hash_original_field = "00EA933EF6108715F16570744D536502", hash_generated_field = "ED6D4EA7416612E8042D06B320A6ED78")

    public static final int F_NOFORCE = 4;
}

