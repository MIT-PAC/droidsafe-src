package android.support.v4.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import java.util.Collections;
import java.util.List;

public class AccessibilityRecordCompat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.961 -0400", hash_original_field = "8890C82BADCF19BB0BB600B83E1E8059", hash_generated_field = "A784208C03B426DBD21A9F3B1C9C44D6")

    private Object mRecord;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.963 -0400", hash_original_method = "31BFD4200028F68ABA6334AACE842508", hash_generated_method = "855B285F9F335D062DA50B3F76A35DD3")
    public  AccessibilityRecordCompat(Object record) {
        mRecord = record;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.964 -0400", hash_original_method = "2C39E0AE7A2BCE05DB00110D59202E17", hash_generated_method = "466B8726B2360733261F674326169412")
    public Object getImpl() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1052631907 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1052631907 = mRecord;
        varB4EAC82CA7396A68D541C85D26508E83_1052631907.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1052631907;
        
        
    }

    
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat record) {
        return new AccessibilityRecordCompat(IMPL.obtain(record.mRecord));
    }

    
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(IMPL.obtain());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.965 -0400", hash_original_method = "3AFA3A6DDA2E637FC419ECEFA9F818B5", hash_generated_method = "613E0C1626B058144C618E0A4D03DE7A")
    public void setSource(View source) {
        IMPL.setSource(mRecord, source);
        addTaint(source.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.966 -0400", hash_original_method = "87B299B79D0E14DB7422F340A1C0FE62", hash_generated_method = "6C22D9196F7CF9F0F3EC8DBB52FEBE2D")
    public AccessibilityNodeInfoCompat getSource() {
        AccessibilityNodeInfoCompat varB4EAC82CA7396A68D541C85D26508E83_903783412 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_903783412 = new AccessibilityNodeInfoCompat(IMPL.getSource(mRecord));
        varB4EAC82CA7396A68D541C85D26508E83_903783412.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_903783412;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.967 -0400", hash_original_method = "62E05317A091F9EB5C63A61E1C16E080", hash_generated_method = "A9442A6FE9CE1C9C5B9D4ACB8AA170A9")
    public int getWindowId() {
        int varD6D14034DAC143BC18083922E1AA4F37_1172933767 = (IMPL.getWindowId(mRecord));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717964312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717964312;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.968 -0400", hash_original_method = "1AFF5AE3B94F0056D4EF443770ADC274", hash_generated_method = "003ABA05AEDE4F4B9AC29A3F5517ABDA")
    public boolean isChecked() {
        boolean var1AEB7CB1A7BA301A7AE26D600154FCA1_538610700 = (IMPL.isChecked(mRecord));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070006373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070006373;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.969 -0400", hash_original_method = "82939BC131B10C62FAE215420492E0DB", hash_generated_method = "787D5CC137D2C9DFFAEF8444E86EE31C")
    public void setChecked(boolean isChecked) {
        IMPL.setChecked(mRecord, isChecked);
        addTaint(isChecked);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.970 -0400", hash_original_method = "A6196744A9E0DE4677E4EDCD9CDB5544", hash_generated_method = "FB9A50C69C52E58E42ACEB7499365E8A")
    public boolean isEnabled() {
        boolean varCF0A09CA9033AD995404ED611BB9CA55_773733790 = (IMPL.isEnabled(mRecord));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_879244464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_879244464;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.970 -0400", hash_original_method = "FAC75D5FEE9E951D20E8B74F1F30D63A", hash_generated_method = "D95AB44256475CE33AA89D7A303A1B2D")
    public void setEnabled(boolean isEnabled) {
        IMPL.setEnabled(mRecord, isEnabled);
        addTaint(isEnabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.971 -0400", hash_original_method = "70A4DC0C3F7EE431E19CD0DBB313CFE5", hash_generated_method = "7BE447185C6E2D4FEFD659133F2AB31A")
    public boolean isPassword() {
        boolean varA3411B68596E497E0516F19EE3E36B40_1445608586 = (IMPL.isPassword(mRecord));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389456606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389456606;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.972 -0400", hash_original_method = "8EE6552623D75449CC3632F110D6A6DC", hash_generated_method = "B2E516D39CC54E1BE7508E34D92DA83B")
    public void setPassword(boolean isPassword) {
        IMPL.setPassword(mRecord, isPassword);
        addTaint(isPassword);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.973 -0400", hash_original_method = "AAC0DA1883ED67EF0CCE360E1CEF75EE", hash_generated_method = "B324BDEF03B3E94D1D81D01EA9FC40F8")
    public boolean isFullScreen() {
        boolean varF38B5C46AE6649A5717E46BF3A6C4860_479799470 = (IMPL.isFullScreen(mRecord));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914144864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_914144864;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.973 -0400", hash_original_method = "758F03C13D5E2913F3F825071429E4D3", hash_generated_method = "FC345EEA50DE70CF433A074308754C41")
    public void setFullScreen(boolean isFullScreen) {
        IMPL.setFullScreen(mRecord, isFullScreen);
        addTaint(isFullScreen);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.974 -0400", hash_original_method = "DA5C61B1238A943CEEDDF7DEA078A144", hash_generated_method = "15DB394343ECBDDC4ED2D545FFEBDFBD")
    public boolean isScrollable() {
        boolean var78DDA27DEA8FFE917BC86DE01E0E4E81_1942724637 = (IMPL.isScrollable(mRecord));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_774656234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_774656234;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.975 -0400", hash_original_method = "601A06B4D95E981EE14DE3F104930987", hash_generated_method = "FF8DA035E7A9E0D79C1874451B12AE65")
    public void setScrollable(boolean scrollable) {
        IMPL.setScrollable(mRecord, scrollable);
        addTaint(scrollable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.976 -0400", hash_original_method = "FF998EEBCE262ECE980198329C7BF044", hash_generated_method = "728E6AC8531CC13B2B062B4B20A13F2D")
    public int getItemCount() {
        int var430B33AE70A17996AB41ECACDA6FDCD1_1891257869 = (IMPL.getItemCount(mRecord));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014091956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014091956;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.976 -0400", hash_original_method = "D724658F0D124C2BBF450D2DF56F4A64", hash_generated_method = "F5F2C5F715668CE773CDDA76CDD16022")
    public void setItemCount(int itemCount) {
        IMPL.setItemCount(mRecord, itemCount);
        addTaint(itemCount);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.977 -0400", hash_original_method = "134A1A5E9720C6CF389819EA20DC75ED", hash_generated_method = "00BE4536267B0A67AFA3A20371F41EBE")
    public int getCurrentItemIndex() {
        int varC3E5E4573C0CF095667F6465CEA2C46B_210372480 = (IMPL.getCurrentItemIndex(mRecord));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466034220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466034220;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.979 -0400", hash_original_method = "DD215C23DF27951318344094153429B5", hash_generated_method = "F995AB2871C66F6949A91DE7F39719F9")
    public void setCurrentItemIndex(int currentItemIndex) {
        IMPL.setCurrentItemIndex(mRecord, currentItemIndex);
        addTaint(currentItemIndex);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.979 -0400", hash_original_method = "3159741BF497F4B87AC236AE0D7CED6E", hash_generated_method = "89DDE2DD51F4144AD2B22EF226CD459C")
    public int getFromIndex() {
        int varB338FA807A94EE1075D970119E078004_979508851 = (IMPL.getFromIndex(mRecord));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677461149 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677461149;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.980 -0400", hash_original_method = "4D25992BD728B158A01F4E5FA9D902DE", hash_generated_method = "3C7F8131B85C7BFE99FBF05C74E986B7")
    public void setFromIndex(int fromIndex) {
        IMPL.setFromIndex(mRecord, fromIndex);
        addTaint(fromIndex);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.981 -0400", hash_original_method = "B98FE77EA903D04BD246D29EFA547DB8", hash_generated_method = "407E178ACBCE41F1A8C3C86E716D64DF")
    public int getToIndex() {
        int var587849E4EAA4948C03BEA30210D153A8_1045551584 = (IMPL.getToIndex(mRecord));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150124688 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150124688;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.981 -0400", hash_original_method = "414EFB55B509BEB1998DEF9660ADB5DF", hash_generated_method = "98FEBA5F829B4E4AF43D7BDA7875A9D8")
    public void setToIndex(int toIndex) {
        IMPL.setToIndex(mRecord, toIndex);
        addTaint(toIndex);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.982 -0400", hash_original_method = "2D992416899C0D6D302552E083379ADA", hash_generated_method = "8C0C64ACE581237BE63BB9610B094AE5")
    public int getScrollX() {
        int varCAB2C9B5C3FE9A96F55B0B4512A83C66_1362222571 = (IMPL.getScrollX(mRecord));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189652019 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189652019;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.983 -0400", hash_original_method = "3CE80F2924A14D2238AE5FB516124BCB", hash_generated_method = "F0208D4DB0A79A1F7204C54D9F9457F8")
    public void setScrollX(int scrollX) {
        IMPL.setScrollX(mRecord, scrollX);
        addTaint(scrollX);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.984 -0400", hash_original_method = "4B111184EA88BFF1C758C71BC3F20771", hash_generated_method = "2B4F7BE1C720FE9535D81E54E51A1560")
    public int getScrollY() {
        int varEE8DAC4E1B5E6DF141007150A38AE1C5_976091632 = (IMPL.getScrollY(mRecord));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_706917338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_706917338;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.984 -0400", hash_original_method = "701F7B58DDEAE878FA149CFF436CC09C", hash_generated_method = "62622980D6959E563D9E6D8248CE1BE2")
    public void setScrollY(int scrollY) {
        IMPL.setScrollY(mRecord, scrollY);
        addTaint(scrollY);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.985 -0400", hash_original_method = "AE14117EBCD35B74E7A6C851CE8210F8", hash_generated_method = "545B8A831324C6974BC6FFC64722C9BC")
    public int getAddedCount() {
        int var251C34EB46817618A08D3A073B063921_338491525 = (IMPL.getAddedCount(mRecord));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408853538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408853538;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.986 -0400", hash_original_method = "575511048E9683D5570A7B1D589F2F9C", hash_generated_method = "93F5270121D391465D88107C0426083E")
    public void setAddedCount(int addedCount) {
        IMPL.setAddedCount(mRecord, addedCount);
        addTaint(addedCount);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.986 -0400", hash_original_method = "270EBCBE6CCF53B396B18FE08804E168", hash_generated_method = "DFAB5F282AE9BD41DCB935E659981F09")
    public int getRemovedCount() {
        int varB99BDF01BEC3A21F7C07B95909105866_1763283304 = (IMPL.getRemovedCount(mRecord));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651535713 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651535713;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.987 -0400", hash_original_method = "99F088C5A877A6D1CA743EAA6EB22155", hash_generated_method = "455F5616939D685ECFBD1FF99153CBE2")
    public void setRemovedCount(int removedCount) {
        IMPL.setRemovedCount(mRecord, removedCount);
        addTaint(removedCount);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.988 -0400", hash_original_method = "67AA0D33040F2AF335EF030F65429A0D", hash_generated_method = "8A649C9634A9B785C2A4FAA115F5AF60")
    public CharSequence getClassName() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1698657552 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1698657552 = IMPL.getClassName(mRecord);
        varB4EAC82CA7396A68D541C85D26508E83_1698657552.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1698657552;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.989 -0400", hash_original_method = "2A00F8117EF5BF1532A324D95A4DA5A5", hash_generated_method = "915F605C485ED88B34A8790782BC80E3")
    public void setClassName(CharSequence className) {
        IMPL.setClassName(mRecord, className);
        addTaint(className.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.990 -0400", hash_original_method = "6C334D32F26DB2948FA7A060F2770263", hash_generated_method = "A716ADFD332F8213D17E6758E57B3078")
    public List<CharSequence> getText() {
        List<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_946558557 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_946558557 = IMPL.getText(mRecord);
        varB4EAC82CA7396A68D541C85D26508E83_946558557.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_946558557;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.991 -0400", hash_original_method = "4C454BCB63118A3CFA6774F8547F2900", hash_generated_method = "552D629748571E35ECAB0D3BBA5A8EDD")
    public CharSequence getBeforeText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1150627000 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1150627000 = IMPL.getBeforeText(mRecord);
        varB4EAC82CA7396A68D541C85D26508E83_1150627000.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1150627000;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.992 -0400", hash_original_method = "17C47A47264827FA91F78B1F5C19C158", hash_generated_method = "FA2DCB98D0CEACF51A7AEBE3CF0B6E41")
    public void setBeforeText(CharSequence beforeText) {
        IMPL.setBeforeText(mRecord, beforeText);
        addTaint(beforeText.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.993 -0400", hash_original_method = "0E1DDDE186BEA175AC4E63AF1F7EF300", hash_generated_method = "CE68ADFE965EA6887F8E937CC40908D7")
    public CharSequence getContentDescription() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_186031772 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_186031772 = IMPL.getContentDescription(mRecord);
        varB4EAC82CA7396A68D541C85D26508E83_186031772.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_186031772;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.993 -0400", hash_original_method = "24B5932BDE3800F2FCAC61218978EDA1", hash_generated_method = "2AC8D752FD23007E74DE2226CC3CECA8")
    public void setContentDescription(CharSequence contentDescription) {
        IMPL.setContentDescription(mRecord, contentDescription);
        addTaint(contentDescription.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.994 -0400", hash_original_method = "6CF5581B59D6C7B0E77B7A5EDAAA13F8", hash_generated_method = "E53BC163088324437C3C05D22481D8B0")
    public Parcelable getParcelableData() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_316888683 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_316888683 = IMPL.getParcelableData(mRecord);
        varB4EAC82CA7396A68D541C85D26508E83_316888683.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_316888683;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.995 -0400", hash_original_method = "991957DCCCA90403EB058761C8C6E328", hash_generated_method = "651ED202DE0F1FA5943356DDA2B5F767")
    public void setParcelableData(Parcelable parcelableData) {
        IMPL.setParcelableData(mRecord, parcelableData);
        addTaint(parcelableData.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.996 -0400", hash_original_method = "CC34369D324679ED344B1A114F44B50C", hash_generated_method = "609A1AA21F68A174783E549285162068")
    public void recycle() {
        IMPL.recycle(mRecord);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.997 -0400", hash_original_method = "25EC1341BA7AB69E33A1507EBB2B1096", hash_generated_method = "9761DF11E60799A3D54176D4B8558698")
    @Override
    public int hashCode() {
        {
            Object var2DF6DD84668FFF34C0CB8AAB3D901C1F_1555904998 = (mRecord.hashCode());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1115550484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1115550484;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.999 -0400", hash_original_method = "23C3AD1F1A4F2DE3EE1527927DE9E6EE", hash_generated_method = "18E8CCAE94B59F61F8C98142B45C0EA1")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var0BDD716692710C348B07111E17BD2B29_183520443 = (getClass() != obj.getClass());
        } 
        AccessibilityRecordCompat other = (AccessibilityRecordCompat) obj;
        {
            boolean var145C2980F6EFCCF2016A70C0289E1D78_1619291609 = (!mRecord.equals(other.mRecord));
        } 
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2132635228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2132635228;
        
        
            
        
        
            
        
        
            
        
        
        
            
                
            
        
            
        
        
    }

    
    static class AccessibilityRecordStubImpl implements AccessibilityRecordImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.999 -0400", hash_original_method = "98A014BA02CDE6CACF46F7CB382330E8", hash_generated_method = "98A014BA02CDE6CACF46F7CB382330E8")
        public AccessibilityRecordStubImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.003 -0400", hash_original_method = "817FD8D623FDA4524F619AFC293F09EC", hash_generated_method = "B5BE255727F4822945BFB6235EB25571")
        public Object obtain() {
            Object varB4EAC82CA7396A68D541C85D26508E83_548616916 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_548616916 = null;
            varB4EAC82CA7396A68D541C85D26508E83_548616916.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_548616916;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.005 -0400", hash_original_method = "C833934C702CCEDDDC40965CF6BB153A", hash_generated_method = "D8D09D0D8DBEB8180F305D08DCEF35A8")
        public Object obtain(Object record) {
            Object varB4EAC82CA7396A68D541C85D26508E83_213923047 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_213923047 = null;
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_213923047.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_213923047;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.005 -0400", hash_original_method = "F90CB281D321FEE4A4F0AF83B7ABB25F", hash_generated_method = "2B3735A858F7C55B5D65DCF4136DB405")
        public int getAddedCount(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836579266 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836579266;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.006 -0400", hash_original_method = "D88DAB510B8A28B158E9FAE2985AFAAE", hash_generated_method = "B566C3B091F58BDADACAA5A46B36A547")
        public CharSequence getBeforeText(Object record) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_711454842 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_711454842 = null;
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_711454842.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_711454842;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.008 -0400", hash_original_method = "FD914D1EFD1979B37ED7245D7B7F7059", hash_generated_method = "A9B0A16B7751645F4E087FFEC5845BDC")
        public CharSequence getClassName(Object record) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_401564111 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_401564111 = null;
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_401564111.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_401564111;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.009 -0400", hash_original_method = "D84898F53B55733105C243C31FF4D92A", hash_generated_method = "EC761A500C17EB929B21B67D804D9F4B")
        public CharSequence getContentDescription(Object record) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1364741104 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1364741104 = null;
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1364741104.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1364741104;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.009 -0400", hash_original_method = "ED755EB9CD2FCB213F8D0958182918B1", hash_generated_method = "CC1168C4E2DA67259CF55D1F12C3DAE3")
        public int getCurrentItemIndex(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134883623 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134883623;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.010 -0400", hash_original_method = "EA55EE1496DF735826E7042DBF59DA21", hash_generated_method = "ED317A3F444EC61CFD2CEC807AD518DE")
        public int getFromIndex(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249245764 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249245764;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.011 -0400", hash_original_method = "B2CEF64A9C6DC39EFF7F59F41B235ACE", hash_generated_method = "5526532EE3AC16B18F9B61CA96BDFDA5")
        public int getItemCount(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466801967 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466801967;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.012 -0400", hash_original_method = "43109DE447EFD28C11432306FD2A6430", hash_generated_method = "154F5410440A9489A98982AE0D1B9E7D")
        public int getMaxScrollX(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1015026478 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1015026478;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.012 -0400", hash_original_method = "79A4CD5BA9EBA207867CFDF16F8DCECF", hash_generated_method = "72C69B6A5DC3A551190099E45264A2E2")
        public int getMaxScrollY(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061082655 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061082655;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.013 -0400", hash_original_method = "A496485FDBB3D7A6E6A1E20087CB0236", hash_generated_method = "DD2245F877D591C23835F30E5ABF8E6C")
        public Parcelable getParcelableData(Object record) {
            Parcelable varB4EAC82CA7396A68D541C85D26508E83_1385734164 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1385734164 = null;
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1385734164.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1385734164;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.014 -0400", hash_original_method = "83058A7D703FFDCDBF9FB80F6F624B91", hash_generated_method = "A6C9166720B55A4C4C978612D488FF81")
        public int getRemovedCount(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496633861 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496633861;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.015 -0400", hash_original_method = "A98DC13E63DB6EDF6312E82E1369DC81", hash_generated_method = "F802285DF72D2506CCCF6D94EC01E1D4")
        public int getScrollX(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334010997 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334010997;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.015 -0400", hash_original_method = "D402DAA3C0FEF0B1A87C51CCB5A458A6", hash_generated_method = "B57366E57F973B80225A8CF987DAD2AA")
        public int getScrollY(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_423295543 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_423295543;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.017 -0400", hash_original_method = "5E1028B22D24ABF330B31F8D1C2B3273", hash_generated_method = "BDBCA6D811B6708DC91B1FBB84ADC31E")
        public Object getSource(Object record) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1967926691 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1967926691 = null;
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1967926691.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1967926691;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.018 -0400", hash_original_method = "557E1B686C578B3F4C5D623A55790D8F", hash_generated_method = "0A699E9B649A651BCE89FD7BFEE871EE")
        public List<CharSequence> getText(Object record) {
            List<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_682990403 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_682990403 = Collections.emptyList();
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_682990403.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_682990403;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.018 -0400", hash_original_method = "53BD445A2E4F458172E7D521BE2BA282", hash_generated_method = "EEABBC712037E51F662C4B860EF78D1D")
        public int getToIndex(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749476346 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749476346;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.019 -0400", hash_original_method = "E7E274C535518FCBAF4AC98EFC681CC0", hash_generated_method = "0AC5ED1CF99819F2BE1D98065891B266")
        public int getWindowId(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691658380 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691658380;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.020 -0400", hash_original_method = "B009BFD7507989B7F184DE698965678F", hash_generated_method = "BD6B7A1BD796F1DF9C331E454868DEC3")
        public boolean isChecked(Object record) {
            addTaint(record.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968254736 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968254736;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.021 -0400", hash_original_method = "387492772BF087B392CED940E81C610C", hash_generated_method = "D459CC43DBF06EF8D0315790863B6736")
        public boolean isEnabled(Object record) {
            addTaint(record.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193481156 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193481156;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.021 -0400", hash_original_method = "C9E2268D6783DD1689D249ED1947D214", hash_generated_method = "A2D0693A3B8AE5511EA72B740A6E5C79")
        public boolean isFullScreen(Object record) {
            addTaint(record.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479980979 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_479980979;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.022 -0400", hash_original_method = "B0A101CD42EE708C94CC714B34E79483", hash_generated_method = "003F0CD0CCCBBA3E2599EEA6A36B0296")
        public boolean isPassword(Object record) {
            addTaint(record.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830681606 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_830681606;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.023 -0400", hash_original_method = "EFE1A97D41CCD0AC1CAE8AE734022222", hash_generated_method = "6319204B4CDA3F390A5FAC8E430F6C0A")
        public boolean isScrollable(Object record) {
            addTaint(record.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_6673144 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_6673144;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.023 -0400", hash_original_method = "0822C51B444C5D0A3B1814CCF76346D8", hash_generated_method = "C4DD1BCD02276DC1A58794021EE4769D")
        public void recycle(Object record) {
            addTaint(record.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.024 -0400", hash_original_method = "AB58CF4EF2D36470A4509FD8C486C38C", hash_generated_method = "AFC220B65A1FACA102723F6D00BF1A23")
        public void setAddedCount(Object record, int addedCount) {
            addTaint(record.getTaint());
            addTaint(addedCount);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.025 -0400", hash_original_method = "0C616FCF3D2F73E411A730590E3D5D32", hash_generated_method = "B14DE201EAC5AEBFC36C83B775C6FE90")
        public void setBeforeText(Object record, CharSequence beforeText) {
            addTaint(record.getTaint());
            addTaint(beforeText.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.025 -0400", hash_original_method = "7C27BC3788733125D507437335EC353D", hash_generated_method = "18BEF68D3E1C3584268E276BC6FAFF49")
        public void setChecked(Object record, boolean isChecked) {
            addTaint(record.getTaint());
            addTaint(isChecked);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.026 -0400", hash_original_method = "FD317401C826C1223A64867C6EC5B291", hash_generated_method = "111A63A16D4875FFD3F3F1C0E267A550")
        public void setClassName(Object record, CharSequence className) {
            addTaint(record.getTaint());
            addTaint(className.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.027 -0400", hash_original_method = "94F0136A29282DAA3DE997090A6A286A", hash_generated_method = "F5A441C0C45B4B64EB378D25D2451BD0")
        public void setContentDescription(Object record, CharSequence contentDescription) {
            addTaint(record.getTaint());
            addTaint(contentDescription.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.027 -0400", hash_original_method = "A2C7EF51987839BAAD4F90BA90C23B24", hash_generated_method = "2FBE9F13C3FEF3964762A2ECA3B37D72")
        public void setCurrentItemIndex(Object record, int currentItemIndex) {
            addTaint(record.getTaint());
            addTaint(currentItemIndex);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.028 -0400", hash_original_method = "1CB087CD34A2A1CF4BACE46FF2A73CB2", hash_generated_method = "CE7D6C30E55330224ABDC597A2756353")
        public void setEnabled(Object record, boolean isEnabled) {
            addTaint(record.getTaint());
            addTaint(isEnabled);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.029 -0400", hash_original_method = "A1530126D49151037E6BE9D65E5EF0F5", hash_generated_method = "21CE33D216532561C689DD23F2BA4723")
        public void setFromIndex(Object record, int fromIndex) {
            addTaint(record.getTaint());
            addTaint(fromIndex);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.029 -0400", hash_original_method = "636733158A16FF28777C708D236383E9", hash_generated_method = "9575FDC1BA203FEA31D8BEBC1A64A813")
        public void setFullScreen(Object record, boolean isFullScreen) {
            addTaint(record.getTaint());
            addTaint(isFullScreen);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.030 -0400", hash_original_method = "7CF260AA168E10865865C5096E83F546", hash_generated_method = "1A0BEFC8AB659239966872A3D5535BBB")
        public void setItemCount(Object record, int itemCount) {
            addTaint(record.getTaint());
            addTaint(itemCount);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.031 -0400", hash_original_method = "B0E228EC678D60AF999CBBCF90005DC4", hash_generated_method = "62B810683D07C9B1273A5DD7EA7B82E2")
        public void setMaxScrollX(Object record, int maxScrollX) {
            addTaint(record.getTaint());
            addTaint(maxScrollX);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.031 -0400", hash_original_method = "6BFFE4DDD0D4E15E25FCE31267BE93D4", hash_generated_method = "9BE3A3263DFA77FEA594A55F65F88E8C")
        public void setMaxScrollY(Object record, int maxScrollY) {
            addTaint(record.getTaint());
            addTaint(maxScrollY);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.032 -0400", hash_original_method = "451273F7B55B772F2ACF5DAE588A6DDB", hash_generated_method = "9A05512AA660E93052DD827C39C570B5")
        public void setParcelableData(Object record, Parcelable parcelableData) {
            addTaint(record.getTaint());
            addTaint(parcelableData.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.032 -0400", hash_original_method = "F35ACC96BB4285B03C9C78E114EF8F8B", hash_generated_method = "AECA75952F61DC76BC139596AB9AF495")
        public void setPassword(Object record, boolean isPassword) {
            addTaint(record.getTaint());
            addTaint(isPassword);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.033 -0400", hash_original_method = "A89AC7628D40B20639C8511B06AD2E79", hash_generated_method = "0E07FF27DCBD7706B93CCD299F21E39D")
        public void setRemovedCount(Object record, int removedCount) {
            addTaint(record.getTaint());
            addTaint(removedCount);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.034 -0400", hash_original_method = "DA3CC9AB973CA8FF4F8225CF31D19FEC", hash_generated_method = "749C94C3DF616712C8B328A138AC487F")
        public void setScrollX(Object record, int scrollX) {
            addTaint(record.getTaint());
            addTaint(scrollX);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.034 -0400", hash_original_method = "867F931D8D0C10A48663B9ECBFA8AA42", hash_generated_method = "FA775ED449E42A312B7CDC7043A14665")
        public void setScrollY(Object record, int scrollY) {
            addTaint(record.getTaint());
            addTaint(scrollY);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.035 -0400", hash_original_method = "D396DC479E27254826BDBDB3890ABCBE", hash_generated_method = "CC13821B8875799E94EBF4630C54C5A7")
        public void setScrollable(Object record, boolean scrollable) {
            addTaint(record.getTaint());
            addTaint(scrollable);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.036 -0400", hash_original_method = "D302B78A3606FA23A1E14A2A82F4DEFF", hash_generated_method = "769AA30882D16222E3C021B2279CBA91")
        public void setSource(Object record, View source) {
            addTaint(record.getTaint());
            addTaint(source.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.036 -0400", hash_original_method = "D8359FB6845E0B840F7081D0CBF68C27", hash_generated_method = "7CBEFD3D747E28AE1FA20ECD80E5070C")
        public void setToIndex(Object record, int toIndex) {
            addTaint(record.getTaint());
            addTaint(toIndex);
            
        }

        
    }


    
    static class AccessibilityRecordIcsImpl implements AccessibilityRecordImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.037 -0400", hash_original_method = "79E9BB88A9F6C01B2F6DFECDC746ACB0", hash_generated_method = "79E9BB88A9F6C01B2F6DFECDC746ACB0")
        public AccessibilityRecordIcsImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.038 -0400", hash_original_method = "7EB73FBAB263789F210F7788D51468F4", hash_generated_method = "79EE15E15E16350DB87303E96808FF18")
        public Object obtain() {
            Object varB4EAC82CA7396A68D541C85D26508E83_363352881 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_363352881 = AccessibilityRecordCompatIcs.obtain();
            varB4EAC82CA7396A68D541C85D26508E83_363352881.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_363352881;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.039 -0400", hash_original_method = "BC9FDD776008A9B0D82C05498D1EECA9", hash_generated_method = "85D7816DE6CA8586B5AF80B5D40D13A8")
        public Object obtain(Object record) {
            Object varB4EAC82CA7396A68D541C85D26508E83_407713110 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_407713110 = AccessibilityRecordCompatIcs.obtain(record);
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_407713110.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_407713110;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.040 -0400", hash_original_method = "1A3B37CCDB12C867E6A2288A86DB25D6", hash_generated_method = "354B839EF2AFB75B68827D883BD108B8")
        public int getAddedCount(Object record) {
            int varF205E06571111F1B74E6CE994F8D3A7E_37437691 = (AccessibilityRecordCompatIcs.getAddedCount(record));
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879796221 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879796221;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.041 -0400", hash_original_method = "3233A2F1E3D7B7C0F821BB74C3572D3B", hash_generated_method = "BFAAB89F1EECC8FE2EE8702250E7D4C4")
        public CharSequence getBeforeText(Object record) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1110333141 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1110333141 = AccessibilityRecordCompatIcs.getBeforeText(record);
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1110333141.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1110333141;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.042 -0400", hash_original_method = "CE0472CF4E9A5E340A202A18673487AD", hash_generated_method = "8710CD822DB2AFBBE59D7ABF9ED8D388")
        public CharSequence getClassName(Object record) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_968433234 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_968433234 = AccessibilityRecordCompatIcs.getClassName(record);
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_968433234.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_968433234;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.043 -0400", hash_original_method = "90265E40F7249321A4F41F94F40B90B4", hash_generated_method = "F53E2760591DA5A76F81F62CFF2AB7A6")
        public CharSequence getContentDescription(Object record) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1519018784 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1519018784 = AccessibilityRecordCompatIcs.getContentDescription(record);
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1519018784.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1519018784;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.044 -0400", hash_original_method = "6C105B97A5CC45B944ED2061420896E4", hash_generated_method = "10CD04C00BA7FF39ECC14A790C567B56")
        public int getCurrentItemIndex(Object record) {
            int var9D00F3D1E484C3C5DA873F369296EB3D_1758040542 = (AccessibilityRecordCompatIcs.getCurrentItemIndex(record));
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420033287 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420033287;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.045 -0400", hash_original_method = "E73C10ABA610508FD459620AD9ECEF63", hash_generated_method = "AB14229BF9C408F26875ECF400F2C32F")
        public int getFromIndex(Object record) {
            int varA9638B657EF71BE545F7DB4DC3CFFD58_1385873545 = (AccessibilityRecordCompatIcs.getFromIndex(record));
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797730634 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797730634;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.046 -0400", hash_original_method = "C0064662D0DCC3222F592593F36EEC2E", hash_generated_method = "0C7904F0A87C4DDF0981F3B77C1B2FEF")
        public int getItemCount(Object record) {
            int varA1E78F2D37E3AC57B5468521556F0EFB_1900202866 = (AccessibilityRecordCompatIcs.getItemCount(record));
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081609684 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081609684;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.046 -0400", hash_original_method = "43109DE447EFD28C11432306FD2A6430", hash_generated_method = "3F5B583A29933CE5FE5DF595AA8115B7")
        public int getMaxScrollX(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953511769 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953511769;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.047 -0400", hash_original_method = "79A4CD5BA9EBA207867CFDF16F8DCECF", hash_generated_method = "A0E9AF488D0A6DDF07AEE2060FD9265A")
        public int getMaxScrollY(Object record) {
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622173709 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622173709;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.048 -0400", hash_original_method = "CC62F112D356933D47B1FFB5ECF96325", hash_generated_method = "9DDDA65C23A9EC686D99D93951906A47")
        public Parcelable getParcelableData(Object record) {
            Parcelable varB4EAC82CA7396A68D541C85D26508E83_2081984625 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2081984625 = AccessibilityRecordCompatIcs.getParcelableData(record);
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2081984625.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2081984625;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.049 -0400", hash_original_method = "74EE57882BE0AC5227D4B1A7BE4DF3EB", hash_generated_method = "A5226C6D6AF11081BE1D0A5BC89E7B68")
        public int getRemovedCount(Object record) {
            int var3CD8E629F492783E2CE3C22C120C617A_745315080 = (AccessibilityRecordCompatIcs.getRemovedCount(record));
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289055857 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289055857;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.050 -0400", hash_original_method = "3CDC55E12CC43F0F7062D946B2C371BA", hash_generated_method = "E6EB5CF727CC37898A64FBC3C1076C4A")
        public int getScrollX(Object record) {
            int var8667F56D370F4923E87FF114F24B551E_2096946696 = (AccessibilityRecordCompatIcs.getScrollX(record));
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1045521121 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1045521121;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.051 -0400", hash_original_method = "A53F9B18279808A39A557368A4537B73", hash_generated_method = "06C27AC5745AED038DEF5287812B19F7")
        public int getScrollY(Object record) {
            int var6C04B019DAFBF4BC72D2372700FA915D_2037791288 = (AccessibilityRecordCompatIcs.getScrollY(record));
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391910221 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391910221;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.052 -0400", hash_original_method = "B16BD5CAEAB6E74A1B628B89673113C1", hash_generated_method = "C647235A1B23A0D0D9A07892AF891C5F")
        public Object getSource(Object record) {
            Object varB4EAC82CA7396A68D541C85D26508E83_564119296 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_564119296 = AccessibilityRecordCompatIcs.getSource(record);
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_564119296.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_564119296;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.053 -0400", hash_original_method = "7D5A4E2FBB71350423F36CEA34258542", hash_generated_method = "F5779EE442D9B0C42B5E0A22747A09E8")
        public List<CharSequence> getText(Object record) {
            List<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_424262704 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_424262704 = AccessibilityRecordCompatIcs.getText(record);
            addTaint(record.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_424262704.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_424262704;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.054 -0400", hash_original_method = "DBFAF70FD24A0E3BD9DECD31C804261E", hash_generated_method = "5CE4DFE2C7D1067440E520E686FB7BF6")
        public int getToIndex(Object record) {
            int varF58656B165152B6842AA2F0F182914AE_1759056437 = (AccessibilityRecordCompatIcs.getToIndex(record));
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732359235 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732359235;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.054 -0400", hash_original_method = "82570EB5ECC68E1592DDC7271BAA513A", hash_generated_method = "9B9D31435ACC2AB406987AA15BA9B142")
        public int getWindowId(Object record) {
            int varA703D13ADD48D70C5B0ED74CEF8E03F4_1569873968 = (AccessibilityRecordCompatIcs.getWindowId(record));
            addTaint(record.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391338460 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391338460;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.055 -0400", hash_original_method = "D84F419FB6F45F1DC525312FAE07E15A", hash_generated_method = "0F23CC5B7A743A8587F89CADD9B8362B")
        public boolean isChecked(Object record) {
            boolean var1DAAAE53D1551180749D2563E6855E71_662656460 = (AccessibilityRecordCompatIcs.isChecked(record));
            addTaint(record.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210255697 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_210255697;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.056 -0400", hash_original_method = "C4D9B7F97B0BCAF922F0D36278F5ECC6", hash_generated_method = "0AA65354A0B3A93E2EC8064C1EB6F3ED")
        public boolean isEnabled(Object record) {
            boolean varF4BA5916D6455E276DA0ACAA97CCCA71_317792931 = (AccessibilityRecordCompatIcs.isEnabled(record));
            addTaint(record.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1674167813 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1674167813;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.057 -0400", hash_original_method = "2C61F22D5E7C67D35B4F5A356D7C4989", hash_generated_method = "78C537E2A04D25EDC868C61992808AF1")
        public boolean isFullScreen(Object record) {
            boolean var4C6C45250A465C8886728EF2E8A07ED3_91584720 = (AccessibilityRecordCompatIcs.isFullScreen(record));
            addTaint(record.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1873929691 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1873929691;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.058 -0400", hash_original_method = "A44538CA98CE6E195EC08845FDC2FD6F", hash_generated_method = "894F5FC146BDE60D08D912C0A92B948F")
        public boolean isPassword(Object record) {
            boolean varCD162F5371F0E85B6D69819BC351A152_2098564974 = (AccessibilityRecordCompatIcs.isPassword(record));
            addTaint(record.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25286051 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_25286051;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.059 -0400", hash_original_method = "E306720FA5100494F8B3A29CFC4AB9F1", hash_generated_method = "039EE9AD35401E26477607804A1B540C")
        public boolean isScrollable(Object record) {
            boolean var9631674BF456BCFA044639C5BE52A0C1_1858015751 = (AccessibilityRecordCompatIcs.isScrollable(record));
            addTaint(record.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_314684393 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_314684393;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.060 -0400", hash_original_method = "2DCE6B495EBDB32321C0D4BA972CB3B3", hash_generated_method = "728ECC0BE5A841742D4567744B532230")
        public void recycle(Object record) {
            AccessibilityRecordCompatIcs.recycle(record);
            addTaint(record.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.060 -0400", hash_original_method = "DDC17112B95239E4ABC47C1E1767BE34", hash_generated_method = "CADF2D26B1B7365DE9866FC5E5E9303C")
        public void setAddedCount(Object record, int addedCount) {
            AccessibilityRecordCompatIcs.setAddedCount(record, addedCount);
            addTaint(record.getTaint());
            addTaint(addedCount);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.062 -0400", hash_original_method = "109C8040B092501378954582255B3673", hash_generated_method = "5C8F03A818E9CA5E6110FE1A6814358A")
        public void setBeforeText(Object record, CharSequence beforeText) {
            AccessibilityRecordCompatIcs.setBeforeText(record, beforeText);
            addTaint(record.getTaint());
            addTaint(beforeText.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.063 -0400", hash_original_method = "BD52DFCDB1D18E3D81A71744F8272351", hash_generated_method = "C763465AAE3784CBECD8DA1C28A59E95")
        public void setChecked(Object record, boolean isChecked) {
            AccessibilityRecordCompatIcs.setChecked(record, isChecked);
            addTaint(record.getTaint());
            addTaint(isChecked);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.064 -0400", hash_original_method = "7BA9A0C3B031A8D2A4A136C329BCA964", hash_generated_method = "4F5229F1CEB08F9C705AEA9FB1A14591")
        public void setClassName(Object record, CharSequence className) {
            AccessibilityRecordCompatIcs.setClassName(record, className);
            addTaint(record.getTaint());
            addTaint(className.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.065 -0400", hash_original_method = "F1EE16D13E1090ACD14D9B11E9F3D349", hash_generated_method = "335AA7F60CF9B81777557997D95A08CF")
        public void setContentDescription(Object record, CharSequence contentDescription) {
            AccessibilityRecordCompatIcs.setContentDescription(record, contentDescription);
            addTaint(record.getTaint());
            addTaint(contentDescription.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.066 -0400", hash_original_method = "8C69B4B73D3FC51261DEED6BC23C4A94", hash_generated_method = "1BD50F1D04E3936A452910563F4FCE74")
        public void setCurrentItemIndex(Object record, int currentItemIndex) {
            AccessibilityRecordCompatIcs.setCurrentItemIndex(record, currentItemIndex);
            addTaint(record.getTaint());
            addTaint(currentItemIndex);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.066 -0400", hash_original_method = "C6018A1F789E522815162DE2BFD2E76A", hash_generated_method = "E49CEDF3D2F4201F367334B267CE4AF9")
        public void setEnabled(Object record, boolean isEnabled) {
            AccessibilityRecordCompatIcs.setEnabled(record, isEnabled);
            addTaint(record.getTaint());
            addTaint(isEnabled);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.067 -0400", hash_original_method = "731C43A20B4248157CFF4E6A90BA6ACB", hash_generated_method = "76FF8582E5663C12A42D9659EE5FAABF")
        public void setFromIndex(Object record, int fromIndex) {
            AccessibilityRecordCompatIcs.setFromIndex(record, fromIndex);
            addTaint(record.getTaint());
            addTaint(fromIndex);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.068 -0400", hash_original_method = "CD49CF55168D5300B72410A3B8ED32C0", hash_generated_method = "81F719C1A6FF448B4BF4D1C79339288E")
        public void setFullScreen(Object record, boolean isFullScreen) {
            AccessibilityRecordCompatIcs.setFullScreen(record, isFullScreen);
            addTaint(record.getTaint());
            addTaint(isFullScreen);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.069 -0400", hash_original_method = "F2CD26C5C838EDD025B4D40D354837BF", hash_generated_method = "E6EE5031D8AEE13B9847C8C9D9B85F1D")
        public void setItemCount(Object record, int itemCount) {
            AccessibilityRecordCompatIcs.setItemCount(record, itemCount);
            addTaint(record.getTaint());
            addTaint(itemCount);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.069 -0400", hash_original_method = "B0E228EC678D60AF999CBBCF90005DC4", hash_generated_method = "62B810683D07C9B1273A5DD7EA7B82E2")
        public void setMaxScrollX(Object record, int maxScrollX) {
            addTaint(record.getTaint());
            addTaint(maxScrollX);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.070 -0400", hash_original_method = "6BFFE4DDD0D4E15E25FCE31267BE93D4", hash_generated_method = "9BE3A3263DFA77FEA594A55F65F88E8C")
        public void setMaxScrollY(Object record, int maxScrollY) {
            addTaint(record.getTaint());
            addTaint(maxScrollY);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.071 -0400", hash_original_method = "2EB1B6160F5E20FA1D639E3D4F5851B2", hash_generated_method = "43D67CEF966D0431A181BC210E7F1159")
        public void setParcelableData(Object record, Parcelable parcelableData) {
            AccessibilityRecordCompatIcs.setParcelableData(record, parcelableData);
            addTaint(record.getTaint());
            addTaint(parcelableData.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.071 -0400", hash_original_method = "680F59D9F36DDD7043F00930FAC1DB30", hash_generated_method = "5B9D6C86006A2A6FC9840C8785EB45B6")
        public void setPassword(Object record, boolean isPassword) {
            AccessibilityRecordCompatIcs.setPassword(record, isPassword);
            addTaint(record.getTaint());
            addTaint(isPassword);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.072 -0400", hash_original_method = "3A809745C2F04B43B84545BC92A48B5D", hash_generated_method = "0F512B7E0DE181372A41E6D802900BA1")
        public void setRemovedCount(Object record, int removedCount) {
            AccessibilityRecordCompatIcs.setRemovedCount(record, removedCount);
            addTaint(record.getTaint());
            addTaint(removedCount);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.073 -0400", hash_original_method = "924F87FF58D3CC5A5EF35035A475CFDB", hash_generated_method = "77F2AD206B0E62D4DC060E24833BA63B")
        public void setScrollX(Object record, int scrollX) {
            AccessibilityRecordCompatIcs.setScrollX(record, scrollX);
            addTaint(record.getTaint());
            addTaint(scrollX);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.073 -0400", hash_original_method = "AF8507ABF0BB78F3B8C05F5D96A45B58", hash_generated_method = "B157684E2698CB80BD3756BB875716B3")
        public void setScrollY(Object record, int scrollY) {
            AccessibilityRecordCompatIcs.setScrollY(record, scrollY);
            addTaint(record.getTaint());
            addTaint(scrollY);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.074 -0400", hash_original_method = "7720BB37EC0AC80BE51120598A64968E", hash_generated_method = "E5FA102166BB996BFA923EE3C1751D97")
        public void setScrollable(Object record, boolean scrollable) {
            AccessibilityRecordCompatIcs.setScrollable(record, scrollable);
            addTaint(record.getTaint());
            addTaint(scrollable);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.075 -0400", hash_original_method = "DD116DB6DF621B64C90116C909A19B22", hash_generated_method = "BB30491B757773D2504DB11B360C2803")
        public void setSource(Object record, View source) {
            AccessibilityRecordCompatIcs.setSource(record, source);
            addTaint(record.getTaint());
            addTaint(source.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.076 -0400", hash_original_method = "4B2B7301B207AC517FB6F6EE2CE16262", hash_generated_method = "12A283A55CDD361686455A322612071E")
        public void setToIndex(Object record, int toIndex) {
            AccessibilityRecordCompatIcs.setToIndex(record, toIndex);
            addTaint(record.getTaint());
            addTaint(toIndex);
            
            
        }

        
    }


    
    static interface AccessibilityRecordImpl {
        public Object obtain();
        public Object obtain(Object record);
        public void setSource(Object record, View source);
        public Object getSource(Object record);
        public int getWindowId(Object record);
        public boolean isChecked(Object record);
        public void setChecked(Object record, boolean isChecked);
        public boolean isEnabled(Object record);
        public void setEnabled(Object record, boolean isEnabled);
        public boolean isPassword(Object record);
        public void setPassword(Object record, boolean isPassword);
        public boolean isFullScreen(Object record);
        public void setFullScreen(Object record, boolean isFullScreen);
        public boolean isScrollable(Object record);
        public void setScrollable(Object record, boolean scrollable);
        public int getItemCount(Object record);
        public void setItemCount(Object record, int itemCount);
        public int getCurrentItemIndex(Object record);
        public void setCurrentItemIndex(Object record, int currentItemIndex);
        public int getFromIndex(Object record);
        public void setFromIndex(Object record, int fromIndex);
        public int getToIndex(Object record);
        public void setToIndex(Object record, int toIndex);
        public int getScrollX(Object record);
        public void setScrollX(Object record, int scrollX);
        public int getScrollY(Object record);
        public void setScrollY(Object record, int scrollY);
        public int getMaxScrollX(Object record);
        public void setMaxScrollX(Object record, int maxScrollX);
        public int getMaxScrollY(Object record);
        public void setMaxScrollY(Object record, int maxScrollY);
        public int getAddedCount(Object record);
        public void setAddedCount(Object record, int addedCount);
        public int getRemovedCount(Object record);
        public void setRemovedCount(Object record, int removedCount);
        public CharSequence getClassName(Object record);
        public void setClassName(Object record, CharSequence className);
        public List<CharSequence> getText(Object record);
        public CharSequence getBeforeText(Object record);
        public void setBeforeText(Object record, CharSequence beforeText);
        public CharSequence getContentDescription(Object record);
        public void setContentDescription(Object record, CharSequence contentDescription);
        public Parcelable getParcelableData(Object record);
        public void setParcelableData(Object record, Parcelable parcelableData);
        public void recycle(Object record);
    }
    
    static {
        if (Build.VERSION.SDK_INT >= 14) { 
            IMPL = new AccessibilityRecordIcsImpl();
        } else {
            IMPL = new AccessibilityRecordStubImpl();
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:53.077 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "D1D1E99F4AC4499526A983B23845B236")

    private static AccessibilityRecordImpl IMPL;
}

