package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;






public final class Phonemetadata {
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.175 -0400", hash_original_method = "AA2168146A79C42118444B1AF1D13430", hash_generated_method = "01D7B0EC1EB8E0CA70481AF327448A6E")
    private  Phonemetadata() {
        // ---------- Original Method ----------
    }

    
    public static class NumberFormat implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.176 -0400", hash_original_field = "EBB44F9DC35254EE54F96EB8D2936620", hash_generated_field = "BCFAB4E6509DB535E782A9A7638BF800")

        private boolean hasPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.176 -0400", hash_original_field = "7BA2602BE34151F7BF8709C5E6902A23", hash_generated_field = "A40119EC58A9ADBEEF7F74515C4824EB")

        private String pattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.176 -0400", hash_original_field = "FB3499637AAFAB74C9C7084B2A5F6485", hash_generated_field = "BB7D9B531AF497BD0CC6485A499825C4")

        private boolean hasFormat;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.176 -0400", hash_original_field = "E46CD8EF559BE4A57DCE6A0505568890", hash_generated_field = "331E3EC56817A5418D313A742EE6BAF6")

        private String format_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.176 -0400", hash_original_field = "2FC5ACB9349FF6307BF22B61065526C5", hash_generated_field = "8C6856D900C2B3217AAACE1CB04BBDC9")

        private java.util.List<String> leadingDigitsPattern_ = new java.util.ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.176 -0400", hash_original_field = "3BCF607E89F66B196F9AF26CAC995637", hash_generated_field = "92669F4414DE1997CD38BA06884F29EB")

        private boolean hasNationalPrefixFormattingRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.176 -0400", hash_original_field = "61056B131F75442BA186CE92F8481346", hash_generated_field = "B5917D98A0DF4DBF46F96EC8B9B42B54")

        private String nationalPrefixFormattingRule_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.176 -0400", hash_original_field = "FBF94AE436756F8EF0359BB5BCECE5A5", hash_generated_field = "1C2206B3A1E5D1FEEB3BC9386E1B8AEC")

        private boolean hasDomesticCarrierCodeFormattingRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.176 -0400", hash_original_field = "6FDFEB13B19DC6F980A9FF00FF64E797", hash_generated_field = "4E860583F8E21CB17BEAB512DD9874BA")

