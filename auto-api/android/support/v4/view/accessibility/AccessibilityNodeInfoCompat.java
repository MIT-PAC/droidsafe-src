package android.support.v4.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessibilityNodeInfoCompat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.613 -0400", hash_original_field = "1715FF63502BEC0E28C8D7CA89F0F72E", hash_generated_field = "EA545B797CAE6A5B712CE13E995894C9")

    private Object mInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.614 -0400", hash_original_method = "27EEB78B664A0859CE9D2482B14EDA44", hash_generated_method = "5D13B8B7945325E456070CD74C88BF1B")
    public  AccessibilityNodeInfoCompat(Object info) {
        mInfo = info;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.615 -0400", hash_original_method = "180B11831FF091AFD58918B491DA5734", hash_generated_method = "0FEFC318914C76792234B19DF0FC6855")
    public Object getImpl() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1186166230 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1186166230 = mInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1186166230.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1186166230;
        
        
    }

    
    public static AccessibilityNodeInfoCompat obtain(View source) {
        return new AccessibilityNodeInfoCompat(IMPL.obtain(source));
    }

    
    public static AccessibilityNodeInfoCompat obtain() {
        return new AccessibilityNodeInfoCompat(IMPL.obtain());
    }

    
    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat info) {
        return new AccessibilityNodeInfoCompat(IMPL.obtain(info.mInfo));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.617 -0400", hash_original_method = "DBD6C4E567C7947922529BA45E2088C3", hash_generated_method = "B9A8D26EC6E76B8860701C97CEB73C3D")
    public void setSource(View source) {
        IMPL.setSource(mInfo, source);
        addTaint(source.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.619 -0400", hash_original_method = "2FCD3C5691FCBE6EB393188032460842", hash_generated_method = "81631B7902A162385D6431E13E5000EC")
    public int getWindowId() {
        int var2C540017C5FDBD06182064294FB65830_1164829326 = (IMPL.getWindowId(mInfo));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127391789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127391789;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.619 -0400", hash_original_method = "2AD4C51D718899601C93A5649AD946AD", hash_generated_method = "9B8950CA53BBF3FF622E18A493B3FE81")
    public int getChildCount() {
        int varE2F87AC99FDBC7ACD964CC797AE1EB45_900650486 = (IMPL.getChildCount(mInfo));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218364938 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218364938;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.620 -0400", hash_original_method = "8EA123998643A19BBF17F459FF07BE7E", hash_generated_method = "7A6B6D6E25F833F9F4B07B820EE02143")
    public AccessibilityNodeInfoCompat getChild(int index) {
        AccessibilityNodeInfoCompat varB4EAC82CA7396A68D541C85D26508E83_2118636637 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2118636637 = new AccessibilityNodeInfoCompat(IMPL.getChild(mInfo, index));
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2118636637.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2118636637;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.621 -0400", hash_original_method = "96991CF3D104F82AE28D15A837764722", hash_generated_method = "F10AB86557B6E113FACEA4BC2C4BCCE2")
    public void addChild(View child) {
        IMPL.addChild(mInfo, child);
        addTaint(child.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.622 -0400", hash_original_method = "933CE3223B5CD7F54D5F21B403DB8A7E", hash_generated_method = "6E22DC7C00341C2984F57DC8B920365A")
    public int getActions() {
        int var78B020D21D062A4C783B30E843B22FA5_1502865920 = (IMPL.getActions(mInfo));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148753756 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148753756;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.623 -0400", hash_original_method = "F620D8EC3817B6EC64D02A805E40B2B4", hash_generated_method = "E0B54E6A2A12F57325FE334316F8B8A4")
    public void addAction(int action) {
        IMPL.addAction(mInfo, action);
        addTaint(action);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.623 -0400", hash_original_method = "76F70B64C56F7E2DCA168B652A090370", hash_generated_method = "CE56AF918A8D576454576C0BF0CFF3F2")
    public boolean performAction(int action) {
        boolean var103988539CD5F32DC229350E3FE6F08A_1662245512 = (IMPL.performAction(mInfo, action));
        addTaint(action);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809436715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809436715;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.625 -0400", hash_original_method = "D972868A6ABA9BEE83DE29ABCCDE4A4C", hash_generated_method = "7B4C3D76FAC5B5D4F7D232DDE5BDEF6A")
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String text) {
        List<AccessibilityNodeInfoCompat> varB4EAC82CA7396A68D541C85D26508E83_1076339625 = null; 
        List<AccessibilityNodeInfoCompat> result = new ArrayList<AccessibilityNodeInfoCompat>();
        List<Object> infos = IMPL.findAccessibilityNodeInfosByText(mInfo, text);
        final int infoCount = infos.size();
        {
            int i = 0;
            {
                Object info = infos.get(i);
                result.add(new AccessibilityNodeInfoCompat(info));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1076339625 = result;
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1076339625.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1076339625;
        
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.628 -0400", hash_original_method = "2E852E0313CFFDFAD47286627DB8F00F", hash_generated_method = "2EABA2AA0C2A17CA8DDA44084E431D2E")
    public AccessibilityNodeInfoCompat getParent() {
        AccessibilityNodeInfoCompat varB4EAC82CA7396A68D541C85D26508E83_1182041339 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1182041339 = new AccessibilityNodeInfoCompat(IMPL.getParent(mInfo));
        varB4EAC82CA7396A68D541C85D26508E83_1182041339.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1182041339;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.628 -0400", hash_original_method = "86518FC5D5AE3E2BA199BEEAA088933F", hash_generated_method = "B25849869AAB46D2E99D9E8E940F1C70")
    public void setParent(View parent) {
        IMPL.setParent(mInfo, parent);
        addTaint(parent.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.629 -0400", hash_original_method = "E0ACD239D05CD134F4788FDE11AB973D", hash_generated_method = "B38356A1EF490FC5686450FA7A9C1D49")
    public void getBoundsInParent(Rect outBounds) {
        IMPL.getBoundsInParent(mInfo, outBounds);
        addTaint(outBounds.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.630 -0400", hash_original_method = "3D18F1D3A722CB931F3C0EA8FCAAFCB7", hash_generated_method = "00EE6B9099A2BEF08CEB58F6805C5C65")
    public void setBoundsInParent(Rect bounds) {
        IMPL.setBoundsInParent(mInfo, bounds);
        addTaint(bounds.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.630 -0400", hash_original_method = "603EEE18F9883128AEF640A26C131D4C", hash_generated_method = "0F39350AF1000599F2F3D64B600400B5")
    public void getBoundsInScreen(Rect outBounds) {
        IMPL.getBoundsInScreen(mInfo, outBounds);
        addTaint(outBounds.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.631 -0400", hash_original_method = "59EABEF98A7E138E1AB24AE8A708DBC4", hash_generated_method = "AC8CDB1835B95905F6B3CFBBA6E65C23")
    public void setBoundsInScreen(Rect bounds) {
        IMPL.setBoundsInParent(mInfo, bounds);
        addTaint(bounds.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.632 -0400", hash_original_method = "AC8D43F54DC3BA7E7C149D4503D525F3", hash_generated_method = "3B75EC17587DC31BB220A89A7B18EAA7")
    public boolean isCheckable() {
        boolean var881652E9087A67FD47CD951364E58936_1455446408 = (IMPL.isCheckable(mInfo));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628047455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628047455;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.633 -0400", hash_original_method = "02532B45DC391F52A2535027893C38AD", hash_generated_method = "649DA0156EF801046DFB238BB898FF12")
    public void setCheckable(boolean checkable) {
        IMPL.setCheckable(mInfo, checkable);
        addTaint(checkable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.635 -0400", hash_original_method = "519FEB307C383A2CCF5C74B89068518B", hash_generated_method = "62C65582B8157A9BD1D38CE7073BFC5D")
    public boolean isChecked() {
        boolean var08DAE480D25E6F8A460CE20163A37E73_1225327629 = (IMPL.isChecked(mInfo));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_395313592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_395313592;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.637 -0400", hash_original_method = "FAB30364812370D4A3BF52C70FA75BB2", hash_generated_method = "927FC88703350AC89E971412B0ECF216")
    public void setChecked(boolean checked) {
        IMPL.setChecked(mInfo, checked);
        addTaint(checked);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.637 -0400", hash_original_method = "C9FC8F868000F9B33292AD780E66DCA0", hash_generated_method = "E2F1198C73A45881E588BF64662062E2")
    public boolean isFocusable() {
        boolean var6DA275B257371FC0A6EA50877523FCE1_818417549 = (IMPL.isFocusable(mInfo));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2122448708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2122448708;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.638 -0400", hash_original_method = "FBAE0F38121F1E86CBC8B993867A4A27", hash_generated_method = "1F8304F04C9F78728E4226D2AC22EED9")
    public void setFocusable(boolean focusable) {
        IMPL.setFocusable(mInfo, focusable);
        addTaint(focusable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.639 -0400", hash_original_method = "4F186107AF4B40F30B1A87108529D484", hash_generated_method = "B4AAFB714C330049D85A20DD76E43A94")
    public boolean isFocused() {
        boolean var4C52A5799DFA7B577F2FD98012268A29_499700849 = (IMPL.isFocused(mInfo));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480562998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480562998;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.639 -0400", hash_original_method = "9869A69DD9422BD72F2EA6EC374F4934", hash_generated_method = "BE02EC61B0AC317A6C94CF177A4B85A1")
    public void setFocused(boolean focused) {
        IMPL.setFocused(mInfo, focused);
        addTaint(focused);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.640 -0400", hash_original_method = "DDA60D7434111992259669E63D890C29", hash_generated_method = "299132CD6DD2E1072C1F7E24477B9DF6")
    public boolean isSelected() {
        boolean var446F6294CD18EF13CA938F2E472AA4FE_496600911 = (IMPL.isSelected(mInfo));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858590181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858590181;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.641 -0400", hash_original_method = "CCBAF3645335D86B821DEAC9BDDB4ED2", hash_generated_method = "1210AE97A5E469B6D138BCCDAC0C6A22")
    public void setSelected(boolean selected) {
        IMPL.setSelected(mInfo, selected);
        addTaint(selected);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.642 -0400", hash_original_method = "6F39B6C0009288DFEA1A8807AE028922", hash_generated_method = "60EF27C087D8D7779EA3D18BC805EC8A")
    public boolean isClickable() {
        boolean var7963C53F1A95ED1807A5BE44364C92C9_251597217 = (IMPL.isClickable(mInfo));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_637000836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_637000836;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.642 -0400", hash_original_method = "CBF9AA1E7F6DA4EEE21EFD519E970C6E", hash_generated_method = "317DF61AD2DE0E5529A6E0E59960DE64")
    public void setClickable(boolean clickable) {
        IMPL.setClickable(mInfo, clickable);
        addTaint(clickable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.643 -0400", hash_original_method = "2A0651AA24697C87D5B10A2F592D15AE", hash_generated_method = "AA3D0B74A0FA5F81A03E8A5EF9B4CCEC")
    public boolean isLongClickable() {
        boolean varCBF69A98DE422BCAE8DA88D6A2AE3DDE_591228512 = (IMPL.isLongClickable(mInfo));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_216162340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_216162340;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.644 -0400", hash_original_method = "C41DB90B24D967665ADB7BE195D933F7", hash_generated_method = "0354D42970284DC817A93477D29F3F85")
    public void setLongClickable(boolean longClickable) {
        IMPL.setLongClickable(mInfo, longClickable);
        addTaint(longClickable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.644 -0400", hash_original_method = "652E5B5F063CB50BC77186FF37F33BDF", hash_generated_method = "17E599CE9F3E65D16E8AC3131A29A6DF")
    public boolean isEnabled() {
        boolean var0B12C276488CF1B63F0507AD6C9DCF14_2027329738 = (IMPL.isEnabled(mInfo));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1444824473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1444824473;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.645 -0400", hash_original_method = "38B56F1A12BFB4B4EFFD2BC2116AF996", hash_generated_method = "A1EF8FEC3165EE7E5C9FC907C51A82F8")
    public void setEnabled(boolean enabled) {
        IMPL.setEnabled(mInfo, enabled);
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.646 -0400", hash_original_method = "65A99E085FF9E307AFC93D67B83055DB", hash_generated_method = "46D95CDF56631DE0813D6E3A5CEC019A")
    public boolean isPassword() {
        boolean varAAFD846A9F01B82DE0FF7DF944363E05_1006309745 = (IMPL.isPassword(mInfo));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1249030400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1249030400;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.647 -0400", hash_original_method = "B97A25B40B977908B12069641BAB55A8", hash_generated_method = "159B6C7E3310497F5DF3D1A9937D5100")
    public void setPassword(boolean password) {
        IMPL.setPassword(mInfo, password);
        addTaint(password);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.647 -0400", hash_original_method = "C7AAD2830522B8BD5949276001A4D042", hash_generated_method = "5E9CCF6D53D983A204E55F09E0217EC1")
    public boolean isScrollable() {
        boolean var7484613912CCC955D33633FC9864C9AD_1692277999 = (IMPL.isScrollable(mInfo));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_412217709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_412217709;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.648 -0400", hash_original_method = "EF0CC581E7F7F261AFF7A1550C16EBCA", hash_generated_method = "23B15A9BE64A810E7C453929BEA92D68")
    public void setScrollable(boolean scrollable) {
        IMPL.setScrollable(mInfo, scrollable);
        addTaint(scrollable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.649 -0400", hash_original_method = "11DA2F2F6D35A0A5BD4D3AD5855546F2", hash_generated_method = "F6152BE6133A92BBB6322988BAD7E346")
    public CharSequence getPackageName() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1473758079 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1473758079 = IMPL.getPackageName(mInfo);
        varB4EAC82CA7396A68D541C85D26508E83_1473758079.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1473758079;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.650 -0400", hash_original_method = "51BDE657C455C3947A276CD4621D88BF", hash_generated_method = "EE3733C306729745A5DACA9BE318A15D")
    public void setPackageName(CharSequence packageName) {
        IMPL.setPackageName(mInfo, packageName);
        addTaint(packageName.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.652 -0400", hash_original_method = "80725931141339E528C95BCDFA69AC67", hash_generated_method = "8516419502154CCCEE67E8CAC30912D9")
    public CharSequence getClassName() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1775754834 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1775754834 = IMPL.getClassName(mInfo);
        varB4EAC82CA7396A68D541C85D26508E83_1775754834.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1775754834;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.654 -0400", hash_original_method = "95DBB6C9D00CCAE01AE6EC9F7D77613E", hash_generated_method = "E5E1CB6F562E3E5471A0F9C9998EC371")
    public void setClassName(CharSequence className) {
        IMPL.setClassName(mInfo, className);
        addTaint(className.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.656 -0400", hash_original_method = "384621808EBD921F20A6EB28B91ADAD5", hash_generated_method = "4179F081FB6C5C3C44C6226183ED507E")
    public CharSequence getText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_97091778 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_97091778 = IMPL.getText(mInfo);
        varB4EAC82CA7396A68D541C85D26508E83_97091778.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_97091778;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.657 -0400", hash_original_method = "CCE84BD471DC2DB3AF81C568CF944475", hash_generated_method = "924E383CA3CB88BCA19AFE42A14004B3")
    public void setText(CharSequence text) {
        IMPL.setText(mInfo, text);
        addTaint(text.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.658 -0400", hash_original_method = "17A5AE651613EAEE40274E28D0DBF3CB", hash_generated_method = "A3E40AD4724E9D481138B0F1647EB42E")
    public CharSequence getContentDescription() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1670322549 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1670322549 = IMPL.getContentDescription(mInfo);
        varB4EAC82CA7396A68D541C85D26508E83_1670322549.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1670322549;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.659 -0400", hash_original_method = "0581568FD089D03E78C8C673EC290A8E", hash_generated_method = "FC0DAC2D7C6E471F03F2803384D0095A")
    public void setContentDescription(CharSequence contentDescription) {
        IMPL.setContentDescription(mInfo, contentDescription);
        addTaint(contentDescription.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.660 -0400", hash_original_method = "4012C2A77CF6E1C54F1B4372AFDF8962", hash_generated_method = "C65940CB1FE55E31C8C8CA907DBC92D5")
    public void recycle() {
        IMPL.recycle(mInfo);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.661 -0400", hash_original_method = "3D44C3AC54A391BB7EEFE6DCE99834D5", hash_generated_method = "0CE197A7BB7141A588688785252D223D")
    @Override
    public int hashCode() {
        {
            Object var74F5A1A70F8B87BC71D4D158E73D3C48_1856548034 = (mInfo.hashCode());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848876185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848876185;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.665 -0400", hash_original_method = "9F360410AD288A74DD17C77A13BAB054", hash_generated_method = "7F279251BBB954FF1F431C45CCD08E57")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var0BDD716692710C348B07111E17BD2B29_481194931 = (getClass() != obj.getClass());
        } 
        AccessibilityNodeInfoCompat other = (AccessibilityNodeInfoCompat) obj;
        {
            boolean varCAB2F203900AEB7FB5D4E82EBD4544A0_1716498546 = (!mInfo.equals(other.mInfo));
        } 
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517997634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_517997634;
        
        
            
        
        
            
        
        
            
        
        
        
            
                
            
        
            
        
        
    }

    
    static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.666 -0400", hash_original_method = "D9A4AFBF5AD5A775B6C1281730E5BA11", hash_generated_method = "D9A4AFBF5AD5A775B6C1281730E5BA11")
        public AccessibilityNodeInfoStubImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.668 -0400", hash_original_method = "817FD8D623FDA4524F619AFC293F09EC", hash_generated_method = "7BCC0B443AAC494C811C352437985B63")
        public Object obtain() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1491404459 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1491404459 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1491404459.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1491404459;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.670 -0400", hash_original_method = "92695667FFAB3FACD22606EFAA0A43BA", hash_generated_method = "0D728D13C832E43E7731B9C704695239")
        public Object obtain(View source) {
            Object varB4EAC82CA7396A68D541C85D26508E83_610279554 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_610279554 = null;
            addTaint(source.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_610279554.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_610279554;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.672 -0400", hash_original_method = "773588C99ADE780DBDFC19514017BC1F", hash_generated_method = "9079873DA7145CBE6C909DEF39E42452")
        public Object obtain(Object info) {
            Object varB4EAC82CA7396A68D541C85D26508E83_858746405 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_858746405 = null;
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_858746405.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_858746405;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.673 -0400", hash_original_method = "8D71C6A90F236F7F17CE9F0DA3BE99D2", hash_generated_method = "6D05B2D93FBA1AB3A27ED2193FB0FBCD")
        public void addAction(Object info, int action) {
            addTaint(info.getTaint());
            addTaint(action);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.674 -0400", hash_original_method = "6B9372E604C01DF70F526B6A8E570148", hash_generated_method = "1002FF86A408C8AA0C5EAB0BCF45835B")
        public void addChild(Object info, View child) {
            addTaint(info.getTaint());
            addTaint(child.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.675 -0400", hash_original_method = "DDFBD7F537083E060F4196E4CBB1F004", hash_generated_method = "23B5D8597342E681BB26A8C3277B48EE")
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
            List<Object> varB4EAC82CA7396A68D541C85D26508E83_1069970448 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1069970448 = Collections.emptyList();
            addTaint(info.getTaint());
            addTaint(text.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1069970448.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1069970448;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.675 -0400", hash_original_method = "62879C9A6873AFA1FE78492502C9E8C1", hash_generated_method = "7D054945E69002975AD645F00FA02087")
        public int getActions(Object info) {
            addTaint(info.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181066658 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181066658;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.676 -0400", hash_original_method = "194BB4DCA6CDD611708C0DBE13AE8AE6", hash_generated_method = "DF2BD16B7AC01825F0F223F910FE71B9")
        public void getBoundsInParent(Object info, Rect outBounds) {
            addTaint(info.getTaint());
            addTaint(outBounds.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.677 -0400", hash_original_method = "AD025A7E801C16406D0F86CAFA041F7F", hash_generated_method = "49EF257B0A7B2E1EA3428095521BA7AB")
        public void getBoundsInScreen(Object info, Rect outBounds) {
            addTaint(info.getTaint());
            addTaint(outBounds.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.678 -0400", hash_original_method = "3EFC24789BAB789DBA02244C19291A8A", hash_generated_method = "A8506AD221CD6E7DE084BEEE98039526")
        public Object getChild(Object info, int index) {
            Object varB4EAC82CA7396A68D541C85D26508E83_179065164 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_179065164 = null;
            addTaint(info.getTaint());
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_179065164.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_179065164;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.678 -0400", hash_original_method = "DE0573752D5D98EE2B44C4024F5102E5", hash_generated_method = "619C97CACC93B25AD9BDBFA86DD2D8B2")
        public int getChildCount(Object info) {
            addTaint(info.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720440625 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720440625;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.680 -0400", hash_original_method = "0F7CFAB631E1B134DCF395A7797DAF67", hash_generated_method = "BF426D925D8DABD7A64D8744EDA5A0EC")
        public CharSequence getClassName(Object info) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1666751436 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1666751436 = null;
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1666751436.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1666751436;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.681 -0400", hash_original_method = "7D3E1748FD6A5B3BAF1D83AAF2AE15DE", hash_generated_method = "6C08F3DC1B7C52920DD2E806DF534609")
        public CharSequence getContentDescription(Object info) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_522162040 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_522162040 = null;
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_522162040.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_522162040;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.682 -0400", hash_original_method = "D7A11002847EF3E5746055DA2B429105", hash_generated_method = "25CBD10BC64D285586EF15C3A549DE7F")
        public CharSequence getPackageName(Object info) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_757009682 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_757009682 = null;
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_757009682.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_757009682;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.683 -0400", hash_original_method = "6E57EFC15A3C835051BC240D78A056B3", hash_generated_method = "3FF0986648F4C80E73D1A74E4D4761EE")
        public AccessibilityNodeInfoCompat getParent(Object info) {
            AccessibilityNodeInfoCompat varB4EAC82CA7396A68D541C85D26508E83_1345922351 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1345922351 = null;
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1345922351.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1345922351;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.684 -0400", hash_original_method = "CA1AE5519AB49B9F955ADEDF9C3C214E", hash_generated_method = "1ECF77CEC5408B644FE4DF68F2A67260")
        public CharSequence getText(Object info) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_837199938 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_837199938 = null;
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_837199938.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_837199938;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.684 -0400", hash_original_method = "EB7D2054B13C972973DD67D9B21CE0E5", hash_generated_method = "F2C3D41C62EE995883F9AC8FD3372A4D")
        public int getWindowId(Object info) {
            addTaint(info.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598921686 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598921686;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.685 -0400", hash_original_method = "4E39FE68FD90D69FA08C7AD1E979DF07", hash_generated_method = "0E213CA14847437E8E7E3B81E5349849")
        public boolean isCheckable(Object info) {
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606636476 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606636476;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.686 -0400", hash_original_method = "F2469434A89FA62BE9B2DB78034140F5", hash_generated_method = "D31A423CEEB8CD735B81EE3F46B598B7")
        public boolean isChecked(Object info) {
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695982053 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695982053;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.686 -0400", hash_original_method = "F7781A93E107315385A57825C2B0B78A", hash_generated_method = "92619DCB854BDA4FB7911529C1A305A5")
        public boolean isClickable(Object info) {
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1727241851 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1727241851;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.687 -0400", hash_original_method = "6BAAC3777342DFE283E965C06FC8D874", hash_generated_method = "A1533C37734A06B5DBAF40272B97053D")
        public boolean isEnabled(Object info) {
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_379767221 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_379767221;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.688 -0400", hash_original_method = "24826F7A102BA4F82C9D9B08241E284F", hash_generated_method = "AEBAE12D0C4CFB6E1FEE5B7ED7939FAE")
        public boolean isFocusable(Object info) {
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1816042703 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1816042703;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.688 -0400", hash_original_method = "4D0616B5A88718B8558E59C7943E57B4", hash_generated_method = "55D3F7CCDC2154502F3B7645C889554D")
        public boolean isFocused(Object info) {
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_589067196 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_589067196;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.689 -0400", hash_original_method = "3EB36752093CDD3C24048A6DFD7EC73D", hash_generated_method = "6D0538C18C9A5354B643240638C5D801")
        public boolean isLongClickable(Object info) {
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1108463077 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1108463077;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.690 -0400", hash_original_method = "CB922389EC3BD00D9BEE74A550F7293C", hash_generated_method = "7AE5B57E2AAD8358B8A241650255BA20")
        public boolean isPassword(Object info) {
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018305727 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018305727;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.691 -0400", hash_original_method = "0A24FC3E128A848006031E8724C7F0A9", hash_generated_method = "84CAC7A9F92144719B4D8C1E3C22842C")
        public boolean isScrollable(Object info) {
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_678492483 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_678492483;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.692 -0400", hash_original_method = "6AFAC3555346166234EF254615BCA05C", hash_generated_method = "E55A7276E77DA5C3624EB561E16B4C7B")
        public boolean isSelected(Object info) {
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1035606715 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1035606715;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.692 -0400", hash_original_method = "FCBED87974E8349E51CFE67F3FE8BAAB", hash_generated_method = "A7B3F8079000CF4136E5010FF0D71D6B")
        public boolean performAction(Object info, int action) {
            addTaint(info.getTaint());
            addTaint(action);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1625913460 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1625913460;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.693 -0400", hash_original_method = "6311EA40C38D5B6B34E9E1F7C3DBB879", hash_generated_method = "7EE4282E2B3D6586C8C091D99FF95514")
        public void setBoundsInParent(Object info, Rect bounds) {
            addTaint(info.getTaint());
            addTaint(bounds.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.694 -0400", hash_original_method = "D2C9C693466BA3A7E4B14036D2B17A5B", hash_generated_method = "F72C02E8694202EDC9223E9D8165B88C")
        public void setBoundsInScreen(Object info, Rect bounds) {
            addTaint(info.getTaint());
            addTaint(bounds.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.694 -0400", hash_original_method = "38431A6D5EE00E0099D8DB2DEFF6D601", hash_generated_method = "66435E452270DFFA96A0450DBFB076A5")
        public void setCheckable(Object info, boolean checkable) {
            addTaint(info.getTaint());
            addTaint(checkable);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.695 -0400", hash_original_method = "4FE562645B89F53A2E3F577D51BE4F8C", hash_generated_method = "5474022FA2A06A6926A3A486AC5C1759")
        public void setChecked(Object info, boolean checked) {
            addTaint(info.getTaint());
            addTaint(checked);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.696 -0400", hash_original_method = "82032763AB44B88BDF6C3C4AC2ABB1CF", hash_generated_method = "CE909B7962E87D7CE91B9D5DD9D50617")
        public void setClassName(Object info, CharSequence className) {
            addTaint(info.getTaint());
            addTaint(className.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.696 -0400", hash_original_method = "31E6103163DC809F9F67CE01A33EE87B", hash_generated_method = "73E2053F7EE3828C026454E9D057D059")
        public void setClickable(Object info, boolean clickable) {
            addTaint(info.getTaint());
            addTaint(clickable);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.699 -0400", hash_original_method = "B500330A66D743DBA7E460FD212D7744", hash_generated_method = "40079A9AB46FA419D2C90C877DB8FA5C")
        public void setContentDescription(Object info, CharSequence contentDescription) {
            addTaint(info.getTaint());
            addTaint(contentDescription.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.700 -0400", hash_original_method = "2E8A30481E49B666D7564B714DFA8A28", hash_generated_method = "5E3ABC794600DCEDDF98464597EF1BEF")
        public void setEnabled(Object info, boolean enabled) {
            addTaint(info.getTaint());
            addTaint(enabled);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.700 -0400", hash_original_method = "6FC489938507A8AC8A67E31F4C0F3485", hash_generated_method = "D51A913A278CDDEE0CCB9F2052B3AAD8")
        public void setFocusable(Object info, boolean focusable) {
            addTaint(info.getTaint());
            addTaint(focusable);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.701 -0400", hash_original_method = "D760A9B869FD1EE026AE8BC4B17036E8", hash_generated_method = "720799867957AAEA68CDACC51C53F22E")
        public void setFocused(Object info, boolean focused) {
            addTaint(info.getTaint());
            addTaint(focused);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.702 -0400", hash_original_method = "FD5EDA58E4935860A3097167F37FF25A", hash_generated_method = "1B43464C62B4E1AB3C24E13F70FECCB9")
        public void setLongClickable(Object info, boolean longClickable) {
            addTaint(info.getTaint());
            addTaint(longClickable);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.703 -0400", hash_original_method = "7ACCCA5C650FD61E0E741AE4759FF12D", hash_generated_method = "3669A231F87A87737EEDFEDAF1B9E8AE")
        public void setPackageName(Object info, CharSequence packageName) {
            addTaint(info.getTaint());
            addTaint(packageName.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.705 -0400", hash_original_method = "69043B1B7F4EB8EB9BDC8511E4B08BEE", hash_generated_method = "FA4D2D77EF97E64AEE2767B91ADEE103")
        public void setParent(Object info, View parent) {
            addTaint(info.getTaint());
            addTaint(parent.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.706 -0400", hash_original_method = "363672B9055A3FB9061F2E3103405704", hash_generated_method = "BFB83A096B1C8951C5498C6227069637")
        public void setPassword(Object info, boolean password) {
            addTaint(info.getTaint());
            addTaint(password);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.707 -0400", hash_original_method = "709C7E935F852B3F6266600FDF6B6337", hash_generated_method = "71D88D9695380615C56612971EF7E721")
        public void setScrollable(Object info, boolean scrollable) {
            addTaint(info.getTaint());
            addTaint(scrollable);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.707 -0400", hash_original_method = "3EF8627D1C0109EB2B6665EF94BA680A", hash_generated_method = "FC4762B9200DCE2134DD3697A420C690")
        public void setSelected(Object info, boolean selected) {
            addTaint(info.getTaint());
            addTaint(selected);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.708 -0400", hash_original_method = "483D361A53672C2015F284EB727D68EB", hash_generated_method = "09992CE7C4C424A440B98411E3B5CEBE")
        public void setSource(Object info, View source) {
            addTaint(info.getTaint());
            addTaint(source.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.708 -0400", hash_original_method = "A82131F0C1B3FA9CC52D0C37845C305A", hash_generated_method = "283AC88038E9BB39A0071C69DFF6DB3E")
        public void setText(Object info, CharSequence text) {
            addTaint(info.getTaint());
            addTaint(text.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.709 -0400", hash_original_method = "83070C3537D062E3CF530D85D02FB919", hash_generated_method = "9CA19930CBA17161800873D06B09C0C2")
        public void recycle(Object info) {
            addTaint(info.getTaint());
            
        }

        
    }


    
    static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.710 -0400", hash_original_method = "21FE378E79CF4BF2260F84D20D666AC8", hash_generated_method = "21FE378E79CF4BF2260F84D20D666AC8")
        public AccessibilityNodeInfoIcsImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.711 -0400", hash_original_method = "E5E40CEE71B96A750609FB525C810C40", hash_generated_method = "8927368BA017EA3E6E2017F3124A15E6")
        @Override
        public Object obtain() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1946136820 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1946136820 = AccessibilityNodeInfoCompatIcs.obtain();
            varB4EAC82CA7396A68D541C85D26508E83_1946136820.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1946136820;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.712 -0400", hash_original_method = "8DA77B182C4547DFE3D4092985103CE0", hash_generated_method = "0C36B084F504D945A76CD6C9AE2EBB6A")
        @Override
        public Object obtain(View source) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1707997052 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1707997052 = AccessibilityNodeInfoCompatIcs.obtain(source);
            addTaint(source.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1707997052.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1707997052;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.713 -0400", hash_original_method = "AAB3A8D4C437B198564587B92520BA15", hash_generated_method = "3E621BD0A87512524CD8F8DD76AB9A5D")
        @Override
        public Object obtain(Object info) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1041507289 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1041507289 = AccessibilityNodeInfoCompatIcs.obtain(info);
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1041507289.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1041507289;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.713 -0400", hash_original_method = "0A7E097CDAE39DDB6B86DB3C969CB42E", hash_generated_method = "D0421D6C553EEB44C139EB6CDB530985")
        @Override
        public void addAction(Object info, int action) {
            AccessibilityNodeInfoCompatIcs.addAction(info, action);
            addTaint(info.getTaint());
            addTaint(action);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.714 -0400", hash_original_method = "341A0CD277745082770A69C5D7681A5A", hash_generated_method = "444A5501108F0B3F25C5941E18E61637")
        @Override
        public void addChild(Object info, View child) {
            AccessibilityNodeInfoCompatIcs.addChild(info, child);
            addTaint(info.getTaint());
            addTaint(child.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.715 -0400", hash_original_method = "E451DF79B85F7C5360B2FFDA4305ECB9", hash_generated_method = "C11ECEC11D3FEE04E59933F575739316")
        @Override
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
            List<Object> varB4EAC82CA7396A68D541C85D26508E83_2104756853 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2104756853 = AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(info, text);
            addTaint(info.getTaint());
            addTaint(text.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2104756853.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2104756853;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.716 -0400", hash_original_method = "D17F96C78962590280138C187D4A4D01", hash_generated_method = "A73597BB51D10EA2D364A6FDDF9F9489")
        @Override
        public int getActions(Object info) {
            int varDCC597B04F02F1A4AFA1617034F8C02D_463918154 = (AccessibilityNodeInfoCompatIcs.getActions(info));
            addTaint(info.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621338630 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621338630;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.717 -0400", hash_original_method = "B26B5755D84A45820A9127024B317E2D", hash_generated_method = "4E6915C7F0264027DBD18F4533A5ACDA")
        @Override
        public void getBoundsInParent(Object info, Rect outBounds) {
            AccessibilityNodeInfoCompatIcs.getBoundsInParent(info, outBounds);
            addTaint(info.getTaint());
            addTaint(outBounds.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.717 -0400", hash_original_method = "B5FD542CD4348223D6FD8509002D9D1B", hash_generated_method = "7FC90567F044EE53CDADE613ABC1D03D")
        @Override
        public void getBoundsInScreen(Object info, Rect outBounds) {
            AccessibilityNodeInfoCompatIcs.getBoundsInScreen(info, outBounds);
            addTaint(info.getTaint());
            addTaint(outBounds.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.719 -0400", hash_original_method = "11896B02F65554BEE96755430EF5F8E2", hash_generated_method = "2D21B795B1CCC1B3A88AC4EEA8DF5840")
        @Override
        public AccessibilityNodeInfoCompat getChild(Object info, int index) {
            AccessibilityNodeInfoCompat varB4EAC82CA7396A68D541C85D26508E83_1345575532 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1345575532 = new AccessibilityNodeInfoCompat(IMPL.getChild(info, index));
            addTaint(info.getTaint());
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1345575532.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1345575532;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.719 -0400", hash_original_method = "1060851E4756FF33B64BCC78AB967D36", hash_generated_method = "EAE51527929C58F0B8CE6F28FFC3918C")
        @Override
        public int getChildCount(Object info) {
            int var47C7911F2431FB0DBB98FC25C5971DFE_973385921 = (AccessibilityNodeInfoCompatIcs.getChildCount(info));
            addTaint(info.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307615112 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307615112;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.720 -0400", hash_original_method = "001ED67ACCB05215E0C0C1269607FAAC", hash_generated_method = "A68499C2E32A05C12B032BD08D7774A2")
        @Override
        public CharSequence getClassName(Object info) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_413969730 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_413969730 = AccessibilityNodeInfoCompatIcs.getClassName(info);
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_413969730.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_413969730;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.721 -0400", hash_original_method = "49E68BE928284122DC1CE4D1F9B3E016", hash_generated_method = "6A0D172818003A186E68E25DEAE812F0")
        @Override
        public CharSequence getContentDescription(Object info) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1034355176 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1034355176 = AccessibilityNodeInfoCompatIcs.getContentDescription(info);
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1034355176.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1034355176;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.722 -0400", hash_original_method = "E8A4C3E3432029A8834D6142201B45ED", hash_generated_method = "9A72B192B89ADCEE2D4BA9A056C83EC2")
        @Override
        public CharSequence getPackageName(Object info) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_2117390567 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2117390567 = AccessibilityNodeInfoCompatIcs.getPackageName(info);
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2117390567.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2117390567;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.723 -0400", hash_original_method = "D663E14A044DAD7A809F789DAE716A60", hash_generated_method = "0E04BE531F2D3B44CD86C52CC6A6AAA6")
        @Override
        public AccessibilityNodeInfoCompat getParent(Object info) {
            AccessibilityNodeInfoCompat varB4EAC82CA7396A68D541C85D26508E83_583962712 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_583962712 = new AccessibilityNodeInfoCompat(IMPL.getParent(info));
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_583962712.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_583962712;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.724 -0400", hash_original_method = "E0898B972D5792ED49F6E082AA078009", hash_generated_method = "A5EFC459978205A3A6EC2EFEB71B0280")
        @Override
        public CharSequence getText(Object info) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_325612375 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_325612375 = AccessibilityNodeInfoCompatIcs.getText(info);
            addTaint(info.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_325612375.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_325612375;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.725 -0400", hash_original_method = "E3B5F3C7383213DB54B59D99B9C21DDF", hash_generated_method = "A408AFC8F3DE39ADEE222E9F430B74E4")
        @Override
        public int getWindowId(Object info) {
            int var64D55BFBBC2C040544708D7A23DCBA41_264163651 = (AccessibilityNodeInfoCompatIcs.getWindowId(info));
            addTaint(info.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259588426 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259588426;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.726 -0400", hash_original_method = "E86FBEBDF802FE51EE90043BABBDBD26", hash_generated_method = "976CB12945D4F08E7B1AF842542B0EC1")
        @Override
        public boolean isCheckable(Object info) {
            boolean varDECFA7CB7D979B2158E6D72B41054BA9_770496406 = (AccessibilityNodeInfoCompatIcs.isCheckable(info));
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69083348 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_69083348;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.727 -0400", hash_original_method = "100CB854A73833CFD79DA770C6A93054", hash_generated_method = "B75798591D29CBB013D06BC2A754E76D")
        @Override
        public boolean isChecked(Object info) {
            boolean varF438820878EDACAB0C8B6B8C80C32160_1190484968 = (AccessibilityNodeInfoCompatIcs.isChecked(info));
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_961505077 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_961505077;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.727 -0400", hash_original_method = "D3DFDB52B10ADA5E3C3F15A26FC7FBD7", hash_generated_method = "3936C0A6508D8D211252C2236ED7495C")
        @Override
        public boolean isClickable(Object info) {
            boolean var39AF046CD2A5F31025E0A8B5CD67C23E_1556272364 = (AccessibilityNodeInfoCompatIcs.isClickable(info));
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189289899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189289899;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.728 -0400", hash_original_method = "36209ADA0F5A959372A76079E2B78D93", hash_generated_method = "A38A0BA05B63B5A50CFB3F772B10C8A0")
        @Override
        public boolean isEnabled(Object info) {
            boolean var3A42DF6210A4AD46E5382D1C23B322CB_408342638 = (AccessibilityNodeInfoCompatIcs.isEnabled(info));
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_404097607 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_404097607;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.729 -0400", hash_original_method = "C6DC12553020499681AB366980A40B1F", hash_generated_method = "31DE9C6161FFE7C6E6868954DC4706AE")
        @Override
        public boolean isFocusable(Object info) {
            boolean var9392463D56C00F8CA4217DD24B9A76A7_1602140520 = (AccessibilityNodeInfoCompatIcs.isFocusable(info));
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595589036 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_595589036;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.730 -0400", hash_original_method = "3B18C47ECC5B4B3818BF155318346723", hash_generated_method = "AB72CB52FB318518B89BF2DAFD6F4CAB")
        @Override
        public boolean isFocused(Object info) {
            boolean var3269833E0D4456D462B6C297042EDB85_261326682 = (AccessibilityNodeInfoCompatIcs.isFocused(info));
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746780591 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746780591;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.731 -0400", hash_original_method = "0E74B77ABC4CEB867A986595A38161A2", hash_generated_method = "191B3C4973E8A01D1AE414D62D326B15")
        @Override
        public boolean isLongClickable(Object info) {
            boolean varFFB78E69CE33CC552B5362A5FE130B88_723558947 = (AccessibilityNodeInfoCompatIcs.isLongClickable(info));
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156459941 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156459941;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.731 -0400", hash_original_method = "B10B564B73623100875F088E9DD770C1", hash_generated_method = "9B4AC24E7B5AECE114F6015E69103ED8")
        @Override
        public boolean isPassword(Object info) {
            boolean varD532BB4E9CCAA4909CF6A7847E7A142A_1254985309 = (AccessibilityNodeInfoCompatIcs.isPassword(info));
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_356975619 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_356975619;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.732 -0400", hash_original_method = "27190DC49C8364B899CAE814D744FE8B", hash_generated_method = "297AEA87A081E32AC696709A7CB1E1E7")
        @Override
        public boolean isScrollable(Object info) {
            boolean var895A5D860BE379819F16681220A66E5D_51364095 = (AccessibilityNodeInfoCompatIcs.isScrollable(info));
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676217580 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676217580;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.733 -0400", hash_original_method = "A622640AC1F4DA88BF6801D78709518C", hash_generated_method = "A0CE6746FA704FDA142DA08E80E520DC")
        @Override
        public boolean isSelected(Object info) {
            boolean var24E73D63D557F01D8001DC3DE7C8C6D9_559668402 = (AccessibilityNodeInfoCompatIcs.isSelected(info));
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751799783 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751799783;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.734 -0400", hash_original_method = "9AD9C2656115753FB34BB6FBDDF94F3E", hash_generated_method = "E22D6860665DD37C8034F6F4A2D70632")
        @Override
        public boolean performAction(Object info, int action) {
            boolean varA07606F0058B8302AA9CEC6DBE6B2E2A_1533942389 = (AccessibilityNodeInfoCompatIcs.performAction(info, action));
            addTaint(info.getTaint());
            addTaint(action);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268360754 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_268360754;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.734 -0400", hash_original_method = "B83B9E944F82D8AD27FBEADECC6E7EF2", hash_generated_method = "C59DE9A5D3668DE5458FABB1DB7690D4")
        @Override
        public void setBoundsInParent(Object info, Rect bounds) {
            AccessibilityNodeInfoCompatIcs.setBoundsInParent(info, bounds);
            addTaint(info.getTaint());
            addTaint(bounds.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.735 -0400", hash_original_method = "AA193C796629869323B4C215F767EF10", hash_generated_method = "5CB2E4DE1294124989B5A9BFA0B0D544")
        @Override
        public void setBoundsInScreen(Object info, Rect bounds) {
            AccessibilityNodeInfoCompatIcs.setBoundsInScreen(info, bounds);
            addTaint(info.getTaint());
            addTaint(bounds.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.736 -0400", hash_original_method = "E50D3EA2B511910BFCFCC317E73F9BD4", hash_generated_method = "E40B91499D8B8BB25B3BCA41B18DB9FB")
        @Override
        public void setCheckable(Object info, boolean checkable) {
            AccessibilityNodeInfoCompatIcs.setCheckable(info, checkable);
            addTaint(info.getTaint());
            addTaint(checkable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.736 -0400", hash_original_method = "AC21400C52299765810DFE83F0ADACE8", hash_generated_method = "5624E9717F7D48DD0ABBD9D0FD098CE7")
        @Override
        public void setChecked(Object info, boolean checked) {
            AccessibilityNodeInfoCompatIcs.setChecked(info, checked);
            addTaint(info.getTaint());
            addTaint(checked);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.738 -0400", hash_original_method = "7A94FF987D45DDACFD0402C8FB7DDE97", hash_generated_method = "3F5A0A197B29C82F13CF1332BF16B981")
        @Override
        public void setClassName(Object info, CharSequence className) {
            AccessibilityNodeInfoCompatIcs.setClassName(info, className);
            addTaint(info.getTaint());
            addTaint(className.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.738 -0400", hash_original_method = "BB8527C09D9C6151F737E8B59EC0FCE8", hash_generated_method = "64C65CE27FB8B6D084610532620AB225")
        @Override
        public void setClickable(Object info, boolean clickable) {
            AccessibilityNodeInfoCompatIcs.setClickable(info, clickable);
            addTaint(info.getTaint());
            addTaint(clickable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.739 -0400", hash_original_method = "0169AC239075ED7B4C4FDF21404839A2", hash_generated_method = "58B3CA2CBF2A50D58290FF573702917B")
        @Override
        public void setContentDescription(Object info, CharSequence contentDescription) {
            AccessibilityNodeInfoCompatIcs.setContentDescription(info, contentDescription);
            addTaint(info.getTaint());
            addTaint(contentDescription.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.740 -0400", hash_original_method = "E3468D53BBC641A160F74004C61B3122", hash_generated_method = "12BA481C682C5EF9F2B6D5D9410A8ED0")
        @Override
        public void setEnabled(Object info, boolean enabled) {
            AccessibilityNodeInfoCompatIcs.setEnabled(info, enabled);
            addTaint(info.getTaint());
            addTaint(enabled);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.740 -0400", hash_original_method = "DF0F47AC0A3E9517E54BD77506E987C2", hash_generated_method = "17192C20A3D616CCC2DE0FEB30C87249")
        @Override
        public void setFocusable(Object info, boolean focusable) {
            AccessibilityNodeInfoCompatIcs.setFocusable(info, focusable);
            addTaint(info.getTaint());
            addTaint(focusable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.741 -0400", hash_original_method = "06FD2B381779CA5EC6EDBB576923A85B", hash_generated_method = "F769AF81302468D22862ED1142251722")
        @Override
        public void setFocused(Object info, boolean focused) {
            AccessibilityNodeInfoCompatIcs.setFocused(info, focused);
            addTaint(info.getTaint());
            addTaint(focused);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.742 -0400", hash_original_method = "C3AB7DB810B3043F9F52463A756847CD", hash_generated_method = "D2729E245CF475955272D96D2C828A13")
        @Override
        public void setLongClickable(Object info, boolean longClickable) {
            AccessibilityNodeInfoCompatIcs.setLongClickable(info, longClickable);
            addTaint(info.getTaint());
            addTaint(longClickable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.742 -0400", hash_original_method = "7DAB17659A9A31AE8995C1EE54CC3933", hash_generated_method = "9F75EA1771085FBF7F58928CDEB10E65")
        @Override
        public void setPackageName(Object info, CharSequence packageName) {
            AccessibilityNodeInfoCompatIcs.setPackageName(info, packageName);
            addTaint(info.getTaint());
            addTaint(packageName.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.743 -0400", hash_original_method = "DDE950F8FB9AD10FE97D3324E7FA0C0C", hash_generated_method = "ADA650B2C94AE250637CB02D3B421801")
        @Override
        public void setParent(Object info, View parent) {
            AccessibilityNodeInfoCompatIcs.setParent(info, parent);
            addTaint(info.getTaint());
            addTaint(parent.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.744 -0400", hash_original_method = "784E93A04B49626C38656FD7564AAD9D", hash_generated_method = "BF7310A5E4CCAE09A66333412FB872C2")
        @Override
        public void setPassword(Object info, boolean password) {
            AccessibilityNodeInfoCompatIcs.setPassword(info, password);
            addTaint(info.getTaint());
            addTaint(password);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.744 -0400", hash_original_method = "B5EF4CAA0C493D78F8DD003411B53892", hash_generated_method = "990C5C9ED1B0DB4E471C2650949F236A")
        @Override
        public void setScrollable(Object info, boolean scrollable) {
            AccessibilityNodeInfoCompatIcs.setScrollable(info, scrollable);
            addTaint(info.getTaint());
            addTaint(scrollable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.745 -0400", hash_original_method = "1A8DBC2AB955429552ADF95538A7CF85", hash_generated_method = "8DC78D4CAF42E7BA5619D75BEDB03644")
        @Override
        public void setSelected(Object info, boolean selected) {
            AccessibilityNodeInfoCompatIcs.setSelected(info, selected);
            addTaint(info.getTaint());
            addTaint(selected);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.746 -0400", hash_original_method = "F051415C170BC070EB1133EF8AE51280", hash_generated_method = "CCAFEBB4109A3D3DCDD018126148C5AF")
        @Override
        public void setSource(Object info, View source) {
            AccessibilityNodeInfoCompatIcs.setSource(info, source);
            addTaint(info.getTaint());
            addTaint(source.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.747 -0400", hash_original_method = "FF3C01EEB678F09ADF7342B2D20BBA32", hash_generated_method = "D221C4D137A8DB685C50E289A38ABD66")
        @Override
        public void setText(Object info, CharSequence text) {
            AccessibilityNodeInfoCompatIcs.setText(info, text);
            addTaint(info.getTaint());
            addTaint(text.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.748 -0400", hash_original_method = "4487949C2661410233FC93B0FC70F4AF", hash_generated_method = "36125B9314F738219CA7EBB561351C28")
        @Override
        public void recycle(Object info) {
            AccessibilityNodeInfoCompatIcs.recycle(info);
            addTaint(info.getTaint());
            
            
        }

        
    }


    
    static interface AccessibilityNodeInfoImpl {
        public Object obtain();
        public Object obtain(View source);
        public Object obtain(Object info);
        public void setSource(Object info, View source);
        public int getWindowId(Object info);
        public int getChildCount(Object info);
        public Object getChild(Object info, int index);
        public void addChild(Object info, View child);
        public int getActions(Object info);
        public void addAction(Object info, int action);
        public boolean performAction(Object info, int action);
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text);
        public Object getParent(Object info);
        public void setParent(Object info, View parent);
        public void getBoundsInParent(Object info, Rect outBounds);
        public void setBoundsInParent(Object info, Rect bounds);
        public void getBoundsInScreen(Object info, Rect outBounds);
        public void setBoundsInScreen(Object info, Rect bounds);
        public boolean isCheckable(Object info);
        public void setCheckable(Object info, boolean checkable);
        public boolean isChecked(Object info);
        public void setChecked(Object info, boolean checked);
        public boolean isFocusable(Object info);
        public void setFocusable(Object info, boolean focusable);
        public boolean isFocused(Object info);
        public void setFocused(Object info, boolean focused);
        public boolean isSelected(Object info);
        public void setSelected(Object info, boolean selected);
        public boolean isClickable(Object info);
        public void setClickable(Object info, boolean clickable);
        public boolean isLongClickable(Object info);
        public void setLongClickable(Object info, boolean longClickable);
        public boolean isEnabled(Object info);
        public void setEnabled(Object info, boolean enabled);
        public boolean isPassword(Object info);
        public void setPassword(Object info, boolean password);
        public boolean isScrollable(Object info);
        public void setScrollable(Object info, boolean scrollable);
        public CharSequence getPackageName(Object info);
        public void setPackageName(Object info, CharSequence packageName);
        public CharSequence getClassName(Object info);
        public void setClassName(Object info, CharSequence className);
        public CharSequence getText(Object info);
        public void setText(Object info, CharSequence text);
        public CharSequence getContentDescription(Object info);
        public void setContentDescription(Object info, CharSequence contentDescription);
        public void recycle(Object info);
    }
    
    static {
        if (Build.VERSION.SDK_INT >= 14) { 
            IMPL = new AccessibilityNodeInfoIcsImpl();
        } else {
            IMPL = new AccessibilityNodeInfoStubImpl();
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.749 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "97BD12C859C1DA2B5849DD1AFA547C72")

    private static AccessibilityNodeInfoImpl IMPL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.749 -0400", hash_original_field = "88C2D1887EB31B570369B487597D045B", hash_generated_field = "F5FAE335945DC9AAC45448FAE7461FBF")

    public static final int ACTION_FOCUS = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.749 -0400", hash_original_field = "1BA8A453AF0935765BB13E51D3B78770", hash_generated_field = "4E51052F791AAD7CED4606387206AC02")

    public static final int ACTION_CLEAR_FOCUS = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.750 -0400", hash_original_field = "1B92A207713BC68EA97823DAC23B10A2", hash_generated_field = "D94F4C12E9D93257353DF25CED690B59")

    public static final int ACTION_SELECT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.750 -0400", hash_original_field = "61076BF1E4699C26E8B0724E793847FD", hash_generated_field = "A07F23DA35D396F8F58D59EF3496C08F")

    public static final int ACTION_CLEAR_SELECTION = 0x00000008;
}

