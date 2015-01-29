package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Registrant;
import android.os.RegistrantList;
import android.os.SystemProperties;
import android.util.Log;

public abstract class BaseCommands implements CommandsInterface {

    /**
     * The contents of the /proc/cmdline file
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.610 -0500", hash_original_method = "D7EE75A618128C9318B9442F75114245", hash_generated_method = "68F5FDDC7050CC9BDCB38E211A91DAE1")
    
private static String getProcCmdLine()
    {
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

    /**
     * Return if the current radio is LTE on CDMA. This
     * is a tri-state return value as for a period of time
     * the mode may be unknown.
     *
     * @return {@link Phone#LTE_ON_CDMA_UNKNOWN}, {@link Phone#LTE_ON_CDMA_FALSE}
     * or {@link Phone#LTE_ON_CDMA_TRUE}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.623 -0500", hash_original_method = "117B0F65A4F71D7CB8099C9B5AF007F4", hash_generated_method = "CB8FACC6544B771BBF4B08A2CBD9D377")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.197 -0500", hash_original_field = "C59531DE2B387E78A8D03FA621876C23", hash_generated_field = "DB7A35D86E816F9CDE58D28E944FC412")

    static final String LOG_TAG = "RILB";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.615 -0500", hash_original_field = "E2034E1FED351F46779844522BD6ADFE", hash_generated_field = "10AF40480CC730D322823C6ED492B55A")

    private static final String sKernelCmdLine = getProcCmdLine();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.617 -0500", hash_original_field = "4532795622010EFB4AEB127627A754F5", hash_generated_field = "1DE06EA7AE869EEEAA6B84332C564D46")

    private static final Pattern sProductTypePattern =
        Pattern.compile("\\sproduct_type\\s*=\\s*(\\w+)");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.620 -0500", hash_original_field = "B3B881A4FBB87F4D8D5AE8BE44348FFF", hash_generated_field = "518D583B60311B9803A5FF7A8AC06918")

    private static final String sLteOnCdmaProductType =
        SystemProperties.get(TelephonyProperties.PROPERTY_LTE_ON_CDMA_PRODUCT_TYPE, "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.200 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.203 -0500", hash_original_field = "1CF45C5C2C9EFB8AADD0AB134B895501", hash_generated_field = "E29C242D0504728E6C3C54A6DDC02A46")

    protected RadioState mState = RadioState.RADIO_UNAVAILABLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.205 -0500", hash_original_field = "3FAB0B5C2DE281E5E7D7109176A5CC7D", hash_generated_field = "732A4411E8B6CD4E0897192B6F27A157")

    protected RadioState mSimState = RadioState.RADIO_UNAVAILABLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.207 -0500", hash_original_field = "622EE459C08E4AC213C2A6141017ECE6", hash_generated_field = "34AD4D4D50B88A82487D87EDB290DD65")

    protected RadioState mRuimState = RadioState.RADIO_UNAVAILABLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.210 -0500", hash_original_field = "3FF9DA9F4E31450277A42EA7A26FE203", hash_generated_field = "AACFF7E48EB5D3C80BE4456A9FEE9F81")

    protected RadioState mNvState = RadioState.RADIO_UNAVAILABLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.212 -0500", hash_original_field = "4545EEA86E5C88EA0EC25068FF3688E7", hash_generated_field = "E5ADD6D93A64C85609CB12342A7B9EC5")

    protected Object mStateMonitor = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.214 -0500", hash_original_field = "1CB89EEFBD296E089FCCDC957206C604", hash_generated_field = "CDE5DEB085980735E31C1C0C83621370")

    protected RegistrantList mRadioStateChangedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.216 -0500", hash_original_field = "C2CA4D797AEC80D846F4A07D7CE6FEE7", hash_generated_field = "BBE48E2A62763F1E6595E3B9C75D6A71")

    protected RegistrantList mOnRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.219 -0500", hash_original_field = "A95006B5D872B1398E76A648FA9B960E", hash_generated_field = "D1905CA58B49E7F78DD846CFA64D5316")

    protected RegistrantList mAvailRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.221 -0500", hash_original_field = "E94B0638480CA549BD3C967FDF3C5607", hash_generated_field = "D638CD091BFAF9674759E1FC93BC7B15")

    protected RegistrantList mOffOrNotAvailRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.223 -0500", hash_original_field = "B6BA32A2F7699D21779203C30CACE4BB", hash_generated_field = "084460E11ACEB5369FB6E423AAFFE543")

    protected RegistrantList mNotAvailRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.226 -0500", hash_original_field = "4AAC918A0F5E8F9FC7D2D844B5FFDD4E", hash_generated_field = "05475482546969953FA0A0F9DAC30933")

    protected RegistrantList mSIMReadyRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.228 -0500", hash_original_field = "4838C5D85CB28A75B0DC3F77C3507D67", hash_generated_field = "A623E3A61C00CC0E81DAD080139B13CD")

    protected RegistrantList mSIMLockedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.231 -0500", hash_original_field = "089FF24E317963F1EC21553866F4E718", hash_generated_field = "A70A1736E6B6D7BA9282C26FE5DD4832")

    protected RegistrantList mRUIMReadyRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.233 -0500", hash_original_field = "4EDA9E97232687EDEC13BD202FF645E7", hash_generated_field = "6BA51D54C350F4A0CEA81951FA73B8D5")

    protected RegistrantList mRUIMLockedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.235 -0500", hash_original_field = "96CE83F66E30C49B374376A6EB0409C9", hash_generated_field = "091BBB21F5D16A03789C0F6AA4D344DD")

    protected RegistrantList mNVReadyRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.237 -0500", hash_original_field = "30E17ED1FC53C24C69F3112107126175", hash_generated_field = "D6147A9CA58DBB501CCF0902B7C9ED16")

    protected RegistrantList mCallStateRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.240 -0500", hash_original_field = "5B25AA019ED269C9445AAF0541EE82FC", hash_generated_field = "8DA8D929D640D50FA30AE860C09088B8")

    protected RegistrantList mVoiceNetworkStateRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.242 -0500", hash_original_field = "2481B54930BD4D084E78EACA8AEC9E11", hash_generated_field = "5E95E0F1E3C09D6368259B9646413BE4")

    protected RegistrantList mDataNetworkStateRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.244 -0500", hash_original_field = "21424A58F40E6B38E40C2CCAD6D54478", hash_generated_field = "2608CFBA55F33EAD5E5D1DA0C4C6F657")

    protected RegistrantList mRadioTechnologyChangedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.247 -0500", hash_original_field = "04DE75DF3A6E7AB16CA18A03197BFC3E", hash_generated_field = "F83A0D6273A29CF318E6C8129181889B")

    protected RegistrantList mIccStatusChangedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.249 -0500", hash_original_field = "19C80B6D64EDD5BA33FDAA2E63FF9A20", hash_generated_field = "42B6C1CA7D49825160E9EA711BCB41AA")

    protected RegistrantList mVoicePrivacyOnRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.251 -0500", hash_original_field = "0BF38E8B76BAC659F9B58E725A17920F", hash_generated_field = "1C168249758DFA87D2497586E517A8E9")

    protected RegistrantList mVoicePrivacyOffRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.253 -0500", hash_original_field = "65B50BD0879EB7ED82B07FA699E7C9F8", hash_generated_field = "C784674CD5101D15CEF6EE1260D16EE0")

    protected Registrant mUnsolOemHookRawRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.256 -0500", hash_original_field = "4118E9372ED5E225F09D9474F1683EBF", hash_generated_field = "BA5574D2FF0265742740D4181685E95C")

    protected RegistrantList mOtaProvisionRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.258 -0500", hash_original_field = "DE46B9C9ED2509C92F8DE3CAFE2F41C7", hash_generated_field = "D42946C72CBF62F18062DFF6D61C2464")

    protected RegistrantList mCallWaitingInfoRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.260 -0500", hash_original_field = "2167D5F20380CE99FF14AD7FADFE7555", hash_generated_field = "0D68472D193D8D7EEB22077B614B9226")

    protected RegistrantList mDisplayInfoRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.263 -0500", hash_original_field = "0D0CFAC0A6D840BE508300CB9A07478A", hash_generated_field = "6204214CCC43D2779C8E0010DB8CC0B9")

    protected RegistrantList mSignalInfoRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.265 -0500", hash_original_field = "7388E5C27D699D446E9B1AD04CE0DABA", hash_generated_field = "CE0ACCBD53FC2723405AD8E23F0142F2")

    protected RegistrantList mNumberInfoRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.267 -0500", hash_original_field = "A1444B8EE968B9AD6B72BCFF545B7F71", hash_generated_field = "61844679F83E8813F0E57C729B60CDFF")

    protected RegistrantList mRedirNumInfoRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.269 -0500", hash_original_field = "E2644DAFA1F6F5F1415F77D1E0461569", hash_generated_field = "8AC1E7C5F78F9248211B76622C386A07")

    protected RegistrantList mLineControlInfoRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.272 -0500", hash_original_field = "421D3453BBB0AB889BF4ED0FD4D57D61", hash_generated_field = "F40B8CC6F582B8E5175CC7D1A77E6085")

    protected RegistrantList mT53ClirInfoRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.274 -0500", hash_original_field = "8786C83EA6ED3514B214433D04A504CC", hash_generated_field = "7C160FE4F8A1F605E24D09BC9B140BAD")

    protected RegistrantList mT53AudCntrlInfoRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.276 -0500", hash_original_field = "446E2A62EB8823DC05E4AC1A6446DE25", hash_generated_field = "9C00D0FD9392C44075239940EFDF7A15")

    protected RegistrantList mRingbackToneRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.279 -0500", hash_original_field = "63E021DF95D45CE0E4F2B639E99408BA", hash_generated_field = "37A17EE00B51514019C95BC8D2DDCD7F")

    protected RegistrantList mResendIncallMuteRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.281 -0500", hash_original_field = "3FFF57125339DC6B02B27E4089D51E9D", hash_generated_field = "950524B6CFECD91E264DC30F2CA5AC4C")

    protected RegistrantList mCdmaSubscriptionChangedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.283 -0500", hash_original_field = "6EF27BE0E12FA8E301BDEF196B94B5B0", hash_generated_field = "031CB0765102321A36876E564078BD43")

    protected RegistrantList mCdmaPrlChangedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.285 -0500", hash_original_field = "27774CD41A4EBAF76950CD6377C4DBAE", hash_generated_field = "0F64A15E5224B623ED0359EA1AFACD3E")

    protected RegistrantList mExitEmergencyCallbackModeRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.288 -0500", hash_original_field = "F17CFDB56B76083FE8460990536C8F5E", hash_generated_field = "783EBC1E3434B7B9A4B526A569D3C8BB")

    protected RegistrantList mRilConnectedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.290 -0500", hash_original_field = "223A557EA16B0139BC9E29FC8844D4A4", hash_generated_field = "D0D69EEA44C0EFCE9F6687FCB10E7138")

    protected RegistrantList mIccRefreshRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.292 -0500", hash_original_field = "E3E80812CB41F37C58D020566F9CDD75", hash_generated_field = "AE6AD1CCCCF6C8652D606AE52E3DF80E")

    protected Registrant mGsmSmsRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.295 -0500", hash_original_field = "E74C8014BFFEABCB71DEEA3E86343312", hash_generated_field = "7EF8A8757C74933479C641605220142B")

    protected Registrant mCdmaSmsRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.297 -0500", hash_original_field = "87EBE06AC1B07BD919487581DA4ACF4E", hash_generated_field = "09C768F38430A45C44F4EC1B33311DC5")

    protected Registrant mNITZTimeRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.299 -0500", hash_original_field = "F39CCC17B410F23F28A663423E1ED897", hash_generated_field = "4AFA4CD65E7E12F4BEAB77E5A8A114EF")

    protected Registrant mSignalStrengthRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.302 -0500", hash_original_field = "BC4035DDB745B263638A3DC8BE2796D8", hash_generated_field = "7F634DCABCF2D0B8F220E57AE4E96590")

    protected Registrant mUSSDRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.304 -0500", hash_original_field = "F66C41CE389A97521A5F3E60692E2BCA", hash_generated_field = "B019300CE4E11592C3B33D347D7C4A76")

    protected Registrant mSmsOnSimRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.306 -0500", hash_original_field = "C72C6067DB5D87F52133C35E6D994650", hash_generated_field = "37F7FBC66940F342032C40B465BB356D")

    protected Registrant mSmsStatusRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.309 -0500", hash_original_field = "2734ACF5A2205FDB0755D540ECB61A38", hash_generated_field = "689F8C2F3A4DCAE6D5A5B4896991685A")

    protected Registrant mSsnRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.311 -0500", hash_original_field = "4419C337014D6EE683609E71E40D8EBC", hash_generated_field = "C778CA70B3096B1243F533C7A926C465")

    protected Registrant mCatSessionEndRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.313 -0500", hash_original_field = "019CEF92AB65912D70FD42020BACE8C0", hash_generated_field = "93E739C036C1A0B86A700CD298905F79")

    protected Registrant mCatProCmdRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.315 -0500", hash_original_field = "CD0DE37790C16B12706BC696EA217005", hash_generated_field = "91902976B405BE9CE9480386077C2D01")

    protected Registrant mCatEventRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.318 -0500", hash_original_field = "683CA7BB9E9DE7099F5744DCF1DFC906", hash_generated_field = "2FFB84B2CC080F88E562A0579189849B")

    protected Registrant mCatCallSetUpRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.320 -0500", hash_original_field = "37DFF4B089B7B65921BAED0F124DB66E", hash_generated_field = "D096C2B238E423A909F827C0F12E3196")

    protected Registrant mIccSmsFullRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.322 -0500", hash_original_field = "91674AD4AA426947365B2E02DA868824", hash_generated_field = "37124344C68F94A9931D1454F42E4330")

    protected Registrant mEmergencyCallbackModeRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.324 -0500", hash_original_field = "B2B568E751DFE0E8A649B7DC7B763BE1", hash_generated_field = "C761F445E12876DE0409CFB83DAB2F08")

    protected Registrant mRingRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.327 -0500", hash_original_field = "ECAEFE7484302D99AE167D227D3A671E", hash_generated_field = "80081B8B3844FBB01B0E57137B1A6224")

    protected Registrant mRestrictedStateRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.329 -0500", hash_original_field = "5C9B30DC91B2E3BAF43ED14D359090C0", hash_generated_field = "CD191F79A4233E2F2A818FF2D70F9A22")

    protected Registrant mGsmBroadcastSmsRegistrant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.331 -0500", hash_original_field = "5BA84AC7CBE58E4EDB6614D7B15D6E0E", hash_generated_field = "BCBFFA7CC72CEAA7B3225E97ACF5F508")

    // This is used when establishing a connection to the
    // vendor ril so it starts up in the correct mode.
    protected int mPreferredNetworkType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.333 -0500", hash_original_field = "FB6A6063BA17535310EA07300EE41861", hash_generated_field = "37D13576834061AD4F22AAB21A88FECE")

    protected int mCdmaSubscription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.336 -0500", hash_original_field = "0BA29C91C7DC80561AF2F5B14AF1461A", hash_generated_field = "ADD2566E3A8EA5E90C108782BDB8F38B")

    protected int mPhoneType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.338 -0500", hash_original_field = "159201D2737D5780BDFB3E85B6D4DD19", hash_generated_field = "580E7C4318D3476CC0659BF42E5F3A02")

    protected int mRilVersion = -1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.341 -0500", hash_original_method = "01B446908FD885F92167357142764DD4", hash_generated_method = "278FDA288815D1F4040531D2621A1CFF")
    
public BaseCommands(Context context) {
        mContext = context;  // May be null (if so we won't log statistics)
    }

    //***** CommandsInterface implementation

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.343 -0500", hash_original_method = "9B72FF4B03FA7DBB789195860BAD353E", hash_generated_method = "1A4DF3503DAD413FBA6D5DE85196FA3D")
    
public RadioState getRadioState() {
        return mState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.345 -0500", hash_original_method = "683B910DC6B22521B92A68335EE5839B", hash_generated_method = "1A4AE1BCA3F53177D1E3C2EC88B7E26B")
    
public RadioState getSimState() {
        return mSimState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.347 -0500", hash_original_method = "109C4CEB2CE04AD161352D599FB1B09F", hash_generated_method = "CCF57F8F91A7403A4CCCCAA460F79DF1")
    
public RadioState getRuimState() {
        return mRuimState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.350 -0500", hash_original_method = "903DF1C2B5F50A021347F02D35C70B16", hash_generated_method = "E09338173B836225921FF0F00FE4079E")
    
public RadioState getNvState() {
        return mNvState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.353 -0500", hash_original_method = "BA48B5E0F5DAB3A06803759CD1341873", hash_generated_method = "7A303584A28E658A76CD96322DDF547F")
    
public void registerForRadioStateChanged(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        synchronized (mStateMonitor) {
            mRadioStateChangedRegistrants.add(r);
            r.notifyRegistrant();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.355 -0500", hash_original_method = "5BE66114299D36CCAFF9DF2B86730E54", hash_generated_method = "F0D5B306F4508250D229F315EA279678")
    
public void unregisterForRadioStateChanged(Handler h) {
        synchronized (mStateMonitor) {
            mRadioStateChangedRegistrants.remove(h);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.358 -0500", hash_original_method = "08D5A7DF41ADD1C0423FEF7DAFFF25BD", hash_generated_method = "99E31F47E4A51C67ECBE17049F2A4FED")
    
public void registerForOn(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        synchronized (mStateMonitor) {
            mOnRegistrants.add(r);

            if (mState.isOn()) {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            }
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.360 -0500", hash_original_method = "DAE1468F1869D31101D72670C27E98BE", hash_generated_method = "3B35EFAB18A28ED129E32DE318E4CEDC")
    
public void unregisterForOn(Handler h) {
        synchronized (mStateMonitor) {
            mOnRegistrants.remove(h);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.362 -0500", hash_original_method = "B002A9DBB8C7C11A31C2582BB5EE1874", hash_generated_method = "C7726F30C474FC3EAAA7933506E3EB84")
    
public void registerForAvailable(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        synchronized (mStateMonitor) {
            mAvailRegistrants.add(r);

            if (mState.isAvailable()) {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.365 -0500", hash_original_method = "1CA2372C2986DE46A59E6A0B2684AC78", hash_generated_method = "9C405F82321EA8CEC1C0B0AB1C05C416")
    
public void unregisterForAvailable(Handler h) {
        synchronized(mStateMonitor) {
            mAvailRegistrants.remove(h);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.367 -0500", hash_original_method = "29C83058E2196992ACCCDF2436EB895F", hash_generated_method = "C830B07BD5A6C3A04995BE2CC7914ECD")
    
public void registerForNotAvailable(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        synchronized (mStateMonitor) {
            mNotAvailRegistrants.add(r);

            if (!mState.isAvailable()) {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.370 -0500", hash_original_method = "CBA6674D64F15D2FCB61961545603AC0", hash_generated_method = "460780400BB3B4DCA26BA2BC67242592")
    
public void unregisterForNotAvailable(Handler h) {
        synchronized (mStateMonitor) {
            mNotAvailRegistrants.remove(h);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.372 -0500", hash_original_method = "7D79215F701EB0E62714361F42A7E5B1", hash_generated_method = "D91319EF734EEB13E7FEEC17E6E9CDA6")
    
public void registerForOffOrNotAvailable(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        synchronized (mStateMonitor) {
            mOffOrNotAvailRegistrants.add(r);

            if (mState == RadioState.RADIO_OFF || !mState.isAvailable()) {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            }
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.374 -0500", hash_original_method = "46989C4094561DAD50220FCBDDA75AA6", hash_generated_method = "3563BFC76873C6CA96CA2283124DFBDA")
    
public void unregisterForOffOrNotAvailable(Handler h) {
        synchronized(mStateMonitor) {
            mOffOrNotAvailRegistrants.remove(h);
        }
    }

    /** Any transition into SIM_READY */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.376 -0500", hash_original_method = "CC4432751ADD65730712EA705F22C3CD", hash_generated_method = "A16E16A1FBA95A0B4FE5FE948D5FF540")
    
public void registerForSIMReady(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        synchronized (mStateMonitor) {
            mSIMReadyRegistrants.add(r);

            if (mSimState.isSIMReady()) {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.379 -0500", hash_original_method = "AB19D2A11305E45A98335C636B50C33B", hash_generated_method = "CDA1E8B0D4327AD3B1D7B68714C70D31")
    
public void unregisterForSIMReady(Handler h) {
        synchronized (mStateMonitor) {
            mSIMReadyRegistrants.remove(h);
        }
    }

    /** Any transition into RUIM_READY */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.382 -0500", hash_original_method = "2C12645510D08A28B5398079ECA6EB3E", hash_generated_method = "F1135F81E245D5F44D4DD04C74F709EE")
    
public void registerForRUIMReady(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        synchronized (mStateMonitor) {
            mRUIMReadyRegistrants.add(r);

            if (mRuimState.isRUIMReady()) {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.384 -0500", hash_original_method = "5D1587722234669A56B255A4AE24EE40", hash_generated_method = "06FCA3C0F9B0E6D8DDF5F03428000B3F")
    
public void unregisterForRUIMReady(Handler h) {
        synchronized(mStateMonitor) {
            mRUIMReadyRegistrants.remove(h);
        }
    }

    /** Any transition into NV_READY */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.386 -0500", hash_original_method = "AC5C11E970C3FC3CF3AF902D98D61BFC", hash_generated_method = "91F316A454E41AC735D44DB96D84CF41")
    
public void registerForNVReady(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        synchronized (mStateMonitor) {
            mNVReadyRegistrants.add(r);

            if (mNvState.isNVReady()) {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.389 -0500", hash_original_method = "0163F455801DEEBEEE15E264968FFDFB", hash_generated_method = "09148AAE2CE8961BD8E05985C98EF611")
    
public void unregisterForNVReady(Handler h) {
        synchronized (mStateMonitor) {
            mNVReadyRegistrants.remove(h);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.391 -0500", hash_original_method = "B685FFCB0EF7DE87E1299EB2C0D91FF5", hash_generated_method = "76880148330AD57538FC7DD161EA1581")
    
public void registerForSIMLockedOrAbsent(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        synchronized (mStateMonitor) {
            mSIMLockedRegistrants.add(r);

            if (mSimState == RadioState.SIM_LOCKED_OR_ABSENT) {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.394 -0500", hash_original_method = "9E4C5688CACB9B43620D9767F5ED2831", hash_generated_method = "F962E6E840B76D08828335E6592581C5")
    
public void unregisterForSIMLockedOrAbsent(Handler h) {
        synchronized (mStateMonitor) {
            mSIMLockedRegistrants.remove(h);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.396 -0500", hash_original_method = "B883F560C1A8BD25AD0100160D6BFB3E", hash_generated_method = "1E3D8A8760DB35D1436BFAC3406E8D6D")
    
public void registerForRUIMLockedOrAbsent(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        synchronized (mStateMonitor) {
            mRUIMLockedRegistrants.add(r);

            if (mRuimState == RadioState.RUIM_LOCKED_OR_ABSENT) {
                r.notifyRegistrant(new AsyncResult(null, null, null));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.398 -0500", hash_original_method = "F7619224FDBBC62B94132C1DE98F9FAE", hash_generated_method = "6B8257A9F2A1FDAEB707A2C6F5C9E511")
    
public void unregisterForRUIMLockedOrAbsent(Handler h) {
        synchronized (mStateMonitor) {
            mRUIMLockedRegistrants.remove(h);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.401 -0500", hash_original_method = "F8B2EAE479ED91D774CA562E26158F6A", hash_generated_method = "45D1C708F45C27F7565D3C66F3F15180")
    
public void registerForCallStateChanged(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        mCallStateRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.404 -0500", hash_original_method = "E52D1B8D1DC6759546B1451A8AF3B3CF", hash_generated_method = "C310A5CE954E41AE285310C52FD76B52")
    
public void unregisterForCallStateChanged(Handler h) {
        mCallStateRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.406 -0500", hash_original_method = "98A3778C7EF08FDD67D8F92B137CAB51", hash_generated_method = "84BD78DEF7E691E5E6C668D1CCE6C0E9")
    
public void registerForVoiceNetworkStateChanged(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        mVoiceNetworkStateRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.409 -0500", hash_original_method = "234E1E4E00B04837A43F108E250B7BAF", hash_generated_method = "0FE86944707768CC3D6B5B1629B06885")
    
public void unregisterForVoiceNetworkStateChanged(Handler h) {
        mVoiceNetworkStateRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.412 -0500", hash_original_method = "4B5CEB601891F006C0B3F4D5219F87E4", hash_generated_method = "58EE559CAD97798D48088C9623AE472E")
    
public void registerForDataNetworkStateChanged(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        mDataNetworkStateRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.414 -0500", hash_original_method = "B36E31BF0B8FB61A85A55463809AD286", hash_generated_method = "2EAF38FFBA59DB1D5B7B1D7702B8E9F5")
    
public void unregisterForDataNetworkStateChanged(Handler h) {
        mDataNetworkStateRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.416 -0500", hash_original_method = "BDED847FB928F6304C85EAE7BEEAA6C9", hash_generated_method = "563C28C357D8BB81E4414549626C50FC")
    
public void registerForRadioTechnologyChanged(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mRadioTechnologyChangedRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.418 -0500", hash_original_method = "836C826B4F0456A82E6FAC645FFBE7BB", hash_generated_method = "CC33B720C34974ECED642AC30E342F00")
    
public void unregisterForRadioTechnologyChanged(Handler h) {
        mRadioTechnologyChangedRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.421 -0500", hash_original_method = "95A4334EE1F2766E4CCE86BA1BBC52D8", hash_generated_method = "77566487A0ED3F6E136E6BAEB64860B2")
    
public void registerForIccStatusChanged(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mIccStatusChangedRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.423 -0500", hash_original_method = "9A6E8063793F2864B53A6581C25E75A7", hash_generated_method = "0FA570DA9E5C4C41D53280024AF4FBF4")
    
public void unregisterForIccStatusChanged(Handler h) {
        mIccStatusChangedRegistrants.remove(h);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.426 -0500", hash_original_method = "7CF6E9042288CF5BCC8A41B33E0FC1FA", hash_generated_method = "8A9CE8E0FEB30E7F93889ABE173AA674")
    
public void setOnNewGsmSms(Handler h, int what, Object obj) {
        mGsmSmsRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.428 -0500", hash_original_method = "72321487D3788873BF3F462EC89D1700", hash_generated_method = "CCC783B0997FAD7BC64A4B2BC5F7FA30")
    
public void unSetOnNewGsmSms(Handler h) {
        mGsmSmsRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.430 -0500", hash_original_method = "9A78052D6944BA613BED064A1FCE96FC", hash_generated_method = "5072ED8E2809C882E4B4734520124F94")
    
public void setOnNewCdmaSms(Handler h, int what, Object obj) {
        mCdmaSmsRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.433 -0500", hash_original_method = "DD82A350612B8F1A5930420947333FBB", hash_generated_method = "E37B12A473446DA16214EDAF5ED168D0")
    
public void unSetOnNewCdmaSms(Handler h) {
        mCdmaSmsRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.435 -0500", hash_original_method = "33C97215793324BA09B0AC1C1CB62DDA", hash_generated_method = "11A15DB01F8A6CD391FAC008519C39E4")
    
public void setOnNewGsmBroadcastSms(Handler h, int what, Object obj) {
        mGsmBroadcastSmsRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.437 -0500", hash_original_method = "E9BA47BA240C655456D09F99640997E5", hash_generated_method = "E3A8235EAD233610B48D0738A7F49F07")
    
public void unSetOnNewGsmBroadcastSms(Handler h) {
        mGsmBroadcastSmsRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.440 -0500", hash_original_method = "0C74AFDE10017540B93B7C27C178AD12", hash_generated_method = "278BBBC0C3B2693DA4CE2AAC2BEBE192")
    
public void setOnSmsOnSim(Handler h, int what, Object obj) {
        mSmsOnSimRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.442 -0500", hash_original_method = "4BFC1B363FF8A6E9FA34FFCCC3CD985B", hash_generated_method = "DBDEE227FC780522875FB137690AC70F")
    
public void unSetOnSmsOnSim(Handler h) {
        mSmsOnSimRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.444 -0500", hash_original_method = "11EEFE2847E162D5587C8E576D844178", hash_generated_method = "820EBCD955DF448C45C04D082AE257F3")
    
public void setOnSmsStatus(Handler h, int what, Object obj) {
        mSmsStatusRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.447 -0500", hash_original_method = "04CADE4525B4CE9C767EB33D42E2733D", hash_generated_method = "95B434A8857866F9D7F521BD7578509A")
    
public void unSetOnSmsStatus(Handler h) {
        mSmsStatusRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.449 -0500", hash_original_method = "BC3FAB2490D1A217545C1F22508EF51F", hash_generated_method = "3C713C1077BEAC63EC257A18D02233C7")
    
public void setOnSignalStrengthUpdate(Handler h, int what, Object obj) {
        mSignalStrengthRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.451 -0500", hash_original_method = "1D4E93C65FCE9EA625F7FEE880958248", hash_generated_method = "620B4DE95576A5882F1035BB57A0EA6E")
    
public void unSetOnSignalStrengthUpdate(Handler h) {
        mSignalStrengthRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.453 -0500", hash_original_method = "B93626E61216BE05ADCBA600BD7F638F", hash_generated_method = "7D3F869E4AE96FB956A86EAB96F6CE0A")
    
public void setOnNITZTime(Handler h, int what, Object obj) {
        mNITZTimeRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.456 -0500", hash_original_method = "71E2E923C47A5EE8EAC4F6876E00C1CF", hash_generated_method = "85CD2C7DFF87D1BDE42B7A0A192338EF")
    
public void unSetOnNITZTime(Handler h) {
        mNITZTimeRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.458 -0500", hash_original_method = "B95EC97639ED908B13D752A2F13F6C7D", hash_generated_method = "15783340D84BC789875DBCC2E3364A31")
    
public void setOnUSSD(Handler h, int what, Object obj) {
        mUSSDRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.461 -0500", hash_original_method = "466A12DF4A4A0EB8A1AA727D5C05C698", hash_generated_method = "3990F566822F6E734A7BA15EC1301ABF")
    
public void unSetOnUSSD(Handler h) {
        mUSSDRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.464 -0500", hash_original_method = "8D0E51584543A1B70BDE99B5C9D8170F", hash_generated_method = "DD88AA945A1267F0D66950D11ED3D2E6")
    
public void setOnSuppServiceNotification(Handler h, int what, Object obj) {
        mSsnRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.466 -0500", hash_original_method = "04E80546CB98E014EC8E47E6045C2AF5", hash_generated_method = "74F6DC03C582A79D386AC36D5F62DB05")
    
public void unSetOnSuppServiceNotification(Handler h) {
        mSsnRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.469 -0500", hash_original_method = "6C58C9A1E016A05F52E2E9DA6EEAE5BF", hash_generated_method = "F0948E1A8A7F618E7CF726FFAB65C7D8")
    
public void setOnCatSessionEnd(Handler h, int what, Object obj) {
        mCatSessionEndRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.471 -0500", hash_original_method = "17A9937977241978E29E1F3DF9376CD7", hash_generated_method = "E22791531DED304F03403073D7E29C76")
    
public void unSetOnCatSessionEnd(Handler h) {
        mCatSessionEndRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.473 -0500", hash_original_method = "D06ACD9FCA890DD319CAD0E6F7424AE6", hash_generated_method = "92E4F86791108FA2AB4DE8A1EFB7717E")
    
public void setOnCatProactiveCmd(Handler h, int what, Object obj) {
        mCatProCmdRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.475 -0500", hash_original_method = "39B4BC08A3AA39DBF2A794BF5A29A6E7", hash_generated_method = "21AFC687F5D5F634000C4B9CFF07FFBF")
    
public void unSetOnCatProactiveCmd(Handler h) {
        mCatProCmdRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.478 -0500", hash_original_method = "C195D512833847BDA6BB456AF1EEA3B4", hash_generated_method = "46ED77C9C2412964492006229588D737")
    
public void setOnCatEvent(Handler h, int what, Object obj) {
        mCatEventRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.480 -0500", hash_original_method = "86C985017D9E368A998E97DBE619C9A6", hash_generated_method = "7A4071FE5C400ECAC8C31C86620402E6")
    
public void unSetOnCatEvent(Handler h) {
        mCatEventRegistrant.clear();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.482 -0500", hash_original_method = "F9248546B0B94A00BBD09A54A068232C", hash_generated_method = "AB3B1D5C6469D30F16E438DB10A01D83")
    
public void setOnCatCallSetUp(Handler h, int what, Object obj) {
        mCatCallSetUpRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.485 -0500", hash_original_method = "F6D53B8DEDF633EF9F4DE137121098A9", hash_generated_method = "90BD73AEB74799F2775915CCEB17E034")
    
public void unSetOnCatCallSetUp(Handler h) {
        mCatCallSetUpRegistrant.clear();
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.487 -0500", hash_original_method = "CEFBB5FD27FBF0DBAFAF8D4D6CE13FCD", hash_generated_method = "02E8EE35D254B0165E1B056E3BF6B1F0")
    
public void setOnIccSmsFull(Handler h, int what, Object obj) {
        mIccSmsFullRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.489 -0500", hash_original_method = "D81168F17A138BA5FBA6935B53E34C2B", hash_generated_method = "B2ACFE0B7A75691687E7943578D096DE")
    
public void unSetOnIccSmsFull(Handler h) {
        mIccSmsFullRegistrant.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.492 -0500", hash_original_method = "A200936B8F975752C35A9946FF5C3971", hash_generated_method = "B25F70E85DAD43738998FBA2F225CD9C")
    
public void registerForIccRefresh(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mIccRefreshRegistrants.add(r);
    }
    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.494 -0500", hash_original_method = "EBD003897DB6B5AFBE1C90F6779BE273", hash_generated_method = "50B95FF2441D6D88A8B206D10A3BC957")
    
public void setOnIccRefresh(Handler h, int what, Object obj) {
        registerForIccRefresh(h, what, obj);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.497 -0500", hash_original_method = "B609D137446E0B07BA45D584DFD22E03", hash_generated_method = "441724EA00247EEB399DE1687B50C7A8")
    
public void setEmergencyCallbackMode(Handler h, int what, Object obj) {
        mEmergencyCallbackModeRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.499 -0500", hash_original_method = "ABCF42C92E2736F7BB23B78C79C740F8", hash_generated_method = "93538D257139ABF4D39DEA93ABD06E98")
    
public void unregisterForIccRefresh(Handler h) {
        mIccRefreshRegistrants.remove(h);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.502 -0500", hash_original_method = "59DD40F71F856C45DA56522E074542F9", hash_generated_method = "D6A3317AE318CBE5A3BD57CEF579DD5C")
    
public void unsetOnIccRefresh(Handler h) {
        unregisterForIccRefresh(h);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.504 -0500", hash_original_method = "8CCA793687CAB6E48BC4AA126090CB63", hash_generated_method = "4622101CA035E771C3B57A6127D6AC9C")
    
public void setOnCallRing(Handler h, int what, Object obj) {
        mRingRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.506 -0500", hash_original_method = "0FA0F9BD0056AE1CB836D67BF674653F", hash_generated_method = "0DB0E245D189B96CA01BAD76D1C1D3CC")
    
public void unSetOnCallRing(Handler h) {
        mRingRegistrant.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.509 -0500", hash_original_method = "66886B702ABE8C8A8A8DA809F8864E28", hash_generated_method = "7D847DBF3FF4EF5C9E4E1C8BC6A9BB52")
    
public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mVoicePrivacyOnRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.511 -0500", hash_original_method = "88FA771B173FBD911A63B00DE113B65C", hash_generated_method = "4684C0B96BD40B4BF0A5D71AD44F5C54")
    
public void unregisterForInCallVoicePrivacyOn(Handler h){
        mVoicePrivacyOnRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.514 -0500", hash_original_method = "0B5424223CA275A3C5522DC295A616C4", hash_generated_method = "DD3D049E83EEDFBF709DF370BF7A7389")
    
public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mVoicePrivacyOffRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.516 -0500", hash_original_method = "B6E776E83D138F03FEB9EA861FA40286", hash_generated_method = "80D65DFF586A6DD1FBC5CC306F08A1AD")
    
public void unregisterForInCallVoicePrivacyOff(Handler h){
        mVoicePrivacyOffRegistrants.remove(h);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.518 -0500", hash_original_method = "5582113CD84EF18DC77145673CEF3805", hash_generated_method = "B791666A4267DB82C747DB02074A7236")
    
public void setOnRestrictedStateChanged(Handler h, int what, Object obj) {
        mRestrictedStateRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.520 -0500", hash_original_method = "5B907CCB9E561B2BE570362A93E2C20B", hash_generated_method = "B2C768AD08E2AB5D892E33E2558D6F40")
    
public void unSetOnRestrictedStateChanged(Handler h) {
        mRestrictedStateRegistrant.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.523 -0500", hash_original_method = "79DF5BB64C5088A6DDB6F272CE7B24F1", hash_generated_method = "7E8AEB7496CED14C60B1CBE5A72EE0F0")
    
public void registerForDisplayInfo(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mDisplayInfoRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.526 -0500", hash_original_method = "E2A72B7F5933EC1681F428F18D2E3B34", hash_generated_method = "822A9B1B0F6A89F266DFA2425D23D291")
    
public void unregisterForDisplayInfo(Handler h) {
        mDisplayInfoRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.528 -0500", hash_original_method = "9BA2D7AA1768E0B6D41C51CBB7D2703D", hash_generated_method = "3DEE2D5E03548F34CC5C35493EF2B99C")
    
public void registerForCallWaitingInfo(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mCallWaitingInfoRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.531 -0500", hash_original_method = "FB5DFAB4742CFF0D938DB8F68F07D307", hash_generated_method = "27F8A63834BE6ADA43F98E9C5EC9B436")
    
public void unregisterForCallWaitingInfo(Handler h) {
        mCallWaitingInfoRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.533 -0500", hash_original_method = "8157808DA0C2AB05798E28DF7F48B26A", hash_generated_method = "C8DB67081B3195C3B21C65451207FEC1")
    
public void registerForSignalInfo(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mSignalInfoRegistrants.add(r);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.535 -0500", hash_original_method = "023EEE600D5AEC21A0C3A38A31A02F7B", hash_generated_method = "9795762AA88F0000A40F81148EF3A043")
    
public void setOnUnsolOemHookRaw(Handler h, int what, Object obj) {
        mUnsolOemHookRawRegistrant = new Registrant (h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.538 -0500", hash_original_method = "B838AB3AB572CDA21BA8AB62D1043E1A", hash_generated_method = "710790F33021F0C71E15D837A16997D9")
    
public void unSetOnUnsolOemHookRaw(Handler h) {
        mUnsolOemHookRawRegistrant.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.540 -0500", hash_original_method = "FBD3C31CDF21A461B92CD6532FEB56B0", hash_generated_method = "708F3897985DBD72D88A2426DA4C408A")
    
public void unregisterForSignalInfo(Handler h) {
        mSignalInfoRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.542 -0500", hash_original_method = "FE7848C889A71C1D52EEFBC3A5A5348D", hash_generated_method = "B7B8EFD1AE7A17600798F94FCD7E05D6")
    
public void registerForCdmaOtaProvision(Handler h,int what, Object obj){
        Registrant r = new Registrant (h, what, obj);
        mOtaProvisionRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.544 -0500", hash_original_method = "AB18EE6BF73A37B52EA253A91CB20B0C", hash_generated_method = "76EBF12D28E1BC6E95398AC58DA27E7C")
    
public void unregisterForCdmaOtaProvision(Handler h){
        mOtaProvisionRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.547 -0500", hash_original_method = "30DBB41A5641384CBA2903733EB0CBD5", hash_generated_method = "EE4E4B765BBCF8BDA6D99D4AE6997AB9")
    
public void registerForNumberInfo(Handler h,int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mNumberInfoRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.550 -0500", hash_original_method = "D4F64543EBE672B1B0DCB72B7F1C49BF", hash_generated_method = "6A783AF472C7BEE3B94FF9D4F7AC44A5")
    
public void unregisterForNumberInfo(Handler h){
        mNumberInfoRegistrants.remove(h);
    }

     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.552 -0500", hash_original_method = "CC4E070A6851C62B1452697B8CB637B7", hash_generated_method = "FB8ED6BA42EDAAEF6AF70BC5AD6FFFDC")
    
public void registerForRedirectedNumberInfo(Handler h,int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mRedirNumInfoRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.554 -0500", hash_original_method = "74D412781A2F86280EE77A31B77394EF", hash_generated_method = "2A24B296442AC1B7ED64FC6FCB4A65A3")
    
public void unregisterForRedirectedNumberInfo(Handler h) {
        mRedirNumInfoRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.557 -0500", hash_original_method = "DD58771B0A7A96A346281B999DA3057A", hash_generated_method = "6C7F34016DBE687E89D788D0ED811AE3")
    
public void registerForLineControlInfo(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mLineControlInfoRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.559 -0500", hash_original_method = "068928B7A17337EC34F57926DDEBA1C3", hash_generated_method = "E76DA8267AA75C3EC42824B57044AC40")
    
public void unregisterForLineControlInfo(Handler h) {
        mLineControlInfoRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.561 -0500", hash_original_method = "9F4D1AFFEF8F9FA5D4778DB89C674FB3", hash_generated_method = "A3DF0B6E75A3A37B6321AA7279D8531F")
    
public void registerFoT53ClirlInfo(Handler h,int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mT53ClirInfoRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.563 -0500", hash_original_method = "814EFF5BC3C88040487B5EAFB470F77D", hash_generated_method = "A8F3162189AA050F70020A0A8A419A57")
    
public void unregisterForT53ClirInfo(Handler h) {
        mT53ClirInfoRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.566 -0500", hash_original_method = "8DE8707DBC07257BD950DE59918A2503", hash_generated_method = "190CB941DF087CA8C419B1ED7B0A798A")
    
public void registerForT53AudioControlInfo(Handler h,int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mT53AudCntrlInfoRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.569 -0500", hash_original_method = "1211535609DA01F7ECA596E2B136A338", hash_generated_method = "BB3693071B59BF0F5494A7F942FAA134")
    
public void unregisterForT53AudioControlInfo(Handler h) {
        mT53AudCntrlInfoRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.571 -0500", hash_original_method = "2D9C6817A422E1F1364DE24FB7D91AF7", hash_generated_method = "01B7E15976A7A48874B2E421782A567C")
    
public void registerForRingbackTone(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mRingbackToneRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.573 -0500", hash_original_method = "F4C16CBC87D51F6E30E1C3D8F75EE8C0", hash_generated_method = "D10110A4ADEFA495CA52F0415A54CA69")
    
public void unregisterForRingbackTone(Handler h) {
        mRingbackToneRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.576 -0500", hash_original_method = "DB3523E7FBDC2E46BB6C1DB462AA57D5", hash_generated_method = "7CFF2806529308B41FD4E766C08E6E45")
    
public void registerForResendIncallMute(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mResendIncallMuteRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.578 -0500", hash_original_method = "2A2F187C5BCDF7811DB17C690EF5A1E4", hash_generated_method = "7E72ABBB4A22D5302793080B6BA58492")
    
public void unregisterForResendIncallMute(Handler h) {
        mResendIncallMuteRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.580 -0500", hash_original_method = "1CB550350E2118EA5DDBC3DA5F8BB474", hash_generated_method = "78B10786E8EB5DEFD7E135B19D3FAFF7")
    
@Override
    public void registerForCdmaSubscriptionChanged(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mCdmaSubscriptionChangedRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.583 -0500", hash_original_method = "7C70EFDA99D4F1952D617116BAD22B13", hash_generated_method = "2E4414BBE351BFC02EF3679476CDA3AD")
    
@Override
    public void unregisterForCdmaSubscriptionChanged(Handler h) {
        mCdmaSubscriptionChangedRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.585 -0500", hash_original_method = "F2C3D1E241ED9A5D51FF055B13B3E9E2", hash_generated_method = "B38928395BA01BDCF0E6ECB0BBC414D2")
    
@Override
    public void registerForCdmaPrlChanged(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mCdmaPrlChangedRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.587 -0500", hash_original_method = "BF3AB10D2A3E0AB38BFCD9D12CDB5334", hash_generated_method = "F92FA63A665E4B9E820D6A330BEC0E4D")
    
@Override
    public void unregisterForCdmaPrlChanged(Handler h) {
        mCdmaPrlChangedRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.590 -0500", hash_original_method = "0716736C7FBF358A30A0A4F7C12EEF60", hash_generated_method = "5FF40FDC529FBF7147BAD1796A9A1E2A")
    
@Override
    public void registerForExitEmergencyCallbackMode(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mExitEmergencyCallbackModeRegistrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.593 -0500", hash_original_method = "C2E40B70802C2BB799E08EA528BF2439", hash_generated_method = "0589B1BB97A3F45F35961B382843B67C")
    
@Override
    public void unregisterForExitEmergencyCallbackMode(Handler h) {
        mExitEmergencyCallbackModeRegistrants.remove(h);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.595 -0500", hash_original_method = "A1D8B314CFB1D3E12BFA58A9A280A374", hash_generated_method = "1812D9FCB529AAC7D03279D76125136A")
    
@Override
    public void registerForRilConnected(Handler h, int what, Object obj) {
        Log.d(LOG_TAG, "registerForRilConnected h=" + h + " w=" + what);
        Registrant r = new Registrant (h, what, obj);
        mRilConnectedRegistrants.add(r);
        if (mRilVersion != -1) {
            Log.d(LOG_TAG, "Notifying: ril connected mRilVersion=" + mRilVersion);
            r.notifyRegistrant(new AsyncResult(null, new Integer(mRilVersion), null));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.598 -0500", hash_original_method = "676479F86CF5300F7E3A79F357120869", hash_generated_method = "7684E371C0270C548A101852B85AD407")
    
@Override
    public void unregisterForRilConnected(Handler h) {
        mRilConnectedRegistrants.remove(h);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.600 -0500", hash_original_method = "9E4D177DE2C4D1C0BCFAAE47CCC59231", hash_generated_method = "25AA40D4020BD55841855C1021ACF232")
    
@Override
    public void setCurrentPreferredNetworkType() {
    }

    //***** Protected Methods
    /**
     * Store new RadioState and send notification based on the changes
     *
     * This function is called only by RIL.java when receiving unsolicited
     * RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED
     *
     * RadioState has 5 values : RADIO_OFF, RADIO_UNAVAILABLE, SIM_NOT_READY,
     * SIM_LOCKED_OR_ABSENT, and SIM_READY.
     *
     * @param newState new RadioState decoded from RIL_UNSOL_RADIO_STATE_CHANGED
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.604 -0500", hash_original_method = "DCDD085282B6C088E7A0852C995BCBF3", hash_generated_method = "F533F3425D596432293C45573178791E")
    
protected void setRadioState(RadioState newState) {
        RadioState oldState;

        synchronized (mStateMonitor) {
            if (false) {
                Log.v(LOG_TAG, "setRadioState old: " + mState
                    + " new " + newState);
            }

            oldState = mState;
            mState = newState;

            if (oldState == mState) {
                // no state transition
                return;
            }

            // FIXME: Use Constants or Enums
            if(mState.getType() == 0) {
                mSimState = mState;
                mRuimState = mState;
                mNvState = mState;
            }
            else if (mState.getType() == 1) {
                mSimState = mState;
            }
            else if (mState.getType() == 2) {
                mRuimState = mState;
            }
            else if (mState.getType() == 3) {
                mNvState = mState;
            }

            mRadioStateChangedRegistrants.notifyRegistrants();

            if (mState.isAvailable() && !oldState.isAvailable()) {
                Log.d(LOG_TAG,"Notifying: radio available");
                mAvailRegistrants.notifyRegistrants();
                onRadioAvailable();
            }

            if (!mState.isAvailable() && oldState.isAvailable()) {
                Log.d(LOG_TAG,"Notifying: radio not available");
                mNotAvailRegistrants.notifyRegistrants();
            }

            if (mState.isSIMReady() && !oldState.isSIMReady()) {
                Log.d(LOG_TAG,"Notifying: SIM ready");
                mSIMReadyRegistrants.notifyRegistrants();
            }

            if (mState == RadioState.SIM_LOCKED_OR_ABSENT) {
                Log.d(LOG_TAG,"Notifying: SIM locked or absent");
                mSIMLockedRegistrants.notifyRegistrants();
            }

            if (mState.isRUIMReady() && !oldState.isRUIMReady()) {
                Log.d(LOG_TAG,"Notifying: RUIM ready");
                mRUIMReadyRegistrants.notifyRegistrants();
            }

            if (mState == RadioState.RUIM_LOCKED_OR_ABSENT) {
                Log.d(LOG_TAG,"Notifying: RUIM locked or absent");
                mRUIMLockedRegistrants.notifyRegistrants();
            }
            if (mState.isNVReady() && !oldState.isNVReady()) {
                Log.d(LOG_TAG,"Notifying: NV ready");
                mNVReadyRegistrants.notifyRegistrants();
            }

            if (mState.isOn() && !oldState.isOn()) {
                Log.d(LOG_TAG,"Notifying: Radio On");
                mOnRegistrants.notifyRegistrants();
            }

            if ((!mState.isOn() || !mState.isAvailable())
                && !((!oldState.isOn() || !oldState.isAvailable()))
            ) {
                Log.d(LOG_TAG,"Notifying: radio off or not available");
                mOffOrNotAvailRegistrants.notifyRegistrants();
            }

            /* Radio Technology Change events
             * NOTE: isGsm and isCdma have no common states in RADIO_OFF or RADIO_UNAVAILABLE; the
             *   current phone is determined by mPhoneType
             * NOTE: at startup no phone have been created and the RIL determines the mPhoneType
             *   looking based on the networkMode set by the PhoneFactory in the constructor
             */

            if (mState.isGsm() && oldState.isCdma()) {
                Log.d(LOG_TAG,"Notifying: radio technology change CDMA to GSM");
                mRadioTechnologyChangedRegistrants.notifyRegistrants();
            }

            if (mState.isGsm() && !oldState.isOn() && (mPhoneType == Phone.PHONE_TYPE_CDMA)) {
                Log.d(LOG_TAG,"Notifying: radio technology change CDMA OFF to GSM");
                mRadioTechnologyChangedRegistrants.notifyRegistrants();
            }

            if (mState.isCdma() && oldState.isGsm()) {
                Log.d(LOG_TAG,"Notifying: radio technology change GSM to CDMA");
                mRadioTechnologyChangedRegistrants.notifyRegistrants();
            }

            if (mState.isCdma() && !oldState.isOn() && (mPhoneType == Phone.PHONE_TYPE_GSM)) {
                Log.d(LOG_TAG,"Notifying: radio technology change GSM OFF to CDMA");
                mRadioTechnologyChangedRegistrants.notifyRegistrants();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.607 -0500", hash_original_method = "1193518C5021D5365FC51C472C5050CB", hash_generated_method = "AB6A3C0C0BCBEC621B409979CDE008ED")
    
protected void onRadioAvailable() {
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:36.612 -0500", hash_original_method = "5CCABDB2C29BD5F7AE98CB3F70B855A8", hash_generated_method = "878B3C3B065232DBAD0E4007DC184F63")
    
@Override
    public int getLteOnCdmaMode() {
        return getLteOnCdmaModeStatic();
    }
}

