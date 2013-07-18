package android.bluetooth;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class BluetoothClass implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.096 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private int mClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.096 -0400", hash_original_method = "3018CA2607FD366405F97E43B06E77B3", hash_generated_method = "90B904425EE4604164B554F63464E722")
    public  BluetoothClass(int classInt) {
        mClass = classInt;
        // ---------- Original Method ----------
        //mClass = classInt;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.097 -0400", hash_original_method = "217E4DCE2F47DBEE08566901FB7CC9C3", hash_generated_method = "2AD04288D39D0980435A669B45CFF9A4")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o instanceof BluetoothClass)        
        {
            boolean var9111256F314568154B4EAFB32B65F8B0_1016746952 = (mClass == ((BluetoothClass)o).mClass);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_913121996 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_913121996;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1679618777 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737634007 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737634007;
        // ---------- Original Method ----------
        //if (o instanceof BluetoothClass) {
            //return mClass == ((BluetoothClass)o).mClass;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.098 -0400", hash_original_method = "874CCBA476992320BB2BF01B58BECDFE", hash_generated_method = "34A5065D06A7AE03D9095C13FBDF5997")
    @Override
    public int hashCode() {
        int var3C06167D41E761EA62261D0BFD22DD5C_1925848656 = (mClass);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883565414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883565414;
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.098 -0400", hash_original_method = "E65C8DBAA86595E02DE1992FA15205E3", hash_generated_method = "5572DD741FE98E74E57CC2E7F3D77831")
    @Override
    public String toString() {
String varE79732AA16E5FC09BDC824B127CB6617_1323526015 =         Integer.toHexString(mClass);
        varE79732AA16E5FC09BDC824B127CB6617_1323526015.addTaint(taint);
        return varE79732AA16E5FC09BDC824B127CB6617_1323526015;
        // ---------- Original Method ----------
        //return Integer.toHexString(mClass);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.099 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4C759EA52A79FAC08853837EB8F29E78")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1032772371 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396276841 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396276841;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.099 -0400", hash_original_method = "E9C9429EDCD73ADBF440E8A3499B15C0", hash_generated_method = "973408289130F53837BAE20C65873B50")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeInt(mClass);
        // ---------- Original Method ----------
        //out.writeInt(mClass);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.100 -0400", hash_original_method = "A40FEF9DD742C9180312A83CC46BA74D", hash_generated_method = "172C688189FC4A90991CD884B72954B1")
    public boolean hasService(int service) {
        addTaint(service);
        boolean var23E09A6742DA5A33ED83AAC695B37ED9_2106679989 = (((mClass & Service.BITMASK & service) != 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1264536067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1264536067;
        // ---------- Original Method ----------
        //return ((mClass & Service.BITMASK & service) != 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.100 -0400", hash_original_method = "3B15E8C4111EC35F10AF5C168F9A121C", hash_generated_method = "E1A7862AA08D74BAC71C1CABA9D0307F")
    public int getMajorDeviceClass() {
        int var3AEA43EC55D211279D605E0296A1D8FE_305044671 = ((mClass & Device.Major.BITMASK));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282799715 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282799715;
        // ---------- Original Method ----------
        //return (mClass & Device.Major.BITMASK);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.101 -0400", hash_original_method = "BA237D1BE1EA8EE11A66DDAAF0ED747D", hash_generated_method = "B4D58E25F1990C8F88DE12C2EB07C446")
    public int getDeviceClass() {
        int var3218FC416E2249A00358985692C83844_127238640 = ((mClass & Device.BITMASK));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530558128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530558128;
        // ---------- Original Method ----------
        //return (mClass & Device.BITMASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.102 -0400", hash_original_method = "21B6C08F5C9193686AC48EB890043753", hash_generated_method = "C83EC8E1839BDE6B961676D189C1CE6D")
    public boolean doesClassMatch(int profile) {
        addTaint(profile);
        if(profile == PROFILE_A2DP)        
        {
            if(hasService(Service.RENDER))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1535773103 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681987428 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_681987428;
            } //End block
switch(getDeviceClass()){
            case Device.AUDIO_VIDEO_HIFI_AUDIO:
            case Device.AUDIO_VIDEO_HEADPHONES:
            case Device.AUDIO_VIDEO_LOUDSPEAKER:
            case Device.AUDIO_VIDEO_CAR_AUDIO:
            boolean varB326B5062B2F0E69046810717534CB09_1784463290 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201280413 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201280413;
            default:
            boolean var68934A3E9455FA72420237EB05902327_1917696966 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656705442 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656705442;
}
        } //End block
        else
        if(profile == PROFILE_HEADSET)        
        {
            if(hasService(Service.RENDER))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1077126867 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1170304760 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1170304760;
            } //End block
switch(getDeviceClass()){
            case Device.AUDIO_VIDEO_HANDSFREE:
            case Device.AUDIO_VIDEO_WEARABLE_HEADSET:
            case Device.AUDIO_VIDEO_CAR_AUDIO:
            boolean varB326B5062B2F0E69046810717534CB09_877474164 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387478298 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_387478298;
            default:
            boolean var68934A3E9455FA72420237EB05902327_1193182429 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140487260 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140487260;
}
        } //End block
        else
        if(profile == PROFILE_OPP)        
        {
            if(hasService(Service.OBJECT_TRANSFER))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_830183753 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1263655664 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1263655664;
            } //End block
switch(getDeviceClass()){
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
            boolean varB326B5062B2F0E69046810717534CB09_2142573689 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763648433 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763648433;
            default:
            boolean var68934A3E9455FA72420237EB05902327_1703212164 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_198077068 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_198077068;
}
        } //End block
        else
        if(profile == PROFILE_HID)        
        {
            boolean var3CC75CFCE60D826E6342F8CB2DDDF94E_766864292 = ((getDeviceClass() & Device.Major.PERIPHERAL) == Device.Major.PERIPHERAL);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_860087996 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_860087996;
        } //End block
        else
        if(profile == PROFILE_PANU || profile == PROFILE_NAP)        
        {
            if(hasService(Service.NETWORKING))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1746479635 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432335075 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_432335075;
            } //End block
            boolean var37FC5865FE6840C2AA64A8ABDDC31039_1466720563 = ((getDeviceClass() & Device.Major.NETWORKING) == Device.Major.NETWORKING);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141088785 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141088785;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1352418120 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954212564 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954212564;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final class Service {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.104 -0400", hash_original_method = "05DD0D3AE8FB07CCF5507C6E023C1B78", hash_generated_method = "05DD0D3AE8FB07CCF5507C6E023C1B78")
        public Service ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.104 -0400", hash_original_field = "80729FF98266C192F4BBDE183B0D1ED1", hash_generated_field = "426959E7E86F5DF5ED12EDB76E954DA5")

        private static final int BITMASK = 0xFFE000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.104 -0400", hash_original_field = "D515AD3E7A1791EDE300224BC8505694", hash_generated_field = "5E269E79168551A0C4298C7721D7C84C")

        public static final int LIMITED_DISCOVERABILITY = 0x002000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.104 -0400", hash_original_field = "9AEAEB4E25508742187A76F66F6BDF19", hash_generated_field = "00734D753B05B56395771F5D6B15AA89")

        public static final int POSITIONING             = 0x010000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.104 -0400", hash_original_field = "00077036FF4170D82A56EF0CEF90F54C", hash_generated_field = "57E34F92FA7FB3C39407E2783912125F")

        public static final int NETWORKING              = 0x020000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.105 -0400", hash_original_field = "463BC3911B8565EE667E4746D5D33C2C", hash_generated_field = "D689848649BC0E11CE503A46AA632311")

        public static final int RENDER                  = 0x040000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.105 -0400", hash_original_field = "541373CBFF3B27F014FD18EDCECA1DB9", hash_generated_field = "B029AA216B734D760B152782F48CC625")

        public static final int CAPTURE                 = 0x080000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.105 -0400", hash_original_field = "FD14C11C32DD74495F893C83F077A932", hash_generated_field = "A401C713A59B2BC32203E29052452FB7")

        public static final int OBJECT_TRANSFER         = 0x100000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.105 -0400", hash_original_field = "0B9AC498C6217388288E4F1018BCBD3E", hash_generated_field = "DFFF955DD91969B8962B3B55CE54F951")

        public static final int AUDIO                   = 0x200000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.105 -0400", hash_original_field = "2231E7A6E609B09972FC605F1A252E60", hash_generated_field = "07EF9D4EFBA2B67E1D090688D094DFEB")

        public static final int TELEPHONY               = 0x400000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.105 -0400", hash_original_field = "FD45A814C0D4E2790151DD97CFFC8972", hash_generated_field = "274077874B28B5CBF7EBAC4E40184DBE")

        public static final int INFORMATION             = 0x800000;
    }


    
    public static class Device {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.107 -0400", hash_original_method = "40AF3D7165C50C753FB5A8D2115663B9", hash_generated_method = "40AF3D7165C50C753FB5A8D2115663B9")
        public Device ()
        {
            //Synthesized constructor
        }


        public static class Major {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.108 -0400", hash_original_method = "2C98A313400B6C1B74CB3BC1CC68B05F", hash_generated_method = "2C98A313400B6C1B74CB3BC1CC68B05F")
            public Major ()
            {
                //Synthesized constructor
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.109 -0400", hash_original_field = "7A655AE88750405178EE371B7D49422A", hash_generated_field = "B141CF4C38B0F742777D6B2BC51B9A0B")

            private static final int BITMASK = 0x1F00;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.109 -0400", hash_original_field = "B2096F2414222C2141A1479D75E89D77", hash_generated_field = "AE466877227B4A952D2138EB1029E3C6")

            public static final int MISC              = 0x0000;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.109 -0400", hash_original_field = "7ABCB2852A1955F6D460359882F5B3F2", hash_generated_field = "20E6C2C42D683E45418599697445F839")

            public static final int COMPUTER          = 0x0100;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.109 -0400", hash_original_field = "7DF1B6373C94636B3E4249A793ADA20B", hash_generated_field = "7751A32A7B23E6C93ED0B1D04495FD64")

            public static final int PHONE             = 0x0200;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.110 -0400", hash_original_field = "F729A6171A047E376E86C517980594E5", hash_generated_field = "E7242554DBE08DA7B464202AA58A96C5")

            public static final int NETWORKING        = 0x0300;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.110 -0400", hash_original_field = "247B595C5227EF472B6C2F8D18FCA041", hash_generated_field = "C306D7248EEC193A57D50AFCB0A3C6A1")

            public static final int AUDIO_VIDEO       = 0x0400;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.110 -0400", hash_original_field = "970A218A84E31A8416190C5CA2AE7C2D", hash_generated_field = "6A476AB4E3FEE2B9C13C9BF02FD8EB26")

            public static final int PERIPHERAL        = 0x0500;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.110 -0400", hash_original_field = "AC2AB0700C5B5CE721A637489CD6CB3A", hash_generated_field = "E504572D9609AB99E895BD86FD486683")

            public static final int IMAGING           = 0x0600;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.110 -0400", hash_original_field = "8A76B663954D9E7A09EA314DF4A911DC", hash_generated_field = "AB8BE7F4132005677524133CCF8CA9E1")

            public static final int WEARABLE          = 0x0700;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.111 -0400", hash_original_field = "0BCE87D07BE44B978E16CDCC3E2E179D", hash_generated_field = "C3B922AB8D0BDC061F8F292B7FD3A613")

            public static final int TOY               = 0x0800;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.111 -0400", hash_original_field = "CE09EDC8E7E789B32C59E567E6D8D71F", hash_generated_field = "C8BB43E7664CF6B2F072D804EF5623CA")

            public static final int HEALTH            = 0x0900;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.111 -0400", hash_original_field = "45925CE8FE4779CF6EE414339D626C4B", hash_generated_field = "4E50DC61372853B626C7816F227F267C")

            public static final int UNCATEGORIZED     = 0x1F00;
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.111 -0400", hash_original_field = "A95AD4D0DAE6D05FE5F8809F1E71EEFB", hash_generated_field = "1D5B39E9B9B878FCC7CCB5BCFF59714D")

        private static final int BITMASK = 0x1FFC;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.111 -0400", hash_original_field = "34D90082F895776E74D6970554DC6FF1", hash_generated_field = "7CCC31D805A8EE2D8A9CA9D848361480")

        public static final int COMPUTER_UNCATEGORIZED              = 0x0100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.112 -0400", hash_original_field = "6915D285D356B1D9E1991D4B678E99BE", hash_generated_field = "BE8D9E15C6B5EEAEA4BEDBCBE695E82F")

        public static final int COMPUTER_DESKTOP                    = 0x0104;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.112 -0400", hash_original_field = "FA0A7898F7EE1C5C38C88577BD517DA7", hash_generated_field = "DE193BEFB322EE44F1BA9B2C2782B021")

        public static final int COMPUTER_SERVER                     = 0x0108;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.112 -0400", hash_original_field = "F05CA36CF562537C2B5EE9AD72473AFF", hash_generated_field = "6098C07B025EB49297B2FE3949A03BDA")

        public static final int COMPUTER_LAPTOP                     = 0x010C;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.112 -0400", hash_original_field = "8275A9633359871F552FBDCF7E0C532A", hash_generated_field = "BDB6EB7666F87D7C5DF367F66D1D5BEF")

        public static final int COMPUTER_HANDHELD_PC_PDA            = 0x0110;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.112 -0400", hash_original_field = "382D698CC65742F4EAFD2DCA3290397F", hash_generated_field = "46CDC92B39391ECE87CEE11A3A779722")

        public static final int COMPUTER_PALM_SIZE_PC_PDA           = 0x0114;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.112 -0400", hash_original_field = "94B4A9075349E4449AB75AE8F34AC2C2", hash_generated_field = "63FBDDE763CB7661EB53A5E5DF9A26C1")

        public static final int COMPUTER_WEARABLE                   = 0x0118;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.112 -0400", hash_original_field = "A0B5C237CA277988A823B7D76F50B45D", hash_generated_field = "1EA634B1743D54B6E7789E83FCDBB3D1")

        public static final int PHONE_UNCATEGORIZED                 = 0x0200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.112 -0400", hash_original_field = "C0C9091364DA04BC109A6239E7CAE781", hash_generated_field = "2843D03A87C50E2859028396546AB438")

        public static final int PHONE_CELLULAR                      = 0x0204;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.113 -0400", hash_original_field = "D90C992AF5DC55F6EE2486CC8E4D5E76", hash_generated_field = "0FDD8E51236A607121ED6B74C9ED9509")

        public static final int PHONE_CORDLESS                      = 0x0208;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.113 -0400", hash_original_field = "1C0EE30AE22BC230CD28184A365F39B0", hash_generated_field = "056904CEF5068736C8936BBD2E5ECC0B")

        public static final int PHONE_SMART                         = 0x020C;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.113 -0400", hash_original_field = "8E15CC95E38FEDC6C3C51A189A8B020A", hash_generated_field = "C45B573DA1724853BF0385C7CC35E057")

        public static final int PHONE_MODEM_OR_GATEWAY              = 0x0210;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.113 -0400", hash_original_field = "7AAFC1AA8A6B86185806F301D80F4560", hash_generated_field = "53AFC0B301B83A1E5F245642A43F04E2")

        public static final int PHONE_ISDN                          = 0x0214;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.113 -0400", hash_original_field = "F029E1321B5188A721D55B3D1E81E3C1", hash_generated_field = "B67EC1F8551E2D43EB168557214193A5")

        public static final int AUDIO_VIDEO_UNCATEGORIZED           = 0x0400;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.113 -0400", hash_original_field = "F09AA180BD99CA84B84EFEF59C176E90", hash_generated_field = "4873C0C3F3145AC11BC4468EA5A8CC5C")

        public static final int AUDIO_VIDEO_WEARABLE_HEADSET        = 0x0404;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.113 -0400", hash_original_field = "F8678C49D7A5B3B7ED71C80ACB14E8FA", hash_generated_field = "4135F1D666D889D649AFC4AF625BE41A")

        public static final int AUDIO_VIDEO_HANDSFREE               = 0x0408;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.113 -0400", hash_original_field = "9915439E10F3890E852EEF68C132A525", hash_generated_field = "A6BA5F3488F608A8BF8A07A06F81C078")

        public static final int AUDIO_VIDEO_MICROPHONE              = 0x0410;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.114 -0400", hash_original_field = "9D26B5FDACA28DECDF1D9B14804F9AA5", hash_generated_field = "3035221D6461054099A9F43B0831D657")

        public static final int AUDIO_VIDEO_LOUDSPEAKER             = 0x0414;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.114 -0400", hash_original_field = "A5FC5B2A4448476DC9623FE968358B72", hash_generated_field = "32C1EC1ECEC4AD4FDB20846AA101D9F0")

        public static final int AUDIO_VIDEO_HEADPHONES              = 0x0418;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.114 -0400", hash_original_field = "326D606C7345E3206AACA63F4EA76008", hash_generated_field = "BD761020F273BD8CF6C831B0CD986DC3")

        public static final int AUDIO_VIDEO_PORTABLE_AUDIO          = 0x041C;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.114 -0400", hash_original_field = "11D9684FE7F8012A4FAED9C046EB9B23", hash_generated_field = "24BD0370AA04AB5A0A0840243548D9DB")

        public static final int AUDIO_VIDEO_CAR_AUDIO               = 0x0420;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.114 -0400", hash_original_field = "0773F6B327334BD9BCDC992DF35BBBDA", hash_generated_field = "6541E3CCF65B5AF295DEABDC60208625")

        public static final int AUDIO_VIDEO_SET_TOP_BOX             = 0x0424;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.114 -0400", hash_original_field = "9CDFD01723F199407537843221AE0852", hash_generated_field = "AFCB247E572ACE2CF6C4518D97071B60")

        public static final int AUDIO_VIDEO_HIFI_AUDIO              = 0x0428;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.114 -0400", hash_original_field = "C892B915DC72E392E378F86AD41FF383", hash_generated_field = "1EB7300F1066D52D4253754811CC07DD")

        public static final int AUDIO_VIDEO_VCR                     = 0x042C;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.115 -0400", hash_original_field = "74D0151F7351C449377DF85E51AB33CE", hash_generated_field = "0BA18F7DEFC21431D9013937E793D181")

        public static final int AUDIO_VIDEO_VIDEO_CAMERA            = 0x0430;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.115 -0400", hash_original_field = "706CBEFB760999305EF0FF8E3AA85B9C", hash_generated_field = "74C94BEBED47932C15634AE962E86EF5")

        public static final int AUDIO_VIDEO_CAMCORDER               = 0x0434;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.115 -0400", hash_original_field = "76BD180245C7EF4FFC4B691B3421F595", hash_generated_field = "A41F49ECB1181C37D7D924CB026AB851")

        public static final int AUDIO_VIDEO_VIDEO_MONITOR           = 0x0438;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.115 -0400", hash_original_field = "FA898DA1CD137C746207D552C7E19FDB", hash_generated_field = "BEF3EF7EF0FD9E376DC62129B349012B")

        public static final int AUDIO_VIDEO_VIDEO_DISPLAY_AND_LOUDSPEAKER = 0x043C;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.115 -0400", hash_original_field = "CD7EAD653D7BF6851206CA0FD755E526", hash_generated_field = "0208BE889A9BDB60FBB73BF4E93C9360")

        public static final int AUDIO_VIDEO_VIDEO_CONFERENCING      = 0x0440;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.115 -0400", hash_original_field = "66BEDB8065EFF2F7DB293E862D992C2F", hash_generated_field = "82BFDD7675AD9C7F075EF858511B48F0")

        public static final int AUDIO_VIDEO_VIDEO_GAMING_TOY        = 0x0448;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.116 -0400", hash_original_field = "6954C3DB7DEAB994CE1888E95626E726", hash_generated_field = "BFA9A10B982FA062509841F89D22B1C2")

        public static final int WEARABLE_UNCATEGORIZED              = 0x0700;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.116 -0400", hash_original_field = "D0E0BF9286E84C60813B2C26B55C49A7", hash_generated_field = "0E1F4092906E8BB1BE7521F62A107A43")

        public static final int WEARABLE_WRIST_WATCH                = 0x0704;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.116 -0400", hash_original_field = "70D48EE426872E941B7AA71A836BE06F", hash_generated_field = "98CBB0AFDA843F4E2D2536EAC10C5C19")

        public static final int WEARABLE_PAGER                      = 0x0708;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.116 -0400", hash_original_field = "F3C56D06BD18F991F0148D74381C4FDA", hash_generated_field = "ADFFD4644FAE0CFDBDE22812EF5D2BE2")

        public static final int WEARABLE_JACKET                     = 0x070C;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.116 -0400", hash_original_field = "8C41629F6F9EE2513D662D009A1947A7", hash_generated_field = "9E9801C9C7B29CFAABA799255FC359E2")

        public static final int WEARABLE_HELMET                     = 0x0710;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.117 -0400", hash_original_field = "90DD28A2499F18A70ECCC818EB8B1786", hash_generated_field = "6E88341EADFCE2A808DDCDED3BCA7934")

        public static final int WEARABLE_GLASSES                    = 0x0714;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.117 -0400", hash_original_field = "F81610A80B9A0C6B3A926A3206A7822A", hash_generated_field = "A43ADD697B3FDF8054EA682F6CFA2B81")

        public static final int TOY_UNCATEGORIZED                   = 0x0800;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.117 -0400", hash_original_field = "64B4D73B6F63914A560361DE35233D65", hash_generated_field = "495188A56512B96FBAE98AE54FBAA429")

        public static final int TOY_ROBOT                           = 0x0804;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.117 -0400", hash_original_field = "F0D710091E5E62720F2ED631A1239473", hash_generated_field = "AA99EA90E02C307BEC8341FEE6FB6279")

        public static final int TOY_VEHICLE                         = 0x0808;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.117 -0400", hash_original_field = "6A754F89327E0C8775E0CB6F1F618B4D", hash_generated_field = "BBFEA70B21BA0587C9F2B5F7BE2CDBA5")

        public static final int TOY_DOLL_ACTION_FIGURE              = 0x080C;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.118 -0400", hash_original_field = "D7F900B9E0148AF1BC8ABDBB2CE7F703", hash_generated_field = "33D175271E9664AB88B7A602DD1AB617")

        public static final int TOY_CONTROLLER                      = 0x0810;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.118 -0400", hash_original_field = "2CD6699F6FD42141C2C8FFA1B5184B02", hash_generated_field = "DA3290FA7E9C7E9D93814B98EE04A515")

        public static final int TOY_GAME                            = 0x0814;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.118 -0400", hash_original_field = "5D28703A59CA31F238F4E4F3B1FD6319", hash_generated_field = "902547DE064CB82CE58DD0339CCD40B7")

        public static final int HEALTH_UNCATEGORIZED                = 0x0900;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.118 -0400", hash_original_field = "9D8B2186CA892EF619D44821979E27F6", hash_generated_field = "F149BEE412B6382EEE143B8E392A1010")

        public static final int HEALTH_BLOOD_PRESSURE               = 0x0904;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.119 -0400", hash_original_field = "1A1F7845FD6895C01BCADC63AD4A2F4D", hash_generated_field = "AF8F277E6C00C657CE39C6FEEC87E78C")

        public static final int HEALTH_THERMOMETER                  = 0x0908;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.119 -0400", hash_original_field = "D12259A600C8137A49E5C61AF530AA97", hash_generated_field = "285F151F1E42C25CDFEF63B19E6BB1A5")

        public static final int HEALTH_WEIGHING                     = 0x090C;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.119 -0400", hash_original_field = "C4A21F26FDD896C64B9C1ED793D158FF", hash_generated_field = "C3ABE07575113BE2EA472012658D0245")

        public static final int HEALTH_GLUCOSE                      = 0x0910;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.119 -0400", hash_original_field = "7D50FFD0E35000DCA4085E80209BB20F", hash_generated_field = "9914FD5B293554E187DF55ACD1E4CCFF")

        public static final int HEALTH_PULSE_OXIMETER               = 0x0914;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.120 -0400", hash_original_field = "8971B36C6CBFA6492B84FA998ADF213F", hash_generated_field = "31043729EF5146088D95F1A18B0664D8")

        public static final int HEALTH_PULSE_RATE                   = 0x0918;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.120 -0400", hash_original_field = "E11C4286D6B7890F15B8D65CF696F60B", hash_generated_field = "756AB6E0C11C352198BB77C7FA4F4889")

        public static final int HEALTH_DATA_DISPLAY                 = 0x091C;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.120 -0400", hash_original_field = "5D6AFC1B6D10D777A5B3DC6116ADB3EB", hash_generated_field = "80A10E0379C16E9925BEFF578DCFB96C")

        public static final int PERIPHERAL_NON_KEYBOARD_NON_POINTING = 0x0500;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.120 -0400", hash_original_field = "91BC3037BE23083F60D48FA18D93018C", hash_generated_field = "5DBD8F2EA8251AE65E76DBE7FBA5814A")

        public static final int PERIPHERAL_KEYBOARD                  = 0x0540;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.120 -0400", hash_original_field = "595A4E746A65C154B0586F697C835780", hash_generated_field = "28CA18D454E44629F46B0F93452200AF")

        public static final int PERIPHERAL_POINTING                  = 0x0580;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.121 -0400", hash_original_field = "DB9C997F9F0DE0FA407915A2134A8F79", hash_generated_field = "A043EA40D9B96761F7A26362300A0C7F")

        public static final int PERIPHERAL_KEYBOARD_POINTING         = 0x05C0;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.121 -0400", hash_original_field = "20ABA48AEF5F40A0A59CD702B2CF2100", hash_generated_field = "0A8DCF3C3E9335974986AC8A09465280")

    public static final int ERROR = 0xFF000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.121 -0400", hash_original_field = "08D493A5CC11EE6A51032CBFE445C1B8", hash_generated_field = "178124FDE61E60B254E623C79893E54C")

    public static final Parcelable.Creator<BluetoothClass> CREATOR =
            new Parcelable.Creator<BluetoothClass>() {
        public BluetoothClass createFromParcel(Parcel in) {
            return new BluetoothClass(in.readInt());
        }
        public BluetoothClass[] newArray(int size) {
            return new BluetoothClass[size];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.121 -0400", hash_original_field = "88D7D09FD2EB036A765E2C2AE1821B14", hash_generated_field = "A91F1554D03F2D40F0EF435E5BB76145")

    public static final int PROFILE_HEADSET = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.121 -0400", hash_original_field = "2425CEF76A12928163395327FFE2C041", hash_generated_field = "1C6F840769C10DB10D56FE733287FEEE")

    public static final int PROFILE_A2DP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.122 -0400", hash_original_field = "F0B3D1F02B3657EF4A34D3B39DF35A9A", hash_generated_field = "7E44908C560873B4D43C2A27F061145E")

    public static final int PROFILE_OPP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.122 -0400", hash_original_field = "80FDC6BB8694A4E4D133F3FFA179F54C", hash_generated_field = "15D963CF89E9BFF8839D7F44F3F1A528")

    public static final int PROFILE_HID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.122 -0400", hash_original_field = "3267A5800EA35A659FD3F90FDCF50451", hash_generated_field = "DD5FDE600B2EE78E730FC60290848DC2")

    public static final int PROFILE_PANU = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.122 -0400", hash_original_field = "CB263DB59D2A8EC72ACF91F631AE6324", hash_generated_field = "8E1DD5D84A7BBA78C1846DC1987F993C")

    public static final int PROFILE_NAP = 5;
}

