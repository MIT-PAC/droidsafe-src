package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LayoutTransition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.688 -0400", hash_original_field = "39AB1186E068767124693950E5241B0C", hash_generated_field = "75E407E7333EB2D59F0ED20EAD88E34E")

    private Animator mDisappearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.688 -0400", hash_original_field = "898C2D1A5742BD7C3E8E82A9D2E0437F", hash_generated_field = "F269A266B00229E5734E5B06B519CF4D")

    private Animator mAppearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.689 -0400", hash_original_field = "1F332D66976C447496CA1B80691E0B10", hash_generated_field = "8569DC611F2B171274327A8DFA6BA137")

    private Animator mChangingAppearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.690 -0400", hash_original_field = "765E4DC7F9110BDE36ADFF990E8FCAEC", hash_generated_field = "295E17A6E98CD794E342CB0517EC6D87")

    private Animator mChangingDisappearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.691 -0400", hash_original_field = "42A198EE1914D883D37C3ED3B1135670", hash_generated_field = "A5577F39C2927B8AF67AB98D2B541767")

    private long mChangingAppearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.691 -0400", hash_original_field = "218EB6559CA33E7E919115954C4DB0D9", hash_generated_field = "463C58461ED789E13A8EEFA59D868711")

    private long mChangingDisappearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.692 -0400", hash_original_field = "80A25498D18A6710708CD4BFB8EF24DA", hash_generated_field = "B1A031389441AED70DA8674A9CDD4213")

    private long mAppearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.692 -0400", hash_original_field = "5ECCF0345DF5DEDAB0F5A39516048905", hash_generated_field = "83E0F49BD50CEA25C451F339C8D938A9")

    private long mDisappearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.693 -0400", hash_original_field = "91B6925F9416CAE38F44C8180EE00D62", hash_generated_field = "6B89F75DB8D18324FDA519C3D6E9C3E1")

    private long mAppearingDelay = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.693 -0400", hash_original_field = "A22E36387E60BA8EEB738DFDB9781A6E", hash_generated_field = "EE2346FE7169B9AB19EA56A1B913BA60")

    private long mDisappearingDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.693 -0400", hash_original_field = "AD69818355B6F5E9EB967A4A202385FA", hash_generated_field = "B72CDDC89FC836C2633888FAF590185E")

    private long mChangingAppearingDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.694 -0400", hash_original_field = "51E19A1306CC67939DEB066B90A6AA30", hash_generated_field = "A8B24D136EA5EC6890818CC10AD17C05")

    private long mChangingDisappearingDelay = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.694 -0400", hash_original_field = "D4E1B66EF88324ED6FA8088CEB4CBE14", hash_generated_field = "715370DF92240EF0021A1CA25FFC6060")

    private long mChangingAppearingStagger = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.695 -0400", hash_original_field = "C9AB7CA6788BC42432306ED5D9FA4751", hash_generated_field = "95B0E8048A3A312DC3734A9E265C8176")

    private long mChangingDisappearingStagger = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.695 -0400", hash_original_field = "E83595FF742C9B6EB99D19F9305ABBA8", hash_generated_field = "3164C261F18E7FCC582837BE79E7E946")

    private TimeInterpolator mAppearingInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.696 -0400", hash_original_field = "D1BFED2C966B3C158EF425A93E73D95C", hash_generated_field = "44480B19C903085EE0CD5A188A9C0404")

    private TimeInterpolator mDisappearingInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.696 -0400", hash_original_field = "9BB07EDE1DBE6A1B275E097543CFA633", hash_generated_field = "6AD343EAC627700E45ADD7F9BC2E498E")

    private TimeInterpolator mChangingAppearingInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.697 -0400", hash_original_field = "AB42CFE8B0A8C2974D7F84A32756AC89", hash_generated_field = "002DBF51FA8D471B18C74A9B6E24123D")

    private TimeInterpolator mChangingDisappearingInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.697 -0400", hash_original_field = "833A7AADDF3C4472D3F75449099C7417", hash_generated_field = "E1CDEDB0BCFDEF2A4DF3C7DEFC5DB240")

    private final HashMap<View, Animator> pendingAnimations = new HashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.697 -0400", hash_original_field = "1A6E910FE59BBBBACA171B049921002A", hash_generated_field = "8713B14FF07C44A33F515A732D4D8076")

    private final LinkedHashMap<View, Animator> currentChangingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.698 -0400", hash_original_field = "54075758A22D2683EE0C4649851E0018", hash_generated_field = "755F172D8CEDE1F2AF3C01713E92C67E")

    private final LinkedHashMap<View, Animator> currentAppearingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.699 -0400", hash_original_field = "0F0C1A65AE21602FD367A69818E8A1E7", hash_generated_field = "81FCC6D3A7C9183D354AEB95CEBC1072")

    private final LinkedHashMap<View, Animator> currentDisappearingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.700 -0400", hash_original_field = "1FEEE2ED7992F5B46B7D29EC9654E64D", hash_generated_field = "41A143D43A4B7FD3193B7EDB883D2AE9")

    private final HashMap<View, View.OnLayoutChangeListener> layoutChangeListenerMap = new HashMap<View, View.OnLayoutChangeListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.700 -0400", hash_original_field = "6210BD7488CCE5FE8B740760087A30E6", hash_generated_field = "62799693C20798E5E433F1B0AF6A3DC5")

    private long staggerDelay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.701 -0400", hash_original_field = "2F2828353527044AFD6820F84A8A1FAB", hash_generated_field = "F165C7B3902835B1E7EE6F9F45B1EBD6")

    private ArrayList<TransitionListener> mListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.702 -0400", hash_original_field = "57CB5A16236BA625AFCBA400CC996A11", hash_generated_field = "E61C51FC893874C4BB912FEBE4441512")

    private boolean mAnimateParentHierarchy = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.707 -0400", hash_original_method = "52DB630B34835349C84181A9ADA45542", hash_generated_method = "721A91E17F464E0314ADCE06D2B5B6F4")
    public  LayoutTransition() {
    if(defaultChangeIn == null)        
        {
            PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
            PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
            PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
            PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 1);
            PropertyValuesHolder pvhScrollX = PropertyValuesHolder.ofInt("scrollX", 0, 1);
            PropertyValuesHolder pvhScrollY = PropertyValuesHolder.ofInt("scrollY", 0, 1);
            defaultChangeIn = ObjectAnimator.ofPropertyValuesHolder((Object)null,
                    pvhLeft, pvhTop, pvhRight, pvhBottom, pvhScrollX, pvhScrollY);
            defaultChangeIn.setDuration(DEFAULT_DURATION);
            defaultChangeIn.setStartDelay(mChangingAppearingDelay);
            defaultChangeIn.setInterpolator(mChangingAppearingInterpolator);
            defaultChangeOut = defaultChangeIn.clone();
            defaultChangeOut.setStartDelay(mChangingDisappearingDelay);
            defaultChangeOut.setInterpolator(mChangingDisappearingInterpolator);
            defaultFadeIn = ObjectAnimator.ofFloat(null, "alpha", 0f, 1f);
            defaultFadeIn.setDuration(DEFAULT_DURATION);
            defaultFadeIn.setStartDelay(mAppearingDelay);
            defaultFadeIn.setInterpolator(mAppearingInterpolator);
            defaultFadeOut = ObjectAnimator.ofFloat(null, "alpha", 1f, 0f);
            defaultFadeOut.setDuration(DEFAULT_DURATION);
            defaultFadeOut.setStartDelay(mDisappearingDelay);
            defaultFadeOut.setInterpolator(mDisappearingInterpolator);
        } 
        mChangingAppearingAnim = defaultChangeIn;
        mChangingDisappearingAnim = defaultChangeOut;
        mAppearingAnim = defaultFadeIn;
        mDisappearingAnim = defaultFadeOut;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.711 -0400", hash_original_method = "24394BA80BA94B39DCA5B438DC3EBDB1", hash_generated_method = "CF9B4395D785358863CAB9605D225CA9")
    public void setDuration(long duration) {
        mChangingAppearingDuration = duration;
        mChangingDisappearingDuration = duration;
        mAppearingDuration = duration;
        mDisappearingDuration = duration;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.719 -0400", hash_original_method = "939FBD8B4C5590BFCAA9E14AEC15ED50", hash_generated_method = "A5FB537129437D22F2C6F067E57B2516")
    public void setStartDelay(int transitionType, long delay) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
        mChangingAppearingDelay = delay;
        break;
        case CHANGE_DISAPPEARING:
        mChangingDisappearingDelay = delay;
        break;
        case APPEARING:
        mAppearingDelay = delay;
        break;
        case DISAPPEARING:
        mDisappearingDelay = delay;
        break;
}
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.723 -0400", hash_original_method = "3F88CD33B6864BEBC3B576EB6504FB35", hash_generated_method = "F1540425F24E444073AC6545AF32D294")
    public long getStartDelay(int transitionType) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
        long var360F5CC70C78CF56662480A12D3AC783_510114710 = (mChangingAppearingDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1902504970 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1902504970;
        case CHANGE_DISAPPEARING:
        long var56AF8CD96606A75F6C069B0B40215186_366905885 = (mChangingDisappearingDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1677355014 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1677355014;
        case APPEARING:
        long var0F6CE604EBA8EF8E890C00A18FB1602E_564041770 = (mAppearingDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1918479415 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1918479415;
        case DISAPPEARING:
        long var8D74CD052B3BED431DA78EAD1063B31D_899891859 = (mDisappearingDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1642148163 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1642148163;
}        long varCFCD208495D565EF66E7DFF9F98764DA_825903062 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1683924924 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1683924924;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.728 -0400", hash_original_method = "2851CBF3AA331995F771441E9F6D0AAD", hash_generated_method = "7657A96A3B56109E70AF47B61010EB14")
    public void setDuration(int transitionType, long duration) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
        mChangingAppearingDuration = duration;
        break;
        case CHANGE_DISAPPEARING:
        mChangingDisappearingDuration = duration;
        break;
        case APPEARING:
        mAppearingDuration = duration;
        break;
        case DISAPPEARING:
        mDisappearingDuration = duration;
        break;
}
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.731 -0400", hash_original_method = "F259A86CD3BB3A6D515EAAF2335DC6DD", hash_generated_method = "D5CAF6BD9684E907D4095770B6406CAA")
    public long getDuration(int transitionType) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
        long var360F5CC70C78CF56662480A12D3AC783_1683848967 = (mChangingAppearingDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_187092811 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_187092811;
        case CHANGE_DISAPPEARING:
        long var56AF8CD96606A75F6C069B0B40215186_416799620 = (mChangingDisappearingDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_797193804 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_797193804;
        case APPEARING:
        long var0F6CE604EBA8EF8E890C00A18FB1602E_1324092031 = (mAppearingDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1781429797 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1781429797;
        case DISAPPEARING:
        long var8D74CD052B3BED431DA78EAD1063B31D_1399947988 = (mDisappearingDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1996342715 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1996342715;
}        long varCFCD208495D565EF66E7DFF9F98764DA_1591310545 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1082227866 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1082227866;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.735 -0400", hash_original_method = "DB3710D74B2FBFD7C44693C4FBA40808", hash_generated_method = "0F08A1C25BA5B8F0A6C96E94A8EBA372")
    public void setStagger(int transitionType, long duration) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
        mChangingAppearingStagger = duration;
        break;
        case CHANGE_DISAPPEARING:
        mChangingDisappearingStagger = duration;
        break;
}
        
        
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.741 -0400", hash_original_method = "70FCFF77D9C405B5FA9E6B4579BF3D8B", hash_generated_method = "7876A2C8D9059D8A5E62D913DB9FC8D9")
    public long getStagger(int transitionType) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
        long varB2B60FEA57CF92DB5EA1A0DECA4E600C_147519303 = (mChangingAppearingStagger);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1433048820 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1433048820;
        case CHANGE_DISAPPEARING:
        long varDB85923B2CE152F34B29DE18C7525580_967195333 = (mChangingDisappearingStagger);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_502298986 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_502298986;
}        long varCFCD208495D565EF66E7DFF9F98764DA_1985607692 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2045415970 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2045415970;
        
        
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.747 -0400", hash_original_method = "2AD5234EB4F80ED9C0D5C1F0BD7735E5", hash_generated_method = "E83B3F47CAEB350521F19BC35F2C70CF")
    public void setInterpolator(int transitionType, TimeInterpolator interpolator) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
        mChangingAppearingInterpolator = interpolator;
        break;
        case CHANGE_DISAPPEARING:
        mChangingDisappearingInterpolator = interpolator;
        break;
        case APPEARING:
        mAppearingInterpolator = interpolator;
        break;
        case DISAPPEARING:
        mDisappearingInterpolator = interpolator;
        break;
}
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.749 -0400", hash_original_method = "11C2A17826922B819D4ABA31B32AF7FD", hash_generated_method = "BACD3F6CAF7CD3A5E0A1B252DAFCAF96")
    public TimeInterpolator getInterpolator(int transitionType) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
TimeInterpolator var331568037575099CFB8611C266B374C3_1096190048 =         mChangingAppearingInterpolator;
        var331568037575099CFB8611C266B374C3_1096190048.addTaint(taint);
        return var331568037575099CFB8611C266B374C3_1096190048;
        case CHANGE_DISAPPEARING:
TimeInterpolator varAA6D111352CA2F502EF88A0438C0A64B_1677000170 =         mChangingDisappearingInterpolator;
        varAA6D111352CA2F502EF88A0438C0A64B_1677000170.addTaint(taint);
        return varAA6D111352CA2F502EF88A0438C0A64B_1677000170;
        case APPEARING:
TimeInterpolator var03E8E061C6EE0F96761AF54D0B031A0D_2028856029 =         mAppearingInterpolator;
        var03E8E061C6EE0F96761AF54D0B031A0D_2028856029.addTaint(taint);
        return var03E8E061C6EE0F96761AF54D0B031A0D_2028856029;
        case DISAPPEARING:
TimeInterpolator varCFF24B6F2E2CCEBC82FB2CBB95DACE21_1111023346 =         mDisappearingInterpolator;
        varCFF24B6F2E2CCEBC82FB2CBB95DACE21_1111023346.addTaint(taint);
        return varCFF24B6F2E2CCEBC82FB2CBB95DACE21_1111023346;
}TimeInterpolator var540C13E9E156B687226421B24F2DF178_2060620802 =         null;
        var540C13E9E156B687226421B24F2DF178_2060620802.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2060620802;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.752 -0400", hash_original_method = "1CE02B172FBE4A7CE10D1F87669E47EA", hash_generated_method = "23274A8F6E7DE274B00CDBF4AEE41ED6")
    public void setAnimator(int transitionType, Animator animator) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
        mChangingAppearingAnim = animator;
        break;
        case CHANGE_DISAPPEARING:
        mChangingDisappearingAnim = animator;
        break;
        case APPEARING:
        mAppearingAnim = animator;
        break;
        case DISAPPEARING:
        mDisappearingAnim = animator;
        break;
}
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.757 -0400", hash_original_method = "FF737FAA09DE0C7945DD1E6E302C4C89", hash_generated_method = "415711EB0476EB8A765A1EE33D8D49C9")
    public Animator getAnimator(int transitionType) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
