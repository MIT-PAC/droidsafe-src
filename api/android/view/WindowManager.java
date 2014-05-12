package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;

public interface WindowManager extends ViewManager {
    
    public static class BadTokenException extends RuntimeException {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.651 -0500", hash_original_method = "B9154FA54F9E87F1168DB918C99950C2", hash_generated_method = "22DF13C3FD6A0238F3E2806F7E1B8FA1")
        
public BadTokenException() {
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.654 -0500", hash_original_method = "21B94DB35E7799DA44FD7BD9793AF220", hash_generated_method = "EEBE5983CA4575E766D2CECF025A20AD")
        
public BadTokenException(String name) {
            super(name);
        }
    }
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public Display getDefaultDisplay();
    
    public void removeViewImmediate(View view);
    
    public boolean isHardwareAccelerated();
    
    public static class LayoutParams extends ViewGroup.LayoutParams
            implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.675 -0500", hash_original_field = "BE91FB12342D475796E494412C8FAFEB", hash_generated_field = "AEE0C36B400F914B70ABC4DB38E7690B")

        public static final int FIRST_APPLICATION_WINDOW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.678 -0500", hash_original_field = "3DC12055132A24F03443FB4EC850CB30", hash_generated_field = "CC095E99F519338A7153B1C3FBBB8BDB")

        public static final int TYPE_BASE_APPLICATION   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.681 -0500", hash_original_field = "6D6D835E55BFEF69A8EA803E748816FC", hash_generated_field = "13C9297BFA024D4A9A00D9B51A8B16A7")

        public static final int TYPE_APPLICATION        = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.684 -0500", hash_original_field = "CEC2CB2BA21270E6A2476A3C5549D010", hash_generated_field = "FB29C4EE7F4F98725B2C50D5990522AA")

        public static final int TYPE_APPLICATION_STARTING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.687 -0500", hash_original_field = "A33908D6BAC9D047F0DD4B4C21FFBF0B", hash_generated_field = "59E4C9EA6E215432C66EDCC1A937120F")

        public static final int LAST_APPLICATION_WINDOW = 99;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.691 -0500", hash_original_field = "BD68FB4080CF22C37FB1CFDFBCE19AD1", hash_generated_field = "921BDC5549B868EA4BE225979C7224EF")

        public static final int FIRST_SUB_WINDOW        = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.694 -0500", hash_original_field = "C233A2531CA7EFEE874086D0E1A82D71", hash_generated_field = "7A83D32C16776069F86B77F6D49C7ED9")

        public static final int TYPE_APPLICATION_PANEL  = FIRST_SUB_WINDOW;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.696 -0500", hash_original_field = "BBB47A4B00D00EA3BE79DBE66665DD39", hash_generated_field = "50BA752156440112F7171741E31C944E")

        public static final int TYPE_APPLICATION_MEDIA  = FIRST_SUB_WINDOW+1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.699 -0500", hash_original_field = "380A56E8F1A52005751B310D1CF61536", hash_generated_field = "FE1AE1A526FCCB3C18A711D481ED41B7")

        public static final int TYPE_APPLICATION_SUB_PANEL = FIRST_SUB_WINDOW+2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.702 -0500", hash_original_field = "5DFDB6BC6857D8C2ED47B829822A95B0", hash_generated_field = "AE8EF51E47CF3D3BDF4C8F6B5DB5A627")

        public static final int TYPE_APPLICATION_ATTACHED_DIALOG = FIRST_SUB_WINDOW+3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.704 -0500", hash_original_field = "5B35C46EE256883990667BEF8FDDCEC2", hash_generated_field = "11642323D2691DC71BC5EFBB918A33C5")

        public static final int TYPE_APPLICATION_MEDIA_OVERLAY  = FIRST_SUB_WINDOW+4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.708 -0500", hash_original_field = "08E7985BE4DF4E737C812ED889ABA318", hash_generated_field = "00F90F8F9E0AA5AA590382C4F8A49C14")

        public static final int LAST_SUB_WINDOW         = 1999;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.710 -0500", hash_original_field = "A9E941D4A1E3DEDCB96B63DD26F81A7D", hash_generated_field = "B5AA836F3CBA2AC27BD28170203222D2")

        public static final int FIRST_SYSTEM_WINDOW     = 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.713 -0500", hash_original_field = "DC951E8780E441A6F57D834B1B49F1E7", hash_generated_field = "9D51C9E5A92E1217FCD3D32116352968")

        public static final int TYPE_STATUS_BAR         = FIRST_SYSTEM_WINDOW;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.716 -0500", hash_original_field = "02E7A609D25B11ADB49810C1EFCDACCC", hash_generated_field = "224BD7FE28D1073DB1B1C06766D19F5C")

        public static final int TYPE_SEARCH_BAR         = FIRST_SYSTEM_WINDOW+1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.719 -0500", hash_original_field = "A667E3FE51B9D4A36F54C2D63E974AE4", hash_generated_field = "B0695CCBCBFFEFFBCEB60E2ADF964B95")

        public static final int TYPE_PHONE              = FIRST_SYSTEM_WINDOW+2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.722 -0500", hash_original_field = "831476FCD6C3760A4C967313A9C9B146", hash_generated_field = "A523A6F914DC5184948297B6DE6E3FC1")

        public static final int TYPE_SYSTEM_ALERT       = FIRST_SYSTEM_WINDOW+3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.724 -0500", hash_original_field = "4F961CFC1F076D7363A10873CA82E1A6", hash_generated_field = "F09AF05F8F22D1A7C401A51B75D8C00F")

        public static final int TYPE_KEYGUARD           = FIRST_SYSTEM_WINDOW+4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.727 -0500", hash_original_field = "C3657011EAFA3BB98980B95DEC582FE2", hash_generated_field = "D57E3F4DC1A837230EB44AF838A7419F")

        public static final int TYPE_TOAST              = FIRST_SYSTEM_WINDOW+5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.730 -0500", hash_original_field = "9379BFD3BBD28DFB77AA3573F21698BD", hash_generated_field = "5883FCF6A74A9557849A49F9542A69F5")

        public static final int TYPE_SYSTEM_OVERLAY     = FIRST_SYSTEM_WINDOW+6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.732 -0500", hash_original_field = "23AC554385EBB691A48E7C932587C07B", hash_generated_field = "BC53892051D4DF7B072229967004742D")

        public static final int TYPE_PRIORITY_PHONE     = FIRST_SYSTEM_WINDOW+7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.736 -0500", hash_original_field = "77861231ADB3FC1DEA25B825FEE627C3", hash_generated_field = "ECE23530C91910FC2D455FE48767F70E")

        public static final int TYPE_SYSTEM_DIALOG      = FIRST_SYSTEM_WINDOW+8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.739 -0500", hash_original_field = "DF7FA0B84ADF48787A12371406B9D16A", hash_generated_field = "6B0A619F7C746591EAE4C93FBEF1BFAC")

        public static final int TYPE_KEYGUARD_DIALOG    = FIRST_SYSTEM_WINDOW+9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.742 -0500", hash_original_field = "F504A26A6B20E63122E09C3A1BFC99F3", hash_generated_field = "1C16FD35582F8EE5666F71C05BFD4BCD")

        public static final int TYPE_SYSTEM_ERROR       = FIRST_SYSTEM_WINDOW+10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.745 -0500", hash_original_field = "B33EC99A912DCAEBE8A900FDB06B5936", hash_generated_field = "3B570C54FA2E69E0A0AEAB724DF0740C")

