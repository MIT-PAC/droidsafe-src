package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.244 -0400", hash_original_field = "39AB1186E068767124693950E5241B0C", hash_generated_field = "75E407E7333EB2D59F0ED20EAD88E34E")

    private Animator mDisappearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.244 -0400", hash_original_field = "898C2D1A5742BD7C3E8E82A9D2E0437F", hash_generated_field = "F269A266B00229E5734E5B06B519CF4D")

    private Animator mAppearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.244 -0400", hash_original_field = "1F332D66976C447496CA1B80691E0B10", hash_generated_field = "8569DC611F2B171274327A8DFA6BA137")

    private Animator mChangingAppearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.245 -0400", hash_original_field = "765E4DC7F9110BDE36ADFF990E8FCAEC", hash_generated_field = "295E17A6E98CD794E342CB0517EC6D87")

    private Animator mChangingDisappearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.245 -0400", hash_original_field = "42A198EE1914D883D37C3ED3B1135670", hash_generated_field = "A5577F39C2927B8AF67AB98D2B541767")

    private long mChangingAppearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.245 -0400", hash_original_field = "218EB6559CA33E7E919115954C4DB0D9", hash_generated_field = "463C58461ED789E13A8EEFA59D868711")

    private long mChangingDisappearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.246 -0400", hash_original_field = "80A25498D18A6710708CD4BFB8EF24DA", hash_generated_field = "B1A031389441AED70DA8674A9CDD4213")

    private long mAppearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.246 -0400", hash_original_field = "5ECCF0345DF5DEDAB0F5A39516048905", hash_generated_field = "83E0F49BD50CEA25C451F339C8D938A9")

    private long mDisappearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.246 -0400", hash_original_field = "91B6925F9416CAE38F44C8180EE00D62", hash_generated_field = "6B89F75DB8D18324FDA519C3D6E9C3E1")

    private long mAppearingDelay = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.246 -0400", hash_original_field = "A22E36387E60BA8EEB738DFDB9781A6E", hash_generated_field = "EE2346FE7169B9AB19EA56A1B913BA60")

    private long mDisappearingDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.247 -0400", hash_original_field = "AD69818355B6F5E9EB967A4A202385FA", hash_generated_field = "B72CDDC89FC836C2633888FAF590185E")

    private long mChangingAppearingDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.247 -0400", hash_original_field = "51E19A1306CC67939DEB066B90A6AA30", hash_generated_field = "A8B24D136EA5EC6890818CC10AD17C05")

    private long mChangingDisappearingDelay = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.247 -0400", hash_original_field = "D4E1B66EF88324ED6FA8088CEB4CBE14", hash_generated_field = "715370DF92240EF0021A1CA25FFC6060")

    private long mChangingAppearingStagger = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.247 -0400", hash_original_field = "C9AB7CA6788BC42432306ED5D9FA4751", hash_generated_field = "95B0E8048A3A312DC3734A9E265C8176")

    private long mChangingDisappearingStagger = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.248 -0400", hash_original_field = "E83595FF742C9B6EB99D19F9305ABBA8", hash_generated_field = "3164C261F18E7FCC582837BE79E7E946")

    private TimeInterpolator mAppearingInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.248 -0400", hash_original_field = "D1BFED2C966B3C158EF425A93E73D95C", hash_generated_field = "44480B19C903085EE0CD5A188A9C0404")

    private TimeInterpolator mDisappearingInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.248 -0400", hash_original_field = "9BB07EDE1DBE6A1B275E097543CFA633", hash_generated_field = "6AD343EAC627700E45ADD7F9BC2E498E")

    private TimeInterpolator mChangingAppearingInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.249 -0400", hash_original_field = "AB42CFE8B0A8C2974D7F84A32756AC89", hash_generated_field = "002DBF51FA8D471B18C74A9B6E24123D")

    private TimeInterpolator mChangingDisappearingInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.249 -0400", hash_original_field = "833A7AADDF3C4472D3F75449099C7417", hash_generated_field = "E1CDEDB0BCFDEF2A4DF3C7DEFC5DB240")

    private final HashMap<View, Animator> pendingAnimations = new HashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.249 -0400", hash_original_field = "1A6E910FE59BBBBACA171B049921002A", hash_generated_field = "8713B14FF07C44A33F515A732D4D8076")

    private final LinkedHashMap<View, Animator> currentChangingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.249 -0400", hash_original_field = "54075758A22D2683EE0C4649851E0018", hash_generated_field = "755F172D8CEDE1F2AF3C01713E92C67E")

    private final LinkedHashMap<View, Animator> currentAppearingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.250 -0400", hash_original_field = "0F0C1A65AE21602FD367A69818E8A1E7", hash_generated_field = "81FCC6D3A7C9183D354AEB95CEBC1072")

    private final LinkedHashMap<View, Animator> currentDisappearingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.250 -0400", hash_original_field = "1FEEE2ED7992F5B46B7D29EC9654E64D", hash_generated_field = "41A143D43A4B7FD3193B7EDB883D2AE9")

    private final HashMap<View, View.OnLayoutChangeListener> layoutChangeListenerMap = new HashMap<View, View.OnLayoutChangeListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.250 -0400", hash_original_field = "6210BD7488CCE5FE8B740760087A30E6", hash_generated_field = "62799693C20798E5E433F1B0AF6A3DC5")

    private long staggerDelay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.250 -0400", hash_original_field = "2F2828353527044AFD6820F84A8A1FAB", hash_generated_field = "F165C7B3902835B1E7EE6F9F45B1EBD6")

    private ArrayList<TransitionListener> mListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.251 -0400", hash_original_field = "57CB5A16236BA625AFCBA400CC996A11", hash_generated_field = "E61C51FC893874C4BB912FEBE4441512")

    private boolean mAnimateParentHierarchy = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.254 -0400", hash_original_method = "52DB630B34835349C84181A9ADA45542", hash_generated_method = "BE59AB7B3199D17BC1ED22539DEF2B05")
    public  LayoutTransition() {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.256 -0400", hash_original_method = "24394BA80BA94B39DCA5B438DC3EBDB1", hash_generated_method = "CF9B4395D785358863CAB9605D225CA9")
    public void setDuration(long duration) {
        mChangingAppearingDuration = duration;
        mChangingDisappearingDuration = duration;
        mAppearingDuration = duration;
        mDisappearingDuration = duration;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.259 -0400", hash_original_method = "939FBD8B4C5590BFCAA9E14AEC15ED50", hash_generated_method = "BCE6354327899DE2956D4D80C0566F68")
    public void setStartDelay(int transitionType, long delay) {
        
        mChangingAppearingDelay = delay;
        
        
        mChangingDisappearingDelay = delay;
        
        
        mAppearingDelay = delay;
        
        
        mDisappearingDelay = delay;
        
        addTaint(transitionType);
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.261 -0400", hash_original_method = "3F88CD33B6864BEBC3B576EB6504FB35", hash_generated_method = "ACB45D4A31F7E3668138D35B804B9D9C")
    public long getStartDelay(int transitionType) {
        addTaint(transitionType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_39973305 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_39973305;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.263 -0400", hash_original_method = "2851CBF3AA331995F771441E9F6D0AAD", hash_generated_method = "93E3AFDD083BDB202331DF6E211BA063")
    public void setDuration(int transitionType, long duration) {
        
        mChangingAppearingDuration = duration;
        
        
        mChangingDisappearingDuration = duration;
        
        
        mAppearingDuration = duration;
        
        
        mDisappearingDuration = duration;
        
        addTaint(transitionType);
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.267 -0400", hash_original_method = "F259A86CD3BB3A6D515EAAF2335DC6DD", hash_generated_method = "88FD67F82124C756CE94FC23808A8C53")
    public long getDuration(int transitionType) {
        addTaint(transitionType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_883607429 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_883607429;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.270 -0400", hash_original_method = "DB3710D74B2FBFD7C44693C4FBA40808", hash_generated_method = "D9C6245F1664A3D7DBFC6A5958CE4B39")
    public void setStagger(int transitionType, long duration) {
        
        mChangingAppearingStagger = duration;
        
        
        mChangingDisappearingStagger = duration;
        
        addTaint(transitionType);
        
        
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.272 -0400", hash_original_method = "70FCFF77D9C405B5FA9E6B4579BF3D8B", hash_generated_method = "3FABE9F94785DD275C5F92465E25B74E")
    public long getStagger(int transitionType) {
        addTaint(transitionType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1115177144 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1115177144;
        
        
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.274 -0400", hash_original_method = "2AD5234EB4F80ED9C0D5C1F0BD7735E5", hash_generated_method = "02FFFA304AEDF303F30ED9BE4A859608")
    public void setInterpolator(int transitionType, TimeInterpolator interpolator) {
        
        mChangingAppearingInterpolator = interpolator;
        
        
        mChangingDisappearingInterpolator = interpolator;
        
        
        mAppearingInterpolator = interpolator;
        
        
        mDisappearingInterpolator = interpolator;
        
        addTaint(transitionType);
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.290 -0400", hash_original_method = "11C2A17826922B819D4ABA31B32AF7FD", hash_generated_method = "A6A2762226E729668F1B8288C72B81DB")
    public TimeInterpolator getInterpolator(int transitionType) {
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_260013283 = null; 
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1747955289 = null; 
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1017597058 = null; 
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1755463504 = null; 
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_913050506 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_260013283 = mChangingAppearingInterpolator;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1747955289 = mChangingDisappearingInterpolator;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1017597058 = mAppearingInterpolator;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1755463504 = mDisappearingInterpolator;
        
        varB4EAC82CA7396A68D541C85D26508E83_913050506 = null;
        addTaint(transitionType);
        TimeInterpolator varA7E53CE21691AB073D9660D615818899_2143875852; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2143875852 = varB4EAC82CA7396A68D541C85D26508E83_260013283;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2143875852 = varB4EAC82CA7396A68D541C85D26508E83_1747955289;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_2143875852 = varB4EAC82CA7396A68D541C85D26508E83_1017597058;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_2143875852 = varB4EAC82CA7396A68D541C85D26508E83_1755463504;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2143875852 = varB4EAC82CA7396A68D541C85D26508E83_913050506;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2143875852.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2143875852;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.292 -0400", hash_original_method = "1CE02B172FBE4A7CE10D1F87669E47EA", hash_generated_method = "740B242662C22BEB9E4E968A95487964")
    public void setAnimator(int transitionType, Animator animator) {
        
        mChangingAppearingAnim = animator;
        
        
        mChangingDisappearingAnim = animator;
        
        
        mAppearingAnim = animator;
        
        
        mDisappearingAnim = animator;
        
        addTaint(transitionType);
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.306 -0400", hash_original_method = "FF737FAA09DE0C7945DD1E6E302C4C89", hash_generated_method = "7F56C0F6F9F9F25341617F1B4B622E12")
    public Animator getAnimator(int transitionType) {
        Animator varB4EAC82CA7396A68D541C85D26508E83_1228364659 = null; 
        Animator varB4EAC82CA7396A68D541C85D26508E83_1285027879 = null; 
        Animator varB4EAC82CA7396A68D541C85D26508E83_166391027 = null; 
        Animator varB4EAC82CA7396A68D541C85D26508E83_1003860398 = null; 
        Animator varB4EAC82CA7396A68D541C85D26508E83_1825438734 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_1228364659 = mChangingAppearingAnim;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1285027879 = mChangingDisappearingAnim;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_166391027 = mAppearingAnim;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1003860398 = mDisappearingAnim;
        
        varB4EAC82CA7396A68D541C85D26508E83_1825438734 = null;
        addTaint(transitionType);
        Animator varA7E53CE21691AB073D9660D615818899_1921284479; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1921284479 = varB4EAC82CA7396A68D541C85D26508E83_1228364659;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1921284479 = varB4EAC82CA7396A68D541C85D26508E83_1285027879;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1921284479 = varB4EAC82CA7396A68D541C85D26508E83_166391027;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1921284479 = varB4EAC82CA7396A68D541C85D26508E83_1003860398;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1921284479 = varB4EAC82CA7396A68D541C85D26508E83_1825438734;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1921284479.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1921284479;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.318 -0400", hash_original_method = "388160589FFEE2126FAAE5CBAFC89998", hash_generated_method = "88282AA8097E1831D48BECFDE6566851")
    private void runChangeTransition(final ViewGroup parent, View newView, final int changeReason) {
        Animator baseAnimator;
        baseAnimator = mChangingAppearingAnim;
        baseAnimator = mChangingDisappearingAnim;
        staggerDelay = 0;
        long duration;
        duration = mChangingAppearingDuration;
        duration = mChangingDisappearingDuration;
        final ViewTreeObserver observer = parent.getViewTreeObserver();
        {
            boolean var8AD88F416FDBC789F76B74DE1C37B0E1_253465536 = (!observer.isAlive());
        } 
        int numChildren = parent.getChildCount();
        {
            int i = 0;
            {
                final View child = parent.getChildAt(i);
                {
                    setupChangeAnimation(parent, changeReason, baseAnimator, duration, child);
                } 
            } 
        } 
        {
            Animator parentAnimator;
            parentAnimator = defaultChangeIn;
            parentAnimator = defaultChangeOut;
            ViewGroup tempParent = parent;
            {
                ViewParent parentParent = tempParent.getParent();
                {
                    setupChangeAnimation((ViewGroup)parentParent, changeReason, parentAnimator,
                            duration, tempParent);
                    tempParent = (ViewGroup) parentParent;
                } 
                {
                    tempParent = null;
                } 
            } 
        } 
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.317 -0400", hash_original_method = "6C01974BA3CD333428484527C9FBE54F", hash_generated_method = "4265B55529DE344C5E70F2BECAD615FD")
            public boolean onPreDraw() {
                
                parent.getViewTreeObserver().removeOnPreDrawListener(this);
                int count = layoutChangeListenerMap.size();
                {
                    Collection<View> views = layoutChangeListenerMap.keySet();
                    {
                        Iterator<View> var6B1B56E78019197FFF75517BC796AC75_1175833581 = (views).iterator();
                        var6B1B56E78019197FFF75517BC796AC75_1175833581.hasNext();
                        View view = var6B1B56E78019197FFF75517BC796AC75_1175833581.next();
                        {
                            View.OnLayoutChangeListener listener = layoutChangeListenerMap.get(view);
                            view.removeOnLayoutChangeListener(listener);
                        } 
                    } 
                } 
                layoutChangeListenerMap.clear();
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1736087697 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1736087697;
                
                
                
                
                    
                    
                        
                        
                    
                
                
                
            }
});
        addTaint(parent.getTaint());
        addTaint(newView.getTaint());
        addTaint(changeReason);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.321 -0400", hash_original_method = "5ECFD2D430BE870F40C042D01FD8A2D6", hash_generated_method = "CEE41014B49B701489653EF4BEF3638A")
    public void setAnimateParentHierarchy(boolean animateParentHierarchy) {
        mAnimateParentHierarchy = animateParentHierarchy;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.667 -0400", hash_original_method = "108854515942B7EF6A63499B84E31466", hash_generated_method = "BAE766841CDAC85EBBF9D485C68D12C3")
    private void setupChangeAnimation(final ViewGroup parent, final int changeReason,
            Animator baseAnimator, final long duration, final View child) {
        {
            boolean varA6A7315ADDDC59C70ED73956C763A706_598106775 = (layoutChangeListenerMap.get(child) != null);
        } 
        final Animator anim;
        anim = baseAnimator.clone();
        anim.setTarget(child);
        anim.setupStartValues();
        Animator currentAnimation;
        currentAnimation = pendingAnimations.get(child);
        {
            currentAnimation.cancel();
            pendingAnimations.remove(child);
        } 
        pendingAnimations.put(child, anim);
        ValueAnimator pendingAnimRemover;
        pendingAnimRemover = ValueAnimator.ofFloat(0f, 1f).
                setDuration(duration + 100);
        pendingAnimRemover.addListener(new AnimatorListenerAdapter() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.622 -0400", hash_original_method = "81B18D5FBD0385E26F1E055D2C44BFFA", hash_generated_method = "5A5AED5D7799D8D31962A97F09B49A74")
            @Override
            public void onAnimationEnd(Animator animation) {
                
                pendingAnimations.remove(child);
                addTaint(animation.getTaint());
                
                
            }
});
        pendingAnimRemover.start();
        final View.OnLayoutChangeListener listener;
        listener = new View.OnLayoutChangeListener() {
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.637 -0400", hash_original_method = "E2B93FC024F741AE866ED6DC48631B6A", hash_generated_method = "603C2476C166DA14B1C746EE7A1E047C")
            @Override
            public void onAnimationStart(Animator animator) {
                
                {
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_2115323691 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_2115323691.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_2115323691.next();
                        {
                            listener.startTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                        } 
                    } 
                } 
                addTaint(animator.getTaint());
                
                
                    
                        
                                
                                        
                    
                
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.644 -0400", hash_original_method = "06655B4777E7383270776E7CEC1CCF7E", hash_generated_method = "16F2B3561150327735D9155EF6C6B5A6")
            @Override
            public void onAnimationCancel(Animator animator) {
                
                child.removeOnLayoutChangeListener(listener);
                layoutChangeListenerMap.remove(child);
                addTaint(animator.getTaint());
                
                
                
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.659 -0400", hash_original_method = "DE5B5D0FB75885026A5DD6EBE7BC56A2", hash_generated_method = "87696B60C5A7CF409AFE900FA86FA6B4")
            @Override
            public void onAnimationEnd(Animator animator) {
                
                currentChangingAnimations.remove(child);
                {
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_56065350 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_56065350.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_56065350.next();
                        {
                            listener.endTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                        } 
                    } 
                } 
                addTaint(animator.getTaint());
                
                
                
                    
                        
                                
                                        
                    
                
            }
});
        child.addOnLayoutChangeListener(listener);
        layoutChangeListenerMap.put(child, listener);
        addTaint(parent.getTaint());
        addTaint(changeReason);
        addTaint(baseAnimator.getTaint());
        addTaint(duration);
        addTaint(child.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.336 -0400", hash_original_method = "7222BE89A56886A0CF62DC8766C00475", hash_generated_method = "ED6396F1656A4749364A24D31F0BCEB1")
    public void startChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        {
            Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_603463402 = (currentAnimCopy.values()).iterator();
            var77A69CCC7893588B99D9F323E4F0D0AD_603463402.hasNext();
            Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_603463402.next();
            {
                {
                    ((ObjectAnimator) anim).setCurrentPlayTime(0);
                } 
                anim.start();
            } 
        } 
        
        
                
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.347 -0400", hash_original_method = "7BA742550F1E1298AB8FE77F45C4383D", hash_generated_method = "41201D594F1F18D332DE0657B931C07C")
    public void endChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        {
            Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_661635266 = (currentAnimCopy.values()).iterator();
            var77A69CCC7893588B99D9F323E4F0D0AD_661635266.hasNext();
            Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_661635266.next();
            {
                anim.start();
                anim.end();
            } 
        } 
        
        
                
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.351 -0400", hash_original_method = "8C9364165F532DD8BD43415668542398", hash_generated_method = "4EEB71523F2522AE5F6768B453A5189F")
    public boolean isChangingLayout() {
        boolean var4077384608DE00EFE78F41629DE0A95B_1034664843 = ((currentChangingAnimations.size() > 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71761246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_71761246;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.353 -0400", hash_original_method = "7F683046BB72ECC23A172B1D3B81B266", hash_generated_method = "A527C1B2D030F906436FB7A9FCF325CB")
    public boolean isRunning() {
        boolean var987B4F52345B82CBBAB6F416FA45A0C5_1655985637 = ((currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 ||
                currentDisappearingAnimations.size() > 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1104877809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1104877809;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.374 -0400", hash_original_method = "2E46A59670A61A0AF64FD97BDAF7B728", hash_generated_method = "BA4E3E7D59BC25EA7FD554107C62C359")
    public void cancel() {
        {
            boolean var33AE39A73D9B32AC5849C5A957F93302_1265873090 = (currentChangingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_475300583 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_475300583.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_475300583.next();
                    {
                        anim.cancel();
                    } 
                } 
                currentChangingAnimations.clear();
            } 
        } 
        {
            boolean var581E5FE1178D7616A969479C9EF98728_1781149042 = (currentAppearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_560241656 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_560241656.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_560241656.next();
                    {
                        anim.end();
                    } 
                } 
                currentAppearingAnimations.clear();
            } 
        } 
        {
            boolean var08F255EDB4B7971930CFAED58C7D7CB3_751456503 = (currentDisappearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_216666265 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_216666265.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_216666265.next();
                    {
                        anim.end();
                    } 
                } 
                currentDisappearingAnimations.clear();
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.398 -0400", hash_original_method = "19B870791205108BA3B602A2E8CB5138", hash_generated_method = "5C62F4EF4090F16DDF46FB9F7A9BF65E")
    public void cancel(int transitionType) {
        
        {
            boolean var33AE39A73D9B32AC5849C5A957F93302_336713555 = (currentChangingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1134414859 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1134414859.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1134414859.next();
                    {
                        anim.cancel();
                    } 
                } 
                currentChangingAnimations.clear();
            } 
        } 
        
        
        {
            boolean var581E5FE1178D7616A969479C9EF98728_429734672 = (currentAppearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_2005972064 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_2005972064.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_2005972064.next();
                    {
                        anim.end();
                    } 
                } 
                currentAppearingAnimations.clear();
            } 
        } 
        
        
        {
            boolean var08F255EDB4B7971930CFAED58C7D7CB3_282736676 = (currentDisappearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1908030735 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1908030735.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1908030735.next();
                    {
                        anim.end();
                    } 
                } 
                currentDisappearingAnimations.clear();
            } 
        } 
        
        addTaint(transitionType);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.426 -0400", hash_original_method = "071036D6A0EA050ACF09A35752DC1D52", hash_generated_method = "6E08395FA501C5B895E4E2D9F691CA80")
    private void runAppearingTransition(final ViewGroup parent, final View child) {
        Animator currentAnimation = currentDisappearingAnimations.get(child);
        {
            currentAnimation.cancel();
        } 
        {
            {
                {
                    Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1086157448 = (mListeners).iterator();
                    var027539751E49B70605583F80C9C40859_1086157448.hasNext();
                    TransitionListener listener = var027539751E49B70605583F80C9C40859_1086157448.next();
                    {
                        listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                    } 
                } 
            } 
        } 
        Animator anim = mAppearingAnim.clone();
        anim.setTarget(child);
        anim.setStartDelay(mAppearingDelay);
        anim.setDuration(mAppearingDuration);
        {
            ((ObjectAnimator) anim).setCurrentPlayTime(0);
        } 
        {
            anim.addListener(new AnimatorListenerAdapter() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.425 -0400", hash_original_method = "494D571A7E2D39F79DD71B48D4E2ACB8", hash_generated_method = "3406D2B3EE7C1017728E4AC2206E5D71")
                @Override
                public void onAnimationEnd(Animator anim) {
                    
                    currentAppearingAnimations.remove(child);
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_521916007 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_521916007.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_521916007.next();
                        {
                            listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                        } 
                    } 
                    addTaint(anim.getTaint());
                    
                    
                    
                        
                    
                }
});
        } 
        currentAppearingAnimations.put(child, anim);
        anim.start();
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.455 -0400", hash_original_method = "202CDBACC5F0926CC1D7E1540267464D", hash_generated_method = "FF5ABCEC8C5B41109C100B1271D5C116")
    private void runDisappearingTransition(final ViewGroup parent, final View child) {
        Animator currentAnimation = currentAppearingAnimations.get(child);
        {
            currentAnimation.cancel();
        } 
        {
            {
                {
                    Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_2144170313 = (mListeners).iterator();
                    var027539751E49B70605583F80C9C40859_2144170313.hasNext();
                    TransitionListener listener = var027539751E49B70605583F80C9C40859_2144170313.next();
                    {
                        listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                    } 
                } 
            } 
        } 
        Animator anim = mDisappearingAnim.clone();
        anim.setStartDelay(mDisappearingDelay);
        anim.setDuration(mDisappearingDuration);
        anim.setTarget(child);
        {
            anim.addListener(new AnimatorListenerAdapter() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.454 -0400", hash_original_method = "29C17A3026C40266B26AB145A51034B4", hash_generated_method = "8AB686A46DD1F0BAB0029B982FA6946D")
                @Override
                public void onAnimationEnd(Animator anim) {
                    
                    currentDisappearingAnimations.remove(child);
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1746128190 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_1746128190.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_1746128190.next();
                        {
                            listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                        } 
                    } 
                    addTaint(anim.getTaint());
                    
                    
                    
                        
                    
                }
});
        } 
        {
            ((ObjectAnimator) anim).setCurrentPlayTime(0);
        } 
        currentDisappearingAnimations.put(child, anim);
        anim.start();
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.475 -0400", hash_original_method = "05533C05F33D5C5B655A5BABA4CC6F65", hash_generated_method = "190BA6B88B19F64330D8404DE7C329CF")
    public void addChild(ViewGroup parent, View child) {
        cancel(DISAPPEARING);
        cancel(CHANGE_APPEARING);
        {
            {
                Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_645857150 = (mListeners).iterator();
                var027539751E49B70605583F80C9C40859_645857150.hasNext();
                TransitionListener listener = var027539751E49B70605583F80C9C40859_645857150.next();
                {
                    listener.startTransition(this, parent, child, APPEARING);
                } 
            } 
        } 
        runChangeTransition(parent, child, APPEARING);
        runAppearingTransition(parent, child);
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        
        
        
        
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.477 -0400", hash_original_method = "5867E97EE566113A4AD2D7416A9B4CB1", hash_generated_method = "95C99C73B2C8A5095E34435724B28DE6")
    public void showChild(ViewGroup parent, View child) {
        addChild(parent, child);
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.496 -0400", hash_original_method = "E23F457F66AC508EC3728A00193F4832", hash_generated_method = "8C6ECA44C0779D609BEBBD3058438C1B")
    public void removeChild(ViewGroup parent, View child) {
        cancel(APPEARING);
        cancel(CHANGE_DISAPPEARING);
        {
            {
                Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_239277692 = (mListeners).iterator();
                var027539751E49B70605583F80C9C40859_239277692.hasNext();
                TransitionListener listener = var027539751E49B70605583F80C9C40859_239277692.next();
                {
                    listener.startTransition(this, parent, child, DISAPPEARING);
                } 
            } 
        } 
        runChangeTransition(parent, child, DISAPPEARING);
        runDisappearingTransition(parent, child);
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        
        
        
        
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.498 -0400", hash_original_method = "59CF94EEC1336BEEB8FFF5467E6ED5F9", hash_generated_method = "A29FAFF27DDBC6B66F44D8F3E67BE879")
    public void hideChild(ViewGroup parent, View child) {
        removeChild(parent, child);
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.501 -0400", hash_original_method = "167EED27AB5F7469F2545513C43EBDC4", hash_generated_method = "33DF80809CD54F9F80083D96E59EE66F")
    public void addTransitionListener(TransitionListener listener) {
        {
            mListeners = new ArrayList<TransitionListener>();
        } 
        mListeners.add(listener);
        addTaint(listener.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.503 -0400", hash_original_method = "CD0DE6419C69039B8FDEE8C2D5BC497D", hash_generated_method = "1088A5954536D6AEF84349B370DCD872")
    public void removeTransitionListener(TransitionListener listener) {
        mListeners.remove(listener);
        addTaint(listener.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.508 -0400", hash_original_method = "F0DD3EC0CE94CE6304D7C3009A3E39A6", hash_generated_method = "C92BE9B07996B4901C437E7776FEA48D")
    public List<TransitionListener> getTransitionListeners() {
        List<TransitionListener> varB4EAC82CA7396A68D541C85D26508E83_885336403 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_885336403 = mListeners;
        varB4EAC82CA7396A68D541C85D26508E83_885336403.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_885336403;
        
        
    }

    
    public interface TransitionListener {

        
        public void startTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);

        
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.509 -0400", hash_original_field = "D65A82112F44124A2B9FDE00A6246728", hash_generated_field = "E63A0521AAA8C6DC4279BA44E098FD23")

    public static final int CHANGE_APPEARING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.509 -0400", hash_original_field = "6F62B99E30E6B4CA586C12E8B13A3B4A", hash_generated_field = "A5E247EB4D6439D9A98E49F907931252")

    public static final int CHANGE_DISAPPEARING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.509 -0400", hash_original_field = "1C2C691552DB12B6637FB16180CB8DEE", hash_generated_field = "F22B7CC5AA7D7298C87C59E48B6986CB")

    public static final int APPEARING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.510 -0400", hash_original_field = "26D6A6E008A00E881DA7073368B3FBCA", hash_generated_field = "2B4B660177B7589D2F5A7A330CB80759")

    public static final int DISAPPEARING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.510 -0400", hash_original_field = "F62AE2A917606476AA59A24B61225594", hash_generated_field = "F23425A4D82261A0713821E518F1C782")

    private static ObjectAnimator defaultChangeIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.510 -0400", hash_original_field = "8FE2012C5D3B66F186AE3B5608F5506B", hash_generated_field = "383D2DB6CC8BE4F70A8FC6AE24EF0892")

    private static ObjectAnimator defaultChangeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.511 -0400", hash_original_field = "9AB47D0B11CFD6785DD53FD6A9B89AC3", hash_generated_field = "9FE642298321DB1BFB3B90AC8C413400")

    private static ObjectAnimator defaultFadeIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.512 -0400", hash_original_field = "32DE7577E5C8E88AE24A2E7B696BED9F", hash_generated_field = "25D149E4F7D04D3FBA535A38951E6CA0")

    private static ObjectAnimator defaultFadeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.512 -0400", hash_original_field = "2588F8D6DA58076995259889823B1880", hash_generated_field = "B0EA698E636B3BDA7398DDB39E975802")

    private static long DEFAULT_DURATION = 300;
}