        private String domesticCarrierCodeFormattingRule_ = "";
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.176 -0400", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "8FEBA1E1E8A6552B6917C667BFAE4E78")
        public  NumberFormat() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        public static Builder newBuilder() {
            return new Builder();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.177 -0400", hash_original_method = "0246232EE6FB2A92C361AD6A40430F9A", hash_generated_method = "C7371E2B14258246AFD4E478F28D18C5")
        public boolean hasPattern() {
            boolean varEBB44F9DC35254EE54F96EB8D2936620_1402528693 = (hasPattern);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1610293998 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1610293998;
            // ---------- Original Method ----------
            //return hasPattern;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.177 -0400", hash_original_method = "42C6A53B1E4394F40C706B46BCE960D0", hash_generated_method = "0AEE9FA4567ECBB15F075DF18A1FFAA8")
        public String getPattern() {
String var4A613D4DAC6EC688BC758E9A858A48DD_1529567244 =             pattern_;
            var4A613D4DAC6EC688BC758E9A858A48DD_1529567244.addTaint(taint);
            return var4A613D4DAC6EC688BC758E9A858A48DD_1529567244;
            // ---------- Original Method ----------
            //return pattern_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.178 -0400", hash_original_method = "ED9D042141B07F3A02D73E93DCCEE4F0", hash_generated_method = "A89F9C20C38229946B462F6C72961E09")
        public NumberFormat setPattern(String value) {
            hasPattern = true;
            pattern_ = value;
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_259887273 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_259887273.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_259887273;
            // ---------- Original Method ----------
            //hasPattern = true;
            //pattern_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.178 -0400", hash_original_method = "68B5595866A3AC066C218CEE1670E78C", hash_generated_method = "D95915C3C118B4B7517187CD8292B5ED")
        public boolean hasFormat() {
            boolean varFB3499637AAFAB74C9C7084B2A5F6485_1256738514 = (hasFormat);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1108705139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1108705139;
            // ---------- Original Method ----------
            //return hasFormat;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.179 -0400", hash_original_method = "77809F0555E410001A5868E71E8924BD", hash_generated_method = "35FE35792EE36A6E6D02D2543EC06275")
        public String getFormat() {
String var2AAFBD016D6976304AA14A6508161568_794198774 =             format_;
            var2AAFBD016D6976304AA14A6508161568_794198774.addTaint(taint);
            return var2AAFBD016D6976304AA14A6508161568_794198774;
            // ---------- Original Method ----------
            //return format_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.179 -0400", hash_original_method = "791160F9BB3B0A81AD0DFEC24C1732C9", hash_generated_method = "C7739C50E10670DAC8BCC7461315E715")
        public NumberFormat setFormat(String value) {
            hasFormat = true;
            format_ = value;
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_126411052 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_126411052.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_126411052;
            // ---------- Original Method ----------
            //hasFormat = true;
            //format_ = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.180 -0400", hash_original_method = "E6A52876E9E1328523A23CDD4ADD6081", hash_generated_method = "EAEF8B5650B3437893D22B9DF74D0071")
        public java.util.List<String> leadingDigitPatterns() {
java.util.List<String> var7D1236E1B21A497AFD6C2FC374C6D184_1040292059 =             leadingDigitsPattern_;
            var7D1236E1B21A497AFD6C2FC374C6D184_1040292059.addTaint(taint);
            return var7D1236E1B21A497AFD6C2FC374C6D184_1040292059;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.180 -0400", hash_original_method = "A7BC4264224DD72A69FEDA104C14570A", hash_generated_method = "CA1DF5C3E39B2C90A32A55F724C2BED0")
        public int leadingDigitsPatternSize() {
            int var039BE43D5DAAF585572C5FE287765906_501985925 = (leadingDigitsPattern_.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_765034951 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_765034951;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.180 -0400", hash_original_method = "F45A9318A15D3A63FB863C1586B0A383", hash_generated_method = "D0E8F13A927CCFB9B97D9945F652D76B")
        public String getLeadingDigitsPattern(int index) {
            addTaint(index);
String var13DC532888B90A00625123EDE9790979_855092535 =             leadingDigitsPattern_.get(index);
            var13DC532888B90A00625123EDE9790979_855092535.addTaint(taint);
            return var13DC532888B90A00625123EDE9790979_855092535;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_.get(index);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.181 -0400", hash_original_method = "67AADF10399513606F7245D93555CAB7", hash_generated_method = "6C7E33A6BE1D42B23261178E11C79EA9")
        public NumberFormat addLeadingDigitsPattern(String value) {
            addTaint(value.getTaint());
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_457757175 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_457757175.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_457757175;
            } //End block
            leadingDigitsPattern_.add(value);
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_806033409 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_806033409.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_806033409;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //leadingDigitsPattern_.add(value);
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.181 -0400", hash_original_method = "A0F401EEBE63541205F643F348AC0373", hash_generated_method = "DD22AE1D7FA08B4BFD3F32790366078B")
        public boolean hasNationalPrefixFormattingRule() {
            boolean var3BCF607E89F66B196F9AF26CAC995637_858782607 = (hasNationalPrefixFormattingRule);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1265214930 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1265214930;
            // ---------- Original Method ----------
            //return hasNationalPrefixFormattingRule;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.182 -0400", hash_original_method = "4B4C80C20D7D7C0D6F8A6AA39111D13B", hash_generated_method = "EF6911F7E448A3DCDB2308EEA957F0DF")
        public String getNationalPrefixFormattingRule() {
String varBD110DC4C24C304B86D211A3959DF09B_355787244 =             nationalPrefixFormattingRule_;
            varBD110DC4C24C304B86D211A3959DF09B_355787244.addTaint(taint);
            return varBD110DC4C24C304B86D211A3959DF09B_355787244;
            // ---------- Original Method ----------
            //return nationalPrefixFormattingRule_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.182 -0400", hash_original_method = "6C67B9000B21FDC6ACFC6210DBD720A7", hash_generated_method = "959020791E0E00E4E04308CC979AF574")
        public NumberFormat setNationalPrefixFormattingRule(String value) {
            hasNationalPrefixFormattingRule = true;
            nationalPrefixFormattingRule_ = value;
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_1777902344 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1777902344.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1777902344;
            // ---------- Original Method ----------
            //hasNationalPrefixFormattingRule = true;
            //nationalPrefixFormattingRule_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.183 -0400", hash_original_method = "394C283EEDF7D9BA381FE6D7D2DD662E", hash_generated_method = "D1374719FBCA8CC4C2A13988EF25AF43")
        public NumberFormat clearNationalPrefixFormattingRule() {
            hasNationalPrefixFormattingRule = false;
            nationalPrefixFormattingRule_ = "";
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_868393905 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_868393905.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_868393905;
            // ---------- Original Method ----------
            //hasNationalPrefixFormattingRule = false;
            //nationalPrefixFormattingRule_ = "";
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.183 -0400", hash_original_method = "1D512C574271A1305D1AF9A0CCC5C6D3", hash_generated_method = "5B997C1A7270AF076BA05CC3FF385378")
        public boolean hasDomesticCarrierCodeFormattingRule() {
            boolean varFBF94AE436756F8EF0359BB5BCECE5A5_49682908 = (hasDomesticCarrierCodeFormattingRule);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236568070 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236568070;
            // ---------- Original Method ----------
            //return hasDomesticCarrierCodeFormattingRule;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.183 -0400", hash_original_method = "1D78023CBBDF63A0A2ACC33925BD120F", hash_generated_method = "7E8369E9981DD8743B95EE22D4707AAA")
        public String getDomesticCarrierCodeFormattingRule() {
String varDD191FBEB100D10A1D2F0E37B46E53E1_1040648447 =             domesticCarrierCodeFormattingRule_;
            varDD191FBEB100D10A1D2F0E37B46E53E1_1040648447.addTaint(taint);
            return varDD191FBEB100D10A1D2F0E37B46E53E1_1040648447;
            // ---------- Original Method ----------
            //return domesticCarrierCodeFormattingRule_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.184 -0400", hash_original_method = "2168D8046E4A0ED39DDD19551FD64D5A", hash_generated_method = "53FB99325D2CEA8D0078BCAD453C6A7B")
        public NumberFormat setDomesticCarrierCodeFormattingRule(String value) {
            hasDomesticCarrierCodeFormattingRule = true;
            domesticCarrierCodeFormattingRule_ = value;
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_381327104 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_381327104.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_381327104;
            // ---------- Original Method ----------
            //hasDomesticCarrierCodeFormattingRule = true;
            //domesticCarrierCodeFormattingRule_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.184 -0400", hash_original_method = "DEB91FB350FEBE5DEE35AF7BFA950AEF", hash_generated_method = "002EE9C73C4CD79026C6E3053960980E")
        public NumberFormat mergeFrom(NumberFormat other) {
            addTaint(other.getTaint());
            if(other.hasPattern())            
            {
                setPattern(other.getPattern());
            } //End block
            if(other.hasFormat())            
            {
                setFormat(other.getFormat());
            } //End block
            int leadingDigitsPatternSize = other.leadingDigitsPatternSize();
for(int i = 0;i < leadingDigitsPatternSize;i++)
            {
                addLeadingDigitsPattern(other.getLeadingDigitsPattern(i));
            } //End block
            if(other.hasNationalPrefixFormattingRule())            
            {
                setNationalPrefixFormattingRule(other.getNationalPrefixFormattingRule());
            } //End block
            if(other.hasDomesticCarrierCodeFormattingRule())            
            {
                setDomesticCarrierCodeFormattingRule(other.getDomesticCarrierCodeFormattingRule());
            } //End block
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_1129440639 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1129440639.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1129440639;
            // ---------- Original Method ----------
            //if (other.hasPattern()) {
        //setPattern(other.getPattern());
      //}
            //if (other.hasFormat()) {
        //setFormat(other.getFormat());
      //}
            //int leadingDigitsPatternSize = other.leadingDigitsPatternSize();
            //for (int i = 0; i < leadingDigitsPatternSize; i++) {
        //addLeadingDigitsPattern(other.getLeadingDigitsPattern(i));
      //}
            //if (other.hasNationalPrefixFormattingRule()) {
        //setNationalPrefixFormattingRule(other.getNationalPrefixFormattingRule());
      //}
            //if (other.hasDomesticCarrierCodeFormattingRule()) {
        //setDomesticCarrierCodeFormattingRule(other.getDomesticCarrierCodeFormattingRule());
      //}
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_method = "A100AA8318BC8064BB1FFCA8BFB04888", hash_generated_method = "98577CAED10A1B00797B9CAAFA5F8589")
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            addTaint(objectOutput.getTaint());
            objectOutput.writeUTF(pattern_);
            objectOutput.writeUTF(format_);
            int leadingDigitsPatternSize = leadingDigitsPatternSize();
            objectOutput.writeInt(leadingDigitsPatternSize);
for(int i = 0;i < leadingDigitsPatternSize;i++)
            {
                objectOutput.writeUTF(leadingDigitsPattern_.get(i));
            } //End block
            objectOutput.writeBoolean(hasNationalPrefixFormattingRule);
            if(hasNationalPrefixFormattingRule)            
            {
                objectOutput.writeUTF(nationalPrefixFormattingRule_);
            } //End block
            objectOutput.writeBoolean(hasDomesticCarrierCodeFormattingRule);
            if(hasDomesticCarrierCodeFormattingRule)            
            {
                objectOutput.writeUTF(domesticCarrierCodeFormattingRule_);
            } //End block
            // ---------- Original Method ----------
            //objectOutput.writeUTF(pattern_);
            //objectOutput.writeUTF(format_);
            //int leadingDigitsPatternSize = leadingDigitsPatternSize();
            //objectOutput.writeInt(leadingDigitsPatternSize);
            //for (int i = 0; i < leadingDigitsPatternSize; i++) {
        //objectOutput.writeUTF(leadingDigitsPattern_.get(i));
      //}
            //objectOutput.writeBoolean(hasNationalPrefixFormattingRule);
            //if (hasNationalPrefixFormattingRule) {
        //objectOutput.writeUTF(nationalPrefixFormattingRule_);
      //}
            //objectOutput.writeBoolean(hasDomesticCarrierCodeFormattingRule);
            //if (hasDomesticCarrierCodeFormattingRule) {
        //objectOutput.writeUTF(domesticCarrierCodeFormattingRule_);
      //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_method = "A5A163CCCC35630D5C707482125AAE27", hash_generated_method = "3809CF0CA7E93FA79AA91C4CC3BA2206")
        public void readExternal(ObjectInput objectInput) throws IOException {
            addTaint(objectInput.getTaint());
            setPattern(objectInput.readUTF());
            setFormat(objectInput.readUTF());
            int leadingDigitsPatternSize = objectInput.readInt();
for(int i = 0;i < leadingDigitsPatternSize;i++)
            {
                leadingDigitsPattern_.add(objectInput.readUTF());
            } //End block
            if(objectInput.readBoolean())            
            {
                setNationalPrefixFormattingRule(objectInput.readUTF());
            } //End block
            if(objectInput.readBoolean())            
            {
                setDomesticCarrierCodeFormattingRule(objectInput.readUTF());
            } //End block
            // ---------- Original Method ----------
            //setPattern(objectInput.readUTF());
            //setFormat(objectInput.readUTF());
            //int leadingDigitsPatternSize = objectInput.readInt();
            //for (int i = 0; i < leadingDigitsPatternSize; i++) {
        //leadingDigitsPattern_.add(objectInput.readUTF());
      //}
            //if (objectInput.readBoolean()) {
        //setNationalPrefixFormattingRule(objectInput.readUTF());
      //}
            //if (objectInput.readBoolean()) {
        //setDomesticCarrierCodeFormattingRule(objectInput.readUTF());
      //}
        }

        
        public static final class Builder extends NumberFormat {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_method = "0B2E67344AC06F839A81A2533D186625", hash_generated_method = "BB446E04D75EA63F80C79B7E30D7BEC5")
            public NumberFormat build() {
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_364739866 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_364739866.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_364739866;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
    public static class PhoneNumberDesc implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_field = "DF8FA0961A72330EDFA83A06858DAA6D", hash_generated_field = "FE0D4AC450B46E7BA63C0A5FF14C51C2")

        private boolean hasNationalNumberPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_field = "B9BBEC8ED347133624C9F13EC01959D6", hash_generated_field = "EEA13D95EC1A783CC3FD2A2EA5BF77DB")

        private String nationalNumberPattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_field = "5128B6327ABA67ABA34F0D40555173E8", hash_generated_field = "A5D4C78E7537A35AEAFB80E70E1EF9CF")

        private boolean hasPossibleNumberPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_field = "CE9BECD6E9AE72932A581A01A4BC72CF", hash_generated_field = "9740030449804334CD1D210C9AACA78D")

        private String possibleNumberPattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_field = "2439321B7A9F025B302F5484BF5AA1CC", hash_generated_field = "A377FEAF080DA6EA07178B0BF7E01505")

        private boolean hasExampleNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_field = "A267297FDB6460E899FB01789A537AEF", hash_generated_field = "D8EDB7AA5577953B265C1D4AEECCDF65")

        private String exampleNumber_ = "";
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_method = "7B50B3AE2E947514292047EE4CC3D0B3", hash_generated_method = "FF0F10C59E5A022C63A72AE504F6D672")
        public  PhoneNumberDesc() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        public static Builder newBuilder() {
            return new Builder();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.186 -0400", hash_original_method = "7AE951C08CA66D0892FA0795F4703C0D", hash_generated_method = "0CF8A4DAA5BAF2C06F99A56312740927")
        public boolean hasNationalNumberPattern() {
            boolean varDF8FA0961A72330EDFA83A06858DAA6D_1271610682 = (hasNationalNumberPattern);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476366241 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476366241;
            // ---------- Original Method ----------
            //return hasNationalNumberPattern;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.186 -0400", hash_original_method = "AE5307416A342E6E51B0D8AFEA64E005", hash_generated_method = "24569C1A895E89C3253020809688A0B0")
        public String getNationalNumberPattern() {
String varC42B48AE81C655A7BA632276B0D5BAF1_135277738 =             nationalNumberPattern_;
            varC42B48AE81C655A7BA632276B0D5BAF1_135277738.addTaint(taint);
            return varC42B48AE81C655A7BA632276B0D5BAF1_135277738;
            // ---------- Original Method ----------
            //return nationalNumberPattern_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.186 -0400", hash_original_method = "5843589EEE5242B872EEFCA090E2182C", hash_generated_method = "F38FD3058F1CB1F934D693FBC992B7CB")
        public PhoneNumberDesc setNationalNumberPattern(String value) {
            hasNationalNumberPattern = true;
            nationalNumberPattern_ = value;
PhoneNumberDesc var72A74007B2BE62B849F475C7BDA4658B_1481534947 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1481534947.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1481534947;
            // ---------- Original Method ----------
            //hasNationalNumberPattern = true;
            //nationalNumberPattern_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.186 -0400", hash_original_method = "0D2D12A828079BB292F0B693EDB7AA61", hash_generated_method = "997215D57C29886A1C9FC54303899113")
        public boolean hasPossibleNumberPattern() {
            boolean var5128B6327ABA67ABA34F0D40555173E8_207654256 = (hasPossibleNumberPattern);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361894978 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_361894978;
            // ---------- Original Method ----------
            //return hasPossibleNumberPattern;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.186 -0400", hash_original_method = "69E173398B553B507060BBCC25879496", hash_generated_method = "8AE5F9B358F05CEFD6A861773172E267")
        public String getPossibleNumberPattern() {
String varBDD637854148D9CF41233830DC280989_758121561 =             possibleNumberPattern_;
            varBDD637854148D9CF41233830DC280989_758121561.addTaint(taint);
            return varBDD637854148D9CF41233830DC280989_758121561;
            // ---------- Original Method ----------
            //return possibleNumberPattern_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.186 -0400", hash_original_method = "E6F0FD7A3910EDF596B66C25C9FCACCB", hash_generated_method = "2F1EC8ABDC641053C2C2B5C3D55C84F8")
        public PhoneNumberDesc setPossibleNumberPattern(String value) {
            hasPossibleNumberPattern = true;
            possibleNumberPattern_ = value;
PhoneNumberDesc var72A74007B2BE62B849F475C7BDA4658B_394721076 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_394721076.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_394721076;
            // ---------- Original Method ----------
            //hasPossibleNumberPattern = true;
            //possibleNumberPattern_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.186 -0400", hash_original_method = "9EA98547022BA9B31E373C0BBC90B4AD", hash_generated_method = "3B61FECBB724421CBB8A1D81D3E33E65")
        public boolean hasExampleNumber() {
            boolean var2439321B7A9F025B302F5484BF5AA1CC_70628474 = (hasExampleNumber);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666301167 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_666301167;
            // ---------- Original Method ----------
            //return hasExampleNumber;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.186 -0400", hash_original_method = "4F2E88760366816D23F2792FF3D4D910", hash_generated_method = "C6342E67B445AF416A97026A58CB0EB7")
        public String getExampleNumber() {
String var4ED1B8A2ED15923B5F0122D42E82B60F_1796449440 =             exampleNumber_;
            var4ED1B8A2ED15923B5F0122D42E82B60F_1796449440.addTaint(taint);
            return var4ED1B8A2ED15923B5F0122D42E82B60F_1796449440;
            // ---------- Original Method ----------
            //return exampleNumber_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.187 -0400", hash_original_method = "99D22C86FFDC5E436BCE118592FFD464", hash_generated_method = "134C0C6334A00805C1F9BBB2A9369571")
        public PhoneNumberDesc setExampleNumber(String value) {
            hasExampleNumber = true;
            exampleNumber_ = value;
PhoneNumberDesc var72A74007B2BE62B849F475C7BDA4658B_698538659 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_698538659.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_698538659;
            // ---------- Original Method ----------
            //hasExampleNumber = true;
            //exampleNumber_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.187 -0400", hash_original_method = "13E9D2F0445C754E67764A18611FF669", hash_generated_method = "9AF06ACD3C7C234C3873BE99055B44E6")
        public PhoneNumberDesc mergeFrom(PhoneNumberDesc other) {
            addTaint(other.getTaint());
            if(other.hasNationalNumberPattern())            
            {
                setNationalNumberPattern(other.getNationalNumberPattern());
            } //End block
            if(other.hasPossibleNumberPattern())            
            {
                setPossibleNumberPattern(other.getPossibleNumberPattern());
            } //End block
            if(other.hasExampleNumber())            
            {
                setExampleNumber(other.getExampleNumber());
            } //End block
PhoneNumberDesc var72A74007B2BE62B849F475C7BDA4658B_1703794459 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1703794459.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1703794459;
            // ---------- Original Method ----------
            //if (other.hasNationalNumberPattern()) {
        //setNationalNumberPattern(other.getNationalNumberPattern());
      //}
            //if (other.hasPossibleNumberPattern()) {
        //setPossibleNumberPattern(other.getPossibleNumberPattern());
      //}
            //if (other.hasExampleNumber()) {
        //setExampleNumber(other.getExampleNumber());
      //}
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.187 -0400", hash_original_method = "67972576318010D4A6F8FC5204742584", hash_generated_method = "F40441A910AA7B871282960BB42EB0D7")
        public boolean exactlySameAs(PhoneNumberDesc other) {
            addTaint(other.getTaint());
            boolean var650C1E7E662B7EDC859F2E164CFF5DF7_446203497 = (nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          exampleNumber_.equals(other.exampleNumber_));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1086742226 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1086742226;
            // ---------- Original Method ----------
            //return nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          //possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          //exampleNumber_.equals(other.exampleNumber_);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.188 -0400", hash_original_method = "A248C31238E31950C31B42AEACDEB8E6", hash_generated_method = "A909E843C569C6ED023C2461C1EECCD9")
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            addTaint(objectOutput.getTaint());
            objectOutput.writeBoolean(hasNationalNumberPattern);
            if(hasNationalNumberPattern)            
            {
                objectOutput.writeUTF(nationalNumberPattern_);
            } //End block
            objectOutput.writeBoolean(hasPossibleNumberPattern);
            if(hasPossibleNumberPattern)            
            {
                objectOutput.writeUTF(possibleNumberPattern_);
            } //End block
            objectOutput.writeBoolean(hasExampleNumber);
            if(hasExampleNumber)            
            {
                objectOutput.writeUTF(exampleNumber_);
            } //End block
            // ---------- Original Method ----------
            //objectOutput.writeBoolean(hasNationalNumberPattern);
            //if (hasNationalNumberPattern) {
        //objectOutput.writeUTF(nationalNumberPattern_);
      //}
            //objectOutput.writeBoolean(hasPossibleNumberPattern);
            //if (hasPossibleNumberPattern) {
        //objectOutput.writeUTF(possibleNumberPattern_);
      //}
            //objectOutput.writeBoolean(hasExampleNumber);
            //if (hasExampleNumber) {
        //objectOutput.writeUTF(exampleNumber_);
      //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.188 -0400", hash_original_method = "27FB9E0837C2CDBADF688660FFE7A75C", hash_generated_method = "32E346548B60C74BB7694BAF1F6E55C6")
        public void readExternal(ObjectInput objectInput) throws IOException {
            addTaint(objectInput.getTaint());
            if(objectInput.readBoolean())            
            {
                setNationalNumberPattern(objectInput.readUTF());
            } //End block
            if(objectInput.readBoolean())            
            {
                setPossibleNumberPattern(objectInput.readUTF());
            } //End block
            if(objectInput.readBoolean())            
            {
                setExampleNumber(objectInput.readUTF());
            } //End block
            // ---------- Original Method ----------
            //if (objectInput.readBoolean()) {
        //setNationalNumberPattern(objectInput.readUTF());
      //}
            //if (objectInput.readBoolean()) {
        //setPossibleNumberPattern(objectInput.readUTF());
      //}
            //if (objectInput.readBoolean()) {
        //setExampleNumber(objectInput.readUTF());
      //}
        }

        
        public static final class Builder extends PhoneNumberDesc {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.188 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.188 -0400", hash_original_method = "27A166D755957BD27B60D63CE4983A6A", hash_generated_method = "5B7E2637192E11277AA8BEAE928ACA47")
            public PhoneNumberDesc build() {
PhoneNumberDesc var72A74007B2BE62B849F475C7BDA4658B_490167988 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_490167988.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_490167988;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.188 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
    public static class PhoneMetadata implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.188 -0400", hash_original_field = "B1185F70DC285179A2028122A1753D38", hash_generated_field = "A3B9F71CE88284DA159E437E743AF585")

        private boolean hasGeneralDesc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.188 -0400", hash_original_field = "419108228A3D4DD7D84FDBBA426B692E", hash_generated_field = "7468C9C864A0465318B0CE4D7F53C201")

        private PhoneNumberDesc generalDesc_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.188 -0400", hash_original_field = "E592D649F417667F2723D6FFED6E2DB7", hash_generated_field = "E05C42AA9F7E3C173F9E6FFB96993C10")

        private boolean hasFixedLine;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.188 -0400", hash_original_field = "7D61EBE9F230AE4F535BB262D140087E", hash_generated_field = "6B2D29317DA7FDD4358F05B6ED70E817")

        private PhoneNumberDesc fixedLine_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "8624D101BA06AC461F2198E30D1F6A12", hash_generated_field = "6732DA5D8F7E44D3EB8E9B3B04D2C208")

        private boolean hasMobile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "9A3666ECDC25598E8B1F39C149B5248B", hash_generated_field = "B09F10BC9C29A32513C7F9D45C9DD65D")

        private PhoneNumberDesc mobile_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "75EB0178779C5B94A142C67A8A3A0895", hash_generated_field = "80FAAA0975BF29FCB14D951C0BEDC5C4")

        private boolean hasTollFree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "8A684838F9710DEC6492C65DEB5B5A0F", hash_generated_field = "80CDA2C3C5F8E5226552943E5B5D1962")

        private PhoneNumberDesc tollFree_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "6401DBC84CDD207E60C202A21F935454", hash_generated_field = "5A30F5E3B7119D5842288ABCFFE97498")

        private boolean hasPremiumRate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "A525D6594473341CA8B89D37798B312E", hash_generated_field = "A45FECABBF74FB7321F9023E44E33237")

        private PhoneNumberDesc premiumRate_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "B64C7B1A99130C1E792DC2EC767D9EFB", hash_generated_field = "E49185F054F9F704C5600406F67DCB84")

        private boolean hasSharedCost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "1E9F4723F699DE8125552E21FFBFE400", hash_generated_field = "F1E7A155AA2DB5B0B5B95BFB0CEE31C9")

        private PhoneNumberDesc sharedCost_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "C6671814FF918E89A75FE4D83E386A68", hash_generated_field = "EDA3B33207D61D6AC565FA093ADCC196")

        private boolean hasPersonalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "1CFAD4514D14064196C72BF65F9CF559", hash_generated_field = "9BEB6F47AE29097500633D2F6F699031")

        private PhoneNumberDesc personalNumber_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "6993F15A6272097A69996233948D6788", hash_generated_field = "389614404066D2EFA2E54C2350D94AD0")

        private boolean hasVoip;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "4F48640F12EB1E254E7007633AE6A4BB", hash_generated_field = "EFA41A681D6E8CCFBC92A6D814B85301")

        private PhoneNumberDesc voip_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "F4712A7EC85B48169BE6F130B09401AF", hash_generated_field = "AA932FC09168FC29B0E1BDD3089132CB")

        private boolean hasPager;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "B53FED5DFF5974BE7B138F1CA58A1B36", hash_generated_field = "6DF80094481DB5FAFFA343EECB46293A")

        private PhoneNumberDesc pager_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "1C045935E1F5FA0A1792848701C607B3", hash_generated_field = "8F81ABDD16142E28D9E5984C6F740238")

        private boolean hasUan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "8579B62499AB55F965AD299835FB973C", hash_generated_field = "AD69C3410F5AE892799A6AC7CB2532E2")

        private PhoneNumberDesc uan_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "DA4DF0660D0FEED67B00F588F241E7EB", hash_generated_field = "0ADF693E546C325541D053D46F07CA67")

        private boolean hasNoInternationalDialling;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "460049B379C4B8AF431BAEE1EBCBF02E", hash_generated_field = "DB4742972A73F31DE788D6B88EE269C4")

        private PhoneNumberDesc noInternationalDialling_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "B00599996521998233C824ACCAB0E15F", hash_generated_field = "0140279EBB974905A38C47A7722FAFF6")

        private boolean hasId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "09E215DDF102AD5C73EE5F65A3C0CAB9", hash_generated_field = "A3944B7884E3A988EBAE9C53EFFAD5F5")

        private String id_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "8DA9382CFAB6A2934FA5AD3C46617F89", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

        private boolean hasCountryCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "3461D01D5A7F32E3FA9B229113397711", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

        private int countryCode_ = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "71E29C99125BF827B3C5BF568381086E", hash_generated_field = "5FC44BC01719FCF066ECC548BE8A5361")

        private boolean hasInternationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "E282158924B697D8BC6CAAE1BC57B7AB", hash_generated_field = "717A913C833941AC2C547FE2DFF1FB22")

        private String internationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "3ECE55B44C31E2628C42F70CE9639621", hash_generated_field = "A9895E937CD8DAE0C496DBC48D2C2CEE")

        private boolean hasPreferredInternationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "FCD8C7D7DFF78E7FA4B7EEE488EB6AC0", hash_generated_field = "CDC303EF35375A2E1F5FC52FA30A0AEF")

        private String preferredInternationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "4470362D119F8595D8A4313EC3BBE684", hash_generated_field = "7558F68656CC64EE957040556631A4B3")

        private boolean hasNationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "7FFC07608A27C8D4C3337E4B3E617A97", hash_generated_field = "9FD4079672B074B1C28FCBD5211F0E6E")

