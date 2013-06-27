package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.988 -0400", hash_original_field = "39AB1186E068767124693950E5241B0C", hash_generated_field = "75E407E7333EB2D59F0ED20EAD88E34E")

    private Animator mDisappearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.989 -0400", hash_original_field = "898C2D1A5742BD7C3E8E82A9D2E0437F", hash_generated_field = "F269A266B00229E5734E5B06B519CF4D")

    private Animator mAppearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.990 -0400", hash_original_field = "1F332D66976C447496CA1B80691E0B10", hash_generated_field = "8569DC611F2B171274327A8DFA6BA137")

    private Animator mChangingAppearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.006 -0400", hash_original_field = "765E4DC7F9110BDE36ADFF990E8FCAEC", hash_generated_field = "295E17A6E98CD794E342CB0517EC6D87")

    private Animator mChangingDisappearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.007 -0400", hash_original_field = "42A198EE1914D883D37C3ED3B1135670", hash_generated_field = "A5577F39C2927B8AF67AB98D2B541767")

    private long mChangingAppearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.008 -0400", hash_original_field = "218EB6559CA33E7E919115954C4DB0D9", hash_generated_field = "463C58461ED789E13A8EEFA59D868711")

    private long mChangingDisappearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.013 -0400", hash_original_field = "80A25498D18A6710708CD4BFB8EF24DA", hash_generated_field = "B1A031389441AED70DA8674A9CDD4213")

    private long mAppearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.014 -0400", hash_original_field = "5ECCF0345DF5DEDAB0F5A39516048905", hash_generated_field = "83E0F49BD50CEA25C451F339C8D938A9")

    private long mDisappearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.015 -0400", hash_original_field = "91B6925F9416CAE38F44C8180EE00D62", hash_generated_field = "6B89F75DB8D18324FDA519C3D6E9C3E1")

    private long mAppearingDelay = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.059 -0400", hash_original_field = "A22E36387E60BA8EEB738DFDB9781A6E", hash_generated_field = "EE2346FE7169B9AB19EA56A1B913BA60")

    private long mDisappearingDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.060 -0400", hash_original_field = "AD69818355B6F5E9EB967A4A202385FA", hash_generated_field = "B72CDDC89FC836C2633888FAF590185E")

    private long mChangingAppearingDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.061 -0400", hash_original_field = "51E19A1306CC67939DEB066B90A6AA30", hash_generated_field = "A8B24D136EA5EC6890818CC10AD17C05")

    private long mChangingDisappearingDelay = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.062 -0400", hash_original_field = "D4E1B66EF88324ED6FA8088CEB4CBE14", hash_generated_field = "715370DF92240EF0021A1CA25FFC6060")

    private long mChangingAppearingStagger = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.067 -0400", hash_original_field = "C9AB7CA6788BC42432306ED5D9FA4751", hash_generated_field = "95B0E8048A3A312DC3734A9E265C8176")

    private long mChangingDisappearingStagger = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.077 -0400", hash_original_field = "E83595FF742C9B6EB99D19F9305ABBA8", hash_generated_field = "3164C261F18E7FCC582837BE79E7E946")

    private TimeInterpolator mAppearingInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.081 -0400", hash_original_field = "D1BFED2C966B3C158EF425A93E73D95C", hash_generated_field = "44480B19C903085EE0CD5A188A9C0404")

    private TimeInterpolator mDisappearingInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.088 -0400", hash_original_field = "9BB07EDE1DBE6A1B275E097543CFA633", hash_generated_field = "6AD343EAC627700E45ADD7F9BC2E498E")

    private TimeInterpolator mChangingAppearingInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.092 -0400", hash_original_field = "AB42CFE8B0A8C2974D7F84A32756AC89", hash_generated_field = "002DBF51FA8D471B18C74A9B6E24123D")

    private TimeInterpolator mChangingDisappearingInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.100 -0400", hash_original_field = "833A7AADDF3C4472D3F75449099C7417", hash_generated_field = "4CD16B39839DD06A15F21E2AB5E191BB")

    private HashMap<View, Animator> pendingAnimations = new HashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.108 -0400", hash_original_field = "1A6E910FE59BBBBACA171B049921002A", hash_generated_field = "371FB10BEA8820BD50A7C52A1EE3E0B9")

    private LinkedHashMap<View, Animator> currentChangingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.113 -0400", hash_original_field = "54075758A22D2683EE0C4649851E0018", hash_generated_field = "7D27A0BC47F29ED76BA5422C9FE81D07")

    private LinkedHashMap<View, Animator> currentAppearingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.114 -0400", hash_original_field = "0F0C1A65AE21602FD367A69818E8A1E7", hash_generated_field = "AD4FA88381487A98E667BBD6F1FE5C0F")

    private LinkedHashMap<View, Animator> currentDisappearingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.118 -0400", hash_original_field = "1FEEE2ED7992F5B46B7D29EC9654E64D", hash_generated_field = "6AF2DBAD6623E516A768E22B61590762")

    private HashMap<View, View.OnLayoutChangeListener> layoutChangeListenerMap = new HashMap<View, View.OnLayoutChangeListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.124 -0400", hash_original_field = "6210BD7488CCE5FE8B740760087A30E6", hash_generated_field = "62799693C20798E5E433F1B0AF6A3DC5")

    private long staggerDelay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.133 -0400", hash_original_field = "2F2828353527044AFD6820F84A8A1FAB", hash_generated_field = "F165C7B3902835B1E7EE6F9F45B1EBD6")

    private ArrayList<TransitionListener> mListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.139 -0400", hash_original_field = "57CB5A16236BA625AFCBA400CC996A11", hash_generated_field = "E61C51FC893874C4BB912FEBE4441512")

    private boolean mAnimateParentHierarchy = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.204 -0400", hash_original_method = "52DB630B34835349C84181A9ADA45542", hash_generated_method = "B5AF3E8337270E86D71495E381BA6591")
    public  LayoutTransition() {
        {
            PropertyValuesHolder pvhLeft;
            pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
            PropertyValuesHolder pvhTop;
            pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
            PropertyValuesHolder pvhRight;
            pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
            PropertyValuesHolder pvhBottom;
            pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 1);
            PropertyValuesHolder pvhScrollX;
            pvhScrollX = PropertyValuesHolder.ofInt("scrollX", 0, 1);
            PropertyValuesHolder pvhScrollY;
            pvhScrollY = PropertyValuesHolder.ofInt("scrollY", 0, 1);
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
        } //End block
        mChangingAppearingAnim = defaultChangeIn;
        mChangingDisappearingAnim = defaultChangeOut;
        mAppearingAnim = defaultFadeIn;
        mDisappearingAnim = defaultFadeOut;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.241 -0400", hash_original_method = "24394BA80BA94B39DCA5B438DC3EBDB1", hash_generated_method = "CF9B4395D785358863CAB9605D225CA9")
    public void setDuration(long duration) {
        mChangingAppearingDuration = duration;
        mChangingDisappearingDuration = duration;
        mAppearingDuration = duration;
        mDisappearingDuration = duration;
        // ---------- Original Method ----------
        //mChangingAppearingDuration = duration;
        //mChangingDisappearingDuration = duration;
        //mAppearingDuration = duration;
        //mDisappearingDuration = duration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.283 -0400", hash_original_method = "939FBD8B4C5590BFCAA9E14AEC15ED50", hash_generated_method = "BCE6354327899DE2956D4D80C0566F68")
    public void setStartDelay(int transitionType, long delay) {
        //Begin case CHANGE_APPEARING 
        mChangingAppearingDelay = delay;
        //End case CHANGE_APPEARING 
        //Begin case CHANGE_DISAPPEARING 
        mChangingDisappearingDelay = delay;
        //End case CHANGE_DISAPPEARING 
        //Begin case APPEARING 
        mAppearingDelay = delay;
        //End case APPEARING 
        //Begin case DISAPPEARING 
        mDisappearingDelay = delay;
        //End case DISAPPEARING 
        addTaint(transitionType);
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //mChangingAppearingDelay = delay;
                //break;
            //case CHANGE_DISAPPEARING:
                //mChangingDisappearingDelay = delay;
                //break;
            //case APPEARING:
                //mAppearingDelay = delay;
                //break;
            //case DISAPPEARING:
                //mDisappearingDelay = delay;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.297 -0400", hash_original_method = "3F88CD33B6864BEBC3B576EB6504FB35", hash_generated_method = "1373ABB5FDB129589CEDB1308C80D708")
    public long getStartDelay(int transitionType) {
        addTaint(transitionType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_9403727 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_9403727;
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingDuration;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingDuration;
            //case APPEARING:
                //return mAppearingDuration;
            //case DISAPPEARING:
                //return mDisappearingDuration;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.337 -0400", hash_original_method = "2851CBF3AA331995F771441E9F6D0AAD", hash_generated_method = "93E3AFDD083BDB202331DF6E211BA063")
    public void setDuration(int transitionType, long duration) {
        //Begin case CHANGE_APPEARING 
        mChangingAppearingDuration = duration;
        //End case CHANGE_APPEARING 
        //Begin case CHANGE_DISAPPEARING 
        mChangingDisappearingDuration = duration;
        //End case CHANGE_DISAPPEARING 
        //Begin case APPEARING 
        mAppearingDuration = duration;
        //End case APPEARING 
        //Begin case DISAPPEARING 
        mDisappearingDuration = duration;
        //End case DISAPPEARING 
        addTaint(transitionType);
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //mChangingAppearingDuration = duration;
                //break;
            //case CHANGE_DISAPPEARING:
                //mChangingDisappearingDuration = duration;
                //break;
            //case APPEARING:
                //mAppearingDuration = duration;
                //break;
            //case DISAPPEARING:
                //mDisappearingDuration = duration;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.364 -0400", hash_original_method = "F259A86CD3BB3A6D515EAAF2335DC6DD", hash_generated_method = "4AE168F27B50998EA009727D48A9141A")
    public long getDuration(int transitionType) {
        addTaint(transitionType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_692504998 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_692504998;
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingDuration;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingDuration;
            //case APPEARING:
                //return mAppearingDuration;
            //case DISAPPEARING:
                //return mDisappearingDuration;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.390 -0400", hash_original_method = "DB3710D74B2FBFD7C44693C4FBA40808", hash_generated_method = "D9C6245F1664A3D7DBFC6A5958CE4B39")
    public void setStagger(int transitionType, long duration) {
        //Begin case CHANGE_APPEARING 
        mChangingAppearingStagger = duration;
        //End case CHANGE_APPEARING 
        //Begin case CHANGE_DISAPPEARING 
        mChangingDisappearingStagger = duration;
        //End case CHANGE_DISAPPEARING 
        addTaint(transitionType);
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //mChangingAppearingStagger = duration;
                //break;
            //case CHANGE_DISAPPEARING:
                //mChangingDisappearingStagger = duration;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.410 -0400", hash_original_method = "70FCFF77D9C405B5FA9E6B4579BF3D8B", hash_generated_method = "8329682995C49900D958452CA9987857")
    public long getStagger(int transitionType) {
        addTaint(transitionType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_382296822 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_382296822;
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingStagger;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingStagger;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.457 -0400", hash_original_method = "2AD5234EB4F80ED9C0D5C1F0BD7735E5", hash_generated_method = "02FFFA304AEDF303F30ED9BE4A859608")
    public void setInterpolator(int transitionType, TimeInterpolator interpolator) {
        //Begin case CHANGE_APPEARING 
        mChangingAppearingInterpolator = interpolator;
        //End case CHANGE_APPEARING 
        //Begin case CHANGE_DISAPPEARING 
        mChangingDisappearingInterpolator = interpolator;
        //End case CHANGE_DISAPPEARING 
        //Begin case APPEARING 
        mAppearingInterpolator = interpolator;
        //End case APPEARING 
        //Begin case DISAPPEARING 
        mDisappearingInterpolator = interpolator;
        //End case DISAPPEARING 
        addTaint(transitionType);
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //mChangingAppearingInterpolator = interpolator;
                //break;
            //case CHANGE_DISAPPEARING:
                //mChangingDisappearingInterpolator = interpolator;
                //break;
            //case APPEARING:
                //mAppearingInterpolator = interpolator;
                //break;
            //case DISAPPEARING:
                //mDisappearingInterpolator = interpolator;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.491 -0400", hash_original_method = "11C2A17826922B819D4ABA31B32AF7FD", hash_generated_method = "33A26D03A72D66289FE2567D8419B5EA")
    public TimeInterpolator getInterpolator(int transitionType) {
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1882735658 = null; //Variable for return #1
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_100328125 = null; //Variable for return #2
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1834366483 = null; //Variable for return #3
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1402524209 = null; //Variable for return #4
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1268269127 = null; //Variable for return #5
        //Begin case CHANGE_APPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_1882735658 = mChangingAppearingInterpolator;
        //End case CHANGE_APPEARING 
        //Begin case CHANGE_DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_100328125 = mChangingDisappearingInterpolator;
        //End case CHANGE_DISAPPEARING 
        //Begin case APPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_1834366483 = mAppearingInterpolator;
        //End case APPEARING 
        //Begin case DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_1402524209 = mDisappearingInterpolator;
        //End case DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_1268269127 = null;
        addTaint(transitionType);
        TimeInterpolator varA7E53CE21691AB073D9660D615818899_527727016; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_527727016 = varB4EAC82CA7396A68D541C85D26508E83_1882735658;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_527727016 = varB4EAC82CA7396A68D541C85D26508E83_100328125;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_527727016 = varB4EAC82CA7396A68D541C85D26508E83_1834366483;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_527727016 = varB4EAC82CA7396A68D541C85D26508E83_1402524209;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_527727016 = varB4EAC82CA7396A68D541C85D26508E83_1268269127;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_527727016.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_527727016;
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingInterpolator;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingInterpolator;
            //case APPEARING:
                //return mAppearingInterpolator;
            //case DISAPPEARING:
                //return mDisappearingInterpolator;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.516 -0400", hash_original_method = "1CE02B172FBE4A7CE10D1F87669E47EA", hash_generated_method = "740B242662C22BEB9E4E968A95487964")
    public void setAnimator(int transitionType, Animator animator) {
        //Begin case CHANGE_APPEARING 
        mChangingAppearingAnim = animator;
        //End case CHANGE_APPEARING 
        //Begin case CHANGE_DISAPPEARING 
        mChangingDisappearingAnim = animator;
        //End case CHANGE_DISAPPEARING 
        //Begin case APPEARING 
        mAppearingAnim = animator;
        //End case APPEARING 
        //Begin case DISAPPEARING 
        mDisappearingAnim = animator;
        //End case DISAPPEARING 
        addTaint(transitionType);
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //mChangingAppearingAnim = animator;
                //break;
            //case CHANGE_DISAPPEARING:
                //mChangingDisappearingAnim = animator;
                //break;
            //case APPEARING:
                //mAppearingAnim = animator;
                //break;
            //case DISAPPEARING:
                //mDisappearingAnim = animator;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.559 -0400", hash_original_method = "FF737FAA09DE0C7945DD1E6E302C4C89", hash_generated_method = "016A67111FA8AE38C92EE5955A3889E4")
    public Animator getAnimator(int transitionType) {
        Animator varB4EAC82CA7396A68D541C85D26508E83_730963465 = null; //Variable for return #1
        Animator varB4EAC82CA7396A68D541C85D26508E83_454610874 = null; //Variable for return #2
        Animator varB4EAC82CA7396A68D541C85D26508E83_1507883102 = null; //Variable for return #3
        Animator varB4EAC82CA7396A68D541C85D26508E83_950292930 = null; //Variable for return #4
        Animator varB4EAC82CA7396A68D541C85D26508E83_298989473 = null; //Variable for return #5
        //Begin case CHANGE_APPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_730963465 = mChangingAppearingAnim;
        //End case CHANGE_APPEARING 
        //Begin case CHANGE_DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_454610874 = mChangingDisappearingAnim;
        //End case CHANGE_DISAPPEARING 
        //Begin case APPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_1507883102 = mAppearingAnim;
        //End case APPEARING 
        //Begin case DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_950292930 = mDisappearingAnim;
        //End case DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_298989473 = null;
        addTaint(transitionType);
        Animator varA7E53CE21691AB073D9660D615818899_1972915334; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1972915334 = varB4EAC82CA7396A68D541C85D26508E83_730963465;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1972915334 = varB4EAC82CA7396A68D541C85D26508E83_454610874;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1972915334 = varB4EAC82CA7396A68D541C85D26508E83_1507883102;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1972915334 = varB4EAC82CA7396A68D541C85D26508E83_950292930;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1972915334 = varB4EAC82CA7396A68D541C85D26508E83_298989473;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1972915334.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1972915334;
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingAnim;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingAnim;
            //case APPEARING:
                //return mAppearingAnim;
            //case DISAPPEARING:
                //return mDisappearingAnim;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:33.681 -0400", hash_original_method = "388160589FFEE2126FAAE5CBAFC89998", hash_generated_method = "28A3928FBDA0ED1E5DB4E85168DDB304")
    private void runChangeTransition(final ViewGroup parent, View newView, final int changeReason) {
        Animator baseAnimator;
        baseAnimator = mChangingAppearingAnim;
        baseAnimator = mChangingDisappearingAnim;
        staggerDelay = 0;
        long duration;
        duration = mChangingAppearingDuration;
        duration = mChangingDisappearingDuration;
        ViewTreeObserver observer;
        observer = parent.getViewTreeObserver();
        {
            boolean var8AD88F416FDBC789F76B74DE1C37B0E1_1051876408 = (!observer.isAlive());
        } //End collapsed parenthetic
        int numChildren;
        numChildren = parent.getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = parent.getChildAt(i);
                {
                    setupChangeAnimation(parent, changeReason, baseAnimator, duration, child);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            Animator parentAnimator;
            parentAnimator = defaultChangeIn;
            parentAnimator = defaultChangeOut;
            ViewGroup tempParent;
            tempParent = parent;
            {
                ViewParent parentParent;
                parentParent = tempParent.getParent();
                {
                    setupChangeAnimation((ViewGroup)parentParent, changeReason, parentAnimator,
                            duration, tempParent);
                    tempParent = (ViewGroup) parentParent;
                } //End block
                {
                    tempParent = null;
                } //End block
            } //End block
        } //End block
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:33.680 -0400", hash_original_method = "6C01974BA3CD333428484527C9FBE54F", hash_generated_method = "ADB3F1570A5A48738D6EDB8805DB3C6F")
            public boolean onPreDraw() {
                //DSFIXME:  CODE0009: Possible callback target function detected
                parent.getViewTreeObserver().removeOnPreDrawListener(this);
                int count;
                count = layoutChangeListenerMap.size();
                {
                    Collection<View> views;
                    views = layoutChangeListenerMap.keySet();
                    {
                        Iterator<View> var6B1B56E78019197FFF75517BC796AC75_1316709760 = (views).iterator();
                        var6B1B56E78019197FFF75517BC796AC75_1316709760.hasNext();
                        View view = var6B1B56E78019197FFF75517BC796AC75_1316709760.next();
                        {
                            View.OnLayoutChangeListener listener;
                            listener = layoutChangeListenerMap.get(view);
                            view.removeOnLayoutChangeListener(listener);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                layoutChangeListenerMap.clear();
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93289785 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_93289785;
                // ---------- Original Method ----------
                //parent.getViewTreeObserver().removeOnPreDrawListener(this);
                //int count = layoutChangeListenerMap.size();
                //if (count > 0) {
                    //Collection<View> views = layoutChangeListenerMap.keySet();
                    //for (View view : views) {
                        //View.OnLayoutChangeListener listener = layoutChangeListenerMap.get(view);
                        //view.removeOnLayoutChangeListener(listener);
                    //}
                //}
                //layoutChangeListenerMap.clear();
                //return true;
            }
});
        addTaint(parent.getTaint());
        addTaint(newView.getTaint());
        addTaint(changeReason);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:33.694 -0400", hash_original_method = "5ECFD2D430BE870F40C042D01FD8A2D6", hash_generated_method = "CEE41014B49B701489653EF4BEF3638A")
    public void setAnimateParentHierarchy(boolean animateParentHierarchy) {
        mAnimateParentHierarchy = animateParentHierarchy;
        // ---------- Original Method ----------
        //mAnimateParentHierarchy = animateParentHierarchy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:33.808 -0400", hash_original_method = "108854515942B7EF6A63499B84E31466", hash_generated_method = "0C136ED5E0982892E60A270194778165")
    private void setupChangeAnimation(final ViewGroup parent, final int changeReason,
            Animator baseAnimator, final long duration, final View child) {
        {
            boolean varA6A7315ADDDC59C70ED73956C763A706_2108734521 = (layoutChangeListenerMap.get(child) != null);
        } //End collapsed parenthetic
        final Animator anim;
        anim = baseAnimator.clone();
        anim.setTarget(child);
        anim.setupStartValues();
        Animator currentAnimation;
        currentAnimation = pendingAnimations.get(child);
        {
            currentAnimation.cancel();
            pendingAnimations.remove(child);
        } //End block
        pendingAnimations.put(child, anim);
        ValueAnimator pendingAnimRemover;
        pendingAnimRemover = ValueAnimator.ofFloat(0f, 1f).
                setDuration(duration + 100);
        pendingAnimRemover.addListener(new AnimatorListenerAdapter() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:33.722 -0400", hash_original_method = "81B18D5FBD0385E26F1E055D2C44BFFA", hash_generated_method = "5A5AED5D7799D8D31962A97F09B49A74")
            @Override
            public void onAnimationEnd(Animator animation) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                pendingAnimations.remove(child);
                addTaint(animation.getTaint());
                // ---------- Original Method ----------
                //pendingAnimations.remove(child);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:33.748 -0400", hash_original_method = "E2B93FC024F741AE866ED6DC48631B6A", hash_generated_method = "A37C06A7C656F1CEACC5BD86008913C4")
            @Override
            public void onAnimationStart(Animator animator) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_110208310 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_110208310.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_110208310.next();
                        {
                            listener.startTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                addTaint(animator.getTaint());
                // ---------- Original Method ----------
                //if (mListeners != null) {
                    //for (TransitionListener listener : mListeners) {
                        //listener.startTransition(LayoutTransition.this, parent, child,
                                //changeReason == APPEARING ?
                                        //CHANGE_APPEARING : CHANGE_DISAPPEARING);
                    //}
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:33.751 -0400", hash_original_method = "06655B4777E7383270776E7CEC1CCF7E", hash_generated_method = "16F2B3561150327735D9155EF6C6B5A6")
            @Override
            public void onAnimationCancel(Animator animator) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                child.removeOnLayoutChangeListener(listener);
                layoutChangeListenerMap.remove(child);
                addTaint(animator.getTaint());
                // ---------- Original Method ----------
                //child.removeOnLayoutChangeListener(listener);
                //layoutChangeListenerMap.remove(child);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:33.776 -0400", hash_original_method = "DE5B5D0FB75885026A5DD6EBE7BC56A2", hash_generated_method = "785B9DD600565A0CB9755461F4575185")
            @Override
            public void onAnimationEnd(Animator animator) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                currentChangingAnimations.remove(child);
                {
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1525760736 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_1525760736.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_1525760736.next();
                        {
                            listener.endTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                addTaint(animator.getTaint());
                // ---------- Original Method ----------
                //currentChangingAnimations.remove(child);
                //if (mListeners != null) {
                    //for (TransitionListener listener : mListeners) {
                        //listener.endTransition(LayoutTransition.this, parent, child,
                                //changeReason == APPEARING ?
                                        //CHANGE_APPEARING : CHANGE_DISAPPEARING);
                    //}
                //}
            }
});
        child.addOnLayoutChangeListener(listener);
        layoutChangeListenerMap.put(child, listener);
        addTaint(parent.getTaint());
        addTaint(changeReason);
        addTaint(baseAnimator.getTaint());
        addTaint(duration);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.375 -0400", hash_original_method = "7222BE89A56886A0CF62DC8766C00475", hash_generated_method = "01F72CC6E3D7807A9AB1E12C3DC0FF1B")
    public void startChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy;
        currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        {
            Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_2055020437 = (currentAnimCopy.values()).iterator();
            var77A69CCC7893588B99D9F323E4F0D0AD_2055020437.hasNext();
            Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_2055020437.next();
            {
                {
                    ((ObjectAnimator) anim).setCurrentPlayTime(0);
                } //End block
                anim.start();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //LinkedHashMap<View, Animator> currentAnimCopy =
                //(LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        //for (Animator anim : currentAnimCopy.values()) {
            //if (anim instanceof ObjectAnimator) {
                //((ObjectAnimator) anim).setCurrentPlayTime(0);
            //}
            //anim.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.559 -0400", hash_original_method = "7BA742550F1E1298AB8FE77F45C4383D", hash_generated_method = "DB64647E92507CCF807AE8417EB861C2")
    public void endChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy;
        currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        {
            Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_999625212 = (currentAnimCopy.values()).iterator();
            var77A69CCC7893588B99D9F323E4F0D0AD_999625212.hasNext();
            Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_999625212.next();
            {
                anim.start();
                anim.end();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //LinkedHashMap<View, Animator> currentAnimCopy =
                //(LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        //for (Animator anim : currentAnimCopy.values()) {
            //anim.start();
            //anim.end();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.582 -0400", hash_original_method = "8C9364165F532DD8BD43415668542398", hash_generated_method = "84E5C502025347E87B09DCB355100718")
    public boolean isChangingLayout() {
        boolean var4077384608DE00EFE78F41629DE0A95B_1262107225 = ((currentChangingAnimations.size() > 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2134105715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2134105715;
        // ---------- Original Method ----------
        //return (currentChangingAnimations.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.597 -0400", hash_original_method = "7F683046BB72ECC23A172B1D3B81B266", hash_generated_method = "9EB62D27F25B7084C938AA0E9151747C")
    public boolean isRunning() {
        boolean var987B4F52345B82CBBAB6F416FA45A0C5_1990150125 = ((currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 ||
                currentDisappearingAnimations.size() > 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418201230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418201230;
        // ---------- Original Method ----------
        //return (currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 ||
                //currentDisappearingAnimations.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.040 -0400", hash_original_method = "2E46A59670A61A0AF64FD97BDAF7B728", hash_generated_method = "A789D66FCAE6E5174E2844E498851716")
    public void cancel() {
        {
            boolean var33AE39A73D9B32AC5849C5A957F93302_1248721387 = (currentChangingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1295106919 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1295106919.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1295106919.next();
                    {
                        anim.cancel();
                    } //End block
                } //End collapsed parenthetic
                currentChangingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var581E5FE1178D7616A969479C9EF98728_1203090106 = (currentAppearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1661958954 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1661958954.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1661958954.next();
                    {
                        anim.end();
                    } //End block
                } //End collapsed parenthetic
                currentAppearingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var08F255EDB4B7971930CFAED58C7D7CB3_1665427531 = (currentDisappearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1794708049 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1794708049.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1794708049.next();
                    {
                        anim.end();
                    } //End block
                } //End collapsed parenthetic
                currentDisappearingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.350 -0400", hash_original_method = "19B870791205108BA3B602A2E8CB5138", hash_generated_method = "B40ABD4580C56D0E0B7179A33F301227")
    public void cancel(int transitionType) {
        //Begin case CHANGE_APPEARING CHANGE_DISAPPEARING 
        {
            boolean var33AE39A73D9B32AC5849C5A957F93302_140667455 = (currentChangingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_2128939322 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_2128939322.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_2128939322.next();
                    {
                        anim.cancel();
                    } //End block
                } //End collapsed parenthetic
                currentChangingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        //End case CHANGE_APPEARING CHANGE_DISAPPEARING 
        //Begin case APPEARING 
        {
            boolean var581E5FE1178D7616A969479C9EF98728_1642149739 = (currentAppearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1421977758 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1421977758.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1421977758.next();
                    {
                        anim.end();
                    } //End block
                } //End collapsed parenthetic
                currentAppearingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        //End case APPEARING 
        //Begin case DISAPPEARING 
        {
            boolean var08F255EDB4B7971930CFAED58C7D7CB3_1507649513 = (currentDisappearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_813034482 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_813034482.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_813034482.next();
                    {
                        anim.end();
                    } //End block
                } //End collapsed parenthetic
                currentDisappearingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        //End case DISAPPEARING 
        addTaint(transitionType);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.560 -0400", hash_original_method = "071036D6A0EA050ACF09A35752DC1D52", hash_generated_method = "DACBA041055C0C34CCBC0E9798B7734A")
    private void runAppearingTransition(final ViewGroup parent, final View child) {
        Animator currentAnimation;
        currentAnimation = currentDisappearingAnimations.get(child);
        {
            currentAnimation.cancel();
        } //End block
        {
            {
                {
                    Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1976163723 = (mListeners).iterator();
                    var027539751E49B70605583F80C9C40859_1976163723.hasNext();
                    TransitionListener listener = var027539751E49B70605583F80C9C40859_1976163723.next();
                    {
                        listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        Animator anim;
        anim = mAppearingAnim.clone();
        anim.setTarget(child);
        anim.setStartDelay(mAppearingDelay);
        anim.setDuration(mAppearingDuration);
        {
            ((ObjectAnimator) anim).setCurrentPlayTime(0);
        } //End block
        {
            anim.addListener(new AnimatorListenerAdapter() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.558 -0400", hash_original_method = "494D571A7E2D39F79DD71B48D4E2ACB8", hash_generated_method = "FA14A61AA77604028EE22CC56C32E407")
                @Override
                public void onAnimationEnd(Animator anim) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    currentAppearingAnimations.remove(child);
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1748818439 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_1748818439.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_1748818439.next();
                        {
                            listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                        } //End block
                    } //End collapsed parenthetic
                    addTaint(anim.getTaint());
                    // ---------- Original Method ----------
                    //currentAppearingAnimations.remove(child);
                    //for (TransitionListener listener : mListeners) {
                        //listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                    //}
                }
});
        } //End block
        currentAppearingAnimations.put(child, anim);
        anim.start();
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.812 -0400", hash_original_method = "202CDBACC5F0926CC1D7E1540267464D", hash_generated_method = "38332A37549054DE3AA2CA293D8526E1")
    private void runDisappearingTransition(final ViewGroup parent, final View child) {
        Animator currentAnimation;
        currentAnimation = currentAppearingAnimations.get(child);
        {
            currentAnimation.cancel();
        } //End block
        {
            {
                {
                    Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1268150617 = (mListeners).iterator();
                    var027539751E49B70605583F80C9C40859_1268150617.hasNext();
                    TransitionListener listener = var027539751E49B70605583F80C9C40859_1268150617.next();
                    {
                        listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        Animator anim;
        anim = mDisappearingAnim.clone();
        anim.setStartDelay(mDisappearingDelay);
        anim.setDuration(mDisappearingDuration);
        anim.setTarget(child);
        {
            anim.addListener(new AnimatorListenerAdapter() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.811 -0400", hash_original_method = "29C17A3026C40266B26AB145A51034B4", hash_generated_method = "4582E1A877CBD87B7498273D854DA70C")
                @Override
                public void onAnimationEnd(Animator anim) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    currentDisappearingAnimations.remove(child);
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_2140407321 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_2140407321.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_2140407321.next();
                        {
                            listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                        } //End block
                    } //End collapsed parenthetic
                    addTaint(anim.getTaint());
                    // ---------- Original Method ----------
                    //currentDisappearingAnimations.remove(child);
                    //for (TransitionListener listener : mListeners) {
                        //listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                    //}
                }
});
        } //End block
        {
            ((ObjectAnimator) anim).setCurrentPlayTime(0);
        } //End block
        currentDisappearingAnimations.put(child, anim);
        anim.start();
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.969 -0400", hash_original_method = "05533C05F33D5C5B655A5BABA4CC6F65", hash_generated_method = "28C0AEEEDAD60BFB46284A53DF7EA9D0")
    public void addChild(ViewGroup parent, View child) {
        cancel(DISAPPEARING);
        cancel(CHANGE_APPEARING);
        {
            {
                Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1815973098 = (mListeners).iterator();
                var027539751E49B70605583F80C9C40859_1815973098.hasNext();
                TransitionListener listener = var027539751E49B70605583F80C9C40859_1815973098.next();
                {
                    listener.startTransition(this, parent, child, APPEARING);
                } //End block
            } //End collapsed parenthetic
        } //End block
        runChangeTransition(parent, child, APPEARING);
        runAppearingTransition(parent, child);
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //cancel(DISAPPEARING);
        //cancel(CHANGE_APPEARING);
        //if (mListeners != null) {
            //for (TransitionListener listener : mListeners) {
                //listener.startTransition(this, parent, child, APPEARING);
            //}
        //}
        //runChangeTransition(parent, child, APPEARING);
        //runAppearingTransition(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.984 -0400", hash_original_method = "5867E97EE566113A4AD2D7416A9B4CB1", hash_generated_method = "95C99C73B2C8A5095E34435724B28DE6")
    public void showChild(ViewGroup parent, View child) {
        addChild(parent, child);
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //addChild(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.159 -0400", hash_original_method = "E23F457F66AC508EC3728A00193F4832", hash_generated_method = "7B3E3E0E0B3907DD9335AC7388155407")
    public void removeChild(ViewGroup parent, View child) {
        cancel(APPEARING);
        cancel(CHANGE_DISAPPEARING);
        {
            {
                Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1698331249 = (mListeners).iterator();
                var027539751E49B70605583F80C9C40859_1698331249.hasNext();
                TransitionListener listener = var027539751E49B70605583F80C9C40859_1698331249.next();
                {
                    listener.startTransition(this, parent, child, DISAPPEARING);
                } //End block
            } //End collapsed parenthetic
        } //End block
        runChangeTransition(parent, child, DISAPPEARING);
        runDisappearingTransition(parent, child);
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //cancel(APPEARING);
        //cancel(CHANGE_DISAPPEARING);
        //if (mListeners != null) {
            //for (TransitionListener listener : mListeners) {
                //listener.startTransition(this, parent, child, DISAPPEARING);
            //}
        //}
        //runChangeTransition(parent, child, DISAPPEARING);
        //runDisappearingTransition(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.173 -0400", hash_original_method = "59CF94EEC1336BEEB8FFF5467E6ED5F9", hash_generated_method = "A29FAFF27DDBC6B66F44D8F3E67BE879")
    public void hideChild(ViewGroup parent, View child) {
        removeChild(parent, child);
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //removeChild(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.186 -0400", hash_original_method = "167EED27AB5F7469F2545513C43EBDC4", hash_generated_method = "33DF80809CD54F9F80083D96E59EE66F")
    public void addTransitionListener(TransitionListener listener) {
        {
            mListeners = new ArrayList<TransitionListener>();
        } //End block
        mListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //mListeners = new ArrayList<TransitionListener>();
        //}
        //mListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.201 -0400", hash_original_method = "CD0DE6419C69039B8FDEE8C2D5BC497D", hash_generated_method = "1088A5954536D6AEF84349B370DCD872")
    public void removeTransitionListener(TransitionListener listener) {
        mListeners.remove(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //return;
        //}
        //mListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.220 -0400", hash_original_method = "F0DD3EC0CE94CE6304D7C3009A3E39A6", hash_generated_method = "803B07706CE110785C17B09421D33C56")
    public List<TransitionListener> getTransitionListeners() {
        List<TransitionListener> varB4EAC82CA7396A68D541C85D26508E83_910656414 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_910656414 = mListeners;
        varB4EAC82CA7396A68D541C85D26508E83_910656414.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_910656414;
        // ---------- Original Method ----------
        //return mListeners;
    }

    
    public interface TransitionListener {

        
        public void startTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);

        
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.221 -0400", hash_original_field = "D65A82112F44124A2B9FDE00A6246728", hash_generated_field = "E63A0521AAA8C6DC4279BA44E098FD23")

    public static final int CHANGE_APPEARING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.221 -0400", hash_original_field = "6F62B99E30E6B4CA586C12E8B13A3B4A", hash_generated_field = "A5E247EB4D6439D9A98E49F907931252")

    public static final int CHANGE_DISAPPEARING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.236 -0400", hash_original_field = "1C2C691552DB12B6637FB16180CB8DEE", hash_generated_field = "F22B7CC5AA7D7298C87C59E48B6986CB")

    public static final int APPEARING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.237 -0400", hash_original_field = "26D6A6E008A00E881DA7073368B3FBCA", hash_generated_field = "2B4B660177B7589D2F5A7A330CB80759")

    public static final int DISAPPEARING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.238 -0400", hash_original_field = "F62AE2A917606476AA59A24B61225594", hash_generated_field = "F23425A4D82261A0713821E518F1C782")

    private static ObjectAnimator defaultChangeIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.238 -0400", hash_original_field = "8FE2012C5D3B66F186AE3B5608F5506B", hash_generated_field = "383D2DB6CC8BE4F70A8FC6AE24EF0892")

    private static ObjectAnimator defaultChangeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.238 -0400", hash_original_field = "9AB47D0B11CFD6785DD53FD6A9B89AC3", hash_generated_field = "9FE642298321DB1BFB3B90AC8C413400")

    private static ObjectAnimator defaultFadeIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.252 -0400", hash_original_field = "32DE7577E5C8E88AE24A2E7B696BED9F", hash_generated_field = "25D149E4F7D04D3FBA535A38951E6CA0")

    private static ObjectAnimator defaultFadeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.253 -0400", hash_original_field = "2588F8D6DA58076995259889823B1880", hash_generated_field = "B0EA698E636B3BDA7398DDB39E975802")

    private static long DEFAULT_DURATION = 300;
}

