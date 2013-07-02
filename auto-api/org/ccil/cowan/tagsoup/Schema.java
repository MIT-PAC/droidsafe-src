package org.ccil.cowan.tagsoup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.HashMap;

public abstract class Schema {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.113 -0400", hash_original_field = "8188B69D13D5B1ECF8F5A593CC51B318", hash_generated_field = "C61B01F294C72FE231EFE447D1205178")

    private HashMap theEntities = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.113 -0400", hash_original_field = "30AA40A499FF95EFFEFA3A2FE87F822E", hash_generated_field = "2AE92EDACE151B18CC432468ECADC6DB")

    private HashMap theElementTypes = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.113 -0400", hash_original_field = "2AF30FE2A2F8DAA1C3C142E861D2ADB0", hash_generated_field = "0B2F19732EC7E786F963FECFA20F63AD")

    private String theURI = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.113 -0400", hash_original_field = "9FE852E5EB62414F6A2FEAAAA1BE0446", hash_generated_field = "FC283CC8AA8CD94A57C44DB3DEB67DE7")

    private String thePrefix = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.113 -0400", hash_original_field = "E2EAE2344101E1B5A88DA91D8AC09D7D", hash_generated_field = "ED3D267A195694465C51E002655EFB20")

    private ElementType theRoot = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.113 -0400", hash_original_method = "D0D844E899EF8830D95ED807F7DF602A", hash_generated_method = "D0D844E899EF8830D95ED807F7DF602A")
    public Schema ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.113 -0400", hash_original_method = "9699024F392D458CCB5B62F4AD905856", hash_generated_method = "040E267CAC329A985481A7B0F56E77FA")
    public void elementType(String name, int model, int memberOf, int flags) {
        ElementType e = new ElementType(name, model, memberOf, flags, this);
        theElementTypes.put(name.toLowerCase(), e);
        theRoot = e;
        addTaint(name.getTaint());
        addTaint(model);
        addTaint(memberOf);
        addTaint(flags);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.114 -0400", hash_original_method = "7A084406CC3B18F733E08ECB30CF0A86", hash_generated_method = "FFF5D132E9AED5BC24C21CB48F5EC7ED")
    public ElementType rootElementType() {
        ElementType varB4EAC82CA7396A68D541C85D26508E83_266662191 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_266662191 = theRoot;
        varB4EAC82CA7396A68D541C85D26508E83_266662191.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_266662191;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.114 -0400", hash_original_method = "1826BAE4A7A25490C40F3DF9456EC509", hash_generated_method = "963C043A44EA98B3570195542BE6D984")
    public void attribute(String elemName, String attrName,
				String type, String value) {
        ElementType e = getElementType(elemName);
        {
            if (DroidSafeAndroidRuntime.control) throw new Error("Attribute " + attrName +
				" specified for unknown element type " +
				elemName);
        } 
        e.setAttribute(attrName, type, value);
        addTaint(elemName.getTaint());
        addTaint(attrName.getTaint());
        addTaint(type.getTaint());
        addTaint(value.getTaint());
        
        
        
			
				
				
			
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.115 -0400", hash_original_method = "C7818769967A7B7D6BCF0765E44CE567", hash_generated_method = "91A81D1D9DA292E76A66F4C968E111AD")
    public void parent(String name, String parentName) {
        ElementType child = getElementType(name);
        ElementType parent = getElementType(parentName);
        {
            if (DroidSafeAndroidRuntime.control) throw new Error("No child " + name + " for parent " + parentName);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new Error("No parent " + parentName + " for child " + name);
        } 
        child.setParent(parent);
        addTaint(name.getTaint());
        addTaint(parentName.getTaint());
        
        
        
        
			
			
        
			
			
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.115 -0400", hash_original_method = "9D058B55598451C1F46B788161F3861A", hash_generated_method = "302CF0689780DBA01F8F38EAEF4D90C3")
    public void entity(String name, int value) {
        theEntities.put(name, new Integer(value));
        addTaint(name.getTaint());
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.116 -0400", hash_original_method = "15E50FC94B256079445190BC5C208F0A", hash_generated_method = "0B583C22A4E491563A72E4ADE0D4E1C7")
    public ElementType getElementType(String name) {
        ElementType varB4EAC82CA7396A68D541C85D26508E83_678844354 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_678844354 = (ElementType)(theElementTypes.get(name.toLowerCase()));
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_678844354.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_678844354;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.116 -0400", hash_original_method = "5590AE9B6B63818372EC6D8DB973BC8E", hash_generated_method = "C1134A83E303BFB9969FE430C2B1059E")
    public int getEntity(String name) {
        Integer ch = (Integer)theEntities.get(name);
        int var7D6C02999E256F8291900373073B5492_1249703189 = (ch.intValue());
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968940631 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968940631;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.117 -0400", hash_original_method = "1798242D281A34B11A86AFDBABA0D18C", hash_generated_method = "245533B97BB8EBCE34AEFD56A53190C2")
    public String getURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1166021776 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1166021776 = theURI;
        varB4EAC82CA7396A68D541C85D26508E83_1166021776.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1166021776;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.118 -0400", hash_original_method = "ED82F113C378B68FF5FAC6A19F5F47F3", hash_generated_method = "743FCFF3EE9FB918348ACD80F06E274D")
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_788175290 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_788175290 = thePrefix;
        varB4EAC82CA7396A68D541C85D26508E83_788175290.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_788175290;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.118 -0400", hash_original_method = "234E680F6FA8586452A8BF7CCF48759A", hash_generated_method = "69EEF406ACDC114BD475EB03C2469E2B")
    public void setURI(String uri) {
        theURI = uri;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.118 -0400", hash_original_method = "4CEDB742D62DCBE17383ACF000150A0B", hash_generated_method = "A94536348B3AA801BFBCDF0F0F6703FC")
    public void setPrefix(String prefix) {
        thePrefix = prefix;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.118 -0400", hash_original_field = "FF63A43022DEC37DD51F58188CD43456", hash_generated_field = "9FCDE2F85894A1F88D902902F60C43F2")

    public static final int M_ANY = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.119 -0400", hash_original_field = "574E4B26C98A58EE59DBFA49886A472A", hash_generated_field = "6F158764A73B46F4A4EF45B21BF7FC55")

    public static final int M_EMPTY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.119 -0400", hash_original_field = "FC013B14BD0B00DF1E7B898B8AE82B83", hash_generated_field = "FB18EC4D7B430B5F3DA623CFEF2C73F4")

    public static final int M_PCDATA = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.119 -0400", hash_original_field = "55CD8222CEE238FF1545581882B49736", hash_generated_field = "1CEEB9FAE29B30670902C2BB3F4C57A8")

    public static final int M_ROOT = 1 << 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.119 -0400", hash_original_field = "50716764F8802F6287DB6A3B19DDC1AD", hash_generated_field = "BABC86BDE81AF8887C1078673844A155")

    public static final int F_RESTART = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.119 -0400", hash_original_field = "72B22BB298DFDA6B79192F11BFDBC128", hash_generated_field = "0FA7AC7F743D988121B9D5FEAB58BEF3")

    public static final int F_CDATA = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.119 -0400", hash_original_field = "00EA933EF6108715F16570744D536502", hash_generated_field = "ED6D4EA7416612E8042D06B320A6ED78")

    public static final int F_NOFORCE = 4;
}