        private String nationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "CE3736A3B3D1072084220B70CD4D0A4F", hash_generated_field = "D4784FA8A81183D66211EA3CB7EAD63D")

        private boolean hasPreferredExtnPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "3BFE67D70B206F596FE6BB87EA4FC2EE", hash_generated_field = "F27B632A949D8FCEF65E426D0FEC59C2")

        private String preferredExtnPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.189 -0400", hash_original_field = "178A91AD8C9D4B311CBB7E9799C204D6", hash_generated_field = "507A8081AF30D85EF13F20C27737EE29")

        private boolean hasNationalPrefixForParsing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "5CE340B02A46FE9107F9780901340CAC", hash_generated_field = "46A092752488BEB0567E42ECBB5103EA")

        private String nationalPrefixForParsing_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "037AAC783F91D571F6E54112E2703ECE", hash_generated_field = "B59E7752C84471B249DCD9F9C398AFC5")

        private boolean hasNationalPrefixTransformRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "E828C84B52178E6A7F8B07EA0784D668", hash_generated_field = "08067D30B404B72AEBA1F2484BFD694C")

        private String nationalPrefixTransformRule_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "5E31C2CEC062E7B8113B945A2F2AA0E9", hash_generated_field = "31870DDEA4297A7CAB4D169E31FFFEBE")

        private boolean hasSameMobileAndFixedLinePattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "E4C862F971A24839C23EBE9F978A48B6", hash_generated_field = "789005A5E2E7FE7FCA1F46FB6F3F7B13")

        private boolean sameMobileAndFixedLinePattern_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "181C76BA224D14DBE65B8E0F96308942", hash_generated_field = "B800AB6258E8C26EC659EA232E613974")

        private java.util.List<NumberFormat> numberFormat_ = new java.util.ArrayList<NumberFormat>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "38053CEBD2D283DF20A1B56D88B2FD5C", hash_generated_field = "8438C32E42D261618BF3822D8254B874")

        private java.util.List<NumberFormat> intlNumberFormat_ = new java.util.ArrayList<NumberFormat>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "08D2B80646091F0A5CABE08AE2346FDA", hash_generated_field = "30F748667FFCDF08F79F81730072A8E1")

        private boolean hasMainCountryForCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "939EF08D7E9438FD155F13C644263B24", hash_generated_field = "7BE3C4CE079A909FDB8BCA00D97F89BF")

        private boolean mainCountryForCode_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "17079C6943CC232663CE7B61C9E492DB", hash_generated_field = "AE9DE5751CA76FAC5FD0690889290B59")

        private boolean hasLeadingDigits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "E5D90B3FC23E47C17AFA7132318C4380", hash_generated_field = "A2DF202A3B5F3D62339A3B2DE2A4FAB2")

        private String leadingDigits_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "352F42E9E2F51AB889A7ACC99B15F496", hash_generated_field = "4AEC48A66912462BA0FE869D7DC85F43")

        private boolean hasLeadingZeroPossible;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_field = "87145D95F10EE570BBC9AFAE6F259808", hash_generated_field = "F45DAF5712BFBE9A35415A4D733DC0FC")

        private boolean leadingZeroPossible_ = false;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.190 -0400", hash_original_method = "8411C48F959C93D1C6435DDA5C4FFBF8", hash_generated_method = "246EB5CC112F2B1B6402C47CB846FD5D")
        public  PhoneMetadata() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        public static Builder newBuilder() {
            return new Builder();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.191 -0400", hash_original_method = "573E786E141FAAA03A367F49BCA559B5", hash_generated_method = "E0EB0E0498CA7F25AD08A1B8384D9BEB")
        public boolean hasGeneralDesc() {
            boolean varB1185F70DC285179A2028122A1753D38_586075091 = (hasGeneralDesc);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763353116 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_763353116;
            // ---------- Original Method ----------
            //return hasGeneralDesc;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.191 -0400", hash_original_method = "F96C4A1868C09190E3C941F03A2889CB", hash_generated_method = "D82384D7C4D62B3CEAC780A77C7CDF28")
        public PhoneNumberDesc getGeneralDesc() {
PhoneNumberDesc var4C7B3B97088EAA66676A3875ED6B8A2C_949541937 =             generalDesc_;
            var4C7B3B97088EAA66676A3875ED6B8A2C_949541937.addTaint(taint);
            return var4C7B3B97088EAA66676A3875ED6B8A2C_949541937;
            // ---------- Original Method ----------
            //return generalDesc_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.191 -0400", hash_original_method = "97D824F311B5130867761544B2540B90", hash_generated_method = "2504BA96F1F2E7B608695F8E7C82A287")
        public PhoneMetadata setGeneralDesc(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2007010029 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_2007010029.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_2007010029;
            } //End block
            hasGeneralDesc = true;
            generalDesc_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1768772639 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1768772639.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1768772639;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasGeneralDesc = true;
            //generalDesc_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.191 -0400", hash_original_method = "0B06F02C38AE7EA6E1205EAD00F0F3D7", hash_generated_method = "51C1A5D19359E5D86C77694B6704A09D")
        public boolean hasFixedLine() {
            boolean varE592D649F417667F2723D6FFED6E2DB7_1434452814 = (hasFixedLine);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2095954375 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2095954375;
            // ---------- Original Method ----------
            //return hasFixedLine;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.191 -0400", hash_original_method = "7111E9DB2C9B99769226207CB0B39C0D", hash_generated_method = "C799BE69EB20415B7FDB1EE85A191D8D")
        public PhoneNumberDesc getFixedLine() {
PhoneNumberDesc var787CF5CB7BCDB84D66FEC693E18BBFD5_1543332732 =             fixedLine_;
            var787CF5CB7BCDB84D66FEC693E18BBFD5_1543332732.addTaint(taint);
            return var787CF5CB7BCDB84D66FEC693E18BBFD5_1543332732;
            // ---------- Original Method ----------
            //return fixedLine_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.191 -0400", hash_original_method = "4E0B7145906BC721C9DE8D0C32500FC9", hash_generated_method = "FECFC93ECC8674A3BF58F477E905A73B")
        public PhoneMetadata setFixedLine(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1489451067 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1489451067.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1489451067;
            } //End block
            hasFixedLine = true;
            fixedLine_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1035691825 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1035691825.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1035691825;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasFixedLine = true;
            //fixedLine_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.192 -0400", hash_original_method = "F5A454F163C8198EDADB6A0267665530", hash_generated_method = "8D64FDAD408C88DA08E3341BF8E0A216")
        public boolean hasMobile() {
            boolean var8624D101BA06AC461F2198E30D1F6A12_745653252 = (hasMobile);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211315218 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_211315218;
            // ---------- Original Method ----------
            //return hasMobile;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.192 -0400", hash_original_method = "469BFC723D37FABFB9BC30DE50B7B80A", hash_generated_method = "05085886572DF52C0830F1D7A73DAB14")
        public PhoneNumberDesc getMobile() {
PhoneNumberDesc varC153FD71E9716C86B0DB722C2C65FDA7_1190549631 =             mobile_;
            varC153FD71E9716C86B0DB722C2C65FDA7_1190549631.addTaint(taint);
            return varC153FD71E9716C86B0DB722C2C65FDA7_1190549631;
            // ---------- Original Method ----------
            //return mobile_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.192 -0400", hash_original_method = "CF0A4860566840BE9C27E4474979A50E", hash_generated_method = "5DB1E5E14B7E983EC22AD890F331B6C8")
        public PhoneMetadata setMobile(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1423628260 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1423628260.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1423628260;
            } //End block
            hasMobile = true;
            mobile_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_364427014 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_364427014.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_364427014;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasMobile = true;
            //mobile_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.192 -0400", hash_original_method = "C6BB80AB6E7BD893E9D8810967101490", hash_generated_method = "00D5B45FA7B757B7FF59EF59AC8F07C2")
        public boolean hasTollFree() {
            boolean var75EB0178779C5B94A142C67A8A3A0895_1361588601 = (hasTollFree);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_462336181 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_462336181;
            // ---------- Original Method ----------
            //return hasTollFree;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.192 -0400", hash_original_method = "A25CEA98E2A744A76CD23B6ECE21AB56", hash_generated_method = "C381A2FE2DCACC1716B3164F6C95BDB4")
        public PhoneNumberDesc getTollFree() {
PhoneNumberDesc var69110EE6A0D073111FD80E85FB87DBAF_1183929995 =             tollFree_;
            var69110EE6A0D073111FD80E85FB87DBAF_1183929995.addTaint(taint);
            return var69110EE6A0D073111FD80E85FB87DBAF_1183929995;
            // ---------- Original Method ----------
            //return tollFree_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.192 -0400", hash_original_method = "46A649F605F0EC24C76169E259456A93", hash_generated_method = "727D0EB27D2D0190F4D7CE571437DF98")
        public PhoneMetadata setTollFree(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1056317551 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1056317551.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1056317551;
            } //End block
            hasTollFree = true;
            tollFree_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1132285790 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1132285790.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1132285790;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasTollFree = true;
            //tollFree_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.192 -0400", hash_original_method = "82079540736B40B455CF317890B4623A", hash_generated_method = "5EBEC6CF5AC0BE3BA421AA3F2E25E6CC")
        public boolean hasPremiumRate() {
            boolean var6401DBC84CDD207E60C202A21F935454_1079682673 = (hasPremiumRate);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_438946897 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_438946897;
            // ---------- Original Method ----------
            //return hasPremiumRate;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.193 -0400", hash_original_method = "14341C327DA8E1CAAD52FEB1F27BC133", hash_generated_method = "1617EBEBC69A5EDCCE157621C9550CA1")
        public PhoneNumberDesc getPremiumRate() {
PhoneNumberDesc var4BD12C96666D7DC70DEC48E38C149D6D_1335213131 =             premiumRate_;
            var4BD12C96666D7DC70DEC48E38C149D6D_1335213131.addTaint(taint);
            return var4BD12C96666D7DC70DEC48E38C149D6D_1335213131;
            // ---------- Original Method ----------
            //return premiumRate_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.193 -0400", hash_original_method = "BC27E8EEE54A894FE20AA77CF35DD102", hash_generated_method = "5A45E48E4137BBB2D448CBDE5B7B992C")
        public PhoneMetadata setPremiumRate(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_152079855 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_152079855.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_152079855;
            } //End block
            hasPremiumRate = true;
            premiumRate_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_710634346 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_710634346.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_710634346;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPremiumRate = true;
            //premiumRate_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.193 -0400", hash_original_method = "3FC94E6C0EA4E13DD9DFC50367AE259A", hash_generated_method = "1452BF874EA5F6DC9216B2C9539944D8")
        public boolean hasSharedCost() {
            boolean varB64C7B1A99130C1E792DC2EC767D9EFB_1739769671 = (hasSharedCost);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_428023241 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_428023241;
            // ---------- Original Method ----------
            //return hasSharedCost;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.193 -0400", hash_original_method = "1FFB14D9D02DC30D3C5835101DD9BAF0", hash_generated_method = "14D168352A1C46FDFF6AC9581E6F0808")
        public PhoneNumberDesc getSharedCost() {
PhoneNumberDesc varD63474C6D2DA55D2359E72FFA0397BC0_545092813 =             sharedCost_;
            varD63474C6D2DA55D2359E72FFA0397BC0_545092813.addTaint(taint);
            return varD63474C6D2DA55D2359E72FFA0397BC0_545092813;
            // ---------- Original Method ----------
            //return sharedCost_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.193 -0400", hash_original_method = "CDEC9E0DF29779C1B33ED334AA2CAB69", hash_generated_method = "A179AF619FC3BA60EA1FFA1F0AC6D098")
        public PhoneMetadata setSharedCost(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_847601525 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_847601525.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_847601525;
            } //End block
            hasSharedCost = true;
            sharedCost_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1480008933 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1480008933.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1480008933;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasSharedCost = true;
            //sharedCost_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.193 -0400", hash_original_method = "0212D7D16A2BAA9CCCFC0F72E5660C30", hash_generated_method = "B8ACDBCC03450C4C0C28BC7F08A5CD3B")
        public boolean hasPersonalNumber() {
            boolean varC6671814FF918E89A75FE4D83E386A68_1856203247 = (hasPersonalNumber);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_520380009 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_520380009;
            // ---------- Original Method ----------
            //return hasPersonalNumber;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.193 -0400", hash_original_method = "4CF811D3746F6643A77AAC306D011902", hash_generated_method = "4C3F6CD008696B27FF0F02E1C4B6B98C")
        public PhoneNumberDesc getPersonalNumber() {
PhoneNumberDesc varCCE39C67DA22BC60D89245F287A7CFC3_1941216878 =             personalNumber_;
            varCCE39C67DA22BC60D89245F287A7CFC3_1941216878.addTaint(taint);
            return varCCE39C67DA22BC60D89245F287A7CFC3_1941216878;
            // ---------- Original Method ----------
            //return personalNumber_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.193 -0400", hash_original_method = "24493CAEB1946A8C79E7D00511D66307", hash_generated_method = "EA8D41F5475D50A617604657EA510242")
        public PhoneMetadata setPersonalNumber(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_59765237 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_59765237.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_59765237;
            } //End block
            hasPersonalNumber = true;
            personalNumber_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1472302983 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1472302983.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1472302983;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPersonalNumber = true;
            //personalNumber_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.193 -0400", hash_original_method = "96BC6C0B8CEC8C19A5CCD809DD7C636B", hash_generated_method = "746C0E88C255C3DADEBEA08A601E5A20")
        public boolean hasVoip() {
            boolean var6993F15A6272097A69996233948D6788_1791007124 = (hasVoip);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590799488 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_590799488;
            // ---------- Original Method ----------
            //return hasVoip;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.193 -0400", hash_original_method = "3E7A9D2F706E69069EF64F75DD5323E7", hash_generated_method = "57FBAF7AD61D30975624E65D5D8C96EF")
        public PhoneNumberDesc getVoip() {
PhoneNumberDesc varB6BEAAE69A06C703395DC04D82543F47_2034140260 =             voip_;
            varB6BEAAE69A06C703395DC04D82543F47_2034140260.addTaint(taint);
            return varB6BEAAE69A06C703395DC04D82543F47_2034140260;
            // ---------- Original Method ----------
            //return voip_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.194 -0400", hash_original_method = "5FE2D757C727FFFD1EC6F29B7720BADF", hash_generated_method = "2C003B6998D1ED81B17CECB5D3B9943B")
        public PhoneMetadata setVoip(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_982117622 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_982117622.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_982117622;
            } //End block
            hasVoip = true;
            voip_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1707183950 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1707183950.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1707183950;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasVoip = true;
            //voip_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.194 -0400", hash_original_method = "ACFB2D18067CB4D678DA99A9B4C18C84", hash_generated_method = "A5E36E86C71DF2221F1A5F9778867DA3")
        public boolean hasPager() {
            boolean varF4712A7EC85B48169BE6F130B09401AF_1392163387 = (hasPager);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845217653 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845217653;
            // ---------- Original Method ----------
            //return hasPager;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.194 -0400", hash_original_method = "C20F5AA8347238E1E9DA82F58997297F", hash_generated_method = "0E3BE0EB13B5E2F8BC0AA722E28A024C")
        public PhoneNumberDesc getPager() {
PhoneNumberDesc varBD60572279158F98063954A8F1A98F99_891036760 =             pager_;
            varBD60572279158F98063954A8F1A98F99_891036760.addTaint(taint);
            return varBD60572279158F98063954A8F1A98F99_891036760;
            // ---------- Original Method ----------
            //return pager_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.194 -0400", hash_original_method = "F7E7BD7CBC5C04503F79204D035D6093", hash_generated_method = "F8FAF9AD6B5970C7DC152563A1C880EF")
        public PhoneMetadata setPager(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1848118119 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1848118119.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1848118119;
            } //End block
            hasPager = true;
            pager_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1911793570 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1911793570.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1911793570;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPager = true;
            //pager_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.194 -0400", hash_original_method = "7052BD1D22DD33A68E8BFBF8EF4C8D7C", hash_generated_method = "D301C21F223BDE83A6B1B50B3CF69C0E")
        public boolean hasUan() {
            boolean var1C045935E1F5FA0A1792848701C607B3_2014857630 = (hasUan);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1930137513 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1930137513;
            // ---------- Original Method ----------
            //return hasUan;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.194 -0400", hash_original_method = "6E5CDB2B0554F6EDEAFB0A826808F837", hash_generated_method = "DDAA8C5819B3FB528EFCF7F3D800110E")
        public PhoneNumberDesc getUan() {
PhoneNumberDesc varA2E1686AE30820EA797ADF16D1725B57_1691435153 =             uan_;
            varA2E1686AE30820EA797ADF16D1725B57_1691435153.addTaint(taint);
            return varA2E1686AE30820EA797ADF16D1725B57_1691435153;
            // ---------- Original Method ----------
            //return uan_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.194 -0400", hash_original_method = "645A0026A31D8D600D28A5F0E2FCB775", hash_generated_method = "D12D2FC199C3426D3747AA702EDEC426")
        public PhoneMetadata setUan(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1761747546 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1761747546.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1761747546;
            } //End block
            hasUan = true;
            uan_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1886883273 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1886883273.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1886883273;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasUan = true;
            //uan_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.195 -0400", hash_original_method = "1D4CDC46AB20A45A27679F7FB2E14F5D", hash_generated_method = "6A832576413A552DE1F923A0AAD87F07")
        public boolean hasNoInternationalDialling() {
            boolean varDA4DF0660D0FEED67B00F588F241E7EB_609647500 = (hasNoInternationalDialling);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1430910710 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1430910710;
            // ---------- Original Method ----------
            //return hasNoInternationalDialling;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.195 -0400", hash_original_method = "8BF24E7280AB555752CDF0AB6293C8C0", hash_generated_method = "AABB620E24713E3E6BA9C765822A4C67")
        public PhoneNumberDesc getNoInternationalDialling() {
PhoneNumberDesc varE6ABAB09793DFEE925CACEF80C261845_1020489230 =             noInternationalDialling_;
            varE6ABAB09793DFEE925CACEF80C261845_1020489230.addTaint(taint);
            return varE6ABAB09793DFEE925CACEF80C261845_1020489230;
            // ---------- Original Method ----------
            //return noInternationalDialling_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.195 -0400", hash_original_method = "7DCE821DB5B30DD48C6A3A37AA42A1FD", hash_generated_method = "289465704A9B2618CC8E48F38ECBD2DD")
        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_993009857 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_993009857.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_993009857;
            } //End block
            hasNoInternationalDialling = true;
            noInternationalDialling_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_776761754 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_776761754.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_776761754;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasNoInternationalDialling = true;
            //noInternationalDialling_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.195 -0400", hash_original_method = "4B670822089DE57CBF3DD8C644F8C3E5", hash_generated_method = "8A58B8D654E95334130642DFFA52ED4B")
        public boolean hasId() {
            boolean varB00599996521998233C824ACCAB0E15F_203805426 = (hasId);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2124686663 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2124686663;
            // ---------- Original Method ----------
            //return hasId;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.195 -0400", hash_original_method = "C805C797DAF63B59CBD999295B2F5158", hash_generated_method = "EE1948C192B6D15682AAC58691593190")
        public String getId() {
String varF269FAEAC30E61C67F21006F1103E9D0_1214641770 =             id_;
            varF269FAEAC30E61C67F21006F1103E9D0_1214641770.addTaint(taint);
            return varF269FAEAC30E61C67F21006F1103E9D0_1214641770;
            // ---------- Original Method ----------
            //return id_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.195 -0400", hash_original_method = "6B3AD7A8DB5994F94639D3A9A0778D2B", hash_generated_method = "8E5D5FBB56FB8A36F5F2C8ECD4C060E1")
        public PhoneMetadata setId(String value) {
            hasId = true;
            id_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_2141059175 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2141059175.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2141059175;
            // ---------- Original Method ----------
            //hasId = true;
            //id_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.195 -0400", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "20771F20E402C663EED4AB15D77589DE")
        public boolean hasCountryCode() {
            boolean var8DA9382CFAB6A2934FA5AD3C46617F89_941367686 = (hasCountryCode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137370326 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137370326;
            // ---------- Original Method ----------
            //return hasCountryCode;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.195 -0400", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "6B154D7C79EE0C69ABAADBC827E7D780")
        public int getCountryCode() {
            int var3C5B11B8C2E2EEFEFDB13FA162E1622D_1619749629 = (countryCode_);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835560121 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835560121;
            // ---------- Original Method ----------
            //return countryCode_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.195 -0400", hash_original_method = "1AB7F6532DA188CC62A13C45F2B9ADF3", hash_generated_method = "0D5AC1FF6681A4535B596B7AC6B540EB")
        public PhoneMetadata setCountryCode(int value) {
            hasCountryCode = true;
            countryCode_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1373957650 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1373957650.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1373957650;
            // ---------- Original Method ----------
            //hasCountryCode = true;
            //countryCode_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.195 -0400", hash_original_method = "B89BF9592A7F16BE6654C3883F9898E5", hash_generated_method = "842EC7D2C8A21B343E3C01248CA31DCE")
        public boolean hasInternationalPrefix() {
            boolean var71E29C99125BF827B3C5BF568381086E_2137189057 = (hasInternationalPrefix);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2003769325 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2003769325;
            // ---------- Original Method ----------
            //return hasInternationalPrefix;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.196 -0400", hash_original_method = "09123B0A33DF502700CE0BB29A84EB95", hash_generated_method = "D6653A9897BB3A1DF1B489F5DE95860A")
        public String getInternationalPrefix() {
String varB48C0E880F380583AF707A79A375121E_1887867832 =             internationalPrefix_;
            varB48C0E880F380583AF707A79A375121E_1887867832.addTaint(taint);
            return varB48C0E880F380583AF707A79A375121E_1887867832;
            // ---------- Original Method ----------
            //return internationalPrefix_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.196 -0400", hash_original_method = "3DE0D2253FD6A81DEABED2BF406E5650", hash_generated_method = "D977B28AEF5D02AB3908D1A6D59A7E50")
        public PhoneMetadata setInternationalPrefix(String value) {
            hasInternationalPrefix = true;
            internationalPrefix_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_331028519 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_331028519.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_331028519;
            // ---------- Original Method ----------
            //hasInternationalPrefix = true;
            //internationalPrefix_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.196 -0400", hash_original_method = "3A1D043D6BB606ABB758EEC975A83919", hash_generated_method = "6F02CC75A5DAC8C3EDF411372317B125")
        public boolean hasPreferredInternationalPrefix() {
            boolean var3ECE55B44C31E2628C42F70CE9639621_1166529753 = (hasPreferredInternationalPrefix);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_765602286 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_765602286;
            // ---------- Original Method ----------
            //return hasPreferredInternationalPrefix;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.196 -0400", hash_original_method = "3992DDBA34CC5C49CFC74CF0545FF343", hash_generated_method = "3F3C4F13C6A10BD712F233A9F40C9DBA")
        public String getPreferredInternationalPrefix() {
String var09FD5A8E8E600C664F9C80767DD1035F_1159110483 =             preferredInternationalPrefix_;
            var09FD5A8E8E600C664F9C80767DD1035F_1159110483.addTaint(taint);
            return var09FD5A8E8E600C664F9C80767DD1035F_1159110483;
            // ---------- Original Method ----------
            //return preferredInternationalPrefix_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.196 -0400", hash_original_method = "2F2A95A6FC37FC6A654CD2ED9E105058", hash_generated_method = "6CED8E9411873AFFFB722B283A1244BE")
        public PhoneMetadata setPreferredInternationalPrefix(String value) {
            hasPreferredInternationalPrefix = true;
            preferredInternationalPrefix_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_348271344 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_348271344.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_348271344;
            // ---------- Original Method ----------
            //hasPreferredInternationalPrefix = true;
            //preferredInternationalPrefix_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.196 -0400", hash_original_method = "3FEC8563D97FEF0C0B81201609B8C138", hash_generated_method = "CEAD68107BC6C60A495F4DB3B303B3F7")
        public boolean hasNationalPrefix() {
            boolean var4470362D119F8595D8A4313EC3BBE684_618103777 = (hasNationalPrefix);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105528024 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105528024;
            // ---------- Original Method ----------
            //return hasNationalPrefix;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.196 -0400", hash_original_method = "3F6DDEA7E91472B57F47F7AA42FF40A4", hash_generated_method = "25E2F058740FF3754516655976E0C001")
        public String getNationalPrefix() {
String var5C39D3A24795B4888A8A79CE62FA327C_298443818 =             nationalPrefix_;
            var5C39D3A24795B4888A8A79CE62FA327C_298443818.addTaint(taint);
            return var5C39D3A24795B4888A8A79CE62FA327C_298443818;
            // ---------- Original Method ----------
            //return nationalPrefix_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.196 -0400", hash_original_method = "F24C638CA5CEB8CDF3416D52787AAB8D", hash_generated_method = "F4866699EBFD4A78184DEC848BF7DF16")
        public PhoneMetadata setNationalPrefix(String value) {
            hasNationalPrefix = true;
            nationalPrefix_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1460171445 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1460171445.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1460171445;
            // ---------- Original Method ----------
            //hasNationalPrefix = true;
            //nationalPrefix_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.197 -0400", hash_original_method = "E23165194A0E40A98A75B1CB3195C323", hash_generated_method = "0ED37F8BB285D4D32FA0839BD058B6CD")
        public boolean hasPreferredExtnPrefix() {
            boolean varCE3736A3B3D1072084220B70CD4D0A4F_1741272941 = (hasPreferredExtnPrefix);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234172102 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234172102;
            // ---------- Original Method ----------
            //return hasPreferredExtnPrefix;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.197 -0400", hash_original_method = "54C0428B3277F86E8CEE26D4467F5D32", hash_generated_method = "83AF7829E355444A3EEC99FD91921A55")
        public String getPreferredExtnPrefix() {
String var7B1E12B3052318BC37C1730A5C8A492E_2112267232 =             preferredExtnPrefix_;
            var7B1E12B3052318BC37C1730A5C8A492E_2112267232.addTaint(taint);
            return var7B1E12B3052318BC37C1730A5C8A492E_2112267232;
            // ---------- Original Method ----------
            //return preferredExtnPrefix_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.197 -0400", hash_original_method = "6AE031AAEF0021BEEE5C7C14D7E5ADEE", hash_generated_method = "8175FBC6B9DDA84F7E5B6713BE131ADC")
        public PhoneMetadata setPreferredExtnPrefix(String value) {
            hasPreferredExtnPrefix = true;
            preferredExtnPrefix_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1571146374 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1571146374.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1571146374;
            // ---------- Original Method ----------
            //hasPreferredExtnPrefix = true;
            //preferredExtnPrefix_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.197 -0400", hash_original_method = "079D2F6BDFB9C83E975C341D5D3984E8", hash_generated_method = "0F1A9CFF125842C1164CBB897F9F1EDD")
        public boolean hasNationalPrefixForParsing() {
            boolean var178A91AD8C9D4B311CBB7E9799C204D6_252136114 = (hasNationalPrefixForParsing);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1909750454 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1909750454;
            // ---------- Original Method ----------
            //return hasNationalPrefixForParsing;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.197 -0400", hash_original_method = "049975D1EC97C98DFAFD92CBA7A3DB4E", hash_generated_method = "F6C3B30BF513565D0B551E9718E0A187")
        public String getNationalPrefixForParsing() {
String var7D5E5B69634A1EE648E5B6802876DC76_1665138587 =             nationalPrefixForParsing_;
            var7D5E5B69634A1EE648E5B6802876DC76_1665138587.addTaint(taint);
            return var7D5E5B69634A1EE648E5B6802876DC76_1665138587;
            // ---------- Original Method ----------
            //return nationalPrefixForParsing_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.201 -0400", hash_original_method = "9C0BD3F3F0877996BC57F1866741042E", hash_generated_method = "62FCAC3476261DC41B914A7369079948")
        public PhoneMetadata setNationalPrefixForParsing(String value) {
            hasNationalPrefixForParsing = true;
            nationalPrefixForParsing_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_222765326 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_222765326.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_222765326;
            // ---------- Original Method ----------
            //hasNationalPrefixForParsing = true;
            //nationalPrefixForParsing_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.201 -0400", hash_original_method = "1810BCBEB4974245D7BFFA09C69DD621", hash_generated_method = "A40A9E35EACA9472A24BE1B0C6592949")
        public boolean hasNationalPrefixTransformRule() {
            boolean var037AAC783F91D571F6E54112E2703ECE_1389227937 = (hasNationalPrefixTransformRule);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131357860 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131357860;
            // ---------- Original Method ----------
            //return hasNationalPrefixTransformRule;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.201 -0400", hash_original_method = "55DE6447BA6383DE2B8CA08949083559", hash_generated_method = "082A4072C5073A1735BF885DB6E7A801")
        public String getNationalPrefixTransformRule() {
String varCBDA20BB93BF1FF264E4F9B48434DF65_1933502283 =             nationalPrefixTransformRule_;
            varCBDA20BB93BF1FF264E4F9B48434DF65_1933502283.addTaint(taint);
            return varCBDA20BB93BF1FF264E4F9B48434DF65_1933502283;
            // ---------- Original Method ----------
            //return nationalPrefixTransformRule_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.202 -0400", hash_original_method = "F0F297723C8F168223FB62622F5A1EB6", hash_generated_method = "3C589DE05CA9C991DB0F74ADD39AF067")
        public PhoneMetadata setNationalPrefixTransformRule(String value) {
            hasNationalPrefixTransformRule = true;
            nationalPrefixTransformRule_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_223736705 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_223736705.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_223736705;
            // ---------- Original Method ----------
            //hasNationalPrefixTransformRule = true;
            //nationalPrefixTransformRule_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.202 -0400", hash_original_method = "23B7A16EBE621B68A999B8F98C32C7FC", hash_generated_method = "6D5578040FE25A251C12C5014D3CB0D1")
        public boolean hasSameMobileAndFixedLinePattern() {
            boolean var5E31C2CEC062E7B8113B945A2F2AA0E9_1922227303 = (hasSameMobileAndFixedLinePattern);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1376523545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1376523545;
            // ---------- Original Method ----------
            //return hasSameMobileAndFixedLinePattern;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.202 -0400", hash_original_method = "0C8ED851B6AE0A07DB69452573173B34", hash_generated_method = "1820DDB2B2F65ED8A41C504D6D8C0B33")
        public boolean isSameMobileAndFixedLinePattern() {
            boolean var983F9C7C7CDF6761A728703994C00E8C_159355608 = (sameMobileAndFixedLinePattern_);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153332016 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153332016;
            // ---------- Original Method ----------
            //return sameMobileAndFixedLinePattern_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.204 -0400", hash_original_method = "4899ADA62C5B2767C955044A6A730FDD", hash_generated_method = "D306CBED777297427CB891DD1E7538DA")
        public PhoneMetadata setSameMobileAndFixedLinePattern(boolean value) {
            hasSameMobileAndFixedLinePattern = true;
            sameMobileAndFixedLinePattern_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_309080051 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_309080051.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_309080051;
            // ---------- Original Method ----------
            //hasSameMobileAndFixedLinePattern = true;
            //sameMobileAndFixedLinePattern_ = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.204 -0400", hash_original_method = "84A1634AEDD3ABF2CF1A3014B5D415EB", hash_generated_method = "1D7C666E027BE999719076818918937D")
        public java.util.List<NumberFormat> numberFormats() {
java.util.List<NumberFormat> var702269FAB9B8E162744A1FBA938D46B8_274056869 =             numberFormat_;
            var702269FAB9B8E162744A1FBA938D46B8_274056869.addTaint(taint);
            return var702269FAB9B8E162744A1FBA938D46B8_274056869;
            // ---------- Original Method ----------
            //return numberFormat_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.204 -0400", hash_original_method = "926251D4CC15A970A4459B1AE98E21C5", hash_generated_method = "F44E5F437DD9D79DFAA948D5598E65E9")
        public int numberFormatSize() {
            int var8D791A6EE08658BD1D9E8E744CC9D556_3858733 = (numberFormat_.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208477463 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208477463;
            // ---------- Original Method ----------
            //return numberFormat_.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.204 -0400", hash_original_method = "A540DB640DF9F8195853729D5B88BC06", hash_generated_method = "3CBE45814B10177D51ACF05D18C993AA")
        public NumberFormat getNumberFormat(int index) {
            addTaint(index);
NumberFormat varA049E8D704FC18C0322F6A3E2DCEB37E_196816541 =             numberFormat_.get(index);
            varA049E8D704FC18C0322F6A3E2DCEB37E_196816541.addTaint(taint);
            return varA049E8D704FC18C0322F6A3E2DCEB37E_196816541;
            // ---------- Original Method ----------
            //return numberFormat_.get(index);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.204 -0400", hash_original_method = "6431B417B09BF16DE184C0BF7BFD8C0A", hash_generated_method = "579148BB9BBF05F0DBCF6DB61BEDF6F5")
        public PhoneMetadata addNumberFormat(NumberFormat value) {
            addTaint(value.getTaint());
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_472448598 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_472448598.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_472448598;
            } //End block
            numberFormat_.add(value);
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1449151958 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1449151958.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1449151958;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //numberFormat_.add(value);
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.205 -0400", hash_original_method = "AE158E1AC846181939D70DB177BF740E", hash_generated_method = "31803467D6D08AAE494456BBE63105A0")
        public java.util.List<NumberFormat> intlNumberFormats() {
java.util.List<NumberFormat> varB0366A78C2DAD208E15B4E68FFB4A87E_657202 =             intlNumberFormat_;
            varB0366A78C2DAD208E15B4E68FFB4A87E_657202.addTaint(taint);
            return varB0366A78C2DAD208E15B4E68FFB4A87E_657202;
            // ---------- Original Method ----------
            //return intlNumberFormat_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.205 -0400", hash_original_method = "58F2978D59C0EB64F45AEE8E7A3A3ECF", hash_generated_method = "134BD66F00DAD49372471D1BB6375B3C")
        public int intlNumberFormatSize() {
            int var3350A78C4DA1132B93694A858CC31D9D_1152219105 = (intlNumberFormat_.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1326395464 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1326395464;
            // ---------- Original Method ----------
            //return intlNumberFormat_.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.205 -0400", hash_original_method = "14BAA3A4AA80C468A085BC9B63542EE0", hash_generated_method = "D6E1B4B5B5D9D4A4F6775352153BCA19")
        public NumberFormat getIntlNumberFormat(int index) {
            addTaint(index);
NumberFormat var2869E6EC0F45B166B5956E42FFC4008A_138114982 =             intlNumberFormat_.get(index);
            var2869E6EC0F45B166B5956E42FFC4008A_138114982.addTaint(taint);
            return var2869E6EC0F45B166B5956E42FFC4008A_138114982;
            // ---------- Original Method ----------
            //return intlNumberFormat_.get(index);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.207 -0400", hash_original_method = "DDE7F201B8001F4279DAEE9969BC3EF9", hash_generated_method = "CBC26398CC7CB43F207FDD2C00A46BA8")
        public PhoneMetadata addIntlNumberFormat(NumberFormat value) {
            addTaint(value.getTaint());
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_545682452 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_545682452.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_545682452;
            } //End block
            intlNumberFormat_.add(value);
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_748673088 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_748673088.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_748673088;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //intlNumberFormat_.add(value);
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.208 -0400", hash_original_method = "C1C6B471737DB86E719E8005B048F8A4", hash_generated_method = "9D42BCEB478821D9DA78A71F16EF2C35")
        public PhoneMetadata clearIntlNumberFormat() {
            intlNumberFormat_.clear();
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1630195409 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1630195409.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1630195409;
            // ---------- Original Method ----------
            //intlNumberFormat_.clear();
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.208 -0400", hash_original_method = "F0A3F725FE27520DECCABEEE1451ABF4", hash_generated_method = "A90AC105F78BAD4B1C5C97E4273C9FA9")
        public boolean hasMainCountryForCode() {
            boolean var08D2B80646091F0A5CABE08AE2346FDA_755332952 = (hasMainCountryForCode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1082330225 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1082330225;
            // ---------- Original Method ----------
            //return hasMainCountryForCode;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.238 -0400", hash_original_method = "CF03E78162809AA6058F20CA8B82C717", hash_generated_method = "7134ED5C4C16522B3ABA08E241B5E2C7")
        public boolean isMainCountryForCode() {
            boolean varB9D64FD23EE8D3F10C4FF8D18442C47D_761740009 = (mainCountryForCode_);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_23519756 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_23519756;
            // ---------- Original Method ----------
            //return mainCountryForCode_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.238 -0400", hash_original_method = "8B579A48BF103BAE8E5F2D34ABF5A62F", hash_generated_method = "1D946C85803214925C5952AA5E901FA5")
        public boolean getMainCountryForCode() {
            boolean varB9D64FD23EE8D3F10C4FF8D18442C47D_1375585571 = (mainCountryForCode_);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650330192 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650330192;
            // ---------- Original Method ----------
            //return mainCountryForCode_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.238 -0400", hash_original_method = "0E977089CAAEFAD04CCCDA9E72421381", hash_generated_method = "44F7547E9AEB95A57756778705249D25")
        public PhoneMetadata setMainCountryForCode(boolean value) {
            hasMainCountryForCode = true;
            mainCountryForCode_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_565102148 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_565102148.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_565102148;
            // ---------- Original Method ----------
            //hasMainCountryForCode = true;
            //mainCountryForCode_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.238 -0400", hash_original_method = "46DBCF13AB23890B1C354034C02AAE0D", hash_generated_method = "315C296A1238BF4EF5AA671B1E28B960")
        public boolean hasLeadingDigits() {
            boolean var17079C6943CC232663CE7B61C9E492DB_141597268 = (hasLeadingDigits);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1580462562 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1580462562;
            // ---------- Original Method ----------
            //return hasLeadingDigits;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.238 -0400", hash_original_method = "BA0CBA2DFD34C6F845467DDF3F7503AD", hash_generated_method = "E824B01859E4698FCDBCD76C173F3CEC")
        public String getLeadingDigits() {
String var39A62A047CE92200C52A50FD8914E24B_665085490 =             leadingDigits_;
            var39A62A047CE92200C52A50FD8914E24B_665085490.addTaint(taint);
            return var39A62A047CE92200C52A50FD8914E24B_665085490;
            // ---------- Original Method ----------
            //return leadingDigits_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.239 -0400", hash_original_method = "1B8095B1499A1300CC7FD6395528DFB9", hash_generated_method = "3D774786B0A8D9270C5B42E70D84259A")
        public PhoneMetadata setLeadingDigits(String value) {
            hasLeadingDigits = true;
            leadingDigits_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_219828131 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_219828131.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_219828131;
            // ---------- Original Method ----------
            //hasLeadingDigits = true;
            //leadingDigits_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.239 -0400", hash_original_method = "DF6824D9CE520B4AB88B3980F12D84DC", hash_generated_method = "0FAF847A59886D6004EB1E0EE295BE22")
        public boolean hasLeadingZeroPossible() {
            boolean var352F42E9E2F51AB889A7ACC99B15F496_2011959406 = (hasLeadingZeroPossible);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_379575018 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_379575018;
            // ---------- Original Method ----------
            //return hasLeadingZeroPossible;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.239 -0400", hash_original_method = "9CE4681262676BB262003F306366B26D", hash_generated_method = "8E3A3CA100BCB16D9B545B1631569AB1")
        public boolean isLeadingZeroPossible() {
            boolean var544EA9601687ABD32F40D28D321B0134_980583778 = (leadingZeroPossible_);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438321639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438321639;
            // ---------- Original Method ----------
            //return leadingZeroPossible_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.239 -0400", hash_original_method = "4E51759A218DB37A00D6735D1891D88D", hash_generated_method = "1E27F1E3AF46ACCD3324BB44771A1AB8")
        public PhoneMetadata setLeadingZeroPossible(boolean value) {
            hasLeadingZeroPossible = true;
            leadingZeroPossible_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1781328351 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1781328351.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1781328351;
            // ---------- Original Method ----------
            //hasLeadingZeroPossible = true;
            //leadingZeroPossible_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.239 -0400", hash_original_method = "82C82662DE792F1D24D935E7D9A568AC", hash_generated_method = "3CFDD3FA6CE8F7C207BBE12C0FCDDAD8")
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            addTaint(objectOutput.getTaint());
            objectOutput.writeBoolean(hasGeneralDesc);
            if(hasGeneralDesc)            
            {
                generalDesc_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasFixedLine);
            if(hasFixedLine)            
            {
                fixedLine_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasMobile);
            if(hasMobile)            
            {
                mobile_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasTollFree);
            if(hasTollFree)            
            {
                tollFree_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasPremiumRate);
            if(hasPremiumRate)            
            {
                premiumRate_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasSharedCost);
            if(hasSharedCost)            
            {
                sharedCost_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasPersonalNumber);
            if(hasPersonalNumber)            
            {
                personalNumber_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasVoip);
            if(hasVoip)            
            {
                voip_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasPager);
            if(hasPager)            
            {
                pager_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasUan);
            if(hasUan)            
            {
                uan_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasNoInternationalDialling);
            if(hasNoInternationalDialling)            
            {
                noInternationalDialling_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeUTF(id_);
            objectOutput.writeInt(countryCode_);
            objectOutput.writeUTF(internationalPrefix_);
            objectOutput.writeBoolean(hasPreferredInternationalPrefix);
            if(hasPreferredInternationalPrefix)            
            {
                objectOutput.writeUTF(preferredInternationalPrefix_);
            } //End block
            objectOutput.writeBoolean(hasNationalPrefix);
            if(hasNationalPrefix)            
            {
                objectOutput.writeUTF(nationalPrefix_);
            } //End block
            objectOutput.writeBoolean(hasPreferredExtnPrefix);
            if(hasPreferredExtnPrefix)            
            {
                objectOutput.writeUTF(preferredExtnPrefix_);
            } //End block
            objectOutput.writeBoolean(hasNationalPrefixForParsing);
            if(hasNationalPrefixForParsing)            
            {
                objectOutput.writeUTF(nationalPrefixForParsing_);
            } //End block
            objectOutput.writeBoolean(hasNationalPrefixTransformRule);
            if(hasNationalPrefixTransformRule)            
            {
                objectOutput.writeUTF(nationalPrefixTransformRule_);
            } //End block
            objectOutput.writeBoolean(sameMobileAndFixedLinePattern_);
            int numberFormatSize = numberFormatSize();
            objectOutput.writeInt(numberFormatSize);
for(int i = 0;i < numberFormatSize;i++)
            {
                numberFormat_.get(i).writeExternal(objectOutput);
            } //End block
            int intlNumberFormatSize = intlNumberFormatSize();
            objectOutput.writeInt(intlNumberFormatSize);
for(int i = 0;i < intlNumberFormatSize;i++)
            {
                intlNumberFormat_.get(i).writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(mainCountryForCode_);
            objectOutput.writeBoolean(hasLeadingDigits);
            if(hasLeadingDigits)            
            {
                objectOutput.writeUTF(leadingDigits_);
            } //End block
            objectOutput.writeBoolean(leadingZeroPossible_);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.240 -0400", hash_original_method = "4D891D3CC56C8A4A25C2FA3B62E66106", hash_generated_method = "68C4B4E6932F5678320FEB53BD6FBFC6")
        public void readExternal(ObjectInput objectInput) throws IOException {
            addTaint(objectInput.getTaint());
            boolean hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setGeneralDesc(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setFixedLine(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setMobile(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setTollFree(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setPremiumRate(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setSharedCost(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setPersonalNumber(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setVoip(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setPager(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setUan(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            if(hasDesc)            
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setNoInternationalDialling(desc);
            } //End block
            setId(objectInput.readUTF());
            setCountryCode(objectInput.readInt());
            setInternationalPrefix(objectInput.readUTF());
            boolean hasString = objectInput.readBoolean();
            if(hasString)            
            {
                setPreferredInternationalPrefix(objectInput.readUTF());
            } //End block
            hasString = objectInput.readBoolean();
            if(hasString)            
            {
                setNationalPrefix(objectInput.readUTF());
            } //End block
            hasString = objectInput.readBoolean();
            if(hasString)            
            {
                setPreferredExtnPrefix(objectInput.readUTF());
            } //End block
            hasString = objectInput.readBoolean();
            if(hasString)            
            {
                setNationalPrefixForParsing(objectInput.readUTF());
            } //End block
            hasString = objectInput.readBoolean();
            if(hasString)            
            {
                setNationalPrefixTransformRule(objectInput.readUTF());
            } //End block
            setSameMobileAndFixedLinePattern(objectInput.readBoolean());
            int nationalFormatSize = objectInput.readInt();
for(int i = 0;i < nationalFormatSize;i++)
            {
                NumberFormat numFormat = new NumberFormat();
                numFormat.readExternal(objectInput);
                numberFormat_.add(numFormat);
            } //End block
            int intlNumberFormatSize = objectInput.readInt();
for(int i = 0;i < intlNumberFormatSize;i++)
            {
                NumberFormat numFormat = new NumberFormat();
                numFormat.readExternal(objectInput);
                intlNumberFormat_.add(numFormat);
            } //End block
            setMainCountryForCode(objectInput.readBoolean());
            hasString = objectInput.readBoolean();
            if(hasString)            
            {
                setLeadingDigits(objectInput.readUTF());
            } //End block
            setLeadingZeroPossible(objectInput.readBoolean());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public static final class Builder extends PhoneMetadata {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.241 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.241 -0400", hash_original_method = "FECA3DB69AA5738CC513C59EB359D04E", hash_generated_method = "440072D3FB204E2C2570DBFA7CDF60D8")
            public PhoneMetadata build() {
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_792392782 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_792392782.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_792392782;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.241 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
    public static class PhoneMetadataCollection implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.241 -0400", hash_original_field = "612BD1F5CEECC04CA1A32C585074C146", hash_generated_field = "3988CF3B3569C765826A81A610C2CFA8")

        private java.util.List<PhoneMetadata> metadata_ = new java.util.ArrayList<PhoneMetadata>();
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.241 -0400", hash_original_method = "833FEC11FB1A703522FFE165412E2F7D", hash_generated_method = "911AB4D46731349730F9522D952A81AB")
        public  PhoneMetadataCollection() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.241 -0400", hash_original_method = "C5ECD645F70FA9D5A2A9EB8CBA32ADEF", hash_generated_method = "AC26030A7B95406DE206A0B848FFD1F7")
        public java.util.List<PhoneMetadata> getMetadataList() {
java.util.List<PhoneMetadata> var408FE00FE1CE1B7F862D9C0F3191C4A3_1226069768 =             metadata_;
            var408FE00FE1CE1B7F862D9C0F3191C4A3_1226069768.addTaint(taint);
            return var408FE00FE1CE1B7F862D9C0F3191C4A3_1226069768;
            // ---------- Original Method ----------
            //return metadata_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.241 -0400", hash_original_method = "95419ED058599C84B2A0103C5C8B3F30", hash_generated_method = "88F63991DE80D9731B50AF3897B51302")
        public int getMetadataCount() {
            int var4BF3C0E17ADF834B03066085E6DB37D6_846310875 = (metadata_.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659464324 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659464324;
            // ---------- Original Method ----------
            //return metadata_.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.241 -0400", hash_original_method = "D57D52560347164C8871C87ACF1DAD2C", hash_generated_method = "AB87C88EEFB1464F2DDB170F512A5876")
        public PhoneMetadataCollection addMetadata(PhoneMetadata value) {
            addTaint(value.getTaint());
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1526580859 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1526580859.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1526580859;
            } //End block
            metadata_.add(value);
PhoneMetadataCollection var72A74007B2BE62B849F475C7BDA4658B_57214723 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_57214723.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_57214723;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //metadata_.add(value);
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.242 -0400", hash_original_method = "BDFB00F39A05DC0D50872248169D293E", hash_generated_method = "1A957EA48698989247007B0B7BD1E431")
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            addTaint(objectOutput.getTaint());
            int size = getMetadataCount();
            objectOutput.writeInt(size);
for(int i = 0;i < size;i++)
            {
                metadata_.get(i).writeExternal(objectOutput);
            } //End block
            // ---------- Original Method ----------
            //int size = getMetadataCount();
            //objectOutput.writeInt(size);
            //for (int i = 0; i < size; i++) {
        //metadata_.get(i).writeExternal(objectOutput);
      //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.242 -0400", hash_original_method = "FAC331B8B6AD54634EE3CFAA3149ADF1", hash_generated_method = "1C5E8E34AE1D24EFF93B3420822781B5")
        public void readExternal(ObjectInput objectInput) throws IOException {
            addTaint(objectInput.getTaint());
            int size = objectInput.readInt();
for(int i = 0;i < size;i++)
            {
                PhoneMetadata metadata = new PhoneMetadata();
                metadata.readExternal(objectInput);
                metadata_.add(metadata);
            } //End block
            // ---------- Original Method ----------
            //int size = objectInput.readInt();
            //for (int i = 0; i < size; i++) {
        //PhoneMetadata metadata = new PhoneMetadata();
        //metadata.readExternal(objectInput);
        //metadata_.add(metadata);
      //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.242 -0400", hash_original_method = "1BB2E7D611D4F26F7F8136F4B2C1D585", hash_generated_method = "25403F991D0E076A23E13F547FCE7B64")
        public PhoneMetadataCollection clear() {
            metadata_.clear();
PhoneMetadataCollection var72A74007B2BE62B849F475C7BDA4658B_240346246 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_240346246.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_240346246;
            // ---------- Original Method ----------
            //metadata_.clear();
            //return this;
        }

        
        public static final class Builder extends PhoneMetadataCollection {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.242 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.242 -0400", hash_original_method = "62075F60ED3DD2393D61C900D272662C", hash_generated_method = "158E9A67CE0B09391006448802E7B6FE")
            public PhoneMetadataCollection build() {
PhoneMetadataCollection var72A74007B2BE62B849F475C7BDA4658B_1388178219 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1388178219.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1388178219;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.242 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
}

