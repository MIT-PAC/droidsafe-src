package com.android.i18n.phonenumbers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public final class Phonenumber {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_method = "9F0C69719EBF6B458992D61E4BCC90E8", hash_generated_method = "5CB1D98A4150FC5519010EC189B4C107")
    private  Phonenumber() {
        
    }

    
    public static class PhoneNumber implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "8DA9382CFAB6A2934FA5AD3C46617F89", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

        private boolean hasCountryCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "3461D01D5A7F32E3FA9B229113397711", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

        private int countryCode_ = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "BEF2FB3011A67ABE2750EE20B94BCF1B", hash_generated_field = "B31B8035F727A8BE2916E64EBF4F38BF")

        private boolean hasNationalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "2FE6622A7CBF4A37DA0EE3F97AFD3C1A", hash_generated_field = "861F5C609F3E4BA70615CE11EE4F3E7C")

        private long nationalNumber_ = 0L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "E8BF8AD5CF623306E4137F929A4B793C", hash_generated_field = "358E6375D13B5162BE1A3016216C10C6")

        private boolean hasExtension;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "BABEC9AFE089768EADBB1770DB6C73E0", hash_generated_field = "6640D7D6CB57D7D20313E3325CD1FB22")

        private java.lang.String extension_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "9A3A483658C79E793F495FF31A1A2719", hash_generated_field = "3F85D89FA25AF2B45530E00802BDAF23")

        private boolean hasItalianLeadingZero;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "BA6B94B60539B119EFEF2AF2F66C2C0F", hash_generated_field = "D7F0554114A7FE26069B675ED8151AC1")

        private boolean italianLeadingZero_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "E04C31A797660EF69743A4E81B09F98E", hash_generated_field = "C4DB1F876DD23BC8A14CC9C5A337EE0B")

        private boolean hasRawInput;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "DA7C30298E9E640F6E99799BCA546A44", hash_generated_field = "1CA91139B304F5C069E8FEFEEC7BDADA")

        private String rawInput_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "AF071B11070C28DD45E4F04A2EAC9FD9", hash_generated_field = "F0FD53E6932AA94BEF89B80DE8FBB48A")

        private boolean hasCountryCodeSource;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "15078F02FD915A57AC4033865D7BD527", hash_generated_field = "726423546266BF59E9D4D30E8DF8603B")

        private CountryCodeSource countryCodeSource_;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "875F08A1E2A43A5348B38BFC578F2335", hash_generated_field = "7A3961A3D14D61159606E8AEE7AE90AE")

        private boolean hasPreferredDomesticCarrierCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_field = "2939A13320742DC344097CB116D7C987", hash_generated_field = "30C4AF8975E517B81211F0AB34A0B954")

        private java.lang.String preferredDomesticCarrierCode_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.553 -0400", hash_original_method = "BC3E0739FB67F4B1E9E07E3377CC422E", hash_generated_method = "82E1ACB1E508CA9B7F2766C0989401DD")
        public  PhoneNumber() {
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.554 -0400", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "6FD9B15FA735939A1D72A93DE14E931C")
        public boolean hasCountryCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_408243327 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_408243327;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.554 -0400", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "0F7BA9465D3E3F999F26C6110E1332CA")
        public int getCountryCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847860161 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847860161;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.554 -0400", hash_original_method = "231BDC2ACAA546410AD99483D572C314", hash_generated_method = "B75804BF445D58BCD3B67491E83C6461")
        public PhoneNumber setCountryCode(int value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_761750041 = null; 
            hasCountryCode = true;
            countryCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_761750041 = this;
            varB4EAC82CA7396A68D541C85D26508E83_761750041.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_761750041;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.555 -0400", hash_original_method = "F3480C339E6576F38870C4A8107DC432", hash_generated_method = "14E874946783E53C37F6D888BFD2F446")
        public PhoneNumber clearCountryCode() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1442239319 = null; 
            hasCountryCode = false;
            countryCode_ = 0;
            varB4EAC82CA7396A68D541C85D26508E83_1442239319 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1442239319.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1442239319;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.555 -0400", hash_original_method = "9E5DD8721DB5E6B4EA37D3D3DF3C82B6", hash_generated_method = "2BFA2D8CF1AC26AE5E1E18C2C4D86E1A")
        public boolean hasNationalNumber() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606630798 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606630798;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.556 -0400", hash_original_method = "6637472029560B21624D3926379C2007", hash_generated_method = "E49C25266AB3E8D9DA9B107CD2968092")
        public long getNationalNumber() {
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1149215348 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1149215348;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.557 -0400", hash_original_method = "6A535B2D70F0F9B1A2B7BD33E2B75251", hash_generated_method = "908E4FDA7E589275605441001AC31362")
        public PhoneNumber setNationalNumber(long value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1303898074 = null; 
            hasNationalNumber = true;
            nationalNumber_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1303898074 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1303898074.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1303898074;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.557 -0400", hash_original_method = "805285A190D17B224561E5C065A4AB00", hash_generated_method = "52797CAF80A075F6837AF452FAE5CCF8")
        public PhoneNumber clearNationalNumber() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1451378874 = null; 
            hasNationalNumber = false;
            nationalNumber_ = 0L;
            varB4EAC82CA7396A68D541C85D26508E83_1451378874 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1451378874.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1451378874;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.558 -0400", hash_original_method = "66338EE760653FB7826716BD4179F0EB", hash_generated_method = "8ACE16B8D255D9FBA6D8B6C0E6B9F9A7")
        public boolean hasExtension() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_250624583 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_250624583;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.558 -0400", hash_original_method = "F04D3A8DBD1CCF0248A759BF39EDDDEC", hash_generated_method = "440E6B4B3A34D2F11A134FBC1280F3A8")
        public String getExtension() {
            String varB4EAC82CA7396A68D541C85D26508E83_1386345795 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1386345795 = extension_;
            varB4EAC82CA7396A68D541C85D26508E83_1386345795.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1386345795;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.558 -0400", hash_original_method = "38A692624EA50F65C5AAF1C27A4F1E79", hash_generated_method = "26D006FB28648501C884C19CDBB8405E")
        public PhoneNumber setExtension(String value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_2110698217 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            hasExtension = true;
            extension_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_2110698217 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2110698217.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2110698217;
            
            
        
      
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.559 -0400", hash_original_method = "831C8D6965C7D5091D9400B8A1911F63", hash_generated_method = "961F4512A2D4BE33EAB4C245D91FA642")
        public PhoneNumber clearExtension() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_577375491 = null; 
            hasExtension = false;
            extension_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_577375491 = this;
            varB4EAC82CA7396A68D541C85D26508E83_577375491.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_577375491;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.559 -0400", hash_original_method = "297A117AFD1E548B3AE9E987C5DEDB53", hash_generated_method = "7502B82DBA17970CAD0BB9D51ECDDD6A")
        public boolean hasItalianLeadingZero() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_412917233 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_412917233;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.559 -0400", hash_original_method = "B0BA7A66148037C7B1A35A6061ECB1A6", hash_generated_method = "ED8658005ED853CE2FB43E44189C34CE")
        public boolean isItalianLeadingZero() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1988808645 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1988808645;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.560 -0400", hash_original_method = "5FB07870F4A15DEE8F66E77590B141DD", hash_generated_method = "BD0F8F8BE68098A292655A8C8F4A55C8")
        public PhoneNumber setItalianLeadingZero(boolean value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1676595732 = null; 
            hasItalianLeadingZero = true;
            italianLeadingZero_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1676595732 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1676595732.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1676595732;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.560 -0400", hash_original_method = "55D33A5E10AF87EF82FB6277592BFD48", hash_generated_method = "C239B0EB7644E4164C1C6427FDDC094D")
        public PhoneNumber clearItalianLeadingZero() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1160560232 = null; 
            hasItalianLeadingZero = false;
            italianLeadingZero_ = false;
            varB4EAC82CA7396A68D541C85D26508E83_1160560232 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1160560232.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1160560232;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.560 -0400", hash_original_method = "FC01A3A255BE4F11BA51CD36FFDCBB37", hash_generated_method = "5656E40B5E1BB09AFF50C81B195C196C")
        public boolean hasRawInput() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133600399 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_133600399;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.561 -0400", hash_original_method = "F6017E34CFBABE539ED487A19641D13D", hash_generated_method = "305F0FD3A67E35A81471F5848E13D791")
        public String getRawInput() {
            String varB4EAC82CA7396A68D541C85D26508E83_1800546561 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1800546561 = rawInput_;
            varB4EAC82CA7396A68D541C85D26508E83_1800546561.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1800546561;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.561 -0400", hash_original_method = "1DF89DBF221798F84EE73F6641D85CA9", hash_generated_method = "05875E3CC59741CF48DC2251F670F88F")
        public PhoneNumber setRawInput(String value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_958624195 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            hasRawInput = true;
            rawInput_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_958624195 = this;
            varB4EAC82CA7396A68D541C85D26508E83_958624195.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_958624195;
            
            
        
      
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.562 -0400", hash_original_method = "090A68BA48513AA6167B14B8C7E5B538", hash_generated_method = "EAED79D178D27524E3D95D83D0A3D795")
        public PhoneNumber clearRawInput() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_88627780 = null; 
            hasRawInput = false;
            rawInput_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_88627780 = this;
            varB4EAC82CA7396A68D541C85D26508E83_88627780.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_88627780;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.562 -0400", hash_original_method = "49E6B213C7CF699A88721EC66ED6A85C", hash_generated_method = "EDBF6D420D920A959688182F31E4DF60")
        public boolean hasCountryCodeSource() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_124183961 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_124183961;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.562 -0400", hash_original_method = "EC13D38EB752707A5D37EF84821B18F3", hash_generated_method = "7701EB73A6BFCC55E6C309AB0F64EA80")
        public CountryCodeSource getCountryCodeSource() {
            CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_1307819130 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1307819130 = countryCodeSource_;
            varB4EAC82CA7396A68D541C85D26508E83_1307819130.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1307819130;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.563 -0400", hash_original_method = "4C681F77FE4C34506AE7929BB9F5DB5B", hash_generated_method = "113791A355A24345B3BB6444EDEF3917")
        public PhoneNumber setCountryCodeSource(CountryCodeSource value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1272222797 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            hasCountryCodeSource = true;
            countryCodeSource_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1272222797 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1272222797.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1272222797;
            
            
        
      
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.563 -0400", hash_original_method = "AD210C1FCCDAAC9D9B6A95A61CE920CC", hash_generated_method = "A4DFF2F68C6996C6303237A0D1C1D5B9")
        public PhoneNumber clearCountryCodeSource() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_521282866 = null; 
            hasCountryCodeSource = false;
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            varB4EAC82CA7396A68D541C85D26508E83_521282866 = this;
            varB4EAC82CA7396A68D541C85D26508E83_521282866.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_521282866;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.563 -0400", hash_original_method = "8350C830C26B7D092EEEE9A503A10DA0", hash_generated_method = "56D985B92269092446F6763B98146A17")
        public boolean hasPreferredDomesticCarrierCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363322026 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363322026;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.564 -0400", hash_original_method = "47CB8521CF67D388DB30B3F811726252", hash_generated_method = "05EFE7E406A635ADA666F5844C038E20")
        public String getPreferredDomesticCarrierCode() {
            String varB4EAC82CA7396A68D541C85D26508E83_956706123 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_956706123 = preferredDomesticCarrierCode_;
            varB4EAC82CA7396A68D541C85D26508E83_956706123.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_956706123;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.564 -0400", hash_original_method = "41BB5D81F1B0279F583403646A2042B9", hash_generated_method = "67189AE1E0A56BD901211C28247A0C83")
        public PhoneNumber setPreferredDomesticCarrierCode(String value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1770095738 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            hasPreferredDomesticCarrierCode = true;
            preferredDomesticCarrierCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1770095738 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1770095738.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1770095738;
            
            
        
      
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.564 -0400", hash_original_method = "26AD27D6AD8CEDC77B768F25CC124964", hash_generated_method = "05AF504E2B351E2ED5491CE544F33730")
        public PhoneNumber clearPreferredDomesticCarrierCode() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_335110414 = null; 
            hasPreferredDomesticCarrierCode = false;
            preferredDomesticCarrierCode_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_335110414 = this;
            varB4EAC82CA7396A68D541C85D26508E83_335110414.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_335110414;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.565 -0400", hash_original_method = "9E3F334A53F42C22EC58969EE12FFC06", hash_generated_method = "9BD293E2AB3070BAE1E8E2B1E2164418")
        public final PhoneNumber clear() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1509238639 = null; 
            clearCountryCode();
            clearNationalNumber();
            clearExtension();
            clearItalianLeadingZero();
            clearRawInput();
            clearCountryCodeSource();
            clearPreferredDomesticCarrierCode();
            varB4EAC82CA7396A68D541C85D26508E83_1509238639 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1509238639.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1509238639;
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.566 -0400", hash_original_method = "0AFF34EE20E5281E0E8704C233C4A6C7", hash_generated_method = "79616D43998298AF2BB41B93739562E2")
        public PhoneNumber mergeFrom(PhoneNumber other) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1181882746 = null; 
            {
                boolean var7E81CBAAB3EA7600B5C349844A3DA67F_1015179364 = (other.hasCountryCode());
                {
                    setCountryCode(other.getCountryCode());
                } 
            } 
            {
                boolean var2052D51723D6CFDD0C32171C1669744A_1080329546 = (other.hasNationalNumber());
                {
                    setNationalNumber(other.getNationalNumber());
                } 
            } 
            {
                boolean var3D50C0940F659491C98DC4B316490D2B_887450229 = (other.hasExtension());
                {
                    setExtension(other.getExtension());
                } 
            } 
            {
                boolean varA9932682E4C7BD97414CE18901A431BF_1286514261 = (other.hasItalianLeadingZero());
                {
                    setItalianLeadingZero(other.isItalianLeadingZero());
                } 
            } 
            {
                boolean varF5BDCCDF0CF842993D0F90518AD8B0B1_1280700637 = (other.hasRawInput());
                {
                    setRawInput(other.getRawInput());
                } 
            } 
            {
                boolean var035EFCDC910421918C6321C968D446C6_159406918 = (other.hasCountryCodeSource());
                {
                    setCountryCodeSource(other.getCountryCodeSource());
                } 
            } 
            {
                boolean varBC066E2F7D27AB4E6EB4E9344D3B9AFA_1844594637 = (other.hasPreferredDomesticCarrierCode());
                {
                    setPreferredDomesticCarrierCode(other.getPreferredDomesticCarrierCode());
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1181882746 = this;
            addTaint(other.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1181882746.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1181882746;
            
            
        
      
            
        
      
            
        
      
            
        
      
            
        
      
            
        
      
            
        
      
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.567 -0400", hash_original_method = "DE1C4B1DD2D8C57C4042DF1B529C7D4D", hash_generated_method = "6E2C86D581F2AD9FCE8B5278A71CF225")
        public boolean exactlySameAs(PhoneNumber other) {
            boolean var4EB77A9CEDB1032569C973613A9313C9_867174034 = ((countryCode_ == other.countryCode_ && nationalNumber_ == other.nationalNumber_ &&
          extension_.equals(other.extension_) && italianLeadingZero_ == other.italianLeadingZero_ &&
          rawInput_.equals(other.rawInput_) && countryCodeSource_ == other.countryCodeSource_ &&
          preferredDomesticCarrierCode_.equals(other.preferredDomesticCarrierCode_) &&
          hasPreferredDomesticCarrierCode() == other.hasPreferredDomesticCarrierCode()));
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_711248787 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_711248787;
            
            
        
      
            
        
      
            
          
          
          
          
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.568 -0400", hash_original_method = "EF0E3A387E8AEF6EC396B951EC1536A9", hash_generated_method = "3FBF2D7BC959CE92F5FFCAD6DA242E57")
        @Override
        public boolean equals(Object that) {
            boolean var739237D2BDA3D224DE7CFFAAA4A6064B_1048286573 = ((that instanceof PhoneNumber) && exactlySameAs((PhoneNumber) that));
            addTaint(that.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112111724 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112111724;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.570 -0400", hash_original_method = "F1BB2EE5D9E77C138CA0D6B9F17756FB", hash_generated_method = "E88788DC6AE47F4E1F7A6B747C0D1DCA")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424296777 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424296777;
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.571 -0400", hash_original_method = "16D1E3F084AA1063C11CF7C5BDA5DD45", hash_generated_method = "E16D098C786CCA2063885A49004EAD3F")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_807173151 = null; 
            StringBuilder outputString = new StringBuilder();
            outputString.append("Country Code: ").append(countryCode_);
            outputString.append(" National Number: ").append(nationalNumber_);
            {
                boolean varAC928743AA4361941C966832DF776A7B_739883940 = (hasItalianLeadingZero() && isItalianLeadingZero());
                {
                    outputString.append(" Leading Zero: true");
                } 
            } 
            {
                boolean var1430D110BD7C50E7B13612C95695845D_1733469554 = (hasExtension());
                {
                    outputString.append(" Extension: ").append(extension_);
                } 
            } 
            {
                boolean var2412B064642DAAEC43954205576731D7_730745788 = (hasCountryCodeSource());
                {
                    outputString.append(" Country Code Source: ").append(countryCodeSource_);
                } 
            } 
            {
                boolean var647279AD14B7D4C5032BD55F39D3D3A8_1461532416 = (hasPreferredDomesticCarrierCode());
                {
                    outputString.append(" Preferred Domestic Carrier Code: ").
            append(preferredDomesticCarrierCode_);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_807173151 = outputString.toString();
            varB4EAC82CA7396A68D541C85D26508E83_807173151.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_807173151;
            
            
            
            
            
        
      
            
        
      
            
        
      
            
        
            
      
            
        }

        
        public enum CountryCodeSource {
      FROM_NUMBER_WITH_PLUS_SIGN,
      FROM_NUMBER_WITH_IDD,
      FROM_NUMBER_WITHOUT_PLUS_SIGN,
      FROM_DEFAULT_COUNTRY
    }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.572 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

        private static final long serialVersionUID = 1L;
    }


    
}

