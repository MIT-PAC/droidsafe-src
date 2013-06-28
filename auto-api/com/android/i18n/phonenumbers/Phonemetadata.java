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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.385 -0400", hash_original_method = "AA2168146A79C42118444B1AF1D13430", hash_generated_method = "01D7B0EC1EB8E0CA70481AF327448A6E")
    private  Phonemetadata() {
        // ---------- Original Method ----------
    }

    
    public static class NumberFormat implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.385 -0400", hash_original_field = "EBB44F9DC35254EE54F96EB8D2936620", hash_generated_field = "BCFAB4E6509DB535E782A9A7638BF800")

        private boolean hasPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.385 -0400", hash_original_field = "7BA2602BE34151F7BF8709C5E6902A23", hash_generated_field = "A40119EC58A9ADBEEF7F74515C4824EB")

        private String pattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.385 -0400", hash_original_field = "FB3499637AAFAB74C9C7084B2A5F6485", hash_generated_field = "BB7D9B531AF497BD0CC6485A499825C4")

        private boolean hasFormat;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.385 -0400", hash_original_field = "E46CD8EF559BE4A57DCE6A0505568890", hash_generated_field = "331E3EC56817A5418D313A742EE6BAF6")

        private String format_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.385 -0400", hash_original_field = "2FC5ACB9349FF6307BF22B61065526C5", hash_generated_field = "8C6856D900C2B3217AAACE1CB04BBDC9")

        private java.util.List<String> leadingDigitsPattern_ = new java.util.ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.385 -0400", hash_original_field = "3BCF607E89F66B196F9AF26CAC995637", hash_generated_field = "92669F4414DE1997CD38BA06884F29EB")

        private boolean hasNationalPrefixFormattingRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.385 -0400", hash_original_field = "61056B131F75442BA186CE92F8481346", hash_generated_field = "B5917D98A0DF4DBF46F96EC8B9B42B54")

        private String nationalPrefixFormattingRule_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.385 -0400", hash_original_field = "FBF94AE436756F8EF0359BB5BCECE5A5", hash_generated_field = "1C2206B3A1E5D1FEEB3BC9386E1B8AEC")

        private boolean hasDomesticCarrierCodeFormattingRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.385 -0400", hash_original_field = "6FDFEB13B19DC6F980A9FF00FF64E797", hash_generated_field = "4E860583F8E21CB17BEAB512DD9874BA")

        private String domesticCarrierCodeFormattingRule_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.386 -0400", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "8FEBA1E1E8A6552B6917C667BFAE4E78")
        public  NumberFormat() {
            // ---------- Original Method ----------
        }

        
        public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.386 -0400", hash_original_method = "0246232EE6FB2A92C361AD6A40430F9A", hash_generated_method = "17ED5BBC59374E86BBAAD76BEADCF92A")
        public boolean hasPattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724077362 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_724077362;
            // ---------- Original Method ----------
            //return hasPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.387 -0400", hash_original_method = "42C6A53B1E4394F40C706B46BCE960D0", hash_generated_method = "C92455DBF057C43F6483D21B6AD73C0A")
        public String getPattern() {
            String varB4EAC82CA7396A68D541C85D26508E83_1366066185 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1366066185 = pattern_;
            varB4EAC82CA7396A68D541C85D26508E83_1366066185.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1366066185;
            // ---------- Original Method ----------
            //return pattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.389 -0400", hash_original_method = "ED9D042141B07F3A02D73E93DCCEE4F0", hash_generated_method = "14C82870BD1DF4E44C2AEE74805A2CB6")
        public NumberFormat setPattern(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_138468523 = null; //Variable for return #1
            hasPattern = true;
            pattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_138468523 = this;
            varB4EAC82CA7396A68D541C85D26508E83_138468523.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_138468523;
            // ---------- Original Method ----------
            //hasPattern = true;
            //pattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.390 -0400", hash_original_method = "68B5595866A3AC066C218CEE1670E78C", hash_generated_method = "07D405181B32ADD25BC9EA64249DB429")
        public boolean hasFormat() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1029426382 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1029426382;
            // ---------- Original Method ----------
            //return hasFormat;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.391 -0400", hash_original_method = "77809F0555E410001A5868E71E8924BD", hash_generated_method = "86B232040B9A06409F9CB52B5D2ABD02")
        public String getFormat() {
            String varB4EAC82CA7396A68D541C85D26508E83_1889369488 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1889369488 = format_;
            varB4EAC82CA7396A68D541C85D26508E83_1889369488.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1889369488;
            // ---------- Original Method ----------
            //return format_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.392 -0400", hash_original_method = "791160F9BB3B0A81AD0DFEC24C1732C9", hash_generated_method = "6305E7E0D7BA8B975EAA8A81F954FB15")
        public NumberFormat setFormat(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1509098038 = null; //Variable for return #1
            hasFormat = true;
            format_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1509098038 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1509098038.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1509098038;
            // ---------- Original Method ----------
            //hasFormat = true;
            //format_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.393 -0400", hash_original_method = "E6A52876E9E1328523A23CDD4ADD6081", hash_generated_method = "6166019B99BA98A00BAFAA9FB0887479")
        public java.util.List<String> leadingDigitPatterns() {
            java.util.List<String> varB4EAC82CA7396A68D541C85D26508E83_584328183 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_584328183 = leadingDigitsPattern_;
            varB4EAC82CA7396A68D541C85D26508E83_584328183.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_584328183;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.393 -0400", hash_original_method = "A7BC4264224DD72A69FEDA104C14570A", hash_generated_method = "7906ED5289156C904EB014108E2B32FA")
        public int leadingDigitsPatternSize() {
            int varB0FE41F8E6695F261080B3A10B142102_708634853 = (leadingDigitsPattern_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024742535 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024742535;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.393 -0400", hash_original_method = "F45A9318A15D3A63FB863C1586B0A383", hash_generated_method = "87358DF0DB0094EB700D0387FE8409FD")
        public String getLeadingDigitsPattern(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_2046711665 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2046711665 = leadingDigitsPattern_.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2046711665.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2046711665;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.394 -0400", hash_original_method = "67AADF10399513606F7245D93555CAB7", hash_generated_method = "E4251F9E215936B9516C70149EE1B4FD")
        public NumberFormat addLeadingDigitsPattern(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_2028523527 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            leadingDigitsPattern_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_2028523527 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2028523527.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2028523527;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //leadingDigitsPattern_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.394 -0400", hash_original_method = "A0F401EEBE63541205F643F348AC0373", hash_generated_method = "7D54B219585BC3DF1DFCF331B2C1137C")
        public boolean hasNationalPrefixFormattingRule() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1745914838 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1745914838;
            // ---------- Original Method ----------
            //return hasNationalPrefixFormattingRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.395 -0400", hash_original_method = "4B4C80C20D7D7C0D6F8A6AA39111D13B", hash_generated_method = "660FE8DA307EA205D3E202AB9ED10A9E")
        public String getNationalPrefixFormattingRule() {
            String varB4EAC82CA7396A68D541C85D26508E83_28555910 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_28555910 = nationalPrefixFormattingRule_;
            varB4EAC82CA7396A68D541C85D26508E83_28555910.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_28555910;
            // ---------- Original Method ----------
            //return nationalPrefixFormattingRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.396 -0400", hash_original_method = "6C67B9000B21FDC6ACFC6210DBD720A7", hash_generated_method = "9F03952B2C26E2D7AB94BD117D9DB104")
        public NumberFormat setNationalPrefixFormattingRule(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_535662094 = null; //Variable for return #1
            hasNationalPrefixFormattingRule = true;
            nationalPrefixFormattingRule_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_535662094 = this;
            varB4EAC82CA7396A68D541C85D26508E83_535662094.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_535662094;
            // ---------- Original Method ----------
            //hasNationalPrefixFormattingRule = true;
            //nationalPrefixFormattingRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.396 -0400", hash_original_method = "394C283EEDF7D9BA381FE6D7D2DD662E", hash_generated_method = "770F71F2CD1425AC07FDEDAB38E27ED6")
        public NumberFormat clearNationalPrefixFormattingRule() {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1695258528 = null; //Variable for return #1
            hasNationalPrefixFormattingRule = false;
            nationalPrefixFormattingRule_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_1695258528 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1695258528.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1695258528;
            // ---------- Original Method ----------
            //hasNationalPrefixFormattingRule = false;
            //nationalPrefixFormattingRule_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.397 -0400", hash_original_method = "1D512C574271A1305D1AF9A0CCC5C6D3", hash_generated_method = "BA50BA42F66C13081BCD874A861402C5")
        public boolean hasDomesticCarrierCodeFormattingRule() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68335809 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_68335809;
            // ---------- Original Method ----------
            //return hasDomesticCarrierCodeFormattingRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.397 -0400", hash_original_method = "1D78023CBBDF63A0A2ACC33925BD120F", hash_generated_method = "6EC85D9C0C58A7A603E408A8FEF3DA6B")
        public String getDomesticCarrierCodeFormattingRule() {
            String varB4EAC82CA7396A68D541C85D26508E83_934351509 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_934351509 = domesticCarrierCodeFormattingRule_;
            varB4EAC82CA7396A68D541C85D26508E83_934351509.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_934351509;
            // ---------- Original Method ----------
            //return domesticCarrierCodeFormattingRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.398 -0400", hash_original_method = "2168D8046E4A0ED39DDD19551FD64D5A", hash_generated_method = "B9A680DF7281933FFB1A07EF5722F67D")
        public NumberFormat setDomesticCarrierCodeFormattingRule(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_550870463 = null; //Variable for return #1
            hasDomesticCarrierCodeFormattingRule = true;
            domesticCarrierCodeFormattingRule_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_550870463 = this;
            varB4EAC82CA7396A68D541C85D26508E83_550870463.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_550870463;
            // ---------- Original Method ----------
            //hasDomesticCarrierCodeFormattingRule = true;
            //domesticCarrierCodeFormattingRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.401 -0400", hash_original_method = "DEB91FB350FEBE5DEE35AF7BFA950AEF", hash_generated_method = "3F5CDF2535F7C11D84D9938A6D6324AB")
        public NumberFormat mergeFrom(NumberFormat other) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1630110815 = null; //Variable for return #1
            {
                boolean varF081F818C9346840C1C05850A1E84836_170492226 = (other.hasPattern());
                {
                    setPattern(other.getPattern());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var3120A21678B49476E859E38D301D6C44_1250916236 = (other.hasFormat());
                {
                    setFormat(other.getFormat());
                } //End block
            } //End collapsed parenthetic
            int leadingDigitsPatternSize = other.leadingDigitsPatternSize();
            {
                int i = 0;
                {
                    addLeadingDigitsPattern(other.getLeadingDigitsPattern(i));
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDDD2CD16D3ACF0EDF8A5770CE9BF81DE_1560333425 = (other.hasNationalPrefixFormattingRule());
                {
                    setNationalPrefixFormattingRule(other.getNationalPrefixFormattingRule());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var41F6787BFF8421A70F22829D88E4C6F7_927519120 = (other.hasDomesticCarrierCodeFormattingRule());
                {
                    setDomesticCarrierCodeFormattingRule(other.getDomesticCarrierCodeFormattingRule());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1630110815 = this;
            addTaint(other.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1630110815.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1630110815;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.402 -0400", hash_original_method = "A100AA8318BC8064BB1FFCA8BFB04888", hash_generated_method = "D72B707F6C15B1BAE6C82CC0EC2871D3")
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeUTF(pattern_);
            objectOutput.writeUTF(format_);
            int leadingDigitsPatternSize = leadingDigitsPatternSize();
            objectOutput.writeInt(leadingDigitsPatternSize);
            {
                int i = 0;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.404 -0400", hash_original_method = "A5A163CCCC35630D5C707482125AAE27", hash_generated_method = "6AC37D8C987AF07865FA4B15D92C8311")
        public void readExternal(ObjectInput objectInput) throws IOException {
            setPattern(objectInput.readUTF());
            setFormat(objectInput.readUTF());
            int leadingDigitsPatternSize = objectInput.readInt();
            {
                int i = 0;
                {
                    leadingDigitsPattern_.add(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_259930675 = (objectInput.readBoolean());
                {
                    setNationalPrefixFormattingRule(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_1992175198 = (objectInput.readBoolean());
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.404 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.406 -0400", hash_original_method = "0B2E67344AC06F839A81A2533D186625", hash_generated_method = "CC5BF6093641C8724DC21897A107AAB0")
            public NumberFormat build() {
                NumberFormat varB4EAC82CA7396A68D541C85D26508E83_233764526 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_233764526 = this;
                varB4EAC82CA7396A68D541C85D26508E83_233764526.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_233764526;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.406 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
    public static class PhoneNumberDesc implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.406 -0400", hash_original_field = "DF8FA0961A72330EDFA83A06858DAA6D", hash_generated_field = "FE0D4AC450B46E7BA63C0A5FF14C51C2")

        private boolean hasNationalNumberPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.406 -0400", hash_original_field = "B9BBEC8ED347133624C9F13EC01959D6", hash_generated_field = "EEA13D95EC1A783CC3FD2A2EA5BF77DB")

        private String nationalNumberPattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.406 -0400", hash_original_field = "5128B6327ABA67ABA34F0D40555173E8", hash_generated_field = "A5D4C78E7537A35AEAFB80E70E1EF9CF")

        private boolean hasPossibleNumberPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.406 -0400", hash_original_field = "CE9BECD6E9AE72932A581A01A4BC72CF", hash_generated_field = "9740030449804334CD1D210C9AACA78D")

        private String possibleNumberPattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.406 -0400", hash_original_field = "2439321B7A9F025B302F5484BF5AA1CC", hash_generated_field = "A377FEAF080DA6EA07178B0BF7E01505")

        private boolean hasExampleNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.406 -0400", hash_original_field = "A267297FDB6460E899FB01789A537AEF", hash_generated_field = "D8EDB7AA5577953B265C1D4AEECCDF65")

        private String exampleNumber_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.407 -0400", hash_original_method = "7B50B3AE2E947514292047EE4CC3D0B3", hash_generated_method = "FF0F10C59E5A022C63A72AE504F6D672")
        public  PhoneNumberDesc() {
            // ---------- Original Method ----------
        }

        
        public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.407 -0400", hash_original_method = "7AE951C08CA66D0892FA0795F4703C0D", hash_generated_method = "B69CC76E204DB3D220090D21EC488BD9")
        public boolean hasNationalNumberPattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1572497610 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1572497610;
            // ---------- Original Method ----------
            //return hasNationalNumberPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.408 -0400", hash_original_method = "AE5307416A342E6E51B0D8AFEA64E005", hash_generated_method = "2DF513AB27E5609E2AB4B7349A4AACCE")
        public String getNationalNumberPattern() {
            String varB4EAC82CA7396A68D541C85D26508E83_1700888193 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1700888193 = nationalNumberPattern_;
            varB4EAC82CA7396A68D541C85D26508E83_1700888193.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1700888193;
            // ---------- Original Method ----------
            //return nationalNumberPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.409 -0400", hash_original_method = "5843589EEE5242B872EEFCA090E2182C", hash_generated_method = "4ECC11D2BC7C22B3FA7E30F96312DAD4")
        public PhoneNumberDesc setNationalNumberPattern(String value) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_167277073 = null; //Variable for return #1
            hasNationalNumberPattern = true;
            nationalNumberPattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_167277073 = this;
            varB4EAC82CA7396A68D541C85D26508E83_167277073.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_167277073;
            // ---------- Original Method ----------
            //hasNationalNumberPattern = true;
            //nationalNumberPattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.409 -0400", hash_original_method = "0D2D12A828079BB292F0B693EDB7AA61", hash_generated_method = "854D1EFB88D7A1BD295E85272FEFD66D")
        public boolean hasPossibleNumberPattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282814468 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282814468;
            // ---------- Original Method ----------
            //return hasPossibleNumberPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.410 -0400", hash_original_method = "69E173398B553B507060BBCC25879496", hash_generated_method = "3E9659E8AB4CF108724ED8F272247671")
        public String getPossibleNumberPattern() {
            String varB4EAC82CA7396A68D541C85D26508E83_1071523306 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1071523306 = possibleNumberPattern_;
            varB4EAC82CA7396A68D541C85D26508E83_1071523306.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1071523306;
            // ---------- Original Method ----------
            //return possibleNumberPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.411 -0400", hash_original_method = "E6F0FD7A3910EDF596B66C25C9FCACCB", hash_generated_method = "E04717E48F94DA048865BAEEE4905A5F")
        public PhoneNumberDesc setPossibleNumberPattern(String value) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_754868118 = null; //Variable for return #1
            hasPossibleNumberPattern = true;
            possibleNumberPattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_754868118 = this;
            varB4EAC82CA7396A68D541C85D26508E83_754868118.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_754868118;
            // ---------- Original Method ----------
            //hasPossibleNumberPattern = true;
            //possibleNumberPattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.411 -0400", hash_original_method = "9EA98547022BA9B31E373C0BBC90B4AD", hash_generated_method = "6A3C74538267B2D37B820E881672B951")
        public boolean hasExampleNumber() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259939662 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_259939662;
            // ---------- Original Method ----------
            //return hasExampleNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.412 -0400", hash_original_method = "4F2E88760366816D23F2792FF3D4D910", hash_generated_method = "9E1D096D7B9A613A8623AAAE5289D7B2")
        public String getExampleNumber() {
            String varB4EAC82CA7396A68D541C85D26508E83_1990430121 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1990430121 = exampleNumber_;
            varB4EAC82CA7396A68D541C85D26508E83_1990430121.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1990430121;
            // ---------- Original Method ----------
            //return exampleNumber_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.413 -0400", hash_original_method = "99D22C86FFDC5E436BCE118592FFD464", hash_generated_method = "DF1D4B7E8FB79004EB2C293243EEB15E")
        public PhoneNumberDesc setExampleNumber(String value) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_315125873 = null; //Variable for return #1
            hasExampleNumber = true;
            exampleNumber_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_315125873 = this;
            varB4EAC82CA7396A68D541C85D26508E83_315125873.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_315125873;
            // ---------- Original Method ----------
            //hasExampleNumber = true;
            //exampleNumber_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.414 -0400", hash_original_method = "13E9D2F0445C754E67764A18611FF669", hash_generated_method = "0EC762D6916117B6656D3EBB9067B0A0")
        public PhoneNumberDesc mergeFrom(PhoneNumberDesc other) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_608230585 = null; //Variable for return #1
            {
                boolean varD58E2A0E1D953219659F1147E75D73F4_378578330 = (other.hasNationalNumberPattern());
                {
                    setNationalNumberPattern(other.getNationalNumberPattern());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varC6F51288774EBF45A3EF2B68674CCC4F_2125879717 = (other.hasPossibleNumberPattern());
                {
                    setPossibleNumberPattern(other.getPossibleNumberPattern());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var63E297A85C8F39AFE7F8C657D805A65F_591156899 = (other.hasExampleNumber());
                {
                    setExampleNumber(other.getExampleNumber());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_608230585 = this;
            addTaint(other.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_608230585.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_608230585;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.414 -0400", hash_original_method = "67972576318010D4A6F8FC5204742584", hash_generated_method = "EA00584092840B0F18F70360DB4CB6A7")
        public boolean exactlySameAs(PhoneNumberDesc other) {
            boolean var6367AA144C0559F2B90F3AB658EAE0FD_947969768 = (nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          exampleNumber_.equals(other.exampleNumber_));
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522549774 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_522549774;
            // ---------- Original Method ----------
            //return nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          //possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          //exampleNumber_.equals(other.exampleNumber_);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.414 -0400", hash_original_method = "A248C31238E31950C31B42AEACDEB8E6", hash_generated_method = "107091F0B9E8823957DC97ED30F00CA8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.415 -0400", hash_original_method = "27FB9E0837C2CDBADF688660FFE7A75C", hash_generated_method = "4D45C8374037B92914C5C82AEF15812A")
        public void readExternal(ObjectInput objectInput) throws IOException {
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_733791904 = (objectInput.readBoolean());
                {
                    setNationalNumberPattern(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_1303606353 = (objectInput.readBoolean());
                {
                    setPossibleNumberPattern(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_1566114331 = (objectInput.readBoolean());
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.415 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.415 -0400", hash_original_method = "27A166D755957BD27B60D63CE4983A6A", hash_generated_method = "3480A04395FBF0D786671459940EB0FA")
            public PhoneNumberDesc build() {
                PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1844962952 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1844962952 = this;
                varB4EAC82CA7396A68D541C85D26508E83_1844962952.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1844962952;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.415 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
    public static class PhoneMetadata implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "B1185F70DC285179A2028122A1753D38", hash_generated_field = "A3B9F71CE88284DA159E437E743AF585")

        private boolean hasGeneralDesc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "419108228A3D4DD7D84FDBBA426B692E", hash_generated_field = "7468C9C864A0465318B0CE4D7F53C201")

        private PhoneNumberDesc generalDesc_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "E592D649F417667F2723D6FFED6E2DB7", hash_generated_field = "E05C42AA9F7E3C173F9E6FFB96993C10")

        private boolean hasFixedLine;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "7D61EBE9F230AE4F535BB262D140087E", hash_generated_field = "6B2D29317DA7FDD4358F05B6ED70E817")

        private PhoneNumberDesc fixedLine_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "8624D101BA06AC461F2198E30D1F6A12", hash_generated_field = "6732DA5D8F7E44D3EB8E9B3B04D2C208")

        private boolean hasMobile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "9A3666ECDC25598E8B1F39C149B5248B", hash_generated_field = "B09F10BC9C29A32513C7F9D45C9DD65D")

        private PhoneNumberDesc mobile_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "75EB0178779C5B94A142C67A8A3A0895", hash_generated_field = "80FAAA0975BF29FCB14D951C0BEDC5C4")

        private boolean hasTollFree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "8A684838F9710DEC6492C65DEB5B5A0F", hash_generated_field = "80CDA2C3C5F8E5226552943E5B5D1962")

        private PhoneNumberDesc tollFree_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "6401DBC84CDD207E60C202A21F935454", hash_generated_field = "5A30F5E3B7119D5842288ABCFFE97498")

        private boolean hasPremiumRate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "A525D6594473341CA8B89D37798B312E", hash_generated_field = "A45FECABBF74FB7321F9023E44E33237")

        private PhoneNumberDesc premiumRate_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "B64C7B1A99130C1E792DC2EC767D9EFB", hash_generated_field = "E49185F054F9F704C5600406F67DCB84")

        private boolean hasSharedCost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "1E9F4723F699DE8125552E21FFBFE400", hash_generated_field = "F1E7A155AA2DB5B0B5B95BFB0CEE31C9")

        private PhoneNumberDesc sharedCost_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "C6671814FF918E89A75FE4D83E386A68", hash_generated_field = "EDA3B33207D61D6AC565FA093ADCC196")

        private boolean hasPersonalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "1CFAD4514D14064196C72BF65F9CF559", hash_generated_field = "9BEB6F47AE29097500633D2F6F699031")

        private PhoneNumberDesc personalNumber_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "6993F15A6272097A69996233948D6788", hash_generated_field = "389614404066D2EFA2E54C2350D94AD0")

        private boolean hasVoip;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "4F48640F12EB1E254E7007633AE6A4BB", hash_generated_field = "EFA41A681D6E8CCFBC92A6D814B85301")

        private PhoneNumberDesc voip_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "F4712A7EC85B48169BE6F130B09401AF", hash_generated_field = "AA932FC09168FC29B0E1BDD3089132CB")

        private boolean hasPager;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "B53FED5DFF5974BE7B138F1CA58A1B36", hash_generated_field = "6DF80094481DB5FAFFA343EECB46293A")

        private PhoneNumberDesc pager_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "1C045935E1F5FA0A1792848701C607B3", hash_generated_field = "8F81ABDD16142E28D9E5984C6F740238")

        private boolean hasUan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "8579B62499AB55F965AD299835FB973C", hash_generated_field = "AD69C3410F5AE892799A6AC7CB2532E2")

        private PhoneNumberDesc uan_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "DA4DF0660D0FEED67B00F588F241E7EB", hash_generated_field = "0ADF693E546C325541D053D46F07CA67")

        private boolean hasNoInternationalDialling;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "460049B379C4B8AF431BAEE1EBCBF02E", hash_generated_field = "DB4742972A73F31DE788D6B88EE269C4")

        private PhoneNumberDesc noInternationalDialling_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "B00599996521998233C824ACCAB0E15F", hash_generated_field = "0140279EBB974905A38C47A7722FAFF6")

        private boolean hasId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "09E215DDF102AD5C73EE5F65A3C0CAB9", hash_generated_field = "A3944B7884E3A988EBAE9C53EFFAD5F5")

        private String id_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "8DA9382CFAB6A2934FA5AD3C46617F89", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

        private boolean hasCountryCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "3461D01D5A7F32E3FA9B229113397711", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

        private int countryCode_ = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "71E29C99125BF827B3C5BF568381086E", hash_generated_field = "5FC44BC01719FCF066ECC548BE8A5361")

        private boolean hasInternationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "E282158924B697D8BC6CAAE1BC57B7AB", hash_generated_field = "717A913C833941AC2C547FE2DFF1FB22")

        private String internationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "3ECE55B44C31E2628C42F70CE9639621", hash_generated_field = "A9895E937CD8DAE0C496DBC48D2C2CEE")

        private boolean hasPreferredInternationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "FCD8C7D7DFF78E7FA4B7EEE488EB6AC0", hash_generated_field = "CDC303EF35375A2E1F5FC52FA30A0AEF")

        private String preferredInternationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "4470362D119F8595D8A4313EC3BBE684", hash_generated_field = "7558F68656CC64EE957040556631A4B3")

        private boolean hasNationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "7FFC07608A27C8D4C3337E4B3E617A97", hash_generated_field = "9FD4079672B074B1C28FCBD5211F0E6E")

        private String nationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "CE3736A3B3D1072084220B70CD4D0A4F", hash_generated_field = "D4784FA8A81183D66211EA3CB7EAD63D")

        private boolean hasPreferredExtnPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "3BFE67D70B206F596FE6BB87EA4FC2EE", hash_generated_field = "F27B632A949D8FCEF65E426D0FEC59C2")

        private String preferredExtnPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "178A91AD8C9D4B311CBB7E9799C204D6", hash_generated_field = "507A8081AF30D85EF13F20C27737EE29")

        private boolean hasNationalPrefixForParsing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "5CE340B02A46FE9107F9780901340CAC", hash_generated_field = "46A092752488BEB0567E42ECBB5103EA")

        private String nationalPrefixForParsing_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "037AAC783F91D571F6E54112E2703ECE", hash_generated_field = "B59E7752C84471B249DCD9F9C398AFC5")

        private boolean hasNationalPrefixTransformRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "E828C84B52178E6A7F8B07EA0784D668", hash_generated_field = "08067D30B404B72AEBA1F2484BFD694C")

        private String nationalPrefixTransformRule_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "5E31C2CEC062E7B8113B945A2F2AA0E9", hash_generated_field = "31870DDEA4297A7CAB4D169E31FFFEBE")

        private boolean hasSameMobileAndFixedLinePattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "E4C862F971A24839C23EBE9F978A48B6", hash_generated_field = "789005A5E2E7FE7FCA1F46FB6F3F7B13")

        private boolean sameMobileAndFixedLinePattern_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "181C76BA224D14DBE65B8E0F96308942", hash_generated_field = "B800AB6258E8C26EC659EA232E613974")

        private java.util.List<NumberFormat> numberFormat_ = new java.util.ArrayList<NumberFormat>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.416 -0400", hash_original_field = "38053CEBD2D283DF20A1B56D88B2FD5C", hash_generated_field = "8438C32E42D261618BF3822D8254B874")

        private java.util.List<NumberFormat> intlNumberFormat_ = new java.util.ArrayList<NumberFormat>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.417 -0400", hash_original_field = "08D2B80646091F0A5CABE08AE2346FDA", hash_generated_field = "30F748667FFCDF08F79F81730072A8E1")

        private boolean hasMainCountryForCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.417 -0400", hash_original_field = "939EF08D7E9438FD155F13C644263B24", hash_generated_field = "7BE3C4CE079A909FDB8BCA00D97F89BF")

        private boolean mainCountryForCode_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.417 -0400", hash_original_field = "17079C6943CC232663CE7B61C9E492DB", hash_generated_field = "AE9DE5751CA76FAC5FD0690889290B59")

        private boolean hasLeadingDigits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.417 -0400", hash_original_field = "E5D90B3FC23E47C17AFA7132318C4380", hash_generated_field = "A2DF202A3B5F3D62339A3B2DE2A4FAB2")

        private String leadingDigits_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.417 -0400", hash_original_field = "352F42E9E2F51AB889A7ACC99B15F496", hash_generated_field = "4AEC48A66912462BA0FE869D7DC85F43")

        private boolean hasLeadingZeroPossible;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.417 -0400", hash_original_field = "87145D95F10EE570BBC9AFAE6F259808", hash_generated_field = "F45DAF5712BFBE9A35415A4D733DC0FC")

        private boolean leadingZeroPossible_ = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.417 -0400", hash_original_method = "8411C48F959C93D1C6435DDA5C4FFBF8", hash_generated_method = "246EB5CC112F2B1B6402C47CB846FD5D")
        public  PhoneMetadata() {
            // ---------- Original Method ----------
        }

        
        public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.417 -0400", hash_original_method = "573E786E141FAAA03A367F49BCA559B5", hash_generated_method = "44EEBCE8B8347A6DC140DCA69E4B9DD2")
        public boolean hasGeneralDesc() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261851492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_261851492;
            // ---------- Original Method ----------
            //return hasGeneralDesc;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.417 -0400", hash_original_method = "F96C4A1868C09190E3C941F03A2889CB", hash_generated_method = "3AA1F51E38FB768C2998E85457CD18A5")
        public PhoneNumberDesc getGeneralDesc() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_997481454 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_997481454 = generalDesc_;
            varB4EAC82CA7396A68D541C85D26508E83_997481454.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_997481454;
            // ---------- Original Method ----------
            //return generalDesc_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.418 -0400", hash_original_method = "97D824F311B5130867761544B2540B90", hash_generated_method = "1643705EC34BE9819D7EA525A4877F11")
        public PhoneMetadata setGeneralDesc(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_502305023 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasGeneralDesc = true;
            generalDesc_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_502305023 = this;
            varB4EAC82CA7396A68D541C85D26508E83_502305023.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_502305023;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasGeneralDesc = true;
            //generalDesc_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.418 -0400", hash_original_method = "0B06F02C38AE7EA6E1205EAD00F0F3D7", hash_generated_method = "604CA98E6EE9E2B129D07B91E97D17B3")
        public boolean hasFixedLine() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_492481922 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_492481922;
            // ---------- Original Method ----------
            //return hasFixedLine;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.418 -0400", hash_original_method = "7111E9DB2C9B99769226207CB0B39C0D", hash_generated_method = "653D928C79F3B72A44A2ED45DC6F23CE")
        public PhoneNumberDesc getFixedLine() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_179979078 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_179979078 = fixedLine_;
            varB4EAC82CA7396A68D541C85D26508E83_179979078.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_179979078;
            // ---------- Original Method ----------
            //return fixedLine_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.419 -0400", hash_original_method = "4E0B7145906BC721C9DE8D0C32500FC9", hash_generated_method = "FA6112324C729ACD495B405544AFE35F")
        public PhoneMetadata setFixedLine(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1478937540 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasFixedLine = true;
            fixedLine_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1478937540 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1478937540.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1478937540;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasFixedLine = true;
            //fixedLine_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.419 -0400", hash_original_method = "F5A454F163C8198EDADB6A0267665530", hash_generated_method = "5EF6A2E092B12A5954F9C55FC8E388A9")
        public boolean hasMobile() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_336101723 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_336101723;
            // ---------- Original Method ----------
            //return hasMobile;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.419 -0400", hash_original_method = "469BFC723D37FABFB9BC30DE50B7B80A", hash_generated_method = "72E1B8DADFB3EBA5C75293CE76671B25")
        public PhoneNumberDesc getMobile() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_662699965 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_662699965 = mobile_;
            varB4EAC82CA7396A68D541C85D26508E83_662699965.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_662699965;
            // ---------- Original Method ----------
            //return mobile_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.419 -0400", hash_original_method = "CF0A4860566840BE9C27E4474979A50E", hash_generated_method = "E69E37A5956DB66EA73DAA3204156A41")
        public PhoneMetadata setMobile(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_126979106 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasMobile = true;
            mobile_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_126979106 = this;
            varB4EAC82CA7396A68D541C85D26508E83_126979106.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_126979106;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasMobile = true;
            //mobile_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.420 -0400", hash_original_method = "C6BB80AB6E7BD893E9D8810967101490", hash_generated_method = "D7AE693D5AC62F1B35FE39DDEC1EDA60")
        public boolean hasTollFree() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955575154 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955575154;
            // ---------- Original Method ----------
            //return hasTollFree;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.420 -0400", hash_original_method = "A25CEA98E2A744A76CD23B6ECE21AB56", hash_generated_method = "0AD2D85F891DE39F624381109E74594F")
        public PhoneNumberDesc getTollFree() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1259235494 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1259235494 = tollFree_;
            varB4EAC82CA7396A68D541C85D26508E83_1259235494.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1259235494;
            // ---------- Original Method ----------
            //return tollFree_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.420 -0400", hash_original_method = "46A649F605F0EC24C76169E259456A93", hash_generated_method = "E46FB953D585ACBB90E0F68A54E3A2B7")
        public PhoneMetadata setTollFree(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1742080588 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasTollFree = true;
            tollFree_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1742080588 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1742080588.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1742080588;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasTollFree = true;
            //tollFree_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.420 -0400", hash_original_method = "82079540736B40B455CF317890B4623A", hash_generated_method = "823B1E46E4C4128CCB05A4010DC2612E")
        public boolean hasPremiumRate() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_329174690 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_329174690;
            // ---------- Original Method ----------
            //return hasPremiumRate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.421 -0400", hash_original_method = "14341C327DA8E1CAAD52FEB1F27BC133", hash_generated_method = "23AD0FEEF196726F03F590DF059DDEFC")
        public PhoneNumberDesc getPremiumRate() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_55487242 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_55487242 = premiumRate_;
            varB4EAC82CA7396A68D541C85D26508E83_55487242.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_55487242;
            // ---------- Original Method ----------
            //return premiumRate_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.421 -0400", hash_original_method = "BC27E8EEE54A894FE20AA77CF35DD102", hash_generated_method = "DF980FD99F8283900DA536FC46A1D914")
        public PhoneMetadata setPremiumRate(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1524407382 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPremiumRate = true;
            premiumRate_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1524407382 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1524407382.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1524407382;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPremiumRate = true;
            //premiumRate_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.421 -0400", hash_original_method = "3FC94E6C0EA4E13DD9DFC50367AE259A", hash_generated_method = "5567A46F87CFE51017144C0A2A3D2B00")
        public boolean hasSharedCost() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788650411 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788650411;
            // ---------- Original Method ----------
            //return hasSharedCost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.422 -0400", hash_original_method = "1FFB14D9D02DC30D3C5835101DD9BAF0", hash_generated_method = "00AA0B06C93A493E248529CB7F4ECC09")
        public PhoneNumberDesc getSharedCost() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1948844625 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1948844625 = sharedCost_;
            varB4EAC82CA7396A68D541C85D26508E83_1948844625.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1948844625;
            // ---------- Original Method ----------
            //return sharedCost_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.422 -0400", hash_original_method = "CDEC9E0DF29779C1B33ED334AA2CAB69", hash_generated_method = "BC96BC45734D30D5CE466516281A6EC1")
        public PhoneMetadata setSharedCost(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1527770778 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasSharedCost = true;
            sharedCost_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1527770778 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1527770778.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1527770778;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasSharedCost = true;
            //sharedCost_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.423 -0400", hash_original_method = "0212D7D16A2BAA9CCCFC0F72E5660C30", hash_generated_method = "4D5E357A143F24A09A79821BF2FE09A4")
        public boolean hasPersonalNumber() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_847358214 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_847358214;
            // ---------- Original Method ----------
            //return hasPersonalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.423 -0400", hash_original_method = "4CF811D3746F6643A77AAC306D011902", hash_generated_method = "33E7C8F35BF16D2E695C54C7BA1382A3")
        public PhoneNumberDesc getPersonalNumber() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_70183618 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_70183618 = personalNumber_;
            varB4EAC82CA7396A68D541C85D26508E83_70183618.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_70183618;
            // ---------- Original Method ----------
            //return personalNumber_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.424 -0400", hash_original_method = "24493CAEB1946A8C79E7D00511D66307", hash_generated_method = "F1E50E2A796F3A30CAC98A38D47C7600")
        public PhoneMetadata setPersonalNumber(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1851913378 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPersonalNumber = true;
            personalNumber_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1851913378 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1851913378.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1851913378;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPersonalNumber = true;
            //personalNumber_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.424 -0400", hash_original_method = "96BC6C0B8CEC8C19A5CCD809DD7C636B", hash_generated_method = "44CF31CD55360A3A24DB4BE34C93A44A")
        public boolean hasVoip() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515178593 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515178593;
            // ---------- Original Method ----------
            //return hasVoip;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.424 -0400", hash_original_method = "3E7A9D2F706E69069EF64F75DD5323E7", hash_generated_method = "12417B8BD83000ADC0251F6750943AFA")
        public PhoneNumberDesc getVoip() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_738263726 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_738263726 = voip_;
            varB4EAC82CA7396A68D541C85D26508E83_738263726.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_738263726;
            // ---------- Original Method ----------
            //return voip_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.425 -0400", hash_original_method = "5FE2D757C727FFFD1EC6F29B7720BADF", hash_generated_method = "98090AE5B1FD8803B94195D04F58669A")
        public PhoneMetadata setVoip(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1207940176 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasVoip = true;
            voip_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1207940176 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1207940176.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1207940176;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasVoip = true;
            //voip_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.425 -0400", hash_original_method = "ACFB2D18067CB4D678DA99A9B4C18C84", hash_generated_method = "325E36DDCB0871570089E634190CBF9D")
        public boolean hasPager() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040505999 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040505999;
            // ---------- Original Method ----------
            //return hasPager;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.426 -0400", hash_original_method = "C20F5AA8347238E1E9DA82F58997297F", hash_generated_method = "87CC299AE8501639040491540A59DC2E")
        public PhoneNumberDesc getPager() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_236509584 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_236509584 = pager_;
            varB4EAC82CA7396A68D541C85D26508E83_236509584.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_236509584;
            // ---------- Original Method ----------
            //return pager_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.426 -0400", hash_original_method = "F7E7BD7CBC5C04503F79204D035D6093", hash_generated_method = "E4D8EABA4792298431CDCDDE2B6B72C9")
        public PhoneMetadata setPager(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1090937093 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPager = true;
            pager_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1090937093 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1090937093.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1090937093;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPager = true;
            //pager_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.427 -0400", hash_original_method = "7052BD1D22DD33A68E8BFBF8EF4C8D7C", hash_generated_method = "0739A620AA0446D210FBE13A45FD0B7F")
        public boolean hasUan() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918874681 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918874681;
            // ---------- Original Method ----------
            //return hasUan;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.427 -0400", hash_original_method = "6E5CDB2B0554F6EDEAFB0A826808F837", hash_generated_method = "90060ACA56702B601EA7A0DF6F9B047A")
        public PhoneNumberDesc getUan() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_153574705 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_153574705 = uan_;
            varB4EAC82CA7396A68D541C85D26508E83_153574705.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_153574705;
            // ---------- Original Method ----------
            //return uan_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.430 -0400", hash_original_method = "645A0026A31D8D600D28A5F0E2FCB775", hash_generated_method = "9F53381AC950FC5332F21486F1C912AC")
        public PhoneMetadata setUan(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1725009118 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasUan = true;
            uan_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1725009118 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1725009118.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1725009118;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasUan = true;
            //uan_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.431 -0400", hash_original_method = "1D4CDC46AB20A45A27679F7FB2E14F5D", hash_generated_method = "3FCC7B741DB33453AF7FF58B8FF13DBF")
        public boolean hasNoInternationalDialling() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_324851993 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_324851993;
            // ---------- Original Method ----------
            //return hasNoInternationalDialling;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.433 -0400", hash_original_method = "8BF24E7280AB555752CDF0AB6293C8C0", hash_generated_method = "C7A62191F5AF77B6682E93E4A2D910ED")
        public PhoneNumberDesc getNoInternationalDialling() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_909125740 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_909125740 = noInternationalDialling_;
            varB4EAC82CA7396A68D541C85D26508E83_909125740.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_909125740;
            // ---------- Original Method ----------
            //return noInternationalDialling_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.435 -0400", hash_original_method = "7DCE821DB5B30DD48C6A3A37AA42A1FD", hash_generated_method = "E6329D7AF108B44E7CE8C67F38385F99")
        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1011422093 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasNoInternationalDialling = true;
            noInternationalDialling_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1011422093 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1011422093.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1011422093;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasNoInternationalDialling = true;
            //noInternationalDialling_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.435 -0400", hash_original_method = "4B670822089DE57CBF3DD8C644F8C3E5", hash_generated_method = "C40E00DA30AE6F3206871D77FDF82018")
        public boolean hasId() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_761666696 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_761666696;
            // ---------- Original Method ----------
            //return hasId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.436 -0400", hash_original_method = "C805C797DAF63B59CBD999295B2F5158", hash_generated_method = "8CBB470A27BE7E7DE27F6DEF2AAA9E86")
        public String getId() {
            String varB4EAC82CA7396A68D541C85D26508E83_849086017 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_849086017 = id_;
            varB4EAC82CA7396A68D541C85D26508E83_849086017.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_849086017;
            // ---------- Original Method ----------
            //return id_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.437 -0400", hash_original_method = "6B3AD7A8DB5994F94639D3A9A0778D2B", hash_generated_method = "42B7C9D5EF0FDD1F2F74A92018C07D4B")
        public PhoneMetadata setId(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_977976414 = null; //Variable for return #1
            hasId = true;
            id_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_977976414 = this;
            varB4EAC82CA7396A68D541C85D26508E83_977976414.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_977976414;
            // ---------- Original Method ----------
            //hasId = true;
            //id_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.437 -0400", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "6CC0F1ADCDF6644A0F492036003FD028")
        public boolean hasCountryCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951069835 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951069835;
            // ---------- Original Method ----------
            //return hasCountryCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.438 -0400", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "9B82E88580E38C8F2D35227B8FEC07A8")
        public int getCountryCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372663677 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372663677;
            // ---------- Original Method ----------
            //return countryCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.439 -0400", hash_original_method = "1AB7F6532DA188CC62A13C45F2B9ADF3", hash_generated_method = "3E9448DE977DA78B20264E78DED613FA")
        public PhoneMetadata setCountryCode(int value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1501502542 = null; //Variable for return #1
            hasCountryCode = true;
            countryCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1501502542 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1501502542.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1501502542;
            // ---------- Original Method ----------
            //hasCountryCode = true;
            //countryCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.440 -0400", hash_original_method = "B89BF9592A7F16BE6654C3883F9898E5", hash_generated_method = "41742B7A89FE5D2311B4DD8136DC566B")
        public boolean hasInternationalPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190139702 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_190139702;
            // ---------- Original Method ----------
            //return hasInternationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.442 -0400", hash_original_method = "09123B0A33DF502700CE0BB29A84EB95", hash_generated_method = "A8E686E2F0D73D48660A99A2CE084708")
        public String getInternationalPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_1377855678 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1377855678 = internationalPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_1377855678.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1377855678;
            // ---------- Original Method ----------
            //return internationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.443 -0400", hash_original_method = "3DE0D2253FD6A81DEABED2BF406E5650", hash_generated_method = "30945E7CA4BD7729118D16FE3D255F82")
        public PhoneMetadata setInternationalPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1184489547 = null; //Variable for return #1
            hasInternationalPrefix = true;
            internationalPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1184489547 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1184489547.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1184489547;
            // ---------- Original Method ----------
            //hasInternationalPrefix = true;
            //internationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.443 -0400", hash_original_method = "3A1D043D6BB606ABB758EEC975A83919", hash_generated_method = "0685B6849885B262A2395FAE617F4619")
        public boolean hasPreferredInternationalPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538397045 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538397045;
            // ---------- Original Method ----------
            //return hasPreferredInternationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.443 -0400", hash_original_method = "3992DDBA34CC5C49CFC74CF0545FF343", hash_generated_method = "8A33734364C2A3B09F2BAF43BF6350D5")
        public String getPreferredInternationalPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_142499077 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_142499077 = preferredInternationalPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_142499077.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_142499077;
            // ---------- Original Method ----------
            //return preferredInternationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.444 -0400", hash_original_method = "2F2A95A6FC37FC6A654CD2ED9E105058", hash_generated_method = "6C489D2E6F033E364C4D0FA0F54EB502")
        public PhoneMetadata setPreferredInternationalPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_452400130 = null; //Variable for return #1
            hasPreferredInternationalPrefix = true;
            preferredInternationalPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_452400130 = this;
            varB4EAC82CA7396A68D541C85D26508E83_452400130.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_452400130;
            // ---------- Original Method ----------
            //hasPreferredInternationalPrefix = true;
            //preferredInternationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.444 -0400", hash_original_method = "3FEC8563D97FEF0C0B81201609B8C138", hash_generated_method = "7A169E0F1AAA622509FDA38D427FF717")
        public boolean hasNationalPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_213502221 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_213502221;
            // ---------- Original Method ----------
            //return hasNationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.444 -0400", hash_original_method = "3F6DDEA7E91472B57F47F7AA42FF40A4", hash_generated_method = "9A3B0A42D68B07FD2D5B8A888326E349")
        public String getNationalPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_1392192149 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1392192149 = nationalPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_1392192149.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1392192149;
            // ---------- Original Method ----------
            //return nationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.445 -0400", hash_original_method = "F24C638CA5CEB8CDF3416D52787AAB8D", hash_generated_method = "035343E552B609F38422E35B439A66D4")
        public PhoneMetadata setNationalPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1531458652 = null; //Variable for return #1
            hasNationalPrefix = true;
            nationalPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1531458652 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1531458652.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1531458652;
            // ---------- Original Method ----------
            //hasNationalPrefix = true;
            //nationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.445 -0400", hash_original_method = "E23165194A0E40A98A75B1CB3195C323", hash_generated_method = "114D7561040AB421BADC3EA3619E64A3")
        public boolean hasPreferredExtnPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92610395 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_92610395;
            // ---------- Original Method ----------
            //return hasPreferredExtnPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.445 -0400", hash_original_method = "54C0428B3277F86E8CEE26D4467F5D32", hash_generated_method = "78A3DAE21DCBA600DBDE7DECE4466197")
        public String getPreferredExtnPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_1700009498 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1700009498 = preferredExtnPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_1700009498.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1700009498;
            // ---------- Original Method ----------
            //return preferredExtnPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.446 -0400", hash_original_method = "6AE031AAEF0021BEEE5C7C14D7E5ADEE", hash_generated_method = "A215FA5E5F32236B9B7FDBAA3E05C94F")
        public PhoneMetadata setPreferredExtnPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_799055059 = null; //Variable for return #1
            hasPreferredExtnPrefix = true;
            preferredExtnPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_799055059 = this;
            varB4EAC82CA7396A68D541C85D26508E83_799055059.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_799055059;
            // ---------- Original Method ----------
            //hasPreferredExtnPrefix = true;
            //preferredExtnPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.446 -0400", hash_original_method = "079D2F6BDFB9C83E975C341D5D3984E8", hash_generated_method = "77F5734F9286C6D9005EC48A5041B9AD")
        public boolean hasNationalPrefixForParsing() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_348187236 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_348187236;
            // ---------- Original Method ----------
            //return hasNationalPrefixForParsing;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.446 -0400", hash_original_method = "049975D1EC97C98DFAFD92CBA7A3DB4E", hash_generated_method = "D2E8CCDD4A8B0BDFE9D4E2748DC331F0")
        public String getNationalPrefixForParsing() {
            String varB4EAC82CA7396A68D541C85D26508E83_1467567185 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1467567185 = nationalPrefixForParsing_;
            varB4EAC82CA7396A68D541C85D26508E83_1467567185.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1467567185;
            // ---------- Original Method ----------
            //return nationalPrefixForParsing_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.447 -0400", hash_original_method = "9C0BD3F3F0877996BC57F1866741042E", hash_generated_method = "E26400222D2B62653D67375E61F269F0")
        public PhoneMetadata setNationalPrefixForParsing(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_95449469 = null; //Variable for return #1
            hasNationalPrefixForParsing = true;
            nationalPrefixForParsing_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_95449469 = this;
            varB4EAC82CA7396A68D541C85D26508E83_95449469.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_95449469;
            // ---------- Original Method ----------
            //hasNationalPrefixForParsing = true;
            //nationalPrefixForParsing_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.447 -0400", hash_original_method = "1810BCBEB4974245D7BFFA09C69DD621", hash_generated_method = "3C7BB2F9767047E3025A4E9E7980A989")
        public boolean hasNationalPrefixTransformRule() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_251370598 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_251370598;
            // ---------- Original Method ----------
            //return hasNationalPrefixTransformRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.447 -0400", hash_original_method = "55DE6447BA6383DE2B8CA08949083559", hash_generated_method = "0B79A1C95C3C532DBE3E13A5D00F6C96")
        public String getNationalPrefixTransformRule() {
            String varB4EAC82CA7396A68D541C85D26508E83_583942394 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_583942394 = nationalPrefixTransformRule_;
            varB4EAC82CA7396A68D541C85D26508E83_583942394.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_583942394;
            // ---------- Original Method ----------
            //return nationalPrefixTransformRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.447 -0400", hash_original_method = "F0F297723C8F168223FB62622F5A1EB6", hash_generated_method = "9F61AA9D1BB5E62D6EA2A82DB7CD26EB")
        public PhoneMetadata setNationalPrefixTransformRule(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_160384498 = null; //Variable for return #1
            hasNationalPrefixTransformRule = true;
            nationalPrefixTransformRule_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_160384498 = this;
            varB4EAC82CA7396A68D541C85D26508E83_160384498.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_160384498;
            // ---------- Original Method ----------
            //hasNationalPrefixTransformRule = true;
            //nationalPrefixTransformRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.448 -0400", hash_original_method = "23B7A16EBE621B68A999B8F98C32C7FC", hash_generated_method = "DD469FB7E50359A832FE64F77C80FBDE")
        public boolean hasSameMobileAndFixedLinePattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898750473 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_898750473;
            // ---------- Original Method ----------
            //return hasSameMobileAndFixedLinePattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.448 -0400", hash_original_method = "0C8ED851B6AE0A07DB69452573173B34", hash_generated_method = "043A07145FCE10960F0B969CA1D16F85")
        public boolean isSameMobileAndFixedLinePattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_784311983 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_784311983;
            // ---------- Original Method ----------
            //return sameMobileAndFixedLinePattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.448 -0400", hash_original_method = "4899ADA62C5B2767C955044A6A730FDD", hash_generated_method = "44AB80F9B76AFCE592EC21A83F2381C9")
        public PhoneMetadata setSameMobileAndFixedLinePattern(boolean value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1294090046 = null; //Variable for return #1
            hasSameMobileAndFixedLinePattern = true;
            sameMobileAndFixedLinePattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1294090046 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1294090046.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1294090046;
            // ---------- Original Method ----------
            //hasSameMobileAndFixedLinePattern = true;
            //sameMobileAndFixedLinePattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.448 -0400", hash_original_method = "84A1634AEDD3ABF2CF1A3014B5D415EB", hash_generated_method = "1D68F032D7BA07B69CA3F8A45C5365A3")
        public java.util.List<NumberFormat> numberFormats() {
            java.util.List<NumberFormat> varB4EAC82CA7396A68D541C85D26508E83_93904854 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_93904854 = numberFormat_;
            varB4EAC82CA7396A68D541C85D26508E83_93904854.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_93904854;
            // ---------- Original Method ----------
            //return numberFormat_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.449 -0400", hash_original_method = "926251D4CC15A970A4459B1AE98E21C5", hash_generated_method = "D63D3D0F9A380E129AA6567627DF3FCE")
        public int numberFormatSize() {
            int var96E94CB08F0191048A027A706C30A965_1394910057 = (numberFormat_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281000844 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281000844;
            // ---------- Original Method ----------
            //return numberFormat_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.449 -0400", hash_original_method = "A540DB640DF9F8195853729D5B88BC06", hash_generated_method = "103AF10C91A417514F0CD5B53CD0D040")
        public NumberFormat getNumberFormat(int index) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1884796950 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1884796950 = numberFormat_.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1884796950.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1884796950;
            // ---------- Original Method ----------
            //return numberFormat_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.449 -0400", hash_original_method = "6431B417B09BF16DE184C0BF7BFD8C0A", hash_generated_method = "A0FBECC17845519313CEB8369477421C")
        public PhoneMetadata addNumberFormat(NumberFormat value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_441026018 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            numberFormat_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_441026018 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_441026018.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_441026018;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //numberFormat_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.450 -0400", hash_original_method = "AE158E1AC846181939D70DB177BF740E", hash_generated_method = "80F926ED765FAF86F928D1DABAD1C3A9")
        public java.util.List<NumberFormat> intlNumberFormats() {
            java.util.List<NumberFormat> varB4EAC82CA7396A68D541C85D26508E83_2018786139 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2018786139 = intlNumberFormat_;
            varB4EAC82CA7396A68D541C85D26508E83_2018786139.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2018786139;
            // ---------- Original Method ----------
            //return intlNumberFormat_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.450 -0400", hash_original_method = "58F2978D59C0EB64F45AEE8E7A3A3ECF", hash_generated_method = "F92D3B55B2F69C1B41817E214680F5C3")
        public int intlNumberFormatSize() {
            int varF47E20D9CBB1855464C7D9F5EA17F55A_515730964 = (intlNumberFormat_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163296241 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163296241;
            // ---------- Original Method ----------
            //return intlNumberFormat_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.450 -0400", hash_original_method = "14BAA3A4AA80C468A085BC9B63542EE0", hash_generated_method = "B2B37C3B998C69DA6880451A8847DA64")
        public NumberFormat getIntlNumberFormat(int index) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_2001346038 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2001346038 = intlNumberFormat_.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2001346038.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2001346038;
            // ---------- Original Method ----------
            //return intlNumberFormat_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.451 -0400", hash_original_method = "DDE7F201B8001F4279DAEE9969BC3EF9", hash_generated_method = "4EB3674B61B2086F6C893C83932C9858")
        public PhoneMetadata addIntlNumberFormat(NumberFormat value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_262076799 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            intlNumberFormat_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_262076799 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_262076799.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_262076799;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //intlNumberFormat_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.451 -0400", hash_original_method = "C1C6B471737DB86E719E8005B048F8A4", hash_generated_method = "49D92D78C48865F1CD1E267238E377F6")
        public PhoneMetadata clearIntlNumberFormat() {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1817054118 = null; //Variable for return #1
            intlNumberFormat_.clear();
            varB4EAC82CA7396A68D541C85D26508E83_1817054118 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1817054118.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1817054118;
            // ---------- Original Method ----------
            //intlNumberFormat_.clear();
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.451 -0400", hash_original_method = "F0A3F725FE27520DECCABEEE1451ABF4", hash_generated_method = "35681C72B101FBCF414F857FB02F9978")
        public boolean hasMainCountryForCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1985509271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1985509271;
            // ---------- Original Method ----------
            //return hasMainCountryForCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.451 -0400", hash_original_method = "CF03E78162809AA6058F20CA8B82C717", hash_generated_method = "A75541D8FC4811BFCD22FDA2CBB1A43D")
        public boolean isMainCountryForCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_677382726 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_677382726;
            // ---------- Original Method ----------
            //return mainCountryForCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.452 -0400", hash_original_method = "8B579A48BF103BAE8E5F2D34ABF5A62F", hash_generated_method = "309B8DC3C384EC4E00CE23D1C96C15AE")
        public boolean getMainCountryForCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_260480861 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_260480861;
            // ---------- Original Method ----------
            //return mainCountryForCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.452 -0400", hash_original_method = "0E977089CAAEFAD04CCCDA9E72421381", hash_generated_method = "7CEEC6CE70E988879DD1686502F52658")
        public PhoneMetadata setMainCountryForCode(boolean value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1585945222 = null; //Variable for return #1
            hasMainCountryForCode = true;
            mainCountryForCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1585945222 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1585945222.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1585945222;
            // ---------- Original Method ----------
            //hasMainCountryForCode = true;
            //mainCountryForCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.452 -0400", hash_original_method = "46DBCF13AB23890B1C354034C02AAE0D", hash_generated_method = "C9216DAA7F856936A1DF35A7A65FA17C")
        public boolean hasLeadingDigits() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874476595 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874476595;
            // ---------- Original Method ----------
            //return hasLeadingDigits;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.453 -0400", hash_original_method = "BA0CBA2DFD34C6F845467DDF3F7503AD", hash_generated_method = "C08558980EA8B14B67376D34189E007C")
        public String getLeadingDigits() {
            String varB4EAC82CA7396A68D541C85D26508E83_339517274 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_339517274 = leadingDigits_;
            varB4EAC82CA7396A68D541C85D26508E83_339517274.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_339517274;
            // ---------- Original Method ----------
            //return leadingDigits_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.453 -0400", hash_original_method = "1B8095B1499A1300CC7FD6395528DFB9", hash_generated_method = "FBC18FE94F9D1BBCF72AFB03124FC7D6")
        public PhoneMetadata setLeadingDigits(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_544243143 = null; //Variable for return #1
            hasLeadingDigits = true;
            leadingDigits_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_544243143 = this;
            varB4EAC82CA7396A68D541C85D26508E83_544243143.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_544243143;
            // ---------- Original Method ----------
            //hasLeadingDigits = true;
            //leadingDigits_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.453 -0400", hash_original_method = "DF6824D9CE520B4AB88B3980F12D84DC", hash_generated_method = "5EB4BE3527A17191414BF352B7B08FA3")
        public boolean hasLeadingZeroPossible() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_748768425 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_748768425;
            // ---------- Original Method ----------
            //return hasLeadingZeroPossible;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.453 -0400", hash_original_method = "9CE4681262676BB262003F306366B26D", hash_generated_method = "3D837D868CBBF82C85EE70C24326974A")
        public boolean isLeadingZeroPossible() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1132866452 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1132866452;
            // ---------- Original Method ----------
            //return leadingZeroPossible_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.454 -0400", hash_original_method = "4E51759A218DB37A00D6735D1891D88D", hash_generated_method = "E99265D1B8EE2C6790C868223F9725C1")
        public PhoneMetadata setLeadingZeroPossible(boolean value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_230963120 = null; //Variable for return #1
            hasLeadingZeroPossible = true;
            leadingZeroPossible_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_230963120 = this;
            varB4EAC82CA7396A68D541C85D26508E83_230963120.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_230963120;
            // ---------- Original Method ----------
            //hasLeadingZeroPossible = true;
            //leadingZeroPossible_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.454 -0400", hash_original_method = "82C82662DE792F1D24D935E7D9A568AC", hash_generated_method = "271F27A5EC5BA734B053F6E5201ED5CC")
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
            int numberFormatSize = numberFormatSize();
            objectOutput.writeInt(numberFormatSize);
            {
                int i = 0;
                {
                    numberFormat_.get(i).writeExternal(objectOutput);
                } //End block
            } //End collapsed parenthetic
            int intlNumberFormatSize = intlNumberFormatSize();
            objectOutput.writeInt(intlNumberFormatSize);
            {
                int i = 0;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.456 -0400", hash_original_method = "4D891D3CC56C8A4A25C2FA3B62E66106", hash_generated_method = "62FAF0F843D7DE47D870A717D3085590")
        public void readExternal(ObjectInput objectInput) throws IOException {
            boolean hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setGeneralDesc(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setFixedLine(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setMobile(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setTollFree(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setPremiumRate(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setSharedCost(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setPersonalNumber(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setVoip(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setPager(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setUan(desc);
            } //End block
            hasDesc = objectInput.readBoolean();
            {
                PhoneNumberDesc desc = new PhoneNumberDesc();
                desc.readExternal(objectInput);
                setNoInternationalDialling(desc);
            } //End block
            setId(objectInput.readUTF());
            setCountryCode(objectInput.readInt());
            setInternationalPrefix(objectInput.readUTF());
            boolean hasString = objectInput.readBoolean();
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
            int nationalFormatSize = objectInput.readInt();
            {
                int i = 0;
                {
                    NumberFormat numFormat = new NumberFormat();
                    numFormat.readExternal(objectInput);
                    numberFormat_.add(numFormat);
                } //End block
            } //End collapsed parenthetic
            int intlNumberFormatSize = objectInput.readInt();
            {
                int i = 0;
                {
                    NumberFormat numFormat = new NumberFormat();
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.456 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.457 -0400", hash_original_method = "FECA3DB69AA5738CC513C59EB359D04E", hash_generated_method = "4B1948ABCCDB559A3937FD2EBCD0E635")
            public PhoneMetadata build() {
                PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_284390514 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_284390514 = this;
                varB4EAC82CA7396A68D541C85D26508E83_284390514.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_284390514;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.457 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
    public static class PhoneMetadataCollection implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.458 -0400", hash_original_field = "612BD1F5CEECC04CA1A32C585074C146", hash_generated_field = "3988CF3B3569C765826A81A610C2CFA8")

        private java.util.List<PhoneMetadata> metadata_ = new java.util.ArrayList<PhoneMetadata>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.458 -0400", hash_original_method = "833FEC11FB1A703522FFE165412E2F7D", hash_generated_method = "911AB4D46731349730F9522D952A81AB")
        public  PhoneMetadataCollection() {
            // ---------- Original Method ----------
        }

        
        public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.459 -0400", hash_original_method = "C5ECD645F70FA9D5A2A9EB8CBA32ADEF", hash_generated_method = "11987EA7EF740ED38D29A9DF0E1BEE59")
        public java.util.List<PhoneMetadata> getMetadataList() {
            java.util.List<PhoneMetadata> varB4EAC82CA7396A68D541C85D26508E83_429349366 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_429349366 = metadata_;
            varB4EAC82CA7396A68D541C85D26508E83_429349366.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_429349366;
            // ---------- Original Method ----------
            //return metadata_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.460 -0400", hash_original_method = "95419ED058599C84B2A0103C5C8B3F30", hash_generated_method = "42D4F4D6F3CB4F738696C3E64E42DD4D")
        public int getMetadataCount() {
            int varE8225671ABD39B7016D6383C297CDF20_1747770006 = (metadata_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_774984618 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_774984618;
            // ---------- Original Method ----------
            //return metadata_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.460 -0400", hash_original_method = "D57D52560347164C8871C87ACF1DAD2C", hash_generated_method = "14B31194AA7393BCB38C282E1DA14CD3")
        public PhoneMetadataCollection addMetadata(PhoneMetadata value) {
            PhoneMetadataCollection varB4EAC82CA7396A68D541C85D26508E83_1657472222 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            metadata_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_1657472222 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1657472222.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1657472222;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //metadata_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.461 -0400", hash_original_method = "BDFB00F39A05DC0D50872248169D293E", hash_generated_method = "A5A82614596F697F08988F00B4ED9DF8")
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            int size = getMetadataCount();
            objectOutput.writeInt(size);
            {
                int i = 0;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.461 -0400", hash_original_method = "FAC331B8B6AD54634EE3CFAA3149ADF1", hash_generated_method = "D653AA96E8D259535C3921EDCEB8BF59")
        public void readExternal(ObjectInput objectInput) throws IOException {
            int size = objectInput.readInt();
            {
                int i = 0;
                {
                    PhoneMetadata metadata = new PhoneMetadata();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.461 -0400", hash_original_method = "1BB2E7D611D4F26F7F8136F4B2C1D585", hash_generated_method = "5D61CBD4ADB1B6C9EB29DED5AD743F12")
        public PhoneMetadataCollection clear() {
            PhoneMetadataCollection varB4EAC82CA7396A68D541C85D26508E83_793537188 = null; //Variable for return #1
            metadata_.clear();
            varB4EAC82CA7396A68D541C85D26508E83_793537188 = this;
            varB4EAC82CA7396A68D541C85D26508E83_793537188.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_793537188;
            // ---------- Original Method ----------
            //metadata_.clear();
            //return this;
        }

        
        public static final class Builder extends PhoneMetadataCollection {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.462 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.462 -0400", hash_original_method = "62075F60ED3DD2393D61C900D272662C", hash_generated_method = "1498486F5CB94B61E3FE9E400D442D45")
            public PhoneMetadataCollection build() {
                PhoneMetadataCollection varB4EAC82CA7396A68D541C85D26508E83_1545938656 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1545938656 = this;
                varB4EAC82CA7396A68D541C85D26508E83_1545938656.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1545938656;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.462 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

        private static final long serialVersionUID = 1;
    }


    
}

