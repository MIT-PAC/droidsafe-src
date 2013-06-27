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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_method = "AA2168146A79C42118444B1AF1D13430", hash_generated_method = "01D7B0EC1EB8E0CA70481AF327448A6E")
    private  Phonemetadata() {
        // ---------- Original Method ----------
    }

    
    public static class NumberFormat implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_field = "EBB44F9DC35254EE54F96EB8D2936620", hash_generated_field = "BCFAB4E6509DB535E782A9A7638BF800")

        private boolean hasPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_field = "7BA2602BE34151F7BF8709C5E6902A23", hash_generated_field = "A40119EC58A9ADBEEF7F74515C4824EB")

        private String pattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_field = "FB3499637AAFAB74C9C7084B2A5F6485", hash_generated_field = "BB7D9B531AF497BD0CC6485A499825C4")

        private boolean hasFormat;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_field = "E46CD8EF559BE4A57DCE6A0505568890", hash_generated_field = "331E3EC56817A5418D313A742EE6BAF6")

        private String format_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_field = "2FC5ACB9349FF6307BF22B61065526C5", hash_generated_field = "8C6856D900C2B3217AAACE1CB04BBDC9")

        private java.util.List<String> leadingDigitsPattern_ = new java.util.ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_field = "3BCF607E89F66B196F9AF26CAC995637", hash_generated_field = "92669F4414DE1997CD38BA06884F29EB")

        private boolean hasNationalPrefixFormattingRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_field = "61056B131F75442BA186CE92F8481346", hash_generated_field = "B5917D98A0DF4DBF46F96EC8B9B42B54")

        private String nationalPrefixFormattingRule_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_field = "FBF94AE436756F8EF0359BB5BCECE5A5", hash_generated_field = "1C2206B3A1E5D1FEEB3BC9386E1B8AEC")

        private boolean hasDomesticCarrierCodeFormattingRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_field = "6FDFEB13B19DC6F980A9FF00FF64E797", hash_generated_field = "4E860583F8E21CB17BEAB512DD9874BA")

        private String domesticCarrierCodeFormattingRule_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.982 -0400", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "8FEBA1E1E8A6552B6917C667BFAE4E78")
        public  NumberFormat() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.984 -0400", hash_original_method = "0246232EE6FB2A92C361AD6A40430F9A", hash_generated_method = "550CCFC7604B14C05DDBCE42B9691D57")
        public boolean hasPattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_238366640 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_238366640;
            // ---------- Original Method ----------
            //return hasPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.984 -0400", hash_original_method = "42C6A53B1E4394F40C706B46BCE960D0", hash_generated_method = "7326F20A682EDCFA9008CE9FD5279D58")
        public String getPattern() {
            String varB4EAC82CA7396A68D541C85D26508E83_956551484 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_956551484 = pattern_;
            varB4EAC82CA7396A68D541C85D26508E83_956551484.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_956551484;
            // ---------- Original Method ----------
            //return pattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.985 -0400", hash_original_method = "ED9D042141B07F3A02D73E93DCCEE4F0", hash_generated_method = "6AED2B72421BDAD2E413EA233421856C")
        public NumberFormat setPattern(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_113265565 = null; //Variable for return #1
            hasPattern = true;
            pattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_113265565 = this;
            varB4EAC82CA7396A68D541C85D26508E83_113265565.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_113265565;
            // ---------- Original Method ----------
            //hasPattern = true;
            //pattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.992 -0400", hash_original_method = "68B5595866A3AC066C218CEE1670E78C", hash_generated_method = "B1581A741AD6DF55D2DD7DD49252BB2A")
        public boolean hasFormat() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_556766997 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_556766997;
            // ---------- Original Method ----------
            //return hasFormat;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.993 -0400", hash_original_method = "77809F0555E410001A5868E71E8924BD", hash_generated_method = "E62952DF66ACA5086DF3025C3B2B1072")
        public String getFormat() {
            String varB4EAC82CA7396A68D541C85D26508E83_930367561 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_930367561 = format_;
            varB4EAC82CA7396A68D541C85D26508E83_930367561.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_930367561;
            // ---------- Original Method ----------
            //return format_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.010 -0400", hash_original_method = "791160F9BB3B0A81AD0DFEC24C1732C9", hash_generated_method = "37066B878858E2F3E499409EECBC4905")
        public NumberFormat setFormat(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_389642748 = null; //Variable for return #1
            hasFormat = true;
            format_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_389642748 = this;
            varB4EAC82CA7396A68D541C85D26508E83_389642748.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_389642748;
            // ---------- Original Method ----------
            //hasFormat = true;
            //format_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.011 -0400", hash_original_method = "E6A52876E9E1328523A23CDD4ADD6081", hash_generated_method = "E573D5F0E5BA0848180D666B3810DFF6")
        public java.util.List<String> leadingDigitPatterns() {
            java.util.List<String> varB4EAC82CA7396A68D541C85D26508E83_1166527109 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1166527109 = leadingDigitsPattern_;
            varB4EAC82CA7396A68D541C85D26508E83_1166527109.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1166527109;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.012 -0400", hash_original_method = "A7BC4264224DD72A69FEDA104C14570A", hash_generated_method = "4E5EAEC0F187D9F693785DF7B4E27096")
        public int leadingDigitsPatternSize() {
            int varB0FE41F8E6695F261080B3A10B142102_1208616033 = (leadingDigitsPattern_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964524652 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964524652;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.013 -0400", hash_original_method = "F45A9318A15D3A63FB863C1586B0A383", hash_generated_method = "686973FA4E62766E1B0D1AB50A1B778A")
        public String getLeadingDigitsPattern(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_1518512002 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1518512002 = leadingDigitsPattern_.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1518512002.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1518512002;
            // ---------- Original Method ----------
            //return leadingDigitsPattern_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.014 -0400", hash_original_method = "67AADF10399513606F7245D93555CAB7", hash_generated_method = "2E8BC2EF65867129D2527CEA153177DE")
        public NumberFormat addLeadingDigitsPattern(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_344677173 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            leadingDigitsPattern_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_344677173 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_344677173.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_344677173;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //leadingDigitsPattern_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.014 -0400", hash_original_method = "A0F401EEBE63541205F643F348AC0373", hash_generated_method = "927FEDF6B70D82C89C53C233085B0A5A")
        public boolean hasNationalPrefixFormattingRule() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580919738 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_580919738;
            // ---------- Original Method ----------
            //return hasNationalPrefixFormattingRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.018 -0400", hash_original_method = "4B4C80C20D7D7C0D6F8A6AA39111D13B", hash_generated_method = "1B4E06484454630231FB66D22E6F0AD7")
        public String getNationalPrefixFormattingRule() {
            String varB4EAC82CA7396A68D541C85D26508E83_2088792182 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2088792182 = nationalPrefixFormattingRule_;
            varB4EAC82CA7396A68D541C85D26508E83_2088792182.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2088792182;
            // ---------- Original Method ----------
            //return nationalPrefixFormattingRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.019 -0400", hash_original_method = "6C67B9000B21FDC6ACFC6210DBD720A7", hash_generated_method = "8EDDC20CF1F5D491C22BB8819B88CD28")
        public NumberFormat setNationalPrefixFormattingRule(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1077324408 = null; //Variable for return #1
            hasNationalPrefixFormattingRule = true;
            nationalPrefixFormattingRule_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1077324408 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1077324408.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1077324408;
            // ---------- Original Method ----------
            //hasNationalPrefixFormattingRule = true;
            //nationalPrefixFormattingRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.027 -0400", hash_original_method = "394C283EEDF7D9BA381FE6D7D2DD662E", hash_generated_method = "36482DB04F44549C1489C22D5A6D7575")
        public NumberFormat clearNationalPrefixFormattingRule() {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1254706862 = null; //Variable for return #1
            hasNationalPrefixFormattingRule = false;
            nationalPrefixFormattingRule_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_1254706862 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1254706862.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1254706862;
            // ---------- Original Method ----------
            //hasNationalPrefixFormattingRule = false;
            //nationalPrefixFormattingRule_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.027 -0400", hash_original_method = "1D512C574271A1305D1AF9A0CCC5C6D3", hash_generated_method = "EE79646A757209E68C5D7CFBE98FFB20")
        public boolean hasDomesticCarrierCodeFormattingRule() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773849443 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_773849443;
            // ---------- Original Method ----------
            //return hasDomesticCarrierCodeFormattingRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.031 -0400", hash_original_method = "1D78023CBBDF63A0A2ACC33925BD120F", hash_generated_method = "BD46FFC364914FC5D3C408AE937F4357")
        public String getDomesticCarrierCodeFormattingRule() {
            String varB4EAC82CA7396A68D541C85D26508E83_826828263 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_826828263 = domesticCarrierCodeFormattingRule_;
            varB4EAC82CA7396A68D541C85D26508E83_826828263.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_826828263;
            // ---------- Original Method ----------
            //return domesticCarrierCodeFormattingRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.044 -0400", hash_original_method = "2168D8046E4A0ED39DDD19551FD64D5A", hash_generated_method = "4B0A5F5C10C6469BABF954E84A36AB60")
        public NumberFormat setDomesticCarrierCodeFormattingRule(String value) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1352745168 = null; //Variable for return #1
            hasDomesticCarrierCodeFormattingRule = true;
            domesticCarrierCodeFormattingRule_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1352745168 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1352745168.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1352745168;
            // ---------- Original Method ----------
            //hasDomesticCarrierCodeFormattingRule = true;
            //domesticCarrierCodeFormattingRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.045 -0400", hash_original_method = "DEB91FB350FEBE5DEE35AF7BFA950AEF", hash_generated_method = "DA981C51BB2047F911A56710C2D095A8")
        public NumberFormat mergeFrom(NumberFormat other) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_2127770231 = null; //Variable for return #1
            {
                boolean varF081F818C9346840C1C05850A1E84836_1419109940 = (other.hasPattern());
                {
                    setPattern(other.getPattern());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var3120A21678B49476E859E38D301D6C44_477591069 = (other.hasFormat());
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
                boolean varDDD2CD16D3ACF0EDF8A5770CE9BF81DE_1125222193 = (other.hasNationalPrefixFormattingRule());
                {
                    setNationalPrefixFormattingRule(other.getNationalPrefixFormattingRule());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var41F6787BFF8421A70F22829D88E4C6F7_1248448250 = (other.hasDomesticCarrierCodeFormattingRule());
                {
                    setDomesticCarrierCodeFormattingRule(other.getDomesticCarrierCodeFormattingRule());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_2127770231 = this;
            addTaint(other.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2127770231.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2127770231;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.047 -0400", hash_original_method = "A100AA8318BC8064BB1FFCA8BFB04888", hash_generated_method = "8D599BE5B93D1BF457F5D040FA4595C7")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.052 -0400", hash_original_method = "A5A163CCCC35630D5C707482125AAE27", hash_generated_method = "B236D600AB4F13D2DFC6C09297DEC00B")
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
                boolean varF1F2050C0B36B3012DF952FA04096995_286513369 = (objectInput.readBoolean());
                {
                    setNationalPrefixFormattingRule(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_1752082410 = (objectInput.readBoolean());
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.053 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.053 -0400", hash_original_method = "0B2E67344AC06F839A81A2533D186625", hash_generated_method = "1BFCA13617EAC7D6DB142B896C793FC1")
            public NumberFormat build() {
                NumberFormat varB4EAC82CA7396A68D541C85D26508E83_479453209 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_479453209 = this;
                varB4EAC82CA7396A68D541C85D26508E83_479453209.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_479453209;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.053 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "DF26AFCCBB9DDCFC72C78DA996786C5E")

        private static long serialVersionUID = 1;
    }


    
    public static class PhoneNumberDesc implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.053 -0400", hash_original_field = "DF8FA0961A72330EDFA83A06858DAA6D", hash_generated_field = "FE0D4AC450B46E7BA63C0A5FF14C51C2")

        private boolean hasNationalNumberPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.053 -0400", hash_original_field = "B9BBEC8ED347133624C9F13EC01959D6", hash_generated_field = "EEA13D95EC1A783CC3FD2A2EA5BF77DB")

        private String nationalNumberPattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.053 -0400", hash_original_field = "5128B6327ABA67ABA34F0D40555173E8", hash_generated_field = "A5D4C78E7537A35AEAFB80E70E1EF9CF")

        private boolean hasPossibleNumberPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.053 -0400", hash_original_field = "CE9BECD6E9AE72932A581A01A4BC72CF", hash_generated_field = "9740030449804334CD1D210C9AACA78D")

        private String possibleNumberPattern_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.053 -0400", hash_original_field = "2439321B7A9F025B302F5484BF5AA1CC", hash_generated_field = "A377FEAF080DA6EA07178B0BF7E01505")

        private boolean hasExampleNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.053 -0400", hash_original_field = "A267297FDB6460E899FB01789A537AEF", hash_generated_field = "D8EDB7AA5577953B265C1D4AEECCDF65")

        private String exampleNumber_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.074 -0400", hash_original_method = "7B50B3AE2E947514292047EE4CC3D0B3", hash_generated_method = "FF0F10C59E5A022C63A72AE504F6D672")
        public  PhoneNumberDesc() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.074 -0400", hash_original_method = "7AE951C08CA66D0892FA0795F4703C0D", hash_generated_method = "26BC8153E10A9F625BC2E25A6F71AB7C")
        public boolean hasNationalNumberPattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758762688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758762688;
            // ---------- Original Method ----------
            //return hasNationalNumberPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.075 -0400", hash_original_method = "AE5307416A342E6E51B0D8AFEA64E005", hash_generated_method = "3B15AC906AFCFF5BCDEE4F28FC443715")
        public String getNationalNumberPattern() {
            String varB4EAC82CA7396A68D541C85D26508E83_1840017350 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1840017350 = nationalNumberPattern_;
            varB4EAC82CA7396A68D541C85D26508E83_1840017350.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1840017350;
            // ---------- Original Method ----------
            //return nationalNumberPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.075 -0400", hash_original_method = "5843589EEE5242B872EEFCA090E2182C", hash_generated_method = "6B99FE9390B696BD2C3AD2CB8950BBE8")
        public PhoneNumberDesc setNationalNumberPattern(String value) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_977057286 = null; //Variable for return #1
            hasNationalNumberPattern = true;
            nationalNumberPattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_977057286 = this;
            varB4EAC82CA7396A68D541C85D26508E83_977057286.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_977057286;
            // ---------- Original Method ----------
            //hasNationalNumberPattern = true;
            //nationalNumberPattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.075 -0400", hash_original_method = "0D2D12A828079BB292F0B693EDB7AA61", hash_generated_method = "237007C968B634C449B1CEA79222434D")
        public boolean hasPossibleNumberPattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680654679 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680654679;
            // ---------- Original Method ----------
            //return hasPossibleNumberPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.076 -0400", hash_original_method = "69E173398B553B507060BBCC25879496", hash_generated_method = "36774BE73454D812D5CA30DF5525DB75")
        public String getPossibleNumberPattern() {
            String varB4EAC82CA7396A68D541C85D26508E83_92894345 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_92894345 = possibleNumberPattern_;
            varB4EAC82CA7396A68D541C85D26508E83_92894345.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_92894345;
            // ---------- Original Method ----------
            //return possibleNumberPattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.076 -0400", hash_original_method = "E6F0FD7A3910EDF596B66C25C9FCACCB", hash_generated_method = "FC9D2B708CB9345BDD9A6B09CE9693B7")
        public PhoneNumberDesc setPossibleNumberPattern(String value) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_517079010 = null; //Variable for return #1
            hasPossibleNumberPattern = true;
            possibleNumberPattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_517079010 = this;
            varB4EAC82CA7396A68D541C85D26508E83_517079010.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_517079010;
            // ---------- Original Method ----------
            //hasPossibleNumberPattern = true;
            //possibleNumberPattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.077 -0400", hash_original_method = "9EA98547022BA9B31E373C0BBC90B4AD", hash_generated_method = "3B3B7425369BC64AEB9FB45DE1214F82")
        public boolean hasExampleNumber() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1949510085 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1949510085;
            // ---------- Original Method ----------
            //return hasExampleNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.078 -0400", hash_original_method = "4F2E88760366816D23F2792FF3D4D910", hash_generated_method = "B03637E5ADCD293256298C1DE29C4784")
        public String getExampleNumber() {
            String varB4EAC82CA7396A68D541C85D26508E83_89325731 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_89325731 = exampleNumber_;
            varB4EAC82CA7396A68D541C85D26508E83_89325731.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_89325731;
            // ---------- Original Method ----------
            //return exampleNumber_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.078 -0400", hash_original_method = "99D22C86FFDC5E436BCE118592FFD464", hash_generated_method = "6ABF1D5606E9DCF84E0EDE69FA577B36")
        public PhoneNumberDesc setExampleNumber(String value) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_881787919 = null; //Variable for return #1
            hasExampleNumber = true;
            exampleNumber_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_881787919 = this;
            varB4EAC82CA7396A68D541C85D26508E83_881787919.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_881787919;
            // ---------- Original Method ----------
            //hasExampleNumber = true;
            //exampleNumber_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.092 -0400", hash_original_method = "13E9D2F0445C754E67764A18611FF669", hash_generated_method = "8BC7A0C8E1FE1B400A636F28A486B183")
        public PhoneNumberDesc mergeFrom(PhoneNumberDesc other) {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1506895189 = null; //Variable for return #1
            {
                boolean varD58E2A0E1D953219659F1147E75D73F4_824189566 = (other.hasNationalNumberPattern());
                {
                    setNationalNumberPattern(other.getNationalNumberPattern());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varC6F51288774EBF45A3EF2B68674CCC4F_1423435035 = (other.hasPossibleNumberPattern());
                {
                    setPossibleNumberPattern(other.getPossibleNumberPattern());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var63E297A85C8F39AFE7F8C657D805A65F_883304934 = (other.hasExampleNumber());
                {
                    setExampleNumber(other.getExampleNumber());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1506895189 = this;
            addTaint(other.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1506895189.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1506895189;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.100 -0400", hash_original_method = "67972576318010D4A6F8FC5204742584", hash_generated_method = "06A4E3C9A05153FF2C88A283E5310A8C")
        public boolean exactlySameAs(PhoneNumberDesc other) {
            boolean var6367AA144C0559F2B90F3AB658EAE0FD_431996807 = (nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          exampleNumber_.equals(other.exampleNumber_));
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1003224555 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1003224555;
            // ---------- Original Method ----------
            //return nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          //possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          //exampleNumber_.equals(other.exampleNumber_);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.108 -0400", hash_original_method = "A248C31238E31950C31B42AEACDEB8E6", hash_generated_method = "107091F0B9E8823957DC97ED30F00CA8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.109 -0400", hash_original_method = "27FB9E0837C2CDBADF688660FFE7A75C", hash_generated_method = "326F79328EC19D57FE2FDD3A59E7419B")
        public void readExternal(ObjectInput objectInput) throws IOException {
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_1646939932 = (objectInput.readBoolean());
                {
                    setNationalNumberPattern(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_552846366 = (objectInput.readBoolean());
                {
                    setPossibleNumberPattern(objectInput.readUTF());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF1F2050C0B36B3012DF952FA04096995_294210953 = (objectInput.readBoolean());
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.109 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.120 -0400", hash_original_method = "27A166D755957BD27B60D63CE4983A6A", hash_generated_method = "35C77A1822854D02FE993088568D70DD")
            public PhoneNumberDesc build() {
                PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1448274254 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1448274254 = this;
                varB4EAC82CA7396A68D541C85D26508E83_1448274254.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1448274254;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.120 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "DF26AFCCBB9DDCFC72C78DA996786C5E")

        private static long serialVersionUID = 1;
    }


    
    public static class PhoneMetadata implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "B1185F70DC285179A2028122A1753D38", hash_generated_field = "A3B9F71CE88284DA159E437E743AF585")

        private boolean hasGeneralDesc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "419108228A3D4DD7D84FDBBA426B692E", hash_generated_field = "7468C9C864A0465318B0CE4D7F53C201")

        private PhoneNumberDesc generalDesc_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "E592D649F417667F2723D6FFED6E2DB7", hash_generated_field = "E05C42AA9F7E3C173F9E6FFB96993C10")

        private boolean hasFixedLine;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "7D61EBE9F230AE4F535BB262D140087E", hash_generated_field = "6B2D29317DA7FDD4358F05B6ED70E817")

        private PhoneNumberDesc fixedLine_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "8624D101BA06AC461F2198E30D1F6A12", hash_generated_field = "6732DA5D8F7E44D3EB8E9B3B04D2C208")

        private boolean hasMobile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "9A3666ECDC25598E8B1F39C149B5248B", hash_generated_field = "B09F10BC9C29A32513C7F9D45C9DD65D")

        private PhoneNumberDesc mobile_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "75EB0178779C5B94A142C67A8A3A0895", hash_generated_field = "80FAAA0975BF29FCB14D951C0BEDC5C4")

        private boolean hasTollFree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "8A684838F9710DEC6492C65DEB5B5A0F", hash_generated_field = "80CDA2C3C5F8E5226552943E5B5D1962")

        private PhoneNumberDesc tollFree_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "6401DBC84CDD207E60C202A21F935454", hash_generated_field = "5A30F5E3B7119D5842288ABCFFE97498")

        private boolean hasPremiumRate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "A525D6594473341CA8B89D37798B312E", hash_generated_field = "A45FECABBF74FB7321F9023E44E33237")

        private PhoneNumberDesc premiumRate_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "B64C7B1A99130C1E792DC2EC767D9EFB", hash_generated_field = "E49185F054F9F704C5600406F67DCB84")

        private boolean hasSharedCost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "1E9F4723F699DE8125552E21FFBFE400", hash_generated_field = "F1E7A155AA2DB5B0B5B95BFB0CEE31C9")

        private PhoneNumberDesc sharedCost_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "C6671814FF918E89A75FE4D83E386A68", hash_generated_field = "EDA3B33207D61D6AC565FA093ADCC196")

        private boolean hasPersonalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "1CFAD4514D14064196C72BF65F9CF559", hash_generated_field = "9BEB6F47AE29097500633D2F6F699031")

        private PhoneNumberDesc personalNumber_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "6993F15A6272097A69996233948D6788", hash_generated_field = "389614404066D2EFA2E54C2350D94AD0")

        private boolean hasVoip;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "4F48640F12EB1E254E7007633AE6A4BB", hash_generated_field = "EFA41A681D6E8CCFBC92A6D814B85301")

        private PhoneNumberDesc voip_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "F4712A7EC85B48169BE6F130B09401AF", hash_generated_field = "AA932FC09168FC29B0E1BDD3089132CB")

        private boolean hasPager;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "B53FED5DFF5974BE7B138F1CA58A1B36", hash_generated_field = "6DF80094481DB5FAFFA343EECB46293A")

        private PhoneNumberDesc pager_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "1C045935E1F5FA0A1792848701C607B3", hash_generated_field = "8F81ABDD16142E28D9E5984C6F740238")

        private boolean hasUan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "8579B62499AB55F965AD299835FB973C", hash_generated_field = "AD69C3410F5AE892799A6AC7CB2532E2")

        private PhoneNumberDesc uan_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "DA4DF0660D0FEED67B00F588F241E7EB", hash_generated_field = "0ADF693E546C325541D053D46F07CA67")

        private boolean hasNoInternationalDialling;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "460049B379C4B8AF431BAEE1EBCBF02E", hash_generated_field = "DB4742972A73F31DE788D6B88EE269C4")

        private PhoneNumberDesc noInternationalDialling_ = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.121 -0400", hash_original_field = "B00599996521998233C824ACCAB0E15F", hash_generated_field = "0140279EBB974905A38C47A7722FAFF6")

        private boolean hasId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "09E215DDF102AD5C73EE5F65A3C0CAB9", hash_generated_field = "A3944B7884E3A988EBAE9C53EFFAD5F5")

        private String id_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "8DA9382CFAB6A2934FA5AD3C46617F89", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

        private boolean hasCountryCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "3461D01D5A7F32E3FA9B229113397711", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

        private int countryCode_ = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "71E29C99125BF827B3C5BF568381086E", hash_generated_field = "5FC44BC01719FCF066ECC548BE8A5361")

        private boolean hasInternationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "E282158924B697D8BC6CAAE1BC57B7AB", hash_generated_field = "717A913C833941AC2C547FE2DFF1FB22")

        private String internationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "3ECE55B44C31E2628C42F70CE9639621", hash_generated_field = "A9895E937CD8DAE0C496DBC48D2C2CEE")

        private boolean hasPreferredInternationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "FCD8C7D7DFF78E7FA4B7EEE488EB6AC0", hash_generated_field = "CDC303EF35375A2E1F5FC52FA30A0AEF")

        private String preferredInternationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "4470362D119F8595D8A4313EC3BBE684", hash_generated_field = "7558F68656CC64EE957040556631A4B3")

        private boolean hasNationalPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "7FFC07608A27C8D4C3337E4B3E617A97", hash_generated_field = "9FD4079672B074B1C28FCBD5211F0E6E")

        private String nationalPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "CE3736A3B3D1072084220B70CD4D0A4F", hash_generated_field = "D4784FA8A81183D66211EA3CB7EAD63D")

        private boolean hasPreferredExtnPrefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "3BFE67D70B206F596FE6BB87EA4FC2EE", hash_generated_field = "F27B632A949D8FCEF65E426D0FEC59C2")

        private String preferredExtnPrefix_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "178A91AD8C9D4B311CBB7E9799C204D6", hash_generated_field = "507A8081AF30D85EF13F20C27737EE29")

        private boolean hasNationalPrefixForParsing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "5CE340B02A46FE9107F9780901340CAC", hash_generated_field = "46A092752488BEB0567E42ECBB5103EA")

        private String nationalPrefixForParsing_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "037AAC783F91D571F6E54112E2703ECE", hash_generated_field = "B59E7752C84471B249DCD9F9C398AFC5")

        private boolean hasNationalPrefixTransformRule;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "E828C84B52178E6A7F8B07EA0784D668", hash_generated_field = "08067D30B404B72AEBA1F2484BFD694C")

        private String nationalPrefixTransformRule_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "5E31C2CEC062E7B8113B945A2F2AA0E9", hash_generated_field = "31870DDEA4297A7CAB4D169E31FFFEBE")

        private boolean hasSameMobileAndFixedLinePattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "E4C862F971A24839C23EBE9F978A48B6", hash_generated_field = "789005A5E2E7FE7FCA1F46FB6F3F7B13")

        private boolean sameMobileAndFixedLinePattern_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "181C76BA224D14DBE65B8E0F96308942", hash_generated_field = "B800AB6258E8C26EC659EA232E613974")

        private java.util.List<NumberFormat> numberFormat_ = new java.util.ArrayList<NumberFormat>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "38053CEBD2D283DF20A1B56D88B2FD5C", hash_generated_field = "8438C32E42D261618BF3822D8254B874")

        private java.util.List<NumberFormat> intlNumberFormat_ = new java.util.ArrayList<NumberFormat>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "08D2B80646091F0A5CABE08AE2346FDA", hash_generated_field = "30F748667FFCDF08F79F81730072A8E1")

        private boolean hasMainCountryForCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "939EF08D7E9438FD155F13C644263B24", hash_generated_field = "7BE3C4CE079A909FDB8BCA00D97F89BF")

        private boolean mainCountryForCode_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "17079C6943CC232663CE7B61C9E492DB", hash_generated_field = "AE9DE5751CA76FAC5FD0690889290B59")

        private boolean hasLeadingDigits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "E5D90B3FC23E47C17AFA7132318C4380", hash_generated_field = "A2DF202A3B5F3D62339A3B2DE2A4FAB2")

        private String leadingDigits_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "352F42E9E2F51AB889A7ACC99B15F496", hash_generated_field = "4AEC48A66912462BA0FE869D7DC85F43")

        private boolean hasLeadingZeroPossible;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.122 -0400", hash_original_field = "87145D95F10EE570BBC9AFAE6F259808", hash_generated_field = "F45DAF5712BFBE9A35415A4D733DC0FC")

        private boolean leadingZeroPossible_ = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.123 -0400", hash_original_method = "8411C48F959C93D1C6435DDA5C4FFBF8", hash_generated_method = "246EB5CC112F2B1B6402C47CB846FD5D")
        public  PhoneMetadata() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.126 -0400", hash_original_method = "573E786E141FAAA03A367F49BCA559B5", hash_generated_method = "073AB59A1A2F64C9FE6273F2448CE6C5")
        public boolean hasGeneralDesc() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683101372 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683101372;
            // ---------- Original Method ----------
            //return hasGeneralDesc;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.136 -0400", hash_original_method = "F96C4A1868C09190E3C941F03A2889CB", hash_generated_method = "E3749C35C511FCF362D7E793892A0643")
        public PhoneNumberDesc getGeneralDesc() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1230284258 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1230284258 = generalDesc_;
            varB4EAC82CA7396A68D541C85D26508E83_1230284258.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1230284258;
            // ---------- Original Method ----------
            //return generalDesc_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.137 -0400", hash_original_method = "97D824F311B5130867761544B2540B90", hash_generated_method = "AA77BDF9E5554E0AA8A2C0923F830D31")
        public PhoneMetadata setGeneralDesc(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_2032566904 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasGeneralDesc = true;
            generalDesc_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_2032566904 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2032566904.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2032566904;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasGeneralDesc = true;
            //generalDesc_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.151 -0400", hash_original_method = "0B06F02C38AE7EA6E1205EAD00F0F3D7", hash_generated_method = "C5711D6B9376F44C52DB7EA9A4AB7958")
        public boolean hasFixedLine() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466638972 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_466638972;
            // ---------- Original Method ----------
            //return hasFixedLine;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.152 -0400", hash_original_method = "7111E9DB2C9B99769226207CB0B39C0D", hash_generated_method = "E16A9C0BB87B3488DA556A097164173F")
        public PhoneNumberDesc getFixedLine() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1140201291 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1140201291 = fixedLine_;
            varB4EAC82CA7396A68D541C85D26508E83_1140201291.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1140201291;
            // ---------- Original Method ----------
            //return fixedLine_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.156 -0400", hash_original_method = "4E0B7145906BC721C9DE8D0C32500FC9", hash_generated_method = "95C73DD8B375020080206EFF12DC0F25")
        public PhoneMetadata setFixedLine(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_15819294 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasFixedLine = true;
            fixedLine_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_15819294 = this;
            varB4EAC82CA7396A68D541C85D26508E83_15819294.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_15819294;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasFixedLine = true;
            //fixedLine_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.156 -0400", hash_original_method = "F5A454F163C8198EDADB6A0267665530", hash_generated_method = "BAF6E4315FD7A741DA0D833EDA3204BC")
        public boolean hasMobile() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_312478566 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_312478566;
            // ---------- Original Method ----------
            //return hasMobile;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.164 -0400", hash_original_method = "469BFC723D37FABFB9BC30DE50B7B80A", hash_generated_method = "CE9C6D5D6BCEF5BA3254155365205C1F")
        public PhoneNumberDesc getMobile() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_2014313900 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2014313900 = mobile_;
            varB4EAC82CA7396A68D541C85D26508E83_2014313900.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2014313900;
            // ---------- Original Method ----------
            //return mobile_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.169 -0400", hash_original_method = "CF0A4860566840BE9C27E4474979A50E", hash_generated_method = "9D6DB504A57A563026E7D918B101E514")
        public PhoneMetadata setMobile(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_551722091 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasMobile = true;
            mobile_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_551722091 = this;
            varB4EAC82CA7396A68D541C85D26508E83_551722091.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_551722091;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasMobile = true;
            //mobile_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.169 -0400", hash_original_method = "C6BB80AB6E7BD893E9D8810967101490", hash_generated_method = "AA0E49FA15998887AB766C872CD4EE7C")
        public boolean hasTollFree() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899113321 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899113321;
            // ---------- Original Method ----------
            //return hasTollFree;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.235 -0400", hash_original_method = "A25CEA98E2A744A76CD23B6ECE21AB56", hash_generated_method = "8F88BB3D30BEE1507C0357F24C7D1F94")
        public PhoneNumberDesc getTollFree() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_361260478 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_361260478 = tollFree_;
            varB4EAC82CA7396A68D541C85D26508E83_361260478.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_361260478;
            // ---------- Original Method ----------
            //return tollFree_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.236 -0400", hash_original_method = "46A649F605F0EC24C76169E259456A93", hash_generated_method = "75ACCA8554E53A7727C362D48EA0318F")
        public PhoneMetadata setTollFree(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1046160730 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasTollFree = true;
            tollFree_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1046160730 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1046160730.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1046160730;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasTollFree = true;
            //tollFree_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.236 -0400", hash_original_method = "82079540736B40B455CF317890B4623A", hash_generated_method = "4D19AA02A9AE1FA65C664E7BEDAC1BC3")
        public boolean hasPremiumRate() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098478041 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098478041;
            // ---------- Original Method ----------
            //return hasPremiumRate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.237 -0400", hash_original_method = "14341C327DA8E1CAAD52FEB1F27BC133", hash_generated_method = "2995A674921F569EC34E78E24A1F2DE3")
        public PhoneNumberDesc getPremiumRate() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_524927460 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_524927460 = premiumRate_;
            varB4EAC82CA7396A68D541C85D26508E83_524927460.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_524927460;
            // ---------- Original Method ----------
            //return premiumRate_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.238 -0400", hash_original_method = "BC27E8EEE54A894FE20AA77CF35DD102", hash_generated_method = "8E600219A4DC06BBB758096DB9F02392")
        public PhoneMetadata setPremiumRate(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_553108731 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPremiumRate = true;
            premiumRate_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_553108731 = this;
            varB4EAC82CA7396A68D541C85D26508E83_553108731.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_553108731;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPremiumRate = true;
            //premiumRate_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.238 -0400", hash_original_method = "3FC94E6C0EA4E13DD9DFC50367AE259A", hash_generated_method = "9CAACFB47A6EA6BCAF30F46B7441D969")
        public boolean hasSharedCost() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_694512749 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_694512749;
            // ---------- Original Method ----------
            //return hasSharedCost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.239 -0400", hash_original_method = "1FFB14D9D02DC30D3C5835101DD9BAF0", hash_generated_method = "1F40FF4F05ABE277511A9E9E02AD841C")
        public PhoneNumberDesc getSharedCost() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_685776444 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_685776444 = sharedCost_;
            varB4EAC82CA7396A68D541C85D26508E83_685776444.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_685776444;
            // ---------- Original Method ----------
            //return sharedCost_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.240 -0400", hash_original_method = "CDEC9E0DF29779C1B33ED334AA2CAB69", hash_generated_method = "31C438E2D40CA452BF86476C8BB84968")
        public PhoneMetadata setSharedCost(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_2130839493 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasSharedCost = true;
            sharedCost_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_2130839493 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2130839493.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2130839493;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasSharedCost = true;
            //sharedCost_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.250 -0400", hash_original_method = "0212D7D16A2BAA9CCCFC0F72E5660C30", hash_generated_method = "7BCA8B341BCB4093E0618B65FE92A4C8")
        public boolean hasPersonalNumber() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1641732748 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1641732748;
            // ---------- Original Method ----------
            //return hasPersonalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.251 -0400", hash_original_method = "4CF811D3746F6643A77AAC306D011902", hash_generated_method = "D09359631839A3E541F2927F8D3B8523")
        public PhoneNumberDesc getPersonalNumber() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1144245093 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1144245093 = personalNumber_;
            varB4EAC82CA7396A68D541C85D26508E83_1144245093.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1144245093;
            // ---------- Original Method ----------
            //return personalNumber_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.251 -0400", hash_original_method = "24493CAEB1946A8C79E7D00511D66307", hash_generated_method = "AA36A7AEA9CA059C4019FB439FF9944C")
        public PhoneMetadata setPersonalNumber(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_846560895 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPersonalNumber = true;
            personalNumber_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_846560895 = this;
            varB4EAC82CA7396A68D541C85D26508E83_846560895.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_846560895;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPersonalNumber = true;
            //personalNumber_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.252 -0400", hash_original_method = "96BC6C0B8CEC8C19A5CCD809DD7C636B", hash_generated_method = "64C828C45F7DE8EB3D9BC6D1D5EAA3D9")
        public boolean hasVoip() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_150034855 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_150034855;
            // ---------- Original Method ----------
            //return hasVoip;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.252 -0400", hash_original_method = "3E7A9D2F706E69069EF64F75DD5323E7", hash_generated_method = "E0899ADD1253F8EF4B634BE01A73550F")
        public PhoneNumberDesc getVoip() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1591756603 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1591756603 = voip_;
            varB4EAC82CA7396A68D541C85D26508E83_1591756603.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1591756603;
            // ---------- Original Method ----------
            //return voip_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.253 -0400", hash_original_method = "5FE2D757C727FFFD1EC6F29B7720BADF", hash_generated_method = "B41622160C3A16823BB7B9CD6DFA284F")
        public PhoneMetadata setVoip(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_236029172 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasVoip = true;
            voip_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_236029172 = this;
            varB4EAC82CA7396A68D541C85D26508E83_236029172.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_236029172;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasVoip = true;
            //voip_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.269 -0400", hash_original_method = "ACFB2D18067CB4D678DA99A9B4C18C84", hash_generated_method = "7648F313FB32A8058FE7E4D4B146EE63")
        public boolean hasPager() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1435709841 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1435709841;
            // ---------- Original Method ----------
            //return hasPager;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.269 -0400", hash_original_method = "C20F5AA8347238E1E9DA82F58997297F", hash_generated_method = "B064143B5B1F73DE0647B41A825E1D24")
        public PhoneNumberDesc getPager() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_242646859 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_242646859 = pager_;
            varB4EAC82CA7396A68D541C85D26508E83_242646859.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_242646859;
            // ---------- Original Method ----------
            //return pager_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.270 -0400", hash_original_method = "F7E7BD7CBC5C04503F79204D035D6093", hash_generated_method = "69B9D6ADF34729AE277B3008F6C689FA")
        public PhoneMetadata setPager(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1889395139 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPager = true;
            pager_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1889395139 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1889395139.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1889395139;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPager = true;
            //pager_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.270 -0400", hash_original_method = "7052BD1D22DD33A68E8BFBF8EF4C8D7C", hash_generated_method = "36ADEF3DC821D428B5E8050785A2663D")
        public boolean hasUan() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1243149629 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1243149629;
            // ---------- Original Method ----------
            //return hasUan;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.271 -0400", hash_original_method = "6E5CDB2B0554F6EDEAFB0A826808F837", hash_generated_method = "FC6861BD56B937D789209693C6029700")
        public PhoneNumberDesc getUan() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_503870356 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_503870356 = uan_;
            varB4EAC82CA7396A68D541C85D26508E83_503870356.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_503870356;
            // ---------- Original Method ----------
            //return uan_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.271 -0400", hash_original_method = "645A0026A31D8D600D28A5F0E2FCB775", hash_generated_method = "621ADF573EC2B9F06CF8F68701BB8A70")
        public PhoneMetadata setUan(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1521717722 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasUan = true;
            uan_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1521717722 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1521717722.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1521717722;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasUan = true;
            //uan_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.275 -0400", hash_original_method = "1D4CDC46AB20A45A27679F7FB2E14F5D", hash_generated_method = "87F6B8AADD183C3B8E7F9610C7B78058")
        public boolean hasNoInternationalDialling() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676564602 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676564602;
            // ---------- Original Method ----------
            //return hasNoInternationalDialling;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.276 -0400", hash_original_method = "8BF24E7280AB555752CDF0AB6293C8C0", hash_generated_method = "8495EC677EB1AB13FE09C58E7045371C")
        public PhoneNumberDesc getNoInternationalDialling() {
            PhoneNumberDesc varB4EAC82CA7396A68D541C85D26508E83_1587767257 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1587767257 = noInternationalDialling_;
            varB4EAC82CA7396A68D541C85D26508E83_1587767257.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1587767257;
            // ---------- Original Method ----------
            //return noInternationalDialling_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.280 -0400", hash_original_method = "7DCE821DB5B30DD48C6A3A37AA42A1FD", hash_generated_method = "368247CF3589C8A8F0CE7C644793D914")
        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_336921329 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasNoInternationalDialling = true;
            noInternationalDialling_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_336921329 = this;
            varB4EAC82CA7396A68D541C85D26508E83_336921329.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_336921329;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasNoInternationalDialling = true;
            //noInternationalDialling_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.284 -0400", hash_original_method = "4B670822089DE57CBF3DD8C644F8C3E5", hash_generated_method = "331EBBAA838A1C92B8964FEF023BE9C0")
        public boolean hasId() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_411820521 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_411820521;
            // ---------- Original Method ----------
            //return hasId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.288 -0400", hash_original_method = "C805C797DAF63B59CBD999295B2F5158", hash_generated_method = "120061A171AFE500EF490C7ECFB31650")
        public String getId() {
            String varB4EAC82CA7396A68D541C85D26508E83_872344482 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_872344482 = id_;
            varB4EAC82CA7396A68D541C85D26508E83_872344482.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_872344482;
            // ---------- Original Method ----------
            //return id_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.292 -0400", hash_original_method = "6B3AD7A8DB5994F94639D3A9A0778D2B", hash_generated_method = "61E628D9D1D27B0F5FB203006139ABEF")
        public PhoneMetadata setId(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1881402783 = null; //Variable for return #1
            hasId = true;
            id_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1881402783 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1881402783.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1881402783;
            // ---------- Original Method ----------
            //hasId = true;
            //id_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.292 -0400", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "A34CC3B59C014837DF0907495B655283")
        public boolean hasCountryCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627193756 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627193756;
            // ---------- Original Method ----------
            //return hasCountryCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.296 -0400", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "4E808883B397F942E6EACB54F9C6D746")
        public int getCountryCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354233847 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354233847;
            // ---------- Original Method ----------
            //return countryCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.297 -0400", hash_original_method = "1AB7F6532DA188CC62A13C45F2B9ADF3", hash_generated_method = "D37B82DC654C707EB3A0AC4E85F2F787")
        public PhoneMetadata setCountryCode(int value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_372861878 = null; //Variable for return #1
            hasCountryCode = true;
            countryCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_372861878 = this;
            varB4EAC82CA7396A68D541C85D26508E83_372861878.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_372861878;
            // ---------- Original Method ----------
            //hasCountryCode = true;
            //countryCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.297 -0400", hash_original_method = "B89BF9592A7F16BE6654C3883F9898E5", hash_generated_method = "971822325C2373B59FD7785AA93E6A36")
        public boolean hasInternationalPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677581311 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677581311;
            // ---------- Original Method ----------
            //return hasInternationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.297 -0400", hash_original_method = "09123B0A33DF502700CE0BB29A84EB95", hash_generated_method = "E92067BE4FA870F1943D1C2268F9FC0C")
        public String getInternationalPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_169311961 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_169311961 = internationalPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_169311961.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_169311961;
            // ---------- Original Method ----------
            //return internationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.308 -0400", hash_original_method = "3DE0D2253FD6A81DEABED2BF406E5650", hash_generated_method = "AABEA28BC301E5D59D29A5E6105B34A6")
        public PhoneMetadata setInternationalPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_633246583 = null; //Variable for return #1
            hasInternationalPrefix = true;
            internationalPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_633246583 = this;
            varB4EAC82CA7396A68D541C85D26508E83_633246583.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_633246583;
            // ---------- Original Method ----------
            //hasInternationalPrefix = true;
            //internationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.309 -0400", hash_original_method = "3A1D043D6BB606ABB758EEC975A83919", hash_generated_method = "5CFD99FF3A722EE1388D6246A9115C52")
        public boolean hasPreferredInternationalPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833636861 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_833636861;
            // ---------- Original Method ----------
            //return hasPreferredInternationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.309 -0400", hash_original_method = "3992DDBA34CC5C49CFC74CF0545FF343", hash_generated_method = "72935E80BBB22382E062043EEA7595A6")
        public String getPreferredInternationalPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_1650115590 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1650115590 = preferredInternationalPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_1650115590.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1650115590;
            // ---------- Original Method ----------
            //return preferredInternationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.310 -0400", hash_original_method = "2F2A95A6FC37FC6A654CD2ED9E105058", hash_generated_method = "DDEE0597A5BE90F05F77B79D0A5048D5")
        public PhoneMetadata setPreferredInternationalPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_2145100336 = null; //Variable for return #1
            hasPreferredInternationalPrefix = true;
            preferredInternationalPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_2145100336 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2145100336.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2145100336;
            // ---------- Original Method ----------
            //hasPreferredInternationalPrefix = true;
            //preferredInternationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.310 -0400", hash_original_method = "3FEC8563D97FEF0C0B81201609B8C138", hash_generated_method = "24561837E4191A1CB684FCCDCCFE17F0")
        public boolean hasNationalPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47521535 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_47521535;
            // ---------- Original Method ----------
            //return hasNationalPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.310 -0400", hash_original_method = "3F6DDEA7E91472B57F47F7AA42FF40A4", hash_generated_method = "74F58D8490377B533EF2546C27E46ADB")
        public String getNationalPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_558695425 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_558695425 = nationalPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_558695425.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_558695425;
            // ---------- Original Method ----------
            //return nationalPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.318 -0400", hash_original_method = "F24C638CA5CEB8CDF3416D52787AAB8D", hash_generated_method = "C114FDCC49DC679F906D85F55C456997")
        public PhoneMetadata setNationalPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_73603324 = null; //Variable for return #1
            hasNationalPrefix = true;
            nationalPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_73603324 = this;
            varB4EAC82CA7396A68D541C85D26508E83_73603324.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_73603324;
            // ---------- Original Method ----------
            //hasNationalPrefix = true;
            //nationalPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.318 -0400", hash_original_method = "E23165194A0E40A98A75B1CB3195C323", hash_generated_method = "9AD427149E2388C2EB80D2AA1D027AC3")
        public boolean hasPreferredExtnPrefix() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_165506029 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_165506029;
            // ---------- Original Method ----------
            //return hasPreferredExtnPrefix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.318 -0400", hash_original_method = "54C0428B3277F86E8CEE26D4467F5D32", hash_generated_method = "CC1E7C88C23C59FC4FB1EA31505394E3")
        public String getPreferredExtnPrefix() {
            String varB4EAC82CA7396A68D541C85D26508E83_1497936835 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1497936835 = preferredExtnPrefix_;
            varB4EAC82CA7396A68D541C85D26508E83_1497936835.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1497936835;
            // ---------- Original Method ----------
            //return preferredExtnPrefix_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.319 -0400", hash_original_method = "6AE031AAEF0021BEEE5C7C14D7E5ADEE", hash_generated_method = "CAFACE06C2362407A04DA8F041FB5EA0")
        public PhoneMetadata setPreferredExtnPrefix(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1066298369 = null; //Variable for return #1
            hasPreferredExtnPrefix = true;
            preferredExtnPrefix_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1066298369 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1066298369.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1066298369;
            // ---------- Original Method ----------
            //hasPreferredExtnPrefix = true;
            //preferredExtnPrefix_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.319 -0400", hash_original_method = "079D2F6BDFB9C83E975C341D5D3984E8", hash_generated_method = "250D0CC224046484F64AA1CD6F9D3A62")
        public boolean hasNationalPrefixForParsing() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423759129 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423759129;
            // ---------- Original Method ----------
            //return hasNationalPrefixForParsing;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.320 -0400", hash_original_method = "049975D1EC97C98DFAFD92CBA7A3DB4E", hash_generated_method = "66B0FE0F15869AD2411776DAFAB7FACF")
        public String getNationalPrefixForParsing() {
            String varB4EAC82CA7396A68D541C85D26508E83_1318157150 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1318157150 = nationalPrefixForParsing_;
            varB4EAC82CA7396A68D541C85D26508E83_1318157150.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1318157150;
            // ---------- Original Method ----------
            //return nationalPrefixForParsing_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.320 -0400", hash_original_method = "9C0BD3F3F0877996BC57F1866741042E", hash_generated_method = "22859AB7C1A865ECBB01E6A1FD9FFE4A")
        public PhoneMetadata setNationalPrefixForParsing(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_197150579 = null; //Variable for return #1
            hasNationalPrefixForParsing = true;
            nationalPrefixForParsing_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_197150579 = this;
            varB4EAC82CA7396A68D541C85D26508E83_197150579.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_197150579;
            // ---------- Original Method ----------
            //hasNationalPrefixForParsing = true;
            //nationalPrefixForParsing_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.320 -0400", hash_original_method = "1810BCBEB4974245D7BFFA09C69DD621", hash_generated_method = "FE914F3ABE7C7D621838C791B3DC163B")
        public boolean hasNationalPrefixTransformRule() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1504297537 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1504297537;
            // ---------- Original Method ----------
            //return hasNationalPrefixTransformRule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.325 -0400", hash_original_method = "55DE6447BA6383DE2B8CA08949083559", hash_generated_method = "EF1F3492336BA16904395F8434C0F8F6")
        public String getNationalPrefixTransformRule() {
            String varB4EAC82CA7396A68D541C85D26508E83_1753709607 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1753709607 = nationalPrefixTransformRule_;
            varB4EAC82CA7396A68D541C85D26508E83_1753709607.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1753709607;
            // ---------- Original Method ----------
            //return nationalPrefixTransformRule_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.331 -0400", hash_original_method = "F0F297723C8F168223FB62622F5A1EB6", hash_generated_method = "6CC8B95DA36C68490DE1BDE649BCC77E")
        public PhoneMetadata setNationalPrefixTransformRule(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1880620003 = null; //Variable for return #1
            hasNationalPrefixTransformRule = true;
            nationalPrefixTransformRule_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1880620003 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1880620003.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1880620003;
            // ---------- Original Method ----------
            //hasNationalPrefixTransformRule = true;
            //nationalPrefixTransformRule_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.331 -0400", hash_original_method = "23B7A16EBE621B68A999B8F98C32C7FC", hash_generated_method = "0C4ADAE443577F98307AFF7B48521F73")
        public boolean hasSameMobileAndFixedLinePattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1969368532 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1969368532;
            // ---------- Original Method ----------
            //return hasSameMobileAndFixedLinePattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.336 -0400", hash_original_method = "0C8ED851B6AE0A07DB69452573173B34", hash_generated_method = "B0DBA06A8944041D5D6665A8338BC962")
        public boolean isSameMobileAndFixedLinePattern() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2102318504 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2102318504;
            // ---------- Original Method ----------
            //return sameMobileAndFixedLinePattern_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.336 -0400", hash_original_method = "4899ADA62C5B2767C955044A6A730FDD", hash_generated_method = "CB4F82C9230022EB4EA60EC73D796782")
        public PhoneMetadata setSameMobileAndFixedLinePattern(boolean value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1783863706 = null; //Variable for return #1
            hasSameMobileAndFixedLinePattern = true;
            sameMobileAndFixedLinePattern_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1783863706 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1783863706.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1783863706;
            // ---------- Original Method ----------
            //hasSameMobileAndFixedLinePattern = true;
            //sameMobileAndFixedLinePattern_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.337 -0400", hash_original_method = "84A1634AEDD3ABF2CF1A3014B5D415EB", hash_generated_method = "E5E27DC667276D34C556794ABC67476C")
        public java.util.List<NumberFormat> numberFormats() {
            java.util.List<NumberFormat> varB4EAC82CA7396A68D541C85D26508E83_1052848721 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1052848721 = numberFormat_;
            varB4EAC82CA7396A68D541C85D26508E83_1052848721.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1052848721;
            // ---------- Original Method ----------
            //return numberFormat_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.337 -0400", hash_original_method = "926251D4CC15A970A4459B1AE98E21C5", hash_generated_method = "6F66C1B4E552C5F933381911821B0F0D")
        public int numberFormatSize() {
            int var96E94CB08F0191048A027A706C30A965_605226230 = (numberFormat_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014671241 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014671241;
            // ---------- Original Method ----------
            //return numberFormat_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.339 -0400", hash_original_method = "A540DB640DF9F8195853729D5B88BC06", hash_generated_method = "F8F9D549E3A5C9E030CD2AB64DC7CB43")
        public NumberFormat getNumberFormat(int index) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_52149679 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_52149679 = numberFormat_.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_52149679.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_52149679;
            // ---------- Original Method ----------
            //return numberFormat_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.339 -0400", hash_original_method = "6431B417B09BF16DE184C0BF7BFD8C0A", hash_generated_method = "114AE4234126DBD337F495948243C642")
        public PhoneMetadata addNumberFormat(NumberFormat value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1757811963 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            numberFormat_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_1757811963 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1757811963.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1757811963;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //numberFormat_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.340 -0400", hash_original_method = "AE158E1AC846181939D70DB177BF740E", hash_generated_method = "E96BC13E22822DA2AFB4CB5088C5ACAD")
        public java.util.List<NumberFormat> intlNumberFormats() {
            java.util.List<NumberFormat> varB4EAC82CA7396A68D541C85D26508E83_541450257 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_541450257 = intlNumberFormat_;
            varB4EAC82CA7396A68D541C85D26508E83_541450257.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_541450257;
            // ---------- Original Method ----------
            //return intlNumberFormat_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.340 -0400", hash_original_method = "58F2978D59C0EB64F45AEE8E7A3A3ECF", hash_generated_method = "1292ACD27906CC0EAA253F9E621C9698")
        public int intlNumberFormatSize() {
            int varF47E20D9CBB1855464C7D9F5EA17F55A_1636086243 = (intlNumberFormat_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810792229 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810792229;
            // ---------- Original Method ----------
            //return intlNumberFormat_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.350 -0400", hash_original_method = "14BAA3A4AA80C468A085BC9B63542EE0", hash_generated_method = "F8DA8242D22D0F61F7E05A5569E0CFB4")
        public NumberFormat getIntlNumberFormat(int index) {
            NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1120399298 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1120399298 = intlNumberFormat_.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1120399298.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1120399298;
            // ---------- Original Method ----------
            //return intlNumberFormat_.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.351 -0400", hash_original_method = "DDE7F201B8001F4279DAEE9969BC3EF9", hash_generated_method = "276776AE47DF5BBF0FC56E3835AA5B74")
        public PhoneMetadata addIntlNumberFormat(NumberFormat value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1754557052 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            intlNumberFormat_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_1754557052 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1754557052.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1754557052;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //intlNumberFormat_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.351 -0400", hash_original_method = "C1C6B471737DB86E719E8005B048F8A4", hash_generated_method = "E0A7516502C50C3C62235AB1A7EEA917")
        public PhoneMetadata clearIntlNumberFormat() {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_493046876 = null; //Variable for return #1
            intlNumberFormat_.clear();
            varB4EAC82CA7396A68D541C85D26508E83_493046876 = this;
            varB4EAC82CA7396A68D541C85D26508E83_493046876.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_493046876;
            // ---------- Original Method ----------
            //intlNumberFormat_.clear();
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.352 -0400", hash_original_method = "F0A3F725FE27520DECCABEEE1451ABF4", hash_generated_method = "8EA55454F0B30E2C148E6AA68EED0D35")
        public boolean hasMainCountryForCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1546198683 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1546198683;
            // ---------- Original Method ----------
            //return hasMainCountryForCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.352 -0400", hash_original_method = "CF03E78162809AA6058F20CA8B82C717", hash_generated_method = "C8BD99CE68841267FF9B01D8507DDAE3")
        public boolean isMainCountryForCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_469616787 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_469616787;
            // ---------- Original Method ----------
            //return mainCountryForCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.352 -0400", hash_original_method = "8B579A48BF103BAE8E5F2D34ABF5A62F", hash_generated_method = "428EC852165E851D5B512B9E31E46246")
        public boolean getMainCountryForCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568302723 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_568302723;
            // ---------- Original Method ----------
            //return mainCountryForCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.356 -0400", hash_original_method = "0E977089CAAEFAD04CCCDA9E72421381", hash_generated_method = "D60227F499280B8D862DBB9E6F083AFA")
        public PhoneMetadata setMainCountryForCode(boolean value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_703288478 = null; //Variable for return #1
            hasMainCountryForCode = true;
            mainCountryForCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_703288478 = this;
            varB4EAC82CA7396A68D541C85D26508E83_703288478.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_703288478;
            // ---------- Original Method ----------
            //hasMainCountryForCode = true;
            //mainCountryForCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.359 -0400", hash_original_method = "46DBCF13AB23890B1C354034C02AAE0D", hash_generated_method = "67CF43849D619EC28AB37BFA9C5E4F87")
        public boolean hasLeadingDigits() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1126325253 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1126325253;
            // ---------- Original Method ----------
            //return hasLeadingDigits;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.359 -0400", hash_original_method = "BA0CBA2DFD34C6F845467DDF3F7503AD", hash_generated_method = "7D0D1AF155A9FF3EFF02A689A132195F")
        public String getLeadingDigits() {
            String varB4EAC82CA7396A68D541C85D26508E83_1876132644 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1876132644 = leadingDigits_;
            varB4EAC82CA7396A68D541C85D26508E83_1876132644.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1876132644;
            // ---------- Original Method ----------
            //return leadingDigits_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.369 -0400", hash_original_method = "1B8095B1499A1300CC7FD6395528DFB9", hash_generated_method = "A042D1E87C3C74D3091E43AB18B4AE29")
        public PhoneMetadata setLeadingDigits(String value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1847118808 = null; //Variable for return #1
            hasLeadingDigits = true;
            leadingDigits_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1847118808 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1847118808.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1847118808;
            // ---------- Original Method ----------
            //hasLeadingDigits = true;
            //leadingDigits_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.370 -0400", hash_original_method = "DF6824D9CE520B4AB88B3980F12D84DC", hash_generated_method = "9414E848A227B339FE23870505535D9D")
        public boolean hasLeadingZeroPossible() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1974557507 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1974557507;
            // ---------- Original Method ----------
            //return hasLeadingZeroPossible;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.373 -0400", hash_original_method = "9CE4681262676BB262003F306366B26D", hash_generated_method = "019DB3909726290DD6A430BD407C9B47")
        public boolean isLeadingZeroPossible() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16435195 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_16435195;
            // ---------- Original Method ----------
            //return leadingZeroPossible_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.374 -0400", hash_original_method = "4E51759A218DB37A00D6735D1891D88D", hash_generated_method = "9331127AC7E436FD3DEA7FF48C7718E9")
        public PhoneMetadata setLeadingZeroPossible(boolean value) {
            PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_1131720723 = null; //Variable for return #1
            hasLeadingZeroPossible = true;
            leadingZeroPossible_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1131720723 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1131720723.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1131720723;
            // ---------- Original Method ----------
            //hasLeadingZeroPossible = true;
            //leadingZeroPossible_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.383 -0400", hash_original_method = "82C82662DE792F1D24D935E7D9A568AC", hash_generated_method = "4B4C11553F61CB049BA33753177F93B1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.398 -0400", hash_original_method = "4D891D3CC56C8A4A25C2FA3B62E66106", hash_generated_method = "FFAB874FB59699E9BA9DAED22AD13B61")
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.398 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.408 -0400", hash_original_method = "FECA3DB69AA5738CC513C59EB359D04E", hash_generated_method = "F511E76A659749EE179C283FDB2F66D4")
            public PhoneMetadata build() {
                PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_216119837 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_216119837 = this;
                varB4EAC82CA7396A68D541C85D26508E83_216119837.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_216119837;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.408 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "DF26AFCCBB9DDCFC72C78DA996786C5E")

        private static long serialVersionUID = 1;
    }


    
    public static class PhoneMetadataCollection implements Externalizable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.409 -0400", hash_original_field = "612BD1F5CEECC04CA1A32C585074C146", hash_generated_field = "3988CF3B3569C765826A81A610C2CFA8")

        private java.util.List<PhoneMetadata> metadata_ = new java.util.ArrayList<PhoneMetadata>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.409 -0400", hash_original_method = "833FEC11FB1A703522FFE165412E2F7D", hash_generated_method = "911AB4D46731349730F9522D952A81AB")
        public  PhoneMetadataCollection() {
            // ---------- Original Method ----------
        }

        
                public static Builder newBuilder() {
            return new Builder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.414 -0400", hash_original_method = "C5ECD645F70FA9D5A2A9EB8CBA32ADEF", hash_generated_method = "33D39FD7090C04F76F7EFCD03A7BBE71")
        public java.util.List<PhoneMetadata> getMetadataList() {
            java.util.List<PhoneMetadata> varB4EAC82CA7396A68D541C85D26508E83_563001417 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_563001417 = metadata_;
            varB4EAC82CA7396A68D541C85D26508E83_563001417.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_563001417;
            // ---------- Original Method ----------
            //return metadata_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.415 -0400", hash_original_method = "95419ED058599C84B2A0103C5C8B3F30", hash_generated_method = "3F4E6B5E9CBEA4139D0EC0C2851D67C2")
        public int getMetadataCount() {
            int varE8225671ABD39B7016D6383C297CDF20_450392937 = (metadata_.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_416882701 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_416882701;
            // ---------- Original Method ----------
            //return metadata_.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.415 -0400", hash_original_method = "D57D52560347164C8871C87ACF1DAD2C", hash_generated_method = "9CFBF3760127750829598222BFA13AFB")
        public PhoneMetadataCollection addMetadata(PhoneMetadata value) {
            PhoneMetadataCollection varB4EAC82CA7396A68D541C85D26508E83_53073722 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            metadata_.add(value);
            varB4EAC82CA7396A68D541C85D26508E83_53073722 = this;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_53073722.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_53073722;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //metadata_.add(value);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.416 -0400", hash_original_method = "BDFB00F39A05DC0D50872248169D293E", hash_generated_method = "8A22B371CAAC2734BD56545531F3D47B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.418 -0400", hash_original_method = "FAC331B8B6AD54634EE3CFAA3149ADF1", hash_generated_method = "31041E417F0CE63C3D8095D4561B120E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.422 -0400", hash_original_method = "1BB2E7D611D4F26F7F8136F4B2C1D585", hash_generated_method = "D8B5BF7B8E0E78FE878CA8DE95662FB7")
        public PhoneMetadataCollection clear() {
            PhoneMetadataCollection varB4EAC82CA7396A68D541C85D26508E83_822104171 = null; //Variable for return #1
            metadata_.clear();
            varB4EAC82CA7396A68D541C85D26508E83_822104171 = this;
            varB4EAC82CA7396A68D541C85D26508E83_822104171.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_822104171;
            // ---------- Original Method ----------
            //metadata_.clear();
            //return this;
        }

        
        public static final class Builder extends PhoneMetadataCollection {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.422 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.429 -0400", hash_original_method = "62075F60ED3DD2393D61C900D272662C", hash_generated_method = "6CDF70328B6D19AC6D7251725682B6CC")
            public PhoneMetadataCollection build() {
                PhoneMetadataCollection varB4EAC82CA7396A68D541C85D26508E83_151237671 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_151237671 = this;
                varB4EAC82CA7396A68D541C85D26508E83_151237671.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_151237671;
                // ---------- Original Method ----------
                //return this;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.429 -0400", hash_original_field = "49D3E8B4A20F6381D83D3C32A4AD65C8", hash_generated_field = "DF26AFCCBB9DDCFC72C78DA996786C5E")

        private static long serialVersionUID = 1;
    }


    
}

