package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.icu.RuleBasedCollatorICU;

public class RuleBasedCollator extends Collator {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.659 -0400", hash_original_method = "31FBA21C05DBD02C02879BE90D845185", hash_generated_method = "4BAD392396C7D2F8879451F9FF7C21AB")
      RuleBasedCollator(RuleBasedCollatorICU wrapper) {
        super(wrapper);
        addTaint(wrapper.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.659 -0400", hash_original_method = "A2DABBE445FB3F5820A862D094AFC471", hash_generated_method = "5310EF898DCE07C16DE7E03217C2DCF4")
    public  RuleBasedCollator(String rules) throws ParseException {
        addTaint(rules.getTaint());
    if(rules == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_54730468 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_54730468.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_54730468;
        } //End block
    if(rules.isEmpty())        
        {
            ParseException var8F07A096E730965264408D7F1FB2E4DD_1859148385 = new ParseException("empty rules", 0);
            var8F07A096E730965264408D7F1FB2E4DD_1859148385.addTaint(taint);
            throw var8F07A096E730965264408D7F1FB2E4DD_1859148385;
        } //End block
        try 
        {
            icuColl = new RuleBasedCollatorICU(rules);
        } //End block
        catch (Exception e)
        {
    if(e instanceof ParseException)            
            {
                ParseException var03BA1A9BB147D9FCB315D85BB9388505_1504025507 = (ParseException) e;
                var03BA1A9BB147D9FCB315D85BB9388505_1504025507.addTaint(taint);
                throw var03BA1A9BB147D9FCB315D85BB9388505_1504025507;
            } //End block
            ParseException varE1B130A1C17A1A1F84C27925E9ECED2B_790033075 = new ParseException(e.getMessage(), -1);
            varE1B130A1C17A1A1F84C27925E9ECED2B_790033075.addTaint(taint);
            throw varE1B130A1C17A1A1F84C27925E9ECED2B_790033075;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.660 -0400", hash_original_method = "C93FCBD8C41C04013259A24B3BA25AFC", hash_generated_method = "FD4C9052A04ED9FC75AB1982F733198D")
    public CollationElementIterator getCollationElementIterator(CharacterIterator source) {
        addTaint(source.getTaint());
    if(source == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1849094102 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1849094102.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1849094102;
        } //End block
CollationElementIterator var85D8D9BBFD7633380922301BECEE0F71_786166059 =         new CollationElementIterator(icuColl.getCollationElementIterator(source));
        var85D8D9BBFD7633380922301BECEE0F71_786166059.addTaint(taint);
        return var85D8D9BBFD7633380922301BECEE0F71_786166059;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.660 -0400", hash_original_method = "0A03AD4A8EA2D5EFD885AFF079D1FBF8", hash_generated_method = "84DCD0291CE363E26909E392AE3573F2")
    public CollationElementIterator getCollationElementIterator(String source) {
        addTaint(source.getTaint());
    if(source == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1648680368 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1648680368.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1648680368;
        } //End block
CollationElementIterator var85D8D9BBFD7633380922301BECEE0F71_1679622688 =         new CollationElementIterator(icuColl.getCollationElementIterator(source));
        var85D8D9BBFD7633380922301BECEE0F71_1679622688.addTaint(taint);
        return var85D8D9BBFD7633380922301BECEE0F71_1679622688;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.660 -0400", hash_original_method = "FF8EDD58F3376852427F0295E98F1202", hash_generated_method = "DFB8A3BDDC39D14C70A9106CB75586AE")
    public String getRules() {
String var8A90C9DBB22B3B738EF7F72CD72CE87A_6326798 =         icuColl.getRules();
        var8A90C9DBB22B3B738EF7F72CD72CE87A_6326798.addTaint(taint);
        return var8A90C9DBB22B3B738EF7F72CD72CE87A_6326798;
        // ---------- Original Method ----------
        //return icuColl.getRules();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.661 -0400", hash_original_method = "FBA963D7A9FB0658F4932AD387478243", hash_generated_method = "0CCAEEDCEAFAC17D61A84873DFE79997")
    @Override
    public Object clone() {
        RuleBasedCollator clone = (RuleBasedCollator) super.clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_2136767315 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_2136767315.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_2136767315;
        // ---------- Original Method ----------
        //RuleBasedCollator clone = (RuleBasedCollator) super.clone();
        //return clone;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.661 -0400", hash_original_method = "6590B43BC0A35CBDE76A6B18FA6459C5", hash_generated_method = "D6B0359E7E6D13FA5C2C54EE791F9B00")
    @Override
    public int compare(String source, String target) {
        addTaint(target.getTaint());
        addTaint(source.getTaint());
    if(source == null || target == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_374354861 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_374354861.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_374354861;
        } //End block
        int var25D1126711FB6558DDCF970BA75507D5_119755882 = (icuColl.compare(source, target));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906703270 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906703270;
        // ---------- Original Method ----------
        //if (source == null || target == null) {
            //throw new NullPointerException();
        //}
        //return icuColl.compare(source, target);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.661 -0400", hash_original_method = "A9AF4E46AA414E7FF98E8748BB278551", hash_generated_method = "36F6AD9117159F00BAC8CB8904EC2FC9")
    @Override
    public CollationKey getCollationKey(String source) {
        addTaint(source.getTaint());
CollationKey var4C5119C68CB04FD6795DE91A08425B93_1138960968 =         icuColl.getCollationKey(source);
        var4C5119C68CB04FD6795DE91A08425B93_1138960968.addTaint(taint);
        return var4C5119C68CB04FD6795DE91A08425B93_1138960968;
        // ---------- Original Method ----------
        //return icuColl.getCollationKey(source);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.662 -0400", hash_original_method = "B4EBBD96DB20771CAD5EB8825D399E3B", hash_generated_method = "93ED650EDF2F48208E6F4CFB50A4DC98")
    @Override
    public int hashCode() {
        int var2635B84BF6950E4AA61B2BCF0C140853_1193879774 = (icuColl.getRules().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917488053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917488053;
        // ---------- Original Method ----------
        //return icuColl.getRules().hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.662 -0400", hash_original_method = "1D9A70F4229C9ABE49C60D2B9C1F5E2A", hash_generated_method = "CBEDBFD06A67E4CA533E7CEABD9D5CEE")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(!(obj instanceof Collator))        
        {
            boolean var68934A3E9455FA72420237EB05902327_960152613 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247232650 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247232650;
        } //End block
        boolean varFE1B16F4C6616369679551DCCAF57C34_1885479716 = (super.equals(obj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645254913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_645254913;
        // ---------- Original Method ----------
        //if (!(obj instanceof Collator)) {
            //return false;
        //}
        //return super.equals(obj);
    }

    
}

