package org.ccil.cowan.tagsoup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Element {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.896 -0400", hash_original_field = "E8584B0E37179A7B82F4A85271799B93", hash_generated_field = "3F58E4656692FD6FEAD0053A32B05324")

    private ElementType theType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.896 -0400", hash_original_field = "89E65547A8BBD28E301BA7733FD2E3AF", hash_generated_field = "B0A2FBEB8F242E836C1CA731A6AB041F")

    private AttributesImpl theAtts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.896 -0400", hash_original_field = "A42D0E0DE01D51B60927FDF6C1F0B526", hash_generated_field = "76A7ADBAEEEC2718891FF24B2F2B9374")

    private Element theNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.896 -0400", hash_original_field = "D8AE31ABFACD39F1529F19591E594EAD", hash_generated_field = "0EC43875BA19E67350871B910584306F")

    private boolean preclosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.897 -0400", hash_original_method = "99F284A13C47F669710FCFDC8EC8F9ED", hash_generated_method = "B1C5F8B124607918F0FDE82A4ABD9D88")
    public  Element(ElementType type, boolean defaultAttributes) {
        addTaint(defaultAttributes);
        theType = type;
    if(defaultAttributes)        
        theAtts = new AttributesImpl(type.atts());
        else
        theAtts = new AttributesImpl();
        theNext = null;
        preclosed = false;
        
        
        
		
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.897 -0400", hash_original_method = "BFA15C1190E0B500E7A321E762D22239", hash_generated_method = "422E209CF9D768E4914C8017DCA23B29")
    public ElementType type() {
ElementType varF51095CBFCCE381E73DD672B54BEF95F_461119508 =         theType;
        varF51095CBFCCE381E73DD672B54BEF95F_461119508.addTaint(taint);
        return varF51095CBFCCE381E73DD672B54BEF95F_461119508;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.897 -0400", hash_original_method = "5DFAF4737CD1323AC5BCD66ECC931C62", hash_generated_method = "1664CD3770F677C0DCCCCF3EB3AD285C")
    public AttributesImpl atts() {
AttributesImpl varFB5CAB611E727D03F638BBA9F461FD53_799499683 =         theAtts;
        varFB5CAB611E727D03F638BBA9F461FD53_799499683.addTaint(taint);
        return varFB5CAB611E727D03F638BBA9F461FD53_799499683;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.898 -0400", hash_original_method = "9BD985D9D137F9E87CC0C75657FC57B8", hash_generated_method = "0D793DF6C30A4E99537C4D69072BE383")
    public Element next() {
Element varB89BFAC58CA29A6FFD18C2AE8DA88577_988907934 =         theNext;
        varB89BFAC58CA29A6FFD18C2AE8DA88577_988907934.addTaint(taint);
        return varB89BFAC58CA29A6FFD18C2AE8DA88577_988907934;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.898 -0400", hash_original_method = "9784418C474A290336108D75EC2613BB", hash_generated_method = "B0D02388E7E125BF20397459054E2AB9")
    public void setNext(Element next) {
        theNext = next;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.898 -0400", hash_original_method = "4B70092235E7A40F6E106A246C1B1B53", hash_generated_method = "DF2977150C4B8F69B553F026A5767971")
    public String name() {
String var005C4062513861A340896052683FF400_863948633 =         theType.name();
        var005C4062513861A340896052683FF400_863948633.addTaint(taint);
        return var005C4062513861A340896052683FF400_863948633;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.899 -0400", hash_original_method = "80004BAEB2388ADEF62653D4EDD03DA4", hash_generated_method = "944B9D1098173E95C8E790F606BE2A1B")
    public String namespace() {
String var423C72382D1E2291404BC0912AFBCE6F_2028391033 =         theType.namespace();
        var423C72382D1E2291404BC0912AFBCE6F_2028391033.addTaint(taint);
        return var423C72382D1E2291404BC0912AFBCE6F_2028391033;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.899 -0400", hash_original_method = "013647E32C485C8E11074DEB96ED8B2D", hash_generated_method = "7816D3C3B40537D3593C88C0B4EBCEC6")
    public String localName() {
String varB3EF0FC926F2BDE57E879A05A0656297_260856236 =         theType.localName();
        varB3EF0FC926F2BDE57E879A05A0656297_260856236.addTaint(taint);
        return varB3EF0FC926F2BDE57E879A05A0656297_260856236;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.899 -0400", hash_original_method = "3430000E3BB78B9B3224C2ADE055F8C5", hash_generated_method = "8987C77F515FD7CFE2BFB6DAB0CF8B4C")
    public int model() {
        int var736FB8E81AE145E9ACFCE37EE55156CB_690542141 = (theType.model());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1005993333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1005993333;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.899 -0400", hash_original_method = "1DD49D169AB38515FFA4793B4461E091", hash_generated_method = "4CA198DF2432D335A619360B2E857860")
    public int memberOf() {
        int var86578D803F3E2C7995C52681C9AD2EB0_657434644 = (theType.memberOf());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784330342 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784330342;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.900 -0400", hash_original_method = "383432538F005F982D316492CCCB0325", hash_generated_method = "4171C2B6816F4133D6A4BB155128251A")
    public int flags() {
        int var711B48DD659D94FE27F8ADFDD5622E4A_856946754 = (theType.flags());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850447165 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850447165;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.900 -0400", hash_original_method = "BCFB422D01A5282722899F511B11ECF6", hash_generated_method = "F5FA67770FD10305C4B0DF44AFF1A250")
    public ElementType parent() {
ElementType varBCFFE70A770DBF894E201FA2576E81A0_1677164776 =         theType.parent();
        varBCFFE70A770DBF894E201FA2576E81A0_1677164776.addTaint(taint);
        return varBCFFE70A770DBF894E201FA2576E81A0_1677164776;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.901 -0400", hash_original_method = "BC680BBCF0406870088BFC77978994BB", hash_generated_method = "388E7A1112F0C21A9C7338A440FF242C")
    public boolean canContain(Element other) {
        addTaint(other.getTaint());
        boolean var8885BCA2DBC3218C8B2A336EB9FA1B44_19232472 = (theType.canContain(other.theType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2081283146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2081283146;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.901 -0400", hash_original_method = "D84E1EF02E49BC2153CE4E53757510D3", hash_generated_method = "4249155B1CC51900DBF381C89E01AC95")
    public void setAttribute(String name, String type, String value) {
        addTaint(value.getTaint());
        addTaint(type.getTaint());
        addTaint(name.getTaint());
        theType.setAttribute(theAtts, name, type, value);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.901 -0400", hash_original_method = "B1EC3E2E623AD0C28D4FB442F2195ED7", hash_generated_method = "4811898F9D444106B3C5C3D5A6BEC4D1")
    public void anonymize() {
for(int i = theAtts.getLength() - 1;i >= 0;i--)
        {
    if(theAtts.getType(i).equals("ID") ||
			    theAtts.getQName(i).equals("name"))            
            {
                theAtts.removeAttribute(i);
            } 
        } 
        
        
			
			    
				
				
			
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.902 -0400", hash_original_method = "D93155F43F41AF612E7774F463E1747A", hash_generated_method = "58ACB8CBF2A09804B1FD80B474F58E3E")
    public void clean() {
for(int i = theAtts.getLength() - 1;i >= 0;i--)
        {
            String name = theAtts.getLocalName(i);
    if(theAtts.getValue(i) == null || name == null ||
					name.length() == 0)            
            {
                theAtts.removeAttribute(i);
                continue;
            } 
        } 
        
        
			
			
					
				
				
				
			
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.903 -0400", hash_original_method = "4B2B445A367BD9870FD7E6D0B377F667", hash_generated_method = "9487A721FE8CC0EDA322618ED3CDFEEE")
    public void preclose() {
        preclosed = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.903 -0400", hash_original_method = "D6339CFBAEA862E2360C9454B8ED0BC8", hash_generated_method = "18F41F16A704A17045F377B2B5D4BEB6")
    public boolean isPreclosed() {
        boolean varD8AE31ABFACD39F1529F19591E594EAD_1117089601 = (preclosed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155764165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155764165;
        
        
    }

    
}

