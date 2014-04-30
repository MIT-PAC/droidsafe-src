package android.support.v4.view.accessibility;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatIcs {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.797 -0500", hash_original_method = "24339090B0A4B6721EAAEB1B2705BB62", hash_generated_method = "DF9DE8CEF759A057CF5C066E9B5F75EE")
    
public static Object obtain() {
        return AccessibilityNodeInfo.obtain();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.800 -0500", hash_original_method = "7C1A71F696AD8B13B363B59F6E0DAA70", hash_generated_method = "632427E58F226291A247EBF66E311709")
    
public static Object obtain(View source) {
        return AccessibilityNodeInfo.obtain(source);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.804 -0500", hash_original_method = "1BDF274B3BAD9A351B3ACC86314CDCDC", hash_generated_method = "5D2C9E1F4B99855DEABC410701606271")
    
public static Object obtain(Object info) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) info);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.809 -0500", hash_original_method = "AA632A639793D92F7D2A85D9D42E86DE", hash_generated_method = "02ED881FAFFE703AB6031C2D53DBFE5E")
    
public static void addAction(Object info, int action) {
        ((AccessibilityNodeInfo) info).addAction(action);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.812 -0500", hash_original_method = "E4E471E7A68F69AE76FDB86081800F5A", hash_generated_method = "AA8021E4A63D60481D17195E51407C29")
    
public static void addChild(Object info, View child) {
        ((AccessibilityNodeInfo) info).addChild(child);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.816 -0500", hash_original_method = "C88F101213475955C325CB1E6582DC81", hash_generated_method = "E945EED5B5CFB0B5B9BBBF1DC322030C")
    
@SuppressWarnings("unchecked")
    public static List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
        Object result = ((AccessibilityNodeInfo) info).findAccessibilityNodeInfosByText(text);
        return (List<Object>) result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.820 -0500", hash_original_method = "E69B8C0BA1D9B6B045BEDB63243D17D2", hash_generated_method = "324554085D12BB78D967095E96419C82")
    
public static int getActions(Object info) {
        return ((AccessibilityNodeInfo) info).getActions();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.823 -0500", hash_original_method = "9C6D09DC36A131F167FA2A012205D0CE", hash_generated_method = "48FD7821527DDFCD8B750C0AE32085AD")
    
public static void getBoundsInParent(Object info, Rect outBounds) {
        ((AccessibilityNodeInfo) info).getBoundsInParent(outBounds);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.828 -0500", hash_original_method = "C9DF8A65CC2F6A00EF5E7BAE04D063BA", hash_generated_method = "8D84C335A9D94CACD7D8829110673598")
    
public static void getBoundsInScreen(Object info, Rect outBounds) {
        ((AccessibilityNodeInfo) info).getBoundsInScreen(outBounds);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.831 -0500", hash_original_method = "FF22FC2D70CABB8EA28B0072AD58762E", hash_generated_method = "4C389B639CD5F5E32E495F03FF8BF7C3")
    
public static Object getChild(Object info, int index) {
        return ((AccessibilityNodeInfo) info).getChild(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.835 -0500", hash_original_method = "B04E9BAF06D8F0794129AEEF3A9A6461", hash_generated_method = "2EB2C89AA9C10195E8805C2D94A86055")
    
public static int getChildCount(Object info) {
        return ((AccessibilityNodeInfo) info).getChildCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.840 -0500", hash_original_method = "448692B0C71E73CC3E32A586CC16F2BD", hash_generated_method = "C4F8E9BD2A171E7FA710197FB0B00873")
    
public static CharSequence getClassName(Object info) {
        return ((AccessibilityNodeInfo) info).getClassName();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.843 -0500", hash_original_method = "D9C04F09B7C01390C23345BD9F0BA1DB", hash_generated_method = "3F2AA12B98BDD6CE4B1B0D38AEB847BB")
    
public static CharSequence getContentDescription(Object info) {
        return ((AccessibilityNodeInfo) info).getContentDescription();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.847 -0500", hash_original_method = "AB3EF81EFE9DD8ABFE7024B987B8D034", hash_generated_method = "6E87B25896AF4F444B6BC3AF8B4AB225")
    
public static CharSequence getPackageName(Object info) {
        return ((AccessibilityNodeInfo) info).getPackageName();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.851 -0500", hash_original_method = "EE3E70CF923D43F3D4D7BC16634E3603", hash_generated_method = "FD69EE099771E3CF1879ECCEBB67E537")
    
public static Object getParent(Object info) {
        return ((AccessibilityNodeInfo) info).getParent();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.854 -0500", hash_original_method = "2C79B50E4420533F11A9F19A74B0CD87", hash_generated_method = "87D89E77CF39E1DC3312D802DE570928")
    
public static CharSequence getText(Object info) {
        return ((AccessibilityNodeInfo) info).getText();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.858 -0500", hash_original_method = "E85D80FE12E4581261209D4BE4B441FB", hash_generated_method = "74C826C7FEABF174C3B0B6067D683C8C")
    
public static int getWindowId(Object info) {
        return ((AccessibilityNodeInfo) info).getWindowId();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.861 -0500", hash_original_method = "6FE9E83F120BAF505E933D56FE8F54CA", hash_generated_method = "EC04A529EB4FF029FA0768CEA4957A81")
    
public static boolean isCheckable(Object info) {
        return ((AccessibilityNodeInfo) info).isCheckable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.865 -0500", hash_original_method = "B4F5755D7CE32966E59BBCB6901C0B5D", hash_generated_method = "D12C889E7D831E488481CF987B1C9FA9")
    
public static boolean isChecked(Object info) {
        return ((AccessibilityNodeInfo) info).isChecked();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.868 -0500", hash_original_method = "F75CD988A32B610A30B52CA2993682B6", hash_generated_method = "4157051B608F771BA23DB566157930A4")
    
public static boolean isClickable(Object info) {
        return ((AccessibilityNodeInfo) info).isClickable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.872 -0500", hash_original_method = "95351C5BAB5FCE7DAAD26C0D553A2843", hash_generated_method = "6BF25B487F1E9D4730A927725E03E8F3")
    
public static boolean isEnabled(Object info) {
        return ((AccessibilityNodeInfo) info).isEnabled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.876 -0500", hash_original_method = "FF857E1A28ED81A8DF9845E28DA699A7", hash_generated_method = "6AB792B868CCCA60CB084B69C7F79363")
    
public static boolean isFocusable(Object info) {
        return ((AccessibilityNodeInfo) info).isFocusable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.880 -0500", hash_original_method = "308C812DFD1684EB604B4B421DE08BAC", hash_generated_method = "D6B8A2B158F4E67404B4F8C2792D6C81")
    
public static boolean isFocused(Object info) {
        return ((AccessibilityNodeInfo) info).isFocused();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.884 -0500", hash_original_method = "20E75F72A5454E1C36DC51CC14712C16", hash_generated_method = "5B8CF837792149F386A197B29EF5D072")
    
public static boolean isLongClickable(Object info) {
        return ((AccessibilityNodeInfo) info).isLongClickable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.887 -0500", hash_original_method = "6D8CFBDA9A20455C0637BAF8905F102C", hash_generated_method = "4CA19970FB6884B07971821D2A60DEDF")
    
public static boolean isPassword(Object info) {
        return ((AccessibilityNodeInfo) info).isPassword();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.890 -0500", hash_original_method = "FA6627CF9831941F90880242285EB357", hash_generated_method = "9D621A6A2BC90259908B35212884DD5A")
    
public static boolean isScrollable(Object info) {
        return ((AccessibilityNodeInfo) info).isScrollable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.892 -0500", hash_original_method = "0454CCBF6AED94110F2E45F56791516D", hash_generated_method = "7138F038FF2FA8B698F14ED1B1D29A59")
    
public static boolean isSelected(Object info) {
        return ((AccessibilityNodeInfo) info).isSelected();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.895 -0500", hash_original_method = "E637DE79C1A07808EDFBC6C0A4B86644", hash_generated_method = "144BC8BB156021EFDE827540F762026E")
    
public static boolean performAction(Object info, int action) {
        return ((AccessibilityNodeInfo) info).performAction(action);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.897 -0500", hash_original_method = "C86AEC97A0239BCD7249C6FE9FF232E6", hash_generated_method = "0C6BB24F5718629AB7FF2793B538B9B6")
    
public static void setBoundsInParent(Object info, Rect bounds) {
        ((AccessibilityNodeInfo) info).setBoundsInParent(bounds);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.899 -0500", hash_original_method = "CC390D0E78078429B7D1BD0A0C3E66B4", hash_generated_method = "11D4D414AB00252BE77DD0BC276B75AA")
    
public static void setBoundsInScreen(Object info, Rect bounds) {
        ((AccessibilityNodeInfo) info).setBoundsInScreen(bounds);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.902 -0500", hash_original_method = "958B4DCBADA1833A1255F92386D86018", hash_generated_method = "73C797FBF7AB17513016C12D5E092947")
    
public static void setCheckable(Object info, boolean checkable) {
        ((AccessibilityNodeInfo) info).setCheckable(checkable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.904 -0500", hash_original_method = "EAD60BFD76F485D95A25C883F281B2ED", hash_generated_method = "6668AFB503F4A405F55F98960FFB0B36")
    
public static void setChecked(Object info, boolean checked) {
        ((AccessibilityNodeInfo) info).setChecked(checked);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.906 -0500", hash_original_method = "D016C9BD2C049F6FD2C2187F3DF94501", hash_generated_method = "4670A26B5D0AA1FE85452BC17333C6E1")
    
public static void setClassName(Object info, CharSequence className) {
        ((AccessibilityNodeInfo) info).setClassName(className);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.908 -0500", hash_original_method = "FF891C09BDFDEA35CD90853B855388F2", hash_generated_method = "1A214BDB468D23E4936ACC5F44A425D3")
    
public static void setClickable(Object info, boolean clickable) {
        ((AccessibilityNodeInfo) info).setClickable(clickable);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.910 -0500", hash_original_method = "474879C571C870F257CD2FFF61DF2661", hash_generated_method = "D4385D77777F822616DCFF695337BF4C")
    
public static void setContentDescription(Object info, CharSequence contentDescription) {
        ((AccessibilityNodeInfo) info).setContentDescription(contentDescription);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.913 -0500", hash_original_method = "AF6A8F1D0E43368FC34EBF31EAE60479", hash_generated_method = "056362F3F538347350B1EFCEF202FE46")
    
public static void setEnabled(Object info, boolean enabled) {
        ((AccessibilityNodeInfo) info).setEnabled(enabled);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.916 -0500", hash_original_method = "9C18DAC2805018857D8A02D49124CB23", hash_generated_method = "1FC2CF3812BBCD016E9820611C4AED92")
    
public static void setFocusable(Object info, boolean focusable) {
        ((AccessibilityNodeInfo) info).setFocusable(focusable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.919 -0500", hash_original_method = "9CB20BC4569E6FF4F556669F7A3ED538", hash_generated_method = "D81D413EACC7116E4ECCECC6CE5417F8")
    
public static void setFocused(Object info, boolean focused) {
        ((AccessibilityNodeInfo) info).setFocused(focused);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.921 -0500", hash_original_method = "7047FCDA61EFDBBB55192A73AF15AF82", hash_generated_method = "AFB33F3C2B0B53444BFE417A29C3C03D")
    
public static void setLongClickable(Object info, boolean longClickable) {
        ((AccessibilityNodeInfo) info).setLongClickable(longClickable);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.923 -0500", hash_original_method = "44056C5350C39A763BAC2CF1BDE66498", hash_generated_method = "AE7F8131704CDD8872B7AD6487664E48")
    
public static void setPackageName(Object info, CharSequence packageName) {
        ((AccessibilityNodeInfo) info).setPackageName(packageName);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.926 -0500", hash_original_method = "1018D4F7F39EC9355402FA6416658A04", hash_generated_method = "599C3AD8B577FA429C5504E3F7E3CB26")
    
public static void setParent(Object info, View parent) {
        ((AccessibilityNodeInfo) info).setParent(parent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.928 -0500", hash_original_method = "07AF69896513E68C4364FFBE4DF41081", hash_generated_method = "439A1E814573B5C6E4FDD30BBF6CC647")
    
public static void setPassword(Object info, boolean password) {
        ((AccessibilityNodeInfo) info).setPassword(password);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.930 -0500", hash_original_method = "30FF2C2E78B89CBCCE27E4A446CE5D3F", hash_generated_method = "BC0A63215AD9FC10F77EBD5446A1259D")
    
public static void setScrollable(Object info, boolean scrollable) {
        ((AccessibilityNodeInfo) info).setScrollable(scrollable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.933 -0500", hash_original_method = "D0C5DDB2523C06C7C4ECE32B662653E5", hash_generated_method = "016BA133E69AECE1F3E3749E76F1858C")
    
public static void setSelected(Object info, boolean selected) {
        ((AccessibilityNodeInfo) info).setSelected(selected);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.935 -0500", hash_original_method = "A66FD1E3E429B3817BCEC07A0150B898", hash_generated_method = "ED6C1DF61622C4C6FAE857C7C8CE64A7")
    
public static void setSource(Object info, View source) {
        ((AccessibilityNodeInfo) info).setSource(source);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.938 -0500", hash_original_method = "DE265DB87520D9B6C85E91941B207B97", hash_generated_method = "31771D57BA329C9E0437C4F70DEB7877")
    
public static void setText(Object info, CharSequence text) {
        ((AccessibilityNodeInfo) info).setText(text);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.940 -0500", hash_original_method = "805379CD3DB31F13219E65BA0420C4E0", hash_generated_method = "5F67E40DC0DCF649A6D0E143690C97A6")
    
public static void recycle(Object info) {
        ((AccessibilityNodeInfo) info).recycle();
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.967 -0400", hash_original_method = "90D82575443FCC4920A59159F197ECDC", hash_generated_method = "90D82575443FCC4920A59159F197ECDC")
    public AccessibilityNodeInfoCompatIcs ()
    {
        //Synthesized constructor
    }
    
}