        public static final int TYPE_INPUT_METHOD       = FIRST_SYSTEM_WINDOW+11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.747 -0500", hash_original_field = "899F47FF0458FFC3A80BB35FC11880BC", hash_generated_field = "2654490CF448B1F454FF2C9616A45527")

        public static final int TYPE_INPUT_METHOD_DIALOG= FIRST_SYSTEM_WINDOW+12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.750 -0500", hash_original_field = "D9970871C202E16D1F0C408C28AAD6E2", hash_generated_field = "9DABFFF866226C24C847AD7ED8218009")

        public static final int TYPE_WALLPAPER          = FIRST_SYSTEM_WINDOW+13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.754 -0500", hash_original_field = "42446209B9DB9DB9823EC535702B1566", hash_generated_field = "91A2507FAC52B834DEB10D06E5CA84B5")

        public static final int TYPE_STATUS_BAR_PANEL   = FIRST_SYSTEM_WINDOW+14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.757 -0500", hash_original_field = "D443E0B181E3B7B600D360CBD8114E06", hash_generated_field = "AF42D6C2ED4BAB7DF167331D8901A310")

        public static final int TYPE_SECURE_SYSTEM_OVERLAY = FIRST_SYSTEM_WINDOW+15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.760 -0500", hash_original_field = "52F69B4247EB4742D187250AD271C63B", hash_generated_field = "F0D10760DC4CFEAD50AAD007AA1AD798")

        public static final int TYPE_DRAG               = FIRST_SYSTEM_WINDOW+16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.763 -0500", hash_original_field = "17E2E5F832486C45D1F8A10E508AB9E4", hash_generated_field = "0630D2B686C2E355490F540CBA3585E1")

        public static final int TYPE_STATUS_BAR_SUB_PANEL = FIRST_SYSTEM_WINDOW+17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.766 -0500", hash_original_field = "3DBC810DF50FCE636D3C828EACC113F4", hash_generated_field = "C8F32625904725E20BA96AA3D291FC21")

        public static final int TYPE_POINTER = FIRST_SYSTEM_WINDOW+18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.769 -0500", hash_original_field = "B71D0F7B70E11A1421A3D0556E6304D2", hash_generated_field = "CAD1BC72E9FD72C6D2D87A638D55A7CF")

        public static final int TYPE_NAVIGATION_BAR = FIRST_SYSTEM_WINDOW+19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.771 -0500", hash_original_field = "FDED6C14CA0004603DCD4742AB89E50F", hash_generated_field = "C5287A836A287612804DA40844375F91")

        public static final int TYPE_VOLUME_OVERLAY = FIRST_SYSTEM_WINDOW+20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.775 -0500", hash_original_field = "0E4F250E8A7557BB9ED39C6E2ABA67EA", hash_generated_field = "CE1FB521C5E8C3B5F1AF184B9FD48C96")

        public static final int TYPE_BOOT_PROGRESS = FIRST_SYSTEM_WINDOW+21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.778 -0500", hash_original_field = "E526D433F6EE09CD0C7D35C0813FB497", hash_generated_field = "F7F7D616B034C73B73F9E139FE75A5B0")

        public static final int TYPE_HIDDEN_NAV_CONSUMER = FIRST_SYSTEM_WINDOW+22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.781 -0500", hash_original_field = "050CAA709773E649E1E50ABA152769B8", hash_generated_field = "C9A8565B51C4E44ECA14BB6A17B777EB")

        public static final int LAST_SYSTEM_WINDOW      = 2999;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.784 -0500", hash_original_field = "74B19D1D8ACE863E12919986430BB35E", hash_generated_field = "A4C600601ABDAB1D78617BB28A782349")

        @Deprecated
        public static final int MEMORY_TYPE_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.787 -0500", hash_original_field = "D1B2322E3CEB922F7177AAC5592FE0DC", hash_generated_field = "EB21A6521C8D01D7DEC74A73F0D32513")

        @Deprecated
        public static final int MEMORY_TYPE_HARDWARE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.790 -0500", hash_original_field = "8327A463A3A7CAF46312EA1E6108B745", hash_generated_field = "74680A82450CED20A8A65B193ECFC04B")

        @Deprecated
        public static final int MEMORY_TYPE_GPU = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.793 -0500", hash_original_field = "FD6002A1BFAC47796EF5E3ED321212F9", hash_generated_field = "424A8851840E67218C1B521208D9BA9B")

        @Deprecated
        public static final int MEMORY_TYPE_PUSH_BUFFERS = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.798 -0500", hash_original_field = "B32466556FD5DEE9995F4C8C9FAC60FB", hash_generated_field = "0783913F68A5398244B61C93FEACE27B")

        public static final int FLAG_ALLOW_LOCK_WHILE_SCREEN_ON     = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.801 -0500", hash_original_field = "2C267A77623F60FC0658E817085A3417", hash_generated_field = "711E59ADD30556C896A272CFD387BD45")

        public static final int FLAG_DIM_BEHIND        = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.804 -0500", hash_original_field = "1E5CAC689A770FD1E589953990AF38EC", hash_generated_field = "4E37A2B6A7DA10B76B16219D9A5C7B1B")

        @Deprecated
        public static final int FLAG_BLUR_BEHIND        = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.807 -0500", hash_original_field = "1DB61380828B3EA54D7939149568D560", hash_generated_field = "111FF2431D853DD225D95AD355E107FF")

        public static final int FLAG_NOT_FOCUSABLE      = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.809 -0500", hash_original_field = "0FBE55DB5F4114512F6A559E97AE7862", hash_generated_field = "44ECC1B93E47B490024930386F13827A")

        public static final int FLAG_NOT_TOUCHABLE      = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.813 -0500", hash_original_field = "6622031E521B2B1FE4DC1A51E4EF3263", hash_generated_field = "3FC964460B01083DE747E58BEF05B768")

        public static final int FLAG_NOT_TOUCH_MODAL    = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.815 -0500", hash_original_field = "3AA44D82986AD248B193C1D7409515A6", hash_generated_field = "EA01ED6B582D0C4E38E4ACD294FACBF2")

        public static final int FLAG_TOUCHABLE_WHEN_WAKING = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.818 -0500", hash_original_field = "C6E9C747F93E15BD2BD773A6FE2021AB", hash_generated_field = "44A8A2CDD7007D84F9320788582F73E0")

        public static final int FLAG_KEEP_SCREEN_ON     = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.820 -0500", hash_original_field = "5E3B9E3165CD68CE152B1E93BA840A91", hash_generated_field = "C1D5FACBB4E3D692D4F04F92A2D02169")

        public static final int FLAG_LAYOUT_IN_SCREEN   = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.823 -0500", hash_original_field = "775DA046719D0994C4CB60D7996A602F", hash_generated_field = "E2634378AC59AE14123ED8F540C66859")

        public static final int FLAG_LAYOUT_NO_LIMITS   = 0x00000200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.826 -0500", hash_original_field = "50007874EB4157BE56C3FFB3178C5560", hash_generated_field = "3715446EA935852F03606AC7D004C83F")

        public static final int FLAG_FULLSCREEN      = 0x00000400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.828 -0500", hash_original_field = "BCE31E956389852D53D62C9C112C9B55", hash_generated_field = "DA750332A35345A0FE4F0320F83C5C5B")

        public static final int FLAG_FORCE_NOT_FULLSCREEN   = 0x00000800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.831 -0500", hash_original_field = "1DF944E5D6FA1BDD3D3D030A000045F0", hash_generated_field = "3FCE66D45E90C983CF0F6703307C60D9")

