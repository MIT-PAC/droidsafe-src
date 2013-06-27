package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.icu.RuleBasedCollatorICU;

public class RuleBasedCollator extends Collator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.840 -0400", hash_original_method = "31FBA21C05DBD02C02879BE90D845185", hash_generated_method = "4BAD392396C7D2F8879451F9FF7C21AB")
      RuleBasedCollator(RuleBasedCollatorICU wrapper) {
        super(wrapper);
        addTaint(wrapper.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.840 -0400", hash_original_method = "A2DABBE445FB3F5820A862D094AFC471", hash_generated_method = "1D52851A5EFB15047079F03E0315BB97")
    public  RuleBasedCollator(String rules) throws ParseException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var3D82C9751A8A34CF2413397F66CF0EAB_782196911 = (rules.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("empty rules", 0);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            icuColl = new RuleBasedCollatorICU(rules);
        } //End block
        catch (Exception e)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw (ParseException) e;
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), -1);
        } //End block
        addTaint(rules.getTaint());
        // ---------- Original Method ----------
        //if (rules == null) {
            //throw new NullPointerException();
        //}
        //if (rules.isEmpty()) {
            //throw new ParseException("empty rules", 0);
        //}
        //try {
            //icuColl = new RuleBasedCollatorICU(rules);
        //} catch (Exception e) {
            //if (e instanceof ParseException) {
                //throw (ParseException) e;
            //}
            //throw new ParseException(e.getMessage(), -1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.841 -0400", hash_original_method = "C93FCBD8C41C04013259A24B3BA25AFC", hash_generated_method = "DCD0CD3DB5348EEEEAACCCF2589B84B4")
    public CollationElementIterator getCollationElementIterator(CharacterIterator source) {
        CollationElementIterator varB4EAC82CA7396A68D541C85D26508E83_143965667 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_143965667 = new CollationElementIterator(icuColl.getCollationElementIterator(source));
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_143965667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_143965667;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.841 -0400", hash_original_method = "0A03AD4A8EA2D5EFD885AFF079D1FBF8", hash_generated_method = "A4AAFFBBFEB5F3E3C0153F3620B58453")
    public CollationElementIterator getCollationElementIterator(String source) {
        CollationElementIterator varB4EAC82CA7396A68D541C85D26508E83_1498677121 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1498677121 = new CollationElementIterator(icuColl.getCollationElementIterator(source));
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1498677121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1498677121;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.842 -0400", hash_original_method = "FF8EDD58F3376852427F0295E98F1202", hash_generated_method = "92C19908AFB666546F36FAB4C21C38F5")
    public String getRules() {
        String varB4EAC82CA7396A68D541C85D26508E83_1196792703 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1196792703 = icuColl.getRules();
        varB4EAC82CA7396A68D541C85D26508E83_1196792703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1196792703;
        // ---------- Original Method ----------
        //return icuColl.getRules();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.842 -0400", hash_original_method = "FBA963D7A9FB0658F4932AD387478243", hash_generated_method = "45A66B1849FCAFC042BAB4074C78718C")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1809872664 = null; //Variable for return #1
        RuleBasedCollator clone;
        clone = (RuleBasedCollator) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1809872664 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1809872664.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1809872664;
        // ---------- Original Method ----------
        //RuleBasedCollator clone = (RuleBasedCollator) super.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.843 -0400", hash_original_method = "6590B43BC0A35CBDE76A6B18FA6459C5", hash_generated_method = "BC515328AD86CEEE70CBB1C1DFE24750")
    @Override
    public int compare(String source, String target) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int varA6E0FB9399BDCEE39D05264A8EB646FD_1408616873 = (icuColl.compare(source, target));
        addTaint(source.getTaint());
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728299152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728299152;
        // ---------- Original Method ----------
        //if (source == null || target == null) {
            //throw new NullPointerException();
        //}
        //return icuColl.compare(source, target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.843 -0400", hash_original_method = "A9AF4E46AA414E7FF98E8748BB278551", hash_generated_method = "95D2F3584117D6F5629CF104C18965B5")
    @Override
    public CollationKey getCollationKey(String source) {
        CollationKey varB4EAC82CA7396A68D541C85D26508E83_514044963 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_514044963 = icuColl.getCollationKey(source);
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_514044963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_514044963;
        // ---------- Original Method ----------
        //return icuColl.getCollationKey(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.853 -0400", hash_original_method = "B4EBBD96DB20771CAD5EB8825D399E3B", hash_generated_method = "7F26E4E37BD7B3BF756008502166B4D0")
    @Override
    public int hashCode() {
        int varF7028415B2CE61B4AB1FA0FC4E297A19_1146557627 = (icuColl.getRules().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936333423 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936333423;
        // ---------- Original Method ----------
        //return icuColl.getRules().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.854 -0400", hash_original_method = "1D9A70F4229C9ABE49C60D2B9C1F5E2A", hash_generated_method = "9EBB0D0B3A687CFDC2CB2647A8A21B35")
    @Override
    public boolean equals(Object obj) {
        boolean var6E858EC9D9579AEA03A77B18029B02A3_1193388032 = (super.equals(obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26411497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_26411497;
        // ---------- Original Method ----------
        //if (!(obj instanceof Collator)) {
            //return false;
        //}
        //return super.equals(obj);
    }

    
}

