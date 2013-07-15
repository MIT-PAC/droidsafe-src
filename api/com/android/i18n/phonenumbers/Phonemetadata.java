package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class Phonemetadata {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.086 -0400", hash_original_method = "AA2168146A79C42118444B1AF1D13430", hash_generated_method = "01D7B0EC1EB8E0CA70481AF327448A6E")
    private  Phonemetadata() {
        // ---------- Original Method ----------
    }

    
    public static class NumberFormat implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.086 -0400", hash_original_field = "EBB44F9DC35254EE54F96EB8D2936620", hash_generated_field = "BCFAB4E6509DB535E782A9A7638BF800")

        private boolean hasPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.086 -0400", hash_original_field = "7BA2602BE34151F7BF8709C5E6902A23", hash_generated_field = "A40119EC58A9ADBEEF7F74515C4824EB")

        private String pattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.086 -0400", hash_original_field = "FB3499637AAFAB74C9C7084B2A5F6485", hash_generated_field = "BB7D9B531AF497BD0CC6485A499825C4")

        private boolean hasFormat;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.086 -0400", hash_original_field = "E46CD8EF559BE4A57DCE6A0505568890", hash_generated_field = "331E3EC56817A5418D313A742EE6BAF6")

        private String format_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.086 -0400", hash_original_field = "2FC5ACB9349FF6307BF22B61065526C5", hash_generated_field = "8C6856D900C2B3217AAACE1CB04BBDC9")

        private java.util.List<String> leadingDigitsPattern_ = new java.util.ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.086 -0400", hash_original_field = "3BCF607E89F66B196F9AF26CAC995637", hash_generated_field = "92669F4414DE1997CD38BA06884F29EB")

        private boolean hasNationalPrefixFormattingRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.087 -0400", hash_original_field = "61056B131F75442BA186CE92F8481346", hash_generated_field = "B5917D98A0DF4DBF46F96EC8B9B42B54")

        private String nationalPrefixFormattingRule_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.087 -0400", hash_original_field = "FBF94AE436756F8EF0359BB5BCECE5A5", hash_generated_field = "1C2206B3A1E5D1FEEB3BC9386E1B8AEC")

        private boolean hasDomesticCarrierCodeFormattingRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.087 -0400", hash_original_field = "6FDFEB13B19DC6F980A9FF00FF64E797", hash_generated_field = "4E860583F8E21CB17BEAB512DD9874BA")

        private String domesticCarrierCodeFormattingRule_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.087 -0400", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "8FEBA1E1E8A6552B6917C667BFAE4E78")
        public  NumberFormat() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.087 -0400", hash_original_method = "0246232EE6FB2A92C361AD6A40430F9A", hash_generated_method = "17AC9981846EFD66938498B71995CED3")
        public boolean hasPattern() {
            boolean varEBB44F9DC35254EE54F96EB8D2936620_262275400 = (hasPattern);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787704085 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_787704085;
            // ---------- Original Method ----------
            //return hasPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.087 -0400", hash_original_method = "42C6A53B1E4394F40C706B46BCE960D0", hash_generated_method = "C4110CCFFF24B4F121241927595F1CBB")
        public String getPattern() {
String var4A613D4DAC6EC688BC758E9A858A48DD_944191069 =             pattern_;
            var4A613D4DAC6EC688BC758E9A858A48DD_944191069.addTaint(taint);
            return var4A613D4DAC6EC688BC758E9A858A48DD_944191069;
            // ---------- Original Method ----------
            //return pattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.088 -0400", hash_original_method = "ED9D042141B07F3A02D73E93DCCEE4F0", hash_generated_method = "7A9105E1FD841296761E04B9E8D78D8A")
        public NumberFormat setPattern(String value) {
            hasPattern = true;
            pattern_ = value;
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_983425493 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_983425493.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_983425493;
            // ---------- Original Method ----------
            //hasPattern = true;
            //pattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.088 -0400", hash_original_method = "68B5595866A3AC066C218CEE1670E78C", hash_generated_method = "8AF30E2011FC575F7495E6CEF4E7051B")
        public boolean hasFormat() {
            boolean varFB3499637AAFAB74C9C7084B2A5F6485_2137740885 = (hasFormat);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186161012 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186161012;
            // ---------- Original Method ----------
            //return hasFormat;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.088 -0400", hash_original_method = "77809F0555E410001A5868E71E8924BD", hash_generated_method = "BA70D0A5D0997C71D41286ED405BC994")
        public String getFormat() {
String var2AAFBD016D6976304AA14A6508161568_2123251269 =             format_;
            var2AAFBD016D6976304AA14A6508161568_2123251269.addTaint(taint);
            return var2AAFBD016D6976304AA14A6508161568_2123251269;
            // ---------- Original Method ----------
            //return format_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.089 -0400", hash_original_method = "791160F9BB3B0A81AD0DFEC24C1732C9", hash_generated_method = "D8BD93DF5745A4041F6EBD976DC364BE")
        public NumberFormat setFormat(String value) {
            hasFormat = true;
            format_ = value;
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_1103519614 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1103519614.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1103519614;
            // ---------- Original Method ----------
            //hasFormat = true;
            //format_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.089 -0400", hash_original_method = "E6A52876E9E1328523A23CDD4ADD6081", hash_generated_method = "70752542CCC1D7CCF69DA2D60C837479")
        public java.util.List<String> leadingDigitPatterns() {
java.util.List<String> var7D1236E1B21A497AFD6C2FC374C6D184_1826422061 =             leadingDigitsPattern_;
            var7D1236E1B21A497AFD6C2FC374C6D184_1826422061.addTaint(taint);
            return var7D1236E1B21A497AFD6C2FC374C6D184_1826422061;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.089 -0400", hash_original_method = "A7BC4264224DD72A69FEDA104C14570A", hash_generated_method = "9D185FCEEE4149D2E0AA3EAA6179973A")
        public int leadingDigitsPatternSize() {
            int var039BE43D5DAAF585572C5FE287765906_1344219464 = (leadingDigitsPattern_.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805997703 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805997703;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.090 -0400", hash_original_method = "F45A9318A15D3A63FB863C1586B0A383", hash_generated_method = "2B40C65CF01279BC36F4FF7EE979A818")
        public String getLeadingDigitsPattern(int index) {
            addTaint(index);
String var13DC532888B90A00625123EDE9790979_2044560384 =             leadingDigitsPattern_.get(index);
            var13DC532888B90A00625123EDE9790979_2044560384.addTaint(taint);
            return var13DC532888B90A00625123EDE9790979_2044560384;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.090 -0400", hash_original_method = "67AADF10399513606F7245D93555CAB7", hash_generated_method = "C735406D56A97673199A8A65556581DB")
        public NumberFormat addLeadingDigitsPattern(String value) {
            addTaint(value.getTaint());
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1163916200 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1163916200.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1163916200;
            } //End block
            leadingDigitsPattern_.add(value);
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_764755425 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_764755425.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_764755425;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //leadingDigitsPattern_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.090 -0400", hash_original_method = "A0F401EEBE63541205F643F348AC0373", hash_generated_method = "8EA3A7F97AA53C5A2153282594FAC369")
        public boolean hasNationalPrefixFormattingRule() {
            boolean var3BCF607E89F66B196F9AF26CAC995637_2042084742 = (hasNationalPrefixFormattingRule);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1372624179 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1372624179;
            // ---------- Original Method ----------
            //return hasNationalPrefixFormattingRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.091 -0400", hash_original_method = "4B4C80C20D7D7C0D6F8A6AA39111D13B", hash_generated_method = "0D6BC1D90D241B3B31C643518FD6B48A")
        public String getNationalPrefixFormattingRule() {
String varBD110DC4C24C304B86D211A3959DF09B_860989960 =             nationalPrefixFormattingRule_;
            varBD110DC4C24C304B86D211A3959DF09B_860989960.addTaint(taint);
            return varBD110DC4C24C304B86D211A3959DF09B_860989960;
            // ---------- Original Method ----------
            //return nationalPrefixFormattingRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.091 -0400", hash_original_method = "6C67B9000B21FDC6ACFC6210DBD720A7", hash_generated_method = "FB25B00726EB88E88695C5B4DFB993AC")
        public NumberFormat setNationalPrefixFormattingRule(String value) {
            hasNationalPrefixFormattingRule = true;
            nationalPrefixFormattingRule_ = value;
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_1474849207 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1474849207.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1474849207;
            // ---------- Original Method ----------
            //hasNationalPrefixFormattingRule = true;
            //nationalPrefixFormattingRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.092 -0400", hash_original_method = "394C283EEDF7D9BA381FE6D7D2DD662E", hash_generated_method = "83D5085725DED223CE8E3D1665FF8697")
        public NumberFormat clearNationalPrefixFormattingRule() {
            hasNationalPrefixFormattingRule = false;
            nationalPrefixFormattingRule_ = "";
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_1546415814 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1546415814.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1546415814;
            // ---------- Original Method ----------
            //hasNationalPrefixFormattingRule = false;
            //nationalPrefixFormattingRule_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.092 -0400", hash_original_method = "1D512C574271A1305D1AF9A0CCC5C6D3", hash_generated_method = "191C040759813E223FA058B8DBD54E92")
        public boolean hasDomesticCarrierCodeFormattingRule() {
            boolean varFBF94AE436756F8EF0359BB5BCECE5A5_956470324 = (hasDomesticCarrierCodeFormattingRule);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826760189 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_826760189;
            // ---------- Original Method ----------
            //return hasDomesticCarrierCodeFormattingRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.092 -0400", hash_original_method = "1D78023CBBDF63A0A2ACC33925BD120F", hash_generated_method = "8E97532E6C17834B7C1869DBE426F37F")
        public String getDomesticCarrierCodeFormattingRule() {
String varDD191FBEB100D10A1D2F0E37B46E53E1_1654129692 =             domesticCarrierCodeFormattingRule_;
            varDD191FBEB100D10A1D2F0E37B46E53E1_1654129692.addTaint(taint);
            return varDD191FBEB100D10A1D2F0E37B46E53E1_1654129692;
            // ---------- Original Method ----------
            //return domesticCarrierCodeFormattingRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.093 -0400", hash_original_method = "2168D8046E4A0ED39DDD19551FD64D5A", hash_generated_method = "9D0E15D9CC996B42646B4796C8102619")
        public NumberFormat setDomesticCarrierCodeFormattingRule(String value) {
            hasDomesticCarrierCodeFormattingRule = true;
            domesticCarrierCodeFormattingRule_ = value;
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_400887926 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_400887926.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_400887926;
            // ---------- Original Method ----------
            //hasDomesticCarrierCodeFormattingRule = true;
            //domesticCarrierCodeFormattingRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.093 -0400", hash_original_method = "DEB91FB350FEBE5DEE35AF7BFA950AEF", hash_generated_method = "3750FFD74ECE3186069EADED819CF7FB")
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
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_1220346742 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1220346742.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1220346742;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.093 -0400", hash_original_method = "A100AA8318BC8064BB1FFCA8BFB04888", hash_generated_method = "98577CAED10A1B00797B9CAAFA5F8589")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.095 -0400", hash_original_method = "A5A163CCCC35630D5C707482125AAE27", hash_generated_method = "3809CF0CA7E93FA79AA91C4CC3BA2206")
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.095 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.095 -0400", hash_original_method = "0B2E67344AC06F839A81A2533D186625", hash_generated_method = "33D44D924CA310470694F7197627C035")
            public NumberFormat build() {
NumberFormat var72A74007B2BE62B849F475C7BDA4658B_134036244 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_134036244.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_134036244;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.095 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
    public static class PhoneNumberDesc implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.095 -0400", hash_original_field = "DF8FA0961A72330EDFA83A06858DAA6D", hash_generated_field = "FE0D4AC450B46E7BA63C0A5FF14C51C2")

        private boolean hasNationalNumberPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.095 -0400", hash_original_field = "B9BBEC8ED347133624C9F13EC01959D6", hash_generated_field = "EEA13D95EC1A783CC3FD2A2EA5BF77DB")

        private String nationalNumberPattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.096 -0400", hash_original_field = "5128B6327ABA67ABA34F0D40555173E8", hash_generated_field = "A5D4C78E7537A35AEAFB80E70E1EF9CF")

        private boolean hasPossibleNumberPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.096 -0400", hash_original_field = "CE9BECD6E9AE72932A581A01A4BC72CF", hash_generated_field = "9740030449804334CD1D210C9AACA78D")

        private String possibleNumberPattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.096 -0400", hash_original_field = "2439321B7A9F025B302F5484BF5AA1CC", hash_generated_field = "A377FEAF080DA6EA07178B0BF7E01505")

        private boolean hasExampleNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.096 -0400", hash_original_field = "A267297FDB6460E899FB01789A537AEF", hash_generated_field = "D8EDB7AA5577953B265C1D4AEECCDF65")

        private String exampleNumber_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.096 -0400", hash_original_method = "7B50B3AE2E947514292047EE4CC3D0B3", hash_generated_method = "FF0F10C59E5A022C63A72AE504F6D672")
        public  PhoneNumberDesc() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.096 -0400", hash_original_method = "7AE951C08CA66D0892FA0795F4703C0D", hash_generated_method = "83BCFB1E1EB69343AAD394BA0570609B")
        public boolean hasNationalNumberPattern() {
            boolean varDF8FA0961A72330EDFA83A06858DAA6D_1501345782 = (hasNationalNumberPattern);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324345208 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324345208;
            // ---------- Original Method ----------
            //return hasNationalNumberPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.096 -0400", hash_original_method = "AE5307416A342E6E51B0D8AFEA64E005", hash_generated_method = "0ECA700C445A67A69B96E72DBEC95CD7")
        public String getNationalNumberPattern() {
String varC42B48AE81C655A7BA632276B0D5BAF1_1803306573 =             nationalNumberPattern_;
            varC42B48AE81C655A7BA632276B0D5BAF1_1803306573.addTaint(taint);
            return varC42B48AE81C655A7BA632276B0D5BAF1_1803306573;
            // ---------- Original Method ----------
            //return nationalNumberPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.097 -0400", hash_original_method = "5843589EEE5242B872EEFCA090E2182C", hash_generated_method = "8F0C93F87E211130395D721CEE2E0401")
        public PhoneNumberDesc setNationalNumberPattern(String value) {
            hasNationalNumberPattern = true;
            nationalNumberPattern_ = value;
PhoneNumberDesc var72A74007B2BE62B849F475C7BDA4658B_1188961318 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1188961318.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1188961318;
            // ---------- Original Method ----------
            //hasNationalNumberPattern = true;
            //nationalNumberPattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.097 -0400", hash_original_method = "0D2D12A828079BB292F0B693EDB7AA61", hash_generated_method = "62F2F1E263415F916DEF1B9683BA1023")
        public boolean hasPossibleNumberPattern() {
            boolean var5128B6327ABA67ABA34F0D40555173E8_1749729396 = (hasPossibleNumberPattern);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_931002939 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_931002939;
            // ---------- Original Method ----------
            //return hasPossibleNumberPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.097 -0400", hash_original_method = "69E173398B553B507060BBCC25879496", hash_generated_method = "90164CDCA5D46CB21EAADF2D867FB607")
        public String getPossibleNumberPattern() {
String varBDD637854148D9CF41233830DC280989_712514539 =             possibleNumberPattern_;
            varBDD637854148D9CF41233830DC280989_712514539.addTaint(taint);
            return varBDD637854148D9CF41233830DC280989_712514539;
            // ---------- Original Method ----------
            //return possibleNumberPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.098 -0400", hash_original_method = "E6F0FD7A3910EDF596B66C25C9FCACCB", hash_generated_method = "70A8A7FDC8889B24E9F39247E7C09CE6")
        public PhoneNumberDesc setPossibleNumberPattern(String value) {
            hasPossibleNumberPattern = true;
            possibleNumberPattern_ = value;
PhoneNumberDesc var72A74007B2BE62B849F475C7BDA4658B_1249845339 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1249845339.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1249845339;
            // ---------- Original Method ----------
            //hasPossibleNumberPattern = true;
            //possibleNumberPattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.098 -0400", hash_original_method = "9EA98547022BA9B31E373C0BBC90B4AD", hash_generated_method = "4514176FB6E83C43BC53578818744E2A")
        public boolean hasExampleNumber() {
            boolean var2439321B7A9F025B302F5484BF5AA1CC_505016709 = (hasExampleNumber);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_996438806 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_996438806;
            // ---------- Original Method ----------
            //return hasExampleNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.098 -0400", hash_original_method = "4F2E88760366816D23F2792FF3D4D910", hash_generated_method = "EC477241A40569E70ADCDBC7153CB406")
        public String getExampleNumber() {
String var4ED1B8A2ED15923B5F0122D42E82B60F_1999137086 =             exampleNumber_;
            var4ED1B8A2ED15923B5F0122D42E82B60F_1999137086.addTaint(taint);
            return var4ED1B8A2ED15923B5F0122D42E82B60F_1999137086;
            // ---------- Original Method ----------
            //return exampleNumber_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.099 -0400", hash_original_method = "99D22C86FFDC5E436BCE118592FFD464", hash_generated_method = "FC71999EA376291D9AD5DEB98DC57371")
        public PhoneNumberDesc setExampleNumber(String value) {
            hasExampleNumber = true;
            exampleNumber_ = value;
PhoneNumberDesc var72A74007B2BE62B849F475C7BDA4658B_1008015792 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1008015792.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1008015792;
            // ---------- Original Method ----------
            //hasExampleNumber = true;
            //exampleNumber_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.100 -0400", hash_original_method = "13E9D2F0445C754E67764A18611FF669", hash_generated_method = "E856F4326F6A0475CA0674879BBCBBB6")
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
PhoneNumberDesc var72A74007B2BE62B849F475C7BDA4658B_833146154 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_833146154.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_833146154;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.101 -0400", hash_original_method = "67972576318010D4A6F8FC5204742584", hash_generated_method = "E0E7090829A52EF06EE5551DBC21886D")
        public boolean exactlySameAs(PhoneNumberDesc other) {
            addTaint(other.getTaint());
            boolean var650C1E7E662B7EDC859F2E164CFF5DF7_1267730887 = (nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          exampleNumber_.equals(other.exampleNumber_));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933803624 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_933803624;
            // ---------- Original Method ----------
            //return nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          //possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          //exampleNumber_.equals(other.exampleNumber_);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.102 -0400", hash_original_method = "A248C31238E31950C31B42AEACDEB8E6", hash_generated_method = "A909E843C569C6ED023C2461C1EECCD9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.102 -0400", hash_original_method = "27FB9E0837C2CDBADF688660FFE7A75C", hash_generated_method = "32E346548B60C74BB7694BAF1F6E55C6")
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.103 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.103 -0400", hash_original_method = "27A166D755957BD27B60D63CE4983A6A", hash_generated_method = "5CBA68BA486C16340DE8E4E43827E7E6")
            public PhoneNumberDesc build() {
PhoneNumberDesc var72A74007B2BE62B849F475C7BDA4658B_763059920 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_763059920.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_763059920;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.104 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
    public static class PhoneMetadata implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.105 -0400", hash_original_field = "B1185F70DC285179A2028122A1753D38", hash_generated_field = "A3B9F71CE88284DA159E437E743AF585")

        private boolean hasGeneralDesc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.105 -0400", hash_original_field = "419108228A3D4DD7D84FDBBA426B692E", hash_generated_field = "7468C9C864A0465318B0CE4D7F53C201")

        private PhoneNumberDesc generalDesc_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.105 -0400", hash_original_field = "E592D649F417667F2723D6FFED6E2DB7", hash_generated_field = "E05C42AA9F7E3C173F9E6FFB96993C10")

        private boolean hasFixedLine;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.105 -0400", hash_original_field = "7D61EBE9F230AE4F535BB262D140087E", hash_generated_field = "6B2D29317DA7FDD4358F05B6ED70E817")

        private PhoneNumberDesc fixedLine_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "8624D101BA06AC461F2198E30D1F6A12", hash_generated_field = "6732DA5D8F7E44D3EB8E9B3B04D2C208")

        private boolean hasMobile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "9A3666ECDC25598E8B1F39C149B5248B", hash_generated_field = "B09F10BC9C29A32513C7F9D45C9DD65D")

        private PhoneNumberDesc mobile_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "75EB0178779C5B94A142C67A8A3A0895", hash_generated_field = "80FAAA0975BF29FCB14D951C0BEDC5C4")

        private boolean hasTollFree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "8A684838F9710DEC6492C65DEB5B5A0F", hash_generated_field = "80CDA2C3C5F8E5226552943E5B5D1962")

        private PhoneNumberDesc tollFree_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "6401DBC84CDD207E60C202A21F935454", hash_generated_field = "5A30F5E3B7119D5842288ABCFFE97498")

        private boolean hasPremiumRate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "A525D6594473341CA8B89D37798B312E", hash_generated_field = "A45FECABBF74FB7321F9023E44E33237")

        private PhoneNumberDesc premiumRate_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "B64C7B1A99130C1E792DC2EC767D9EFB", hash_generated_field = "E49185F054F9F704C5600406F67DCB84")

        private boolean hasSharedCost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "1E9F4723F699DE8125552E21FFBFE400", hash_generated_field = "F1E7A155AA2DB5B0B5B95BFB0CEE31C9")

        private PhoneNumberDesc sharedCost_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "C6671814FF918E89A75FE4D83E386A68", hash_generated_field = "EDA3B33207D61D6AC565FA093ADCC196")

        private boolean hasPersonalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "1CFAD4514D14064196C72BF65F9CF559", hash_generated_field = "9BEB6F47AE29097500633D2F6F699031")

        private PhoneNumberDesc personalNumber_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "6993F15A6272097A69996233948D6788", hash_generated_field = "389614404066D2EFA2E54C2350D94AD0")

        private boolean hasVoip;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "4F48640F12EB1E254E7007633AE6A4BB", hash_generated_field = "EFA41A681D6E8CCFBC92A6D814B85301")

        private PhoneNumberDesc voip_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "F4712A7EC85B48169BE6F130B09401AF", hash_generated_field = "AA932FC09168FC29B0E1BDD3089132CB")

        private boolean hasPager;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "B53FED5DFF5974BE7B138F1CA58A1B36", hash_generated_field = "6DF80094481DB5FAFFA343EECB46293A")

        private PhoneNumberDesc pager_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "1C045935E1F5FA0A1792848701C607B3", hash_generated_field = "8F81ABDD16142E28D9E5984C6F740238")

        private boolean hasUan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "8579B62499AB55F965AD299835FB973C", hash_generated_field = "AD69C3410F5AE892799A6AC7CB2532E2")

        private PhoneNumberDesc uan_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "DA4DF0660D0FEED67B00F588F241E7EB", hash_generated_field = "0ADF693E546C325541D053D46F07CA67")

        private boolean hasNoInternationalDialling;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "460049B379C4B8AF431BAEE1EBCBF02E", hash_generated_field = "DB4742972A73F31DE788D6B88EE269C4")

        private PhoneNumberDesc noInternationalDialling_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.106 -0400", hash_original_field = "B00599996521998233C824ACCAB0E15F", hash_generated_field = "0140279EBB974905A38C47A7722FAFF6")

        private boolean hasId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "09E215DDF102AD5C73EE5F65A3C0CAB9", hash_generated_field = "A3944B7884E3A988EBAE9C53EFFAD5F5")

        private String id_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "8DA9382CFAB6A2934FA5AD3C46617F89", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

        private boolean hasCountryCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "3461D01D5A7F32E3FA9B229113397711", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

        private int countryCode_ = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "71E29C99125BF827B3C5BF568381086E", hash_generated_field = "5FC44BC01719FCF066ECC548BE8A5361")

        private boolean hasInternationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "E282158924B697D8BC6CAAE1BC57B7AB", hash_generated_field = "717A913C833941AC2C547FE2DFF1FB22")

        private String internationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "3ECE55B44C31E2628C42F70CE9639621", hash_generated_field = "A9895E937CD8DAE0C496DBC48D2C2CEE")

        private boolean hasPreferredInternationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "FCD8C7D7DFF78E7FA4B7EEE488EB6AC0", hash_generated_field = "CDC303EF35375A2E1F5FC52FA30A0AEF")

        private String preferredInternationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "4470362D119F8595D8A4313EC3BBE684", hash_generated_field = "7558F68656CC64EE957040556631A4B3")

        private boolean hasNationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "7FFC07608A27C8D4C3337E4B3E617A97", hash_generated_field = "9FD4079672B074B1C28FCBD5211F0E6E")

        private String nationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "CE3736A3B3D1072084220B70CD4D0A4F", hash_generated_field = "D4784FA8A81183D66211EA3CB7EAD63D")

        private boolean hasPreferredExtnPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "3BFE67D70B206F596FE6BB87EA4FC2EE", hash_generated_field = "F27B632A949D8FCEF65E426D0FEC59C2")

        private String preferredExtnPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "178A91AD8C9D4B311CBB7E9799C204D6", hash_generated_field = "507A8081AF30D85EF13F20C27737EE29")

        private boolean hasNationalPrefixForParsing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "5CE340B02A46FE9107F9780901340CAC", hash_generated_field = "46A092752488BEB0567E42ECBB5103EA")

        private String nationalPrefixForParsing_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "037AAC783F91D571F6E54112E2703ECE", hash_generated_field = "B59E7752C84471B249DCD9F9C398AFC5")

        private boolean hasNationalPrefixTransformRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "E828C84B52178E6A7F8B07EA0784D668", hash_generated_field = "08067D30B404B72AEBA1F2484BFD694C")

        private String nationalPrefixTransformRule_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "5E31C2CEC062E7B8113B945A2F2AA0E9", hash_generated_field = "31870DDEA4297A7CAB4D169E31FFFEBE")

        private boolean hasSameMobileAndFixedLinePattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "E4C862F971A24839C23EBE9F978A48B6", hash_generated_field = "789005A5E2E7FE7FCA1F46FB6F3F7B13")

        private boolean sameMobileAndFixedLinePattern_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "181C76BA224D14DBE65B8E0F96308942", hash_generated_field = "B800AB6258E8C26EC659EA232E613974")

        private java.util.List<NumberFormat> numberFormat_ = new java.util.ArrayList<NumberFormat>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "38053CEBD2D283DF20A1B56D88B2FD5C", hash_generated_field = "8438C32E42D261618BF3822D8254B874")

        private java.util.List<NumberFormat> intlNumberFormat_ = new java.util.ArrayList<NumberFormat>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "08D2B80646091F0A5CABE08AE2346FDA", hash_generated_field = "30F748667FFCDF08F79F81730072A8E1")

        private boolean hasMainCountryForCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.107 -0400", hash_original_field = "939EF08D7E9438FD155F13C644263B24", hash_generated_field = "7BE3C4CE079A909FDB8BCA00D97F89BF")

        private boolean mainCountryForCode_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.108 -0400", hash_original_field = "17079C6943CC232663CE7B61C9E492DB", hash_generated_field = "AE9DE5751CA76FAC5FD0690889290B59")

        private boolean hasLeadingDigits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.108 -0400", hash_original_field = "E5D90B3FC23E47C17AFA7132318C4380", hash_generated_field = "A2DF202A3B5F3D62339A3B2DE2A4FAB2")

        private String leadingDigits_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.108 -0400", hash_original_field = "352F42E9E2F51AB889A7ACC99B15F496", hash_generated_field = "4AEC48A66912462BA0FE869D7DC85F43")

        private boolean hasLeadingZeroPossible;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.108 -0400", hash_original_field = "87145D95F10EE570BBC9AFAE6F259808", hash_generated_field = "F45DAF5712BFBE9A35415A4D733DC0FC")

        private boolean leadingZeroPossible_ = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.108 -0400", hash_original_method = "8411C48F959C93D1C6435DDA5C4FFBF8", hash_generated_method = "246EB5CC112F2B1B6402C47CB846FD5D")
        public  PhoneMetadata() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.108 -0400", hash_original_method = "573E786E141FAAA03A367F49BCA559B5", hash_generated_method = "28A30A8B8769DF2C9EB90A5ACBBE4C22")
        public boolean hasGeneralDesc() {
            boolean varB1185F70DC285179A2028122A1753D38_52049371 = (hasGeneralDesc);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721156766 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_721156766;
            // ---------- Original Method ----------
            //return hasGeneralDesc;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.108 -0400", hash_original_method = "F96C4A1868C09190E3C941F03A2889CB", hash_generated_method = "6F5CE3171E5A24FAF5171E1B0A01B6DF")
        public PhoneNumberDesc getGeneralDesc() {
PhoneNumberDesc var4C7B3B97088EAA66676A3875ED6B8A2C_1292917462 =             generalDesc_;
            var4C7B3B97088EAA66676A3875ED6B8A2C_1292917462.addTaint(taint);
            return var4C7B3B97088EAA66676A3875ED6B8A2C_1292917462;
            // ---------- Original Method ----------
            //return generalDesc_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.109 -0400", hash_original_method = "97D824F311B5130867761544B2540B90", hash_generated_method = "9C2B6630150E0B3F5648DB083D83BE61")
        public PhoneMetadata setGeneralDesc(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1110259745 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1110259745.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1110259745;
            } //End block
            hasGeneralDesc = true;
            generalDesc_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_583339834 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_583339834.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_583339834;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasGeneralDesc = true;
            //generalDesc_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.109 -0400", hash_original_method = "0B06F02C38AE7EA6E1205EAD00F0F3D7", hash_generated_method = "486B24F256BA3EE3FDF2D65710146A5A")
        public boolean hasFixedLine() {
            boolean varE592D649F417667F2723D6FFED6E2DB7_1216121809 = (hasFixedLine);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1283390148 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1283390148;
            // ---------- Original Method ----------
            //return hasFixedLine;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.109 -0400", hash_original_method = "7111E9DB2C9B99769226207CB0B39C0D", hash_generated_method = "98ED49FCED54E2E099195E8495B226DF")
        public PhoneNumberDesc getFixedLine() {
PhoneNumberDesc var787CF5CB7BCDB84D66FEC693E18BBFD5_1845985995 =             fixedLine_;
            var787CF5CB7BCDB84D66FEC693E18BBFD5_1845985995.addTaint(taint);
            return var787CF5CB7BCDB84D66FEC693E18BBFD5_1845985995;
            // ---------- Original Method ----------
            //return fixedLine_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.110 -0400", hash_original_method = "4E0B7145906BC721C9DE8D0C32500FC9", hash_generated_method = "23D3911624240788B8B6BA2072D85FAA")
        public PhoneMetadata setFixedLine(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_183614584 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_183614584.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_183614584;
            } //End block
            hasFixedLine = true;
            fixedLine_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1671714194 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1671714194.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1671714194;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasFixedLine = true;
            //fixedLine_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.110 -0400", hash_original_method = "F5A454F163C8198EDADB6A0267665530", hash_generated_method = "1F6861BFC9D4F6853370EDE810904852")
        public boolean hasMobile() {
            boolean var8624D101BA06AC461F2198E30D1F6A12_847109447 = (hasMobile);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_359801878 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_359801878;
            // ---------- Original Method ----------
            //return hasMobile;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.110 -0400", hash_original_method = "469BFC723D37FABFB9BC30DE50B7B80A", hash_generated_method = "032AC920727DEDABC9CEFD21FDC0423E")
        public PhoneNumberDesc getMobile() {
PhoneNumberDesc varC153FD71E9716C86B0DB722C2C65FDA7_2053732440 =             mobile_;
            varC153FD71E9716C86B0DB722C2C65FDA7_2053732440.addTaint(taint);
            return varC153FD71E9716C86B0DB722C2C65FDA7_2053732440;
            // ---------- Original Method ----------
            //return mobile_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.111 -0400", hash_original_method = "CF0A4860566840BE9C27E4474979A50E", hash_generated_method = "AC86B6BA337DBD77C2F185BDB080EAD6")
        public PhoneMetadata setMobile(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1898595205 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1898595205.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1898595205;
            } //End block
            hasMobile = true;
            mobile_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_30686745 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_30686745.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_30686745;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasMobile = true;
            //mobile_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.111 -0400", hash_original_method = "C6BB80AB6E7BD893E9D8810967101490", hash_generated_method = "02DAA3209446AFE4BDC398C88B630554")
        public boolean hasTollFree() {
            boolean var75EB0178779C5B94A142C67A8A3A0895_1413403283 = (hasTollFree);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649033975 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_649033975;
            // ---------- Original Method ----------
            //return hasTollFree;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.111 -0400", hash_original_method = "A25CEA98E2A744A76CD23B6ECE21AB56", hash_generated_method = "E786C3B7737DDDB2558928119C52B26E")
        public PhoneNumberDesc getTollFree() {
PhoneNumberDesc var69110EE6A0D073111FD80E85FB87DBAF_1565867496 =             tollFree_;
            var69110EE6A0D073111FD80E85FB87DBAF_1565867496.addTaint(taint);
            return var69110EE6A0D073111FD80E85FB87DBAF_1565867496;
            // ---------- Original Method ----------
            //return tollFree_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.112 -0400", hash_original_method = "46A649F605F0EC24C76169E259456A93", hash_generated_method = "E65DD9FA5A4F825C8D8294780EC5231E")
        public PhoneMetadata setTollFree(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1878330814 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1878330814.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1878330814;
            } //End block
            hasTollFree = true;
            tollFree_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_812659270 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_812659270.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_812659270;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasTollFree = true;
            //tollFree_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.112 -0400", hash_original_method = "82079540736B40B455CF317890B4623A", hash_generated_method = "6BE2E78749B22FA071C6439A4A874703")
        public boolean hasPremiumRate() {
            boolean var6401DBC84CDD207E60C202A21F935454_1469313961 = (hasPremiumRate);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847763877 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847763877;
            // ---------- Original Method ----------
            //return hasPremiumRate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.112 -0400", hash_original_method = "14341C327DA8E1CAAD52FEB1F27BC133", hash_generated_method = "3DD1B0E5E385828A87D7F9356B72264C")
        public PhoneNumberDesc getPremiumRate() {
PhoneNumberDesc var4BD12C96666D7DC70DEC48E38C149D6D_895456598 =             premiumRate_;
            var4BD12C96666D7DC70DEC48E38C149D6D_895456598.addTaint(taint);
            return var4BD12C96666D7DC70DEC48E38C149D6D_895456598;
            // ---------- Original Method ----------
            //return premiumRate_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.113 -0400", hash_original_method = "BC27E8EEE54A894FE20AA77CF35DD102", hash_generated_method = "C2624A2AC5B6D3B043618BA424F24639")
        public PhoneMetadata setPremiumRate(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1162346699 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1162346699.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1162346699;
            } //End block
            hasPremiumRate = true;
            premiumRate_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1204419951 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1204419951.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1204419951;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPremiumRate = true;
            //premiumRate_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.113 -0400", hash_original_method = "3FC94E6C0EA4E13DD9DFC50367AE259A", hash_generated_method = "8FBF7D3F3174DC78EBA3A87998BB2F10")
        public boolean hasSharedCost() {
            boolean varB64C7B1A99130C1E792DC2EC767D9EFB_254828800 = (hasSharedCost);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677971057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677971057;
            // ---------- Original Method ----------
            //return hasSharedCost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.113 -0400", hash_original_method = "1FFB14D9D02DC30D3C5835101DD9BAF0", hash_generated_method = "08E6187D99CDB2594CCC51762C0C60C9")
        public PhoneNumberDesc getSharedCost() {
PhoneNumberDesc varD63474C6D2DA55D2359E72FFA0397BC0_1823593649 =             sharedCost_;
            varD63474C6D2DA55D2359E72FFA0397BC0_1823593649.addTaint(taint);
            return varD63474C6D2DA55D2359E72FFA0397BC0_1823593649;
            // ---------- Original Method ----------
            //return sharedCost_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.114 -0400", hash_original_method = "CDEC9E0DF29779C1B33ED334AA2CAB69", hash_generated_method = "AAB5A883E363CF9CBF8E6C4CEDA86E8A")
        public PhoneMetadata setSharedCost(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_416757758 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_416757758.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_416757758;
            } //End block
            hasSharedCost = true;
            sharedCost_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1412154431 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1412154431.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1412154431;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasSharedCost = true;
            //sharedCost_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.114 -0400", hash_original_method = "0212D7D16A2BAA9CCCFC0F72E5660C30", hash_generated_method = "812A30240036E1C28725C58007C7E075")
        public boolean hasPersonalNumber() {
            boolean varC6671814FF918E89A75FE4D83E386A68_758802674 = (hasPersonalNumber);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_808477337 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_808477337;
            // ---------- Original Method ----------
            //return hasPersonalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.114 -0400", hash_original_method = "4CF811D3746F6643A77AAC306D011902", hash_generated_method = "C8E6D5795C676ED3569BC14AB28FC454")
        public PhoneNumberDesc getPersonalNumber() {
PhoneNumberDesc varCCE39C67DA22BC60D89245F287A7CFC3_1462113383 =             personalNumber_;
            varCCE39C67DA22BC60D89245F287A7CFC3_1462113383.addTaint(taint);
            return varCCE39C67DA22BC60D89245F287A7CFC3_1462113383;
            // ---------- Original Method ----------
            //return personalNumber_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.115 -0400", hash_original_method = "24493CAEB1946A8C79E7D00511D66307", hash_generated_method = "38B7CFE141D905D097A042B1C7D58250")
        public PhoneMetadata setPersonalNumber(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_12494017 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_12494017.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_12494017;
            } //End block
            hasPersonalNumber = true;
            personalNumber_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_2000438022 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2000438022.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2000438022;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPersonalNumber = true;
            //personalNumber_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.115 -0400", hash_original_method = "96BC6C0B8CEC8C19A5CCD809DD7C636B", hash_generated_method = "9FD6D691BE304F3353D0DCC23AAFC616")
        public boolean hasVoip() {
            boolean var6993F15A6272097A69996233948D6788_649164837 = (hasVoip);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845329130 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_845329130;
            // ---------- Original Method ----------
            //return hasVoip;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.115 -0400", hash_original_method = "3E7A9D2F706E69069EF64F75DD5323E7", hash_generated_method = "ABC98709D78A5D66468EAE0C54FA4F59")
        public PhoneNumberDesc getVoip() {
PhoneNumberDesc varB6BEAAE69A06C703395DC04D82543F47_944439125 =             voip_;
            varB6BEAAE69A06C703395DC04D82543F47_944439125.addTaint(taint);
            return varB6BEAAE69A06C703395DC04D82543F47_944439125;
            // ---------- Original Method ----------
            //return voip_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.115 -0400", hash_original_method = "5FE2D757C727FFFD1EC6F29B7720BADF", hash_generated_method = "595A06428877B1C40CDAB49E3DBD2585")
        public PhoneMetadata setVoip(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_416898141 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_416898141.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_416898141;
            } //End block
            hasVoip = true;
            voip_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1895013741 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1895013741.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1895013741;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasVoip = true;
            //voip_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.116 -0400", hash_original_method = "ACFB2D18067CB4D678DA99A9B4C18C84", hash_generated_method = "A97503B9A3F3D6948B70C8B4CA5AD246")
        public boolean hasPager() {
            boolean varF4712A7EC85B48169BE6F130B09401AF_777811714 = (hasPager);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_152821304 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_152821304;
            // ---------- Original Method ----------
            //return hasPager;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.116 -0400", hash_original_method = "C20F5AA8347238E1E9DA82F58997297F", hash_generated_method = "D8BAE39213D6C4DDBE933530FA52413E")
        public PhoneNumberDesc getPager() {
PhoneNumberDesc varBD60572279158F98063954A8F1A98F99_646253824 =             pager_;
            varBD60572279158F98063954A8F1A98F99_646253824.addTaint(taint);
            return varBD60572279158F98063954A8F1A98F99_646253824;
            // ---------- Original Method ----------
            //return pager_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.116 -0400", hash_original_method = "F7E7BD7CBC5C04503F79204D035D6093", hash_generated_method = "BF6EF09D72EE67429D55C193F8EA6188")
        public PhoneMetadata setPager(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1676045892 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1676045892.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1676045892;
            } //End block
            hasPager = true;
            pager_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1180609267 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1180609267.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1180609267;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPager = true;
            //pager_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.117 -0400", hash_original_method = "7052BD1D22DD33A68E8BFBF8EF4C8D7C", hash_generated_method = "C4B8E6EA1ED555692825C63BF4F434DC")
        public boolean hasUan() {
            boolean var1C045935E1F5FA0A1792848701C607B3_1711230911 = (hasUan);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852607527 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_852607527;
            // ---------- Original Method ----------
            //return hasUan;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.117 -0400", hash_original_method = "6E5CDB2B0554F6EDEAFB0A826808F837", hash_generated_method = "EFC93E7A18A85B9ECFF9F2681C01DE00")
        public PhoneNumberDesc getUan() {
PhoneNumberDesc varA2E1686AE30820EA797ADF16D1725B57_65450135 =             uan_;
            varA2E1686AE30820EA797ADF16D1725B57_65450135.addTaint(taint);
            return varA2E1686AE30820EA797ADF16D1725B57_65450135;
            // ---------- Original Method ----------
            //return uan_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.117 -0400", hash_original_method = "645A0026A31D8D600D28A5F0E2FCB775", hash_generated_method = "F93B2DB9F8FE49AC40C4FDEDF2DD13EF")
        public PhoneMetadata setUan(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1674434098 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1674434098.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1674434098;
            } //End block
            hasUan = true;
            uan_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_775176903 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_775176903.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_775176903;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasUan = true;
            //uan_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.117 -0400", hash_original_method = "1D4CDC46AB20A45A27679F7FB2E14F5D", hash_generated_method = "38C383A8F9F919517FD3C13593AD843E")
        public boolean hasNoInternationalDialling() {
            boolean varDA4DF0660D0FEED67B00F588F241E7EB_544517341 = (hasNoInternationalDialling);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1307106394 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1307106394;
            // ---------- Original Method ----------
            //return hasNoInternationalDialling;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.118 -0400", hash_original_method = "8BF24E7280AB555752CDF0AB6293C8C0", hash_generated_method = "8388EB2517CAA97D4EA6E2DC8320C96F")
        public PhoneNumberDesc getNoInternationalDialling() {
PhoneNumberDesc varE6ABAB09793DFEE925CACEF80C261845_780208514 =             noInternationalDialling_;
            varE6ABAB09793DFEE925CACEF80C261845_780208514.addTaint(taint);
            return varE6ABAB09793DFEE925CACEF80C261845_780208514;
            // ---------- Original Method ----------
            //return noInternationalDialling_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.118 -0400", hash_original_method = "7DCE821DB5B30DD48C6A3A37AA42A1FD", hash_generated_method = "FEAF1507F7B7231B43A15A5380B7F074")
        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1543694422 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1543694422.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1543694422;
            } //End block
            hasNoInternationalDialling = true;
            noInternationalDialling_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1084704447 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1084704447.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1084704447;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasNoInternationalDialling = true;
            //noInternationalDialling_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.118 -0400", hash_original_method = "4B670822089DE57CBF3DD8C644F8C3E5", hash_generated_method = "EA5741BF4D286BDCCBABF755C87A8760")
        public boolean hasId() {
            boolean varB00599996521998233C824ACCAB0E15F_2147147456 = (hasId);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1694416560 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1694416560;
            // ---------- Original Method ----------
            //return hasId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.119 -0400", hash_original_method = "C805C797DAF63B59CBD999295B2F5158", hash_generated_method = "DF38505D60E7A532B62BCA419870049E")
        public String getId() {
String varF269FAEAC30E61C67F21006F1103E9D0_805880572 =             id_;
            varF269FAEAC30E61C67F21006F1103E9D0_805880572.addTaint(taint);
            return varF269FAEAC30E61C67F21006F1103E9D0_805880572;
            // ---------- Original Method ----------
            //return id_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.119 -0400", hash_original_method = "6B3AD7A8DB5994F94639D3A9A0778D2B", hash_generated_method = "E7747092B6BD0128EA74231747F46D05")
        public PhoneMetadata setId(String value) {
            hasId = true;
            id_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1972756227 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1972756227.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1972756227;
            // ---------- Original Method ----------
            //hasId = true;
            //id_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.119 -0400", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "FC8DCF9BD00B014C8F6A3373DCEA2CE7")
        public boolean hasCountryCode() {
            boolean var8DA9382CFAB6A2934FA5AD3C46617F89_1932474831 = (hasCountryCode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856688119 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856688119;
            // ---------- Original Method ----------
            //return hasCountryCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.120 -0400", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "30699FC48744A07557B2AF9D3E0111F0")
        public int getCountryCode() {
            int var3C5B11B8C2E2EEFEFDB13FA162E1622D_517196011 = (countryCode_);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1698991172 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1698991172;
            // ---------- Original Method ----------
            //return countryCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.120 -0400", hash_original_method = "1AB7F6532DA188CC62A13C45F2B9ADF3", hash_generated_method = "401F417BD1C13814DFF91805AACC2EE1")
        public PhoneMetadata setCountryCode(int value) {
            hasCountryCode = true;
            countryCode_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_486099918 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_486099918.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_486099918;
            // ---------- Original Method ----------
            //hasCountryCode = true;
            //countryCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.120 -0400", hash_original_method = "B89BF9592A7F16BE6654C3883F9898E5", hash_generated_method = "95E8CB859E06E182052ABCC1C8872215")
        public boolean hasInternationalPrefix() {
            boolean var71E29C99125BF827B3C5BF568381086E_1098641767 = (hasInternationalPrefix);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_117289769 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_117289769;
            // ---------- Original Method ----------
            //return hasInternationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.120 -0400", hash_original_method = "09123B0A33DF502700CE0BB29A84EB95", hash_generated_method = "0653B3BA5EB3996E05DC0DB01ECE165A")
        public String getInternationalPrefix() {
String varB48C0E880F380583AF707A79A375121E_2085313371 =             internationalPrefix_;
            varB48C0E880F380583AF707A79A375121E_2085313371.addTaint(taint);
            return varB48C0E880F380583AF707A79A375121E_2085313371;
            // ---------- Original Method ----------
            //return internationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.120 -0400", hash_original_method = "3DE0D2253FD6A81DEABED2BF406E5650", hash_generated_method = "14A57FB741BD1C9D3E030395D7E99797")
        public PhoneMetadata setInternationalPrefix(String value) {
            hasInternationalPrefix = true;
            internationalPrefix_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1964765634 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1964765634.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1964765634;
            // ---------- Original Method ----------
            //hasInternationalPrefix = true;
            //internationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.120 -0400", hash_original_method = "3A1D043D6BB606ABB758EEC975A83919", hash_generated_method = "FD87362827C07E66378EAE3E914FE413")
        public boolean hasPreferredInternationalPrefix() {
            boolean var3ECE55B44C31E2628C42F70CE9639621_1128436906 = (hasPreferredInternationalPrefix);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300053074 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_300053074;
            // ---------- Original Method ----------
            //return hasPreferredInternationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.120 -0400", hash_original_method = "3992DDBA34CC5C49CFC74CF0545FF343", hash_generated_method = "BEC2A917E0F4E4AA37F3C84B1C113ACF")
        public String getPreferredInternationalPrefix() {
String var09FD5A8E8E600C664F9C80767DD1035F_103972232 =             preferredInternationalPrefix_;
            var09FD5A8E8E600C664F9C80767DD1035F_103972232.addTaint(taint);
            return var09FD5A8E8E600C664F9C80767DD1035F_103972232;
            // ---------- Original Method ----------
            //return preferredInternationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.121 -0400", hash_original_method = "2F2A95A6FC37FC6A654CD2ED9E105058", hash_generated_method = "A7FF1773CCF0CC4785837E6D1E89AEEA")
        public PhoneMetadata setPreferredInternationalPrefix(String value) {
            hasPreferredInternationalPrefix = true;
            preferredInternationalPrefix_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_567464649 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_567464649.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_567464649;
            // ---------- Original Method ----------
            //hasPreferredInternationalPrefix = true;
            //preferredInternationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.121 -0400", hash_original_method = "3FEC8563D97FEF0C0B81201609B8C138", hash_generated_method = "B77BF76CDC50E1B70EAD63676E317676")
        public boolean hasNationalPrefix() {
            boolean var4470362D119F8595D8A4313EC3BBE684_1582410836 = (hasNationalPrefix);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883033135 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_883033135;
            // ---------- Original Method ----------
            //return hasNationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.121 -0400", hash_original_method = "3F6DDEA7E91472B57F47F7AA42FF40A4", hash_generated_method = "98F2251346FFF79A403736723FD80F73")
        public String getNationalPrefix() {
String var5C39D3A24795B4888A8A79CE62FA327C_119161298 =             nationalPrefix_;
            var5C39D3A24795B4888A8A79CE62FA327C_119161298.addTaint(taint);
            return var5C39D3A24795B4888A8A79CE62FA327C_119161298;
            // ---------- Original Method ----------
            //return nationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.121 -0400", hash_original_method = "F24C638CA5CEB8CDF3416D52787AAB8D", hash_generated_method = "B93909FE4346EE95ED2E72A22C814DC0")
        public PhoneMetadata setNationalPrefix(String value) {
            hasNationalPrefix = true;
            nationalPrefix_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1516999115 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1516999115.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1516999115;
            // ---------- Original Method ----------
            //hasNationalPrefix = true;
            //nationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.121 -0400", hash_original_method = "E23165194A0E40A98A75B1CB3195C323", hash_generated_method = "2CA2C3291891EABA672FB7DDA7FF78FD")
        public boolean hasPreferredExtnPrefix() {
            boolean varCE3736A3B3D1072084220B70CD4D0A4F_84138980 = (hasPreferredExtnPrefix);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1251223691 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1251223691;
            // ---------- Original Method ----------
            //return hasPreferredExtnPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.121 -0400", hash_original_method = "54C0428B3277F86E8CEE26D4467F5D32", hash_generated_method = "1695FFD07A89CAAE50A11D8B8E804010")
        public String getPreferredExtnPrefix() {
String var7B1E12B3052318BC37C1730A5C8A492E_701558636 =             preferredExtnPrefix_;
            var7B1E12B3052318BC37C1730A5C8A492E_701558636.addTaint(taint);
            return var7B1E12B3052318BC37C1730A5C8A492E_701558636;
            // ---------- Original Method ----------
            //return preferredExtnPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.121 -0400", hash_original_method = "6AE031AAEF0021BEEE5C7C14D7E5ADEE", hash_generated_method = "E793CB8F1693C607A868F6A786374C0A")
        public PhoneMetadata setPreferredExtnPrefix(String value) {
            hasPreferredExtnPrefix = true;
            preferredExtnPrefix_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1221062520 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1221062520.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1221062520;
            // ---------- Original Method ----------
            //hasPreferredExtnPrefix = true;
            //preferredExtnPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.121 -0400", hash_original_method = "079D2F6BDFB9C83E975C341D5D3984E8", hash_generated_method = "B487CD0C04E97237090D423C76424D9E")
        public boolean hasNationalPrefixForParsing() {
            boolean var178A91AD8C9D4B311CBB7E9799C204D6_867308018 = (hasNationalPrefixForParsing);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274025714 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274025714;
            // ---------- Original Method ----------
            //return hasNationalPrefixForParsing;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.121 -0400", hash_original_method = "049975D1EC97C98DFAFD92CBA7A3DB4E", hash_generated_method = "AC8F163CE02B99513BD384658D4BA614")
        public String getNationalPrefixForParsing() {
String var7D5E5B69634A1EE648E5B6802876DC76_869951782 =             nationalPrefixForParsing_;
            var7D5E5B69634A1EE648E5B6802876DC76_869951782.addTaint(taint);
            return var7D5E5B69634A1EE648E5B6802876DC76_869951782;
            // ---------- Original Method ----------
            //return nationalPrefixForParsing_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.122 -0400", hash_original_method = "9C0BD3F3F0877996BC57F1866741042E", hash_generated_method = "54B35CC239D81DB233BE5788DFDEEF3F")
        public PhoneMetadata setNationalPrefixForParsing(String value) {
            hasNationalPrefixForParsing = true;
            nationalPrefixForParsing_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_645351918 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_645351918.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_645351918;
            // ---------- Original Method ----------
            //hasNationalPrefixForParsing = true;
            //nationalPrefixForParsing_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.122 -0400", hash_original_method = "1810BCBEB4974245D7BFFA09C69DD621", hash_generated_method = "1597729E459AA0C40CEE27CFC25C39C2")
        public boolean hasNationalPrefixTransformRule() {
            boolean var037AAC783F91D571F6E54112E2703ECE_1893480433 = (hasNationalPrefixTransformRule);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_764061125 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_764061125;
            // ---------- Original Method ----------
            //return hasNationalPrefixTransformRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.122 -0400", hash_original_method = "55DE6447BA6383DE2B8CA08949083559", hash_generated_method = "F058CAD5136ED4707472A9559211505E")
        public String getNationalPrefixTransformRule() {
String varCBDA20BB93BF1FF264E4F9B48434DF65_2810994 =             nationalPrefixTransformRule_;
            varCBDA20BB93BF1FF264E4F9B48434DF65_2810994.addTaint(taint);
            return varCBDA20BB93BF1FF264E4F9B48434DF65_2810994;
            // ---------- Original Method ----------
            //return nationalPrefixTransformRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.122 -0400", hash_original_method = "F0F297723C8F168223FB62622F5A1EB6", hash_generated_method = "0441AB85FB0BE1B985936E2808807B3A")
        public PhoneMetadata setNationalPrefixTransformRule(String value) {
            hasNationalPrefixTransformRule = true;
            nationalPrefixTransformRule_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_93621150 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_93621150.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_93621150;
            // ---------- Original Method ----------
            //hasNationalPrefixTransformRule = true;
            //nationalPrefixTransformRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.122 -0400", hash_original_method = "23B7A16EBE621B68A999B8F98C32C7FC", hash_generated_method = "1E64182F34FFC64D89D57A18E1422799")
        public boolean hasSameMobileAndFixedLinePattern() {
            boolean var5E31C2CEC062E7B8113B945A2F2AA0E9_1334174810 = (hasSameMobileAndFixedLinePattern);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_359832568 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_359832568;
            // ---------- Original Method ----------
            //return hasSameMobileAndFixedLinePattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.122 -0400", hash_original_method = "0C8ED851B6AE0A07DB69452573173B34", hash_generated_method = "9914D3574A28612A499CE43CE8E6695C")
        public boolean isSameMobileAndFixedLinePattern() {
            boolean var983F9C7C7CDF6761A728703994C00E8C_320024602 = (sameMobileAndFixedLinePattern_);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1367246585 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1367246585;
            // ---------- Original Method ----------
            //return sameMobileAndFixedLinePattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.122 -0400", hash_original_method = "4899ADA62C5B2767C955044A6A730FDD", hash_generated_method = "BFBCD3576CFE203E2486D64D97E44CB0")
        public PhoneMetadata setSameMobileAndFixedLinePattern(boolean value) {
            hasSameMobileAndFixedLinePattern = true;
            sameMobileAndFixedLinePattern_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1017603870 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1017603870.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1017603870;
            // ---------- Original Method ----------
            //hasSameMobileAndFixedLinePattern = true;
            //sameMobileAndFixedLinePattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.122 -0400", hash_original_method = "84A1634AEDD3ABF2CF1A3014B5D415EB", hash_generated_method = "893F015BA2B25BD84544A8F542C75490")
        public java.util.List<NumberFormat> numberFormats() {
java.util.List<NumberFormat> var702269FAB9B8E162744A1FBA938D46B8_37421135 =             numberFormat_;
            var702269FAB9B8E162744A1FBA938D46B8_37421135.addTaint(taint);
            return var702269FAB9B8E162744A1FBA938D46B8_37421135;
            // ---------- Original Method ----------
            //return numberFormat_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.122 -0400", hash_original_method = "926251D4CC15A970A4459B1AE98E21C5", hash_generated_method = "0B353DFBA1D179353542D470B2535282")
        public int numberFormatSize() {
            int var8D791A6EE08658BD1D9E8E744CC9D556_3161670 = (numberFormat_.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156234561 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156234561;
            // ---------- Original Method ----------
            //return numberFormat_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.122 -0400", hash_original_method = "A540DB640DF9F8195853729D5B88BC06", hash_generated_method = "34CD684DF619F005ED7F567F86D9FEE8")
        public NumberFormat getNumberFormat(int index) {
            addTaint(index);
NumberFormat varA049E8D704FC18C0322F6A3E2DCEB37E_1861115071 =             numberFormat_.get(index);
            varA049E8D704FC18C0322F6A3E2DCEB37E_1861115071.addTaint(taint);
            return varA049E8D704FC18C0322F6A3E2DCEB37E_1861115071;
            // ---------- Original Method ----------
            //return numberFormat_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.123 -0400", hash_original_method = "6431B417B09BF16DE184C0BF7BFD8C0A", hash_generated_method = "80954F81074412A031A6E642F1F08256")
        public PhoneMetadata addNumberFormat(NumberFormat value) {
            addTaint(value.getTaint());
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1602092744 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1602092744.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1602092744;
            } //End block
            numberFormat_.add(value);
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1650495503 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1650495503.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1650495503;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //numberFormat_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.123 -0400", hash_original_method = "AE158E1AC846181939D70DB177BF740E", hash_generated_method = "876C5F3E172E665EAF7903883121989C")
        public java.util.List<NumberFormat> intlNumberFormats() {
java.util.List<NumberFormat> varB0366A78C2DAD208E15B4E68FFB4A87E_1556477885 =             intlNumberFormat_;
            varB0366A78C2DAD208E15B4E68FFB4A87E_1556477885.addTaint(taint);
            return varB0366A78C2DAD208E15B4E68FFB4A87E_1556477885;
            // ---------- Original Method ----------
            //return intlNumberFormat_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.123 -0400", hash_original_method = "58F2978D59C0EB64F45AEE8E7A3A3ECF", hash_generated_method = "2383A0796C7C3BAF212768BDC05ACFE6")
        public int intlNumberFormatSize() {
            int var3350A78C4DA1132B93694A858CC31D9D_387701487 = (intlNumberFormat_.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_482127761 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_482127761;
            // ---------- Original Method ----------
            //return intlNumberFormat_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.123 -0400", hash_original_method = "14BAA3A4AA80C468A085BC9B63542EE0", hash_generated_method = "B2E18C5FB7F28F8A778AD5E8526D22CE")
        public NumberFormat getIntlNumberFormat(int index) {
            addTaint(index);
NumberFormat var2869E6EC0F45B166B5956E42FFC4008A_1634644522 =             intlNumberFormat_.get(index);
            var2869E6EC0F45B166B5956E42FFC4008A_1634644522.addTaint(taint);
            return var2869E6EC0F45B166B5956E42FFC4008A_1634644522;
            // ---------- Original Method ----------
            //return intlNumberFormat_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.123 -0400", hash_original_method = "DDE7F201B8001F4279DAEE9969BC3EF9", hash_generated_method = "FF4E15D43F32C6FB4B62E0C429B71D44")
        public PhoneMetadata addIntlNumberFormat(NumberFormat value) {
            addTaint(value.getTaint());
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1790788992 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1790788992.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1790788992;
            } //End block
            intlNumberFormat_.add(value);
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_307917553 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_307917553.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_307917553;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //intlNumberFormat_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.123 -0400", hash_original_method = "C1C6B471737DB86E719E8005B048F8A4", hash_generated_method = "AD1064FB1704790465ECE7B5AC8EC679")
        public PhoneMetadata clearIntlNumberFormat() {
            intlNumberFormat_.clear();
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1726287220 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1726287220.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1726287220;
            // ---------- Original Method ----------
            //intlNumberFormat_.clear();
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.123 -0400", hash_original_method = "F0A3F725FE27520DECCABEEE1451ABF4", hash_generated_method = "83AFA8054FB0262FF1907631417066D6")
        public boolean hasMainCountryForCode() {
            boolean var08D2B80646091F0A5CABE08AE2346FDA_1013468168 = (hasMainCountryForCode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_279964387 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_279964387;
            // ---------- Original Method ----------
            //return hasMainCountryForCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.123 -0400", hash_original_method = "CF03E78162809AA6058F20CA8B82C717", hash_generated_method = "644A3695D31A7AB9C2C13CFCC7FFCBE5")
        public boolean isMainCountryForCode() {
            boolean varB9D64FD23EE8D3F10C4FF8D18442C47D_412919587 = (mainCountryForCode_);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1319201454 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1319201454;
            // ---------- Original Method ----------
            //return mainCountryForCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.124 -0400", hash_original_method = "8B579A48BF103BAE8E5F2D34ABF5A62F", hash_generated_method = "CF47611F3966C2818927F4FA4970CF64")
        public boolean getMainCountryForCode() {
            boolean varB9D64FD23EE8D3F10C4FF8D18442C47D_426837109 = (mainCountryForCode_);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1882606194 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1882606194;
            // ---------- Original Method ----------
            //return mainCountryForCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.124 -0400", hash_original_method = "0E977089CAAEFAD04CCCDA9E72421381", hash_generated_method = "B01B48AF060E787C972583677690150B")
        public PhoneMetadata setMainCountryForCode(boolean value) {
            hasMainCountryForCode = true;
            mainCountryForCode_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1590848292 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1590848292.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1590848292;
            // ---------- Original Method ----------
            //hasMainCountryForCode = true;
            //mainCountryForCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.124 -0400", hash_original_method = "46DBCF13AB23890B1C354034C02AAE0D", hash_generated_method = "5922CBDC862DA875DB87F3A91EAC573A")
        public boolean hasLeadingDigits() {
            boolean var17079C6943CC232663CE7B61C9E492DB_73791836 = (hasLeadingDigits);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47075195 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_47075195;
            // ---------- Original Method ----------
            //return hasLeadingDigits;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.124 -0400", hash_original_method = "BA0CBA2DFD34C6F845467DDF3F7503AD", hash_generated_method = "3D4565D87F8EA88DDB2855D1417950FA")
        public String getLeadingDigits() {
String var39A62A047CE92200C52A50FD8914E24B_1003466458 =             leadingDigits_;
            var39A62A047CE92200C52A50FD8914E24B_1003466458.addTaint(taint);
            return var39A62A047CE92200C52A50FD8914E24B_1003466458;
            // ---------- Original Method ----------
            //return leadingDigits_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.124 -0400", hash_original_method = "1B8095B1499A1300CC7FD6395528DFB9", hash_generated_method = "6E1E9C7A95F4C0B0271A97014A12C951")
        public PhoneMetadata setLeadingDigits(String value) {
            hasLeadingDigits = true;
            leadingDigits_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1259711927 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1259711927.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1259711927;
            // ---------- Original Method ----------
            //hasLeadingDigits = true;
            //leadingDigits_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.124 -0400", hash_original_method = "DF6824D9CE520B4AB88B3980F12D84DC", hash_generated_method = "836D19C6AEF06DD556C5CF9F8DC8DD47")
        public boolean hasLeadingZeroPossible() {
            boolean var352F42E9E2F51AB889A7ACC99B15F496_1805367232 = (hasLeadingZeroPossible);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_559858676 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_559858676;
            // ---------- Original Method ----------
            //return hasLeadingZeroPossible;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.124 -0400", hash_original_method = "9CE4681262676BB262003F306366B26D", hash_generated_method = "C3539F861765394457A1E383CC3D5BB7")
        public boolean isLeadingZeroPossible() {
            boolean var544EA9601687ABD32F40D28D321B0134_416915239 = (leadingZeroPossible_);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1816801784 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1816801784;
            // ---------- Original Method ----------
            //return leadingZeroPossible_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.124 -0400", hash_original_method = "4E51759A218DB37A00D6735D1891D88D", hash_generated_method = "0CE70655F41365657976451CC1CE56FC")
        public PhoneMetadata setLeadingZeroPossible(boolean value) {
            hasLeadingZeroPossible = true;
            leadingZeroPossible_ = value;
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_1507966710 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1507966710.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1507966710;
            // ---------- Original Method ----------
            //hasLeadingZeroPossible = true;
            //leadingZeroPossible_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.126 -0400", hash_original_method = "82C82662DE792F1D24D935E7D9A568AC", hash_generated_method = "3CFDD3FA6CE8F7C207BBE12C0FCDDAD8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.129 -0400", hash_original_method = "4D891D3CC56C8A4A25C2FA3B62E66106", hash_generated_method = "68C4B4E6932F5678320FEB53BD6FBFC6")
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.129 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.129 -0400", hash_original_method = "FECA3DB69AA5738CC513C59EB359D04E", hash_generated_method = "33AEB8F33F447DAD0AFC4DCC7C31CBFA")
            public PhoneMetadata build() {
PhoneMetadata var72A74007B2BE62B849F475C7BDA4658B_442054912 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_442054912.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_442054912;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.129 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
    public static class PhoneMetadataCollection implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.130 -0400", hash_original_field = "612BD1F5CEECC04CA1A32C585074C146", hash_generated_field = "3988CF3B3569C765826A81A610C2CFA8")

        private java.util.List<PhoneMetadata> metadata_ = new java.util.ArrayList<PhoneMetadata>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.130 -0400", hash_original_method = "833FEC11FB1A703522FFE165412E2F7D", hash_generated_method = "911AB4D46731349730F9522D952A81AB")
        public  PhoneMetadataCollection() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.130 -0400", hash_original_method = "C5ECD645F70FA9D5A2A9EB8CBA32ADEF", hash_generated_method = "4FAA8C1957C9E5235A028C898543AD02")
        public java.util.List<PhoneMetadata> getMetadataList() {
java.util.List<PhoneMetadata> var408FE00FE1CE1B7F862D9C0F3191C4A3_476693515 =             metadata_;
            var408FE00FE1CE1B7F862D9C0F3191C4A3_476693515.addTaint(taint);
            return var408FE00FE1CE1B7F862D9C0F3191C4A3_476693515;
            // ---------- Original Method ----------
            //return metadata_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.130 -0400", hash_original_method = "95419ED058599C84B2A0103C5C8B3F30", hash_generated_method = "92B44D412614A31BB8FE5CB0FF01FB98")
        public int getMetadataCount() {
            int var4BF3C0E17ADF834B03066085E6DB37D6_1544188794 = (metadata_.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546082683 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546082683;
            // ---------- Original Method ----------
            //return metadata_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.131 -0400", hash_original_method = "D57D52560347164C8871C87ACF1DAD2C", hash_generated_method = "57C4A641239A8E7C810C05B20D996A67")
        public PhoneMetadataCollection addMetadata(PhoneMetadata value) {
            addTaint(value.getTaint());
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1708407376 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1708407376.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1708407376;
            } //End block
            metadata_.add(value);
PhoneMetadataCollection var72A74007B2BE62B849F475C7BDA4658B_835800209 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_835800209.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_835800209;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //metadata_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.131 -0400", hash_original_method = "BDFB00F39A05DC0D50872248169D293E", hash_generated_method = "1A957EA48698989247007B0B7BD1E431")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.131 -0400", hash_original_method = "FAC331B8B6AD54634EE3CFAA3149ADF1", hash_generated_method = "1C5E8E34AE1D24EFF93B3420822781B5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.131 -0400", hash_original_method = "1BB2E7D611D4F26F7F8136F4B2C1D585", hash_generated_method = "F2D021EE14C7C0837D32D9FA1B8B5D52")
        public PhoneMetadataCollection clear() {
            metadata_.clear();
PhoneMetadataCollection var72A74007B2BE62B849F475C7BDA4658B_202416359 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_202416359.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_202416359;
            // ---------- Original Method ----------
            //metadata_.clear();
            //return this;
        }

        
        public static final class Builder extends PhoneMetadataCollection {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.132 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.132 -0400", hash_original_method = "62075F60ED3DD2393D61C900D272662C", hash_generated_method = "1568795FB9B34E72FACC7D440CC056F0")
            public PhoneMetadataCollection build() {
PhoneMetadataCollection var72A74007B2BE62B849F475C7BDA4658B_1104881027 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1104881027.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1104881027;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.132 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
}

