package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public final class BluetoothClass implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.428 -0500", hash_original_field = "1D5262A0E52304A95D0DF93E7D728EC1", hash_generated_field = "0A8DCF3C3E9335974986AC8A09465280")

    public static final int ERROR = 0xFF000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.121 -0400", hash_original_field = "08D493A5CC11EE6A51032CBFE445C1B8", hash_generated_field = "178124FDE61E60B254E623C79893E54C")

    public static final Parcelable.Creator<BluetoothClass> CREATOR =
            new Parcelable.Creator<BluetoothClass>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.444 -0500", hash_original_method = "B44CE55AFB9D52E11C79A0FBA01F5306", hash_generated_method = "E9EB8CA077AEC00E8EB952CDCB5A8A96")
        
public BluetoothClass createFromParcel(Parcel in) {
            return new BluetoothClass(in.readInt());
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.447 -0500", hash_original_method = "6DF43DA1CA065C9A6D59AF5E5C74F432", hash_generated_method = "5C13091DA3F80C442EFBEF9B2B9F32F3")
        
public BluetoothClass[] newArray(int size) {
            return new BluetoothClass[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.664 -0500", hash_original_field = "5469753113C594B169B769E164E7B0B1", hash_generated_field = "A91F1554D03F2D40F0EF435E5BB76145")

    public static final int PROFILE_HEADSET = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.667 -0500", hash_original_field = "CD85CD502A52BD133C3A182F177A632A", hash_generated_field = "1C6F840769C10DB10D56FE733287FEEE")

    public static final int PROFILE_A2DP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.669 -0500", hash_original_field = "E7311708E13D7C1ABCFD0D1EA08ADB91", hash_generated_field = "7E44908C560873B4D43C2A27F061145E")

    public static final int PROFILE_OPP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.671 -0500", hash_original_field = "1805765A3FA1D455CA23398020EAA7DF", hash_generated_field = "15D963CF89E9BFF8839D7F44F3F1A528")

    public static final int PROFILE_HID = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.673 -0500", hash_original_field = "860BAE880E9EBB1B2F7989C13EDB486E", hash_generated_field = "DD5FDE600B2EE78E730FC60290848DC2")

    public static final int PROFILE_PANU = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.675 -0500", hash_original_field = "02DA4E59262AA0335E23D1DD5D9AE91F", hash_generated_field = "8E1DD5D84A7BBA78C1846DC1987F993C")

    public static final int PROFILE_NAP = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.430 -0500", hash_original_field = "E48DAE8D69C6B9F32DD524643B0838E9", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private  int mClass;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.433 -0500", hash_original_method = "3018CA2607FD366405F97E43B06E77B3", hash_generated_method = "39ABF5C0801382009DB7BC62C14F524E")
    
public BluetoothClass(int classInt) {
        mClass = classInt;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.435 -0500", hash_original_method = "217E4DCE2F47DBEE08566901FB7CC9C3", hash_generated_method = "1710722012A93F08CE4CD1522BAB190B")
    
@Override
    public boolean equals(Object o) {
        return toTaintBoolean(getTaintInt() + o.getTaintInt());
        /*
        if (o instanceof BluetoothClass) {
            return mClass == ((BluetoothClass)o).mClass;
        }
        return false;
        */
    }
    
    public static final class Service {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.455 -0500", hash_original_field = "D91B93CE6579CFD68BD5809AC8BE46B2", hash_generated_field = "426959E7E86F5DF5ED12EDB76E954DA5")

        private static final int BITMASK                 = 0xFFE000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.458 -0500", hash_original_field = "E5B7909731FDC8A93250CAAD2A787418", hash_generated_field = "5E269E79168551A0C4298C7721D7C84C")

        public static final int LIMITED_DISCOVERABILITY = 0x002000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.460 -0500", hash_original_field = "4B7BE0C082A7D10FCED74D74BCA08409", hash_generated_field = "00734D753B05B56395771F5D6B15AA89")

        public static final int POSITIONING             = 0x010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.463 -0500", hash_original_field = "D51D870160EA9AF92D26EB3A3FB16579", hash_generated_field = "57E34F92FA7FB3C39407E2783912125F")

        public static final int NETWORKING              = 0x020000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.465 -0500", hash_original_field = "3FDA05E2F9A43F62B0835694F8CCC403", hash_generated_field = "D689848649BC0E11CE503A46AA632311")

        public static final int RENDER                  = 0x040000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.467 -0500", hash_original_field = "A1F7D33236D7EA649601059CAEE9D6E2", hash_generated_field = "B029AA216B734D760B152782F48CC625")

        public static final int CAPTURE                 = 0x080000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.471 -0500", hash_original_field = "BECE72E241B2B966636DF7B2BA915E1A", hash_generated_field = "A401C713A59B2BC32203E29052452FB7")

        public static final int OBJECT_TRANSFER         = 0x100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.473 -0500", hash_original_field = "B1519B4AF84F872316B2B3B929083AE8", hash_generated_field = "DFFF955DD91969B8962B3B55CE54F951")

        public static final int AUDIO                   = 0x200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.475 -0500", hash_original_field = "E164AA6B2CD1F2F2987D6E6BC4C1AE92", hash_generated_field = "07EF9D4EFBA2B67E1D090688D094DFEB")

        public static final int TELEPHONY               = 0x400000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.478 -0500", hash_original_field = "CA4CC314BFFF33FD4E67DC70FFB2745D", hash_generated_field = "274077874B28B5CBF7EBAC4E40184DBE")

        public static final int INFORMATION             = 0x800000;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.104 -0400", hash_original_method = "05DD0D3AE8FB07CCF5507C6E023C1B78", hash_generated_method = "05DD0D3AE8FB07CCF5507C6E023C1B78")
        public Service ()
        {
            //Synthesized constructor
        }
    }
    
    public static class Device {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.485 -0500", hash_original_field = "DC2C858F406E573FC7ADDF2541C8F380", hash_generated_field = "1D5B39E9B9B878FCC7CCB5BCFF59714D")

        private static final int BITMASK               = 0x1FFC;

        public static class Major {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.488 -0500", hash_original_field = "2AC9787844C4CC027375EE390B3EA166", hash_generated_field = "B141CF4C38B0F742777D6B2BC51B9A0B")

            private static final int BITMASK           = 0x1F00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.491 -0500", hash_original_field = "6D3D0C5A0929F11A9B74859A2E80530D", hash_generated_field = "AE466877227B4A952D2138EB1029E3C6")

            public static final int MISC              = 0x0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.493 -0500", hash_original_field = "E699ACD1B8D89BF33A62BBEABF6DD644", hash_generated_field = "20E6C2C42D683E45418599697445F839")

            public static final int COMPUTER          = 0x0100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.496 -0500", hash_original_field = "23A4936BFE54CA98FCA5711C94AC90D4", hash_generated_field = "7751A32A7B23E6C93ED0B1D04495FD64")

            public static final int PHONE             = 0x0200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.498 -0500", hash_original_field = "F4012A715E39F02C5F7BD6D38A2D18AC", hash_generated_field = "E7242554DBE08DA7B464202AA58A96C5")

            public static final int NETWORKING        = 0x0300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.501 -0500", hash_original_field = "0A8A5B9DD0E6D4412F0E5308E81A9C83", hash_generated_field = "C306D7248EEC193A57D50AFCB0A3C6A1")

            public static final int AUDIO_VIDEO       = 0x0400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.504 -0500", hash_original_field = "A2D2C39E2A4E78C38C930D76BF64C04A", hash_generated_field = "6A476AB4E3FEE2B9C13C9BF02FD8EB26")

            public static final int PERIPHERAL        = 0x0500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.506 -0500", hash_original_field = "3AD9DD55D40005FE10E1A03E3BE85909", hash_generated_field = "E504572D9609AB99E895BD86FD486683")

            public static final int IMAGING           = 0x0600;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.509 -0500", hash_original_field = "463C0485ADF224C38D088D963E051272", hash_generated_field = "AB8BE7F4132005677524133CCF8CA9E1")

            public static final int WEARABLE          = 0x0700;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.512 -0500", hash_original_field = "1E31B465FFE8CED3AF6521C58835E1EA", hash_generated_field = "C3B922AB8D0BDC061F8F292B7FD3A613")

            public static final int TOY               = 0x0800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.514 -0500", hash_original_field = "75792D2D15389E97477B399C6A37DCE5", hash_generated_field = "C8BB43E7664CF6B2F072D804EF5623CA")

            public static final int HEALTH            = 0x0900;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.517 -0500", hash_original_field = "794D88538B435DAAF5BAC7638471E9AF", hash_generated_field = "4E50DC61372853B626C7816F227F267C")

            public static final int UNCATEGORIZED     = 0x1F00;
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.108 -0400", hash_original_method = "2C98A313400B6C1B74CB3BC1CC68B05F", hash_generated_method = "2C98A313400B6C1B74CB3BC1CC68B05F")
            public Major ()
            {
                //Synthesized constructor
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.521 -0500", hash_original_field = "FADA55208A9E0B898E942AA88623ECA1", hash_generated_field = "7CCC31D805A8EE2D8A9CA9D848361480")

        public static final int COMPUTER_UNCATEGORIZED              = 0x0100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.525 -0500", hash_original_field = "F0A17B44EBA02070FC496DCD0174AD73", hash_generated_field = "BE8D9E15C6B5EEAEA4BEDBCBE695E82F")

        public static final int COMPUTER_DESKTOP                    = 0x0104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.527 -0500", hash_original_field = "3DD6FF47ABD9CD2F8D0D99A0AC2C034A", hash_generated_field = "DE193BEFB322EE44F1BA9B2C2782B021")

        public static final int COMPUTER_SERVER                     = 0x0108;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.529 -0500", hash_original_field = "2140CB3305055EFE3E1935E85FC967C8", hash_generated_field = "6098C07B025EB49297B2FE3949A03BDA")

        public static final int COMPUTER_LAPTOP                     = 0x010C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.532 -0500", hash_original_field = "3221E3F9A82E0444F90212B006954D42", hash_generated_field = "BDB6EB7666F87D7C5DF367F66D1D5BEF")

        public static final int COMPUTER_HANDHELD_PC_PDA            = 0x0110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.534 -0500", hash_original_field = "C783FC174DCEF0BEF597E28C773085F4", hash_generated_field = "46CDC92B39391ECE87CEE11A3A779722")

        public static final int COMPUTER_PALM_SIZE_PC_PDA           = 0x0114;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.536 -0500", hash_original_field = "EBF02B0DE953EBA1A25EEC0FE63204CB", hash_generated_field = "63FBDDE763CB7661EB53A5E5DF9A26C1")

        public static final int COMPUTER_WEARABLE                   = 0x0118;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.539 -0500", hash_original_field = "162E1B3BEC0A7C0D0B2B00FD2F6859DC", hash_generated_field = "1EA634B1743D54B6E7789E83FCDBB3D1")

        public static final int PHONE_UNCATEGORIZED                 = 0x0200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.541 -0500", hash_original_field = "1690EAF25C96A8263D7F3B60CD76E81B", hash_generated_field = "2843D03A87C50E2859028396546AB438")

        public static final int PHONE_CELLULAR                      = 0x0204;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.543 -0500", hash_original_field = "0F588A178A98057E9814EABDF7EE6D1B", hash_generated_field = "0FDD8E51236A607121ED6B74C9ED9509")

        public static final int PHONE_CORDLESS                      = 0x0208;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.546 -0500", hash_original_field = "C8887F6CA683D35E6E3A104BB70C7162", hash_generated_field = "056904CEF5068736C8936BBD2E5ECC0B")

        public static final int PHONE_SMART                         = 0x020C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.549 -0500", hash_original_field = "D88A663671DC3DE0A7C78B3485005A11", hash_generated_field = "C45B573DA1724853BF0385C7CC35E057")

        public static final int PHONE_MODEM_OR_GATEWAY              = 0x0210;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.551 -0500", hash_original_field = "752CA0468C112510E513F93942B732E3", hash_generated_field = "53AFC0B301B83A1E5F245642A43F04E2")

        public static final int PHONE_ISDN                          = 0x0214;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.554 -0500", hash_original_field = "1684C32049FBEF5F501BB9C9495B0C12", hash_generated_field = "B67EC1F8551E2D43EB168557214193A5")

        public static final int AUDIO_VIDEO_UNCATEGORIZED           = 0x0400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.556 -0500", hash_original_field = "990F29BA8285A18B0E3526B0191FB589", hash_generated_field = "4873C0C3F3145AC11BC4468EA5A8CC5C")

        public static final int AUDIO_VIDEO_WEARABLE_HEADSET        = 0x0404;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.558 -0500", hash_original_field = "A4EABD7E2871F01E954D995BD60ADD46", hash_generated_field = "4135F1D666D889D649AFC4AF625BE41A")

        public static final int AUDIO_VIDEO_HANDSFREE               = 0x0408;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.561 -0500", hash_original_field = "512C323C77E360A66E5BE403772785A1", hash_generated_field = "A6BA5F3488F608A8BF8A07A06F81C078")

        public static final int AUDIO_VIDEO_MICROPHONE              = 0x0410;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.564 -0500", hash_original_field = "9FDD29685DE59B02AAE83A3B27351D5A", hash_generated_field = "3035221D6461054099A9F43B0831D657")

        public static final int AUDIO_VIDEO_LOUDSPEAKER             = 0x0414;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.567 -0500", hash_original_field = "CE0CB804732414251A55F9255B4E3FD7", hash_generated_field = "32C1EC1ECEC4AD4FDB20846AA101D9F0")

        public static final int AUDIO_VIDEO_HEADPHONES              = 0x0418;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.569 -0500", hash_original_field = "17D4167DAA44546361DE5E576216D6F7", hash_generated_field = "BD761020F273BD8CF6C831B0CD986DC3")

        public static final int AUDIO_VIDEO_PORTABLE_AUDIO          = 0x041C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.572 -0500", hash_original_field = "6E6578E20760DFEADC38571DC9807D92", hash_generated_field = "24BD0370AA04AB5A0A0840243548D9DB")

        public static final int AUDIO_VIDEO_CAR_AUDIO               = 0x0420;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.574 -0500", hash_original_field = "82732EAC19DF824CF8C6929F5A216323", hash_generated_field = "6541E3CCF65B5AF295DEABDC60208625")

        public static final int AUDIO_VIDEO_SET_TOP_BOX             = 0x0424;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.577 -0500", hash_original_field = "D32FE0BD00D456249783424B13C87B97", hash_generated_field = "AFCB247E572ACE2CF6C4518D97071B60")

        public static final int AUDIO_VIDEO_HIFI_AUDIO              = 0x0428;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.579 -0500", hash_original_field = "65DAD21116C02A6242190C56719AD29E", hash_generated_field = "1EB7300F1066D52D4253754811CC07DD")

        public static final int AUDIO_VIDEO_VCR                     = 0x042C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.582 -0500", hash_original_field = "D6C6F6C59679FB8C8C7545BFB587FCF5", hash_generated_field = "0BA18F7DEFC21431D9013937E793D181")

        public static final int AUDIO_VIDEO_VIDEO_CAMERA            = 0x0430;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.584 -0500", hash_original_field = "D5F5A48C62DA0513FF227C93A27A946E", hash_generated_field = "74C94BEBED47932C15634AE962E86EF5")

        public static final int AUDIO_VIDEO_CAMCORDER               = 0x0434;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.586 -0500", hash_original_field = "AB73C0AF9454A7683D0F3CBC927D139D", hash_generated_field = "A41F49ECB1181C37D7D924CB026AB851")

        public static final int AUDIO_VIDEO_VIDEO_MONITOR           = 0x0438;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.589 -0500", hash_original_field = "B668833B71C740457EC09E2496235864", hash_generated_field = "BEF3EF7EF0FD9E376DC62129B349012B")

        public static final int AUDIO_VIDEO_VIDEO_DISPLAY_AND_LOUDSPEAKER = 0x043C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.591 -0500", hash_original_field = "D7F48C03DD3924D683776F347C291062", hash_generated_field = "0208BE889A9BDB60FBB73BF4E93C9360")

        public static final int AUDIO_VIDEO_VIDEO_CONFERENCING      = 0x0440;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.594 -0500", hash_original_field = "CBA9187AEF09C4BD741FB03F19F50768", hash_generated_field = "82BFDD7675AD9C7F075EF858511B48F0")

        public static final int AUDIO_VIDEO_VIDEO_GAMING_TOY        = 0x0448;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.596 -0500", hash_original_field = "15DD27289C950C2B3D32C35D9D977553", hash_generated_field = "BFA9A10B982FA062509841F89D22B1C2")

        public static final int WEARABLE_UNCATEGORIZED              = 0x0700;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.599 -0500", hash_original_field = "74C8897382621FDAAE4051C1FD13A5A9", hash_generated_field = "0E1F4092906E8BB1BE7521F62A107A43")

        public static final int WEARABLE_WRIST_WATCH                = 0x0704;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.601 -0500", hash_original_field = "4AB27C5F775F4BF08809C1D0B8D5802E", hash_generated_field = "98CBB0AFDA843F4E2D2536EAC10C5C19")

        public static final int WEARABLE_PAGER                      = 0x0708;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.604 -0500", hash_original_field = "131E04A04B791019134D9A4DA4F8A544", hash_generated_field = "ADFFD4644FAE0CFDBDE22812EF5D2BE2")

        public static final int WEARABLE_JACKET                     = 0x070C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.606 -0500", hash_original_field = "D3D0867A6128384A4207CD7D36F3FF45", hash_generated_field = "9E9801C9C7B29CFAABA799255FC359E2")

        public static final int WEARABLE_HELMET                     = 0x0710;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.609 -0500", hash_original_field = "A2C7E3B87443EC9C13E8F3E9AA46FBA3", hash_generated_field = "6E88341EADFCE2A808DDCDED3BCA7934")

        public static final int WEARABLE_GLASSES                    = 0x0714;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.611 -0500", hash_original_field = "E4A68CD14D3BE3A870C57B991985B8EE", hash_generated_field = "A43ADD697B3FDF8054EA682F6CFA2B81")

        public static final int TOY_UNCATEGORIZED                   = 0x0800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.613 -0500", hash_original_field = "ACE6D14EE52E39FFEC8A8451B4CF21CF", hash_generated_field = "495188A56512B96FBAE98AE54FBAA429")

        public static final int TOY_ROBOT                           = 0x0804;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.617 -0500", hash_original_field = "CB5ACC5F7142BAC09CD3FF99BE9BB82F", hash_generated_field = "AA99EA90E02C307BEC8341FEE6FB6279")

        public static final int TOY_VEHICLE                         = 0x0808;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.619 -0500", hash_original_field = "CCB90A8B67B2EB81A00FC62D95F3DB94", hash_generated_field = "BBFEA70B21BA0587C9F2B5F7BE2CDBA5")

        public static final int TOY_DOLL_ACTION_FIGURE              = 0x080C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.622 -0500", hash_original_field = "80135BB93058DE7E5F919AC80351F101", hash_generated_field = "33D175271E9664AB88B7A602DD1AB617")

        public static final int TOY_CONTROLLER                      = 0x0810;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.624 -0500", hash_original_field = "F0F00CA703C1CBC54443083917F58D2F", hash_generated_field = "DA3290FA7E9C7E9D93814B98EE04A515")

        public static final int TOY_GAME                            = 0x0814;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.626 -0500", hash_original_field = "6932E1EAE503D3D593D751AA4FA05E3B", hash_generated_field = "902547DE064CB82CE58DD0339CCD40B7")

        public static final int HEALTH_UNCATEGORIZED                = 0x0900;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.629 -0500", hash_original_field = "54A42C48176EEC5715946DB8831C914B", hash_generated_field = "F149BEE412B6382EEE143B8E392A1010")

        public static final int HEALTH_BLOOD_PRESSURE               = 0x0904;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.631 -0500", hash_original_field = "028265AB4C98000AB6E453C7025FF200", hash_generated_field = "AF8F277E6C00C657CE39C6FEEC87E78C")

        public static final int HEALTH_THERMOMETER                  = 0x0908;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.633 -0500", hash_original_field = "CB1172B15A0F12665A7F84AE43C6164B", hash_generated_field = "285F151F1E42C25CDFEF63B19E6BB1A5")

        public static final int HEALTH_WEIGHING                     = 0x090C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.636 -0500", hash_original_field = "46D2C5CBF01A57B1139D8A2D34A23A64", hash_generated_field = "C3ABE07575113BE2EA472012658D0245")

        public static final int HEALTH_GLUCOSE                      = 0x0910;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.639 -0500", hash_original_field = "1712A8AFA479345D5B78BB22610C8C36", hash_generated_field = "9914FD5B293554E187DF55ACD1E4CCFF")

        public static final int HEALTH_PULSE_OXIMETER               = 0x0914;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.641 -0500", hash_original_field = "AA7ED741E240AFCB481EE9BF4B21F8E0", hash_generated_field = "31043729EF5146088D95F1A18B0664D8")

        public static final int HEALTH_PULSE_RATE                   = 0x0918;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.644 -0500", hash_original_field = "860302A76C674F9A9E329B2828C09228", hash_generated_field = "756AB6E0C11C352198BB77C7FA4F4889")

        public static final int HEALTH_DATA_DISPLAY                 = 0x091C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.646 -0500", hash_original_field = "D807BFB657AF2F72D8155A1B3686A03D", hash_generated_field = "D46470F88A894ACD23F8750C416AABFD")

        /**
         * @hide
         */
        public static final int PERIPHERAL_NON_KEYBOARD_NON_POINTING = 0x0500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.649 -0500", hash_original_field = "653EFC2B911257BC35BD9DDAA9C0B9B7", hash_generated_field = "5DBD8F2EA8251AE65E76DBE7FBA5814A")

        public static final int PERIPHERAL_KEYBOARD                  = 0x0540;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.651 -0500", hash_original_field = "0FBDC00DF46D5BD201D1F655835B4E97", hash_generated_field = "28CA18D454E44629F46B0F93452200AF")

        public static final int PERIPHERAL_POINTING                  = 0x0580;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.653 -0500", hash_original_field = "58D84219D91D2FE17F35690935C3D0ED", hash_generated_field = "A043EA40D9B96761F7A26362300A0C7F")

        public static final int PERIPHERAL_KEYBOARD_POINTING         = 0x05C0;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.107 -0400", hash_original_method = "40AF3D7165C50C753FB5A8D2115663B9", hash_generated_method = "40AF3D7165C50C753FB5A8D2115663B9")
        public Device ()
        {
            //Synthesized constructor
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.437 -0500", hash_original_method = "874CCBA476992320BB2BF01B58BECDFE", hash_generated_method = "69DB1472F2B81EAEEF779A38A9EE8F0C")
    
@Override
    public int hashCode() {
        return mClass;
    }
    
    @DSComment("Bluetooth subsystem")
    @DSSpec(DSCat.BLUETOOTH)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.439 -0500", hash_original_method = "E65C8DBAA86595E02DE1992FA15205E3", hash_generated_method = "8D351E82FF3F21D76A924AE1FC9D0F5E")
    
@Override
    public String toString() {
        return Integer.toHexString(mClass);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.441 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.451 -0500", hash_original_method = "E9C9429EDCD73ADBF440E8A3499B15C0", hash_generated_method = "F328D5CA6A219B33DF9A01BF776F41E8")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mClass);
    }

    /**
     * Return true if the specified service class is supported by this
     * {@link BluetoothClass}.
     * <p>Valid service classes are the public constants in
     * {@link BluetoothClass.Service}. For example, {@link
     * BluetoothClass.Service#AUDIO}.
     *
     * @param service valid service class
     * @return true if the service class is supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.482 -0500", hash_original_method = "A40FEF9DD742C9180312A83CC46BA74D", hash_generated_method = "361D3D89F84B08660F7805B92FEDDB85")
    
public boolean hasService(int service) {
        return toTaintBoolean(mClass & Service.BITMASK & service); 
    }

    /**
     * Return the major device class component of this {@link BluetoothClass}.
     * <p>Values returned from this function can be compared with the
     * public constants in {@link BluetoothClass.Device.Major} to determine
     * which major class is encoded in this Bluetooth class.
     *
     * @return major device class component
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.660 -0500", hash_original_method = "3B15E8C4111EC35F10AF5C168F9A121C", hash_generated_method = "E36907ABD2D926BC80410DA751E44A09")
    
public int getMajorDeviceClass() {
        return (mClass & Device.Major.BITMASK);
    }

    /**
     * Return the (major and minor) device class component of this
     * {@link BluetoothClass}.
     * <p>Values returned from this function can be compared with the
     * public constants in {@link BluetoothClass.Device} to determine which
     * device class is encoded in this Bluetooth class.
     *
     * @return device class component
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.662 -0500", hash_original_method = "BA237D1BE1EA8EE11A66DDAAF0ED747D", hash_generated_method = "771C43732EC2FB8958C6B376C6A4572D")
    
public int getDeviceClass() {
        return (mClass & Device.BITMASK);
    }

    /**
     * Check class bits for possible bluetooth profile support.
     * This is a simple heuristic that tries to guess if a device with the
     * given class bits might support specified profile. It is not accurate for all
     * devices. It tries to err on the side of false positives.
     * @param profile The profile to be checked
     * @return True if this device might support specified profile.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:33.678 -0500", hash_original_method = "21B6C08F5C9193686AC48EB890043753", hash_generated_method = "1688924C06269CC56407DFDFB3878B74")
    
public boolean doesClassMatch(int profile) {
        if (profile == PROFILE_A2DP) {
            if (hasService(Service.RENDER)) {
                return true;
            }
            // By the A2DP spec, sinks must indicate the RENDER service.
            // However we found some that do not (Chordette). So lets also
            // match on some other class bits.
            switch (getDeviceClass()) {
                case Device.AUDIO_VIDEO_HIFI_AUDIO:
                case Device.AUDIO_VIDEO_HEADPHONES:
                case Device.AUDIO_VIDEO_LOUDSPEAKER:
                case Device.AUDIO_VIDEO_CAR_AUDIO:
                    return true;
                default:
                    return false;
            }
        } else if (profile == PROFILE_HEADSET) {
            // The render service class is required by the spec for HFP, so is a
            // pretty good signal
            if (hasService(Service.RENDER)) {
                return true;
            }
            // Just in case they forgot the render service class
            switch (getDeviceClass()) {
                case Device.AUDIO_VIDEO_HANDSFREE:
                case Device.AUDIO_VIDEO_WEARABLE_HEADSET:
                case Device.AUDIO_VIDEO_CAR_AUDIO:
                    return true;
                default:
                    return false;
            }
        } else if (profile == PROFILE_OPP) {
            if (hasService(Service.OBJECT_TRANSFER)) {
                return true;
            }

            switch (getDeviceClass()) {
                case Device.COMPUTER_UNCATEGORIZED:
                case Device.COMPUTER_DESKTOP:
                case Device.COMPUTER_SERVER:
                case Device.COMPUTER_LAPTOP:
                case Device.COMPUTER_HANDHELD_PC_PDA:
                case Device.COMPUTER_PALM_SIZE_PC_PDA:
                case Device.COMPUTER_WEARABLE:
                case Device.PHONE_UNCATEGORIZED:
                case Device.PHONE_CELLULAR:
                case Device.PHONE_CORDLESS:
                case Device.PHONE_SMART:
                case Device.PHONE_MODEM_OR_GATEWAY:
                case Device.PHONE_ISDN:
                    return true;
                default:
                    return false;
            }
        }

        return toTaintBoolean(profile + getDeviceClass() + toTaintInt(hasService(profile)));
        
        /*
         else if (profile == PROFILE_HID) {
            return toTaintBoolean(getDeviceClass() & Device.Major.PERIPHERAL + Device.Major.PERIPHERAL); 
        } else if (profile == PROFILE_PANU || profile == PROFILE_NAP){
            // No good way to distinguish between the two, based on class bits.
            if (hasService(Service.NETWORKING)) {
                return true;
            }
            return toTaintBoolean(getDeviceClass() & Device.Major.NETWORKING + Device.Major.NETWORKING + );
        } else {
            return false;
        }
        */
    }
}

