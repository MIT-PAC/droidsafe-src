package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public final class Phonenumber {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.231 -0400", hash_original_method = "9F0C69719EBF6B458992D61E4BCC90E8", hash_generated_method = "5CB1D98A4150FC5519010EC189B4C107")
    private  Phonenumber() {
        // ---------- Original Method ----------
    }

    
    public static class PhoneNumber implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.232 -0400", hash_original_field = "8DA9382CFAB6A2934FA5AD3C46617F89", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

        private boolean hasCountryCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.232 -0400", hash_original_field = "3461D01D5A7F32E3FA9B229113397711", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

        private int countryCode_ = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.232 -0400", hash_original_field = "BEF2FB3011A67ABE2750EE20B94BCF1B", hash_generated_field = "B31B8035F727A8BE2916E64EBF4F38BF")

        private boolean hasNationalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.232 -0400", hash_original_field = "2FE6622A7CBF4A37DA0EE3F97AFD3C1A", hash_generated_field = "861F5C609F3E4BA70615CE11EE4F3E7C")

        private long nationalNumber_ = 0L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.232 -0400", hash_original_field = "E8BF8AD5CF623306E4137F929A4B793C", hash_generated_field = "358E6375D13B5162BE1A3016216C10C6")

        private boolean hasExtension;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.232 -0400", hash_original_field = "BABEC9AFE089768EADBB1770DB6C73E0", hash_generated_field = "6640D7D6CB57D7D20313E3325CD1FB22")

        private java.lang.String extension_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.232 -0400", hash_original_field = "9A3A483658C79E793F495FF31A1A2719", hash_generated_field = "3F85D89FA25AF2B45530E00802BDAF23")

        private boolean hasItalianLeadingZero;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.232 -0400", hash_original_field = "BA6B94B60539B119EFEF2AF2F66C2C0F", hash_generated_field = "D7F0554114A7FE26069B675ED8151AC1")

        private boolean italianLeadingZero_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.232 -0400", hash_original_field = "E04C31A797660EF69743A4E81B09F98E", hash_generated_field = "C4DB1F876DD23BC8A14CC9C5A337EE0B")

        private boolean hasRawInput;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.233 -0400", hash_original_field = "DA7C30298E9E640F6E99799BCA546A44", hash_generated_field = "1CA91139B304F5C069E8FEFEEC7BDADA")

        private String rawInput_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.233 -0400", hash_original_field = "AF071B11070C28DD45E4F04A2EAC9FD9", hash_generated_field = "F0FD53E6932AA94BEF89B80DE8FBB48A")

        private boolean hasCountryCodeSource;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.233 -0400", hash_original_field = "15078F02FD915A57AC4033865D7BD527", hash_generated_field = "726423546266BF59E9D4D30E8DF8603B")

        private CountryCodeSource countryCodeSource_;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.233 -0400", hash_original_field = "875F08A1E2A43A5348B38BFC578F2335", hash_generated_field = "7A3961A3D14D61159606E8AEE7AE90AE")

        private boolean hasPreferredDomesticCarrierCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.233 -0400", hash_original_field = "2939A13320742DC344097CB116D7C987", hash_generated_field = "30C4AF8975E517B81211F0AB34A0B954")

        private java.lang.String preferredDomesticCarrierCode_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.233 -0400", hash_original_method = "BC3E0739FB67F4B1E9E07E3377CC422E", hash_generated_method = "82E1ACB1E508CA9B7F2766C0989401DD")
        public  PhoneNumber() {
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            // ---------- Original Method ----------
            //countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.233 -0400", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "C0D9F1C53435AE44EFBA622C7AFCD081")
        public boolean hasCountryCode() {
            boolean var8DA9382CFAB6A2934FA5AD3C46617F89_1605925232 = (hasCountryCode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153187853 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153187853;
            // ---------- Original Method ----------
            //return hasCountryCode;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.234 -0400", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "543983C4ADB736D0AB66484766EE01A0")
        public int getCountryCode() {
            int var3C5B11B8C2E2EEFEFDB13FA162E1622D_348516572 = (countryCode_);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_246803831 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_246803831;
            // ---------- Original Method ----------
            //return countryCode_;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.234 -0400", hash_original_method = "231BDC2ACAA546410AD99483D572C314", hash_generated_method = "6B5D5AB1890EC87AD97117510250117F")
        public PhoneNumber setCountryCode(int value) {
            hasCountryCode = true;
            countryCode_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1498851139 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1498851139.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1498851139;
            // ---------- Original Method ----------
            //hasCountryCode = true;
            //countryCode_ = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.235 -0400", hash_original_method = "F3480C339E6576F38870C4A8107DC432", hash_generated_method = "0F8B7B2285DCA0E036C22252AFC00029")
        public PhoneNumber clearCountryCode() {
            hasCountryCode = false;
            countryCode_ = 0;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1580303776 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1580303776.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1580303776;
            // ---------- Original Method ----------
            //hasCountryCode = false;
            //countryCode_ = 0;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.235 -0400", hash_original_method = "9E5DD8721DB5E6B4EA37D3D3DF3C82B6", hash_generated_method = "2FB21590963ED0B2AA11620A332B7CA7")
        public boolean hasNationalNumber() {
            boolean varBEF2FB3011A67ABE2750EE20B94BCF1B_682375858 = (hasNationalNumber);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577115194 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577115194;
            // ---------- Original Method ----------
            //return hasNationalNumber;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.236 -0400", hash_original_method = "6637472029560B21624D3926379C2007", hash_generated_method = "FA43510A2ED8D886BAE50E28D72641B7")
        public long getNationalNumber() {
            long var6F698002E19497D272F47EBD21C1CE81_627857977 = (nationalNumber_);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_193963895 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_193963895;
            // ---------- Original Method ----------
            //return nationalNumber_;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.236 -0400", hash_original_method = "6A535B2D70F0F9B1A2B7BD33E2B75251", hash_generated_method = "9198B52709D6690A88F4038856304FB5")
        public PhoneNumber setNationalNumber(long value) {
            hasNationalNumber = true;
            nationalNumber_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1644299433 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1644299433.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1644299433;
            // ---------- Original Method ----------
            //hasNationalNumber = true;
            //nationalNumber_ = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.236 -0400", hash_original_method = "805285A190D17B224561E5C065A4AB00", hash_generated_method = "E5A546F362322A2805439E7439B78EDE")
        public PhoneNumber clearNationalNumber() {
            hasNationalNumber = false;
            nationalNumber_ = 0L;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1184117115 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1184117115.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1184117115;
            // ---------- Original Method ----------
            //hasNationalNumber = false;
            //nationalNumber_ = 0L;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.237 -0400", hash_original_method = "66338EE760653FB7826716BD4179F0EB", hash_generated_method = "4DBC78B844328A38D471C84A1F1E8F34")
        public boolean hasExtension() {
            boolean varE8BF8AD5CF623306E4137F929A4B793C_320194286 = (hasExtension);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1210239694 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1210239694;
            // ---------- Original Method ----------
            //return hasExtension;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.237 -0400", hash_original_method = "F04D3A8DBD1CCF0248A759BF39EDDDEC", hash_generated_method = "A0461A62B0A19F35BA6D3D4915715A5D")
        public String getExtension() {
String var637C5A1C83AAF573761C4AF8FC11C30A_1035088387 =             extension_;
            var637C5A1C83AAF573761C4AF8FC11C30A_1035088387.addTaint(taint);
            return var637C5A1C83AAF573761C4AF8FC11C30A_1035088387;
            // ---------- Original Method ----------
            //return extension_;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.237 -0400", hash_original_method = "38A692624EA50F65C5AAF1C27A4F1E79", hash_generated_method = "B7850E8B3A45FD441E262AFEF1526FBE")
        public PhoneNumber setExtension(String value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1726842225 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1726842225.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1726842225;
            } //End block
            hasExtension = true;
            extension_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1981096310 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1981096310.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1981096310;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasExtension = true;
            //extension_ = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.238 -0400", hash_original_method = "831C8D6965C7D5091D9400B8A1911F63", hash_generated_method = "DE88E612B615B362BDFD23511B0ADD62")
        public PhoneNumber clearExtension() {
            hasExtension = false;
            extension_ = "";
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1824852726 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1824852726.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1824852726;
            // ---------- Original Method ----------
            //hasExtension = false;
            //extension_ = "";
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.238 -0400", hash_original_method = "297A117AFD1E548B3AE9E987C5DEDB53", hash_generated_method = "FCBABFD7F5BFE380ACD751361E0354B2")
        public boolean hasItalianLeadingZero() {
            boolean var9A3A483658C79E793F495FF31A1A2719_1017620263 = (hasItalianLeadingZero);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68759390 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_68759390;
            // ---------- Original Method ----------
            //return hasItalianLeadingZero;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.238 -0400", hash_original_method = "B0BA7A66148037C7B1A35A6061ECB1A6", hash_generated_method = "857DCA6C5BB0B09DA82F552F4E7D193A")
        public boolean isItalianLeadingZero() {
            boolean varE14A1BCA7348187626B366BB2C6D2119_1317669331 = (italianLeadingZero_);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870203060 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_870203060;
            // ---------- Original Method ----------
            //return italianLeadingZero_;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.239 -0400", hash_original_method = "5FB07870F4A15DEE8F66E77590B141DD", hash_generated_method = "5C31FF85698BBCBA2E9629ECF02B2AF8")
        public PhoneNumber setItalianLeadingZero(boolean value) {
            hasItalianLeadingZero = true;
            italianLeadingZero_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_47149617 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_47149617.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_47149617;
            // ---------- Original Method ----------
            //hasItalianLeadingZero = true;
            //italianLeadingZero_ = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.239 -0400", hash_original_method = "55D33A5E10AF87EF82FB6277592BFD48", hash_generated_method = "1EB45CC08FF107F289C76E59335B0A45")
        public PhoneNumber clearItalianLeadingZero() {
            hasItalianLeadingZero = false;
            italianLeadingZero_ = false;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1631292598 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1631292598.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1631292598;
            // ---------- Original Method ----------
            //hasItalianLeadingZero = false;
            //italianLeadingZero_ = false;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.239 -0400", hash_original_method = "FC01A3A255BE4F11BA51CD36FFDCBB37", hash_generated_method = "2117F85ACAEF4121938B5E59CD0CE4FB")
        public boolean hasRawInput() {
            boolean varE04C31A797660EF69743A4E81B09F98E_745188583 = (hasRawInput);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1092892139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1092892139;
            // ---------- Original Method ----------
            //return hasRawInput;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.239 -0400", hash_original_method = "F6017E34CFBABE539ED487A19641D13D", hash_generated_method = "78E0F5AD18740FE8EF36F0C974B5CC16")
        public String getRawInput() {
String var86CB54FEF5E218064706500C9F7D92A9_1486024940 =             rawInput_;
            var86CB54FEF5E218064706500C9F7D92A9_1486024940.addTaint(taint);
            return var86CB54FEF5E218064706500C9F7D92A9_1486024940;
            // ---------- Original Method ----------
            //return rawInput_;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.240 -0400", hash_original_method = "1DF89DBF221798F84EE73F6641D85CA9", hash_generated_method = "9738BFB80BB6C1BA0A97EC1FFD064956")
        public PhoneNumber setRawInput(String value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_646566948 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_646566948.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_646566948;
            } //End block
            hasRawInput = true;
            rawInput_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_744957242 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_744957242.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_744957242;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasRawInput = true;
            //rawInput_ = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.240 -0400", hash_original_method = "090A68BA48513AA6167B14B8C7E5B538", hash_generated_method = "85A79394BE855309280EB1A10A77A6FF")
        public PhoneNumber clearRawInput() {
            hasRawInput = false;
            rawInput_ = "";
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_467633052 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_467633052.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_467633052;
            // ---------- Original Method ----------
            //hasRawInput = false;
            //rawInput_ = "";
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.241 -0400", hash_original_method = "49E6B213C7CF699A88721EC66ED6A85C", hash_generated_method = "07F3355BEE00795E0CBB392194A8CC42")
        public boolean hasCountryCodeSource() {
            boolean varAF071B11070C28DD45E4F04A2EAC9FD9_1246447084 = (hasCountryCodeSource);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817894365 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_817894365;
            // ---------- Original Method ----------
            //return hasCountryCodeSource;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.241 -0400", hash_original_method = "EC13D38EB752707A5D37EF84821B18F3", hash_generated_method = "B39BBD9CB82BB3CF0F709CACE6CCCBE1")
        public CountryCodeSource getCountryCodeSource() {
CountryCodeSource var0A93FE3B5880D72246BECF6597030055_661727489 =             countryCodeSource_;
            var0A93FE3B5880D72246BECF6597030055_661727489.addTaint(taint);
            return var0A93FE3B5880D72246BECF6597030055_661727489;
            // ---------- Original Method ----------
            //return countryCodeSource_;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.241 -0400", hash_original_method = "4C681F77FE4C34506AE7929BB9F5DB5B", hash_generated_method = "710D0BC5FF4BC28A8F1D354F4565ED63")
        public PhoneNumber setCountryCodeSource(CountryCodeSource value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1763878030 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1763878030.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1763878030;
            } //End block
            hasCountryCodeSource = true;
            countryCodeSource_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1009877866 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1009877866.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1009877866;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasCountryCodeSource = true;
            //countryCodeSource_ = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.242 -0400", hash_original_method = "AD210C1FCCDAAC9D9B6A95A61CE920CC", hash_generated_method = "23592963A0FA5B1FC1430B1B0689F3C7")
        public PhoneNumber clearCountryCodeSource() {
            hasCountryCodeSource = false;
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_776844910 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_776844910.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_776844910;
            // ---------- Original Method ----------
            //hasCountryCodeSource = false;
            //countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.242 -0400", hash_original_method = "8350C830C26B7D092EEEE9A503A10DA0", hash_generated_method = "1B102EB86B4358553A8E8898982D551C")
        public boolean hasPreferredDomesticCarrierCode() {
            boolean var875F08A1E2A43A5348B38BFC578F2335_1956446582 = (hasPreferredDomesticCarrierCode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_875423505 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_875423505;
            // ---------- Original Method ----------
            //return hasPreferredDomesticCarrierCode;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.242 -0400", hash_original_method = "47CB8521CF67D388DB30B3F811726252", hash_generated_method = "A8B9BB5940A860E28D14DE1FDDF38E81")
        public String getPreferredDomesticCarrierCode() {
String var7A97AC82E2980E5270FD81B0B7EF0B7B_16177182 =             preferredDomesticCarrierCode_;
            var7A97AC82E2980E5270FD81B0B7EF0B7B_16177182.addTaint(taint);
            return var7A97AC82E2980E5270FD81B0B7EF0B7B_16177182;
            // ---------- Original Method ----------
            //return preferredDomesticCarrierCode_;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.243 -0400", hash_original_method = "41BB5D81F1B0279F583403646A2042B9", hash_generated_method = "208730D47B9EFDCBD434215FFF69EEF0")
        public PhoneNumber setPreferredDomesticCarrierCode(String value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1946376901 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1946376901.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1946376901;
            } //End block
            hasPreferredDomesticCarrierCode = true;
            preferredDomesticCarrierCode_ = value;
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1611518116 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1611518116.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1611518116;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPreferredDomesticCarrierCode = true;
            //preferredDomesticCarrierCode_ = value;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.243 -0400", hash_original_method = "26AD27D6AD8CEDC77B768F25CC124964", hash_generated_method = "9749E020AED395127E117ED61B770E23")
        public PhoneNumber clearPreferredDomesticCarrierCode() {
            hasPreferredDomesticCarrierCode = false;
            preferredDomesticCarrierCode_ = "";
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_724769560 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_724769560.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_724769560;
            // ---------- Original Method ----------
            //hasPreferredDomesticCarrierCode = false;
            //preferredDomesticCarrierCode_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.243 -0400", hash_original_method = "9E3F334A53F42C22EC58969EE12FFC06", hash_generated_method = "EBC9436988E48879E402869120293C59")
        public final PhoneNumber clear() {
            clearCountryCode();
            clearNationalNumber();
            clearExtension();
            clearItalianLeadingZero();
            clearRawInput();
            clearCountryCodeSource();
            clearPreferredDomesticCarrierCode();
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_1652574318 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1652574318.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1652574318;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.244 -0400", hash_original_method = "0AFF34EE20E5281E0E8704C233C4A6C7", hash_generated_method = "5F37F37B6A8DC42401FE752628E6876A")
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
PhoneNumber var72A74007B2BE62B849F475C7BDA4658B_257659794 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_257659794.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_257659794;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.245 -0400", hash_original_method = "DE1C4B1DD2D8C57C4042DF1B529C7D4D", hash_generated_method = "AA8FA85B7726B782962FEEA2F309F0D2")
        public boolean exactlySameAs(PhoneNumber other) {
            addTaint(other.getTaint());
    if(other == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1879346611 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67916613 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_67916613;
            } //End block
    if(this == other)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1457879840 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_464020318 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_464020318;
            } //End block
            boolean var2259DE569DFFDDB7AE6A944847ED320F_1715548210 = ((countryCode_ == other.countryCode_ && nationalNumber_ == other.nationalNumber_ &&
          extension_.equals(other.extension_) && italianLeadingZero_ == other.italianLeadingZero_ &&
          rawInput_.equals(other.rawInput_) && countryCodeSource_ == other.countryCodeSource_ &&
          preferredDomesticCarrierCode_.equals(other.preferredDomesticCarrierCode_) &&
          hasPreferredDomesticCarrierCode() == other.hasPreferredDomesticCarrierCode()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_929093093 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_929093093;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.245 -0400", hash_original_method = "EF0E3A387E8AEF6EC396B951EC1536A9", hash_generated_method = "9966626DDE431945B85ED4459E8DA4C5")
        @Override
        public boolean equals(Object that) {
            addTaint(that.getTaint());
            boolean varA0C1DA9A16D8865D89C78B991DC254B0_1680974242 = ((that instanceof PhoneNumber) && exactlySameAs((PhoneNumber) that));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_535664968 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_535664968;
            // ---------- Original Method ----------
            //return (that instanceof PhoneNumber) && exactlySameAs((PhoneNumber) that);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.246 -0400", hash_original_method = "F1BB2EE5D9E77C138CA0D6B9F17756FB", hash_generated_method = "BEFC827080214239D2294FA582F31BF0")
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
            int var0800FC577294C34E0B28AD2839435945_463523344 = (hash);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881938843 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881938843;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.247 -0400", hash_original_method = "16D1E3F084AA1063C11CF7C5BDA5DD45", hash_generated_method = "609724F8CECE4AD7D21B6D1535FD7126")
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
String varF9C77AD1D66AAC2CCF21F4FFED2F9F68_18324658 =             outputString.toString();
            varF9C77AD1D66AAC2CCF21F4FFED2F9F68_18324658.addTaint(taint);
            return varF9C77AD1D66AAC2CCF21F4FFED2F9F68_18324658;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.247 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

        private static final long serialVersionUID = 1L;
    }


    
}