Animator var0D29585A57B5CDCFCA43902220DCF7B0_736407622 =         mChangingAppearingAnim;
        var0D29585A57B5CDCFCA43902220DCF7B0_736407622.addTaint(taint);
        return var0D29585A57B5CDCFCA43902220DCF7B0_736407622;
        case CHANGE_DISAPPEARING:
Animator varF4E0372C7A803D49F0494F21921B1DA0_807982610 =         mChangingDisappearingAnim;
        varF4E0372C7A803D49F0494F21921B1DA0_807982610.addTaint(taint);
        return varF4E0372C7A803D49F0494F21921B1DA0_807982610;
        case APPEARING:
Animator varABE09B1369CBE743F2029BB63821B780_159503164 =         mAppearingAnim;
        varABE09B1369CBE743F2029BB63821B780_159503164.addTaint(taint);
        return varABE09B1369CBE743F2029BB63821B780_159503164;
        case DISAPPEARING:
Animator var91452894FB20F2545760279496A05CEA_1678614044 =         mDisappearingAnim;
        var91452894FB20F2545760279496A05CEA_1678614044.addTaint(taint);
        return var91452894FB20F2545760279496A05CEA_1678614044;
}Animator var540C13E9E156B687226421B24F2DF178_2134248712 =         null;
        var540C13E9E156B687226421B24F2DF178_2134248712.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2134248712;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.772 -0400", hash_original_method = "388160589FFEE2126FAAE5CBAFC89998", hash_generated_method = "2B6A02E0C6A11C1C3AEB7AA202D5A9CC")
    private void runChangeTransition(final ViewGroup parent, View newView, final int changeReason) {
        addTaint(changeReason);
        addTaint(newView.getTaint());
        addTaint(parent.getTaint());
        Animator baseAnimator = (changeReason == APPEARING) ?
                mChangingAppearingAnim : mChangingDisappearingAnim;
    if(baseAnimator == null)        
        {
            return;
        } 
        staggerDelay = 0;
        final long duration = (changeReason == APPEARING) ?
                mChangingAppearingDuration : mChangingDisappearingDuration;
        final ViewTreeObserver observer = parent.getViewTreeObserver();
    if(!observer.isAlive())        
        {
            return;
        } 
        int numChildren = parent.getChildCount();
for(int i = 0;i < numChildren;++i)
        {
            final View child = parent.getChildAt(i);
    if(child != newView)            
            {
                setupChangeAnimation(parent, changeReason, baseAnimator, duration, child);
            } 
        } 
    if(mAnimateParentHierarchy)        
        {
            Animator parentAnimator = (changeReason == APPEARING) ?
                    defaultChangeIn : defaultChangeOut;
            ViewGroup tempParent = parent;
            while
(tempParent != null)            
            {
                ViewParent parentParent = tempParent.getParent();
    if(parentParent instanceof ViewGroup)                
                {
                    setupChangeAnimation((ViewGroup)parentParent, changeReason, parentAnimator,
                            duration, tempParent);
                    tempParent = (ViewGroup) parentParent;
                } 
                else
                {
                    tempParent = null;
                } 
            } 
        } 
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.769 -0400", hash_original_method = "6C01974BA3CD333428484527C9FBE54F", hash_generated_method = "509376B63E3B0360AFEBA74835C4F2B7")
        public boolean onPreDraw() {
            
            parent.getViewTreeObserver().removeOnPreDrawListener(this);
            int count = layoutChangeListenerMap.size();
    if(count > 0)            
            {
                Collection<View> views = layoutChangeListenerMap.keySet();
for(View view : views)
                {
                    View.OnLayoutChangeListener listener = layoutChangeListenerMap.get(view);
                    view.removeOnLayoutChangeListener(listener);
                } 
            } 
            layoutChangeListenerMap.clear();
            boolean varB326B5062B2F0E69046810717534CB09_556803046 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_847488965 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_847488965;
            
            
            
            
                    
                    
                        
                        
                    
                
            
            
        }
});
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.778 -0400", hash_original_method = "5ECFD2D430BE870F40C042D01FD8A2D6", hash_generated_method = "CEE41014B49B701489653EF4BEF3638A")
    public void setAnimateParentHierarchy(boolean animateParentHierarchy) {
        mAnimateParentHierarchy = animateParentHierarchy;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.799 -0400", hash_original_method = "108854515942B7EF6A63499B84E31466", hash_generated_method = "347EB9A3B6AF308D4287D727B9F3352F")
    private void setupChangeAnimation(final ViewGroup parent, final int changeReason,
            Animator baseAnimator, final long duration, final View child) {
        addTaint(child.getTaint());
        addTaint(duration);
        addTaint(baseAnimator.getTaint());
        addTaint(changeReason);
        addTaint(parent.getTaint());
    if(layoutChangeListenerMap.get(child) != null)        
        {
            return;
        } 
        final Animator anim = baseAnimator.clone();
        anim.setTarget(child);
        anim.setupStartValues();
        Animator currentAnimation = pendingAnimations.get(child);
    if(currentAnimation != null)        
        {
            currentAnimation.cancel();
            pendingAnimations.remove(child);
        } 
        pendingAnimations.put(child, anim);
        ValueAnimator pendingAnimRemover = ValueAnimator.ofFloat(0f, 1f).
                setDuration(duration + 100);
        pendingAnimRemover.addListener(new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.783 -0400", hash_original_method = "81B18D5FBD0385E26F1E055D2C44BFFA", hash_generated_method = "1079FCB0C15F1BC3A19D8110EC8505CE")
        @Override
        public void onAnimationEnd(Animator animation) {
            
            addTaint(animation.getTaint());
            pendingAnimations.remove(child);
            
            
        }
});
        pendingAnimRemover.start();
        final View.OnLayoutChangeListener listener = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View v, int left, int top, int right, int bottom,
                    int oldLeft, int oldTop, int oldRight, int oldBottom) {
                anim.setupEndValues();
                if (anim instanceof ValueAnimator) {
                    boolean valuesDiffer = false;
                    ValueAnimator valueAnim = (ValueAnimator)anim;
                    PropertyValuesHolder[] oldValues = valueAnim.getValues();
                    for (int i = 0; i < oldValues.length; ++i) {
                        PropertyValuesHolder pvh = oldValues[i];
                        KeyframeSet keyframeSet = pvh.mKeyframeSet;
                        if (keyframeSet.mFirstKeyframe == null ||
                                keyframeSet.mLastKeyframe == null ||
                                !keyframeSet.mFirstKeyframe.getValue().equals(
                                keyframeSet.mLastKeyframe.getValue())) {
                            valuesDiffer = true;
                        }
                    }
                    if (!valuesDiffer) {
                        return;
                    }
                }
                long startDelay;
                if (changeReason == APPEARING) {
                    startDelay = mChangingAppearingDelay + staggerDelay;
                    staggerDelay += mChangingAppearingStagger;
                } else {
                    startDelay = mChangingDisappearingDelay + staggerDelay;
                    staggerDelay += mChangingDisappearingStagger;
                }
                anim.setStartDelay(startDelay);
                anim.setDuration(duration);
                Animator prevAnimation = currentChangingAnimations.get(child);
                if (prevAnimation != null) {
                    prevAnimation.cancel();
                }
                Animator pendingAnimation = pendingAnimations.get(child);
                if (pendingAnimation != null) {
                    pendingAnimations.remove(child);
                }
                currentChangingAnimations.put(child, anim);
                parent.requestTransitionStart(LayoutTransition.this);
                child.removeOnLayoutChangeListener(this);
                layoutChangeListenerMap.remove(child);
            }
        };
        anim.addListener(new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.790 -0400", hash_original_method = "E2B93FC024F741AE866ED6DC48631B6A", hash_generated_method = "E0A2CCFEBA9C8C648165E24C5108227E")
        @Override
        public void onAnimationStart(Animator animator) {
            
            addTaint(animator.getTaint());
    if(mListeners != null)            
            {
for(TransitionListener listener : mListeners)
                {
                    listener.startTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                } 
            } 
            
            
                    
                        
                                
                                        
                    
                
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.794 -0400", hash_original_method = "06655B4777E7383270776E7CEC1CCF7E", hash_generated_method = "8D5917F49C43A6647740D8F4530A3A1A")
        @Override
        public void onAnimationCancel(Animator animator) {
            
            addTaint(animator.getTaint());
            child.removeOnLayoutChangeListener(listener);
            layoutChangeListenerMap.remove(child);
            
            
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.797 -0400", hash_original_method = "DE5B5D0FB75885026A5DD6EBE7BC56A2", hash_generated_method = "91D9FC1C871CF46CE1C4B14181A8D322")
        @Override
        public void onAnimationEnd(Animator animator) {
            
            addTaint(animator.getTaint());
            currentChangingAnimations.remove(child);
    if(mListeners != null)            
            {
for(TransitionListener listener : mListeners)
                {
                    listener.endTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                } 
            } 
            
            
            
                    
                        
                                
                                        
                    
                
        }
});
        child.addOnLayoutChangeListener(listener);
        layoutChangeListenerMap.put(child, listener);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.802 -0400", hash_original_method = "7222BE89A56886A0CF62DC8766C00475", hash_generated_method = "58EB62EC444DDE7276F344F5BFB5B913")
    public void startChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
for(Animator anim : currentAnimCopy.values())
        {
    if(anim instanceof ObjectAnimator)            
            {
                ((ObjectAnimator) anim).setCurrentPlayTime(0);
            } 
            anim.start();
        } 
        
        
                
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.804 -0400", hash_original_method = "7BA742550F1E1298AB8FE77F45C4383D", hash_generated_method = "18E4A07428D8738302E55F2CA66BB0BD")
    public void endChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
for(Animator anim : currentAnimCopy.values())
        {
            anim.start();
            anim.end();
        } 
        
        
                
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.807 -0400", hash_original_method = "8C9364165F532DD8BD43415668542398", hash_generated_method = "0229F0AC528170CB687322A2004BC197")
    public boolean isChangingLayout() {
        boolean var8CFDE1B1575D1F7869D0994A7B5C63D5_899639787 = ((currentChangingAnimations.size() > 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_603377117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_603377117;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.809 -0400", hash_original_method = "7F683046BB72ECC23A172B1D3B81B266", hash_generated_method = "C57A6D69EB8F7A05936F7C289A65088D")
    public boolean isRunning() {
        boolean var89C9AB021B50A13092EFF1DF3FF89A96_1843919967 = ((currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 ||
                currentDisappearingAnimations.size() > 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241933581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241933581;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.812 -0400", hash_original_method = "2E46A59670A61A0AF64FD97BDAF7B728", hash_generated_method = "1D55E8979FD40241915B035DFE60288E")
    public void cancel() {
    if(currentChangingAnimations.size() > 0)        
        {
            LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
for(Animator anim : currentAnimCopy.values())
            {
                anim.cancel();
            } 
            currentChangingAnimations.clear();
        } 
    if(currentAppearingAnimations.size() > 0)        
        {
            LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
for(Animator anim : currentAnimCopy.values())
            {
                anim.end();
            } 
            currentAppearingAnimations.clear();
        } 
    if(currentDisappearingAnimations.size() > 0)        
        {
            LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
for(Animator anim : currentAnimCopy.values())
            {
                anim.end();
            } 
            currentDisappearingAnimations.clear();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.819 -0400", hash_original_method = "19B870791205108BA3B602A2E8CB5138", hash_generated_method = "E0E967CC19174281F40087590A5817C5")
    public void cancel(int transitionType) {
        addTaint(transitionType);
switch(transitionType){
        case CHANGE_APPEARING:
        case CHANGE_DISAPPEARING:
    if(currentChangingAnimations.size() > 0)        
        {
            LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
for(Animator anim : currentAnimCopy.values())
            {
                anim.cancel();
            } 
            currentChangingAnimations.clear();
        } 
        break;
        case APPEARING:
    if(currentAppearingAnimations.size() > 0)        
        {
            LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
for(Animator anim : currentAnimCopy.values())
            {
                anim.end();
            } 
            currentAppearingAnimations.clear();
        } 
        break;
        case DISAPPEARING:
    if(currentDisappearingAnimations.size() > 0)        
        {
            LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
for(Animator anim : currentAnimCopy.values())
            {
                anim.end();
            } 
            currentDisappearingAnimations.clear();
        } 
        break;
}
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.826 -0400", hash_original_method = "071036D6A0EA050ACF09A35752DC1D52", hash_generated_method = "B6472EEAC8C7288AA00336CA32373DF4")
    private void runAppearingTransition(final ViewGroup parent, final View child) {
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        Animator currentAnimation = currentDisappearingAnimations.get(child);
    if(currentAnimation != null)        
        {
            currentAnimation.cancel();
        } 
    if(mAppearingAnim == null)        
        {
    if(mListeners != null)            
            {
for(TransitionListener listener : mListeners)
                {
                    listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                } 
            } 
            return;
        } 
        Animator anim = mAppearingAnim.clone();
        anim.setTarget(child);
        anim.setStartDelay(mAppearingDelay);
        anim.setDuration(mAppearingDuration);
    if(anim instanceof ObjectAnimator)        
        {
            ((ObjectAnimator) anim).setCurrentPlayTime(0);
        } 
    if(mListeners != null)        
        {
            anim.addListener(new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.824 -0400", hash_original_method = "494D571A7E2D39F79DD71B48D4E2ACB8", hash_generated_method = "63635027932472A32EB56E028843331F")
        @Override
        public void onAnimationEnd(Animator anim) {
            
            addTaint(anim.getTaint());
            currentAppearingAnimations.remove(child);
for(TransitionListener listener : mListeners)
            {
                listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
            } 
            
            
            
                        
                    
        }
});
        } 
        currentAppearingAnimations.put(child, anim);
        anim.start();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.835 -0400", hash_original_method = "202CDBACC5F0926CC1D7E1540267464D", hash_generated_method = "F758BEC6484E50E4E978A21D5853F315")
    private void runDisappearingTransition(final ViewGroup parent, final View child) {
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        Animator currentAnimation = currentAppearingAnimations.get(child);
    if(currentAnimation != null)        
        {
            currentAnimation.cancel();
        } 
    if(mDisappearingAnim == null)        
        {
    if(mListeners != null)            
            {
for(TransitionListener listener : mListeners)
                {
                    listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                } 
            } 
            return;
        } 
        Animator anim = mDisappearingAnim.clone();
        anim.setStartDelay(mDisappearingDelay);
        anim.setDuration(mDisappearingDuration);
        anim.setTarget(child);
    if(mListeners != null)        
        {
            anim.addListener(new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.833 -0400", hash_original_method = "29C17A3026C40266B26AB145A51034B4", hash_generated_method = "CC89B6A493F71D7A7D42EC97958C5C2A")
        @Override
        public void onAnimationEnd(Animator anim) {
            
            addTaint(anim.getTaint());
            currentDisappearingAnimations.remove(child);
for(TransitionListener listener : mListeners)
            {
                listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
            } 
            
            
            
                        
                    
        }
});
        } 
    if(anim instanceof ObjectAnimator)        
        {
            ((ObjectAnimator) anim).setCurrentPlayTime(0);
        } 
        currentDisappearingAnimations.put(child, anim);
        anim.start();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.844 -0400", hash_original_method = "05533C05F33D5C5B655A5BABA4CC6F65", hash_generated_method = "9006C296C31DA364D85CE38CD4B03B17")
    public void addChild(ViewGroup parent, View child) {
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        cancel(DISAPPEARING);
        cancel(CHANGE_APPEARING);
    if(mListeners != null)        
        {
for(TransitionListener listener : mListeners)
            {
                listener.startTransition(this, parent, child, APPEARING);
            } 
        } 
        runChangeTransition(parent, child, APPEARING);
        runAppearingTransition(parent, child);
        
        
        
        
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.846 -0400", hash_original_method = "5867E97EE566113A4AD2D7416A9B4CB1", hash_generated_method = "38BEB20D0EC47F8ABABFA70422C181EE")
    public void showChild(ViewGroup parent, View child) {
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        addChild(parent, child);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.849 -0400", hash_original_method = "E23F457F66AC508EC3728A00193F4832", hash_generated_method = "869D8AE3398CB57F7C69061799E703A3")
    public void removeChild(ViewGroup parent, View child) {
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        cancel(APPEARING);
        cancel(CHANGE_DISAPPEARING);
    if(mListeners != null)        
        {
for(TransitionListener listener : mListeners)
            {
                listener.startTransition(this, parent, child, DISAPPEARING);
            } 
        } 
        runChangeTransition(parent, child, DISAPPEARING);
        runDisappearingTransition(parent, child);
        
        
        
        
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.851 -0400", hash_original_method = "59CF94EEC1336BEEB8FFF5467E6ED5F9", hash_generated_method = "85C90B8BAF899E593B220CBF90237093")
    public void hideChild(ViewGroup parent, View child) {
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        removeChild(parent, child);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.853 -0400", hash_original_method = "167EED27AB5F7469F2545513C43EBDC4", hash_generated_method = "A9FB58B1412AB9DB62334609B1D7CB5C")
    public void addTransitionListener(TransitionListener listener) {
        addTaint(listener.getTaint());
    if(mListeners == null)        
        {
            mListeners = new ArrayList<TransitionListener>();
        } 
        mListeners.add(listener);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.855 -0400", hash_original_method = "CD0DE6419C69039B8FDEE8C2D5BC497D", hash_generated_method = "9546D9F32DC5F91E191823FA4922C6C0")
    public void removeTransitionListener(TransitionListener listener) {
        addTaint(listener.getTaint());
    if(mListeners == null)        
        {
            return;
        } 
        mListeners.remove(listener);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.856 -0400", hash_original_method = "F0DD3EC0CE94CE6304D7C3009A3E39A6", hash_generated_method = "E36FE0FBABB5B5CCDA285DAD01DBFE2B")
    public List<TransitionListener> getTransitionListeners() {
List<TransitionListener> var6F226E74DAC534764C2244A2BF49F27C_547184988 =         mListeners;
        var6F226E74DAC534764C2244A2BF49F27C_547184988.addTaint(taint);
        return var6F226E74DAC534764C2244A2BF49F27C_547184988;
        
        
    }

    
    public interface TransitionListener {

        
        public void startTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);

        
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.857 -0400", hash_original_field = "D65A82112F44124A2B9FDE00A6246728", hash_generated_field = "E63A0521AAA8C6DC4279BA44E098FD23")

    public static final int CHANGE_APPEARING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.858 -0400", hash_original_field = "6F62B99E30E6B4CA586C12E8B13A3B4A", hash_generated_field = "A5E247EB4D6439D9A98E49F907931252")

    public static final int CHANGE_DISAPPEARING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.859 -0400", hash_original_field = "1C2C691552DB12B6637FB16180CB8DEE", hash_generated_field = "F22B7CC5AA7D7298C87C59E48B6986CB")

    public static final int APPEARING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.860 -0400", hash_original_field = "26D6A6E008A00E881DA7073368B3FBCA", hash_generated_field = "2B4B660177B7589D2F5A7A330CB80759")

    public static final int DISAPPEARING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.860 -0400", hash_original_field = "F62AE2A917606476AA59A24B61225594", hash_generated_field = "F23425A4D82261A0713821E518F1C782")

    private static ObjectAnimator defaultChangeIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.861 -0400", hash_original_field = "8FE2012C5D3B66F186AE3B5608F5506B", hash_generated_field = "383D2DB6CC8BE4F70A8FC6AE24EF0892")

    private static ObjectAnimator defaultChangeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.863 -0400", hash_original_field = "9AB47D0B11CFD6785DD53FD6A9B89AC3", hash_generated_field = "9FE642298321DB1BFB3B90AC8C413400")

    private static ObjectAnimator defaultFadeIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.864 -0400", hash_original_field = "32DE7577E5C8E88AE24A2E7B696BED9F", hash_generated_field = "25D149E4F7D04D3FBA535A38951E6CA0")

    private static ObjectAnimator defaultFadeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.865 -0400", hash_original_field = "2588F8D6DA58076995259889823B1880", hash_generated_field = "B0EA698E636B3BDA7398DDB39E975802")

    private static long DEFAULT_DURATION = 300;
}

