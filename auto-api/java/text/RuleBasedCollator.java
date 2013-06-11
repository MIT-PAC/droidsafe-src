package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import libcore.icu.RuleBasedCollatorICU;

public class RuleBasedCollator extends Collator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.818 -0400", hash_original_method = "31FBA21C05DBD02C02879BE90D845185", hash_generated_method = "43D6478A8B5ACF0CB79ABE286F8C7952")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     RuleBasedCollator(RuleBasedCollatorICU wrapper) {
        super(wrapper);
        dsTaint.addTaint(wrapper.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.820 -0400", hash_original_method = "A2DABBE445FB3F5820A862D094AFC471", hash_generated_method = "6DD1AFEC8F318B8326BAADB878ED9438")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuleBasedCollator(String rules) throws ParseException {
        dsTaint.addTaint(rules);
        {
            throw new NullPointerException();
        } //End block
        {
            boolean var3D82C9751A8A34CF2413397F66CF0EAB_1742690339 = (rules.isEmpty());
            {
                throw new ParseException("empty rules", 0);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            icuColl = new RuleBasedCollatorICU(rules);
        } //End block
        catch (Exception e)
        {
            {
                throw (ParseException) e;
            } //End block
            throw new ParseException(e.getMessage(), -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.822 -0400", hash_original_method = "C93FCBD8C41C04013259A24B3BA25AFC", hash_generated_method = "5443D38031685E4818F87745B69E672F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CollationElementIterator getCollationElementIterator(CharacterIterator source) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(source.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        CollationElementIterator var86C17557BF5AC61776999CA7479588A7_104057208 = (new CollationElementIterator(icuColl.getCollationElementIterator(source)));
        return (CollationElementIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.823 -0400", hash_original_method = "0A03AD4A8EA2D5EFD885AFF079D1FBF8", hash_generated_method = "D8B9A2B0A66787095D26C612E08BE1F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CollationElementIterator getCollationElementIterator(String source) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(source);
        {
            throw new NullPointerException();
        } //End block
        CollationElementIterator var86C17557BF5AC61776999CA7479588A7_1812197148 = (new CollationElementIterator(icuColl.getCollationElementIterator(source)));
        return (CollationElementIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.825 -0400", hash_original_method = "FF8EDD58F3376852427F0295E98F1202", hash_generated_method = "6FFD248F9A72AD7686C4F90BDF20F481")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRules() {
        String var5324726C5F742A7B7850634C18B018B6_1234212407 = (icuColl.getRules());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return icuColl.getRules();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.826 -0400", hash_original_method = "FBA963D7A9FB0658F4932AD387478243", hash_generated_method = "366E5EA87B91393810F6A3B88E23506A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.827 -0400", hash_original_method = "6590B43BC0A35CBDE76A6B18FA6459C5", hash_generated_method = "C2FB7802126E50CB8CCD922846CEA378")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int compare(String source, String target) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(target);
        {
            throw new NullPointerException();
        } //End block
        int varA6E0FB9399BDCEE39D05264A8EB646FD_1328019661 = (icuColl.compare(source, target));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (source == null || target == null) {
            //throw new NullPointerException();
        //}
        //return icuColl.compare(source, target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.828 -0400", hash_original_method = "A9AF4E46AA414E7FF98E8748BB278551", hash_generated_method = "E3F7E00CE288D7AD183A171B725F8AD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CollationKey getCollationKey(String source) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(source);
        CollationKey var955B2CB8C39C195120A267F70CB2586E_1859751144 = (icuColl.getCollationKey(source));
        return (CollationKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return icuColl.getCollationKey(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.830 -0400", hash_original_method = "B4EBBD96DB20771CAD5EB8825D399E3B", hash_generated_method = "FA77FE65F5B8E79387E3BF42FCF80BE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varF7028415B2CE61B4AB1FA0FC4E297A19_141205071 = (icuColl.getRules().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return icuColl.getRules().hashCode();
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 15:32:19.724 -0400",hash_original_method="1D9A70F4229C9ABE49C60D2B9C1F5E2A",hash_generated_method="5E6DE0153E6251ED1E621EFF49096D7A")
@Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        boolean var6E858EC9D9579AEA03A77B18029B02A3_1830876036 = (super.equals(obj));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(obj instanceof Collator)) {
            //return false;
        //}
        //return super.equals(obj);
    }

    
}


