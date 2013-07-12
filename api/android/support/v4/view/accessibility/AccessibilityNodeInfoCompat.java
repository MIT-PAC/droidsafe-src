package android.support.v4.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessibilityNodeInfoCompat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.427 -0400", hash_original_field = "1715FF63502BEC0E28C8D7CA89F0F72E", hash_generated_field = "EA545B797CAE6A5B712CE13E995894C9")

    private Object mInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.427 -0400", hash_original_method = "27EEB78B664A0859CE9D2482B14EDA44", hash_generated_method = "5D13B8B7945325E456070CD74C88BF1B")
    public  AccessibilityNodeInfoCompat(Object info) {
        mInfo = info;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.427 -0400", hash_original_method = "180B11831FF091AFD58918B491DA5734", hash_generated_method = "0D80E28D842867A1C78BBB09740F1F89")
    public Object getImpl() {
Object var3A968EAC93D51342CCDD9EFE8723F737_432726549 =         mInfo;
        var3A968EAC93D51342CCDD9EFE8723F737_432726549.addTaint(taint);
        return var3A968EAC93D51342CCDD9EFE8723F737_432726549;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.428 -0400", hash_original_method = "DBD6C4E567C7947922529BA45E2088C3", hash_generated_method = "96D1C979791CA51F586D42025B355A21")
    public void setSource(View source) {
        addTaint(source.getTaint());
        IMPL.setSource(mInfo, source);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.428 -0400", hash_original_method = "2FCD3C5691FCBE6EB393188032460842", hash_generated_method = "1C3F3A725421D760BA0641A1C6468B06")
    public int getWindowId() {
        int varA6542EF1E8520CFD8FA35E921B4733FA_956217164 = (IMPL.getWindowId(mInfo));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868804489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868804489;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.428 -0400", hash_original_method = "2AD4C51D718899601C93A5649AD946AD", hash_generated_method = "34BB3A8F5AD88F109A70A13F68F692D9")
    public int getChildCount() {
        int var023CE45408957D180E638B192CAE01B2_1572839966 = (IMPL.getChildCount(mInfo));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535407912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535407912;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.428 -0400", hash_original_method = "8EA123998643A19BBF17F459FF07BE7E", hash_generated_method = "5834310D2E2050C2005C6FB432F71A3E")
    public AccessibilityNodeInfoCompat getChild(int index) {
        addTaint(index);
AccessibilityNodeInfoCompat var2605D89E858102C2A1CCC621632F47F1_1193371344 =         new AccessibilityNodeInfoCompat(IMPL.getChild(mInfo, index));
        var2605D89E858102C2A1CCC621632F47F1_1193371344.addTaint(taint);
        return var2605D89E858102C2A1CCC621632F47F1_1193371344;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.428 -0400", hash_original_method = "96991CF3D104F82AE28D15A837764722", hash_generated_method = "07698E1827C644ED9389ABC9B0153729")
    public void addChild(View child) {
        addTaint(child.getTaint());
        IMPL.addChild(mInfo, child);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.428 -0400", hash_original_method = "933CE3223B5CD7F54D5F21B403DB8A7E", hash_generated_method = "51E580CB4FDE0F692B2FE9FC468E16F5")
    public int getActions() {
        int var8569F370D1382923E0B8563F43031884_703096837 = (IMPL.getActions(mInfo));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431151661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431151661;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.428 -0400", hash_original_method = "F620D8EC3817B6EC64D02A805E40B2B4", hash_generated_method = "F3C7E4538858F00931E35733583E9BF6")
    public void addAction(int action) {
        addTaint(action);
        IMPL.addAction(mInfo, action);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.428 -0400", hash_original_method = "76F70B64C56F7E2DCA168B652A090370", hash_generated_method = "878C54AF9083180B22140C0445D8C2A1")
    public boolean performAction(int action) {
        addTaint(action);
        boolean var390DBE2902D20317D8BAAE03F4F21A62_560081173 = (IMPL.performAction(mInfo, action));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216695789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216695789;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.429 -0400", hash_original_method = "D972868A6ABA9BEE83DE29ABCCDE4A4C", hash_generated_method = "F36F843FFF3BFD2E1B29168E9E8D192A")
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String text) {
        addTaint(text.getTaint());
        List<AccessibilityNodeInfoCompat> result = new ArrayList<AccessibilityNodeInfoCompat>();
        List<Object> infos = IMPL.findAccessibilityNodeInfosByText(mInfo, text);
        final int infoCount = infos.size();
for(int i = 0;i < infoCount;i++)
        {
            Object info = infos.get(i);
            result.add(new AccessibilityNodeInfoCompat(info));
        } 
List<AccessibilityNodeInfoCompat> varDC838461EE2FA0CA4C9BBB70A15456B0_1236820076 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1236820076.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1236820076;
        
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.429 -0400", hash_original_method = "2E852E0313CFFDFAD47286627DB8F00F", hash_generated_method = "0C0EA6D3378DF59E8336AB25DD673C44")
    public AccessibilityNodeInfoCompat getParent() {
AccessibilityNodeInfoCompat var3A7512F2201A458C8A653FFCCAFC5906_1119747503 =         new AccessibilityNodeInfoCompat(IMPL.getParent(mInfo));
        var3A7512F2201A458C8A653FFCCAFC5906_1119747503.addTaint(taint);
        return var3A7512F2201A458C8A653FFCCAFC5906_1119747503;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.429 -0400", hash_original_method = "86518FC5D5AE3E2BA199BEEAA088933F", hash_generated_method = "A9925D1A891853762BFC2FE37B3FA328")
    public void setParent(View parent) {
        addTaint(parent.getTaint());
        IMPL.setParent(mInfo, parent);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.429 -0400", hash_original_method = "E0ACD239D05CD134F4788FDE11AB973D", hash_generated_method = "7CC874153C050630804412E683E7E62F")
    public void getBoundsInParent(Rect outBounds) {
        addTaint(outBounds.getTaint());
        IMPL.getBoundsInParent(mInfo, outBounds);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.429 -0400", hash_original_method = "3D18F1D3A722CB931F3C0EA8FCAAFCB7", hash_generated_method = "09906DCD9F8705DB8E3FB8E8173228E4")
    public void setBoundsInParent(Rect bounds) {
        addTaint(bounds.getTaint());
        IMPL.setBoundsInParent(mInfo, bounds);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.429 -0400", hash_original_method = "603EEE18F9883128AEF640A26C131D4C", hash_generated_method = "6DBA668FEEB42A1CB1BE32712AED4D73")
    public void getBoundsInScreen(Rect outBounds) {
        addTaint(outBounds.getTaint());
        IMPL.getBoundsInScreen(mInfo, outBounds);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.429 -0400", hash_original_method = "59EABEF98A7E138E1AB24AE8A708DBC4", hash_generated_method = "31129F3B6257CD60F48D9A97CFCCF6D4")
    public void setBoundsInScreen(Rect bounds) {
        addTaint(bounds.getTaint());
        IMPL.setBoundsInParent(mInfo, bounds);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.429 -0400", hash_original_method = "AC8D43F54DC3BA7E7C149D4503D525F3", hash_generated_method = "ED8B12519BEDF595EEF12C0AC561BAD0")
    public boolean isCheckable() {
        boolean var685F4011AF6E4D2986BDCC68720B0399_1655170794 = (IMPL.isCheckable(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399576290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399576290;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.429 -0400", hash_original_method = "02532B45DC391F52A2535027893C38AD", hash_generated_method = "C7B38FFBB8FC14ADA2271A87AC1361F0")
    public void setCheckable(boolean checkable) {
        addTaint(checkable);
        IMPL.setCheckable(mInfo, checkable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "519FEB307C383A2CCF5C74B89068518B", hash_generated_method = "6E82EC4DB4D1EA822451026DDD8716CE")
    public boolean isChecked() {
        boolean var33F9D569DBB4402543C1779FBB014D50_493997062 = (IMPL.isChecked(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1305018691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1305018691;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "FAB30364812370D4A3BF52C70FA75BB2", hash_generated_method = "23BAF728D1F14A1222F1C6EC59F5FC5F")
    public void setChecked(boolean checked) {
        addTaint(checked);
        IMPL.setChecked(mInfo, checked);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "C9FC8F868000F9B33292AD780E66DCA0", hash_generated_method = "64EC303EA03903DD5ACD1D09FB2F6119")
    public boolean isFocusable() {
        boolean var3BB37A0698B8505BC22CF5C6D88C0EEB_1657496669 = (IMPL.isFocusable(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_996431503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_996431503;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "FBAE0F38121F1E86CBC8B993867A4A27", hash_generated_method = "33CD65E82A144246B95AABB47A4ADA51")
    public void setFocusable(boolean focusable) {
        addTaint(focusable);
        IMPL.setFocusable(mInfo, focusable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "4F186107AF4B40F30B1A87108529D484", hash_generated_method = "2EA6E1C0EE86F99C160853AFDB46A720")
    public boolean isFocused() {
        boolean var00711EF416F1BA8A3800587F0BAC689D_1339865852 = (IMPL.isFocused(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898647230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_898647230;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "9869A69DD9422BD72F2EA6EC374F4934", hash_generated_method = "95B8577E8A942DD29AEEEFE5D7237F7B")
    public void setFocused(boolean focused) {
        addTaint(focused);
        IMPL.setFocused(mInfo, focused);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "DDA60D7434111992259669E63D890C29", hash_generated_method = "BB5C6500A71D3D492A3144E82D9F3B83")
    public boolean isSelected() {
        boolean varE100557C9239498F7159ABAB0035E995_940130348 = (IMPL.isSelected(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015286202 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015286202;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "CCBAF3645335D86B821DEAC9BDDB4ED2", hash_generated_method = "9BC7205A9389E43E5F8805EE6DF68AF9")
    public void setSelected(boolean selected) {
        addTaint(selected);
        IMPL.setSelected(mInfo, selected);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "6F39B6C0009288DFEA1A8807AE028922", hash_generated_method = "E27A04553B4261A6ED307851D3381C63")
    public boolean isClickable() {
        boolean var50B5B2E08A22B3AD29A9E7E355DB395A_420013070 = (IMPL.isClickable(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_494829271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_494829271;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "CBF9AA1E7F6DA4EEE21EFD519E970C6E", hash_generated_method = "EACEF5087FD082FDE8C7968E38B86C7A")
    public void setClickable(boolean clickable) {
        addTaint(clickable);
        IMPL.setClickable(mInfo, clickable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.430 -0400", hash_original_method = "2A0651AA24697C87D5B10A2F592D15AE", hash_generated_method = "5FA68E9843A037F7112B69CD5C60EC7C")
    public boolean isLongClickable() {
        boolean varF4EAA6F4997241DF13A848FDABDE2DE3_307075281 = (IMPL.isLongClickable(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107668378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107668378;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.431 -0400", hash_original_method = "C41DB90B24D967665ADB7BE195D933F7", hash_generated_method = "27E416E65DAA2E3D4144E2260D86D7E7")
    public void setLongClickable(boolean longClickable) {
        addTaint(longClickable);
        IMPL.setLongClickable(mInfo, longClickable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.431 -0400", hash_original_method = "652E5B5F063CB50BC77186FF37F33BDF", hash_generated_method = "736E783FD87E5579C832A04835433D54")
    public boolean isEnabled() {
        boolean var51B48439FD11F5F658E2CBFAF91AFAA8_1082600975 = (IMPL.isEnabled(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1268102770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1268102770;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.431 -0400", hash_original_method = "38B56F1A12BFB4B4EFFD2BC2116AF996", hash_generated_method = "21DA0CFFDB4C804D5A4A91108CBD7CD7")
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        IMPL.setEnabled(mInfo, enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.431 -0400", hash_original_method = "65A99E085FF9E307AFC93D67B83055DB", hash_generated_method = "D8056D554D8A011520CD6B1F65628A45")
    public boolean isPassword() {
        boolean var5B3CA3EE69541E38082AD0239B1B6074_1041055154 = (IMPL.isPassword(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1841965751 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1841965751;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.432 -0400", hash_original_method = "B97A25B40B977908B12069641BAB55A8", hash_generated_method = "2824D3EBA03E41186B592DB1A76A6B96")
    public void setPassword(boolean password) {
        addTaint(password);
        IMPL.setPassword(mInfo, password);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.432 -0400", hash_original_method = "C7AAD2830522B8BD5949276001A4D042", hash_generated_method = "7443D20432C137D7DBB297CD3F87B9C7")
    public boolean isScrollable() {
        boolean var386B817CD3380B6278D51C5463FC5279_2139523913 = (IMPL.isScrollable(mInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517755505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517755505;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.433 -0400", hash_original_method = "EF0CC581E7F7F261AFF7A1550C16EBCA", hash_generated_method = "DE592F606AC5C3DFA486E36F4A7214E0")
    public void setScrollable(boolean scrollable) {
        addTaint(scrollable);
        IMPL.setScrollable(mInfo, scrollable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.433 -0400", hash_original_method = "11DA2F2F6D35A0A5BD4D3AD5855546F2", hash_generated_method = "D0B0623E091F6D03D54FF4C4A4939984")
    public CharSequence getPackageName() {
CharSequence varE0B20734E37C2B46025E4F8131365FD2_1203027428 =         IMPL.getPackageName(mInfo);
        varE0B20734E37C2B46025E4F8131365FD2_1203027428.addTaint(taint);
        return varE0B20734E37C2B46025E4F8131365FD2_1203027428;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.433 -0400", hash_original_method = "51BDE657C455C3947A276CD4621D88BF", hash_generated_method = "9A61E15B94A65BC44A91F487A5663A1A")
    public void setPackageName(CharSequence packageName) {
        addTaint(packageName.getTaint());
        IMPL.setPackageName(mInfo, packageName);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.433 -0400", hash_original_method = "80725931141339E528C95BCDFA69AC67", hash_generated_method = "3118703A0C4716E919150A5D96BB6E4A")
    public CharSequence getClassName() {
CharSequence var13976FE2411926A27FCB8E00EEE7AAD4_103175263 =         IMPL.getClassName(mInfo);
        var13976FE2411926A27FCB8E00EEE7AAD4_103175263.addTaint(taint);
        return var13976FE2411926A27FCB8E00EEE7AAD4_103175263;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.434 -0400", hash_original_method = "95DBB6C9D00CCAE01AE6EC9F7D77613E", hash_generated_method = "F66BE18B952BCADB658E7C23182022A4")
    public void setClassName(CharSequence className) {
        addTaint(className.getTaint());
        IMPL.setClassName(mInfo, className);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.434 -0400", hash_original_method = "384621808EBD921F20A6EB28B91ADAD5", hash_generated_method = "A06A0A37F94200039FEB8DF740B6E512")
    public CharSequence getText() {
CharSequence var1DF1200F05671DF9D4AB0C5F6C8DAAA4_383345745 =         IMPL.getText(mInfo);
        var1DF1200F05671DF9D4AB0C5F6C8DAAA4_383345745.addTaint(taint);
        return var1DF1200F05671DF9D4AB0C5F6C8DAAA4_383345745;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.434 -0400", hash_original_method = "CCE84BD471DC2DB3AF81C568CF944475", hash_generated_method = "6443F8BA015BAFA56BE9E33E21F5D8E5")
    public void setText(CharSequence text) {
        addTaint(text.getTaint());
        IMPL.setText(mInfo, text);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.434 -0400", hash_original_method = "17A5AE651613EAEE40274E28D0DBF3CB", hash_generated_method = "B7BF703AC07F5783D2D5FE7FDE67E89F")
    public CharSequence getContentDescription() {
CharSequence varC4BA732E0BE0020738370211FB549BA9_606706761 =         IMPL.getContentDescription(mInfo);
        varC4BA732E0BE0020738370211FB549BA9_606706761.addTaint(taint);
        return varC4BA732E0BE0020738370211FB549BA9_606706761;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.434 -0400", hash_original_method = "0581568FD089D03E78C8C673EC290A8E", hash_generated_method = "9B7BD8E2BC21A367B4D01A839E39FDB6")
    public void setContentDescription(CharSequence contentDescription) {
        addTaint(contentDescription.getTaint());
        IMPL.setContentDescription(mInfo, contentDescription);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.435 -0400", hash_original_method = "4012C2A77CF6E1C54F1B4372AFDF8962", hash_generated_method = "C65940CB1FE55E31C8C8CA907DBC92D5")
    public void recycle() {
        IMPL.recycle(mInfo);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.435 -0400", hash_original_method = "3D44C3AC54A391BB7EEFE6DCE99834D5", hash_generated_method = "AA597A388E4DD067B3991F015A48827B")
    @Override
    public int hashCode() {
        int var625C9F3E5BE1C6E8EA2CEBDE7561D065_1128275659 = ((mInfo == null) ? 0 : mInfo.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537784730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537784730;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.437 -0400", hash_original_method = "9F360410AD288A74DD17C77A13BAB054", hash_generated_method = "A074CF7E2C8DAB791C962FBD83050300")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(this == obj)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1180826739 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432815212 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432815212;
        } 
    if(obj == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1560944583 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_884364045 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_884364045;
        } 
    if(getClass() != obj.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1404064476 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682299973 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682299973;
        } 
        AccessibilityNodeInfoCompat other = (AccessibilityNodeInfoCompat) obj;
    if(mInfo == null)        
        {
    if(other.mInfo != null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_505057881 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073336527 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073336527;
            } 
        } 
        else
    if(!mInfo.equals(other.mInfo))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1664987229 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_891998014 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_891998014;
        } 
        boolean varB326B5062B2F0E69046810717534CB09_114668780 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715491035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_715491035;
        
        
            
        
        
            
        
        
            
        
        
        
            
                
            
        
            
        
        
    }

    
    static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.437 -0400", hash_original_method = "D9A4AFBF5AD5A775B6C1281730E5BA11", hash_generated_method = "D9A4AFBF5AD5A775B6C1281730E5BA11")
        public AccessibilityNodeInfoStubImpl ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.437 -0400", hash_original_method = "817FD8D623FDA4524F619AFC293F09EC", hash_generated_method = "D5D4022990DEAD48A85F705CDB622F5A")
        public Object obtain() {
Object var540C13E9E156B687226421B24F2DF178_808166371 =             null;
            var540C13E9E156B687226421B24F2DF178_808166371.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_808166371;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.438 -0400", hash_original_method = "92695667FFAB3FACD22606EFAA0A43BA", hash_generated_method = "3316DA34065811E54A817134D83B2F07")
        public Object obtain(View source) {
            addTaint(source.getTaint());
Object var540C13E9E156B687226421B24F2DF178_889612174 =             null;
            var540C13E9E156B687226421B24F2DF178_889612174.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_889612174;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.438 -0400", hash_original_method = "773588C99ADE780DBDFC19514017BC1F", hash_generated_method = "F65D175F9E8D4235E70A65B85D1D6DF9")
        public Object obtain(Object info) {
            addTaint(info.getTaint());
Object var540C13E9E156B687226421B24F2DF178_1425950464 =             null;
            var540C13E9E156B687226421B24F2DF178_1425950464.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1425950464;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.438 -0400", hash_original_method = "8D71C6A90F236F7F17CE9F0DA3BE99D2", hash_generated_method = "5F00060CAB9B4B2566E623D909A28FE0")
        public void addAction(Object info, int action) {
            addTaint(action);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.440 -0400", hash_original_method = "6B9372E604C01DF70F526B6A8E570148", hash_generated_method = "46FE01FA0CFC681CC6BB779E2143207C")
        public void addChild(Object info, View child) {
            addTaint(child.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.440 -0400", hash_original_method = "DDFBD7F537083E060F4196E4CBB1F004", hash_generated_method = "DCE7335FF59B488FD166293C419BEB45")
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
            addTaint(text.getTaint());
            addTaint(info.getTaint());
List<Object> varB803AB532741AA7D5C2F301CCDDD25F2_1417429793 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_1417429793.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_1417429793;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.440 -0400", hash_original_method = "62879C9A6873AFA1FE78492502C9E8C1", hash_generated_method = "F15F3C6378A0EB8262B7DB43AE2DAB92")
        public int getActions(Object info) {
            addTaint(info.getTaint());
            int varCFCD208495D565EF66E7DFF9F98764DA_297897070 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19342186 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19342186;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.440 -0400", hash_original_method = "194BB4DCA6CDD611708C0DBE13AE8AE6", hash_generated_method = "3C000B93FEEBF5C47B18A21222CC810A")
        public void getBoundsInParent(Object info, Rect outBounds) {
            addTaint(outBounds.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.440 -0400", hash_original_method = "AD025A7E801C16406D0F86CAFA041F7F", hash_generated_method = "5D8984E8D4D82D8FAB88F2396774FB3D")
        public void getBoundsInScreen(Object info, Rect outBounds) {
            addTaint(outBounds.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.440 -0400", hash_original_method = "3EFC24789BAB789DBA02244C19291A8A", hash_generated_method = "B71B41DBB9198D4625D271667D1DCF98")
        public Object getChild(Object info, int index) {
            addTaint(index);
            addTaint(info.getTaint());
Object var540C13E9E156B687226421B24F2DF178_1652273479 =             null;
            var540C13E9E156B687226421B24F2DF178_1652273479.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1652273479;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.441 -0400", hash_original_method = "DE0573752D5D98EE2B44C4024F5102E5", hash_generated_method = "18E4BFD3CBC3B7C85C1F836576FB2414")
        public int getChildCount(Object info) {
            addTaint(info.getTaint());
            int varCFCD208495D565EF66E7DFF9F98764DA_1635645950 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303838947 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303838947;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.441 -0400", hash_original_method = "0F7CFAB631E1B134DCF395A7797DAF67", hash_generated_method = "6AFC8E1C58F1EF8B49A1E2C09DCA84BB")
        public CharSequence getClassName(Object info) {
            addTaint(info.getTaint());
CharSequence var540C13E9E156B687226421B24F2DF178_1241824492 =             null;
            var540C13E9E156B687226421B24F2DF178_1241824492.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1241824492;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.441 -0400", hash_original_method = "7D3E1748FD6A5B3BAF1D83AAF2AE15DE", hash_generated_method = "FA9ACF20C1D1EECBE251FD87B5AFD1E0")
        public CharSequence getContentDescription(Object info) {
            addTaint(info.getTaint());
CharSequence var540C13E9E156B687226421B24F2DF178_1883021215 =             null;
            var540C13E9E156B687226421B24F2DF178_1883021215.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1883021215;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.441 -0400", hash_original_method = "D7A11002847EF3E5746055DA2B429105", hash_generated_method = "840A10C11F625CFCF0C73C32E040FCF9")
        public CharSequence getPackageName(Object info) {
            addTaint(info.getTaint());
CharSequence var540C13E9E156B687226421B24F2DF178_1042185895 =             null;
            var540C13E9E156B687226421B24F2DF178_1042185895.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1042185895;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.441 -0400", hash_original_method = "6E57EFC15A3C835051BC240D78A056B3", hash_generated_method = "E59699C758BD75ECA3EE10C939ED4E79")
        public AccessibilityNodeInfoCompat getParent(Object info) {
            addTaint(info.getTaint());
AccessibilityNodeInfoCompat var540C13E9E156B687226421B24F2DF178_1877188321 =             null;
            var540C13E9E156B687226421B24F2DF178_1877188321.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1877188321;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.441 -0400", hash_original_method = "CA1AE5519AB49B9F955ADEDF9C3C214E", hash_generated_method = "2BBBE4890CE78135D8A064EB22399A63")
        public CharSequence getText(Object info) {
            addTaint(info.getTaint());
CharSequence var540C13E9E156B687226421B24F2DF178_1133351793 =             null;
            var540C13E9E156B687226421B24F2DF178_1133351793.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1133351793;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.441 -0400", hash_original_method = "EB7D2054B13C972973DD67D9B21CE0E5", hash_generated_method = "39F00A135E0FCDC08564EB6E3D504AC0")
        public int getWindowId(Object info) {
            addTaint(info.getTaint());
            int varCFCD208495D565EF66E7DFF9F98764DA_1368157400 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1321451042 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1321451042;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.441 -0400", hash_original_method = "4E39FE68FD90D69FA08C7AD1E979DF07", hash_generated_method = "59AC79102ED947719B0A68AB337E82C3")
        public boolean isCheckable(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1796400207 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905008998 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_905008998;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.441 -0400", hash_original_method = "F2469434A89FA62BE9B2DB78034140F5", hash_generated_method = "1E4BC1BBD7C3C1788A30166BA998FB4A")
        public boolean isChecked(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_973715926 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1797244315 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1797244315;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.441 -0400", hash_original_method = "F7781A93E107315385A57825C2B0B78A", hash_generated_method = "BD931D612AE8190488F89D6B8E368336")
        public boolean isClickable(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1580812162 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1419631328 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1419631328;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.442 -0400", hash_original_method = "6BAAC3777342DFE283E965C06FC8D874", hash_generated_method = "46AF711618D2C154FE2D10DA39F30350")
        public boolean isEnabled(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1353960777 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676074586 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_676074586;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.442 -0400", hash_original_method = "24826F7A102BA4F82C9D9B08241E284F", hash_generated_method = "764AA6091638EB62DFD6CD04F68E3833")
        public boolean isFocusable(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_775096175 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1288206780 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1288206780;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.442 -0400", hash_original_method = "4D0616B5A88718B8558E59C7943E57B4", hash_generated_method = "7E95670C8A616A815A44B6D3F90A7F53")
        public boolean isFocused(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1154861829 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1126037952 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1126037952;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.442 -0400", hash_original_method = "3EB36752093CDD3C24048A6DFD7EC73D", hash_generated_method = "EFB04FF8029F59F220C58561DD56EEC3")
        public boolean isLongClickable(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1050610516 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1077752052 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1077752052;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.442 -0400", hash_original_method = "CB922389EC3BD00D9BEE74A550F7293C", hash_generated_method = "7DE2B4B0395E660931920AD997CB0642")
        public boolean isPassword(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1682702315 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1615458006 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1615458006;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.442 -0400", hash_original_method = "0A24FC3E128A848006031E8724C7F0A9", hash_generated_method = "EAE2E3387051016ED9DBA4DABAC29B55")
        public boolean isScrollable(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1622152994 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2138773013 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2138773013;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.442 -0400", hash_original_method = "6AFAC3555346166234EF254615BCA05C", hash_generated_method = "B9F0E6F56D9A90457D724526AA7E6450")
        public boolean isSelected(Object info) {
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_363254039 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1640444738 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1640444738;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.442 -0400", hash_original_method = "FCBED87974E8349E51CFE67F3FE8BAAB", hash_generated_method = "8C68181E4C0717CF9F807899FBAE7752")
        public boolean performAction(Object info, int action) {
            addTaint(action);
            addTaint(info.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1808186975 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1313531709 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1313531709;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.442 -0400", hash_original_method = "6311EA40C38D5B6B34E9E1F7C3DBB879", hash_generated_method = "C7F581AF90B338E0925C62A3024C6F67")
        public void setBoundsInParent(Object info, Rect bounds) {
            addTaint(bounds.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.442 -0400", hash_original_method = "D2C9C693466BA3A7E4B14036D2B17A5B", hash_generated_method = "E05AFA6EA9AAF9FB0ECD646B93254DD9")
        public void setBoundsInScreen(Object info, Rect bounds) {
            addTaint(bounds.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "38431A6D5EE00E0099D8DB2DEFF6D601", hash_generated_method = "804DCE913D9E6070F8E550B71AD22B80")
        public void setCheckable(Object info, boolean checkable) {
            addTaint(checkable);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "4FE562645B89F53A2E3F577D51BE4F8C", hash_generated_method = "4543C14DB341621D93F6F2621D639CFB")
        public void setChecked(Object info, boolean checked) {
            addTaint(checked);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "82032763AB44B88BDF6C3C4AC2ABB1CF", hash_generated_method = "161EF9CD79B216300D2AF4B61D1E4F45")
        public void setClassName(Object info, CharSequence className) {
            addTaint(className.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "31E6103163DC809F9F67CE01A33EE87B", hash_generated_method = "D519D0F39A07EEB0AEEBA5E5875F6150")
        public void setClickable(Object info, boolean clickable) {
            addTaint(clickable);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "B500330A66D743DBA7E460FD212D7744", hash_generated_method = "27D40B14BF3DEDB56AAB9AECA05C82A0")
        public void setContentDescription(Object info, CharSequence contentDescription) {
            addTaint(contentDescription.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "2E8A30481E49B666D7564B714DFA8A28", hash_generated_method = "CA3CFCFE549F59FC75A446D5BCE0A521")
        public void setEnabled(Object info, boolean enabled) {
            addTaint(enabled);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "6FC489938507A8AC8A67E31F4C0F3485", hash_generated_method = "BD5881FAC223E930D2E2E37E44B33C3C")
        public void setFocusable(Object info, boolean focusable) {
            addTaint(focusable);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "D760A9B869FD1EE026AE8BC4B17036E8", hash_generated_method = "14E41B822435BE880FB3392798601F91")
        public void setFocused(Object info, boolean focused) {
            addTaint(focused);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "FD5EDA58E4935860A3097167F37FF25A", hash_generated_method = "3DDF3ED1B3E0FC0801A2CBFA37667157")
        public void setLongClickable(Object info, boolean longClickable) {
            addTaint(longClickable);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "7ACCCA5C650FD61E0E741AE4759FF12D", hash_generated_method = "3D2CB84EBAF7AE0D0E07B4791BF148D9")
        public void setPackageName(Object info, CharSequence packageName) {
            addTaint(packageName.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "69043B1B7F4EB8EB9BDC8511E4B08BEE", hash_generated_method = "4A942148EB5C52DD6E700A02688275C9")
        public void setParent(Object info, View parent) {
            addTaint(parent.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.443 -0400", hash_original_method = "363672B9055A3FB9061F2E3103405704", hash_generated_method = "B195B3F20A419F8DC07BEA2D24B96A97")
        public void setPassword(Object info, boolean password) {
            addTaint(password);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.444 -0400", hash_original_method = "709C7E935F852B3F6266600FDF6B6337", hash_generated_method = "DE0FD2B7B59EB7B909C49C4E237BDD07")
        public void setScrollable(Object info, boolean scrollable) {
            addTaint(scrollable);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.444 -0400", hash_original_method = "3EF8627D1C0109EB2B6665EF94BA680A", hash_generated_method = "8F344D2BAB0B685E1E5931897D28D77F")
        public void setSelected(Object info, boolean selected) {
            addTaint(selected);
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.444 -0400", hash_original_method = "483D361A53672C2015F284EB727D68EB", hash_generated_method = "6E7CE2F4361113870428E586C12141BF")
        public void setSource(Object info, View source) {
            addTaint(source.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.444 -0400", hash_original_method = "A82131F0C1B3FA9CC52D0C37845C305A", hash_generated_method = "A869718C721ADA1CBF5B40E6DCF8AA00")
        public void setText(Object info, CharSequence text) {
            addTaint(text.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.444 -0400", hash_original_method = "83070C3537D062E3CF530D85D02FB919", hash_generated_method = "9CA19930CBA17161800873D06B09C0C2")
        public void recycle(Object info) {
            addTaint(info.getTaint());
            
        }

        
    }


    
    static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.444 -0400", hash_original_method = "21FE378E79CF4BF2260F84D20D666AC8", hash_generated_method = "21FE378E79CF4BF2260F84D20D666AC8")
        public AccessibilityNodeInfoIcsImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.444 -0400", hash_original_method = "E5E40CEE71B96A750609FB525C810C40", hash_generated_method = "40DBFBE0A7CBEE96DE14C3F66BA984D0")
        @Override
        public Object obtain() {
Object var18E616ED4124E416419712D8A33E1555_170373124 =             AccessibilityNodeInfoCompatIcs.obtain();
            var18E616ED4124E416419712D8A33E1555_170373124.addTaint(taint);
            return var18E616ED4124E416419712D8A33E1555_170373124;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.444 -0400", hash_original_method = "8DA77B182C4547DFE3D4092985103CE0", hash_generated_method = "CB7375242B184209D242D52911A0F052")
        @Override
        public Object obtain(View source) {
            addTaint(source.getTaint());
Object var72AFDB1E0D71CABB69ABFDF218476CD8_188178075 =             AccessibilityNodeInfoCompatIcs.obtain(source);
            var72AFDB1E0D71CABB69ABFDF218476CD8_188178075.addTaint(taint);
            return var72AFDB1E0D71CABB69ABFDF218476CD8_188178075;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.444 -0400", hash_original_method = "AAB3A8D4C437B198564587B92520BA15", hash_generated_method = "4A290DB729230FBAF5B10502D15E7DA0")
        @Override
        public Object obtain(Object info) {
            addTaint(info.getTaint());
Object var9655CD537A169570B739BF9CC4952AF2_650992883 =             AccessibilityNodeInfoCompatIcs.obtain(info);
            var9655CD537A169570B739BF9CC4952AF2_650992883.addTaint(taint);
            return var9655CD537A169570B739BF9CC4952AF2_650992883;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.445 -0400", hash_original_method = "0A7E097CDAE39DDB6B86DB3C969CB42E", hash_generated_method = "4265DEC8A88EB69AFE7E14F7A6FA9844")
        @Override
        public void addAction(Object info, int action) {
            addTaint(action);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.addAction(info, action);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.445 -0400", hash_original_method = "341A0CD277745082770A69C5D7681A5A", hash_generated_method = "1D68C7EFD3CEF96931E1517562A1DA7F")
        @Override
        public void addChild(Object info, View child) {
            addTaint(child.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.addChild(info, child);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.445 -0400", hash_original_method = "E451DF79B85F7C5360B2FFDA4305ECB9", hash_generated_method = "B0952EAA5E596464892F3A3FB504EB27")
        @Override
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
            addTaint(text.getTaint());
            addTaint(info.getTaint());
List<Object> var8DC6DAB02BA4C7815AC89010EB33D0AD_1881054379 =             AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(info, text);
            var8DC6DAB02BA4C7815AC89010EB33D0AD_1881054379.addTaint(taint);
            return var8DC6DAB02BA4C7815AC89010EB33D0AD_1881054379;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.445 -0400", hash_original_method = "D17F96C78962590280138C187D4A4D01", hash_generated_method = "6CF159035CE777ABC545E11FC750E780")
        @Override
        public int getActions(Object info) {
            addTaint(info.getTaint());
            int varE1C5C8F3250A60420574AB5876C073E0_1855756292 = (AccessibilityNodeInfoCompatIcs.getActions(info));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831996085 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831996085;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.445 -0400", hash_original_method = "B26B5755D84A45820A9127024B317E2D", hash_generated_method = "8A979AA8B478E449ED6DCD3881A07425")
        @Override
        public void getBoundsInParent(Object info, Rect outBounds) {
            addTaint(outBounds.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.getBoundsInParent(info, outBounds);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.449 -0400", hash_original_method = "B5FD542CD4348223D6FD8509002D9D1B", hash_generated_method = "5B1CF93FA477C47F230F9FF0DF0F5A19")
        @Override
        public void getBoundsInScreen(Object info, Rect outBounds) {
            addTaint(outBounds.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.getBoundsInScreen(info, outBounds);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.449 -0400", hash_original_method = "11896B02F65554BEE96755430EF5F8E2", hash_generated_method = "478CEC02E854A6D603009085DB63400A")
        @Override
        public AccessibilityNodeInfoCompat getChild(Object info, int index) {
            addTaint(index);
            addTaint(info.getTaint());
AccessibilityNodeInfoCompat varC082D3DF38BC3C4721A24C567F2203D9_1471267681 =             new AccessibilityNodeInfoCompat(IMPL.getChild(info, index));
            varC082D3DF38BC3C4721A24C567F2203D9_1471267681.addTaint(taint);
            return varC082D3DF38BC3C4721A24C567F2203D9_1471267681;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.450 -0400", hash_original_method = "1060851E4756FF33B64BCC78AB967D36", hash_generated_method = "BB20EF033A384E0B92C1F67E340DC6AC")
        @Override
        public int getChildCount(Object info) {
            addTaint(info.getTaint());
            int var453D2111E45109D707554F829D387FC3_1993815781 = (AccessibilityNodeInfoCompatIcs.getChildCount(info));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110855952 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110855952;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.450 -0400", hash_original_method = "001ED67ACCB05215E0C0C1269607FAAC", hash_generated_method = "1C63EC366CCB8A5FD46C93E0F4301822")
        @Override
        public CharSequence getClassName(Object info) {
            addTaint(info.getTaint());
CharSequence varC282983408C091643715DAD53F515590_674055932 =             AccessibilityNodeInfoCompatIcs.getClassName(info);
            varC282983408C091643715DAD53F515590_674055932.addTaint(taint);
            return varC282983408C091643715DAD53F515590_674055932;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.450 -0400", hash_original_method = "49E68BE928284122DC1CE4D1F9B3E016", hash_generated_method = "743F9C59DC92C4D0E832DDD5EFC1AD57")
        @Override
        public CharSequence getContentDescription(Object info) {
            addTaint(info.getTaint());
CharSequence var32F5476EEDF6FF1279E269184BC4EEF0_1572147903 =             AccessibilityNodeInfoCompatIcs.getContentDescription(info);
            var32F5476EEDF6FF1279E269184BC4EEF0_1572147903.addTaint(taint);
            return var32F5476EEDF6FF1279E269184BC4EEF0_1572147903;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.450 -0400", hash_original_method = "E8A4C3E3432029A8834D6142201B45ED", hash_generated_method = "FF7B12683256F714EA67F574B373F4BB")
        @Override
        public CharSequence getPackageName(Object info) {
            addTaint(info.getTaint());
CharSequence var25E39EB6D9B13CC71DEE96F6E8413836_865906446 =             AccessibilityNodeInfoCompatIcs.getPackageName(info);
            var25E39EB6D9B13CC71DEE96F6E8413836_865906446.addTaint(taint);
            return var25E39EB6D9B13CC71DEE96F6E8413836_865906446;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.450 -0400", hash_original_method = "D663E14A044DAD7A809F789DAE716A60", hash_generated_method = "50306E2696D59F0F2A267D04889FA5E6")
        @Override
        public AccessibilityNodeInfoCompat getParent(Object info) {
            addTaint(info.getTaint());
AccessibilityNodeInfoCompat var7941D4894D6ACA970D05A94330CFE6E2_887091023 =             new AccessibilityNodeInfoCompat(IMPL.getParent(info));
            var7941D4894D6ACA970D05A94330CFE6E2_887091023.addTaint(taint);
            return var7941D4894D6ACA970D05A94330CFE6E2_887091023;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.450 -0400", hash_original_method = "E0898B972D5792ED49F6E082AA078009", hash_generated_method = "786B445A3146DCF750A6332D2D949B0B")
        @Override
        public CharSequence getText(Object info) {
            addTaint(info.getTaint());
CharSequence varC39EDBF46B20FFFBE67EBDDAFFAF4404_1131715769 =             AccessibilityNodeInfoCompatIcs.getText(info);
            varC39EDBF46B20FFFBE67EBDDAFFAF4404_1131715769.addTaint(taint);
            return varC39EDBF46B20FFFBE67EBDDAFFAF4404_1131715769;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.451 -0400", hash_original_method = "E3B5F3C7383213DB54B59D99B9C21DDF", hash_generated_method = "58F724F35434B50680D9EAF4AF99F28D")
        @Override
        public int getWindowId(Object info) {
            addTaint(info.getTaint());
            int var7E755BE734029BAEE15574E279891519_1098529521 = (AccessibilityNodeInfoCompatIcs.getWindowId(info));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837189111 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837189111;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.451 -0400", hash_original_method = "E86FBEBDF802FE51EE90043BABBDBD26", hash_generated_method = "7D0BE9D841C05E53CD43A4814CF67181")
        @Override
        public boolean isCheckable(Object info) {
            addTaint(info.getTaint());
            boolean var6EBF9497CE9D8DB73C60338542DEE7A0_130791064 = (AccessibilityNodeInfoCompatIcs.isCheckable(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719116738 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719116738;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.451 -0400", hash_original_method = "100CB854A73833CFD79DA770C6A93054", hash_generated_method = "A7170F45FBEF65E544F66B9142623BC5")
        @Override
        public boolean isChecked(Object info) {
            addTaint(info.getTaint());
            boolean var5FE936E046D67E017ADAFED3989D8217_1565504117 = (AccessibilityNodeInfoCompatIcs.isChecked(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638117008 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_638117008;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.452 -0400", hash_original_method = "D3DFDB52B10ADA5E3C3F15A26FC7FBD7", hash_generated_method = "593C2270253D12819B00847A90856C8B")
        @Override
        public boolean isClickable(Object info) {
            addTaint(info.getTaint());
            boolean var7F39A5797EB1A99D99E2343C7CAE7411_499970168 = (AccessibilityNodeInfoCompatIcs.isClickable(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_4021691 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_4021691;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.452 -0400", hash_original_method = "36209ADA0F5A959372A76079E2B78D93", hash_generated_method = "2CF29C40463086B2F4FA6B0556F20D0F")
        @Override
        public boolean isEnabled(Object info) {
            addTaint(info.getTaint());
            boolean var882EA9E175AFA2A78B164B1A1EDAA334_337639130 = (AccessibilityNodeInfoCompatIcs.isEnabled(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164195099 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_164195099;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.452 -0400", hash_original_method = "C6DC12553020499681AB366980A40B1F", hash_generated_method = "5E6A30D127F58E68823C9BEBD640A2BD")
        @Override
        public boolean isFocusable(Object info) {
            addTaint(info.getTaint());
            boolean varF205ED058EE2032775A632B9C55F0576_544780594 = (AccessibilityNodeInfoCompatIcs.isFocusable(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_478233429 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_478233429;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.452 -0400", hash_original_method = "3B18C47ECC5B4B3818BF155318346723", hash_generated_method = "D66C74EC0091F64E3ECD05AE2F952880")
        @Override
        public boolean isFocused(Object info) {
            addTaint(info.getTaint());
            boolean var968A4F44201F839E9BD8A149DDC95B50_120362914 = (AccessibilityNodeInfoCompatIcs.isFocused(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864739858 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_864739858;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.452 -0400", hash_original_method = "0E74B77ABC4CEB867A986595A38161A2", hash_generated_method = "C225EE4BA5F23CDA2E3353F278CE88F0")
        @Override
        public boolean isLongClickable(Object info) {
            addTaint(info.getTaint());
            boolean var7FD4110AC14E635626C3442A1C47C6C0_51982282 = (AccessibilityNodeInfoCompatIcs.isLongClickable(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488279192 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488279192;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.461 -0400", hash_original_method = "B10B564B73623100875F088E9DD770C1", hash_generated_method = "D6CD47724C17B8D043667C27001FBA86")
        @Override
        public boolean isPassword(Object info) {
            addTaint(info.getTaint());
            boolean var591107E717E8BE76738CDD50302FB72E_1396462391 = (AccessibilityNodeInfoCompatIcs.isPassword(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_761834890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_761834890;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.462 -0400", hash_original_method = "27190DC49C8364B899CAE814D744FE8B", hash_generated_method = "1DC490794B01B8D06E4F3CBCFE5984AC")
        @Override
        public boolean isScrollable(Object info) {
            addTaint(info.getTaint());
            boolean var0DBA0213B6D1A14FBEE7922D4AE5EFDB_1327277023 = (AccessibilityNodeInfoCompatIcs.isScrollable(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567346630 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_567346630;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.462 -0400", hash_original_method = "A622640AC1F4DA88BF6801D78709518C", hash_generated_method = "A0CCA849501348E8B1D1806A28A1569D")
        @Override
        public boolean isSelected(Object info) {
            addTaint(info.getTaint());
            boolean var64D15A97240D47FE0C8EC2B678FEEE31_484667914 = (AccessibilityNodeInfoCompatIcs.isSelected(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_51824513 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_51824513;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.462 -0400", hash_original_method = "9AD9C2656115753FB34BB6FBDDF94F3E", hash_generated_method = "8AD627105FEDB67FA4C007E92401D958")
        @Override
        public boolean performAction(Object info, int action) {
            addTaint(action);
            addTaint(info.getTaint());
            boolean varF9AF688EECBFC4106C6E922E0F041AEF_726354747 = (AccessibilityNodeInfoCompatIcs.performAction(info, action));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817727042 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817727042;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.463 -0400", hash_original_method = "B83B9E944F82D8AD27FBEADECC6E7EF2", hash_generated_method = "B5DB3E00269FD3E90A39F18B1B246286")
        @Override
        public void setBoundsInParent(Object info, Rect bounds) {
            addTaint(bounds.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setBoundsInParent(info, bounds);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.463 -0400", hash_original_method = "AA193C796629869323B4C215F767EF10", hash_generated_method = "272EDD93017BFDCA6BC9F9B69976FE38")
        @Override
        public void setBoundsInScreen(Object info, Rect bounds) {
            addTaint(bounds.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setBoundsInScreen(info, bounds);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.464 -0400", hash_original_method = "E50D3EA2B511910BFCFCC317E73F9BD4", hash_generated_method = "C0FD246CF600A12AFC819660661B5557")
        @Override
        public void setCheckable(Object info, boolean checkable) {
            addTaint(checkable);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setCheckable(info, checkable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.464 -0400", hash_original_method = "AC21400C52299765810DFE83F0ADACE8", hash_generated_method = "769CDD4B596A3EC9CAA2C40838E5A7B8")
        @Override
        public void setChecked(Object info, boolean checked) {
            addTaint(checked);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setChecked(info, checked);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.464 -0400", hash_original_method = "7A94FF987D45DDACFD0402C8FB7DDE97", hash_generated_method = "5845EEBEDABF97F8D2A7AB51F28E54EC")
        @Override
        public void setClassName(Object info, CharSequence className) {
            addTaint(className.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setClassName(info, className);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.464 -0400", hash_original_method = "BB8527C09D9C6151F737E8B59EC0FCE8", hash_generated_method = "1E377FC61F83E3E5C15A80672A862C99")
        @Override
        public void setClickable(Object info, boolean clickable) {
            addTaint(clickable);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setClickable(info, clickable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.464 -0400", hash_original_method = "0169AC239075ED7B4C4FDF21404839A2", hash_generated_method = "DA3622123B77CD2E451C413D9BB4143B")
        @Override
        public void setContentDescription(Object info, CharSequence contentDescription) {
            addTaint(contentDescription.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setContentDescription(info, contentDescription);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.464 -0400", hash_original_method = "E3468D53BBC641A160F74004C61B3122", hash_generated_method = "EE6F5DA7CC7016A40B21D7C83D70A756")
        @Override
        public void setEnabled(Object info, boolean enabled) {
            addTaint(enabled);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setEnabled(info, enabled);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.464 -0400", hash_original_method = "DF0F47AC0A3E9517E54BD77506E987C2", hash_generated_method = "295C8D89291147AAA9AEC4F4540EBFFF")
        @Override
        public void setFocusable(Object info, boolean focusable) {
            addTaint(focusable);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setFocusable(info, focusable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.464 -0400", hash_original_method = "06FD2B381779CA5EC6EDBB576923A85B", hash_generated_method = "51DAF5E6FFCA5AFCC41CE4DF37F5875C")
        @Override
        public void setFocused(Object info, boolean focused) {
            addTaint(focused);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setFocused(info, focused);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.465 -0400", hash_original_method = "C3AB7DB810B3043F9F52463A756847CD", hash_generated_method = "971690CB8D25CAF7394EF34846FC720D")
        @Override
        public void setLongClickable(Object info, boolean longClickable) {
            addTaint(longClickable);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setLongClickable(info, longClickable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.465 -0400", hash_original_method = "7DAB17659A9A31AE8995C1EE54CC3933", hash_generated_method = "45B00EE74F0171DC54A79C1B0D835A91")
        @Override
        public void setPackageName(Object info, CharSequence packageName) {
            addTaint(packageName.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setPackageName(info, packageName);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.465 -0400", hash_original_method = "DDE950F8FB9AD10FE97D3324E7FA0C0C", hash_generated_method = "5004BA1E4773E52DAE97853A1F12618E")
        @Override
        public void setParent(Object info, View parent) {
            addTaint(parent.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setParent(info, parent);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_method = "784E93A04B49626C38656FD7564AAD9D", hash_generated_method = "F0B8EBC78DDDAD293AAF066CB748C7B9")
        @Override
        public void setPassword(Object info, boolean password) {
            addTaint(password);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setPassword(info, password);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_method = "B5EF4CAA0C493D78F8DD003411B53892", hash_generated_method = "93DC401C378BC231B855E47C29332094")
        @Override
        public void setScrollable(Object info, boolean scrollable) {
            addTaint(scrollable);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setScrollable(info, scrollable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_method = "1A8DBC2AB955429552ADF95538A7CF85", hash_generated_method = "23DE6E65C107A64E981959F9E092DEFC")
        @Override
        public void setSelected(Object info, boolean selected) {
            addTaint(selected);
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setSelected(info, selected);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_method = "F051415C170BC070EB1133EF8AE51280", hash_generated_method = "894BFD92FBB49740E2F99E521E5152B1")
        @Override
        public void setSource(Object info, View source) {
            addTaint(source.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setSource(info, source);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_method = "FF3C01EEB678F09ADF7342B2D20BBA32", hash_generated_method = "151286B39A90F1E88BEDCF5ECAEA65FA")
        @Override
        public void setText(Object info, CharSequence text) {
            addTaint(text.getTaint());
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.setText(info, text);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_method = "4487949C2661410233FC93B0FC70F4AF", hash_generated_method = "AAD645FF065F336CE08995545206834C")
        @Override
        public void recycle(Object info) {
            addTaint(info.getTaint());
            AccessibilityNodeInfoCompatIcs.recycle(info);
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "97BD12C859C1DA2B5849DD1AFA547C72")

    private static AccessibilityNodeInfoImpl IMPL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_field = "88C2D1887EB31B570369B487597D045B", hash_generated_field = "F5FAE335945DC9AAC45448FAE7461FBF")

    public static final int ACTION_FOCUS = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_field = "1BA8A453AF0935765BB13E51D3B78770", hash_generated_field = "4E51052F791AAD7CED4606387206AC02")

    public static final int ACTION_CLEAR_FOCUS = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_field = "1B92A207713BC68EA97823DAC23B10A2", hash_generated_field = "D94F4C12E9D93257353DF25CED690B59")

    public static final int ACTION_SELECT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.466 -0400", hash_original_field = "61076BF1E4699C26E8B0724E793847FD", hash_generated_field = "A07F23DA35D396F8F58D59EF3496C08F")

    public static final int ACTION_CLEAR_SELECTION = 0x00000008;
}

