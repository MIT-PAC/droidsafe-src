package android.support.v4.view.accessibility;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;





public class AccessibilityNodeInfoCompat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.899 -0400", hash_original_field = "1715FF63502BEC0E28C8D7CA89F0F72E", hash_generated_field = "EA545B797CAE6A5B712CE13E995894C9")

    private Object mInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.899 -0400", hash_original_method = "27EEB78B664A0859CE9D2482B14EDA44", hash_generated_method = "5D13B8B7945325E456070CD74C88BF1B")
    public  AccessibilityNodeInfoCompat(Object info) {
        mInfo = info;
        // ---------- Original Method ----------
        //mInfo = info;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.900 -0400", hash_original_method = "180B11831FF091AFD58918B491DA5734", hash_generated_method = "7BB8C73F5DD083C034742BE0BAA9456C")
    public Object getImpl() {
Object var3A968EAC93D51342CCDD9EFE8723F737_2060431345 =         mInfo;
        var3A968EAC93D51342CCDD9EFE8723F737_2060431345.addTaint(taint);
        return var3A968EAC93D51342CCDD9EFE8723F737_2060431345;
        // ---------- Original Method ----------
        //return mInfo;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.901 -0400", hash_original_method = "DBD6C4E567C7947922529BA45E2088C3", hash_generated_method = "96D1C979791CA51F586D42025B355A21")
    public void setSource(View source) {
        addTaint(source.getTaint());
        IMPL.setSource(mInfo, source);
        // ---------- Original Method ----------
        //IMPL.setSource(mInfo, source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.901 -0400", hash_original_method = "2FCD3C5691FCBE6EB393188032460842", hash_generated_method = "D6E9C9E94BF25F53E43D8C74506E0124")
    public int getWindowId() {
        int varA6542EF1E8520CFD8FA35E921B4733FA_1526373286 = (IMPL.getWindowId(mInfo));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051683506 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051683506;
        // ---------- Original Method ----------
        //return IMPL.getWindowId(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.901 -0400", hash_original_method = "2AD4C51D718899601C93A5649AD946AD", hash_generated_method = "9F2EA2F8A109EE2D9D923E1CFBC3FED3")
    public int getChildCount() {
        int var023CE45408957D180E638B192CAE01B2_599451533 = (IMPL.getChildCount(mInfo));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1795452177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1795452177;
        // ---------- Original Method ----------
        //return IMPL.getChildCount(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.902 -0400", hash_original_method = "8EA123998643A19BBF17F459FF07BE7E", hash_generated_method = "FAEC8BCDFECB8C38870B63A42CFBE9F5")
    public AccessibilityNodeInfoCompat getChild(int index) {
        addTaint(index);
AccessibilityNodeInfoCompat var2605D89E858102C2A1CCC621632F47F1_646659109 =         new AccessibilityNodeInfoCompat(IMPL.getChild(mInfo, index));
        var2605D89E858102C2A1CCC621632F47F1_646659109.addTaint(taint);
        return var2605D89E858102C2A1CCC621632F47F1_646659109;
        // ---------- Original Method ----------
        //return new AccessibilityNodeInfoCompat(IMPL.getChild(mInfo, index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.902 -0400", hash_original_method = "96991CF3D104F82AE28D15A837764722", hash_generated_method = "07698E1827C644ED9389ABC9B0153729")
    public void addChild(View child) {
        addTaint(child.getTaint());
        IMPL.addChild(mInfo, child);
        // ---------- Original Method ----------
        //IMPL.addChild(mInfo, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.902 -0400", hash_original_method = "933CE3223B5CD7F54D5F21B403DB8A7E", hash_generated_method = "834B2B82444D856219DA6B34C455361E")
    public int getActions() {
        int var8569F370D1382923E0B8563F43031884_146959774 = (IMPL.getActions(mInfo));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772094985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772094985;
        // ---------- Original Method ----------
        //return IMPL.getActions(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.903 -0400", hash_original_method = "F620D8EC3817B6EC64D02A805E40B2B4", hash_generated_method = "F3C7E4538858F00931E35733583E9BF6")
    public void addAction(int action) {
        addTaint(action);
        IMPL.addAction(mInfo, action);
        // ---------- Original Method ----------
        //IMPL.addAction(mInfo, action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.903 -0400", hash_original_method = "76F70B64C56F7E2DCA168B652A090370", hash_generated_method = "BA37160B8A9AE9FEA0AA24AB6DDA4E90")
    public boolean performAction(int action) {
        addTaint(action);
        boolean var390DBE2902D20317D8BAAE03F4F21A62_1534270220 = (IMPL.performAction(mInfo, action));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_342145118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_342145118;
        // ---------- Original Method ----------
        //return IMPL.performAction(mInfo, action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.904 -0400", hash_original_method = "D972868A6ABA9BEE83DE29ABCCDE4A4C", hash_generated_method = "F260FBF47FFF6042F7A67631962DAD44")
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String text) {
        addTaint(text.getTaint());
        List<AccessibilityNodeInfoCompat> result = new ArrayList<AccessibilityNodeInfoCompat>();
        List<Object> infos = IMPL.findAccessibilityNodeInfosByText(mInfo, text);
        final int infoCount = infos.size();
for(int i = 0;i < infoCount;i++)
        {
            Object info = infos.get(i);
            result.add(new AccessibilityNodeInfoCompat(info));
        } //End block
List<AccessibilityNodeInfoCompat> varDC838461EE2FA0CA4C9BBB70A15456B0_1223923643 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1223923643.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1223923643;
        // ---------- Original Method ----------
        //List<AccessibilityNodeInfoCompat> result = new ArrayList<AccessibilityNodeInfoCompat>();
        //List<Object> infos = IMPL.findAccessibilityNodeInfosByText(mInfo, text);
        //final int infoCount = infos.size();
        //for (int i = 0; i < infoCount; i++) {
            //Object info = infos.get(i);
            //result.add(new AccessibilityNodeInfoCompat(info));
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.904 -0400", hash_original_method = "2E852E0313CFFDFAD47286627DB8F00F", hash_generated_method = "D466F589D238657189A84C3BFFFB473C")
    public AccessibilityNodeInfoCompat getParent() {
AccessibilityNodeInfoCompat var3A7512F2201A458C8A653FFCCAFC5906_953283302 =         new AccessibilityNodeInfoCompat(IMPL.getParent(mInfo));
        var3A7512F2201A458C8A653FFCCAFC5906_953283302.addTaint(taint);
        return var3A7512F2201A458C8A653FFCCAFC5906_953283302;
        // ---------- Original Method ----------
        //return new AccessibilityNodeInfoCompat(IMPL.getParent(mInfo));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.904 -0400", hash_original_method = "86518FC5D5AE3E2BA199BEEAA088933F", hash_generated_method = "A9925D1A891853762BFC2FE37B3FA328")
    public void setParent(View parent) {
        addTaint(parent.getTaint());
        IMPL.setParent(mInfo, parent);
        // ---------- Original Method ----------
        //IMPL.setParent(mInfo, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.904 -0400", hash_original_method = "E0ACD239D05CD134F4788FDE11AB973D", hash_generated_method = "7CC874153C050630804412E683E7E62F")
    public void getBoundsInParent(Rect outBounds) {
        addTaint(outBounds.getTaint());
        IMPL.getBoundsInParent(mInfo, outBounds);
        // ---------- Original Method ----------
        //IMPL.getBoundsInParent(mInfo, outBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.905 -0400", hash_original_method = "3D18F1D3A722CB931F3C0EA8FCAAFCB7", hash_generated_method = "09906DCD9F8705DB8E3FB8E8173228E4")
    public void setBoundsInParent(Rect bounds) {
        addTaint(bounds.getTaint());
        IMPL.setBoundsInParent(mInfo, bounds);
        // ---------- Original Method ----------
        //IMPL.setBoundsInParent(mInfo, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.905 -0400", hash_original_method = "603EEE18F9883128AEF640A26C131D4C", hash_generated_method = "6DBA668FEEB42A1CB1BE32712AED4D73")
    public void getBoundsInScreen(Rect outBounds) {
        addTaint(outBounds.getTaint());
        IMPL.getBoundsInScreen(mInfo, outBounds);
        // ---------- Original Method ----------
        //IMPL.getBoundsInScreen(mInfo, outBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.905 -0400", hash_original_method = "59EABEF98A7E138E1AB24AE8A708DBC4", hash_generated_method = "31129F3B6257CD60F48D9A97CFCCF6D4")
    public void setBoundsInScreen(Rect bounds) {
        addTaint(bounds.getTaint());
        IMPL.setBoundsInParent(mInfo, bounds);
        // ---------- Original Method ----------
        //IMPL.setBoundsInParent(mInfo, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.906 -0400", hash_original_method = "AC8D43F54DC3BA7E7C149D4503D525F3", hash_generated_method = "71853747A865B3792ED65ED5E93DD4C8")
    public boolean isCheckable() {
        boolean var685F4011AF6E4D2986BDCC68720B0399_895198588 = (IMPL.isCheckable(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588157606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588157606;
        // ---------- Original Method ----------
        //return IMPL.isCheckable(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.906 -0400", hash_original_method = "02532B45DC391F52A2535027893C38AD", hash_generated_method = "C7B38FFBB8FC14ADA2271A87AC1361F0")
    public void setCheckable(boolean checkable) {
        addTaint(checkable);
        IMPL.setCheckable(mInfo, checkable);
        // ---------- Original Method ----------
        //IMPL.setCheckable(mInfo, checkable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.907 -0400", hash_original_method = "519FEB307C383A2CCF5C74B89068518B", hash_generated_method = "8DD5C87E849AFA9F3C84D1A1AD660211")
    public boolean isChecked() {
        boolean var33F9D569DBB4402543C1779FBB014D50_1102730527 = (IMPL.isChecked(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_694057368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_694057368;
        // ---------- Original Method ----------
        //return IMPL.isChecked(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.907 -0400", hash_original_method = "FAB30364812370D4A3BF52C70FA75BB2", hash_generated_method = "23BAF728D1F14A1222F1C6EC59F5FC5F")
    public void setChecked(boolean checked) {
        addTaint(checked);
        IMPL.setChecked(mInfo, checked);
        // ---------- Original Method ----------
        //IMPL.setChecked(mInfo, checked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.908 -0400", hash_original_method = "C9FC8F868000F9B33292AD780E66DCA0", hash_generated_method = "BCA84CAC9CDE5B0AF845C4DE5A712B80")
    public boolean isFocusable() {
        boolean var3BB37A0698B8505BC22CF5C6D88C0EEB_18913854 = (IMPL.isFocusable(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1793042783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1793042783;
        // ---------- Original Method ----------
        //return IMPL.isFocusable(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.909 -0400", hash_original_method = "FBAE0F38121F1E86CBC8B993867A4A27", hash_generated_method = "33CD65E82A144246B95AABB47A4ADA51")
    public void setFocusable(boolean focusable) {
        addTaint(focusable);
        IMPL.setFocusable(mInfo, focusable);
        // ---------- Original Method ----------
        //IMPL.setFocusable(mInfo, focusable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.909 -0400", hash_original_method = "4F186107AF4B40F30B1A87108529D484", hash_generated_method = "7E9B8608BC3DF204DB6481129A7008B9")
    public boolean isFocused() {
        boolean var00711EF416F1BA8A3800587F0BAC689D_988166458 = (IMPL.isFocused(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683597024 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683597024;
        // ---------- Original Method ----------
        //return IMPL.isFocused(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.910 -0400", hash_original_method = "9869A69DD9422BD72F2EA6EC374F4934", hash_generated_method = "95B8577E8A942DD29AEEEFE5D7237F7B")
    public void setFocused(boolean focused) {
        addTaint(focused);
        IMPL.setFocused(mInfo, focused);
        // ---------- Original Method ----------
        //IMPL.setFocused(mInfo, focused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.910 -0400", hash_original_method = "DDA60D7434111992259669E63D890C29", hash_generated_method = "51508CD6FA505574A818CC5843036373")
    public boolean isSelected() {
        boolean varE100557C9239498F7159ABAB0035E995_1669036655 = (IMPL.isSelected(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_621306201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_621306201;
        // ---------- Original Method ----------
        //return IMPL.isSelected(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.910 -0400", hash_original_method = "CCBAF3645335D86B821DEAC9BDDB4ED2", hash_generated_method = "9BC7205A9389E43E5F8805EE6DF68AF9")
    public void setSelected(boolean selected) {
        addTaint(selected);
        IMPL.setSelected(mInfo, selected);
        // ---------- Original Method ----------
        //IMPL.setSelected(mInfo, selected);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.910 -0400", hash_original_method = "6F39B6C0009288DFEA1A8807AE028922", hash_generated_method = "6FF93CFA699687A78D4D0BF59A9BDDC5")
    public boolean isClickable() {
        boolean var50B5B2E08A22B3AD29A9E7E355DB395A_323919475 = (IMPL.isClickable(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245578811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245578811;
        // ---------- Original Method ----------
        //return IMPL.isClickable(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.911 -0400", hash_original_method = "CBF9AA1E7F6DA4EEE21EFD519E970C6E", hash_generated_method = "EACEF5087FD082FDE8C7968E38B86C7A")
    public void setClickable(boolean clickable) {
        addTaint(clickable);
        IMPL.setClickable(mInfo, clickable);
        // ---------- Original Method ----------
        //IMPL.setClickable(mInfo, clickable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.911 -0400", hash_original_method = "2A0651AA24697C87D5B10A2F592D15AE", hash_generated_method = "ECC36E7ADE05CFD140310E4821068DA1")
    public boolean isLongClickable() {
        boolean varF4EAA6F4997241DF13A848FDABDE2DE3_1843014490 = (IMPL.isLongClickable(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815569525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815569525;
        // ---------- Original Method ----------
        //return IMPL.isLongClickable(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.911 -0400", hash_original_method = "C41DB90B24D967665ADB7BE195D933F7", hash_generated_method = "27E416E65DAA2E3D4144E2260D86D7E7")
    public void setLongClickable(boolean longClickable) {
        addTaint(longClickable);
        IMPL.setLongClickable(mInfo, longClickable);
        // ---------- Original Method ----------
        //IMPL.setLongClickable(mInfo, longClickable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.911 -0400", hash_original_method = "652E5B5F063CB50BC77186FF37F33BDF", hash_generated_method = "A7829AD92A96295FB446AA4096E4CBD8")
    public boolean isEnabled() {
        boolean var51B48439FD11F5F658E2CBFAF91AFAA8_1518422621 = (IMPL.isEnabled(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98228139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98228139;
        // ---------- Original Method ----------
        //return IMPL.isEnabled(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.911 -0400", hash_original_method = "38B56F1A12BFB4B4EFFD2BC2116AF996", hash_generated_method = "21DA0CFFDB4C804D5A4A91108CBD7CD7")
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        IMPL.setEnabled(mInfo, enabled);
        // ---------- Original Method ----------
        //IMPL.setEnabled(mInfo, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.911 -0400", hash_original_method = "65A99E085FF9E307AFC93D67B83055DB", hash_generated_method = "87DC269012931A13C1A5C1F338B3120A")
    public boolean isPassword() {
        boolean var5B3CA3EE69541E38082AD0239B1B6074_62510698 = (IMPL.isPassword(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983269749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983269749;
        // ---------- Original Method ----------
        //return IMPL.isPassword(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.911 -0400", hash_original_method = "B97A25B40B977908B12069641BAB55A8", hash_generated_method = "2824D3EBA03E41186B592DB1A76A6B96")
    public void setPassword(boolean password) {
        addTaint(password);
        IMPL.setPassword(mInfo, password);
        // ---------- Original Method ----------
        //IMPL.setPassword(mInfo, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.911 -0400", hash_original_method = "C7AAD2830522B8BD5949276001A4D042", hash_generated_method = "A5804360C86798CF4A3467002ABEB2DE")
    public boolean isScrollable() {
        boolean var386B817CD3380B6278D51C5463FC5279_430815435 = (IMPL.isScrollable(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075645415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075645415;
        // ---------- Original Method ----------
        //return IMPL.isScrollable(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.911 -0400", hash_original_method = "EF0CC581E7F7F261AFF7A1550C16EBCA", hash_generated_method = "DE592F606AC5C3DFA486E36F4A7214E0")
    public void setScrollable(boolean scrollable) {
        addTaint(scrollable);
        IMPL.setScrollable(mInfo, scrollable);
        // ---------- Original Method ----------
        //IMPL.setScrollable(mInfo, scrollable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.911 -0400", hash_original_method = "11DA2F2F6D35A0A5BD4D3AD5855546F2", hash_generated_method = "22A549EC8E14067C9086883B3883CCB2")
    public CharSequence getPackageName() {
CharSequence varE0B20734E37C2B46025E4F8131365FD2_1713273493 =         IMPL.getPackageName(mInfo);
        varE0B20734E37C2B46025E4F8131365FD2_1713273493.addTaint(taint);
        return varE0B20734E37C2B46025E4F8131365FD2_1713273493;
        // ---------- Original Method ----------
        //return IMPL.getPackageName(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.912 -0400", hash_original_method = "51BDE657C455C3947A276CD4621D88BF", hash_generated_method = "9A61E15B94A65BC44A91F487A5663A1A")
    public void setPackageName(CharSequence packageName) {
        addTaint(packageName.getTaint());
        IMPL.setPackageName(mInfo, packageName);
        // ---------- Original Method ----------
        //IMPL.setPackageName(mInfo, packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.912 -0400", hash_original_method = "80725931141339E528C95BCDFA69AC67", hash_generated_method = "5A2BA13E66E497D76E1549A61BCBCD07")
    public CharSequence getClassName() {
CharSequence var13976FE2411926A27FCB8E00EEE7AAD4_432317811 =         IMPL.getClassName(mInfo);
        var13976FE2411926A27FCB8E00EEE7AAD4_432317811.addTaint(taint);
        return var13976FE2411926A27FCB8E00EEE7AAD4_432317811;
        // ---------- Original Method ----------
        //return IMPL.getClassName(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.912 -0400", hash_original_method = "95DBB6C9D00CCAE01AE6EC9F7D77613E", hash_generated_method = "F66BE18B952BCADB658E7C23182022A4")
    public void setClassName(CharSequence className) {
        addTaint(className.getTaint());
        IMPL.setClassName(mInfo, className);
        // ---------- Original Method ----------
        //IMPL.setClassName(mInfo, className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.912 -0400", hash_original_method = "384621808EBD921F20A6EB28B91ADAD5", hash_generated_method = "C158BFB466793188729FDD8820F27DA8")
    public CharSequence getText() {
CharSequence var1DF1200F05671DF9D4AB0C5F6C8DAAA4_626847862 =         IMPL.getText(mInfo);
        var1DF1200F05671DF9D4AB0C5F6C8DAAA4_626847862.addTaint(taint);
        return var1DF1200F05671DF9D4AB0C5F6C8DAAA4_626847862;
        // ---------- Original Method ----------
        //return IMPL.getText(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.912 -0400", hash_original_method = "CCE84BD471DC2DB3AF81C568CF944475", hash_generated_method = "6443F8BA015BAFA56BE9E33E21F5D8E5")
    public void setText(CharSequence text) {
        addTaint(text.getTaint());
        IMPL.setText(mInfo, text);
        // ---------- Original Method ----------
        //IMPL.setText(mInfo, text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.912 -0400", hash_original_method = "17A5AE651613EAEE40274E28D0DBF3CB", hash_generated_method = "18DCD58EBDD6A233371A7649A0F96367")
    public CharSequence getContentDescription() {
CharSequence varC4BA732E0BE0020738370211FB549BA9_221820327 =         IMPL.getContentDescription(mInfo);
        varC4BA732E0BE0020738370211FB549BA9_221820327.addTaint(taint);
        return varC4BA732E0BE0020738370211FB549BA9_221820327;
        // ---------- Original Method ----------
        //return IMPL.getContentDescription(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.912 -0400", hash_original_method = "0581568FD089D03E78C8C673EC290A8E", hash_generated_method = "9B7BD8E2BC21A367B4D01A839E39FDB6")
    public void setContentDescription(CharSequence contentDescription) {
        addTaint(contentDescription.getTaint());
        IMPL.setContentDescription(mInfo, contentDescription);
        // ---------- Original Method ----------
        //IMPL.setContentDescription(mInfo, contentDescription);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.912 -0400", hash_original_method = "4012C2A77CF6E1C54F1B4372AFDF8962", hash_generated_method = "C65940CB1FE55E31C8C8CA907DBC92D5")
    public void recycle() {
        IMPL.recycle(mInfo);
        // ---------- Original Method ----------
        //IMPL.recycle(mInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.912 -0400", hash_original_method = "3D44C3AC54A391BB7EEFE6DCE99834D5", hash_generated_method = "5C61BEB110CEA2E10C908BA81B926027")
    @Override
    public int hashCode() {
        int var625C9F3E5BE1C6E8EA2CEBDE7561D065_2097581976 = ((mInfo == null) ? 0 : mInfo.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119665132 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119665132;
        // ---------- Original Method ----------
        //return (mInfo == null) ? 0 : mInfo.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.913 -0400", hash_original_method = "9F360410AD288A74DD17C77A13BAB054", hash_generated_method = "41CA14B05DE42EC79F5FCA6891D462EE")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(this == obj)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1939781463 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510874604 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_510874604;
        } //End block
        if(obj == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1206958100 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807803962 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_807803962;
        } //End block
        if(getClass() != obj.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1513043913 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57383357 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_57383357;
        } //End block
        AccessibilityNodeInfoCompat other = (AccessibilityNodeInfoCompat) obj;
        if(mInfo == null)        
        {
            if(other.mInfo != null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1715389481 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_287297776 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_287297776;
            } //End block
        } //End block
        else
        if(!mInfo.equals(other.mInfo))        
        {
            boolean var68934A3E9455FA72420237EB05902327_715054587 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938180279 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_938180279;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_822773925 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182058033 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182058033;
        // ---------- Original Method ----------
        //if (this == obj) {
            //return true;
        //}
        //if (obj == null) {
            //return false;
        //}
        //if (getClass() != obj.getClass()) {
            //return false;
        //}
        //AccessibilityNodeInfoCompat other = (AccessibilityNodeInfoCompat) obj;
        //if (mInfo == null) {
            //if (other.mInfo != null) {
                //return false;
            //}
        //} else if (!mInfo.equals(other.mInfo)) {
            //return false;
        //}
        //return true;
    }

    
    static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.913 -0400", hash_original_method = "D9A4AFBF5AD5A775B6C1281730E5BA11", hash_generated_method = "D9A4AFBF5AD5A775B6C1281730E5BA11")
        public AccessibilityNodeInfoStubImpl ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.913 -0400", hash_original_method = "817FD8D623FDA4524F619AFC293F09EC", hash_generated_method = "C22676B56DF071A7F5CF6788FE18A34A")
        public Object obtain() {
Object var540C13E9E156B687226421B24F2DF178_1040934607 =             null;
            var540C13E9E156B687226421B24F2DF178_1040934607.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1040934607;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.913 -0400", hash_original_method = "92695667FFAB3FACD22606EFAA0A43BA", hash_generated_method = "428FCD4EBF9849DCA7C7BCB5941DCB1D")
        public Object obtain(View source) {
            addTaint(source.getTaint());
Object var540C13E9E156B687226421B24F2DF178_1468704625 =             null;
            var540C13E9E156B687226421B24F2DF178_1468704625.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1468704625;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.914 -0400", hash_original_method = "773588C99ADE780DBDFC19514017BC1F", hash_generated_method = "1C42FB8843EC80E28B12893B8DDA3996")
        public Object obtain(Object info) {
            addTaint(info.getTaint());
Object var540C13E9E156B687226421B24F2DF178_1360766167 =             null;
            var540C13E9E156B687226421B24F2DF178_1360766167.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1360766167;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.914 -0400", hash_original_method = "8D71C6A90F236F7F17CE9F0DA3BE99D2", hash_generated_method = "5F00060CAB9B4B2566E623D909A28FE0")
        public void addAction(Object info, int action) {
            addTaint(action);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.914 -0400", hash_original_method = "6B9372E604C01DF70F526B6A8E570148", hash_generated_method = "46FE01FA0CFC681CC6BB779E2143207C")
        public void addChild(Object info, View child) {
            addTaint(child.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.914 -0400", hash_original_method = "DDFBD7F537083E060F4196E4CBB1F004", hash_generated_method = "223906D14B1366CB768D5585282A9374")
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
            addTaint(text.getTaint());
            addTaint(info.getTaint());
List<Object> varB803AB532741AA7D5C2F301CCDDD25F2_1989815313 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_1989815313.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_1989815313;
            // ---------- Original Method ----------
            //return Collections.emptyList();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.914 -0400", hash_original_method = "62879C9A6873AFA1FE78492502C9E8C1", hash_generated_method = "6731D5282942741D23214A873AEAEEB0")
        public int getActions(Object info) {
            addTaint(info.getTaint());
            int varCFCD208495D565EF66E7DFF9F98764DA_945072697 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_781183492 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_781183492;
            // ---------- Original Method ----------
            //return 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.914 -0400", hash_original_method = "194BB4DCA6CDD611708C0DBE13AE8AE6", hash_generated_method = "3C000B93FEEBF5C47B18A21222CC810A")
        public void getBoundsInParent(Object info, Rect outBounds) {
            addTaint(outBounds.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.914 -0400", hash_original_method = "AD025A7E801C16406D0F86CAFA041F7F", hash_generated_method = "5D8984E8D4D82D8FAB88F2396774FB3D")
        public void getBoundsInScreen(Object info, Rect outBounds) {
            addTaint(outBounds.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.914 -0400", hash_original_method = "3EFC24789BAB789DBA02244C19291A8A", hash_generated_method = "40C84CF3785E094D813BFD5A6A73E381")
        public Object getChild(Object info, int index) {
            addTaint(index);
            addTaint(info.getTaint());
Object var540C13E9E156B687226421B24F2DF178_84511909 =             null;
            var540C13E9E156B687226421B24F2DF178_84511909.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_84511909;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.915 -0400", hash_original_method = "DE0573752D5D98EE2B44C4024F5102E5", hash_generated_method = "120A3C333C23C0A79C298CDF028C1E14")
        public int getChildCount(Object info) {
            addTaint(info.getTaint());
            int varCFCD208495D565EF66E7DFF9F98764DA_1296444467 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651125123 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651125123;
            // ---------- Original Method ----------
            //return 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.915 -0400", hash_original_method = "0F7CFAB631E1B134DCF395A7797DAF67", hash_generated_method = "332F58C34E004BAF0E3F0DC1446D5AA0")
        public CharSequence getClassName(Object info) {
            addTaint(info.getTaint());
CharSequence var540C13E9E156B687226421B24F2DF178_464677271 =             null;
            var540C13E9E156B687226421B24F2DF178_464677271.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_464677271;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.915 -0400", hash_original_method = "7D3E1748FD6A5B3BAF1D83AAF2AE15DE", hash_generated_method = "A651D94E331335FDD31E75DBE6324B99")
        public CharSequence getContentDescription(Object info) {
            addTaint(info.getTaint());
CharSequence var540C13E9E156B687226421B24F2DF178_2004204139 =             null;
            var540C13E9E156B687226421B24F2DF178_2004204139.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2004204139;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.915 -0400", hash_original_method = "D7A11002847EF3E5746055DA2B429105", hash_generated_method = "6DDDD691E35DDFC43AD4965A0F8F4580")
        public CharSequence getPackageName(Object info) {
            addTaint(info.getTaint());
CharSequence var540C13E9E156B687226421B24F2DF178_846134427 =             null;
            var540C13E9E156B687226421B24F2DF178_846134427.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_846134427;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.915 -0400", hash_original_method = "6E57EFC15A3C835051BC240D78A056B3", hash_generated_method = "06C29B35230D9C2A03DFFAA30C2BEE21")
        public AccessibilityNodeInfoCompat getParent(Object info) {
            addTaint(info.getTaint());
AccessibilityNodeInfoCompat var540C13E9E156B687226421B24F2DF178_217224083 =             null;
            var540C13E9E156B687226421B24F2DF178_217224083.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_217224083;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.915 -0400", hash_original_method = "CA1AE5519AB49B9F955ADEDF9C3C214E", hash_generated_method = "FB4F453C70EEE90213D81EC91DAC7AE9")
        public CharSequence getText(Object info) {
            addTaint(info.getTaint());
CharSequence var540C13E9E156B687226421B24F2DF178_426406822 =             null;
            var540C13E9E156B687226421B24F2DF178_426406822.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_426406822;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.915 -0400", hash_original_method = "EB7D2054B13C972973DD67D9B21CE0E5", hash_generated_method = "C439079EA6F598B0EB54F5E0F5A049EE")
        public int getWindowId(Object info) {
            addTaint(info.getTaint());
            int varCFCD208495D565EF66E7DFF9F98764DA_1240209974 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111491701 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111491701;
            // ---------- Original Method ----------
            //return 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.915 -0400", hash_original_method = "4E39FE68FD90D69FA08C7AD1E979DF07", hash_generated_method = "2A56A0AA92FC00F555760CE938255496")
        public boolean isCheckable(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_653285470 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984624090 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_984624090;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.915 -0400", hash_original_method = "F2469434A89FA62BE9B2DB78034140F5", hash_generated_method = "8D6F77D4078679E1957182F1511A57C6")
        public boolean isChecked(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1687903031 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197183923 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197183923;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.916 -0400", hash_original_method = "F7781A93E107315385A57825C2B0B78A", hash_generated_method = "2B9E68459C4444FAB3A60ED42976F0D6")
        public boolean isClickable(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_733561169 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587694012 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_587694012;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.916 -0400", hash_original_method = "6BAAC3777342DFE283E965C06FC8D874", hash_generated_method = "482153F30448AD98BFB27ACC5FE1B1B9")
        public boolean isEnabled(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1314570303 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_508961167 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_508961167;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.916 -0400", hash_original_method = "24826F7A102BA4F82C9D9B08241E284F", hash_generated_method = "92BFC06E77DCD654545C86AAE1ED03F3")
        public boolean isFocusable(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_399290581 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_629163545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_629163545;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.916 -0400", hash_original_method = "4D0616B5A88718B8558E59C7943E57B4", hash_generated_method = "0DA42201F4880A5D7F2404FCC348284C")
        public boolean isFocused(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_135245669 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114256132 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_114256132;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.916 -0400", hash_original_method = "3EB36752093CDD3C24048A6DFD7EC73D", hash_generated_method = "C070550102AC2B76E95846A89BCD4429")
        public boolean isLongClickable(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1024372960 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1408047017 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1408047017;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.916 -0400", hash_original_method = "CB922389EC3BD00D9BEE74A550F7293C", hash_generated_method = "561284904FF2C75228EF3BD396F91EC1")
        public boolean isPassword(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1120051209 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335428126 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335428126;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.916 -0400", hash_original_method = "0A24FC3E128A848006031E8724C7F0A9", hash_generated_method = "8E167448D81CC77907E83E4ECAB9775E")
        public boolean isScrollable(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_121108552 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_637836720 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_637836720;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.916 -0400", hash_original_method = "6AFAC3555346166234EF254615BCA05C", hash_generated_method = "AA9E9F5D23AA924F53DE6D02EC5B2566")
        public boolean isSelected(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1322036354 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036356663 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036356663;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.916 -0400", hash_original_method = "FCBED87974E8349E51CFE67F3FE8BAAB", hash_generated_method = "FC8B27D1EF41A3F95092F7CA96F51474")
        public boolean performAction(Object info, int action) {
            addTaint(action);
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_225874550 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_243141773 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_243141773;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.917 -0400", hash_original_method = "6311EA40C38D5B6B34E9E1F7C3DBB879", hash_generated_method = "C7F581AF90B338E0925C62A3024C6F67")
        public void setBoundsInParent(Object info, Rect bounds) {
            addTaint(bounds.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.917 -0400", hash_original_method = "D2C9C693466BA3A7E4B14036D2B17A5B", hash_generated_method = "E05AFA6EA9AAF9FB0ECD646B93254DD9")
        public void setBoundsInScreen(Object info, Rect bounds) {
            addTaint(bounds.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.917 -0400", hash_original_method = "38431A6D5EE00E0099D8DB2DEFF6D601", hash_generated_method = "804DCE913D9E6070F8E550B71AD22B80")
        public void setCheckable(Object info, boolean checkable) {
            addTaint(checkable);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.918 -0400", hash_original_method = "4FE562645B89F53A2E3F577D51BE4F8C", hash_generated_method = "4543C14DB341621D93F6F2621D639CFB")
        public void setChecked(Object info, boolean checked) {
            addTaint(checked);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.918 -0400", hash_original_method = "82032763AB44B88BDF6C3C4AC2ABB1CF", hash_generated_method = "161EF9CD79B216300D2AF4B61D1E4F45")
        public void setClassName(Object info, CharSequence className) {
            addTaint(className.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.918 -0400", hash_original_method = "31E6103163DC809F9F67CE01A33EE87B", hash_generated_method = "D519D0F39A07EEB0AEEBA5E5875F6150")
        public void setClickable(Object info, boolean clickable) {
            addTaint(clickable);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.918 -0400", hash_original_method = "B500330A66D743DBA7E460FD212D7744", hash_generated_method = "27D40B14BF3DEDB56AAB9AECA05C82A0")
        public void setContentDescription(Object info, CharSequence contentDescription) {
            addTaint(contentDescription.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.918 -0400", hash_original_method = "2E8A30481E49B666D7564B714DFA8A28", hash_generated_method = "CA3CFCFE549F59FC75A446D5BCE0A521")
        public void setEnabled(Object info, boolean enabled) {
            addTaint(enabled);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.918 -0400", hash_original_method = "6FC489938507A8AC8A67E31F4C0F3485", hash_generated_method = "BD5881FAC223E930D2E2E37E44B33C3C")
        public void setFocusable(Object info, boolean focusable) {
            addTaint(focusable);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.918 -0400", hash_original_method = "D760A9B869FD1EE026AE8BC4B17036E8", hash_generated_method = "14E41B822435BE880FB3392798601F91")
        public void setFocused(Object info, boolean focused) {
            addTaint(focused);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.918 -0400", hash_original_method = "FD5EDA58E4935860A3097167F37FF25A", hash_generated_method = "3DDF3ED1B3E0FC0801A2CBFA37667157")
        public void setLongClickable(Object info, boolean longClickable) {
            addTaint(longClickable);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.918 -0400", hash_original_method = "7ACCCA5C650FD61E0E741AE4759FF12D", hash_generated_method = "3D2CB84EBAF7AE0D0E07B4791BF148D9")
        public void setPackageName(Object info, CharSequence packageName) {
            addTaint(packageName.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.919 -0400", hash_original_method = "69043B1B7F4EB8EB9BDC8511E4B08BEE", hash_generated_method = "4A942148EB5C52DD6E700A02688275C9")
        public void setParent(Object info, View parent) {
            addTaint(parent.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.919 -0400", hash_original_method = "363672B9055A3FB9061F2E3103405704", hash_generated_method = "B195B3F20A419F8DC07BEA2D24B96A97")
        public void setPassword(Object info, boolean password) {
            addTaint(password);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.919 -0400", hash_original_method = "709C7E935F852B3F6266600FDF6B6337", hash_generated_method = "DE0FD2B7B59EB7B909C49C4E237BDD07")
        public void setScrollable(Object info, boolean scrollable) {
            addTaint(scrollable);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.919 -0400", hash_original_method = "3EF8627D1C0109EB2B6665EF94BA680A", hash_generated_method = "8F344D2BAB0B685E1E5931897D28D77F")
        public void setSelected(Object info, boolean selected) {
            addTaint(selected);
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.919 -0400", hash_original_method = "483D361A53672C2015F284EB727D68EB", hash_generated_method = "6E7CE2F4361113870428E586C12141BF")
        public void setSource(Object info, View source) {
            addTaint(source.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.919 -0400", hash_original_method = "A82131F0C1B3FA9CC52D0C37845C305A", hash_generated_method = "A869718C721ADA1CBF5B40E6DCF8AA00")
        public void setText(Object info, CharSequence text) {
            addTaint(text.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.919 -0400", hash_original_method = "83070C3537D062E3CF530D85D02FB919", hash_generated_method = "9CA19930CBA17161800873D06B09C0C2")
        public void recycle(Object info) {
            addTaint(info.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.920 -0400", hash_original_method = "21FE378E79CF4BF2260F84D20D666AC8", hash_generated_method = "21FE378E79CF4BF2260F84D20D666AC8")
        public AccessibilityNodeInfoIcsImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.920 -0400", hash_original_method = "E5E40CEE71B96A750609FB525C810C40", hash_generated_method = "7960978FB42BBD1908203CDE0C055919")
        @Override
        public Object obtain() {
Object var18E616ED4124E416419712D8A33E1555_1112526389 =             AccessibilityNodeInfoCompatIcs.obtain();
            var18E616ED4124E416419712D8A33E1555_1112526389.addTaint(taint);
            return var18E616ED4124E416419712D8A33E1555_1112526389;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.obtain();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.920 -0400", hash_original_method = "8DA77B182C4547DFE3D4092985103CE0", hash_generated_method = "EA6109307244898B3F025B1BE915F854")
        @Override
        public Object obtain(View source) {
            addTaint(source.getTaint());
Object var72AFDB1E0D71CABB69ABFDF218476CD8_1631993890 =             AccessibilityNodeInfoCompatIcs.obtain(source);
            var72AFDB1E0D71CABB69ABFDF218476CD8_1631993890.addTaint(taint);
            return var72AFDB1E0D71CABB69ABFDF218476CD8_1631993890;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.obtain(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.920 -0400", hash_original_method = "AAB3A8D4C437B198564587B92520BA15", hash_generated_method = "417D3329750DA46E7F3E3BE11E1B2FCA")
        @Override
        public Object obtain(Object info) {
            addTaint(info.getTaint());
Object var9655CD537A169570B739BF9CC4952AF2_803820218 =             AccessibilityNodeInfoCompatIcs.obtain(info);
            var9655CD537A169570B739BF9CC4952AF2_803820218.addTaint(taint);
            return var9655CD537A169570B739BF9CC4952AF2_803820218;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.obtain(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.920 -0400", hash_original_method = "0A7E097CDAE39DDB6B86DB3C969CB42E", hash_generated_method = "4265DEC8A88EB69AFE7E14F7A6FA9844")
        @Override
        public void addAction(Object info, int action) {
            addTaint(action);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.addAction(info, action);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.addAction(info, action);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.920 -0400", hash_original_method = "341A0CD277745082770A69C5D7681A5A", hash_generated_method = "1D68C7EFD3CEF96931E1517562A1DA7F")
        @Override
        public void addChild(Object info, View child) {
            addTaint(child.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.addChild(info, child);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.addChild(info, child);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.920 -0400", hash_original_method = "E451DF79B85F7C5360B2FFDA4305ECB9", hash_generated_method = "D10942A00E25272914BF8D6EDF38C28F")
        @Override
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
            addTaint(text.getTaint());
            addTaint(info.getTaint());
List<Object> var8DC6DAB02BA4C7815AC89010EB33D0AD_1129306425 =             AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(info, text);
            var8DC6DAB02BA4C7815AC89010EB33D0AD_1129306425.addTaint(taint);
            return var8DC6DAB02BA4C7815AC89010EB33D0AD_1129306425;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(info, text);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.920 -0400", hash_original_method = "D17F96C78962590280138C187D4A4D01", hash_generated_method = "0715547C5FE75D0606683B1C108047E0")
        @Override
        public int getActions(Object info) {
            addTaint(info.getTaint());
            int varE1C5C8F3250A60420574AB5876C073E0_1403990300 = (AccessibilityNodeInfoCompatIcs.getActions(info));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439061894 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439061894;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.getActions(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.921 -0400", hash_original_method = "B26B5755D84A45820A9127024B317E2D", hash_generated_method = "8A979AA8B478E449ED6DCD3881A07425")
        @Override
        public void getBoundsInParent(Object info, Rect outBounds) {
            addTaint(outBounds.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.getBoundsInParent(info, outBounds);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.getBoundsInParent(info, outBounds);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.921 -0400", hash_original_method = "B5FD542CD4348223D6FD8509002D9D1B", hash_generated_method = "5B1CF93FA477C47F230F9FF0DF0F5A19")
        @Override
        public void getBoundsInScreen(Object info, Rect outBounds) {
            addTaint(outBounds.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.getBoundsInScreen(info, outBounds);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.getBoundsInScreen(info, outBounds);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.921 -0400", hash_original_method = "11896B02F65554BEE96755430EF5F8E2", hash_generated_method = "DCF98ED7630E2080390A60B596845E12")
        @Override
        public AccessibilityNodeInfoCompat getChild(Object info, int index) {
            addTaint(index);
            addTaint(info.getTaint());
AccessibilityNodeInfoCompat varC082D3DF38BC3C4721A24C567F2203D9_74743173 =             new AccessibilityNodeInfoCompat(IMPL.getChild(info, index));
            varC082D3DF38BC3C4721A24C567F2203D9_74743173.addTaint(taint);
            return varC082D3DF38BC3C4721A24C567F2203D9_74743173;
            // ---------- Original Method ----------
            //return new AccessibilityNodeInfoCompat(IMPL.getChild(info, index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.921 -0400", hash_original_method = "1060851E4756FF33B64BCC78AB967D36", hash_generated_method = "1F3A543185BD223D374D92DAF5839E2B")
        @Override
        public int getChildCount(Object info) {
            addTaint(info.getTaint());
            int var453D2111E45109D707554F829D387FC3_1453200138 = (AccessibilityNodeInfoCompatIcs.getChildCount(info));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226904314 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226904314;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.getChildCount(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.921 -0400", hash_original_method = "001ED67ACCB05215E0C0C1269607FAAC", hash_generated_method = "EA7D2EEFBFF99FB6796FE8591D18320D")
        @Override
        public CharSequence getClassName(Object info) {
            addTaint(info.getTaint());
CharSequence varC282983408C091643715DAD53F515590_848367529 =             AccessibilityNodeInfoCompatIcs.getClassName(info);
            varC282983408C091643715DAD53F515590_848367529.addTaint(taint);
            return varC282983408C091643715DAD53F515590_848367529;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.getClassName(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.921 -0400", hash_original_method = "49E68BE928284122DC1CE4D1F9B3E016", hash_generated_method = "5E7956FEF7889F46332A5E8E5EA60818")
        @Override
        public CharSequence getContentDescription(Object info) {
            addTaint(info.getTaint());
CharSequence var32F5476EEDF6FF1279E269184BC4EEF0_820935326 =             AccessibilityNodeInfoCompatIcs.getContentDescription(info);
            var32F5476EEDF6FF1279E269184BC4EEF0_820935326.addTaint(taint);
            return var32F5476EEDF6FF1279E269184BC4EEF0_820935326;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.getContentDescription(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.921 -0400", hash_original_method = "E8A4C3E3432029A8834D6142201B45ED", hash_generated_method = "A6F40BBC5464B16C80F03490DFD4BAE8")
        @Override
        public CharSequence getPackageName(Object info) {
            addTaint(info.getTaint());
CharSequence var25E39EB6D9B13CC71DEE96F6E8413836_560614857 =             AccessibilityNodeInfoCompatIcs.getPackageName(info);
            var25E39EB6D9B13CC71DEE96F6E8413836_560614857.addTaint(taint);
            return var25E39EB6D9B13CC71DEE96F6E8413836_560614857;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.getPackageName(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.921 -0400", hash_original_method = "D663E14A044DAD7A809F789DAE716A60", hash_generated_method = "BC2E600CE20CFC154A9990D02B7BC2DE")
        @Override
        public AccessibilityNodeInfoCompat getParent(Object info) {
            addTaint(info.getTaint());
AccessibilityNodeInfoCompat var7941D4894D6ACA970D05A94330CFE6E2_1453628228 =             new AccessibilityNodeInfoCompat(IMPL.getParent(info));
            var7941D4894D6ACA970D05A94330CFE6E2_1453628228.addTaint(taint);
            return var7941D4894D6ACA970D05A94330CFE6E2_1453628228;
            // ---------- Original Method ----------
            //return new AccessibilityNodeInfoCompat(IMPL.getParent(info));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.921 -0400", hash_original_method = "E0898B972D5792ED49F6E082AA078009", hash_generated_method = "60D688ED4B8778F72176F4ADB3E775F9")
        @Override
        public CharSequence getText(Object info) {
            addTaint(info.getTaint());
CharSequence varC39EDBF46B20FFFBE67EBDDAFFAF4404_1052541694 =             AccessibilityNodeInfoCompatIcs.getText(info);
            varC39EDBF46B20FFFBE67EBDDAFFAF4404_1052541694.addTaint(taint);
            return varC39EDBF46B20FFFBE67EBDDAFFAF4404_1052541694;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.getText(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.921 -0400", hash_original_method = "E3B5F3C7383213DB54B59D99B9C21DDF", hash_generated_method = "F9924F7CA2A445A4AF565C7CB35E2C76")
        @Override
        public int getWindowId(Object info) {
            addTaint(info.getTaint());
            int var7E755BE734029BAEE15574E279891519_2027115381 = (AccessibilityNodeInfoCompatIcs.getWindowId(info));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2002278447 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2002278447;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.getWindowId(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.922 -0400", hash_original_method = "E86FBEBDF802FE51EE90043BABBDBD26", hash_generated_method = "E9722525BBB6844C6E4B6604A56D115A")
        @Override
        public boolean isCheckable(Object info) {
            addTaint(info.getTaint());
            boolean var6EBF9497CE9D8DB73C60338542DEE7A0_1878821180 = (AccessibilityNodeInfoCompatIcs.isCheckable(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079501210 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079501210;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.isCheckable(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.922 -0400", hash_original_method = "100CB854A73833CFD79DA770C6A93054", hash_generated_method = "CDB3FE8C925EC4A20B94F4B14B9869CD")
        @Override
        public boolean isChecked(Object info) {
            addTaint(info.getTaint());
            boolean var5FE936E046D67E017ADAFED3989D8217_7724802 = (AccessibilityNodeInfoCompatIcs.isChecked(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813287248 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_813287248;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.isChecked(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.922 -0400", hash_original_method = "D3DFDB52B10ADA5E3C3F15A26FC7FBD7", hash_generated_method = "C2CEC0498727EE6AA49883ED7A330C65")
        @Override
        public boolean isClickable(Object info) {
            addTaint(info.getTaint());
            boolean var7F39A5797EB1A99D99E2343C7CAE7411_1713906126 = (AccessibilityNodeInfoCompatIcs.isClickable(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1502796019 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1502796019;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.isClickable(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.922 -0400", hash_original_method = "36209ADA0F5A959372A76079E2B78D93", hash_generated_method = "4A1EAC85B115F15725F69ECAD36214E3")
        @Override
        public boolean isEnabled(Object info) {
            addTaint(info.getTaint());
            boolean var882EA9E175AFA2A78B164B1A1EDAA334_1520275482 = (AccessibilityNodeInfoCompatIcs.isEnabled(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054988454 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054988454;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.isEnabled(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.922 -0400", hash_original_method = "C6DC12553020499681AB366980A40B1F", hash_generated_method = "0586EB72F60DFD83B8099E49F018CEAC")
        @Override
        public boolean isFocusable(Object info) {
            addTaint(info.getTaint());
            boolean varF205ED058EE2032775A632B9C55F0576_215525486 = (AccessibilityNodeInfoCompatIcs.isFocusable(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117218863 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117218863;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.isFocusable(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.923 -0400", hash_original_method = "3B18C47ECC5B4B3818BF155318346723", hash_generated_method = "BA35A0D63A9CCE3D6398A9764BE80A5D")
        @Override
        public boolean isFocused(Object info) {
            addTaint(info.getTaint());
            boolean var968A4F44201F839E9BD8A149DDC95B50_1888852285 = (AccessibilityNodeInfoCompatIcs.isFocused(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1291084763 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1291084763;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.isFocused(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.923 -0400", hash_original_method = "0E74B77ABC4CEB867A986595A38161A2", hash_generated_method = "4688C112A0800B4A7E30770D15B54015")
        @Override
        public boolean isLongClickable(Object info) {
            addTaint(info.getTaint());
            boolean var7FD4110AC14E635626C3442A1C47C6C0_1319509304 = (AccessibilityNodeInfoCompatIcs.isLongClickable(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1128296848 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1128296848;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.isLongClickable(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.923 -0400", hash_original_method = "B10B564B73623100875F088E9DD770C1", hash_generated_method = "9668F6DF02FBCD3F4A33EFC9E43E3513")
        @Override
        public boolean isPassword(Object info) {
            addTaint(info.getTaint());
            boolean var591107E717E8BE76738CDD50302FB72E_1384467756 = (AccessibilityNodeInfoCompatIcs.isPassword(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647006876 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_647006876;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.isPassword(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.923 -0400", hash_original_method = "27190DC49C8364B899CAE814D744FE8B", hash_generated_method = "6A26808D427DBF5EF1951B707B84DA49")
        @Override
        public boolean isScrollable(Object info) {
            addTaint(info.getTaint());
            boolean var0DBA0213B6D1A14FBEE7922D4AE5EFDB_494730980 = (AccessibilityNodeInfoCompatIcs.isScrollable(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_868909699 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_868909699;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.isScrollable(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.924 -0400", hash_original_method = "A622640AC1F4DA88BF6801D78709518C", hash_generated_method = "9C92F06A5103FCD74B20B3B5CD9A13F1")
        @Override
        public boolean isSelected(Object info) {
            addTaint(info.getTaint());
            boolean var64D15A97240D47FE0C8EC2B678FEEE31_1964899666 = (AccessibilityNodeInfoCompatIcs.isSelected(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18524684 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_18524684;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.isSelected(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.924 -0400", hash_original_method = "9AD9C2656115753FB34BB6FBDDF94F3E", hash_generated_method = "FB64B4CFA31C37936CD837B1EC23E15D")
        @Override
        public boolean performAction(Object info, int action) {
            addTaint(action);
            addTaint(info.getTaint());
            boolean varF9AF688EECBFC4106C6E922E0F041AEF_1102985263 = (AccessibilityNodeInfoCompatIcs.performAction(info, action));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1204537717 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1204537717;
            // ---------- Original Method ----------
            //return AccessibilityNodeInfoCompatIcs.performAction(info, action);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.924 -0400", hash_original_method = "B83B9E944F82D8AD27FBEADECC6E7EF2", hash_generated_method = "B5DB3E00269FD3E90A39F18B1B246286")
        @Override
        public void setBoundsInParent(Object info, Rect bounds) {
            addTaint(bounds.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setBoundsInParent(info, bounds);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setBoundsInParent(info, bounds);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.924 -0400", hash_original_method = "AA193C796629869323B4C215F767EF10", hash_generated_method = "272EDD93017BFDCA6BC9F9B69976FE38")
        @Override
        public void setBoundsInScreen(Object info, Rect bounds) {
            addTaint(bounds.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setBoundsInScreen(info, bounds);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setBoundsInScreen(info, bounds);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.925 -0400", hash_original_method = "E50D3EA2B511910BFCFCC317E73F9BD4", hash_generated_method = "C0FD246CF600A12AFC819660661B5557")
        @Override
        public void setCheckable(Object info, boolean checkable) {
            addTaint(checkable);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setCheckable(info, checkable);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setCheckable(info, checkable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.925 -0400", hash_original_method = "AC21400C52299765810DFE83F0ADACE8", hash_generated_method = "769CDD4B596A3EC9CAA2C40838E5A7B8")
        @Override
        public void setChecked(Object info, boolean checked) {
            addTaint(checked);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setChecked(info, checked);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setChecked(info, checked);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.925 -0400", hash_original_method = "7A94FF987D45DDACFD0402C8FB7DDE97", hash_generated_method = "5845EEBEDABF97F8D2A7AB51F28E54EC")
        @Override
        public void setClassName(Object info, CharSequence className) {
            addTaint(className.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setClassName(info, className);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setClassName(info, className);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.926 -0400", hash_original_method = "BB8527C09D9C6151F737E8B59EC0FCE8", hash_generated_method = "1E377FC61F83E3E5C15A80672A862C99")
        @Override
        public void setClickable(Object info, boolean clickable) {
            addTaint(clickable);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setClickable(info, clickable);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setClickable(info, clickable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.926 -0400", hash_original_method = "0169AC239075ED7B4C4FDF21404839A2", hash_generated_method = "DA3622123B77CD2E451C413D9BB4143B")
        @Override
        public void setContentDescription(Object info, CharSequence contentDescription) {
            addTaint(contentDescription.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setContentDescription(info, contentDescription);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setContentDescription(info, contentDescription);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.926 -0400", hash_original_method = "E3468D53BBC641A160F74004C61B3122", hash_generated_method = "EE6F5DA7CC7016A40B21D7C83D70A756")
        @Override
        public void setEnabled(Object info, boolean enabled) {
            addTaint(enabled);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setEnabled(info, enabled);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setEnabled(info, enabled);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.926 -0400", hash_original_method = "DF0F47AC0A3E9517E54BD77506E987C2", hash_generated_method = "295C8D89291147AAA9AEC4F4540EBFFF")
        @Override
        public void setFocusable(Object info, boolean focusable) {
            addTaint(focusable);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setFocusable(info, focusable);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setFocusable(info, focusable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.927 -0400", hash_original_method = "06FD2B381779CA5EC6EDBB576923A85B", hash_generated_method = "51DAF5E6FFCA5AFCC41CE4DF37F5875C")
        @Override
        public void setFocused(Object info, boolean focused) {
            addTaint(focused);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setFocused(info, focused);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setFocused(info, focused);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.927 -0400", hash_original_method = "C3AB7DB810B3043F9F52463A756847CD", hash_generated_method = "971690CB8D25CAF7394EF34846FC720D")
        @Override
        public void setLongClickable(Object info, boolean longClickable) {
            addTaint(longClickable);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setLongClickable(info, longClickable);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setLongClickable(info, longClickable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.927 -0400", hash_original_method = "7DAB17659A9A31AE8995C1EE54CC3933", hash_generated_method = "45B00EE74F0171DC54A79C1B0D835A91")
        @Override
        public void setPackageName(Object info, CharSequence packageName) {
            addTaint(packageName.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setPackageName(info, packageName);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setPackageName(info, packageName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.927 -0400", hash_original_method = "DDE950F8FB9AD10FE97D3324E7FA0C0C", hash_generated_method = "5004BA1E4773E52DAE97853A1F12618E")
        @Override
        public void setParent(Object info, View parent) {
            addTaint(parent.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setParent(info, parent);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setParent(info, parent);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.927 -0400", hash_original_method = "784E93A04B49626C38656FD7564AAD9D", hash_generated_method = "F0B8EBC78DDDAD293AAF066CB748C7B9")
        @Override
        public void setPassword(Object info, boolean password) {
            addTaint(password);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setPassword(info, password);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setPassword(info, password);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.928 -0400", hash_original_method = "B5EF4CAA0C493D78F8DD003411B53892", hash_generated_method = "93DC401C378BC231B855E47C29332094")
        @Override
        public void setScrollable(Object info, boolean scrollable) {
            addTaint(scrollable);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setScrollable(info, scrollable);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setScrollable(info, scrollable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.928 -0400", hash_original_method = "1A8DBC2AB955429552ADF95538A7CF85", hash_generated_method = "23DE6E65C107A64E981959F9E092DEFC")
        @Override
        public void setSelected(Object info, boolean selected) {
            addTaint(selected);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setSelected(info, selected);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setSelected(info, selected);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.928 -0400", hash_original_method = "F051415C170BC070EB1133EF8AE51280", hash_generated_method = "894BFD92FBB49740E2F99E521E5152B1")
        @Override
        public void setSource(Object info, View source) {
            addTaint(source.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setSource(info, source);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setSource(info, source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.932 -0400", hash_original_method = "FF3C01EEB678F09ADF7342B2D20BBA32", hash_generated_method = "151286B39A90F1E88BEDCF5ECAEA65FA")
        @Override
        public void setText(Object info, CharSequence text) {
            addTaint(text.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setText(info, text);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.setText(info, text);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.933 -0400", hash_original_method = "4487949C2661410233FC93B0FC70F4AF", hash_generated_method = "AAD645FF065F336CE08995545206834C")
        @Override
        public void recycle(Object info) {
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.recycle(info);
            // ---------- Original Method ----------
            //AccessibilityNodeInfoCompatIcs.recycle(info);
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.933 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "97BD12C859C1DA2B5849DD1AFA547C72")

    private static AccessibilityNodeInfoImpl IMPL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.933 -0400", hash_original_field = "88C2D1887EB31B570369B487597D045B", hash_generated_field = "F5FAE335945DC9AAC45448FAE7461FBF")

    public static final int ACTION_FOCUS = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.933 -0400", hash_original_field = "1BA8A453AF0935765BB13E51D3B78770", hash_generated_field = "4E51052F791AAD7CED4606387206AC02")

    public static final int ACTION_CLEAR_FOCUS = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.933 -0400", hash_original_field = "1B92A207713BC68EA97823DAC23B10A2", hash_generated_field = "D94F4C12E9D93257353DF25CED690B59")

    public static final int ACTION_SELECT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.933 -0400", hash_original_field = "61076BF1E4699C26E8B0724E793847FD", hash_generated_field = "A07F23DA35D396F8F58D59EF3496C08F")

    public static final int ACTION_CLEAR_SELECTION = 0x00000008;
}

