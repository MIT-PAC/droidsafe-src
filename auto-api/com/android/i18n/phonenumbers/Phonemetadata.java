package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class Phonemetadata {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.433 -0400", hash_original_method = "AA2168146A79C42118444B1AF1D13430", hash_generated_method = "01D7B0EC1EB8E0CA70481AF327448A6E")
    private  Phonemetadata() {
        // ---------- Original Method ----------
    }

    
    public static class NumberFormat implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.433 -0400", hash_original_field = "EBB44F9DC35254EE54F96EB8D2936620", hash_generated_field = "BCFAB4E6509DB535E782A9A7638BF800")

        private boolean hasPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.433 -0400", hash_original_field = "7BA2602BE34151F7BF8709C5E6902A23", hash_generated_field = "A40119EC58A9ADBEEF7F74515C4824EB")

        private String pattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.433 -0400", hash_original_field = "FB3499637AAFAB74C9C7084B2A5F6485", hash_generated_field = "BB7D9B531AF497BD0CC6485A499825C4")

        private boolean hasFormat;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.433 -0400", hash_original_field = "E46CD8EF559BE4A57DCE6A0505568890", hash_generated_field = "331E3EC56817A5418D313A742EE6BAF6")

        private String format_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.433 -0400", hash_original_field = "2FC5ACB9349FF6307BF22B61065526C5", hash_generated_field = "8C6856D900C2B3217AAACE1CB04BBDC9")

        private java.util.List<String> leadingDigitsPattern_ = new java.util.ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.433 -0400", hash_original_field = "3BCF607E89F66B196F9AF26CAC995637", hash_generated_field = "92669F4414DE1997CD38BA06884F29EB")

        private boolean hasNationalPrefixFormattingRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.433 -0400", hash_original_field = "61056B131F75442BA186CE92F8481346", hash_generated_field = "B5917D98A0DF4DBF46F96EC8B9B42B54")

        private String nationalPrefixFormattingRule_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.433 -0400", hash_original_field = "FBF94AE436756F8EF0359BB5BCECE5A5", hash_generated_field = "1C2206B3A1E5D1FEEB3BC9386E1B8AEC")

        private boolean hasDomesticCarrierCodeFormattingRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.433 -0400", hash_original_field = "6FDFEB13B19DC6F980A9FF00FF64E797", hash_generated_field = "4E860583F8E21CB17BEAB512DD9874BA")

        private String domesticCarrierCodeFormattingRule_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.438 -0400", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "8FEBA1E1E8A6552B6917C667BFAE4E78")
        public  NumberFormat() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.444 -0400", hash_original_method = "0246232EE6FB2A92C361AD6A40430F9A", hash_generated_method = "FC36FA6FAD06A57AC69D1545EEB82FC0")
        public boolean hasPattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2032418763 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2032418763;
            // ---------- Original Method ----------
            //return hasPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.445 -0400", hash_original_method = "42C6A53B1E4394F40C706B46BCE960D0", hash_generated_method = "FFD0496661C6C4E00CDE8187D0CB0A24")
        public String getPattern() {
            String varB4EAC82CA7396A68D541C85D26508E83_1347216530 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1347216530 = pattern_;
            varB4EAC82CA7396A68D541C85D26508E83_1347216530.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1347216530;
            // ---------- Original Method ----------
            //return pattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.446 -0400", hash_original_method = "ED9D042141B07F3A02D73E93DCCEE4F0", hash_generated_method = "8593A01ADE6AB34FA065CEB3BF305E9A")
        public NumberFormat setPattern(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1304299455 = null; //Variable for return #1
            hasPattern = true;
            pattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1304299455 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1304299455.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1304299455;
            // ---------- Original Method ----------
            //hasPattern = true;
            //pattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.446 -0400", hash_original_method = "68B5595866A3AC066C218CEE1670E78C", hash_generated_method = "A42C06FA2181030BB59C6F24CFB55F99")
        public boolean hasFormat() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316910039 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_316910039;
            // ---------- Original Method ----------
            //return hasFormat;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.452 -0400", hash_original_method = "77809F0555E410001A5868E71E8924BD", hash_generated_method = "438E801D20E4A0056B498DF6104E6E0B")
        public String getFormat() {
            String varB4EAC82CA7396A68D541C85D26508E83_493854350 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_493854350 = format_;
            varB4EAC82CA7396A68D541C85D26508E83_493854350.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_493854350;
            // ---------- Original Method ----------
            //return format_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.453 -0400", hash_original_method = "791160F9BB3B0A81AD0DFEC24C1732C9", hash_generated_method = "190E48B1E4F1331FF5B372089878BE38")
        public NumberFormat setFormat(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_112176236 = null; //Variable for return #1
            hasFormat = true;
            format_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_112176236 = this;
            varB4EAC82CA7396A68D541C85D26508E83_112176236.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_112176236;
            // ---------- Original Method ----------
            //hasFormat = true;
            //format_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.454 -0400", hash_original_method = "E6A52876E9E1328523A23CDD4ADD6081", hash_generated_method = "C8CCC1CA8C964EA6621ECD1ABEAA2843")
        public java.util.List<String> leadingDigitPatterns() {
            java.util.List<String> varB4EAC82CA7396A68D541C85D26508E83_1499073532 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1499073532 = leadingDigitsPattern_;
            varB4EAC82CA7396A68D541C85D26508E83_1499073532.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1499073532;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.456 -0400", hash_original_method = "A7BC4264224DD72A69FEDA104C14570A", hash_generated_method = "C41DDF0A99B4189AE7736227B3FE1690")
        public int leadingDigitsPatternSize() {
            int varB0FE41F8E6695F261080B3A10B142102_1541894243 = (leadingDigitsPattern_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_321088579 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_321088579;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.466 -0400", hash_original_method = "F45A9318A15D3A63FB863C1586B0A383", hash_generated_method = "07CD621C320B79DAA30937DF253AE47C")
        public String getLeadingDigitsPattern(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_757637955 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_757637955 = leadingDigitsPattern_.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_757637955.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_757637955;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.467 -0400", hash_original_method = "67AADF10399513606F7245D93555CAB7", hash_generated_method = "7F1A695580CEB501F7756456A1EF877B")
        public NumberFormat addLeadingDigitsPattern(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1612948075 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            leadingDigitsPattern_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_1612948075 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1612948075.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1612948075;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //leadingDigitsPattern_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.467 -0400", hash_original_method = "A0F401EEBE63541205F643F348AC0373", hash_generated_method = "CFDEC4C5C7B3FBA55161364E89737E0F")
        public boolean hasNationalPrefixFormattingRule() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1914626120 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1914626120;
            // ---------- Original Method ----------
            //return hasNationalPrefixFormattingRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.476 -0400", hash_original_method = "4B4C80C20D7D7C0D6F8A6AA39111D13B", hash_generated_method = "8FB1BA1AD6AD4BE43C1102AE884AA85F")
        public String getNationalPrefixFormattingRule() {
            String varB4EAC82CA7396A68D541C85D26508E83_1272760268 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1272760268 = nationalPrefixFormattingRule_;
            varB4EAC82CA7396A68D541C85D26508E83_1272760268.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1272760268;
            // ---------- Original Method ----------
            //return nationalPrefixFormattingRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.482 -0400", hash_original_method = "6C67B9000B21FDC6ACFC6210DBD720A7", hash_generated_method = "EAC7216CB5BA4F947DE63B510F137C7A")
        public NumberFormat setNationalPrefixFormattingRule(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_180226666 = null; //Variable for return #1
            hasNationalPrefixFormattingRule = true;
            nationalPrefixFormattingRule_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_180226666 = this;
            varB4EAC82CA7396A68D541C85D26508E83_180226666.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_180226666;
            // ---------- Original Method ----------
            //hasNationalPrefixFormattingRule = true;
            //nationalPrefixFormattingRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.487 -0400", hash_original_method = "394C283EEDF7D9BA381FE6D7D2DD662E", hash_generated_method = "9CD257A0E5A8D6F3BFC5CC39844FFC14")
        public NumberFormat clearNationalPrefixFormattingRule() {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_853775951 = null; //Variable for return #1
            hasNationalPrefixFormattingRule = false;
            nationalPrefixFormattingRule_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_853775951 = this;
            varB4EAC82CA7396A68D541C85D26508E83_853775951.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_853775951;
            // ---------- Original Method ----------
            //hasNationalPrefixFormattingRule = false;
            //nationalPrefixFormattingRule_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.487 -0400", hash_original_method = "1D512C574271A1305D1AF9A0CCC5C6D3", hash_generated_method = "AF974E4556E657AC908E5A32FC177B3C")
        public boolean hasDomesticCarrierCodeFormattingRule() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1129962115 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1129962115;
            // ---------- Original Method ----------
            //return hasDomesticCarrierCodeFormattingRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.488 -0400", hash_original_method = "1D78023CBBDF63A0A2ACC33925BD120F", hash_generated_method = "588F8D8F616C65B7883D25EF8876033B")
        public String getDomesticCarrierCodeFormattingRule() {
            String varB4EAC82CA7396A68D541C85D26508E83_96901115 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_96901115 = domesticCarrierCodeFormattingRule_;
            varB4EAC82CA7396A68D541C85D26508E83_96901115.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_96901115;
            // ---------- Original Method ----------
            //return domesticCarrierCodeFormattingRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.488 -0400", hash_original_method = "2168D8046E4A0ED39DDD19551FD64D5A", hash_generated_method = "5C34892EF32493C4EFE218FD2F0439B0")
        public NumberFormat setDomesticCarrierCodeFormattingRule(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_867378401 = null; //Variable for return #1
            hasDomesticCarrierCodeFormattingRule = true;
            domesticCarrierCodeFormattingRule_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_867378401 = this;
            varB4EAC82CA7396A68D541C85D26508E83_867378401.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_867378401;
            // ---------- Original Method ----------
            //hasDomesticCarrierCodeFormattingRule = true;
            //domesticCarrierCodeFormattingRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.489 -0400", hash_original_method = "DEB91FB350FEBE5DEE35AF7BFA950AEF", hash_generated_method = "15455E74CBB39BF29CEF264AC1C74109")
        public NumberFormat mergeFrom(NumberFormat other) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_825256382 = null; //Variable for return #1
            {
                boolean varF081F818C9346840C1C05850A1E84836_1289038152 = (other.hasPattern());
                {
                    setPattern(other.getPattern());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var3120A21678B49476E859E38D301D6C44_1278531999 = (other.hasFormat());
                {
                    setFormat(other.getFormat());
                } //End block
            } //End collapsed parenthetic
            int leadingDigitsPatternSize;
            leadingDigitsPatternSize = other.leadingDigitsPatternSize();
            {
                int i;
                i = 0;
                {
                    addLeadingDigitsPattern(other.getLeadingDigitsPattern(i));
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDDD2CD16D3ACF0EDF8A5770CE9BF81DE_1123685198 = (other.hasNationalPrefixFormattingRule());
                {
                    setNationalPrefixFormattingRule(other.getNationalPrefixFormattingRule());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var41F6787BFF8421A70F22829D88E4C6F7_1687200341 = (other.hasDomesticCarrierCodeFormattingRule());
                {
                    setDomesticCarrierCodeFormattingRule(other.getDomesticCarrierCodeFormattingRule());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_825256382 = this;
            addTaint(other.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_825256382.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_825256382;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.504 -0400", hash_original_method = "A100AA8318BC8064BB1FFCA8BFB04888", hash_generated_method = "8D599BE5B93D1BF457F5D040FA4595C7")
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeUTF(pattern_);
            objectOutput.writeUTF(format_);
            int leadingDigitsPatternSize;
            leadingDigitsPatternSize = leadingDigitsPatternSize();
            objectOutput.writeInt(leadingDigitsPatternSize);
            {
                int i;
                i = 0;
                {
                    objectOutput.writeUTF(leadingDigitsPattern_.get(i));
                } //End block
            } //End collapsed parenthetic
            objectOutput.writeBoolean(hasNationalPrefixFormattingRule);
            {
                objectOutput.writeUTF(nationalPrefixFormattingRule_);
            } //End block
            objectOutput.writeBoolean(hasDomesticCarrierCodeFormattingRule);
            {
                objectOutput.writeUTF(domesticCarrierCodeFormattingRule_);
            } //End block
            addTaint(objectOutput.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.505 -0400", hash_original_method = "A5A163CCCC35630D5C707482125AAE27", hash_generated_method = "D4CD91EA462A360C06E281FF1C5E4C46")
        public void readExternal(ObjectInput objectInput) throws IOException {
            setPattern(objectInput.readUTF());
            setFormat(objectInput.readUTF());
            int leadingDigitsPatternSize;
            leadingDigitsPatternSize = objectInput.readInt();
            {
                int i;
                i = 0;
                {
                    leadingDigitsPattern_.add(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_410558606 = (objectInput.readBoolean());
                {
                    setNationalPrefixFormattingRule(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_1528701222 = (objectInput.readBoolean());
                {
                    setDomesticCarrierCodeFormattingRule(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            addTaint(objectInput.getTaint());
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.505 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.508 -0400", hash_original_method = "0B2E67344AC06F839A81A2533D186625", hash_generated_method = "CAB343EED97FADF97CC54E4DDCA573F5")
            public NumberFormat build() {
                NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1013383141 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1013383141 = this;
                varB4EAC82CA7396A68D541C85D26508E83_1013383141.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1013383141;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.509 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "DF26AFCCBB9DDCFC72C78DA996786C5E")

        private static long serialVersionUID = 1;
    }


    
    public static class PhoneNumberDesc implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.518 -0400", hash_original_field = "DF8FA0961A72330EDFA83A06858DAA6D", hash_generated_field = "FE0D4AC450B46E7BA63C0A5FF14C51C2")

        private boolean hasNationalNumberPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.518 -0400", hash_original_field = "B9BBEC8ED347133624C9F13EC01959D6", hash_generated_field = "EEA13D95EC1A783CC3FD2A2EA5BF77DB")

        private String nationalNumberPattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.518 -0400", hash_original_field = "5128B6327ABA67ABA34F0D40555173E8", hash_generated_field = "A5D4C78E7537A35AEAFB80E70E1EF9CF")

        private boolean hasPossibleNumberPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.518 -0400", hash_original_field = "CE9BECD6E9AE72932A581A01A4BC72CF", hash_generated_field = "9740030449804334CD1D210C9AACA78D")

        private String possibleNumberPattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.518 -0400", hash_original_field = "2439321B7A9F025B302F5484BF5AA1CC", hash_generated_field = "A377FEAF080DA6EA07178B0BF7E01505")

        private boolean hasExampleNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.518 -0400", hash_original_field = "A267297FDB6460E899FB01789A537AEF", hash_generated_field = "D8EDB7AA5577953B265C1D4AEECCDF65")

        private String exampleNumber_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.518 -0400", hash_original_method = "7B50B3AE2E947514292047EE4CC3D0B3", hash_generated_method = "FF0F10C59E5A022C63A72AE504F6D672")
        public  PhoneNumberDesc() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.519 -0400", hash_original_method = "7AE951C08CA66D0892FA0795F4703C0D", hash_generated_method = "5A6D1BFBF576EE70C086477C4707C0CE")
        public boolean hasNationalNumberPattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130905938 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_130905938;
            // ---------- Original Method ----------
            //return hasNationalNumberPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.524 -0400", hash_original_method = "AE5307416A342E6E51B0D8AFEA64E005", hash_generated_method = "269A0C686FB2C9876F59B43E37C45B89")
        public String getNationalNumberPattern() {
            String varB4EAC82CA7396A68D541C85D26508E83_691973246 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_691973246 = nationalNumberPattern_;
            varB4EAC82CA7396A68D541C85D26508E83_691973246.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_691973246;
            // ---------- Original Method ----------
            //return nationalNumberPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.525 -0400", hash_original_method = "5843589EEE5242B872EEFCA090E2182C", hash_generated_method = "01699FB4247B86632E720F43FA1C5F75")
        public PhoneNumberDesc setNationalNumberPattern(String value) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1340667603 = null; //Variable for return #1
            hasNationalNumberPattern = true;
            nationalNumberPattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1340667603 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1340667603.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1340667603;
            // ---------- Original Method ----------
            //hasNationalNumberPattern = true;
            //nationalNumberPattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.525 -0400", hash_original_method = "0D2D12A828079BB292F0B693EDB7AA61", hash_generated_method = "7C7FC03C94D0417A81E24EFA17A023AF")
        public boolean hasPossibleNumberPattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_46482805 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_46482805;
            // ---------- Original Method ----------
            //return hasPossibleNumberPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.526 -0400", hash_original_method = "69E173398B553B507060BBCC25879496", hash_generated_method = "FA322FFD56F82143568C769459C8B2AE")
        public String getPossibleNumberPattern() {
            String varB4EAC82CA7396A68D541C85D26508E83_1856265151 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1856265151 = possibleNumberPattern_;
            varB4EAC82CA7396A68D541C85D26508E83_1856265151.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1856265151;
            // ---------- Original Method ----------
            //return possibleNumberPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.527 -0400", hash_original_method = "E6F0FD7A3910EDF596B66C25C9FCACCB", hash_generated_method = "F786BF7C04B0E99AAF6B4558A96FD247")
        public PhoneNumberDesc setPossibleNumberPattern(String value) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1803215231 = null; //Variable for return #1
            hasPossibleNumberPattern = true;
            possibleNumberPattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1803215231 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1803215231.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1803215231;
            // ---------- Original Method ----------
            //hasPossibleNumberPattern = true;
            //possibleNumberPattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.531 -0400", hash_original_method = "9EA98547022BA9B31E373C0BBC90B4AD", hash_generated_method = "3F43D24106B6572E409E82782B0CFAA2")
        public boolean hasExampleNumber() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110849259 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_110849259;
            // ---------- Original Method ----------
            //return hasExampleNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.531 -0400", hash_original_method = "4F2E88760366816D23F2792FF3D4D910", hash_generated_method = "49C1E0A62E5C844FFAD8AF45C826F60B")
        public String getExampleNumber() {
            String varB4EAC82CA7396A68D541C85D26508E83_608302321 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_608302321 = exampleNumber_;
            varB4EAC82CA7396A68D541C85D26508E83_608302321.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_608302321;
            // ---------- Original Method ----------
            //return exampleNumber_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.543 -0400", hash_original_method = "99D22C86FFDC5E436BCE118592FFD464", hash_generated_method = "3AE58DCE8B81A7D9B5824425D3CC5F9A")
        public PhoneNumberDesc setExampleNumber(String value) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1997356285 = null; //Variable for return #1
            hasExampleNumber = true;
            exampleNumber_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1997356285 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1997356285.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1997356285;
            // ---------- Original Method ----------
            //hasExampleNumber = true;
            //exampleNumber_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.554 -0400", hash_original_method = "13E9D2F0445C754E67764A18611FF669", hash_generated_method = "9D11CD8B0DA7D4EC02519EB3F0C1D822")
        public PhoneNumberDesc mergeFrom(PhoneNumberDesc other) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1930183155 = null; //Variable for return #1
            {
                boolean varD58E2A0E1D953219659F1147E75D73F4_1806451037 = (other.hasNationalNumberPattern());
                {
                    setNationalNumberPattern(other.getNationalNumberPattern());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varC6F51288774EBF45A3EF2B68674CCC4F_79459744 = (other.hasPossibleNumberPattern());
                {
                    setPossibleNumberPattern(other.getPossibleNumberPattern());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var63E297A85C8F39AFE7F8C657D805A65F_1997999226 = (other.hasExampleNumber());
                {
                    setExampleNumber(other.getExampleNumber());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1930183155 = this;
            addTaint(other.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1930183155.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1930183155;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.555 -0400", hash_original_method = "67972576318010D4A6F8FC5204742584", hash_generated_method = "1E5A935CC04DEA91119151509FBBC4D3")
        public boolean exactlySameAs(PhoneNumberDesc other) {
            boolean var6367AA144C0559F2B90F3AB658EAE0FD_2023283757 = (nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          exampleNumber_.equals(other.exampleNumber_));
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2021046935 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2021046935;
            // ---------- Original Method ----------
            //return nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          //possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          //exampleNumber_.equals(other.exampleNumber_);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.556 -0400", hash_original_method = "A248C31238E31950C31B42AEACDEB8E6", hash_generated_method = "107091F0B9E8823957DC97ED30F00CA8")
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(hasNationalNumberPattern);
            {
                objectOutput.writeUTF(nationalNumberPattern_);
            } //End block
            objectOutput.writeBoolean(hasPossibleNumberPattern);
            {
                objectOutput.writeUTF(possibleNumberPattern_);
            } //End block
            objectOutput.writeBoolean(hasExampleNumber);
            {
                objectOutput.writeUTF(exampleNumber_);
            } //End block
            addTaint(objectOutput.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.556 -0400", hash_original_method = "27FB9E0837C2CDBADF688660FFE7A75C", hash_generated_method = "D526A7620BEF1EA4A5DB147271674672")
        public void readExternal(ObjectInput objectInput) throws IOException {
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_1771532067 = (objectInput.readBoolean());
                {
                    setNationalNumberPattern(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_372139598 = (objectInput.readBoolean());
                {
                    setPossibleNumberPattern(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_39146810 = (objectInput.readBoolean());
                {
                    setExampleNumber(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            addTaint(objectInput.getTaint());
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.556 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.568 -0400", hash_original_method = "27A166D755957BD27B60D63CE4983A6A", hash_generated_method = "74C897B1EB6FD7BA1499B326F6F43BBC")
            public PhoneNumberDesc build() {
                PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_933525275 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_933525275 = this;
                varB4EAC82CA7396A68D541C85D26508E83_933525275.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_933525275;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.575 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "DF26AFCCBB9DDCFC72C78DA996786C5E")

        private static long serialVersionUID = 1;
    }


    
    public static class PhoneMetadata implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "B1185F70DC285179A2028122A1753D38", hash_generated_field = "A3B9F71CE88284DA159E437E743AF585")

        private boolean hasGeneralDesc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "419108228A3D4DD7D84FDBBA426B692E", hash_generated_field = "7468C9C864A0465318B0CE4D7F53C201")

        private PhoneNumberDesc generalDesc_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "E592D649F417667F2723D6FFED6E2DB7", hash_generated_field = "E05C42AA9F7E3C173F9E6FFB96993C10")

        private boolean hasFixedLine;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "7D61EBE9F230AE4F535BB262D140087E", hash_generated_field = "6B2D29317DA7FDD4358F05B6ED70E817")

        private PhoneNumberDesc fixedLine_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "8624D101BA06AC461F2198E30D1F6A12", hash_generated_field = "6732DA5D8F7E44D3EB8E9B3B04D2C208")

        private boolean hasMobile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "9A3666ECDC25598E8B1F39C149B5248B", hash_generated_field = "B09F10BC9C29A32513C7F9D45C9DD65D")

        private PhoneNumberDesc mobile_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "75EB0178779C5B94A142C67A8A3A0895", hash_generated_field = "80FAAA0975BF29FCB14D951C0BEDC5C4")

        private boolean hasTollFree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "8A684838F9710DEC6492C65DEB5B5A0F", hash_generated_field = "80CDA2C3C5F8E5226552943E5B5D1962")

        private PhoneNumberDesc tollFree_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "6401DBC84CDD207E60C202A21F935454", hash_generated_field = "5A30F5E3B7119D5842288ABCFFE97498")

        private boolean hasPremiumRate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "A525D6594473341CA8B89D37798B312E", hash_generated_field = "A45FECABBF74FB7321F9023E44E33237")

        private PhoneNumberDesc premiumRate_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "B64C7B1A99130C1E792DC2EC767D9EFB", hash_generated_field = "E49185F054F9F704C5600406F67DCB84")

        private boolean hasSharedCost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "1E9F4723F699DE8125552E21FFBFE400", hash_generated_field = "F1E7A155AA2DB5B0B5B95BFB0CEE31C9")

        private PhoneNumberDesc sharedCost_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "C6671814FF918E89A75FE4D83E386A68", hash_generated_field = "EDA3B33207D61D6AC565FA093ADCC196")

        private boolean hasPersonalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "1CFAD4514D14064196C72BF65F9CF559", hash_generated_field = "9BEB6F47AE29097500633D2F6F699031")

        private PhoneNumberDesc personalNumber_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "6993F15A6272097A69996233948D6788", hash_generated_field = "389614404066D2EFA2E54C2350D94AD0")

        private boolean hasVoip;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "4F48640F12EB1E254E7007633AE6A4BB", hash_generated_field = "EFA41A681D6E8CCFBC92A6D814B85301")

        private PhoneNumberDesc voip_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "F4712A7EC85B48169BE6F130B09401AF", hash_generated_field = "AA932FC09168FC29B0E1BDD3089132CB")

        private boolean hasPager;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.580 -0400", hash_original_field = "B53FED5DFF5974BE7B138F1CA58A1B36", hash_generated_field = "6DF80094481DB5FAFFA343EECB46293A")

        private PhoneNumberDesc pager_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "1C045935E1F5FA0A1792848701C607B3", hash_generated_field = "8F81ABDD16142E28D9E5984C6F740238")

        private boolean hasUan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "8579B62499AB55F965AD299835FB973C", hash_generated_field = "AD69C3410F5AE892799A6AC7CB2532E2")

        private PhoneNumberDesc uan_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "DA4DF0660D0FEED67B00F588F241E7EB", hash_generated_field = "0ADF693E546C325541D053D46F07CA67")

        private boolean hasNoInternationalDialling;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "460049B379C4B8AF431BAEE1EBCBF02E", hash_generated_field = "DB4742972A73F31DE788D6B88EE269C4")

        private PhoneNumberDesc noInternationalDialling_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "B00599996521998233C824ACCAB0E15F", hash_generated_field = "0140279EBB974905A38C47A7722FAFF6")

        private boolean hasId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "09E215DDF102AD5C73EE5F65A3C0CAB9", hash_generated_field = "A3944B7884E3A988EBAE9C53EFFAD5F5")

        private String id_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "8DA9382CFAB6A2934FA5AD3C46617F89", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

        private boolean hasCountryCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "3461D01D5A7F32E3FA9B229113397711", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

        private int countryCode_ = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "71E29C99125BF827B3C5BF568381086E", hash_generated_field = "5FC44BC01719FCF066ECC548BE8A5361")

        private boolean hasInternationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "E282158924B697D8BC6CAAE1BC57B7AB", hash_generated_field = "717A913C833941AC2C547FE2DFF1FB22")

        private String internationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "3ECE55B44C31E2628C42F70CE9639621", hash_generated_field = "A9895E937CD8DAE0C496DBC48D2C2CEE")

        private boolean hasPreferredInternationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "FCD8C7D7DFF78E7FA4B7EEE488EB6AC0", hash_generated_field = "CDC303EF35375A2E1F5FC52FA30A0AEF")

        private String preferredInternationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "4470362D119F8595D8A4313EC3BBE684", hash_generated_field = "7558F68656CC64EE957040556631A4B3")

        private boolean hasNationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "7FFC07608A27C8D4C3337E4B3E617A97", hash_generated_field = "9FD4079672B074B1C28FCBD5211F0E6E")

        private String nationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "CE3736A3B3D1072084220B70CD4D0A4F", hash_generated_field = "D4784FA8A81183D66211EA3CB7EAD63D")

        private boolean hasPreferredExtnPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "3BFE67D70B206F596FE6BB87EA4FC2EE", hash_generated_field = "F27B632A949D8FCEF65E426D0FEC59C2")

        private String preferredExtnPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "178A91AD8C9D4B311CBB7E9799C204D6", hash_generated_field = "507A8081AF30D85EF13F20C27737EE29")

        private boolean hasNationalPrefixForParsing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.581 -0400", hash_original_field = "5CE340B02A46FE9107F9780901340CAC", hash_generated_field = "46A092752488BEB0567E42ECBB5103EA")

        private String nationalPrefixForParsing_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "037AAC783F91D571F6E54112E2703ECE", hash_generated_field = "B59E7752C84471B249DCD9F9C398AFC5")

        private boolean hasNationalPrefixTransformRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "E828C84B52178E6A7F8B07EA0784D668", hash_generated_field = "08067D30B404B72AEBA1F2484BFD694C")

        private String nationalPrefixTransformRule_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "5E31C2CEC062E7B8113B945A2F2AA0E9", hash_generated_field = "31870DDEA4297A7CAB4D169E31FFFEBE")

        private boolean hasSameMobileAndFixedLinePattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "E4C862F971A24839C23EBE9F978A48B6", hash_generated_field = "789005A5E2E7FE7FCA1F46FB6F3F7B13")

        private boolean sameMobileAndFixedLinePattern_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "181C76BA224D14DBE65B8E0F96308942", hash_generated_field = "B800AB6258E8C26EC659EA232E613974")

        private java.util.List<NumberFormat> numberFormat_ = new java.util.ArrayList<NumberFormat>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "38053CEBD2D283DF20A1B56D88B2FD5C", hash_generated_field = "8438C32E42D261618BF3822D8254B874")

        private java.util.List<NumberFormat> intlNumberFormat_ = new java.util.ArrayList<NumberFormat>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "08D2B80646091F0A5CABE08AE2346FDA", hash_generated_field = "30F748667FFCDF08F79F81730072A8E1")

        private boolean hasMainCountryForCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "939EF08D7E9438FD155F13C644263B24", hash_generated_field = "7BE3C4CE079A909FDB8BCA00D97F89BF")

        private boolean mainCountryForCode_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "17079C6943CC232663CE7B61C9E492DB", hash_generated_field = "AE9DE5751CA76FAC5FD0690889290B59")

        private boolean hasLeadingDigits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "E5D90B3FC23E47C17AFA7132318C4380", hash_generated_field = "A2DF202A3B5F3D62339A3B2DE2A4FAB2")

        private String leadingDigits_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "352F42E9E2F51AB889A7ACC99B15F496", hash_generated_field = "4AEC48A66912462BA0FE869D7DC85F43")

        private boolean hasLeadingZeroPossible;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.582 -0400", hash_original_field = "87145D95F10EE570BBC9AFAE6F259808", hash_generated_field = "F45DAF5712BFBE9A35415A4D733DC0FC")

        private boolean leadingZeroPossible_ = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.583 -0400", hash_original_method = "8411C48F959C93D1C6435DDA5C4FFBF8", hash_generated_method = "246EB5CC112F2B1B6402C47CB846FD5D")
        public  PhoneMetadata() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.583 -0400", hash_original_method = "573E786E141FAAA03A367F49BCA559B5", hash_generated_method = "DF51C77F228DD759C4308D89D48DA62E")
        public boolean hasGeneralDesc() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1091794135 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1091794135;
            // ---------- Original Method ----------
            //return hasGeneralDesc;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.584 -0400", hash_original_method = "F96C4A1868C09190E3C941F03A2889CB", hash_generated_method = "067E83BD5204CDDEDDEFA0B800B3BB4D")
        public PhoneNumberDesc getGeneralDesc() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_2047148871 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2047148871 = generalDesc_;
            varB4EAC82CA7396A68D541C85D26508E83_2047148871.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2047148871;
            // ---------- Original Method ----------
            //return generalDesc_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.585 -0400", hash_original_method = "97D824F311B5130867761544B2540B90", hash_generated_method = "6DFAB70122E4C1F8FA1E85D4783FAC62")
        public PhoneMetadata setGeneralDesc(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_13290791 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasGeneralDesc = true;
            generalDesc_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_13290791 = this;
            varB4EAC82CA7396A68D541C85D26508E83_13290791.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_13290791;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasGeneralDesc = true;
            //generalDesc_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.585 -0400", hash_original_method = "0B06F02C38AE7EA6E1205EAD00F0F3D7", hash_generated_method = "6FEAE0D2BA04F79C0E8EC8CDCB64B1E4")
        public boolean hasFixedLine() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1930225135 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1930225135;
            // ---------- Original Method ----------
            //return hasFixedLine;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.586 -0400", hash_original_method = "7111E9DB2C9B99769226207CB0B39C0D", hash_generated_method = "6DF852A205158643AB9936807661A227")
        public PhoneNumberDesc getFixedLine() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1422214595 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1422214595 = fixedLine_;
            varB4EAC82CA7396A68D541C85D26508E83_1422214595.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1422214595;
            // ---------- Original Method ----------
            //return fixedLine_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.595 -0400", hash_original_method = "4E0B7145906BC721C9DE8D0C32500FC9", hash_generated_method = "11D1B8482EBC7F5868AD5F14C46BC250")
        public PhoneMetadata setFixedLine(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1066496886 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasFixedLine = true;
            fixedLine_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1066496886 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1066496886.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1066496886;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasFixedLine = true;
            //fixedLine_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.606 -0400", hash_original_method = "F5A454F163C8198EDADB6A0267665530", hash_generated_method = "E59ADECFB9146E215A53EFC385D218BC")
        public boolean hasMobile() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_3622075 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_3622075;
            // ---------- Original Method ----------
            //return hasMobile;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.606 -0400", hash_original_method = "469BFC723D37FABFB9BC30DE50B7B80A", hash_generated_method = "4BB6918AE540B8A11F458767F7451536")
        public PhoneNumberDesc getMobile() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_2135083704 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2135083704 = mobile_;
            varB4EAC82CA7396A68D541C85D26508E83_2135083704.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2135083704;
            // ---------- Original Method ----------
            //return mobile_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.607 -0400", hash_original_method = "CF0A4860566840BE9C27E4474979A50E", hash_generated_method = "D4DA914977E461BB6AA6252DBCAFD216")
        public PhoneMetadata setMobile(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_895630092 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasMobile = true;
            mobile_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_895630092 = this;
            varB4EAC82CA7396A68D541C85D26508E83_895630092.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_895630092;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasMobile = true;
            //mobile_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.607 -0400", hash_original_method = "C6BB80AB6E7BD893E9D8810967101490", hash_generated_method = "3EE8C9AFD4F4D583FE07FB89295DACEA")
        public boolean hasTollFree() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_258893237 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_258893237;
            // ---------- Original Method ----------
            //return hasTollFree;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.608 -0400", hash_original_method = "A25CEA98E2A744A76CD23B6ECE21AB56", hash_generated_method = "FAAC0D0C8C515C509132C3DB45771819")
        public PhoneNumberDesc getTollFree() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_56098442 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_56098442 = tollFree_;
            varB4EAC82CA7396A68D541C85D26508E83_56098442.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_56098442;
            // ---------- Original Method ----------
            //return tollFree_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.608 -0400", hash_original_method = "46A649F605F0EC24C76169E259456A93", hash_generated_method = "23B0A5F92B81A7B0B321C830E1C80607")
        public PhoneMetadata setTollFree(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_124196463 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasTollFree = true;
            tollFree_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_124196463 = this;
            varB4EAC82CA7396A68D541C85D26508E83_124196463.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_124196463;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasTollFree = true;
            //tollFree_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.608 -0400", hash_original_method = "82079540736B40B455CF317890B4623A", hash_generated_method = "90AFB3F5C0C202E2EBE51E2AC8605493")
        public boolean hasPremiumRate() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1042369972 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1042369972;
            // ---------- Original Method ----------
            //return hasPremiumRate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.612 -0400", hash_original_method = "14341C327DA8E1CAAD52FEB1F27BC133", hash_generated_method = "2BA7778C150B5A912B2D17AB53140C27")
        public PhoneNumberDesc getPremiumRate() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_567814744 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_567814744 = premiumRate_;
            varB4EAC82CA7396A68D541C85D26508E83_567814744.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_567814744;
            // ---------- Original Method ----------
            //return premiumRate_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.613 -0400", hash_original_method = "BC27E8EEE54A894FE20AA77CF35DD102", hash_generated_method = "7AE2698C0BFF3AFF186F8D729BB24730")
        public PhoneMetadata setPremiumRate(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_2124351613 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPremiumRate = true;
            premiumRate_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_2124351613 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2124351613.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2124351613;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPremiumRate = true;
            //premiumRate_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.613 -0400", hash_original_method = "3FC94E6C0EA4E13DD9DFC50367AE259A", hash_generated_method = "6AE06833DFADEB0549403880F500BAE2")
        public boolean hasSharedCost() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1347624251 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1347624251;
            // ---------- Original Method ----------
            //return hasSharedCost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.621 -0400", hash_original_method = "1FFB14D9D02DC30D3C5835101DD9BAF0", hash_generated_method = "0E73EBEDB04D8A51A659B470AE8F8A05")
        public PhoneNumberDesc getSharedCost() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1858120870 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1858120870 = sharedCost_;
            varB4EAC82CA7396A68D541C85D26508E83_1858120870.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1858120870;
            // ---------- Original Method ----------
            //return sharedCost_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.622 -0400", hash_original_method = "CDEC9E0DF29779C1B33ED334AA2CAB69", hash_generated_method = "5580DA66F8424E7ED8970B4B1A8D3BFC")
        public PhoneMetadata setSharedCost(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1508664261 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasSharedCost = true;
            sharedCost_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1508664261 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1508664261.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1508664261;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasSharedCost = true;
            //sharedCost_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.636 -0400", hash_original_method = "0212D7D16A2BAA9CCCFC0F72E5660C30", hash_generated_method = "B58D34975C81883BC229C7088988F969")
        public boolean hasPersonalNumber() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169272242 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169272242;
            // ---------- Original Method ----------
            //return hasPersonalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.637 -0400", hash_original_method = "4CF811D3746F6643A77AAC306D011902", hash_generated_method = "92375A5DCDA5CA3C9E70C788F4043B02")
        public PhoneNumberDesc getPersonalNumber() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1662733451 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1662733451 = personalNumber_;
            varB4EAC82CA7396A68D541C85D26508E83_1662733451.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1662733451;
            // ---------- Original Method ----------
            //return personalNumber_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.637 -0400", hash_original_method = "24493CAEB1946A8C79E7D00511D66307", hash_generated_method = "A75F2884CB8A3E0C44A930FA715E3133")
        public PhoneMetadata setPersonalNumber(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1944538949 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPersonalNumber = true;
            personalNumber_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1944538949 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1944538949.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1944538949;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPersonalNumber = true;
            //personalNumber_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.637 -0400", hash_original_method = "96BC6C0B8CEC8C19A5CCD809DD7C636B", hash_generated_method = "D6803836C10ACD59F35EDC8C9040CE9F")
        public boolean hasVoip() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71896456 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_71896456;
            // ---------- Original Method ----------
            //return hasVoip;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.638 -0400", hash_original_method = "3E7A9D2F706E69069EF64F75DD5323E7", hash_generated_method = "6F4558B3486E93529D7ECE52D3570F31")
        public PhoneNumberDesc getVoip() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_565502237 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_565502237 = voip_;
            varB4EAC82CA7396A68D541C85D26508E83_565502237.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_565502237;
            // ---------- Original Method ----------
            //return voip_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.648 -0400", hash_original_method = "5FE2D757C727FFFD1EC6F29B7720BADF", hash_generated_method = "ECF1EE1BA130B72F7789799D58BBBAC4")
        public PhoneMetadata setVoip(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1925619948 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasVoip = true;
            voip_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1925619948 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1925619948.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1925619948;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasVoip = true;
            //voip_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.649 -0400", hash_original_method = "ACFB2D18067CB4D678DA99A9B4C18C84", hash_generated_method = "80ED99A10510A65B9931584DFB5B1515")
        public boolean hasPager() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92013737 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_92013737;
            // ---------- Original Method ----------
            //return hasPager;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.649 -0400", hash_original_method = "C20F5AA8347238E1E9DA82F58997297F", hash_generated_method = "484EC9C175A30666869564E1EA38FCD2")
        public PhoneNumberDesc getPager() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1705333461 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1705333461 = pager_;
            varB4EAC82CA7396A68D541C85D26508E83_1705333461.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1705333461;
            // ---------- Original Method ----------
            //return pager_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.650 -0400", hash_original_method = "F7E7BD7CBC5C04503F79204D035D6093", hash_generated_method = "39DAF0B52E01DD4206EADB1FDD262E4C")
        public PhoneMetadata setPager(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1146729880 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPager = true;
            pager_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1146729880 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1146729880.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1146729880;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPager = true;
            //pager_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.650 -0400", hash_original_method = "7052BD1D22DD33A68E8BFBF8EF4C8D7C", hash_generated_method = "EE43295A230E643431BEF807B50076BE")
        public boolean hasUan() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1209293248 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1209293248;
            // ---------- Original Method ----------
            //return hasUan;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.651 -0400", hash_original_method = "6E5CDB2B0554F6EDEAFB0A826808F837", hash_generated_method = "10E1C19F2D0230BD475AA37A1ECB9F6E")
        public PhoneNumberDesc getUan() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_822166161 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_822166161 = uan_;
            varB4EAC82CA7396A68D541C85D26508E83_822166161.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_822166161;
            // ---------- Original Method ----------
            //return uan_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.651 -0400", hash_original_method = "645A0026A31D8D600D28A5F0E2FCB775", hash_generated_method = "1C22A2945895497BA708BEDB47C519B8")
        public PhoneMetadata setUan(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_943001289 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasUan = true;
            uan_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_943001289 = this;
            varB4EAC82CA7396A68D541C85D26508E83_943001289.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_943001289;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasUan = true;
            //uan_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.652 -0400", hash_original_method = "1D4CDC46AB20A45A27679F7FB2E14F5D", hash_generated_method = "96E1738EAAFCE5934DC0DA7BB660AFE5")
        public boolean hasNoInternationalDialling() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882000372 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_882000372;
            // ---------- Original Method ----------
            //return hasNoInternationalDialling;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.652 -0400", hash_original_method = "8BF24E7280AB555752CDF0AB6293C8C0", hash_generated_method = "5CC3F61C54C68F4CDA06DF1A425ABF22")
        public PhoneNumberDesc getNoInternationalDialling() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1086954126 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1086954126 = noInternationalDialling_;
            varB4EAC82CA7396A68D541C85D26508E83_1086954126.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1086954126;
            // ---------- Original Method ----------
            //return noInternationalDialling_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.652 -0400", hash_original_method = "7DCE821DB5B30DD48C6A3A37AA42A1FD", hash_generated_method = "B7C65478BA716FDFC5708606415434C7")
        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_865521870 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasNoInternationalDialling = true;
            noInternationalDialling_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_865521870 = this;
            varB4EAC82CA7396A68D541C85D26508E83_865521870.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_865521870;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasNoInternationalDialling = true;
            //noInternationalDialling_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.653 -0400", hash_original_method = "4B670822089DE57CBF3DD8C644F8C3E5", hash_generated_method = "7AFC08936F8ACB7210621AD7C4F9D8DF")
        public boolean hasId() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826561421 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_826561421;
            // ---------- Original Method ----------
            //return hasId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.667 -0400", hash_original_method = "C805C797DAF63B59CBD999295B2F5158", hash_generated_method = "20A572AB6A489821E6170176A47B852F")
        public String getId() {
            String varB4EAC82CA7396A68D541C85D26508E83_1668058144 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1668058144 = id_;
            varB4EAC82CA7396A68D541C85D26508E83_1668058144.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1668058144;
            // ---------- Original Method ----------
            //return id_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.668 -0400", hash_original_method = "6B3AD7A8DB5994F94639D3A9A0778D2B", hash_generated_method = "2101FFDFB8CEC3C579A1B5649FAE564B")
        public PhoneMetadata setId(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_885057965 = null; //Variable for return #1
            hasId = true;
            id_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_885057965 = this;
            varB4EAC82CA7396A68D541C85D26508E83_885057965.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_885057965;
            // ---------- Original Method ----------
            //hasId = true;
            //id_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.668 -0400", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "E4025A2AB1ACF513649108757A349089")
        public boolean hasCountryCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1222441922 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1222441922;
            // ---------- Original Method ----------
            //return hasCountryCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.669 -0400", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "F779D8A6B2820BDA2F2E2E0A1AEA4BF2")
        public int getCountryCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872195101 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872195101;
            // ---------- Original Method ----------
            //return countryCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.669 -0400", hash_original_method = "1AB7F6532DA188CC62A13C45F2B9ADF3", hash_generated_method = "0007432626CC03792C17D1DB51A0D204")
        public PhoneMetadata setCountryCode(int value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1478532482 = null; //Variable for return #1
            hasCountryCode = true;
            countryCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1478532482 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1478532482.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1478532482;
            // ---------- Original Method ----------
            //hasCountryCode = true;
            //countryCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.669 -0400", hash_original_method = "B89BF9592A7F16BE6654C3883F9898E5", hash_generated_method = "60A555C3365929F845EC2CA0B1C54523")
        public boolean hasInternationalPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923522945 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_923522945;
            // ---------- Original Method ----------
            //return hasInternationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.670 -0400", hash_original_method = "09123B0A33DF502700CE0BB29A84EB95", hash_generated_method = "4C99F9881DA339084ECFD0B2BDB7EBE6")
        public String getInternationalPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_1352915907 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1352915907 = internationalPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_1352915907.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1352915907;
            // ---------- Original Method ----------
            //return internationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.671 -0400", hash_original_method = "3DE0D2253FD6A81DEABED2BF406E5650", hash_generated_method = "37CE204621E234F5793671F757CE32F1")
        public PhoneMetadata setInternationalPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1714153206 = null; //Variable for return #1
            hasInternationalPrefix = true;
            internationalPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1714153206 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1714153206.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1714153206;
            // ---------- Original Method ----------
            //hasInternationalPrefix = true;
            //internationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.671 -0400", hash_original_method = "3A1D043D6BB606ABB758EEC975A83919", hash_generated_method = "4A3DCA6EDF867928FBF9074DC7D12A0D")
        public boolean hasPreferredInternationalPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194572891 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_194572891;
            // ---------- Original Method ----------
            //return hasPreferredInternationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.681 -0400", hash_original_method = "3992DDBA34CC5C49CFC74CF0545FF343", hash_generated_method = "767CD2CFFE179D46EFDE24EC24C62978")
        public String getPreferredInternationalPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_1194703050 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1194703050 = preferredInternationalPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_1194703050.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1194703050;
            // ---------- Original Method ----------
            //return preferredInternationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.694 -0400", hash_original_method = "2F2A95A6FC37FC6A654CD2ED9E105058", hash_generated_method = "2B5E03D523655D7DF9CC42E477D61007")
        public PhoneMetadata setPreferredInternationalPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_833706736 = null; //Variable for return #1
            hasPreferredInternationalPrefix = true;
            preferredInternationalPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_833706736 = this;
            varB4EAC82CA7396A68D541C85D26508E83_833706736.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_833706736;
            // ---------- Original Method ----------
            //hasPreferredInternationalPrefix = true;
            //preferredInternationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.694 -0400", hash_original_method = "3FEC8563D97FEF0C0B81201609B8C138", hash_generated_method = "97E09ED72E54EAF1C29A02F36D40FA8F")
        public boolean hasNationalPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436446346 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436446346;
            // ---------- Original Method ----------
            //return hasNationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.694 -0400", hash_original_method = "3F6DDEA7E91472B57F47F7AA42FF40A4", hash_generated_method = "AB4FDFC836B93B33846E1C4F3914727F")
        public String getNationalPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_1068481435 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1068481435 = nationalPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_1068481435.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1068481435;
            // ---------- Original Method ----------
            //return nationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.695 -0400", hash_original_method = "F24C638CA5CEB8CDF3416D52787AAB8D", hash_generated_method = "9C60E4DB520B70640A3D8FF993363575")
        public PhoneMetadata setNationalPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1699854656 = null; //Variable for return #1
            hasNationalPrefix = true;
            nationalPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1699854656 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1699854656.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1699854656;
            // ---------- Original Method ----------
            //hasNationalPrefix = true;
            //nationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.695 -0400", hash_original_method = "E23165194A0E40A98A75B1CB3195C323", hash_generated_method = "E93FB0862B9E25C2038A030E4E37A215")
        public boolean hasPreferredExtnPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1212588932 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1212588932;
            // ---------- Original Method ----------
            //return hasPreferredExtnPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.697 -0400", hash_original_method = "54C0428B3277F86E8CEE26D4467F5D32", hash_generated_method = "BF91D45C39A43B4697E5B19A13B00532")
        public String getPreferredExtnPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_1204165583 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1204165583 = preferredExtnPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_1204165583.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1204165583;
            // ---------- Original Method ----------
            //return preferredExtnPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.742 -0400", hash_original_method = "6AE031AAEF0021BEEE5C7C14D7E5ADEE", hash_generated_method = "DF8C77C0AD4FC85D001C855C2EAE913D")
        public PhoneMetadata setPreferredExtnPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1305907227 = null; //Variable for return #1
            hasPreferredExtnPrefix = true;
            preferredExtnPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1305907227 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1305907227.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1305907227;
            // ---------- Original Method ----------
            //hasPreferredExtnPrefix = true;
            //preferredExtnPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.742 -0400", hash_original_method = "079D2F6BDFB9C83E975C341D5D3984E8", hash_generated_method = "523027E3D5F5C89F702B6C217C5FA83A")
        public boolean hasNationalPrefixForParsing() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1612050714 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1612050714;
            // ---------- Original Method ----------
            //return hasNationalPrefixForParsing;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.743 -0400", hash_original_method = "049975D1EC97C98DFAFD92CBA7A3DB4E", hash_generated_method = "DE3D267132FDF88D52727D11B6FF7BF5")
        public String getNationalPrefixForParsing() {
            String varB4EAC82CA7396A68D541C85D26508E83_949792238 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_949792238 = nationalPrefixForParsing_;
            varB4EAC82CA7396A68D541C85D26508E83_949792238.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_949792238;
            // ---------- Original Method ----------
            //return nationalPrefixForParsing_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.743 -0400", hash_original_method = "9C0BD3F3F0877996BC57F1866741042E", hash_generated_method = "96C75C86AD82FE07AF43B170F3A46AB3")
        public PhoneMetadata setNationalPrefixForParsing(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_202385994 = null; //Variable for return #1
            hasNationalPrefixForParsing = true;
            nationalPrefixForParsing_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_202385994 = this;
            varB4EAC82CA7396A68D541C85D26508E83_202385994.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_202385994;
            // ---------- Original Method ----------
            //hasNationalPrefixForParsing = true;
            //nationalPrefixForParsing_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.743 -0400", hash_original_method = "1810BCBEB4974245D7BFFA09C69DD621", hash_generated_method = "A30D5E99C38705721656BEDD7659888D")
        public boolean hasNationalPrefixTransformRule() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1078277212 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1078277212;
            // ---------- Original Method ----------
            //return hasNationalPrefixTransformRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.744 -0400", hash_original_method = "55DE6447BA6383DE2B8CA08949083559", hash_generated_method = "87B05A3528A502D4CF9413B9F3109180")
        public String getNationalPrefixTransformRule() {
            String varB4EAC82CA7396A68D541C85D26508E83_1611008740 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1611008740 = nationalPrefixTransformRule_;
            varB4EAC82CA7396A68D541C85D26508E83_1611008740.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1611008740;
            // ---------- Original Method ----------
            //return nationalPrefixTransformRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.744 -0400", hash_original_method = "F0F297723C8F168223FB62622F5A1EB6", hash_generated_method = "705324FE12C535F49694A385E28B7238")
        public PhoneMetadata setNationalPrefixTransformRule(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_926682933 = null; //Variable for return #1
            hasNationalPrefixTransformRule = true;
            nationalPrefixTransformRule_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_926682933 = this;
            varB4EAC82CA7396A68D541C85D26508E83_926682933.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_926682933;
            // ---------- Original Method ----------
            //hasNationalPrefixTransformRule = true;
            //nationalPrefixTransformRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.745 -0400", hash_original_method = "23B7A16EBE621B68A999B8F98C32C7FC", hash_generated_method = "E5AB279482B3F73637504D99FC80B35E")
        public boolean hasSameMobileAndFixedLinePattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982595148 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982595148;
            // ---------- Original Method ----------
            //return hasSameMobileAndFixedLinePattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.745 -0400", hash_original_method = "0C8ED851B6AE0A07DB69452573173B34", hash_generated_method = "BC043A00023A94EE0934BC3817B8FFD5")
        public boolean isSameMobileAndFixedLinePattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1644865027 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1644865027;
            // ---------- Original Method ----------
            //return sameMobileAndFixedLinePattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.769 -0400", hash_original_method = "4899ADA62C5B2767C955044A6A730FDD", hash_generated_method = "640EFFB2AECCDFEEE5976F86EDFFC3DF")
        public PhoneMetadata setSameMobileAndFixedLinePattern(boolean value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_596427311 = null; //Variable for return #1
            hasSameMobileAndFixedLinePattern = true;
            sameMobileAndFixedLinePattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_596427311 = this;
            varB4EAC82CA7396A68D541C85D26508E83_596427311.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_596427311;
            // ---------- Original Method ----------
            //hasSameMobileAndFixedLinePattern = true;
            //sameMobileAndFixedLinePattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.771 -0400", hash_original_method = "84A1634AEDD3ABF2CF1A3014B5D415EB", hash_generated_method = "AB1A81228D848BF30A3FB1CBB721936A")
        public java.util.List<NumberFormat> numberFormats() {
            java.util.List<NumberFormat> varB4EAC82CA7396A68D541C85D26508E83_241385601 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_241385601 = numberFormat_;
            varB4EAC82CA7396A68D541C85D26508E83_241385601.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_241385601;
            // ---------- Original Method ----------
            //return numberFormat_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.772 -0400", hash_original_method = "926251D4CC15A970A4459B1AE98E21C5", hash_generated_method = "D9A3C7BB2C08F702F809311CBE1DF310")
        public int numberFormatSize() {
            int var96E94CB08F0191048A027A706C30A965_684144940 = (numberFormat_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065163841 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065163841;
            // ---------- Original Method ----------
            //return numberFormat_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.772 -0400", hash_original_method = "A540DB640DF9F8195853729D5B88BC06", hash_generated_method = "6FF50554965F52989F90E53BFEAB76FB")
        public NumberFormat getNumberFormat(int index) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1673089648 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1673089648 = numberFormat_.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1673089648.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1673089648;
            // ---------- Original Method ----------
            //return numberFormat_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.785 -0400", hash_original_method = "6431B417B09BF16DE184C0BF7BFD8C0A", hash_generated_method = "904A54BF9E6D2B25A972F6477458F1A0")
        public PhoneMetadata addNumberFormat(NumberFormat value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_281843940 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            numberFormat_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_281843940 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_281843940.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_281843940;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //numberFormat_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.785 -0400", hash_original_method = "AE158E1AC846181939D70DB177BF740E", hash_generated_method = "7585BC02E31DECDBF92C1F38AECB86A4")
        public java.util.List<NumberFormat> intlNumberFormats() {
            java.util.List<NumberFormat> varB4EAC82CA7396A68D541C85D26508E83_730532063 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_730532063 = intlNumberFormat_;
            varB4EAC82CA7396A68D541C85D26508E83_730532063.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_730532063;
            // ---------- Original Method ----------
            //return intlNumberFormat_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.786 -0400", hash_original_method = "58F2978D59C0EB64F45AEE8E7A3A3ECF", hash_generated_method = "81D3A314E223CF4275C778ECB060144B")
        public int intlNumberFormatSize() {
            int varF47E20D9CBB1855464C7D9F5EA17F55A_2060186971 = (intlNumberFormat_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288434391 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288434391;
            // ---------- Original Method ----------
            //return intlNumberFormat_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.786 -0400", hash_original_method = "14BAA3A4AA80C468A085BC9B63542EE0", hash_generated_method = "22F3DDA1FB0A62AF547E4E948027EF30")
        public NumberFormat getIntlNumberFormat(int index) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1192562879 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1192562879 = intlNumberFormat_.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1192562879.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1192562879;
            // ---------- Original Method ----------
            //return intlNumberFormat_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.787 -0400", hash_original_method = "DDE7F201B8001F4279DAEE9969BC3EF9", hash_generated_method = "1E0E3FA7D3ADE2CC918B8AF4267030EA")
        public PhoneMetadata addIntlNumberFormat(NumberFormat value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_281074270 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            intlNumberFormat_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_281074270 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_281074270.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_281074270;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //intlNumberFormat_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.795 -0400", hash_original_method = "C1C6B471737DB86E719E8005B048F8A4", hash_generated_method = "D2F72C7666F3A1CCA519197296E2EB2E")
        public PhoneMetadata clearIntlNumberFormat() {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1426848553 = null; //Variable for return #1
            intlNumberFormat_.clear();
            varB4EAC82CA7396A68D541C85D26508E83_1426848553 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1426848553.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1426848553;
            // ---------- Original Method ----------
            //intlNumberFormat_.clear();
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.795 -0400", hash_original_method = "F0A3F725FE27520DECCABEEE1451ABF4", hash_generated_method = "D32B97E83940AE4D56A75E200B515CB3")
        public boolean hasMainCountryForCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_22082269 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_22082269;
            // ---------- Original Method ----------
            //return hasMainCountryForCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.795 -0400", hash_original_method = "CF03E78162809AA6058F20CA8B82C717", hash_generated_method = "533191B980E72AA95CC1B0219306A409")
        public boolean isMainCountryForCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1964648533 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1964648533;
            // ---------- Original Method ----------
            //return mainCountryForCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.796 -0400", hash_original_method = "8B579A48BF103BAE8E5F2D34ABF5A62F", hash_generated_method = "3B90B28B1748B77F9E1915864254175D")
        public boolean getMainCountryForCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1083769913 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1083769913;
            // ---------- Original Method ----------
            //return mainCountryForCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.796 -0400", hash_original_method = "0E977089CAAEFAD04CCCDA9E72421381", hash_generated_method = "F89757F2BDB53E315B387FC771E7A83F")
        public PhoneMetadata setMainCountryForCode(boolean value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_752682686 = null; //Variable for return #1
            hasMainCountryForCode = true;
            mainCountryForCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_752682686 = this;
            varB4EAC82CA7396A68D541C85D26508E83_752682686.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_752682686;
            // ---------- Original Method ----------
            //hasMainCountryForCode = true;
            //mainCountryForCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.825 -0400", hash_original_method = "46DBCF13AB23890B1C354034C02AAE0D", hash_generated_method = "51172E84B9FDF68C6A7EA07AF491E2DF")
        public boolean hasLeadingDigits() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_391337962 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_391337962;
            // ---------- Original Method ----------
            //return hasLeadingDigits;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.825 -0400", hash_original_method = "BA0CBA2DFD34C6F845467DDF3F7503AD", hash_generated_method = "6EAFDDA26E8E8435E82796C513E55DE5")
        public String getLeadingDigits() {
            String varB4EAC82CA7396A68D541C85D26508E83_107125692 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_107125692 = leadingDigits_;
            varB4EAC82CA7396A68D541C85D26508E83_107125692.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_107125692;
            // ---------- Original Method ----------
            //return leadingDigits_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.825 -0400", hash_original_method = "1B8095B1499A1300CC7FD6395528DFB9", hash_generated_method = "42797754EABEEE68D38AE7926DEF7014")
        public PhoneMetadata setLeadingDigits(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1341463649 = null; //Variable for return #1
            hasLeadingDigits = true;
            leadingDigits_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1341463649 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1341463649.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1341463649;
            // ---------- Original Method ----------
            //hasLeadingDigits = true;
            //leadingDigits_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.826 -0400", hash_original_method = "DF6824D9CE520B4AB88B3980F12D84DC", hash_generated_method = "E96170CF0480B8089EBBD43078D8EA03")
        public boolean hasLeadingZeroPossible() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775185139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775185139;
            // ---------- Original Method ----------
            //return hasLeadingZeroPossible;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.826 -0400", hash_original_method = "9CE4681262676BB262003F306366B26D", hash_generated_method = "5B1684D2DFA3D226EE4071288F9BC180")
        public boolean isLeadingZeroPossible() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_702424674 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_702424674;
            // ---------- Original Method ----------
            //return leadingZeroPossible_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.827 -0400", hash_original_method = "4E51759A218DB37A00D6735D1891D88D", hash_generated_method = "C62AB02007EECD114132AC1195E20706")
        public PhoneMetadata setLeadingZeroPossible(boolean value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_212640585 = null; //Variable for return #1
            hasLeadingZeroPossible = true;
            leadingZeroPossible_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_212640585 = this;
            varB4EAC82CA7396A68D541C85D26508E83_212640585.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_212640585;
            // ---------- Original Method ----------
            //hasLeadingZeroPossible = true;
            //leadingZeroPossible_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.828 -0400", hash_original_method = "82C82662DE792F1D24D935E7D9A568AC", hash_generated_method = "4B4C11553F61CB049BA33753177F93B1")
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(hasGeneralDesc);
            {
                generalDesc_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasFixedLine);
            {
                fixedLine_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasMobile);
            {
                mobile_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasTollFree);
            {
                tollFree_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasPremiumRate);
            {
                premiumRate_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasSharedCost);
            {
                sharedCost_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasPersonalNumber);
            {
                personalNumber_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasVoip);
            {
                voip_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasPager);
            {
                pager_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasUan);
            {
                uan_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeBoolean(hasNoInternationalDialling);
            {
                noInternationalDialling_.writeExternal(objectOutput);
            } //End block
            objectOutput.writeUTF(id_);
            objectOutput.writeInt(countryCode_);
            objectOutput.writeUTF(internationalPrefix_);
            objectOutput.writeBoolean(hasPreferredInternationalPrefix);
            {
                objectOutput.writeUTF(preferredInternationalPrefix_);
            } //End block
            objectOutput.writeBoolean(hasNationalPrefix);
            {
                objectOutput.writeUTF(nationalPrefix_);
            } //End block
            objectOutput.writeBoolean(hasPreferredExtnPrefix);
            {
                objectOutput.writeUTF(preferredExtnPrefix_);
            } //End block
            objectOutput.writeBoolean(hasNationalPrefixForParsing);
            {
                objectOutput.writeUTF(nationalPrefixForParsing_);
            } //End block
            objectOutput.writeBoolean(hasNationalPrefixTransformRule);
            {
                objectOutput.writeUTF(nationalPrefixTransformRule_);
            } //End block
            objectOutput.writeBoolean(sameMobileAndFixedLinePattern_);
            int numberFormatSize;
            numberFormatSize = numberFormatSize();
            objectOutput.writeInt(numberFormatSize);
            {
                int i;
                i = 0;
                {
                    numberFormat_.get(i).writeExternal(objectOutput);
                } //End block
            } //End collapsed parenthetic
            int intlNumberFormatSize;
            intlNumberFormatSize = intlNumberFormatSize();
            objectOutput.writeInt(intlNumberFormatSize);
            {
                int i;
                i = 0;
                {
                    intlNumberFormat_.get(i).writeExternal(objectOutput);
                } //End block
            } //End collapsed parenthetic
            objectOutput.writeBoolean(mainCountryForCode_);
            objectOutput.writeBoolean(hasLeadingDigits);
            {
                objectOutput.writeUTF(leadingDigits_);
            } //End block
            objectOutput.writeBoolean(leadingZeroPossible_);
            addTaint(objectOutput.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.843 -0400", hash_original_method = "4D891D3CC56C8A4A25C2FA3B62E66106", hash_generated_method = "FFAB874FB59699E9BA9DAED22AD13B61")
        public void readExternal(ObjectInput objectInput) throws IOException {
            boolean hasDesc;
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setGeneralDesc(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setFixedLine(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setMobile(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setTollFree(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setPremiumRate(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setSharedCost(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setPersonalNumber(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setVoip(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setPager(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setUan(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc;
                desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setNoInternationalDialling(desc);
            } //End block
            setId(objectInput.readUTF());
            setCountryCode(objectInput.readInt());
            setInternationalPrefix(objectInput.readUTF());
            boolean hasString;
            hasString = objectInput.readBoolean();
            {
                setPreferredInternationalPrefix(objectInput.readUTF());
            } //End block
            hasString = objectInput.readBoolean();
            {
                setNationalPrefix(objectInput.readUTF());
            } //End block
            hasString = objectInput.readBoolean();
            {
                setPreferredExtnPrefix(objectInput.readUTF());
            } //End block
            hasString = objectInput.readBoolean();
            {
                setNationalPrefixForParsing(objectInput.readUTF());
            } //End block
            hasString = objectInput.readBoolean();
            {
                setNationalPrefixTransformRule(objectInput.readUTF());
            } //End block
            setSameMobileAndFixedLinePattern(objectInput.readBoolean());
            int nationalFormatSize;
            nationalFormatSize = objectInput.readInt();
            {
                int i;
                i = 0;
                {
                    NumberFormat numFormat;
                    numFormat = new NumberFormat();
                    numFormat.readExternal(objectInput);
                    numberFormat_.add(numFormat);
                } //End block
            } //End collapsed parenthetic
            int intlNumberFormatSize;
            intlNumberFormatSize = objectInput.readInt();
            {
                int i;
                i = 0;
                {
                    NumberFormat numFormat;
                    numFormat = new NumberFormat();
                    numFormat.readExternal(objectInput);
                    intlNumberFormat_.add(numFormat);
                } //End block
            } //End collapsed parenthetic
            setMainCountryForCode(objectInput.readBoolean());
            hasString = objectInput.readBoolean();
            {
                setLeadingDigits(objectInput.readUTF());
            } //End block
            setLeadingZeroPossible(objectInput.readBoolean());
            addTaint(objectInput.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public static final class Builder extends PhoneMetadata {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.843 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.844 -0400", hash_original_method = "FECA3DB69AA5738CC513C59EB359D04E", hash_generated_method = "5FE35F1FFEFA79F5EA66DA90F1F4F130")
            public PhoneMetadata build() {
                PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1311780820 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1311780820 = this;
                varB4EAC82CA7396A68D541C85D26508E83_1311780820.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1311780820;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.844 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "DF26AFCCBB9DDCFC72C78DA996786C5E")

        private static long serialVersionUID = 1;
    }


    
    public static class PhoneMetadataCollection implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.844 -0400", hash_original_field = "612BD1F5CEECC04CA1A32C585074C146", hash_generated_field = "3988CF3B3569C765826A81A610C2CFA8")

        private java.util.List<PhoneMetadata> metadata_ = new java.util.ArrayList<PhoneMetadata>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.845 -0400", hash_original_method = "833FEC11FB1A703522FFE165412E2F7D", hash_generated_method = "911AB4D46731349730F9522D952A81AB")
        public  PhoneMetadataCollection() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.846 -0400", hash_original_method = "C5ECD645F70FA9D5A2A9EB8CBA32ADEF", hash_generated_method = "A587EA2F2BF49B902953026314E51C96")
        public java.util.List<PhoneMetadata> getMetadataList() {
            java.util.List<PhoneMetadata> varB4EAC82CA7396A68D541C85D26508E83_338303263 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_338303263 = metadata_;
            varB4EAC82CA7396A68D541C85D26508E83_338303263.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_338303263;
            // ---------- Original Method ----------
            //return metadata_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.846 -0400", hash_original_method = "95419ED058599C84B2A0103C5C8B3F30", hash_generated_method = "77E0EF2B7DFEC0C91BC844AFC243521F")
        public int getMetadataCount() {
            int varE8225671ABD39B7016D6383C297CDF20_944187105 = (metadata_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715709634 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715709634;
            // ---------- Original Method ----------
            //return metadata_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.858 -0400", hash_original_method = "D57D52560347164C8871C87ACF1DAD2C", hash_generated_method = "5E61DF750F8B446CBA660244F2933A20")
        public PhoneMetadataCollection addMetadata(PhoneMetadata value) {
            PhoneMetadataCollection varB4EAC82CA7396A68D541C85D26508E83_424462427 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            metadata_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_424462427 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_424462427.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_424462427;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //metadata_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.858 -0400", hash_original_method = "BDFB00F39A05DC0D50872248169D293E", hash_generated_method = "8A22B371CAAC2734BD56545531F3D47B")
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            int size;
            size = getMetadataCount();
            objectOutput.writeInt(size);
            {
                int i;
                i = 0;
                {
                    metadata_.get(i).writeExternal(objectOutput);
                } //End block
            } //End collapsed parenthetic
            addTaint(objectOutput.getTaint());
            // ---------- Original Method ----------
            //int size = getMetadataCount();
            //objectOutput.writeInt(size);
            //for (int i = 0; i < size; i++) {
        //metadata_.get(i).writeExternal(objectOutput);
      //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.859 -0400", hash_original_method = "FAC331B8B6AD54634EE3CFAA3149ADF1", hash_generated_method = "31041E417F0CE63C3D8095D4561B120E")
        public void readExternal(ObjectInput objectInput) throws IOException {
            int size;
            size = objectInput.readInt();
            {
                int i;
                i = 0;
                {
                    PhoneMetadata metadata;
                    metadata = new PhoneMetadata();
                    metadata.readExternal(objectInput);
                    metadata_.add(metadata);
                } //End block
            } //End collapsed parenthetic
            addTaint(objectInput.getTaint());
            // ---------- Original Method ----------
            //int size = objectInput.readInt();
            //for (int i = 0; i < size; i++) {
        //PhoneMetadata metadata = new PhoneMetadata();
        //metadata.readExternal(objectInput);
        //metadata_.add(metadata);
      //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.859 -0400", hash_original_method = "1BB2E7D611D4F26F7F8136F4B2C1D585", hash_generated_method = "BF61CBB34E0DD98DBA132A5F807B9CE0")
        public PhoneMetadataCollection clear() {
            PhoneMetadataCollection varB4EAC82CA7396A68D541C85D26508E83_1047327536 = null; //Variable for return #1
            metadata_.clear();
            varB4EAC82CA7396A68D541C85D26508E83_1047327536 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1047327536.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1047327536;
            // ---------- Original Method ----------
            //metadata_.clear();
            //return this;
        }

        
        public static final class Builder extends PhoneMetadataCollection {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.859 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.860 -0400", hash_original_method = "62075F60ED3DD2393D61C900D272662C", hash_generated_method = "EE56B9461BFB9C98C8367FDD02F872B5")
            public PhoneMetadataCollection build() {
                PhoneMetadataCollection varB4EAC82CA7396A68D541C85D26508E83_1336092515 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1336092515 = this;
                varB4EAC82CA7396A68D541C85D26508E83_1336092515.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1336092515;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.860 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "DF26AFCCBB9DDCFC72C78DA996786C5E")

        private static long serialVersionUID = 1;
    }


    
}

