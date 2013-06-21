package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.icu.RuleBasedCollatorICU;

public class RuleBasedCollator extends Collator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.508 -0400", hash_original_method = "31FBA21C05DBD02C02879BE90D845185", hash_generated_method = "511CAC2EDDCD35D13B76ED3FC082E940")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     RuleBasedCollator(RuleBasedCollatorICU wrapper) {
        super(wrapper);
        dsTaint.addTaint(wrapper.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.509 -0400", hash_original_method = "A2DABBE445FB3F5820A862D094AFC471", hash_generated_method = "A44BF354CF77238FF258A64EC553F004")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuleBasedCollator(String rules) throws ParseException {
        dsTaint.addTaint(rules);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var3D82C9751A8A34CF2413397F66CF0EAB_577870057 = (rules.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.509 -0400", hash_original_method = "C93FCBD8C41C04013259A24B3BA25AFC", hash_generated_method = "59F990CE6207BE6CB8A6B432671E470E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CollationElementIterator getCollationElementIterator(CharacterIterator source) {
        dsTaint.addTaint(source.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        CollationElementIterator var86C17557BF5AC61776999CA7479588A7_982502984 = (new CollationElementIterator(icuColl.getCollationElementIterator(source)));
        return (CollationElementIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.510 -0400", hash_original_method = "0A03AD4A8EA2D5EFD885AFF079D1FBF8", hash_generated_method = "4AD2EEA94D6B6162825ED84DD56033C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CollationElementIterator getCollationElementIterator(String source) {
        dsTaint.addTaint(source);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        CollationElementIterator var86C17557BF5AC61776999CA7479588A7_75943374 = (new CollationElementIterator(icuColl.getCollationElementIterator(source)));
        return (CollationElementIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.510 -0400", hash_original_method = "FF8EDD58F3376852427F0295E98F1202", hash_generated_method = "C7B63D43ACE20233653AAFDD6494A1DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRules() {
        String var5324726C5F742A7B7850634C18B018B6_139695420 = (icuColl.getRules());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return icuColl.getRules();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.510 -0400", hash_original_method = "FBA963D7A9FB0658F4932AD387478243", hash_generated_method = "82AFB8176F275A5F557A16F71900DECE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        RuleBasedCollator clone;
        clone = (RuleBasedCollator) super.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RuleBasedCollator clone = (RuleBasedCollator) super.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.510 -0400", hash_original_method = "6590B43BC0A35CBDE76A6B18FA6459C5", hash_generated_method = "3D03A73BF27BB7B6C42D10049EC19C47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int compare(String source, String target) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(target);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int varA6E0FB9399BDCEE39D05264A8EB646FD_1780091627 = (icuColl.compare(source, target));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (source == null || target == null) {
            //throw new NullPointerException();
        //}
        //return icuColl.compare(source, target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.511 -0400", hash_original_method = "A9AF4E46AA414E7FF98E8748BB278551", hash_generated_method = "B38B59749CE1C28E6F1DC696B7AF35AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CollationKey getCollationKey(String source) {
        dsTaint.addTaint(source);
        CollationKey var955B2CB8C39C195120A267F70CB2586E_990619595 = (icuColl.getCollationKey(source));
        return (CollationKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return icuColl.getCollationKey(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.511 -0400", hash_original_method = "B4EBBD96DB20771CAD5EB8825D399E3B", hash_generated_method = "899A95D98BE8AC52CDE014AD2B5D59AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varF7028415B2CE61B4AB1FA0FC4E297A19_2095022659 = (icuColl.getRules().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return icuColl.getRules().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.511 -0400", hash_original_method = "1D9A70F4229C9ABE49C60D2B9C1F5E2A", hash_generated_method = "CDC54E38C5C227C60F8F87CF9C3F9E59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        boolean var6E858EC9D9579AEA03A77B18029B02A3_518520588 = (super.equals(obj));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(obj instanceof Collator)) {
            //return false;
        //}
        //return super.equals(obj);
    }

    
}

