package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.icu.RuleBasedCollatorICU;

public class RuleBasedCollator extends Collator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.652 -0400", hash_original_method = "31FBA21C05DBD02C02879BE90D845185", hash_generated_method = "4BAD392396C7D2F8879451F9FF7C21AB")
      RuleBasedCollator(RuleBasedCollatorICU wrapper) {
        super(wrapper);
        addTaint(wrapper.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.653 -0400", hash_original_method = "A2DABBE445FB3F5820A862D094AFC471", hash_generated_method = "B7BF989833498C0256BEFE1E5DEFF3E6")
    public  RuleBasedCollator(String rules) throws ParseException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var3D82C9751A8A34CF2413397F66CF0EAB_2050513829 = (rules.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.659 -0400", hash_original_method = "C93FCBD8C41C04013259A24B3BA25AFC", hash_generated_method = "7AD67D319882A2B65E95793B7153DEFB")
    public CollationElementIterator getCollationElementIterator(CharacterIterator source) {
        CollationElementIterator varB4EAC82CA7396A68D541C85D26508E83_1513311907 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1513311907 = new CollationElementIterator(icuColl.getCollationElementIterator(source));
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1513311907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1513311907;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.660 -0400", hash_original_method = "0A03AD4A8EA2D5EFD885AFF079D1FBF8", hash_generated_method = "FEA7274537455F8FA072CF0C36F312F5")
    public CollationElementIterator getCollationElementIterator(String source) {
        CollationElementIterator varB4EAC82CA7396A68D541C85D26508E83_1917720446 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1917720446 = new CollationElementIterator(icuColl.getCollationElementIterator(source));
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1917720446.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1917720446;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.660 -0400", hash_original_method = "FF8EDD58F3376852427F0295E98F1202", hash_generated_method = "9ED13361D9BA608955CD3F6E3506F251")
    public String getRules() {
        String varB4EAC82CA7396A68D541C85D26508E83_878216462 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_878216462 = icuColl.getRules();
        varB4EAC82CA7396A68D541C85D26508E83_878216462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_878216462;
        // ---------- Original Method ----------
        //return icuColl.getRules();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.660 -0400", hash_original_method = "FBA963D7A9FB0658F4932AD387478243", hash_generated_method = "2353CDDD6738C194DF6638647F4B83F8")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1024528185 = null; //Variable for return #1
        RuleBasedCollator clone;
        clone = (RuleBasedCollator) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1024528185 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1024528185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1024528185;
        // ---------- Original Method ----------
        //RuleBasedCollator clone = (RuleBasedCollator) super.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.661 -0400", hash_original_method = "6590B43BC0A35CBDE76A6B18FA6459C5", hash_generated_method = "EDFE22A049E83D2C209D0EAA6A5539A1")
    @Override
    public int compare(String source, String target) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int varA6E0FB9399BDCEE39D05264A8EB646FD_1314169581 = (icuColl.compare(source, target));
        addTaint(source.getTaint());
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943899468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943899468;
        // ---------- Original Method ----------
        //if (source == null || target == null) {
            //throw new NullPointerException();
        //}
        //return icuColl.compare(source, target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.661 -0400", hash_original_method = "A9AF4E46AA414E7FF98E8748BB278551", hash_generated_method = "2CA86DD9204B30062EE211D7C4355A2E")
    @Override
    public CollationKey getCollationKey(String source) {
        CollationKey varB4EAC82CA7396A68D541C85D26508E83_145004580 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_145004580 = icuColl.getCollationKey(source);
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_145004580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_145004580;
        // ---------- Original Method ----------
        //return icuColl.getCollationKey(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.662 -0400", hash_original_method = "B4EBBD96DB20771CAD5EB8825D399E3B", hash_generated_method = "A5F57C96BCADD36E2EEC7F8241EA3EEF")
    @Override
    public int hashCode() {
        int varF7028415B2CE61B4AB1FA0FC4E297A19_1351210505 = (icuColl.getRules().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226392306 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226392306;
        // ---------- Original Method ----------
        //return icuColl.getRules().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.663 -0400", hash_original_method = "1D9A70F4229C9ABE49C60D2B9C1F5E2A", hash_generated_method = "DA54E24F7068E7B55356EFAAE8E9A278")
    @Override
    public boolean equals(Object obj) {
        boolean var6E858EC9D9579AEA03A77B18029B02A3_549100212 = (super.equals(obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_96098584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_96098584;
        // ---------- Original Method ----------
        //if (!(obj instanceof Collator)) {
            //return false;
        //}
        //return super.equals(obj);
    }

    
}

