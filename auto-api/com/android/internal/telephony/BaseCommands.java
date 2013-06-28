package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.RegistrantList;
import android.os.Registrant;
import android.os.Handler;
import android.os.AsyncResult;
import android.os.SystemProperties;
import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseCommands implements CommandsInterface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "2BF934F4DD24E65E50AF1752F2D5A583", hash_generated_field = "E29C242D0504728E6C3C54A6DDC02A46")

    protected RadioState mState = RadioState.RADIO_UNAVAILABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "B2B5F311C90603C2144044CBC44E4FBF", hash_generated_field = "732A4411E8B6CD4E0897192B6F27A157")

    protected RadioState mSimState = RadioState.RADIO_UNAVAILABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "80FF96B7912BEBCF49D2C318DC1F37A1", hash_generated_field = "34AD4D4D50B88A82487D87EDB290DD65")

    protected RadioState mRuimState = RadioState.RADIO_UNAVAILABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "C92F32158206673F4825547EDD2DF45E", hash_generated_field = "AACFF7E48EB5D3C80BE4456A9FEE9F81")

    protected RadioState mNvState = RadioState.RADIO_UNAVAILABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "7CB20A433ED2F43C6F880910B3015C96", hash_generated_field = "E5ADD6D93A64C85609CB12342A7B9EC5")

    protected Object mStateMonitor = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "D526FD4EC7FD2BAB90539F40603BF331", hash_generated_field = "CDE5DEB085980735E31C1C0C83621370")

    protected RegistrantList mRadioStateChangedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "66CFB0591A43ED1046B62577FA89A3FA", hash_generated_field = "BBE48E2A62763F1E6595E3B9C75D6A71")

    protected RegistrantList mOnRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "FBE03152FE4A31AE66CC0C955A1FB239", hash_generated_field = "D1905CA58B49E7F78DD846CFA64D5316")

    protected RegistrantList mAvailRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "13FDC9D5C077A5D4CB4CFA2A0B23AF71", hash_generated_field = "D638CD091BFAF9674759E1FC93BC7B15")

    protected RegistrantList mOffOrNotAvailRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "1C90B7B9FC0BB72BB7B369441F008FB6", hash_generated_field = "084460E11ACEB5369FB6E423AAFFE543")

    protected RegistrantList mNotAvailRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "6DE69D2157F0D9CA83423EB73835207A", hash_generated_field = "05475482546969953FA0A0F9DAC30933")

    protected RegistrantList mSIMReadyRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "B8B512E7187543F3A15BF36C25D7A350", hash_generated_field = "A623E3A61C00CC0E81DAD080139B13CD")

    protected RegistrantList mSIMLockedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.378 -0400", hash_original_field = "F8D843ECE8B1CE1FD39A64E5564DB5AA", hash_generated_field = "A70A1736E6B6D7BA9282C26FE5DD4832")

    protected RegistrantList mRUIMReadyRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "A44814E3043024C928175EA73AE05DDB", hash_generated_field = "6BA51D54C350F4A0CEA81951FA73B8D5")

    protected RegistrantList mRUIMLockedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "DF7961017AE394706AF1E967D73424A4", hash_generated_field = "091BBB21F5D16A03789C0F6AA4D344DD")

    protected RegistrantList mNVReadyRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "EA60A75E187A8F698634CF83CB27A424", hash_generated_field = "D6147A9CA58DBB501CCF0902B7C9ED16")

    protected RegistrantList mCallStateRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "1D0EDA6B45F788B295CAAF8E7FEA6744", hash_generated_field = "8DA8D929D640D50FA30AE860C09088B8")

    protected RegistrantList mVoiceNetworkStateRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "746D40BFB26C05DC213C733AB7271496", hash_generated_field = "5E95E0F1E3C09D6368259B9646413BE4")

    protected RegistrantList mDataNetworkStateRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "F33842FF34ECFEF351711D1FC5446488", hash_generated_field = "2608CFBA55F33EAD5E5D1DA0C4C6F657")

    protected RegistrantList mRadioTechnologyChangedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "5664D6D3169AB7E439100320CC9EFC6A", hash_generated_field = "F83A0D6273A29CF318E6C8129181889B")

    protected RegistrantList mIccStatusChangedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "507DA9B30217F66A0F60A57CFD5E863E", hash_generated_field = "42B6C1CA7D49825160E9EA711BCB41AA")

    protected RegistrantList mVoicePrivacyOnRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "E95C0D832DDBA596D46C957A8AF9CA2D", hash_generated_field = "1C168249758DFA87D2497586E517A8E9")

    protected RegistrantList mVoicePrivacyOffRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "48869D1C8E6664F747BE0B177F8F277B", hash_generated_field = "C784674CD5101D15CEF6EE1260D16EE0")

    protected Registrant mUnsolOemHookRawRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "34A8494C24A6077203F2F49F2DF7C639", hash_generated_field = "BA5574D2FF0265742740D4181685E95C")

    protected RegistrantList mOtaProvisionRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "821AD54275FA235F072AC1E29614F195", hash_generated_field = "D42946C72CBF62F18062DFF6D61C2464")

    protected RegistrantList mCallWaitingInfoRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "FF5BC7452774D64B461FB8EA0AF7D269", hash_generated_field = "0D68472D193D8D7EEB22077B614B9226")

    protected RegistrantList mDisplayInfoRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "2E9BBDE0062377CB99BF33C36CBE08C6", hash_generated_field = "6204214CCC43D2779C8E0010DB8CC0B9")

    protected RegistrantList mSignalInfoRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "9E5885E78F4B7C2BF7262B36EF91B736", hash_generated_field = "CE0ACCBD53FC2723405AD8E23F0142F2")

    protected RegistrantList mNumberInfoRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "0857666F462FE4CF3D08E74BE0732D81", hash_generated_field = "61844679F83E8813F0E57C729B60CDFF")

    protected RegistrantList mRedirNumInfoRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "3994B85A7FB3277566475CEA28C1C8C6", hash_generated_field = "8AC1E7C5F78F9248211B76622C386A07")

    protected RegistrantList mLineControlInfoRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "B8F9BF6E4165A88E97FABC7BE71271C2", hash_generated_field = "F40B8CC6F582B8E5175CC7D1A77E6085")

    protected RegistrantList mT53ClirInfoRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "8D48F6E1E89A649D28F53847B6CAF34C", hash_generated_field = "7C160FE4F8A1F605E24D09BC9B140BAD")

    protected RegistrantList mT53AudCntrlInfoRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "6734B6C6A53D1CEEE7CE51CB2E98869A", hash_generated_field = "9C00D0FD9392C44075239940EFDF7A15")

    protected RegistrantList mRingbackToneRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "251A8C261F0A6B5A6EF340C11F86AED3", hash_generated_field = "37A17EE00B51514019C95BC8D2DDCD7F")

    protected RegistrantList mResendIncallMuteRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "1F26750C0D1C62D4FA5DC396C0BC99AC", hash_generated_field = "950524B6CFECD91E264DC30F2CA5AC4C")

    protected RegistrantList mCdmaSubscriptionChangedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "A443A43D626AE1F08330B798B226FCF5", hash_generated_field = "031CB0765102321A36876E564078BD43")

    protected RegistrantList mCdmaPrlChangedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "6B06F77C2225BB93956582694B044176", hash_generated_field = "0F64A15E5224B623ED0359EA1AFACD3E")

    protected RegistrantList mExitEmergencyCallbackModeRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "359A8F385A0BC2C0C9693D7F3C770E3B", hash_generated_field = "783EBC1E3434B7B9A4B526A569D3C8BB")

    protected RegistrantList mRilConnectedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "CC7DF180825E26075C285A298011BA6E", hash_generated_field = "D0D69EEA44C0EFCE9F6687FCB10E7138")

    protected RegistrantList mIccRefreshRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "93068B3DFCA92ABEB6A973BEDD81CA36", hash_generated_field = "AE6AD1CCCCF6C8652D606AE52E3DF80E")

    protected Registrant mGsmSmsRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "E9128F4517A76124C10B76E1AD207E87", hash_generated_field = "7EF8A8757C74933479C641605220142B")

    protected Registrant mCdmaSmsRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "797D32C2AB6071943A7BF33F95E2AA87", hash_generated_field = "09C768F38430A45C44F4EC1B33311DC5")

    protected Registrant mNITZTimeRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "39A511522F6DAE685ADF58B71F21A4B8", hash_generated_field = "4AFA4CD65E7E12F4BEAB77E5A8A114EF")

    protected Registrant mSignalStrengthRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "65BF7B29E63435B20DF73C57D9F54E4B", hash_generated_field = "7F634DCABCF2D0B8F220E57AE4E96590")

    protected Registrant mUSSDRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "0124EDB065170193461E13F8D03E250F", hash_generated_field = "B019300CE4E11592C3B33D347D7C4A76")

    protected Registrant mSmsOnSimRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "F2C3739904B57032DC0211B1C9945367", hash_generated_field = "37F7FBC66940F342032C40B465BB356D")

    protected Registrant mSmsStatusRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "88BADC43999AC7AC0B7BA77BA2173F18", hash_generated_field = "689F8C2F3A4DCAE6D5A5B4896991685A")

    protected Registrant mSsnRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "C2904B0E5C44162B38647670CAED146A", hash_generated_field = "C778CA70B3096B1243F533C7A926C465")

    protected Registrant mCatSessionEndRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "DB3ADE55CC0A4A25897682DAA2F959DF", hash_generated_field = "93E739C036C1A0B86A700CD298905F79")

    protected Registrant mCatProCmdRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "20CAB5E5B9DA3FC4209B5A585EEA6620", hash_generated_field = "91902976B405BE9CE9480386077C2D01")

    protected Registrant mCatEventRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "C8C3EAEC9054FE1E7F4D40AE9B30385F", hash_generated_field = "2FFB84B2CC080F88E562A0579189849B")

    protected Registrant mCatCallSetUpRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "1ABD4B5BDE64D16AC273F11E75E4CCD2", hash_generated_field = "D096C2B238E423A909F827C0F12E3196")

    protected Registrant mIccSmsFullRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "55A11E68DAB4ED2ABEA253DDA27F9036", hash_generated_field = "37124344C68F94A9931D1454F42E4330")

    protected Registrant mEmergencyCallbackModeRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "35F2B175BDFF05E754154997AA28BF30", hash_generated_field = "C761F445E12876DE0409CFB83DAB2F08")

    protected Registrant mRingRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "327F5B007E0D9B70653AB92935E6CE1F", hash_generated_field = "80081B8B3844FBB01B0E57137B1A6224")

    protected Registrant mRestrictedStateRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "1329ACEFEF592C884F9EC20DD70DF339", hash_generated_field = "CD191F79A4233E2F2A818FF2D70F9A22")

    protected Registrant mGsmBroadcastSmsRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "5E797CD98A6F48EA74102A194ABE8414", hash_generated_field = "68A41D2FF9AA4AE66DAE7932D0E1DF46")

    protected int mPreferredNetworkType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "1C51E17BC9825EE74606128C3012A8C8", hash_generated_field = "37D13576834061AD4F22AAB21A88FECE")

    protected int mCdmaSubscription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "096AB6E359ED6FF0EE592ECA75245EED", hash_generated_field = "ADD2566E3A8EA5E90C108782BDB8F38B")

    protected int mPhoneType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.379 -0400", hash_original_field = "C377C6F97C92F8D0FBD252C9A0BEFE61", hash_generated_field = "580E7C4318D3476CC0659BF42E5F3A02")

    protected int mRilVersion = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.380 -0400", hash_original_method = "01B446908FD885F92167357142764DD4", hash_generated_method = "4647031EB039E2A3D118E070276D6752")
    public  BaseCommands(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.380 -0400", hash_original_method = "9B72FF4B03FA7DBB789195860BAD353E", hash_generated_method = "709EDEE91BC5097A9867BB884336EBA1")
    public RadioState getRadioState() {
        RadioState varB4EAC82CA7396A68D541C85D26508E83_1590437228 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1590437228 = mState;
        varB4EAC82CA7396A68D541C85D26508E83_1590437228.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1590437228;
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.381 -0400", hash_original_method = "683B910DC6B22521B92A68335EE5839B", hash_generated_method = "05AC696CC377C481D60AFCEE5A34EF13")
    public RadioState getSimState() {
        RadioState varB4EAC82CA7396A68D541C85D26508E83_328780430 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_328780430 = mSimState;
        varB4EAC82CA7396A68D541C85D26508E83_328780430.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_328780430;
        // ---------- Original Method ----------
        //return mSimState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.381 -0400", hash_original_method = "109C4CEB2CE04AD161352D599FB1B09F", hash_generated_method = "21240131F650693B1A2C4AAFE9E2A50F")
    public RadioState getRuimState() {
        RadioState varB4EAC82CA7396A68D541C85D26508E83_574064244 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_574064244 = mRuimState;
        varB4EAC82CA7396A68D541C85D26508E83_574064244.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_574064244;
        // ---------- Original Method ----------
        //return mRuimState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.382 -0400", hash_original_method = "903DF1C2B5F50A021347F02D35C70B16", hash_generated_method = "CB6E022125EB725D368413A7CC220E95")
    public RadioState getNvState() {
        RadioState varB4EAC82CA7396A68D541C85D26508E83_599136338 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_599136338 = mNvState;
        varB4EAC82CA7396A68D541C85D26508E83_599136338.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_599136338;
        // ---------- Original Method ----------
        //return mNvState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.382 -0400", hash_original_method = "BA48B5E0F5DAB3A06803759CD1341873", hash_generated_method = "22B116ADC2BA524FB56E6C225B87EDD3")
    public void registerForRadioStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        {
            mRadioStateChangedRegistrants.add(r);
            r.notifyRegistrant();
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mRadioStateChangedRegistrants.add(r);
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.383 -0400", hash_original_method = "5BE66114299D36CCAFF9DF2B86730E54", hash_generated_method = "AF39AD25069081EBCA754DAC40C54375")
    public void unregisterForRadioStateChanged(Handler h) {
        {
            mRadioStateChangedRegistrants.remove(h);
        } //End block
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mRadioStateChangedRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.385 -0400", hash_original_method = "08D5A7DF41ADD1C0423FEF7DAFFF25BD", hash_generated_method = "3650976053E920CB523656413508309C")
    public void registerForOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        {
            mOnRegistrants.add(r);
            {
                boolean varC432C946EB5D571635B857CCF1AC273D_1721068631 = (mState.isOn());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mOnRegistrants.add(r);
            //if (mState.isOn()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.385 -0400", hash_original_method = "DAE1468F1869D31101D72670C27E98BE", hash_generated_method = "5701F283EF75AFBE931E07D529B1EAAE")
    public void unregisterForOn(Handler h) {
        {
            mOnRegistrants.remove(h);
        } //End block
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mOnRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.386 -0400", hash_original_method = "B002A9DBB8C7C11A31C2582BB5EE1874", hash_generated_method = "059ABDEF0129BE86193E75CC05E5F908")
    public void registerForAvailable(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        {
            mAvailRegistrants.add(r);
            {
                boolean var125377391E8A2F9B6DF662CC52B1DC3C_1791272582 = (mState.isAvailable());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mAvailRegistrants.add(r);
            //if (mState.isAvailable()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.386 -0400", hash_original_method = "1CA2372C2986DE46A59E6A0B2684AC78", hash_generated_method = "A0B2CAC85E87E4171C1DC92D773ADC2F")
    public void unregisterForAvailable(Handler h) {
        {
            mAvailRegistrants.remove(h);
        } //End block
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //synchronized(mStateMonitor) {
            //mAvailRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.387 -0400", hash_original_method = "29C83058E2196992ACCCDF2436EB895F", hash_generated_method = "B128CCBD49DF62CC37CACCFB35617A3F")
    public void registerForNotAvailable(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        {
            mNotAvailRegistrants.add(r);
            {
                boolean varD36E632F0E0B6691B3B97AF15E031B66_604817950 = (!mState.isAvailable());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mNotAvailRegistrants.add(r);
            //if (!mState.isAvailable()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.387 -0400", hash_original_method = "CBA6674D64F15D2FCB61961545603AC0", hash_generated_method = "519BDC433B210FB9C4958A34BD85798B")
    public void unregisterForNotAvailable(Handler h) {
        {
            mNotAvailRegistrants.remove(h);
        } //End block
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mNotAvailRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.387 -0400", hash_original_method = "7D79215F701EB0E62714361F42A7E5B1", hash_generated_method = "7CE5470EA4FD39F6BCD1DE1F4FEDAA74")
    public void registerForOffOrNotAvailable(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        {
            mOffOrNotAvailRegistrants.add(r);
            {
                boolean var31C4C6E13480922D49199FF94A7DDE48_1936444971 = (mState == RadioState.RADIO_OFF || !mState.isAvailable());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mOffOrNotAvailRegistrants.add(r);
            //if (mState == RadioState.RADIO_OFF || !mState.isAvailable()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.388 -0400", hash_original_method = "46989C4094561DAD50220FCBDDA75AA6", hash_generated_method = "97CC52E1E52E7A7BC807C66B983812B9")
    public void unregisterForOffOrNotAvailable(Handler h) {
        {
            mOffOrNotAvailRegistrants.remove(h);
        } //End block
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //synchronized(mStateMonitor) {
            //mOffOrNotAvailRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.388 -0400", hash_original_method = "CC4432751ADD65730712EA705F22C3CD", hash_generated_method = "84C03F6F07A904CE299EAC2553D16C95")
    public void registerForSIMReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        {
            mSIMReadyRegistrants.add(r);
            {
                boolean varB1F49383AD10BFFD2293060B5333102C_494645547 = (mSimState.isSIMReady());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mSIMReadyRegistrants.add(r);
            //if (mSimState.isSIMReady()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.388 -0400", hash_original_method = "AB19D2A11305E45A98335C636B50C33B", hash_generated_method = "729A52517E5D007040901B46B7613139")
    public void unregisterForSIMReady(Handler h) {
        {
            mSIMReadyRegistrants.remove(h);
        } //End block
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mSIMReadyRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.388 -0400", hash_original_method = "2C12645510D08A28B5398079ECA6EB3E", hash_generated_method = "65424E101337648AEFD799DD7259D48E")
    public void registerForRUIMReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        {
            mRUIMReadyRegistrants.add(r);
            {
                boolean varDA1934D636D9BE382DB58F17EF4E0175_1035686549 = (mRuimState.isRUIMReady());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mRUIMReadyRegistrants.add(r);
            //if (mRuimState.isRUIMReady()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.389 -0400", hash_original_method = "5D1587722234669A56B255A4AE24EE40", hash_generated_method = "0C552B1F89D56BBD79F839D650D7A6D7")
    public void unregisterForRUIMReady(Handler h) {
        {
            mRUIMReadyRegistrants.remove(h);
        } //End block
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //synchronized(mStateMonitor) {
            //mRUIMReadyRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.389 -0400", hash_original_method = "AC5C11E970C3FC3CF3AF902D98D61BFC", hash_generated_method = "E469D94B600A86CCCB823A2F33F6E3D6")
    public void registerForNVReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        {
            mNVReadyRegistrants.add(r);
            {
                boolean var695FD0EFB66918705B8196B52B61E089_517286967 = (mNvState.isNVReady());
                {
                    r.notifyRegistrant(new AsyncResult(null, null, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mNVReadyRegistrants.add(r);
            //if (mNvState.isNVReady()) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.390 -0400", hash_original_method = "0163F455801DEEBEEE15E264968FFDFB", hash_generated_method = "64C8060B14C70090AC197259E7040D3D")
    public void unregisterForNVReady(Handler h) {
        {
            mNVReadyRegistrants.remove(h);
        } //End block
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mNVReadyRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.390 -0400", hash_original_method = "B685FFCB0EF7DE87E1299EB2C0D91FF5", hash_generated_method = "58D290741D27CF5C3F9564B9EA50220C")
    public void registerForSIMLockedOrAbsent(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        {
            mSIMLockedRegistrants.add(r);
            {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            } //End block
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mSIMLockedRegistrants.add(r);
            //if (mSimState == RadioState.SIM_LOCKED_OR_ABSENT) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.390 -0400", hash_original_method = "9E4C5688CACB9B43620D9767F5ED2831", hash_generated_method = "88A4BEEF2A8DC537C0BF371A85AC6287")
    public void unregisterForSIMLockedOrAbsent(Handler h) {
        {
            mSIMLockedRegistrants.remove(h);
        } //End block
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mSIMLockedRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.390 -0400", hash_original_method = "B883F560C1A8BD25AD0100160D6BFB3E", hash_generated_method = "D637703445FC91A52A046D4D67728D36")
    public void registerForRUIMLockedOrAbsent(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        {
            mRUIMLockedRegistrants.add(r);
            {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            } //End block
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //synchronized (mStateMonitor) {
            //mRUIMLockedRegistrants.add(r);
            //if (mRuimState == RadioState.RUIM_LOCKED_OR_ABSENT) {
                //r.notifyRegistrant(new AsyncResult(null, null, null));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.391 -0400", hash_original_method = "F7619224FDBBC62B94132C1DE98F9FAE", hash_generated_method = "BF8F47E1C100249D5404E4212CAF75A4")
    public void unregisterForRUIMLockedOrAbsent(Handler h) {
        {
            mRUIMLockedRegistrants.remove(h);
        } //End block
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //synchronized (mStateMonitor) {
            //mRUIMLockedRegistrants.remove(h);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.391 -0400", hash_original_method = "F8B2EAE479ED91D774CA562E26158F6A", hash_generated_method = "73382E6780519635A09A1AF875EA21FF")
    public void registerForCallStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mCallStateRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mCallStateRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.391 -0400", hash_original_method = "E52D1B8D1DC6759546B1451A8AF3B3CF", hash_generated_method = "FFCE4AFD62056E8D6627A5453ED14508")
    public void unregisterForCallStateChanged(Handler h) {
        mCallStateRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCallStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.391 -0400", hash_original_method = "98A3778C7EF08FDD67D8F92B137CAB51", hash_generated_method = "85CF4D27D03C83B15A86CADD7D0EB0AE")
    public void registerForVoiceNetworkStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mVoiceNetworkStateRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mVoiceNetworkStateRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.392 -0400", hash_original_method = "234E1E4E00B04837A43F108E250B7BAF", hash_generated_method = "F1D38E695ED34A925FF65950F75713A5")
    public void unregisterForVoiceNetworkStateChanged(Handler h) {
        mVoiceNetworkStateRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mVoiceNetworkStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.392 -0400", hash_original_method = "4B5CEB601891F006C0B3F4D5219F87E4", hash_generated_method = "42E605DE95135353E410914CE3C795B4")
    public void registerForDataNetworkStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mDataNetworkStateRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mDataNetworkStateRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.392 -0400", hash_original_method = "B36E31BF0B8FB61A85A55463809AD286", hash_generated_method = "BBBFFA85813600B56B2284DA26BA03FD")
    public void unregisterForDataNetworkStateChanged(Handler h) {
        mDataNetworkStateRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mDataNetworkStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.392 -0400", hash_original_method = "BDED847FB928F6304C85EAE7BEEAA6C9", hash_generated_method = "BB64623D4D1623AA35730A70481B9E09")
    public void registerForRadioTechnologyChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mRadioTechnologyChangedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mRadioTechnologyChangedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.393 -0400", hash_original_method = "836C826B4F0456A82E6FAC645FFBE7BB", hash_generated_method = "65C5F717D92A76BC2F8082318C3E5FD8")
    public void unregisterForRadioTechnologyChanged(Handler h) {
        mRadioTechnologyChangedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mRadioTechnologyChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.393 -0400", hash_original_method = "95A4334EE1F2766E4CCE86BA1BBC52D8", hash_generated_method = "3BB52AE98A4F0A47EABC24B8F6240A64")
    public void registerForIccStatusChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mIccStatusChangedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mIccStatusChangedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.393 -0400", hash_original_method = "9A6E8063793F2864B53A6581C25E75A7", hash_generated_method = "00D245DF65AAB2E63FB8B6820DC48574")
    public void unregisterForIccStatusChanged(Handler h) {
        mIccStatusChangedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mIccStatusChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.393 -0400", hash_original_method = "7CF6E9042288CF5BCC8A41B33E0FC1FA", hash_generated_method = "7D67F8A9E73CC31243F7D2D1116AD7EF")
    public void setOnNewGsmSms(Handler h, int what, Object obj) {
        mGsmSmsRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mGsmSmsRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.394 -0400", hash_original_method = "72321487D3788873BF3F462EC89D1700", hash_generated_method = "C4BE9028B97EE180F2612BD224A82712")
    public void unSetOnNewGsmSms(Handler h) {
        mGsmSmsRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mGsmSmsRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.394 -0400", hash_original_method = "9A78052D6944BA613BED064A1FCE96FC", hash_generated_method = "B037FBFD0EC202C599820C526877D98E")
    public void setOnNewCdmaSms(Handler h, int what, Object obj) {
        mCdmaSmsRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCdmaSmsRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.394 -0400", hash_original_method = "DD82A350612B8F1A5930420947333FBB", hash_generated_method = "9E921DD9A5492CA9F6F4274941F3FF12")
    public void unSetOnNewCdmaSms(Handler h) {
        mCdmaSmsRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCdmaSmsRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.395 -0400", hash_original_method = "33C97215793324BA09B0AC1C1CB62DDA", hash_generated_method = "695C2CE0D24706197FF6D3425DB7158C")
    public void setOnNewGsmBroadcastSms(Handler h, int what, Object obj) {
        mGsmBroadcastSmsRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mGsmBroadcastSmsRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.395 -0400", hash_original_method = "E9BA47BA240C655456D09F99640997E5", hash_generated_method = "3D89A33E859CD48CBF5B8786F717CA5B")
    public void unSetOnNewGsmBroadcastSms(Handler h) {
        mGsmBroadcastSmsRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mGsmBroadcastSmsRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.396 -0400", hash_original_method = "0C74AFDE10017540B93B7C27C178AD12", hash_generated_method = "F01D2F2AAD554400F7F805F97220DBBD")
    public void setOnSmsOnSim(Handler h, int what, Object obj) {
        mSmsOnSimRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSmsOnSimRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.396 -0400", hash_original_method = "4BFC1B363FF8A6E9FA34FFCCC3CD985B", hash_generated_method = "24869AA523C2A0042D7B76B27363509B")
    public void unSetOnSmsOnSim(Handler h) {
        mSmsOnSimRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mSmsOnSimRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.396 -0400", hash_original_method = "11EEFE2847E162D5587C8E576D844178", hash_generated_method = "C023336B87B4FB7229398B4D2AAC0D61")
    public void setOnSmsStatus(Handler h, int what, Object obj) {
        mSmsStatusRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSmsStatusRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.397 -0400", hash_original_method = "04CADE4525B4CE9C767EB33D42E2733D", hash_generated_method = "2D61C9D4836D2EF408F83CB29A0B4427")
    public void unSetOnSmsStatus(Handler h) {
        mSmsStatusRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mSmsStatusRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.397 -0400", hash_original_method = "BC3FAB2490D1A217545C1F22508EF51F", hash_generated_method = "842F4D77544312766E28F3F47E12ABFB")
    public void setOnSignalStrengthUpdate(Handler h, int what, Object obj) {
        mSignalStrengthRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSignalStrengthRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.397 -0400", hash_original_method = "1D4E93C65FCE9EA625F7FEE880958248", hash_generated_method = "1FD61DBA66209735265E154D522E0E4E")
    public void unSetOnSignalStrengthUpdate(Handler h) {
        mSignalStrengthRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mSignalStrengthRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.397 -0400", hash_original_method = "B93626E61216BE05ADCBA600BD7F638F", hash_generated_method = "34C7C5FD81579CD8736C8D1E69A09444")
    public void setOnNITZTime(Handler h, int what, Object obj) {
        mNITZTimeRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mNITZTimeRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.398 -0400", hash_original_method = "71E2E923C47A5EE8EAC4F6876E00C1CF", hash_generated_method = "4893F8C52AAECB5FAD18F95D2CEF2044")
    public void unSetOnNITZTime(Handler h) {
        mNITZTimeRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mNITZTimeRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.398 -0400", hash_original_method = "B95EC97639ED908B13D752A2F13F6C7D", hash_generated_method = "965063192BA32BA8BB4F78D6116BC04C")
    public void setOnUSSD(Handler h, int what, Object obj) {
        mUSSDRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mUSSDRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.398 -0400", hash_original_method = "466A12DF4A4A0EB8A1AA727D5C05C698", hash_generated_method = "4C5C0EEF27179877C9EFDE9C305C445F")
    public void unSetOnUSSD(Handler h) {
        mUSSDRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mUSSDRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.398 -0400", hash_original_method = "8D0E51584543A1B70BDE99B5C9D8170F", hash_generated_method = "3E9B0CA153F889522D46C5CA5D5D9D1E")
    public void setOnSuppServiceNotification(Handler h, int what, Object obj) {
        mSsnRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mSsnRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.399 -0400", hash_original_method = "04E80546CB98E014EC8E47E6045C2AF5", hash_generated_method = "6F902DDCA91364038503A8DB78A4F50A")
    public void unSetOnSuppServiceNotification(Handler h) {
        mSsnRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mSsnRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.399 -0400", hash_original_method = "6C58C9A1E016A05F52E2E9DA6EEAE5BF", hash_generated_method = "66F144C7BEB8D3C63B568E259A7B0EE0")
    public void setOnCatSessionEnd(Handler h, int what, Object obj) {
        mCatSessionEndRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatSessionEndRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.399 -0400", hash_original_method = "17A9937977241978E29E1F3DF9376CD7", hash_generated_method = "239854D8E6234838788F24520B58FD67")
    public void unSetOnCatSessionEnd(Handler h) {
        mCatSessionEndRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCatSessionEndRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.399 -0400", hash_original_method = "D06ACD9FCA890DD319CAD0E6F7424AE6", hash_generated_method = "57DD1FEEC78E9DC2542934C7571DE8EE")
    public void setOnCatProactiveCmd(Handler h, int what, Object obj) {
        mCatProCmdRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatProCmdRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.399 -0400", hash_original_method = "39B4BC08A3AA39DBF2A794BF5A29A6E7", hash_generated_method = "5DF934C1B5DC145C3FD6B374AC38C20B")
    public void unSetOnCatProactiveCmd(Handler h) {
        mCatProCmdRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCatProCmdRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.400 -0400", hash_original_method = "C195D512833847BDA6BB456AF1EEA3B4", hash_generated_method = "A995C302C5CC50F2ACB61368386ABBA2")
    public void setOnCatEvent(Handler h, int what, Object obj) {
        mCatEventRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatEventRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.400 -0400", hash_original_method = "86C985017D9E368A998E97DBE619C9A6", hash_generated_method = "E5908206FDA6D8C00DF68F0427FBBD68")
    public void unSetOnCatEvent(Handler h) {
        mCatEventRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCatEventRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.400 -0400", hash_original_method = "F9248546B0B94A00BBD09A54A068232C", hash_generated_method = "866AABE5F83941F6E6ADACA72CB9CB3B")
    public void setOnCatCallSetUp(Handler h, int what, Object obj) {
        mCatCallSetUpRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mCatCallSetUpRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.400 -0400", hash_original_method = "F6D53B8DEDF633EF9F4DE137121098A9", hash_generated_method = "D4F4716CE21F8CA628125A1CF601B7CB")
    public void unSetOnCatCallSetUp(Handler h) {
        mCatCallSetUpRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCatCallSetUpRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.401 -0400", hash_original_method = "CEFBB5FD27FBF0DBAFAF8D4D6CE13FCD", hash_generated_method = "0AE5D0FC8715D154CD25BAC61D8ACFEC")
    public void setOnIccSmsFull(Handler h, int what, Object obj) {
        mIccSmsFullRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mIccSmsFullRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.401 -0400", hash_original_method = "D81168F17A138BA5FBA6935B53E34C2B", hash_generated_method = "30952C9A2A209B0EF72B723171B43F8B")
    public void unSetOnIccSmsFull(Handler h) {
        mIccSmsFullRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mIccSmsFullRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.401 -0400", hash_original_method = "A200936B8F975752C35A9946FF5C3971", hash_generated_method = "2116CB173302FA741A6FA245725FCAB4")
    public void registerForIccRefresh(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mIccRefreshRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mIccRefreshRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.402 -0400", hash_original_method = "EBD003897DB6B5AFBE1C90F6779BE273", hash_generated_method = "C407301D7D269035E51AA9E2617FCBEF")
    public void setOnIccRefresh(Handler h, int what, Object obj) {
        registerForIccRefresh(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //registerForIccRefresh(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.402 -0400", hash_original_method = "B609D137446E0B07BA45D584DFD22E03", hash_generated_method = "DB9CF349072D11A86739F8678B83388D")
    public void setEmergencyCallbackMode(Handler h, int what, Object obj) {
        mEmergencyCallbackModeRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mEmergencyCallbackModeRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.402 -0400", hash_original_method = "ABCF42C92E2736F7BB23B78C79C740F8", hash_generated_method = "1396AA5F9017E0874A4DCADB0E5BEC0D")
    public void unregisterForIccRefresh(Handler h) {
        mIccRefreshRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mIccRefreshRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.402 -0400", hash_original_method = "59DD40F71F856C45DA56522E074542F9", hash_generated_method = "F91358236A7DBCC20CE06ECCBEAA7AF6")
    public void unsetOnIccRefresh(Handler h) {
        unregisterForIccRefresh(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //unregisterForIccRefresh(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.402 -0400", hash_original_method = "8CCA793687CAB6E48BC4AA126090CB63", hash_generated_method = "7D7866775B01E9A84A9965E15AC2EDAD")
    public void setOnCallRing(Handler h, int what, Object obj) {
        mRingRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mRingRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.403 -0400", hash_original_method = "0FA0F9BD0056AE1CB836D67BF674653F", hash_generated_method = "BD91D4D9E1EC25EF756464B024A28F63")
    public void unSetOnCallRing(Handler h) {
        mRingRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mRingRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.403 -0400", hash_original_method = "66886B702ABE8C8A8A8DA809F8864E28", hash_generated_method = "7D3CFC7685AA8AB6D88ACD51FB1BF0A6")
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mVoicePrivacyOnRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mVoicePrivacyOnRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.403 -0400", hash_original_method = "88FA771B173FBD911A63B00DE113B65C", hash_generated_method = "B81C32B64EEAC2157F5E0D4C42BBCDA0")
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        mVoicePrivacyOnRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mVoicePrivacyOnRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.403 -0400", hash_original_method = "0B5424223CA275A3C5522DC295A616C4", hash_generated_method = "C41543D5B623BA802387EAEBBD5EA07A")
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mVoicePrivacyOffRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mVoicePrivacyOffRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.403 -0400", hash_original_method = "B6E776E83D138F03FEB9EA861FA40286", hash_generated_method = "9ED8B687AA2184B21C331FBEF8B3417E")
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        mVoicePrivacyOffRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mVoicePrivacyOffRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.404 -0400", hash_original_method = "5582113CD84EF18DC77145673CEF3805", hash_generated_method = "6063AF1D543D5FE7F9B3E4575CF35F60")
    public void setOnRestrictedStateChanged(Handler h, int what, Object obj) {
        mRestrictedStateRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mRestrictedStateRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.404 -0400", hash_original_method = "5B907CCB9E561B2BE570362A93E2C20B", hash_generated_method = "3C4E66772E362812742A1DB79F30D48D")
    public void unSetOnRestrictedStateChanged(Handler h) {
        mRestrictedStateRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mRestrictedStateRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.404 -0400", hash_original_method = "79DF5BB64C5088A6DDB6F272CE7B24F1", hash_generated_method = "65CC14D8B52FE9F2A8CA417644B83C87")
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mDisplayInfoRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mDisplayInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.405 -0400", hash_original_method = "E2A72B7F5933EC1681F428F18D2E3B34", hash_generated_method = "F6B442606FE05934A9F11A2BE5DD9B29")
    public void unregisterForDisplayInfo(Handler h) {
        mDisplayInfoRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mDisplayInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.405 -0400", hash_original_method = "9BA2D7AA1768E0B6D41C51CBB7D2703D", hash_generated_method = "183E52A99BAD7AEA78A11FF4E0E44A17")
    public void registerForCallWaitingInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mCallWaitingInfoRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mCallWaitingInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.405 -0400", hash_original_method = "FB5DFAB4742CFF0D938DB8F68F07D307", hash_generated_method = "78D6AE923344FD2DB9B24227115EE4E1")
    public void unregisterForCallWaitingInfo(Handler h) {
        mCallWaitingInfoRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCallWaitingInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.405 -0400", hash_original_method = "8157808DA0C2AB05798E28DF7F48B26A", hash_generated_method = "EF3DF060DA2C68AD0987B800D3740D36")
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mSignalInfoRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mSignalInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.406 -0400", hash_original_method = "023EEE600D5AEC21A0C3A38A31A02F7B", hash_generated_method = "46558A559ECBB305C1A769C63C03C48E")
    public void setOnUnsolOemHookRaw(Handler h, int what, Object obj) {
        mUnsolOemHookRawRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mUnsolOemHookRawRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.406 -0400", hash_original_method = "B838AB3AB572CDA21BA8AB62D1043E1A", hash_generated_method = "95483240B07F38DCB4CAE2AE9BD3B7E8")
    public void unSetOnUnsolOemHookRaw(Handler h) {
        mUnsolOemHookRawRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mUnsolOemHookRawRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.406 -0400", hash_original_method = "FBD3C31CDF21A461B92CD6532FEB56B0", hash_generated_method = "E80029B9113C803B7F10BDEECCBF1E7B")
    public void unregisterForSignalInfo(Handler h) {
        mSignalInfoRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mSignalInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.407 -0400", hash_original_method = "FE7848C889A71C1D52EEFBC3A5A5348D", hash_generated_method = "959A4D1801AC7B366E729FABA0A394F2")
    public void registerForCdmaOtaProvision(Handler h,int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mOtaProvisionRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mOtaProvisionRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.407 -0400", hash_original_method = "AB18EE6BF73A37B52EA253A91CB20B0C", hash_generated_method = "6BFD4D00356EDD811F427AD758EB203E")
    public void unregisterForCdmaOtaProvision(Handler h) {
        mOtaProvisionRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mOtaProvisionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.407 -0400", hash_original_method = "30DBB41A5641384CBA2903733EB0CBD5", hash_generated_method = "7BBAD3B3F92F7A1F13943053AC181966")
    public void registerForNumberInfo(Handler h,int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mNumberInfoRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mNumberInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.407 -0400", hash_original_method = "D4F64543EBE672B1B0DCB72B7F1C49BF", hash_generated_method = "E5B6F36DE883ECF8BF788B6A597971B2")
    public void unregisterForNumberInfo(Handler h) {
        mNumberInfoRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mNumberInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.408 -0400", hash_original_method = "CC4E070A6851C62B1452697B8CB637B7", hash_generated_method = "D236D0D0E83F37A62E7F6E70B724C5BB")
    public void registerForRedirectedNumberInfo(Handler h,int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mRedirNumInfoRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mRedirNumInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.408 -0400", hash_original_method = "74D412781A2F86280EE77A31B77394EF", hash_generated_method = "B0A4ADAD1679C5E45D8BA597EE2E9C1B")
    public void unregisterForRedirectedNumberInfo(Handler h) {
        mRedirNumInfoRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mRedirNumInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.409 -0400", hash_original_method = "DD58771B0A7A96A346281B999DA3057A", hash_generated_method = "21E8990F6CF9CBEBCD87ABC5CD51FE2D")
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mLineControlInfoRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mLineControlInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.409 -0400", hash_original_method = "068928B7A17337EC34F57926DDEBA1C3", hash_generated_method = "5FEE67C469EA96D71B9F54F244980760")
    public void unregisterForLineControlInfo(Handler h) {
        mLineControlInfoRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mLineControlInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.410 -0400", hash_original_method = "9F4D1AFFEF8F9FA5D4778DB89C674FB3", hash_generated_method = "213126D78BBD3D84725C41D0BBE24ECD")
    public void registerFoT53ClirlInfo(Handler h,int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mT53ClirInfoRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mT53ClirInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.410 -0400", hash_original_method = "814EFF5BC3C88040487B5EAFB470F77D", hash_generated_method = "F2F4E4FCAF1F803717789F1D7DF80A98")
    public void unregisterForT53ClirInfo(Handler h) {
        mT53ClirInfoRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mT53ClirInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.411 -0400", hash_original_method = "8DE8707DBC07257BD950DE59918A2503", hash_generated_method = "7533EE16380700FCBF750D4D17E05776")
    public void registerForT53AudioControlInfo(Handler h,int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mT53AudCntrlInfoRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mT53AudCntrlInfoRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.411 -0400", hash_original_method = "1211535609DA01F7ECA596E2B136A338", hash_generated_method = "DEEFF035CA52875F83C6AA325E82C5AB")
    public void unregisterForT53AudioControlInfo(Handler h) {
        mT53AudCntrlInfoRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mT53AudCntrlInfoRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.411 -0400", hash_original_method = "2D9C6817A422E1F1364DE24FB7D91AF7", hash_generated_method = "9A4DEF5D3F136A804A32E2B03240D1BD")
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mRingbackToneRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mRingbackToneRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.411 -0400", hash_original_method = "F4C16CBC87D51F6E30E1C3D8F75EE8C0", hash_generated_method = "B07148A67BB90734DD24B02806A5587D")
    public void unregisterForRingbackTone(Handler h) {
        mRingbackToneRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mRingbackToneRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.412 -0400", hash_original_method = "DB3523E7FBDC2E46BB6C1DB462AA57D5", hash_generated_method = "55CCC8C637B5E11E708C9AC0B34E3EB3")
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mResendIncallMuteRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mResendIncallMuteRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.412 -0400", hash_original_method = "2A2F187C5BCDF7811DB17C690EF5A1E4", hash_generated_method = "356E9BFF5E0A527270E3D3616EAEE781")
    public void unregisterForResendIncallMute(Handler h) {
        mResendIncallMuteRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mResendIncallMuteRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.413 -0400", hash_original_method = "1CB550350E2118EA5DDBC3DA5F8BB474", hash_generated_method = "70A4BFE986549F107D0821BC4C684E63")
    @Override
    public void registerForCdmaSubscriptionChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mCdmaSubscriptionChangedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mCdmaSubscriptionChangedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.413 -0400", hash_original_method = "7C70EFDA99D4F1952D617116BAD22B13", hash_generated_method = "DDF68113DF823C12F5BF13E7B6D2010B")
    @Override
    public void unregisterForCdmaSubscriptionChanged(Handler h) {
        mCdmaSubscriptionChangedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCdmaSubscriptionChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.414 -0400", hash_original_method = "F2C3D1E241ED9A5D51FF055B13B3E9E2", hash_generated_method = "17994962DB8A25EE8480EEF4A2F16284")
    @Override
    public void registerForCdmaPrlChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mCdmaPrlChangedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mCdmaPrlChangedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.414 -0400", hash_original_method = "BF3AB10D2A3E0AB38BFCD9D12CDB5334", hash_generated_method = "31D20188D5FA46DB05AA45C68480210A")
    @Override
    public void unregisterForCdmaPrlChanged(Handler h) {
        mCdmaPrlChangedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCdmaPrlChangedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.414 -0400", hash_original_method = "0716736C7FBF358A30A0A4F7C12EEF60", hash_generated_method = "0A6DB16237CB404D61F3F9D7AEBFA53B")
    @Override
    public void registerForExitEmergencyCallbackMode(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r = new Registrant (h, what, obj);
        mExitEmergencyCallbackModeRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mExitEmergencyCallbackModeRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.414 -0400", hash_original_method = "C2E40B70802C2BB799E08EA528BF2439", hash_generated_method = "4B4D95E512D55C31DE580824D13C50B9")
    @Override
    public void unregisterForExitEmergencyCallbackMode(Handler h) {
        mExitEmergencyCallbackModeRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mExitEmergencyCallbackModeRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.415 -0400", hash_original_method = "A1D8B314CFB1D3E12BFA58A9A280A374", hash_generated_method = "6253B536E04F207CAC92103AC62A4DE6")
    @Override
    public void registerForRilConnected(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Log.d(LOG_TAG, "registerForRilConnected h=" + h + " w=" + what);
        Registrant r = new Registrant (h, what, obj);
        mRilConnectedRegistrants.add(r);
        {
            Log.d(LOG_TAG, "Notifying: ril connected mRilVersion=" + mRilVersion);
            r.notifyRegistrant(new AsyncResult(null, new Integer(mRilVersion), null));
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "registerForRilConnected h=" + h + " w=" + what);
        //Registrant r = new Registrant (h, what, obj);
        //mRilConnectedRegistrants.add(r);
        //if (mRilVersion != -1) {
            //Log.d(LOG_TAG, "Notifying: ril connected mRilVersion=" + mRilVersion);
            //r.notifyRegistrant(new AsyncResult(null, new Integer(mRilVersion), null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.415 -0400", hash_original_method = "676479F86CF5300F7E3A79F357120869", hash_generated_method = "2F4EE8CB69FEDF5145D1D0608A15024E")
    @Override
    public void unregisterForRilConnected(Handler h) {
        mRilConnectedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mRilConnectedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.415 -0400", hash_original_method = "9E4D177DE2C4D1C0BCFAAE47CCC59231", hash_generated_method = "4213F91204D502CD576FBCFFBFDC54D6")
    @Override
    public void setCurrentPreferredNetworkType() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.416 -0400", hash_original_method = "DCDD085282B6C088E7A0852C995BCBF3", hash_generated_method = "1BA232B7D2070F79D94CBB8CF6951744")
    protected void setRadioState(RadioState newState) {
        RadioState oldState;
        {
            oldState = mState;
            mState = newState;
            {
                boolean varA57A6B192324CD4F622370C1B7316512_2092487594 = (mState.getType() == 0);
                {
                    mSimState = mState;
                    mRuimState = mState;
                    mNvState = mState;
                } //End block
                {
                    boolean varCAB862CEBBE694F190D9E62B19124DBF_885251041 = (mState.getType() == 1);
                    {
                        mSimState = mState;
                    } //End block
                    {
                        boolean var59416DBBACB1B592D2F68B808359CB11_792043179 = (mState.getType() == 2);
                        {
                            mRuimState = mState;
                        } //End block
                        {
                            boolean var2A783CC55430BA7655D0F25D3D461C7C_143779864 = (mState.getType() == 3);
                            {
                                mNvState = mState;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            mRadioStateChangedRegistrants.notifyRegistrants();
            {
                boolean varA7C84CF67F878FDAE5D11A9DF79D83E4_1469159165 = (mState.isAvailable() && !oldState.isAvailable());
                {
                    Log.d(LOG_TAG,"Notifying: radio available");
                    mAvailRegistrants.notifyRegistrants();
                    onRadioAvailable();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2FDB5B444B83DEA6EEDE92CD58322DD3_1743701552 = (!mState.isAvailable() && oldState.isAvailable());
                {
                    Log.d(LOG_TAG,"Notifying: radio not available");
                    mNotAvailRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBED0583E86066F1EE3861BEB93E78641_1034376430 = (mState.isSIMReady() && !oldState.isSIMReady());
                {
                    Log.d(LOG_TAG,"Notifying: SIM ready");
                    mSIMReadyRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                Log.d(LOG_TAG,"Notifying: SIM locked or absent");
                mSIMLockedRegistrants.notifyRegistrants();
            } //End block
            {
                boolean var39C5C9CEC8C4BE8D25675984775135FC_1209480514 = (mState.isRUIMReady() && !oldState.isRUIMReady());
                {
                    Log.d(LOG_TAG,"Notifying: RUIM ready");
                    mRUIMReadyRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                Log.d(LOG_TAG,"Notifying: RUIM locked or absent");
                mRUIMLockedRegistrants.notifyRegistrants();
            } //End block
            {
                boolean var85390FFEEBD9C40A5358749E0561D5D5_867875950 = (mState.isNVReady() && !oldState.isNVReady());
                {
                    Log.d(LOG_TAG,"Notifying: NV ready");
                    mNVReadyRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var4CF30BAD139D8BB63CF4DF108535EC21_1942333358 = (mState.isOn() && !oldState.isOn());
                {
                    Log.d(LOG_TAG,"Notifying: Radio On");
                    mOnRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var5338AF0F053F3978DA8435D4833C9E0E_1548038483 = ((!mState.isOn() || !mState.isAvailable())
                && !((!oldState.isOn() || !oldState.isAvailable())));
                {
                    Log.d(LOG_TAG,"Notifying: radio off or not available");
                    mOffOrNotAvailRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varCADB0698B59858BBBF6DEB48B866760C_402787773 = (mState.isGsm() && oldState.isCdma());
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change CDMA to GSM");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2B349370EAB2BB60D253C16B0E5DDDF4_1379707145 = (mState.isGsm() && !oldState.isOn() && (mPhoneType == Phone.PHONE_TYPE_CDMA));
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change CDMA OFF to GSM");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var779580E04A970D1A62D66948CB7F983C_1400810048 = (mState.isCdma() && oldState.isGsm());
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change GSM to CDMA");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var907406491902A72484AB8EDF8CEBEE8C_508845251 = (mState.isCdma() && !oldState.isOn() && (mPhoneType == Phone.PHONE_TYPE_GSM));
                {
                    Log.d(LOG_TAG,"Notifying: radio technology change GSM OFF to CDMA");
                    mRadioTechnologyChangedRegistrants.notifyRegistrants();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.417 -0400", hash_original_method = "1193518C5021D5365FC51C472C5050CB", hash_generated_method = "69A42F2EFF74FEEABD1AC7F929142872")
    protected void onRadioAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    private static String getProcCmdLine() {
        String cmdline = "";
        FileInputStream is = null;
        try {
            is = new FileInputStream("/proc/cmdline");
            byte [] buffer = new byte[2048];
            int count = is.read(buffer);
            if (count > 0) {
                cmdline = new String(buffer, 0, count);
            }
        } catch (IOException e) {
            Log.d(LOG_TAG, "No /proc/cmdline exception=" + e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        Log.d(LOG_TAG, "/proc/cmdline=" + cmdline);
        return cmdline;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.417 -0400", hash_original_method = "5CCABDB2C29BD5F7AE98CB3F70B855A8", hash_generated_method = "61206D4113E78FB2FA3F0F8BD4555769")
    @Override
    public int getLteOnCdmaMode() {
        int var338D796EC42E4804395F013DC2CD8CD5_372501434 = (getLteOnCdmaModeStatic());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580535648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580535648;
        // ---------- Original Method ----------
        //return getLteOnCdmaModeStatic();
    }

    
    public static int getLteOnCdmaModeStatic() {
        int retVal;
        int curVal;
        String productType = "";
        curVal = SystemProperties.getInt(TelephonyProperties.PROPERTY_LTE_ON_CDMA_DEVICE,
                    Phone.LTE_ON_CDMA_UNKNOWN);
        retVal = curVal;
        if (retVal == Phone.LTE_ON_CDMA_UNKNOWN) {
            Matcher matcher = sProductTypePattern.matcher(sKernelCmdLine);
            if (matcher.find()) {
                productType = matcher.group(1);
                if (sLteOnCdmaProductType.equals(productType)) {
                    retVal = Phone.LTE_ON_CDMA_TRUE;
                } else {
                    retVal = Phone.LTE_ON_CDMA_FALSE;
                }
            } else {
                retVal = Phone.LTE_ON_CDMA_FALSE;
            }
        }
        Log.d(LOG_TAG, "getLteOnCdmaMode=" + retVal + " curVal=" + curVal +
                " product_type='" + productType +
                "' lteOnCdmaProductType='" + sLteOnCdmaProductType + "'");
        return retVal;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.418 -0400", hash_original_field = "4DBD40250117FD6239DF36E7EBA17FD5", hash_generated_field = "DB7A35D86E816F9CDE58D28E944FC412")

    static final String LOG_TAG = "RILB";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.418 -0400", hash_original_field = "C252224AF16219214FD2A770CF7C8963", hash_generated_field = "10AF40480CC730D322823C6ED492B55A")

    private static final String sKernelCmdLine = getProcCmdLine();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.418 -0400", hash_original_field = "5D3FE46921C6149BD3767F3B447B2584", hash_generated_field = "1DE06EA7AE869EEEAA6B84332C564D46")

    private static final Pattern sProductTypePattern = Pattern.compile("\\sproduct_type\\s*=\\s*(\\w+)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.418 -0400", hash_original_field = "50E9340576463BE81A482BEA71F864E9", hash_generated_field = "518D583B60311B9803A5FF7A8AC06918")

    private static final String sLteOnCdmaProductType = SystemProperties.get(TelephonyProperties.PROPERTY_LTE_ON_CDMA_PRODUCT_TYPE, "");
}