        public static final int FLAG_DITHER             = 0x00001000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.834 -0500", hash_original_field = "034B51FB1D722A9B676F7C5C5B6877B4", hash_generated_field = "611470D3E0F72560535EE6E843F20237")

        public static final int FLAG_SECURE             = 0x00002000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.837 -0500", hash_original_field = "9F0C06EE1F18F7234CD056D7C55F6229", hash_generated_field = "C2B7222AE1B73A8D22E3E0D2995A8D11")

        public static final int FLAG_SCALED             = 0x00004000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.840 -0500", hash_original_field = "C755DD03E9CE0809B36E8D0855E9C288", hash_generated_field = "3CD6B9CE46F068D1ADCADF6F3BCFF983")

        public static final int FLAG_IGNORE_CHEEK_PRESSES    = 0x00008000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.843 -0500", hash_original_field = "DBA8383A531FB174CF93E4DA0E008B77", hash_generated_field = "3DDD8B33640F31CC8BFFE737F717B43F")

        public static final int FLAG_LAYOUT_INSET_DECOR = 0x00010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.846 -0500", hash_original_field = "19AB70B59314C2D86032C17FD9C46B1C", hash_generated_field = "00CF91884F300CF7D7A2131A925742F3")

        public static final int FLAG_ALT_FOCUSABLE_IM = 0x00020000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.848 -0500", hash_original_field = "B609E2798512A1FA2C1967A29B5391B3", hash_generated_field = "BEB8E470F787B90BB8DBF4AC3A250AE5")

        public static final int FLAG_WATCH_OUTSIDE_TOUCH = 0x00040000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.851 -0500", hash_original_field = "5A3FBA7D51A8217EF4FA65B57A98B621", hash_generated_field = "D91D07DB1DEF11254B16B660C7850C02")

        public static final int FLAG_SHOW_WHEN_LOCKED = 0x00080000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.854 -0500", hash_original_field = "8A4A2999DF107E61D2FA9F7C005530E8", hash_generated_field = "EA030C566B334E7C86693F6B9CA5A0BB")

        public static final int FLAG_SHOW_WALLPAPER = 0x00100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.857 -0500", hash_original_field = "389574DBB2678DCF612E8424612147A2", hash_generated_field = "B9C602043BAD147A81792FDF2DCCDACE")

        public static final int FLAG_TURN_SCREEN_ON = 0x00200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.860 -0500", hash_original_field = "7AE228E496A85D162EDABBEDDF3AD2A0", hash_generated_field = "E46540792264BE1E4E4BF73249E42455")

        public static final int FLAG_DISMISS_KEYGUARD = 0x00400000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.863 -0500", hash_original_field = "F9C8E7DF95F259862447FAF9D2FD7DBE", hash_generated_field = "3B9802684163D5729D1E31B8E034D413")

        public static final int FLAG_SPLIT_TOUCH = 0x00800000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.865 -0500", hash_original_field = "6C0BF7E110ACB4A440F896811FC5D60D", hash_generated_field = "78240BDD5DABD5857FA96503FB0F7A8A")

        public static final int FLAG_HARDWARE_ACCELERATED = 0x01000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.868 -0500", hash_original_field = "12BF2CF1361F3E9C912B234D1F850C7D", hash_generated_field = "FD71400A8725CC58DF59D91FAEBCBF75")

        // These start at the high bit and go down.

        /** Window flag: Enable touches to slide out of a window into neighboring
         * windows in mid-gesture instead of being captured for the duration of
         * the gesture.
         *
         * This flag changes the behavior of touch focus for this window only.
         * Touches can slide out of the window but they cannot necessarily slide
         * back in (unless the other window with touch focus permits it).
         *
         * {@hide}
         */
        public static final int FLAG_SLIPPERY = 0x04000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.873 -0500", hash_original_field = "2298E5E849B891D8A69550858871FF80", hash_generated_field = "4734E6CD72EF2009A74B6FE1C7B03602")

        public static final int FLAG_NEEDS_MENU_KEY = 0x08000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.878 -0500", hash_original_field = "0AD3DC128B50D9D1CFCA85C6E2F1587A", hash_generated_field = "A1E95FD34F1476A2D318A5DE05849B09")

        public static final int FLAG_KEEP_SURFACE_WHILE_ANIMATING = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.881 -0500", hash_original_field = "3D3BD16C8F5C3A1C663750C6BEFE004F", hash_generated_field = "D17B677E27FC73A10464CF001A54F822")

        public static final int FLAG_COMPATIBLE_WINDOW = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.884 -0500", hash_original_field = "B59C5D45E507F944B2D161AD5CC16CB6", hash_generated_field = "7D97CD59108CED9BB6EE317445596072")

        public static final int FLAG_SYSTEM_ERROR = 0x40000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.891 -0500", hash_original_field = "B9A5A51E75D1213A3BAD729BCEB8DE26", hash_generated_field = "7700DD6AA33297237EA45D726D3FEFC0")

        public static final int PRIVATE_FLAG_FAKE_HARDWARE_ACCELERATED = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.894 -0500", hash_original_field = "C847D3E515BA32C2568FCCD891C1072A", hash_generated_field = "33887E9AFBEA20BE719934659813BF76")

        public static final int PRIVATE_FLAG_FORCE_HARDWARE_ACCELERATED = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.897 -0500", hash_original_field = "26D8322ED085E12B4D7279B316D87F66", hash_generated_field = "47B8FA474DFEB338E9BA792FCDB76072")

        public static final int PRIVATE_FLAG_WANTS_OFFSET_NOTIFICATIONS = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.900 -0500", hash_original_field = "18EB117D3A239D51E02BB1F7311798AB", hash_generated_field = "D9609FBDBE83BFF3458F067A0651DE76")

        public static final int PRIVATE_FLAG_SET_NEEDS_MENU_KEY = 0x00000008;

