package com.android.i18n.phonenumbers;

// Droidsafe Imports
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class Phonenumber {
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.354 -0400", hash_original_method = "9F0C69719EBF6B458992D61E4BCC90E8", hash_generated_method = "5CB1D98A4150FC5519010EC189B4C107")
    private  Phonenumber() {
        // ---------- Original Method ----------
    }

    
    public static class PhoneNumber implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.354 -0400", hash_original_field = "8DA9382CFAB6A2934FA5AD3C46617F89", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

        private boolean hasCountryCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.354 -0400", hash_original_field = "3461D01D5A7F32E3FA9B229113397711", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

        private int countryCode_ = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.354 -0400", hash_original_field = "BEF2FB3011A67ABE2750EE20B94BCF1B", hash_generated_field = "B31B8035F727A8BE2916E64EBF4F38BF")

        private boolean hasNationalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.354 -0400", hash_original_field = "2FE6622A7CBF4A37DA0EE3F97AFD3C1A", hash_generated_field = "861F5C609F3E4BA70615CE11EE4F3E7C")

        private long nationalNumber_ = 0L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.354 -0400", hash_original_field = "E8BF8AD5CF623306E4137F929A4B793C", hash_generated_field = "358E6375D13B5162BE1A3016216C10C6")

        private boolean hasExtension;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.354 -0400", hash_original_field = "BABEC9AFE089768EADBB1770DB6C73E0", hash_generated_field = "6640D7D6CB57D7D20313E3325CD1FB22")

        private java.lang.String extension_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.354 -0400", hash_original_field = "9A3A483658C79E793F495FF31A1A2719", hash_generated_field = "3F85D89FA25AF2B45530E00802BDAF23")

        private boolean hasItalianLeadingZero;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.354 -0400", hash_original_field = "BA6B94B60539B119EFEF2AF2F66C2C0F", hash_generated_field = "D7F0554114A7FE26069B675ED8151AC1")

        private boolean italianLeadingZero_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.354 -0400", hash_original_field = "E04C31A797660EF69743A4E81B09F98E", hash_generated_field = "C4DB1F876DD23BC8A14CC9C5A337EE0B")

        private boolean hasRawInput;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.355 -0400", hash_original_field = "DA7C30298E9E640F6E99799BCA546A44", hash_generated_field = "1CA91139B304F5C069E8FEFEEC7BDADA")

        private String rawInput_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.355 -0400", hash_original_field = "AF071B11070C28DD45E4F04A2EAC9FD9", hash_generated_field = "F0FD53E6932AA94BEF89B80DE8FBB48A")

        private boolean hasCountryCodeSource;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.355 -0400", hash_original_field = "15078F02FD915A57AC4033865D7BD527", hash_generated_field = "726423546266BF59E9D4D30E8DF8603B")

        private CountryCodeSource countryCodeSource_;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.355 -0400", hash_original_field = "875F08A1E2A43A5348B38BFC578F2335", hash_generated_field = "7A3961A3D14D61159606E8AEE7AE90AE")

        private boolean hasPreferredDomesticCarrierCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.355 -0400", hash_original_field = "2939A13320742DC344097CB116D7C987", hash_generated_field = "30C4AF8975E517B81211F0AB34A0B954")

        private java.lang.String preferredDomesticCarrierCode_ = "";
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.356 -0400", hash_original_method = "BC3E0739FB67F4B1E9E07E3377CC422E", hash_generated_method = "82E1ACB1E508CA9B7F2766C0989401DD")
        public  PhoneNumber() {
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            // ---------- Original Method ----------
            //countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.356 -0400", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "3B66B276C8609990FD90AD3A15B11E80")
        public boolean hasCountryCode() {
            boolean var8DA9382CFAB6A2934FA5AD3C46617F89_1006440283 = (hasCountryCode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633561521 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_633561521;
            // ---------- Original Method ----------
            //return hasCountryCode;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.356 -0400", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "E96405BF2AF7BC831EDB271CA0613031")
        public int getCountryCode() {
            int var3C5B11B8C2E2EEFEFDB13FA162E1622D_1803182958 = (countryCode_);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353077718 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353077718;
            // ---------- Original Method ----------
            //return countryCode_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.357 -0400", hash_original_method = "231BDC2ACAA546410AD99483D572C314", hash_generated_method = "27AA1EA7868576EF341FB583DA48C9B3")
        public PhoneNumber setCountryCode(int value) {
            hasCountryCode = true;
            countryCode_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_895208489 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_895208489.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_895208489;
            // ---------- Original Method ----------
            //hasCountryCode = true;
            //countryCode_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.357 -0400", hash_original_method = "F3480C339E6576F38870C4A8107DC432", hash_generated_method = "574E2DB384724FB5976AFCCA8B28C6C9")
        public PhoneNumber clearCountryCode() {
            hasCountryCode = false;
            countryCode_ = 0;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_2020887712 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2020887712.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2020887712;
            // ---------- Original Method ----------
            //hasCountryCode = false;
            //countryCode_ = 0;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.358 -0400", hash_original_method = "9E5DD8721DB5E6B4EA37D3D3DF3C82B6", hash_generated_method = "147F20EE5B6E8A997B44F92657142AF0")
        public boolean hasNationalNumber() {
            boolean varBEF2FB3011A67ABE2750EE20B94BCF1B_896323295 = (hasNationalNumber);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44140202 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_44140202;
            // ---------- Original Method ----------
            //return hasNationalNumber;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.358 -0400", hash_original_method = "6637472029560B21624D3926379C2007", hash_generated_method = "6A2A09EF894295A500929FF6574E7316")
        public long getNationalNumber() {
            long var6F698002E19497D272F47EBD21C1CE81_1116202228 = (nationalNumber_);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_314099121 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_314099121;
            // ---------- Original Method ----------
            //return nationalNumber_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.358 -0400", hash_original_method = "6A535B2D70F0F9B1A2B7BD33E2B75251", hash_generated_method = "E7C3A5A34E98C921D963A174033DD89A")
        public PhoneNumber setNationalNumber(long value) {
            hasNationalNumber = true;
            nationalNumber_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_762168800 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_762168800.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_762168800;
            // ---------- Original Method ----------
            //hasNationalNumber = true;
            //nationalNumber_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.359 -0400", hash_original_method = "805285A190D17B224561E5C065A4AB00", hash_generated_method = "CD055AF6C921ACC3FDB016EA58B9EFB0")
        public PhoneNumber clearNationalNumber() {
            hasNationalNumber = false;
            nationalNumber_ = 0L;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1656021569 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1656021569.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1656021569;
            // ---------- Original Method ----------
            //hasNationalNumber = false;
            //nationalNumber_ = 0L;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.359 -0400", hash_original_method = "66338EE760653FB7826716BD4179F0EB", hash_generated_method = "20757DDEB33482F8C891516794359F21")
        public boolean hasExtension() {
            boolean varE8BF8AD5CF623306E4137F929A4B793C_187641706 = (hasExtension);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659289192 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_659289192;
            // ---------- Original Method ----------
            //return hasExtension;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.360 -0400", hash_original_method = "F04D3A8DBD1CCF0248A759BF39EDDDEC", hash_generated_method = "9E55552F342BBCFA963ECCCB6A86AAFB")
        public String getExtension() {
String var637C5A1C83AAF573761C4AF8FC11C30A_1132074393 =             extension_;
            var637C5A1C83AAF573761C4AF8FC11C30A_1132074393.addTaint(taint);
            return var637C5A1C83AAF573761C4AF8FC11C30A_1132074393;
            // ---------- Original Method ----------
            //return extension_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.360 -0400", hash_original_method = "38A692624EA50F65C5AAF1C27A4F1E79", hash_generated_method = "0315FFE49587F9C61753792BEFACD1A8")
        public PhoneNumber setExtension(String value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1011745467 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1011745467.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1011745467;
            } //End block
            hasExtension = true;
            extension_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_237676595 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_237676595.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_237676595;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasExtension = true;
            //extension_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.361 -0400", hash_original_method = "831C8D6965C7D5091D9400B8A1911F63", hash_generated_method = "0FEAE278ECEBB727F8E576B79DE04386")
        public PhoneNumber clearExtension() {
            hasExtension = false;
            extension_ = "";
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_802120029 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_802120029.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_802120029;
            // ---------- Original Method ----------
            //hasExtension = false;
            //extension_ = "";
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.361 -0400", hash_original_method = "297A117AFD1E548B3AE9E987C5DEDB53", hash_generated_method = "5B983E8C9913AE1240F1EDB5735EE4C0")
        public boolean hasItalianLeadingZero() {
            boolean var9A3A483658C79E793F495FF31A1A2719_448639744 = (hasItalianLeadingZero);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731953371 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731953371;
            // ---------- Original Method ----------
            //return hasItalianLeadingZero;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.361 -0400", hash_original_method = "B0BA7A66148037C7B1A35A6061ECB1A6", hash_generated_method = "B88D430BDD50E515D5D1AE70634B4FF6")
        public boolean isItalianLeadingZero() {
            boolean varE14A1BCA7348187626B366BB2C6D2119_655978163 = (italianLeadingZero_);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211504705 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211504705;
            // ---------- Original Method ----------
            //return italianLeadingZero_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.362 -0400", hash_original_method = "5FB07870F4A15DEE8F66E77590B141DD", hash_generated_method = "BF0B2D33937C37EB7C2F6714C64BD2EC")
        public PhoneNumber setItalianLeadingZero(boolean value) {
            hasItalianLeadingZero = true;
            italianLeadingZero_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1153165242 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1153165242.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1153165242;
            // ---------- Original Method ----------
            //hasItalianLeadingZero = true;
            //italianLeadingZero_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.362 -0400", hash_original_method = "55D33A5E10AF87EF82FB6277592BFD48", hash_generated_method = "69A90F53F5F03CD003D5E471792F9266")
        public PhoneNumber clearItalianLeadingZero() {
            hasItalianLeadingZero = false;
            italianLeadingZero_ = false;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_29477421 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_29477421.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_29477421;
            // ---------- Original Method ----------
            //hasItalianLeadingZero = false;
            //italianLeadingZero_ = false;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.362 -0400", hash_original_method = "FC01A3A255BE4F11BA51CD36FFDCBB37", hash_generated_method = "A3853C065CE98D45F67DE30B1AE49D8F")
        public boolean hasRawInput() {
            boolean varE04C31A797660EF69743A4E81B09F98E_1193974589 = (hasRawInput);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217378790 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_217378790;
            // ---------- Original Method ----------
            //return hasRawInput;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.363 -0400", hash_original_method = "F6017E34CFBABE539ED487A19641D13D", hash_generated_method = "178BC2682028496661851D7D214C58BA")
        public String getRawInput() {
String var86CB54FEF5E218064706500C9F7D92A9_1367470459 =             rawInput_;
            var86CB54FEF5E218064706500C9F7D92A9_1367470459.addTaint(taint);
            return var86CB54FEF5E218064706500C9F7D92A9_1367470459;
            // ---------- Original Method ----------
            //return rawInput_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.363 -0400", hash_original_method = "1DF89DBF221798F84EE73F6641D85CA9", hash_generated_method = "6226A8BC06CBA673ABE8E865E50BA969")
        public PhoneNumber setRawInput(String value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1778678505 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1778678505.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1778678505;
            } //End block
            hasRawInput = true;
            rawInput_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_2031699433 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2031699433.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2031699433;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasRawInput = true;
            //rawInput_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.364 -0400", hash_original_method = "090A68BA48513AA6167B14B8C7E5B538", hash_generated_method = "BE81BD475095DBBB8DD2084E7CCCA203")
        public PhoneNumber clearRawInput() {
            hasRawInput = false;
            rawInput_ = "";
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_269902820 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_269902820.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_269902820;
            // ---------- Original Method ----------
            //hasRawInput = false;
            //rawInput_ = "";
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.364 -0400", hash_original_method = "49E6B213C7CF699A88721EC66ED6A85C", hash_generated_method = "7813B1B986487B42E64FF9A9FC8D0BF1")
        public boolean hasCountryCodeSource() {
            boolean varAF071B11070C28DD45E4F04A2EAC9FD9_1380679983 = (hasCountryCodeSource);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1265629097 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1265629097;
            // ---------- Original Method ----------
            //return hasCountryCodeSource;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.364 -0400", hash_original_method = "EC13D38EB752707A5D37EF84821B18F3", hash_generated_method = "68B827198BC0457443EDD6AC50823B83")
        public CountryCodeSource getCountryCodeSource() {
CountryCodeSource var0A93FE3B5880D72246BECF6597030055_1581570290 =             countryCodeSource_;
            var0A93FE3B5880D72246BECF6597030055_1581570290.addTaint(taint);
            return var0A93FE3B5880D72246BECF6597030055_1581570290;
            // ---------- Original Method ----------
            //return countryCodeSource_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.364 -0400", hash_original_method = "4C681F77FE4C34506AE7929BB9F5DB5B", hash_generated_method = "21A1F6714E50EB3F3C28571C813D7218")
        public PhoneNumber setCountryCodeSource(CountryCodeSource value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_225727240 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_225727240.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_225727240;
            } //End block
            hasCountryCodeSource = true;
            countryCodeSource_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_297922532 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_297922532.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_297922532;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasCountryCodeSource = true;
            //countryCodeSource_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.364 -0400", hash_original_method = "AD210C1FCCDAAC9D9B6A95A61CE920CC", hash_generated_method = "269E946BCB753605E08D428370460A6B")
        public PhoneNumber clearCountryCodeSource() {
            hasCountryCodeSource = false;
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_187648429 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_187648429.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_187648429;
            // ---------- Original Method ----------
            //hasCountryCodeSource = false;
            //countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.364 -0400", hash_original_method = "8350C830C26B7D092EEEE9A503A10DA0", hash_generated_method = "F72A12FE343B9C03F58349B5721C2230")
        public boolean hasPreferredDomesticCarrierCode() {
            boolean var875F08A1E2A43A5348B38BFC578F2335_1884767105 = (hasPreferredDomesticCarrierCode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578419580 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578419580;
            // ---------- Original Method ----------
            //return hasPreferredDomesticCarrierCode;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.364 -0400", hash_original_method = "47CB8521CF67D388DB30B3F811726252", hash_generated_method = "E050E12B433245F46730737CF5E4382D")
        public String getPreferredDomesticCarrierCode() {
String var7A97AC82E2980E5270FD81B0B7EF0B7B_1516117177 =             preferredDomesticCarrierCode_;
            var7A97AC82E2980E5270FD81B0B7EF0B7B_1516117177.addTaint(taint);
            return var7A97AC82E2980E5270FD81B0B7EF0B7B_1516117177;
            // ---------- Original Method ----------
            //return preferredDomesticCarrierCode_;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.364 -0400", hash_original_method = "41BB5D81F1B0279F583403646A2042B9", hash_generated_method = "A248CFEFA111B063BD2430A48B3C97C9")
        public PhoneNumber setPreferredDomesticCarrierCode(String value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1567474593 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1567474593.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1567474593;
            } //End block
            hasPreferredDomesticCarrierCode = true;
            preferredDomesticCarrierCode_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_56516468 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_56516468.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_56516468;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPreferredDomesticCarrierCode = true;
            //preferredDomesticCarrierCode_ = value;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.365 -0400", hash_original_method = "26AD27D6AD8CEDC77B768F25CC124964", hash_generated_method = "AD6E681C68D7F1D0F61E5E6ED9AA2625")
        public PhoneNumber clearPreferredDomesticCarrierCode() {
            hasPreferredDomesticCarrierCode = false;
            preferredDomesticCarrierCode_ = "";
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1432240611 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1432240611.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1432240611;
            // ---------- Original Method ----------
            //hasPreferredDomesticCarrierCode = false;
            //preferredDomesticCarrierCode_ = "";
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.365 -0400", hash_original_method = "9E3F334A53F42C22EC58969EE12FFC06", hash_generated_method = "0F65CFE8EF91A1576BC2B339834DCC8E")
        public final PhoneNumber clear() {
            clearCountryCode();
            clearNationalNumber();
            clearExtension();
            clearItalianLeadingZero();
            clearRawInput();
            clearCountryCodeSource();
            clearPreferredDomesticCarrierCode();
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_2112003817 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2112003817.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2112003817;
            // ---------- Original Method ----------
            //clearCountryCode();
            //clearNationalNumber();
            //clearExtension();
            //clearItalianLeadingZero();
            //clearRawInput();
            //clearCountryCodeSource();
            //clearPreferredDomesticCarrierCode();
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.365 -0400", hash_original_method = "0AFF34EE20E5281E0E8704C233C4A6C7", hash_generated_method = "DA511D9763FD6A7F58AD430FD6AC6EEB")
        public PhoneNumber mergeFrom(PhoneNumber other) {
            addTaint(other.getTaint());
            if(other.hasCountryCode())            
            {
                setCountryCode(other.getCountryCode());
            } //End block
            if(other.hasNationalNumber())            
            {
                setNationalNumber(other.getNationalNumber());
            } //End block
            if(other.hasExtension())            
            {
                setExtension(other.getExtension());
            } //End block
            if(other.hasItalianLeadingZero())            
            {
                setItalianLeadingZero(other.isItalianLeadingZero());
            } //End block
            if(other.hasRawInput())            
            {
                setRawInput(other.getRawInput());
            } //End block
            if(other.hasCountryCodeSource())            
            {
                setCountryCodeSource(other.getCountryCodeSource());
            } //End block
            if(other.hasPreferredDomesticCarrierCode())            
            {
                setPreferredDomesticCarrierCode(other.getPreferredDomesticCarrierCode());
            } //End block
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_469993664 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_469993664.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_469993664;
            // ---------- Original Method ----------
            //if (other.hasCountryCode()) {
        //setCountryCode(other.getCountryCode());
      //}
            //if (other.hasNationalNumber()) {
        //setNationalNumber(other.getNationalNumber());
      //}
            //if (other.hasExtension()) {
        //setExtension(other.getExtension());
      //}
            //if (other.hasItalianLeadingZero()) {
        //setItalianLeadingZero(other.isItalianLeadingZero());
      //}
            //if (other.hasRawInput()) {
        //setRawInput(other.getRawInput());
      //}
            //if (other.hasCountryCodeSource()) {
        //setCountryCodeSource(other.getCountryCodeSource());
      //}
            //if (other.hasPreferredDomesticCarrierCode()) {
        //setPreferredDomesticCarrierCode(other.getPreferredDomesticCarrierCode());
      //}
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.365 -0400", hash_original_method = "DE1C4B1DD2D8C57C4042DF1B529C7D4D", hash_generated_method = "13B7C6A004AC6E3029F347F4AFA2336E")
        public boolean exactlySameAs(PhoneNumber other) {
            addTaint(other.getTaint());
            if(other == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1081295955 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_945158907 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_945158907;
            } //End block
            if(this == other)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1013080776 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1536444926 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1536444926;
            } //End block
            boolean var2259DE569DFFDDB7AE6A944847ED320F_856604140 = ((countryCode_ == other.countryCode_ && nationalNumber_ == other.nationalNumber_ &&
          extension_.equals(other.extension_) && italianLeadingZero_ == other.italianLeadingZero_ &&
          rawInput_.equals(other.rawInput_) && countryCodeSource_ == other.countryCodeSource_ &&
          preferredDomesticCarrierCode_.equals(other.preferredDomesticCarrierCode_) &&
          hasPreferredDomesticCarrierCode() == other.hasPreferredDomesticCarrierCode()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047497243 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047497243;
            // ---------- Original Method ----------
            //if (other == null) {
        //return false;
      //}
            //if (this == other) {
        //return true;
      //}
            //return (countryCode_ == other.countryCode_ && nationalNumber_ == other.nationalNumber_ &&
          //extension_.equals(other.extension_) && italianLeadingZero_ == other.italianLeadingZero_ &&
          //rawInput_.equals(other.rawInput_) && countryCodeSource_ == other.countryCodeSource_ &&
          //preferredDomesticCarrierCode_.equals(other.preferredDomesticCarrierCode_) &&
          //hasPreferredDomesticCarrierCode() == other.hasPreferredDomesticCarrierCode());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.366 -0400", hash_original_method = "EF0E3A387E8AEF6EC396B951EC1536A9", hash_generated_method = "0D743F5443BA2A8360352246E921F18B")
        @Override
        public boolean equals(Object that) {
            addTaint(that.getTaint());
            boolean varA0C1DA9A16D8865D89C78B991DC254B0_1360970046 = ((that instanceof PhoneNumber) && exactlySameAs((PhoneNumber) that));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_571366157 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_571366157;
            // ---------- Original Method ----------
            //return (that instanceof PhoneNumber) && exactlySameAs((PhoneNumber) that);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.366 -0400", hash_original_method = "F1BB2EE5D9E77C138CA0D6B9F17756FB", hash_generated_method = "8044F7CA18DE2D88E8D0B0DC5139A529")
        @Override
        public int hashCode() {
            int hash = 41;
            hash = (53 * hash) + getCountryCode();
            hash = (53 * hash) + Long.valueOf(getNationalNumber()).hashCode();
            hash = (53 * hash) + getExtension().hashCode();
            hash = (53 * hash) + (isItalianLeadingZero() ? 1231 : 1237);
            hash = (53 * hash) + getRawInput().hashCode();
            hash = (53 * hash) + getCountryCodeSource().hashCode();
            hash = (53 * hash) + getPreferredDomesticCarrierCode().hashCode();
            hash = (53 * hash) + (hasPreferredDomesticCarrierCode() ? 1231 : 1237);
            int var0800FC577294C34E0B28AD2839435945_303580121 = (hash);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_582357958 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_582357958;
            // ---------- Original Method ----------
            //int hash = 41;
            //hash = (53 * hash) + getCountryCode();
            //hash = (53 * hash) + Long.valueOf(getNationalNumber()).hashCode();
            //hash = (53 * hash) + getExtension().hashCode();
            //hash = (53 * hash) + (isItalianLeadingZero() ? 1231 : 1237);
            //hash = (53 * hash) + getRawInput().hashCode();
            //hash = (53 * hash) + getCountryCodeSource().hashCode();
            //hash = (53 * hash) + getPreferredDomesticCarrierCode().hashCode();
            //hash = (53 * hash) + (hasPreferredDomesticCarrierCode() ? 1231 : 1237);
            //return hash;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.367 -0400", hash_original_method = "16D1E3F084AA1063C11CF7C5BDA5DD45", hash_generated_method = "37EAF9C8F0CCCF32623ABFEDD24E8291")
        @Override
        public String toString() {
            StringBuilder outputString = new StringBuilder();
            outputString.append("Country Code: ").append(countryCode_);
            outputString.append(" National Number: ").append(nationalNumber_);
            if(hasItalianLeadingZero() && isItalianLeadingZero())            
            {
                outputString.append(" Leading Zero: true");
            } //End block
            if(hasExtension())            
            {
                outputString.append(" Extension: ").append(extension_);
            } //End block
            if(hasCountryCodeSource())            
            {
                outputString.append(" Country Code Source: ").append(countryCodeSource_);
            } //End block
            if(hasPreferredDomesticCarrierCode())            
            {
                outputString.append(" Preferred Domestic Carrier Code: ").
            append(preferredDomesticCarrierCode_);
            } //End block
String varF9C77AD1D66AAC2CCF21F4FFED2F9F68_441001113 =             outputString.toString();
            varF9C77AD1D66AAC2CCF21F4FFED2F9F68_441001113.addTaint(taint);
            return varF9C77AD1D66AAC2CCF21F4FFED2F9F68_441001113;
            // ---------- Original Method ----------
            //StringBuilder outputString = new StringBuilder();
            //outputString.append("Country Code: ").append(countryCode_);
            //outputString.append(" National Number: ").append(nationalNumber_);
            //if (hasItalianLeadingZero() && isItalianLeadingZero()) {
        //outputString.append(" Leading Zero: true");
      //}
            //if (hasExtension()) {
        //outputString.append(" Extension: ").append(extension_);
      //}
            //if (hasCountryCodeSource()) {
        //outputString.append(" Country Code Source: ").append(countryCodeSource_);
      //}
            //if (hasPreferredDomesticCarrierCode()) {
        //outputString.append(" Preferred Domestic Carrier Code: ").
            //append(preferredDomesticCarrierCode_);
      //}
            //return outputString.toString();
        }

        
        public enum CountryCodeSource {
      FROM_NUMBER_WITH_PLUS_SIGN,
      FROM_NUMBER_WITH_IDD,
      FROM_NUMBER_WITHOUT_PLUS_SIGN,
      FROM_DEFAULT_COUNTRY
    }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.367 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

        private static final long serialVersionUID = 1L;
    }


    
}

