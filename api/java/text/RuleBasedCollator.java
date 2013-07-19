package java.text;

// Droidsafe Imports
import libcore.icu.RuleBasedCollatorICU;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RuleBasedCollator extends Collator {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.922 -0400", hash_original_method = "31FBA21C05DBD02C02879BE90D845185", hash_generated_method = "4BAD392396C7D2F8879451F9FF7C21AB")
      RuleBasedCollator(RuleBasedCollatorICU wrapper) {
        super(wrapper);
        addTaint(wrapper.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.923 -0400", hash_original_method = "A2DABBE445FB3F5820A862D094AFC471", hash_generated_method = "023C4851F7E8C762EA036D144953EF25")
    public  RuleBasedCollator(String rules) throws ParseException {
        addTaint(rules.getTaint());
        if(rules == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1224836515 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1224836515.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1224836515;
        } //End block
        if(rules.isEmpty())        
        {
            ParseException var8F07A096E730965264408D7F1FB2E4DD_749107269 = new ParseException("empty rules", 0);
            var8F07A096E730965264408D7F1FB2E4DD_749107269.addTaint(taint);
            throw var8F07A096E730965264408D7F1FB2E4DD_749107269;
        } //End block
        try 
        {
            icuColl = new RuleBasedCollatorICU(rules);
        } //End block
        catch (Exception e)
        {
            if(e instanceof ParseException)            
            {
                ParseException var03BA1A9BB147D9FCB315D85BB9388505_246872031 = (ParseException) e;
                var03BA1A9BB147D9FCB315D85BB9388505_246872031.addTaint(taint);
                throw var03BA1A9BB147D9FCB315D85BB9388505_246872031;
            } //End block
            ParseException varE1B130A1C17A1A1F84C27925E9ECED2B_1315381951 = new ParseException(e.getMessage(), -1);
            varE1B130A1C17A1A1F84C27925E9ECED2B_1315381951.addTaint(taint);
            throw varE1B130A1C17A1A1F84C27925E9ECED2B_1315381951;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.924 -0400", hash_original_method = "C93FCBD8C41C04013259A24B3BA25AFC", hash_generated_method = "6D35D8069178E122A0728F61510B253C")
    public CollationElementIterator getCollationElementIterator(CharacterIterator source) {
        addTaint(source.getTaint());
        if(source == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1550088926 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1550088926.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1550088926;
        } //End block
CollationElementIterator var85D8D9BBFD7633380922301BECEE0F71_401815930 =         new CollationElementIterator(icuColl.getCollationElementIterator(source));
        var85D8D9BBFD7633380922301BECEE0F71_401815930.addTaint(taint);
        return var85D8D9BBFD7633380922301BECEE0F71_401815930;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.924 -0400", hash_original_method = "0A03AD4A8EA2D5EFD885AFF079D1FBF8", hash_generated_method = "46A96E69B66190CC7C2978C73B2CC374")
    public CollationElementIterator getCollationElementIterator(String source) {
        addTaint(source.getTaint());
        if(source == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1037937445 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1037937445.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1037937445;
        } //End block
CollationElementIterator var85D8D9BBFD7633380922301BECEE0F71_1908215264 =         new CollationElementIterator(icuColl.getCollationElementIterator(source));
        var85D8D9BBFD7633380922301BECEE0F71_1908215264.addTaint(taint);
        return var85D8D9BBFD7633380922301BECEE0F71_1908215264;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new NullPointerException();
        //}
        //return new CollationElementIterator(icuColl.getCollationElementIterator(source));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.925 -0400", hash_original_method = "FF8EDD58F3376852427F0295E98F1202", hash_generated_method = "5679EE98F077538ECB4889C12191997F")
    public String getRules() {
String var8A90C9DBB22B3B738EF7F72CD72CE87A_287679780 =         icuColl.getRules();
        var8A90C9DBB22B3B738EF7F72CD72CE87A_287679780.addTaint(taint);
        return var8A90C9DBB22B3B738EF7F72CD72CE87A_287679780;
        // ---------- Original Method ----------
        //return icuColl.getRules();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.925 -0400", hash_original_method = "FBA963D7A9FB0658F4932AD387478243", hash_generated_method = "77C2669E792F125351C0A06BD0E42AEF")
    @Override
    public Object clone() {
        RuleBasedCollator clone = (RuleBasedCollator) super.clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_2018375579 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_2018375579.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_2018375579;
        // ---------- Original Method ----------
        //RuleBasedCollator clone = (RuleBasedCollator) super.clone();
        //return clone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.926 -0400", hash_original_method = "6590B43BC0A35CBDE76A6B18FA6459C5", hash_generated_method = "49FC8DEEB42E8CE65BBBB9FFBE9EF9FA")
    @Override
    public int compare(String source, String target) {
        addTaint(target.getTaint());
        addTaint(source.getTaint());
        if(source == null || target == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1141762816 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1141762816.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1141762816;
        } //End block
        int var25D1126711FB6558DDCF970BA75507D5_1391859282 = (icuColl.compare(source, target));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2440299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2440299;
        // ---------- Original Method ----------
        //if (source == null || target == null) {
            //throw new NullPointerException();
        //}
        //return icuColl.compare(source, target);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.926 -0400", hash_original_method = "A9AF4E46AA414E7FF98E8748BB278551", hash_generated_method = "12802A805CEFD81F268E15F8B1846E20")
    @Override
    public CollationKey getCollationKey(String source) {
        addTaint(source.getTaint());
CollationKey var4C5119C68CB04FD6795DE91A08425B93_102346362 =         icuColl.getCollationKey(source);
        var4C5119C68CB04FD6795DE91A08425B93_102346362.addTaint(taint);
        return var4C5119C68CB04FD6795DE91A08425B93_102346362;
        // ---------- Original Method ----------
        //return icuColl.getCollationKey(source);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.926 -0400", hash_original_method = "B4EBBD96DB20771CAD5EB8825D399E3B", hash_generated_method = "9451A0B7BC5C1CAFBA8204FF2882F07D")
    @Override
    public int hashCode() {
        int var2635B84BF6950E4AA61B2BCF0C140853_1142818440 = (icuColl.getRules().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452541684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452541684;
        // ---------- Original Method ----------
        //return icuColl.getRules().hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.927 -0400", hash_original_method = "1D9A70F4229C9ABE49C60D2B9C1F5E2A", hash_generated_method = "59460DFA9FE6173A34594A1DA385D526")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(!(obj instanceof Collator))        
        {
            boolean var68934A3E9455FA72420237EB05902327_178272041 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2021540512 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2021540512;
        } //End block
        boolean varFE1B16F4C6616369679551DCCAF57C34_1741081324 = (super.equals(obj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_765270925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_765270925;
        // ---------- Original Method ----------
        //if (!(obj instanceof Collator)) {
            //return false;
        //}
        //return super.equals(obj);
    }

    
}