        /**
         * Given a particular set of window manager flags, determine whether
         * such a window may be a target for an input method when it has
         * focus.  In particular, this checks the
         * {@link #FLAG_NOT_FOCUSABLE} and {@link #FLAG_ALT_FOCUSABLE_IM}
         * flags and returns true if the combination of the two corresponds
         * to a window that needs to be behind the input method so that the
         * user can type into it.
         * 
         * @param flags The current window manager flags.
         * 
         * @return Returns true if such a window should be behind/interact
         * with an input method, false if not.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.905 -0500", hash_original_method = "02803D40A7066F0F3129E06F1CF795C0", hash_generated_method = "13488FEE41D076E4DA2FA7E330572293")
        
public static boolean mayUseInputMethod(int flags) {
            switch (flags&(FLAG_NOT_FOCUSABLE|FLAG_ALT_FOCUSABLE_IM)) {
                case 0:
                case FLAG_NOT_FOCUSABLE|FLAG_ALT_FOCUSABLE_IM:
                    return true;
            }
            return false;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.908 -0500", hash_original_field = "6DA259492ECD439F34B21A00F9EEDB96", hash_generated_field = "854D8927F3DBC8F44BDE3E90FE6CA1DF")

        public static final int SOFT_INPUT_MASK_STATE = 0x0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.911 -0500", hash_original_field = "14F96EE5A342ACF116ACD52AA3E38583", hash_generated_field = "AC25D4FA9CEE25D6D667B9F8E4A5AA21")

        public static final int SOFT_INPUT_STATE_UNSPECIFIED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.913 -0500", hash_original_field = "39E00095874D28B0C3D34CE68828F025", hash_generated_field = "3E81E54A60912F864A0B063D031838BC")

        public static final int SOFT_INPUT_STATE_UNCHANGED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.917 -0500", hash_original_field = "B6356F998EDD99DF7987590375C45466", hash_generated_field = "63B8C9CB98CEC8AC4690381F236B7700")

        public static final int SOFT_INPUT_STATE_HIDDEN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.920 -0500", hash_original_field = "E4B8F8C583F34DAB9CCCA3BE4F48EBA4", hash_generated_field = "7FDAA1A6D406EFD0E1BF13BED0409BCE")

        public static final int SOFT_INPUT_STATE_ALWAYS_HIDDEN = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.922 -0500", hash_original_field = "B78684A6DB890AA62ADF56E605ABA6F0", hash_generated_field = "7C96C9CC979E8616DB7501CF4ABB4686")

        public static final int SOFT_INPUT_STATE_VISIBLE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.926 -0500", hash_original_field = "71A363A1C8E0B56FD9593D01CC567CAF", hash_generated_field = "F79C3150D563AA06BB2231CC4BED768E")

        public static final int SOFT_INPUT_STATE_ALWAYS_VISIBLE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.929 -0500", hash_original_field = "52EA6C2F732DBC2624DF0DBA5AA8C056", hash_generated_field = "3CDC5C662047EAD024FFD8201A746108")

        public static final int SOFT_INPUT_MASK_ADJUST = 0xf0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.931 -0500", hash_original_field = "869F2A5DA6A09519D4FEF1DC29E9CF98", hash_generated_field = "C937EC4E41B0C6C471BB8D37E14ABDF8")

        public static final int SOFT_INPUT_ADJUST_UNSPECIFIED = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.934 -0500", hash_original_field = "057DD13C7853D0F01E7DCDCC196525AC", hash_generated_field = "EDDCD68B78CF6B73CE5DD089ECE15499")

        public static final int SOFT_INPUT_ADJUST_RESIZE = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.940 -0500", hash_original_field = "B02D83D6A92DD3A7A3B07904445969BC", hash_generated_field = "F3D9A6D2EC0306C89707949E962303E2")

        public static final int SOFT_INPUT_ADJUST_PAN = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.944 -0500", hash_original_field = "96445C7F38CA4BF4387DF5BE9131B503", hash_generated_field = "E614CBDBE599ADDC6A3F27598F58E580")

        public static final int SOFT_INPUT_ADJUST_NOTHING = 0x30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.947 -0500", hash_original_field = "34F62068577BE5E695A91330422B2AAB", hash_generated_field = "3AF80677E54369E68A370E117B8AFA9D")

        public static final int SOFT_INPUT_IS_FORWARD_NAVIGATION = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.976 -0500", hash_original_field = "2389437228FCA51AD74C8941D324FC61", hash_generated_field = "43C719E6443E6CF3A26FD33AF419A5CD")

        public static final float BRIGHTNESS_OVERRIDE_NONE = -1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.979 -0500", hash_original_field = "1F26A854747FB1C4A6A672DA121EFC89", hash_generated_field = "4EE4BCAE60B3AC70B699531E610BE678")

        public static final float BRIGHTNESS_OVERRIDE_OFF = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.982 -0500", hash_original_field = "5EE3EB76CCE600DF5F80C8ED7BD42F2E", hash_generated_field = "67B6920F524516DE521D638D10B284C2")

        public static final float BRIGHTNESS_OVERRIDE_FULL = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.005 -0500", hash_original_field = "8B48C4E351D07887FED4BC9696CFDBD5", hash_generated_field = "FBE3DADC2BF43D04AFEC97CAFDDAE271")

        public static final int INPUT_FEATURE_DISABLE_POINTER_GESTURES = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.008 -0500", hash_original_field = "89A54FEE01B7CA0F8D5F65A0107E951B", hash_generated_field = "4F090FCDDD8234EE4AE9AEA1127FCBEC")

        public static final int INPUT_FEATURE_NO_INPUT_CHANNEL = 0x00000002;
        
        public static final Parcelable.Creator<LayoutParams> CREATOR
                    = new Parcelable.Creator<LayoutParams>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.046 -0500", hash_original_method = "AB2D39A2B696161CF2CD764489EDE57E", hash_generated_method = "1B698383EC2C452A3EBCFCE202C96D2D")
            
public LayoutParams createFromParcel(Parcel in) {
                return new LayoutParams(in);
            }
    
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.049 -0500", hash_original_method = "1AF6847A426238F16AE28956F1062E3B", hash_generated_method = "37741434F8863EF284464DC1F76F59F1")
            
public LayoutParams[] newArray(int size) {
                return new LayoutParams[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.058 -0500", hash_original_field = "934C6F83F9CBAFC440BDA7FC35662FF3", hash_generated_field = "19E8A37771A577590A042CF511B68063")
    
        @SuppressWarnings({"PointlessBitwiseExpression"})
        public static final int LAYOUT_CHANGED = 1<<0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.061 -0500", hash_original_field = "1CAC2369E90C9DD0B963C4AC409E79B6", hash_generated_field = "BA9AA46392262DDEE7D8CC41B7A83863")

        public static final int TYPE_CHANGED = 1<<1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.064 -0500", hash_original_field = "DB4A23A18CB3B486293529DCC9C0F845", hash_generated_field = "2096B6E37E8C25A2537821710F2869E4")

        public static final int FLAGS_CHANGED = 1<<2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.067 -0500", hash_original_field = "9C7AA520A3ECBCC0A4CDE1264C510988", hash_generated_field = "CD3795579C3E836815012CA3CC1C8CE8")

        public static final int FORMAT_CHANGED = 1<<3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.070 -0500", hash_original_field = "18CA04105010C01E820009E4D79907C7", hash_generated_field = "D86E7DB19C0AC7165AA4EA381ADAA1FE")

        public static final int ANIMATION_CHANGED = 1<<4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.073 -0500", hash_original_field = "61CEE4F4A8F23DB6211633AF17F3350F", hash_generated_field = "BC60D455F30D16965EB3F95BB8395BF0")

        public static final int DIM_AMOUNT_CHANGED = 1<<5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.075 -0500", hash_original_field = "C3A4FFC170F6D14E8839D3C42D9D7F09", hash_generated_field = "A2B0C71975827AF84F56A9AB55F19739")

        public static final int TITLE_CHANGED = 1<<6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.078 -0500", hash_original_field = "B154DBD169548F342BE15859C3F9D3D2", hash_generated_field = "9A3EEFD437714627CFCF47C9E4D19C43")

        public static final int ALPHA_CHANGED = 1<<7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.081 -0500", hash_original_field = "FF53C10E4F9A4A9B2C246ECE63EFF058", hash_generated_field = "0F55214DBE3F266157C94217B0A385F5")

        public static final int MEMORY_TYPE_CHANGED = 1<<8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.084 -0500", hash_original_field = "CC3A9975B6E12C981E52B63645B588A4", hash_generated_field = "E574EC8353B82C5A647429CFB2864E9F")

        public static final int SOFT_INPUT_MODE_CHANGED = 1<<9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.086 -0500", hash_original_field = "D7ECA60D029BC8E994BD15AAD328999B", hash_generated_field = "6EAB9FA6FBB8CB00A52B787F0ACF5963")

        public static final int SCREEN_ORIENTATION_CHANGED = 1<<10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.089 -0500", hash_original_field = "8993F06306FFB6409BC63147029D4B11", hash_generated_field = "12E368B146F3BD2686A9F0FF14D0C9BE")

        public static final int SCREEN_BRIGHTNESS_CHANGED = 1<<11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.092 -0500", hash_original_field = "D6A9FE2790D506240CD962427A8E8759", hash_generated_field = "3E097412B3C33EEE170993CF0FA57169")

        public static final int BUTTON_BRIGHTNESS_CHANGED = 1<<12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.094 -0500", hash_original_field = "18CB2853CE85254BA243B23E57F950A9", hash_generated_field = "C2E8CBE3179F469E4729F1A421087052")

        public static final int SYSTEM_UI_VISIBILITY_CHANGED = 1<<13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.097 -0500", hash_original_field = "BFEA2D63CFAF2827FBBA6DE81F05E3F9", hash_generated_field = "4E2C24B43CBCDA4AF6FA0EB75C217E62")

        public static final int SYSTEM_UI_LISTENER_CHANGED = 1<<14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.100 -0500", hash_original_field = "169C147EF89FA9CBDEDDECE733F3B108", hash_generated_field = "0FCC053511A13234885E5A730DF69F98")

        public static final int INPUT_FEATURES_CHANGED = 1<<15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.103 -0500", hash_original_field = "912813C6928667E6FC282FF126E925FB", hash_generated_field = "5DCDCF9E5A94083DEA65EE01A715EEC2")

        public static final int PRIVATE_FLAGS_CHANGED = 1<<16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.106 -0500", hash_original_field = "74DE3B5FA836D742F8811201723EDD3E", hash_generated_field = "1E6F1B6486EC63DEA24A25C2502C3F7E")

        public static final int EVERYTHING_CHANGED = 0xffffffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.658 -0500", hash_original_field = "3ECDEC351FCE13CBA8A59E38409B3C9E", hash_generated_field = "ADEFF5DA4ABA4F51BFD83235E12C431C")

        @ViewDebug.ExportedProperty
        public int x;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.662 -0500", hash_original_field = "93D19118DABD6AC5BACF335A34537CEB", hash_generated_field = "073DF22223957A3E265555A95A3AA83E")

        @ViewDebug.ExportedProperty
        public int y;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.665 -0500", hash_original_field = "F3816F3E86CB33EF2BC631AD9684BACA", hash_generated_field = "F6E441A1523DAC9703B9EA4CC242E7B7")

        @ViewDebug.ExportedProperty
        public float horizontalWeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.667 -0500", hash_original_field = "06E468914591F13BDAE8E2092F25105F", hash_generated_field = "0C04C751E65DABE09E99829B766914F8")

        @ViewDebug.ExportedProperty
        public float verticalWeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.672 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "2B179CE3427BCE2E03B1B9EE9577A484")

        @ViewDebug.ExportedProperty(mapping = {
            @ViewDebug.IntToString(from = TYPE_BASE_APPLICATION, to = "TYPE_BASE_APPLICATION"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION, to = "TYPE_APPLICATION"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION_STARTING, to = "TYPE_APPLICATION_STARTING"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION_PANEL, to = "TYPE_APPLICATION_PANEL"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION_MEDIA, to = "TYPE_APPLICATION_MEDIA"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION_SUB_PANEL, to = "TYPE_APPLICATION_SUB_PANEL"),
            @ViewDebug.IntToString(from = TYPE_APPLICATION_ATTACHED_DIALOG, to = "TYPE_APPLICATION_ATTACHED_DIALOG"),
            @ViewDebug.IntToString(from = TYPE_STATUS_BAR, to = "TYPE_STATUS_BAR"),
            @ViewDebug.IntToString(from = TYPE_SEARCH_BAR, to = "TYPE_SEARCH_BAR"),
            @ViewDebug.IntToString(from = TYPE_PHONE, to = "TYPE_PHONE"),
            @ViewDebug.IntToString(from = TYPE_SYSTEM_ALERT, to = "TYPE_SYSTEM_ALERT"),
            @ViewDebug.IntToString(from = TYPE_KEYGUARD, to = "TYPE_KEYGUARD"),
            @ViewDebug.IntToString(from = TYPE_TOAST, to = "TYPE_TOAST"),
            @ViewDebug.IntToString(from = TYPE_SYSTEM_OVERLAY, to = "TYPE_SYSTEM_OVERLAY"),
            @ViewDebug.IntToString(from = TYPE_PRIORITY_PHONE, to = "TYPE_PRIORITY_PHONE"),
            @ViewDebug.IntToString(from = TYPE_STATUS_BAR_PANEL, to = "TYPE_STATUS_BAR_PANEL"),
            @ViewDebug.IntToString(from = TYPE_STATUS_BAR_SUB_PANEL, to = "TYPE_STATUS_BAR_SUB_PANEL"),
            @ViewDebug.IntToString(from = TYPE_SYSTEM_DIALOG, to = "TYPE_SYSTEM_DIALOG"),
            @ViewDebug.IntToString(from = TYPE_KEYGUARD_DIALOG, to = "TYPE_KEYGUARD_DIALOG"),
            @ViewDebug.IntToString(from = TYPE_SYSTEM_ERROR, to = "TYPE_SYSTEM_ERROR"),
            @ViewDebug.IntToString(from = TYPE_INPUT_METHOD, to = "TYPE_INPUT_METHOD"),
            @ViewDebug.IntToString(from = TYPE_INPUT_METHOD_DIALOG, to = "TYPE_INPUT_METHOD_DIALOG"),
            @ViewDebug.IntToString(from = TYPE_WALLPAPER, to = "TYPE_WALLPAPER"),
            @ViewDebug.IntToString(from = TYPE_STATUS_BAR_PANEL, to = "TYPE_STATUS_BAR_PANEL"),
            @ViewDebug.IntToString(from = TYPE_SECURE_SYSTEM_OVERLAY, to = "TYPE_SECURE_SYSTEM_OVERLAY"),
            @ViewDebug.IntToString(from = TYPE_DRAG, to = "TYPE_DRAG"),
            @ViewDebug.IntToString(from = TYPE_STATUS_BAR_SUB_PANEL, to = "TYPE_STATUS_BAR_SUB_PANEL"),
            @ViewDebug.IntToString(from = TYPE_POINTER, to = "TYPE_POINTER"),
            @ViewDebug.IntToString(from = TYPE_NAVIGATION_BAR, to = "TYPE_NAVIGATION_BAR"),
            @ViewDebug.IntToString(from = TYPE_VOLUME_OVERLAY, to = "TYPE_VOLUME_OVERLAY"),
            @ViewDebug.IntToString(from = TYPE_BOOT_PROGRESS, to = "TYPE_BOOT_PROGRESS")
        })
        public int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.796 -0500", hash_original_field = "DBD150C2895B96949DC818AC29EFBD9A", hash_generated_field = "1A7029BA0D7F7757C3E402251AA6DD67")

        @Deprecated
        public int memoryType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.888 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "995C7C6E2331572E18BEA89516BE35C8")

        @ViewDebug.ExportedProperty(flagMapping = {
            @ViewDebug.FlagToString(mask = FLAG_ALLOW_LOCK_WHILE_SCREEN_ON, equals = FLAG_ALLOW_LOCK_WHILE_SCREEN_ON,
                    name = "FLAG_ALLOW_LOCK_WHILE_SCREEN_ON"),
            @ViewDebug.FlagToString(mask = FLAG_DIM_BEHIND, equals = FLAG_DIM_BEHIND,
                    name = "FLAG_DIM_BEHIND"),
            @ViewDebug.FlagToString(mask = FLAG_BLUR_BEHIND, equals = FLAG_BLUR_BEHIND,
                    name = "FLAG_BLUR_BEHIND"),
            @ViewDebug.FlagToString(mask = FLAG_NOT_FOCUSABLE, equals = FLAG_NOT_FOCUSABLE,
                    name = "FLAG_NOT_FOCUSABLE"),
            @ViewDebug.FlagToString(mask = FLAG_NOT_TOUCHABLE, equals = FLAG_NOT_TOUCHABLE,
                    name = "FLAG_NOT_TOUCHABLE"),
            @ViewDebug.FlagToString(mask = FLAG_NOT_TOUCH_MODAL, equals = FLAG_NOT_TOUCH_MODAL,
                    name = "FLAG_NOT_TOUCH_MODAL"),
            @ViewDebug.FlagToString(mask = FLAG_TOUCHABLE_WHEN_WAKING, equals = FLAG_TOUCHABLE_WHEN_WAKING,
                    name = "FLAG_TOUCHABLE_WHEN_WAKING"),
            @ViewDebug.FlagToString(mask = FLAG_KEEP_SCREEN_ON, equals = FLAG_KEEP_SCREEN_ON,
                    name = "FLAG_KEEP_SCREEN_ON"),
            @ViewDebug.FlagToString(mask = FLAG_LAYOUT_IN_SCREEN, equals = FLAG_LAYOUT_IN_SCREEN,
                    name = "FLAG_LAYOUT_IN_SCREEN"),
            @ViewDebug.FlagToString(mask = FLAG_LAYOUT_NO_LIMITS, equals = FLAG_LAYOUT_NO_LIMITS,
                    name = "FLAG_LAYOUT_NO_LIMITS"),
            @ViewDebug.FlagToString(mask = FLAG_FULLSCREEN, equals = FLAG_FULLSCREEN,
                    name = "FLAG_FULLSCREEN"),
            @ViewDebug.FlagToString(mask = FLAG_FORCE_NOT_FULLSCREEN, equals = FLAG_FORCE_NOT_FULLSCREEN,
                    name = "FLAG_FORCE_NOT_FULLSCREEN"),
            @ViewDebug.FlagToString(mask = FLAG_DITHER, equals = FLAG_DITHER,
                    name = "FLAG_DITHER"),
            @ViewDebug.FlagToString(mask = FLAG_SECURE, equals = FLAG_SECURE,
                    name = "FLAG_SECURE"),
            @ViewDebug.FlagToString(mask = FLAG_SCALED, equals = FLAG_SCALED,
                    name = "FLAG_SCALED"),
            @ViewDebug.FlagToString(mask = FLAG_IGNORE_CHEEK_PRESSES, equals = FLAG_IGNORE_CHEEK_PRESSES,
                    name = "FLAG_IGNORE_CHEEK_PRESSES"),
            @ViewDebug.FlagToString(mask = FLAG_LAYOUT_INSET_DECOR, equals = FLAG_LAYOUT_INSET_DECOR,
                    name = "FLAG_LAYOUT_INSET_DECOR"),
            @ViewDebug.FlagToString(mask = FLAG_ALT_FOCUSABLE_IM, equals = FLAG_ALT_FOCUSABLE_IM,
                    name = "FLAG_ALT_FOCUSABLE_IM"),
            @ViewDebug.FlagToString(mask = FLAG_WATCH_OUTSIDE_TOUCH, equals = FLAG_WATCH_OUTSIDE_TOUCH,
                    name = "FLAG_WATCH_OUTSIDE_TOUCH"),
            @ViewDebug.FlagToString(mask = FLAG_SHOW_WHEN_LOCKED, equals = FLAG_SHOW_WHEN_LOCKED,
                    name = "FLAG_SHOW_WHEN_LOCKED"),
            @ViewDebug.FlagToString(mask = FLAG_SHOW_WALLPAPER, equals = FLAG_SHOW_WALLPAPER,
                    name = "FLAG_SHOW_WALLPAPER"),
            @ViewDebug.FlagToString(mask = FLAG_TURN_SCREEN_ON, equals = FLAG_TURN_SCREEN_ON,
                    name = "FLAG_TURN_SCREEN_ON"),
            @ViewDebug.FlagToString(mask = FLAG_DISMISS_KEYGUARD, equals = FLAG_DISMISS_KEYGUARD,
                    name = "FLAG_DISMISS_KEYGUARD"),
            @ViewDebug.FlagToString(mask = FLAG_SPLIT_TOUCH, equals = FLAG_SPLIT_TOUCH,
                    name = "FLAG_SPLIT_TOUCH"),
            @ViewDebug.FlagToString(mask = FLAG_HARDWARE_ACCELERATED, equals = FLAG_HARDWARE_ACCELERATED,
                    name = "FLAG_HARDWARE_ACCELERATED")
        })
        public int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.903 -0500", hash_original_field = "5FC543A630F4649F8A43866B440D351B", hash_generated_field = "206929AF9F8B7FF44B2425CD0919288E")

        public int privateFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.950 -0500", hash_original_field = "E191C85AC29CBA81CD76EDE74703370C", hash_generated_field = "3D8BA35B328FE1B6C6D3197F4C56033F")

        public int softInputMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.953 -0500", hash_original_field = "E7FDA06D45817A851F4CCBCEDBBF1171", hash_generated_field = "7B969BCD8327FD354F9843B5C2FB842F")

        public int gravity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.958 -0500", hash_original_field = "1E006ACC9E5372997DF5CAFC08B7DC10", hash_generated_field = "3C5548971B49B83710851C5018B1769B")

        public float horizontalMargin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.961 -0500", hash_original_field = "74C0F1ED52FEB3E2B0B5F58E14E2AF66", hash_generated_field = "0A93298F2FCAB82D917DB1FB08E4A804")

        public float verticalMargin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.965 -0500", hash_original_field = "DF6A9425E64603B99565AC4512172219", hash_generated_field = "607BD764A61A3197D0A2D65B6E1CF0E2")

        public int format;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.968 -0500", hash_original_field = "2B808634C0F256930087E4700EAB48ED", hash_generated_field = "3CB1AB2952C2713B44E6A4CF6AAA0D69")

        public int windowAnimations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.971 -0500", hash_original_field = "6A4C36F23D59750BD81CC5605C4435D1", hash_generated_field = "8A14377DC9CFC116660571385CD08FC4")

        public float alpha = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.973 -0500", hash_original_field = "BA0EE0458E3B06420D414E51DFCA032F", hash_generated_field = "99034640579EEC1581188146F1606419")

        public float dimAmount = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.985 -0500", hash_original_field = "65922B64135D72A24C20FE4C85B111EB", hash_generated_field = "6C6B7EACEBC0B3E1DF6A93EF96068BB7")

        public float screenBrightness = BRIGHTNESS_OVERRIDE_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.987 -0500", hash_original_field = "1DB01F2706D9E8BFC4796784CA2E21A8", hash_generated_field = "DF80EB3BC5DE40FBD1F456F8F3FF2F14")

        public float buttonBrightness = BRIGHTNESS_OVERRIDE_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.989 -0500", hash_original_field = "87CAEFA478087E204934E015B8B852CF", hash_generated_field = "F8A2ADCF880C5A794D59A2D84095BA1D")

        public IBinder token = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.992 -0500", hash_original_field = "0FF4809E10BE0BB9501C9C53EB88A866", hash_generated_field = "591F53EDA675313C5C899A74F2B25223")

        public String packageName = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.994 -0500", hash_original_field = "9C7B876429D416FA9763925C857549D4", hash_generated_field = "EC97C7F97586527ECD90683E6C598396")

        public int screenOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.997 -0500", hash_original_field = "3EDF9662565490884966E1FDF41CB227", hash_generated_field = "2DD4AFC17B152E64D32E88E1CE02BE8A")

        public int systemUiVisibility;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.999 -0500", hash_original_field = "3F8BD973EB2DDB0AE7206EC818695C54", hash_generated_field = "3D663549F53F0FB0DBF13ACC67A664A6")

        public int subtreeSystemUiVisibility;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.002 -0500", hash_original_field = "0CD2975430D66AA89A4FFABA3A323834", hash_generated_field = "07BB588847EC0E6233292BB953AB7B3F")

        public boolean hasSystemUiListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.011 -0500", hash_original_field = "83340B2EAA108C28C0C14AE3C532D98F", hash_generated_field = "2B72D0B6C62814E5EBEFE091E195EAC0")

        public int inputFeatures;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.108 -0500", hash_original_field = "DDB755FE9321D89FFEDA375848A7D635", hash_generated_field = "D89720499F497B31416D561AFC715F8E")

        private int[] mCompatibilityParamsBackup = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.131 -0500", hash_original_field = "6CA2DE735E52FAEE758B1481C458DACF", hash_generated_field = "A00E74CB12D339049C537B70593F23C0")

        private CharSequence mTitle = "";

        @DSComment("no action/not sensitive")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.016 -0500", hash_original_method = "AA9FD1851747B2F0FD665FC7C8D0CF51", hash_generated_method = "A9F78AD53FB6B4BDA0D0F95D5A5E1AA6")
        
public LayoutParams() {
            super(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            type = TYPE_APPLICATION;
            format = PixelFormat.OPAQUE;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.019 -0500", hash_original_method = "80C6E29E40FFCD36AC93EE28B1F7F095", hash_generated_method = "22EDD37903DDDD13A8C6075BD3579A0E")
        
public LayoutParams(int _type) {
            super(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            type = _type;
            format = PixelFormat.OPAQUE;
        }
    
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.022 -0500", hash_original_method = "967A71E2A08139F35DA4E32248AE1816", hash_generated_method = "FC5F7600326764FA0F6D2F6BFE14A714")
        
public LayoutParams(int _type, int _flags) {
            super(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            type = _type;
            flags = _flags;
            format = PixelFormat.OPAQUE;
        }
    
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.025 -0500", hash_original_method = "C17C11C43CE8DE9C5C8569C5019A2E2D", hash_generated_method = "05CE48E76156C4E305B6B758A9940654")
        
public LayoutParams(int _type, int _flags, int _format) {
            super(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            type = _type;
            flags = _flags;
            format = _format;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.029 -0500", hash_original_method = "E4181C6959691503A1A29FD26110025C", hash_generated_method = "552CD249234514C5F6E2C7C483B6C703")
        
public LayoutParams(int w, int h, int _type, int _flags, int _format) {
            super(w, h);
            type = _type;
            flags = _flags;
            format = _format;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.032 -0500", hash_original_method = "7C01FB8A64E1CF8AFE67C16A0175AB0A", hash_generated_method = "C0E5A124E78BA5D640F33D8410BB8DD6")
        
public LayoutParams(int w, int h, int xpos, int ypos, int _type,
                int _flags, int _format) {
            super(w, h);
            x = xpos;
            y = ypos;
            type = _type;
            flags = _flags;
            format = _format;
        }
    
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.055 -0500", hash_original_method = "144F58EFD16271AC6CDC4218D153EBC0", hash_generated_method = "DC64F1A548E1D3D85FEC50C41E854365")
        
public LayoutParams(Parcel in) {
            width = in.readInt();
            height = in.readInt();
            x = in.readInt();
            y = in.readInt();
            type = in.readInt();
            flags = in.readInt();
            privateFlags = in.readInt();
            softInputMode = in.readInt();
            gravity = in.readInt();
            horizontalMargin = in.readFloat();
            verticalMargin = in.readFloat();
            format = in.readInt();
            windowAnimations = in.readInt();
            alpha = in.readFloat();
            dimAmount = in.readFloat();
            screenBrightness = in.readFloat();
            buttonBrightness = in.readFloat();
            token = in.readStrongBinder();
            packageName = in.readString();
            mTitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            screenOrientation = in.readInt();
            systemUiVisibility = in.readInt();
            subtreeSystemUiVisibility = in.readInt();
            hasSystemUiListeners = in.readInt() != 0;
            inputFeatures = in.readInt();
        }
    
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.034 -0500", hash_original_method = "6F9B8B9DC4DDD39983F318552B913051", hash_generated_method = "2B5104083580B3816E7BA54E25FE5D58")
        
public final void setTitle(CharSequence title) {
            if (null == title)
                title = "";
    
            mTitle = TextUtils.stringOrSpannedString(title);
        }
    
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.037 -0500", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "8E68CAEF2DE68CDDD808B8D3534F95EE")
        
public final CharSequence getTitle() {
            return mTitle;
        }
    
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.040 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.042 -0500", hash_original_method = "F62CAA063B4E8718ABD5334B90851BE5", hash_generated_method = "6EA7B9E229C90CF417100CB4BF01F77F")
        
public void writeToParcel(Parcel out, int parcelableFlags) {
            out.writeInt(width);
            out.writeInt(height);
            out.writeInt(x);
            out.writeInt(y);
            out.writeInt(type);
            out.writeInt(flags);
            out.writeInt(privateFlags);
            out.writeInt(softInputMode);
            out.writeInt(gravity);
            out.writeFloat(horizontalMargin);
            out.writeFloat(verticalMargin);
            out.writeInt(format);
            out.writeInt(windowAnimations);
            out.writeFloat(alpha);
            out.writeFloat(dimAmount);
            out.writeFloat(screenBrightness);
            out.writeFloat(buttonBrightness);
            out.writeStrongBinder(token);
            out.writeString(packageName);
            TextUtils.writeToParcel(mTitle, out, parcelableFlags);
            out.writeInt(screenOrientation);
            out.writeInt(systemUiVisibility);
            out.writeInt(subtreeSystemUiVisibility);
            out.writeInt(hasSystemUiListeners ? 1 : 0);
            out.writeInt(inputFeatures);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.113 -0500", hash_original_method = "5B29C373DB564C0AF5266E0B36B7B621", hash_generated_method = "F1386DB4330EDCB09A05537CBD10F3D3")
        
public final int copyFrom(LayoutParams o) {
            int changes = 0;
    
            if (width != o.width) {
                width = o.width;
                changes |= LAYOUT_CHANGED;
            }
            if (height != o.height) {
                height = o.height;
                changes |= LAYOUT_CHANGED;
            }
            if (x != o.x) {
                x = o.x;
                changes |= LAYOUT_CHANGED;
            }
            if (y != o.y) {
                y = o.y;
                changes |= LAYOUT_CHANGED;
            }
            if (horizontalWeight != o.horizontalWeight) {
                horizontalWeight = o.horizontalWeight;
                changes |= LAYOUT_CHANGED;
            }
            if (verticalWeight != o.verticalWeight) {
                verticalWeight = o.verticalWeight;
                changes |= LAYOUT_CHANGED;
            }
            if (horizontalMargin != o.horizontalMargin) {
                horizontalMargin = o.horizontalMargin;
                changes |= LAYOUT_CHANGED;
            }
            if (verticalMargin != o.verticalMargin) {
                verticalMargin = o.verticalMargin;
                changes |= LAYOUT_CHANGED;
            }
            if (type != o.type) {
                type = o.type;
                changes |= TYPE_CHANGED;
            }
            if (flags != o.flags) {
                flags = o.flags;
                changes |= FLAGS_CHANGED;
            }
            if (privateFlags != o.privateFlags) {
                privateFlags = o.privateFlags;
                changes |= PRIVATE_FLAGS_CHANGED;
            }
            if (softInputMode != o.softInputMode) {
                softInputMode = o.softInputMode;
                changes |= SOFT_INPUT_MODE_CHANGED;
            }
            if (gravity != o.gravity) {
                gravity = o.gravity;
                changes |= LAYOUT_CHANGED;
            }
            if (format != o.format) {
                format = o.format;
                changes |= FORMAT_CHANGED;
            }
            if (windowAnimations != o.windowAnimations) {
                windowAnimations = o.windowAnimations;
                changes |= ANIMATION_CHANGED;
            }
            if (token == null) {
                // NOTE: token only copied if the recipient doesn't
                // already have one.
                token = o.token;
            }
            if (packageName == null) {
                // NOTE: packageName only copied if the recipient doesn't
                // already have one.
                packageName = o.packageName;
            }
            if (!mTitle.equals(o.mTitle)) {
                mTitle = o.mTitle;
                changes |= TITLE_CHANGED;
            }
            if (alpha != o.alpha) {
                alpha = o.alpha;
                changes |= ALPHA_CHANGED;
            }
            if (dimAmount != o.dimAmount) {
                dimAmount = o.dimAmount;
                changes |= DIM_AMOUNT_CHANGED;
            }
            if (screenBrightness != o.screenBrightness) {
                screenBrightness = o.screenBrightness;
                changes |= SCREEN_BRIGHTNESS_CHANGED;
            }
            if (buttonBrightness != o.buttonBrightness) {
                buttonBrightness = o.buttonBrightness;
                changes |= BUTTON_BRIGHTNESS_CHANGED;
            }
    
            if (screenOrientation != o.screenOrientation) {
                screenOrientation = o.screenOrientation;
                changes |= SCREEN_ORIENTATION_CHANGED;
            }

            if (systemUiVisibility != o.systemUiVisibility
                    || subtreeSystemUiVisibility != o.subtreeSystemUiVisibility) {
                systemUiVisibility = o.systemUiVisibility;
                subtreeSystemUiVisibility = o.subtreeSystemUiVisibility;
                changes |= SYSTEM_UI_VISIBILITY_CHANGED;
            }

            if (hasSystemUiListeners != o.hasSystemUiListeners) {
                hasSystemUiListeners = o.hasSystemUiListeners;
                changes |= SYSTEM_UI_LISTENER_CHANGED;
            }

            if (inputFeatures != o.inputFeatures) {
                inputFeatures = o.inputFeatures;
                changes |= INPUT_FEATURES_CHANGED;
            }

            return changes;
        }
    
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.116 -0500", hash_original_method = "BCD281D5A691C9FFE0E42C29A8A359E4", hash_generated_method = "CD031126142946702E50C065AB22DD21")
        
@Override
        public String debug(String output) {
            output += "Contents of " + this + ":";
            Log.d("Debug", output);
            output = super.debug("");
            Log.d("Debug", output);
            Log.d("Debug", "");
            Log.d("Debug", "WindowManager.LayoutParams={title=" + mTitle + "}");
            return "";
        }
    
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.120 -0500", hash_original_method = "41B9FD0A22A3C1DC6E251DE94C75B18D", hash_generated_method = "009ABCFBDDC67308D2886E20C626E696")
        
@Override
        public String toString() {
            StringBuilder sb = new StringBuilder(256);
            sb.append("WM.LayoutParams{");
            sb.append("(");
            sb.append(x);
            sb.append(',');
            sb.append(y);
            sb.append(")(");
            sb.append((width== MATCH_PARENT ?"fill":(width==WRAP_CONTENT?"wrap":width)));
            sb.append('x');
            sb.append((height== MATCH_PARENT ?"fill":(height==WRAP_CONTENT?"wrap":height)));
            sb.append(")");
            if (horizontalMargin != 0) {
                sb.append(" hm=");
                sb.append(horizontalMargin);
            }
            if (verticalMargin != 0) {
                sb.append(" vm=");
                sb.append(verticalMargin);
            }
            if (gravity != 0) {
                sb.append(" gr=#");
                sb.append(Integer.toHexString(gravity));
            }
            if (softInputMode != 0) {
                sb.append(" sim=#");
                sb.append(Integer.toHexString(softInputMode));
            }
            sb.append(" ty=");
            sb.append(type);
            sb.append(" fl=#");
            sb.append(Integer.toHexString(flags));
            if (privateFlags != 0) {
                sb.append(" pfl=0x").append(Integer.toHexString(privateFlags));
            }
            if (format != PixelFormat.OPAQUE) {
                sb.append(" fmt=");
                sb.append(format);
            }
            if (windowAnimations != 0) {
                sb.append(" wanim=0x");
                sb.append(Integer.toHexString(windowAnimations));
            }
            if (screenOrientation != ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
                sb.append(" or=");
                sb.append(screenOrientation);
            }
            if (alpha != 1.0f) {
                sb.append(" alpha=");
                sb.append(alpha);
            }
            if (screenBrightness != BRIGHTNESS_OVERRIDE_NONE) {
                sb.append(" sbrt=");
                sb.append(screenBrightness);
            }
            if (buttonBrightness != BRIGHTNESS_OVERRIDE_NONE) {
                sb.append(" bbrt=");
                sb.append(buttonBrightness);
            }
            if ((flags & FLAG_COMPATIBLE_WINDOW) != 0) {
                sb.append(" compatible=true");
            }
            if (systemUiVisibility != 0) {
                sb.append(" sysui=0x");
                sb.append(Integer.toHexString(systemUiVisibility));
            }
            if (subtreeSystemUiVisibility != 0) {
                sb.append(" vsysui=0x");
                sb.append(Integer.toHexString(subtreeSystemUiVisibility));
            }
            if (hasSystemUiListeners) {
                sb.append(" sysuil=");
                sb.append(hasSystemUiListeners);
            }
            if (inputFeatures != 0) {
                sb.append(" if=0x").append(Integer.toHexString(inputFeatures));
            }
            sb.append('}');
            return sb.toString();
        }

        /**
         * Scale the layout params' coordinates and size.
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.123 -0500", hash_original_method = "ED16036059CF4646EEC964097D8D3C94", hash_generated_method = "C7FFE5EFC1E10EE3DD9EDC82EB182E2A")
        
public void scale(float scale) {
            x = (int) (x * scale + 0.5f);
            y = (int) (y * scale + 0.5f);
            if (width > 0) {
                width = (int) (width * scale + 0.5f);
            }
            if (height > 0) {
                height = (int) (height * scale + 0.5f);
            }
        }

        /**
         * Backup the layout parameters used in compatibility mode.
         * @see LayoutParams#restore()
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.126 -0500", hash_original_method = "99E53D5A5FA0AFC41A02D5F2628F3A7A", hash_generated_method = "E36601F0E7B6E2EB4B2A7CE1FC773AF3")
        
void backup() {
            int[] backup = mCompatibilityParamsBackup;
            if (backup == null) {
                // we backup 4 elements, x, y, width, height
                backup = mCompatibilityParamsBackup = new int[4];
            }
            backup[0] = x;
            backup[1] = y;
            backup[2] = width;
            backup[3] = height;
        }

        /**
         * Restore the layout params' coordinates, size and gravity
         * @see LayoutParams#backup()
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:00.129 -0500", hash_original_method = "80239032BEE556394E9060CC798A2741", hash_generated_method = "80239032BEE556394E9060CC798A2741")
        
void restore() {
            int[] backup = mCompatibilityParamsBackup;
            if (backup != null) {
                x = backup[0];
                y = backup[1];
                width = backup[2];
                height = backup[3];
            }
        }
    }
}
