package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import libcore.icu.RuleBasedCollatorICU;

public class RuleBasedCollator extends Collator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.034 -0400", hash_original_method = "31FBA21C05DBD02C02879BE90D845185", hash_generated_method = "4BAD392396C7D2F8879451F9FF7C21AB")
      RuleBasedCollator(RuleBasedCollatorICU wrapper) {
        super(wrapper);
        addTaint(wrapper.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.034 -0400", hash_original_method = "A2DABBE445FB3F5820A862D094AFC471", hash_generated_method = "4E3535DA45AD0D21D264D7BCF9914D5A")
    public  RuleBasedCollator(String rules) throws ParseException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean var3D82C9751A8A34CF2413397F66CF0EAB_640898998 = (rules.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("empty rules", 0);
            } 
        } 
        try 
        {
            icuColl = new RuleBasedCollatorICU(rules);
        } 
        catch (Exception e)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw (ParseException) e;
            } 
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), -1);
        } 
        addTaint(rules.getTaint());
        
        
            
        
        
            
        
        
            
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.035 -0400", hash_original_method = "C93FCBD8C41C04013259A24B3BA25AFC", hash_generated_method = "E44494C93D9BB4C7DB17712162773281")
    public CollationElementIterator getCollationElementIterator(CharacterIterator source) {
        CollationElementIterator varB4EAC82CA7396A68D541C85D26508E83_1960131231 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1960131231 = new CollationElementIterator(icuColl.getCollationElementIterator(source));
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1960131231.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1960131231;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.035 -0400", hash_original_method = "0A03AD4A8EA2D5EFD885AFF079D1FBF8", hash_generated_method = "2AC17CA33E6965AA3FD3E864FA2C5E89")
    public CollationElementIterator getCollationElementIterator(String source) {
        CollationElementIterator varB4EAC82CA7396A68D541C85D26508E83_1938445332 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1938445332 = new CollationElementIterator(icuColl.getCollationElementIterator(source));
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1938445332.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1938445332;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.036 -0400", hash_original_method = "FF8EDD58F3376852427F0295E98F1202", hash_generated_method = "56605438C6B0FA24CF3E2F436C187E00")
    public String getRules() {
        String varB4EAC82CA7396A68D541C85D26508E83_868555953 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_868555953 = icuColl.getRules();
        varB4EAC82CA7396A68D541C85D26508E83_868555953.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_868555953;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.036 -0400", hash_original_method = "FBA963D7A9FB0658F4932AD387478243", hash_generated_method = "5B1D56358B436BF3BF16CADDE744CFE3")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1899467522 = null; 
        RuleBasedCollator clone = (RuleBasedCollator) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1899467522 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1899467522.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1899467522;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.037 -0400", hash_original_method = "6590B43BC0A35CBDE76A6B18FA6459C5", hash_generated_method = "0091845BBAFFD64DD58CDFABB92EF31D")
    @Override
    public int compare(String source, String target) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        int varA6E0FB9399BDCEE39D05264A8EB646FD_931926483 = (icuColl.compare(source, target));
        addTaint(source.getTaint());
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1488689981 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1488689981;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.037 -0400", hash_original_method = "A9AF4E46AA414E7FF98E8748BB278551", hash_generated_method = "9C1FEC9338142DF2B2F441A607CF557E")
    @Override
    public CollationKey getCollationKey(String source) {
        CollationKey varB4EAC82CA7396A68D541C85D26508E83_1099744065 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1099744065 = icuColl.getCollationKey(source);
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1099744065.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1099744065;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.038 -0400", hash_original_method = "B4EBBD96DB20771CAD5EB8825D399E3B", hash_generated_method = "F67CA5E3178048BB8309352E3A64C46B")
    @Override
    public int hashCode() {
        int varF7028415B2CE61B4AB1FA0FC4E297A19_57584225 = (icuColl.getRules().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009364664 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009364664;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.038 -0400", hash_original_method = "1D9A70F4229C9ABE49C60D2B9C1F5E2A", hash_generated_method = "4099E65472AC8940D9E8FA7819F3A76D")
    @Override
    public boolean equals(Object obj) {
        boolean var6E858EC9D9579AEA03A77B18029B02A3_346639672 = (super.equals(obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1160063437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1160063437;
        
        
            
        
        
    }

    
}

