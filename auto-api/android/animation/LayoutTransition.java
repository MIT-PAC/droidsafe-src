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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.060 -0400", hash_original_field = "39AB1186E068767124693950E5241B0C", hash_generated_field = "75E407E7333EB2D59F0ED20EAD88E34E")

    private Animator mDisappearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.077 -0400", hash_original_field = "898C2D1A5742BD7C3E8E82A9D2E0437F", hash_generated_field = "F269A266B00229E5734E5B06B519CF4D")

    private Animator mAppearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.079 -0400", hash_original_field = "1F332D66976C447496CA1B80691E0B10", hash_generated_field = "8569DC611F2B171274327A8DFA6BA137")

    private Animator mChangingAppearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.080 -0400", hash_original_field = "765E4DC7F9110BDE36ADFF990E8FCAEC", hash_generated_field = "295E17A6E98CD794E342CB0517EC6D87")

    private Animator mChangingDisappearingAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.081 -0400", hash_original_field = "42A198EE1914D883D37C3ED3B1135670", hash_generated_field = "A5577F39C2927B8AF67AB98D2B541767")

    private long mChangingAppearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.082 -0400", hash_original_field = "218EB6559CA33E7E919115954C4DB0D9", hash_generated_field = "463C58461ED789E13A8EEFA59D868711")

    private long mChangingDisappearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.083 -0400", hash_original_field = "80A25498D18A6710708CD4BFB8EF24DA", hash_generated_field = "B1A031389441AED70DA8674A9CDD4213")

    private long mAppearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.087 -0400", hash_original_field = "5ECCF0345DF5DEDAB0F5A39516048905", hash_generated_field = "83E0F49BD50CEA25C451F339C8D938A9")

    private long mDisappearingDuration = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.089 -0400", hash_original_field = "91B6925F9416CAE38F44C8180EE00D62", hash_generated_field = "6B89F75DB8D18324FDA519C3D6E9C3E1")

    private long mAppearingDelay = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.092 -0400", hash_original_field = "A22E36387E60BA8EEB738DFDB9781A6E", hash_generated_field = "EE2346FE7169B9AB19EA56A1B913BA60")

    private long mDisappearingDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.097 -0400", hash_original_field = "AD69818355B6F5E9EB967A4A202385FA", hash_generated_field = "B72CDDC89FC836C2633888FAF590185E")

    private long mChangingAppearingDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.099 -0400", hash_original_field = "51E19A1306CC67939DEB066B90A6AA30", hash_generated_field = "A8B24D136EA5EC6890818CC10AD17C05")

    private long mChangingDisappearingDelay = DEFAULT_DURATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.101 -0400", hash_original_field = "D4E1B66EF88324ED6FA8088CEB4CBE14", hash_generated_field = "715370DF92240EF0021A1CA25FFC6060")

    private long mChangingAppearingStagger = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.103 -0400", hash_original_field = "C9AB7CA6788BC42432306ED5D9FA4751", hash_generated_field = "95B0E8048A3A312DC3734A9E265C8176")

    private long mChangingDisappearingStagger = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.108 -0400", hash_original_field = "E83595FF742C9B6EB99D19F9305ABBA8", hash_generated_field = "3164C261F18E7FCC582837BE79E7E946")

    private TimeInterpolator mAppearingInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.110 -0400", hash_original_field = "D1BFED2C966B3C158EF425A93E73D95C", hash_generated_field = "44480B19C903085EE0CD5A188A9C0404")

    private TimeInterpolator mDisappearingInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.112 -0400", hash_original_field = "9BB07EDE1DBE6A1B275E097543CFA633", hash_generated_field = "6AD343EAC627700E45ADD7F9BC2E498E")

    private TimeInterpolator mChangingAppearingInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.115 -0400", hash_original_field = "AB42CFE8B0A8C2974D7F84A32756AC89", hash_generated_field = "002DBF51FA8D471B18C74A9B6E24123D")

    private TimeInterpolator mChangingDisappearingInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.118 -0400", hash_original_field = "833A7AADDF3C4472D3F75449099C7417", hash_generated_field = "4CD16B39839DD06A15F21E2AB5E191BB")

    private HashMap<View, Animator> pendingAnimations = new HashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.121 -0400", hash_original_field = "1A6E910FE59BBBBACA171B049921002A", hash_generated_field = "371FB10BEA8820BD50A7C52A1EE3E0B9")

    private LinkedHashMap<View, Animator> currentChangingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.124 -0400", hash_original_field = "54075758A22D2683EE0C4649851E0018", hash_generated_field = "7D27A0BC47F29ED76BA5422C9FE81D07")

    private LinkedHashMap<View, Animator> currentAppearingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.128 -0400", hash_original_field = "0F0C1A65AE21602FD367A69818E8A1E7", hash_generated_field = "AD4FA88381487A98E667BBD6F1FE5C0F")

    private LinkedHashMap<View, Animator> currentDisappearingAnimations = new LinkedHashMap<View, Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.131 -0400", hash_original_field = "1FEEE2ED7992F5B46B7D29EC9654E64D", hash_generated_field = "6AF2DBAD6623E516A768E22B61590762")

    private HashMap<View, View.OnLayoutChangeListener> layoutChangeListenerMap = new HashMap<View, View.OnLayoutChangeListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.135 -0400", hash_original_field = "6210BD7488CCE5FE8B740760087A30E6", hash_generated_field = "62799693C20798E5E433F1B0AF6A3DC5")

    private long staggerDelay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.139 -0400", hash_original_field = "2F2828353527044AFD6820F84A8A1FAB", hash_generated_field = "F165C7B3902835B1E7EE6F9F45B1EBD6")

    private ArrayList<TransitionListener> mListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.143 -0400", hash_original_field = "57CB5A16236BA625AFCBA400CC996A11", hash_generated_field = "E61C51FC893874C4BB912FEBE4441512")

    private boolean mAnimateParentHierarchy = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.191 -0400", hash_original_method = "52DB630B34835349C84181A9ADA45542", hash_generated_method = "B5AF3E8337270E86D71495E381BA6591")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.221 -0400", hash_original_method = "24394BA80BA94B39DCA5B438DC3EBDB1", hash_generated_method = "CF9B4395D785358863CAB9605D225CA9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.247 -0400", hash_original_method = "939FBD8B4C5590BFCAA9E14AEC15ED50", hash_generated_method = "BCE6354327899DE2956D4D80C0566F68")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.262 -0400", hash_original_method = "3F88CD33B6864BEBC3B576EB6504FB35", hash_generated_method = "50D64E1FCBCEDF0BB62A6AE2E8F840A6")
    public long getStartDelay(int transitionType) {
        addTaint(transitionType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_144512219 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_144512219;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.286 -0400", hash_original_method = "2851CBF3AA331995F771441E9F6D0AAD", hash_generated_method = "93E3AFDD083BDB202331DF6E211BA063")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.305 -0400", hash_original_method = "F259A86CD3BB3A6D515EAAF2335DC6DD", hash_generated_method = "C86CD9A0CCA58390F93197DB625079DC")
    public long getDuration(int transitionType) {
        addTaint(transitionType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_974552222 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_974552222;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.320 -0400", hash_original_method = "DB3710D74B2FBFD7C44693C4FBA40808", hash_generated_method = "D9C6245F1664A3D7DBFC6A5958CE4B39")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.328 -0400", hash_original_method = "70FCFF77D9C405B5FA9E6B4579BF3D8B", hash_generated_method = "8C64DCD2EAA4D95BF49C092212D72B96")
    public long getStagger(int transitionType) {
        addTaint(transitionType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1793981435 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1793981435;
        // ---------- Original Method ----------
        //switch (transitionType) {
            //case CHANGE_APPEARING:
                //return mChangingAppearingStagger;
            //case CHANGE_DISAPPEARING:
                //return mChangingDisappearingStagger;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.360 -0400", hash_original_method = "2AD5234EB4F80ED9C0D5C1F0BD7735E5", hash_generated_method = "02FFFA304AEDF303F30ED9BE4A859608")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.394 -0400", hash_original_method = "11C2A17826922B819D4ABA31B32AF7FD", hash_generated_method = "64315C5FD50B682935362C2C46212990")
    public TimeInterpolator getInterpolator(int transitionType) {
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1988154384 = null; //Variable for return #1
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1143864055 = null; //Variable for return #2
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_2079940473 = null; //Variable for return #3
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_572713748 = null; //Variable for return #4
        TimeInterpolator varB4EAC82CA7396A68D541C85D26508E83_1654765935 = null; //Variable for return #5
        //Begin case CHANGE_APPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_1988154384 = mChangingAppearingInterpolator;
        //End case CHANGE_APPEARING 
        //Begin case CHANGE_DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_1143864055 = mChangingDisappearingInterpolator;
        //End case CHANGE_DISAPPEARING 
        //Begin case APPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_2079940473 = mAppearingInterpolator;
        //End case APPEARING 
        //Begin case DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_572713748 = mDisappearingInterpolator;
        //End case DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_1654765935 = null;
        addTaint(transitionType);
        TimeInterpolator varA7E53CE21691AB073D9660D615818899_270181311; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_270181311 = varB4EAC82CA7396A68D541C85D26508E83_1988154384;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_270181311 = varB4EAC82CA7396A68D541C85D26508E83_1143864055;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_270181311 = varB4EAC82CA7396A68D541C85D26508E83_2079940473;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_270181311 = varB4EAC82CA7396A68D541C85D26508E83_572713748;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_270181311 = varB4EAC82CA7396A68D541C85D26508E83_1654765935;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_270181311.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_270181311;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.425 -0400", hash_original_method = "1CE02B172FBE4A7CE10D1F87669E47EA", hash_generated_method = "740B242662C22BEB9E4E968A95487964")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.459 -0400", hash_original_method = "FF737FAA09DE0C7945DD1E6E302C4C89", hash_generated_method = "D5549CD67E0C4775F0A12861D30FCE2C")
    public Animator getAnimator(int transitionType) {
        Animator varB4EAC82CA7396A68D541C85D26508E83_655460994 = null; //Variable for return #1
        Animator varB4EAC82CA7396A68D541C85D26508E83_334333216 = null; //Variable for return #2
        Animator varB4EAC82CA7396A68D541C85D26508E83_399201918 = null; //Variable for return #3
        Animator varB4EAC82CA7396A68D541C85D26508E83_331304189 = null; //Variable for return #4
        Animator varB4EAC82CA7396A68D541C85D26508E83_640519074 = null; //Variable for return #5
        //Begin case CHANGE_APPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_655460994 = mChangingAppearingAnim;
        //End case CHANGE_APPEARING 
        //Begin case CHANGE_DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_334333216 = mChangingDisappearingAnim;
        //End case CHANGE_DISAPPEARING 
        //Begin case APPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_399201918 = mAppearingAnim;
        //End case APPEARING 
        //Begin case DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_331304189 = mDisappearingAnim;
        //End case DISAPPEARING 
        varB4EAC82CA7396A68D541C85D26508E83_640519074 = null;
        addTaint(transitionType);
        Animator varA7E53CE21691AB073D9660D615818899_1979335866; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1979335866 = varB4EAC82CA7396A68D541C85D26508E83_655460994;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1979335866 = varB4EAC82CA7396A68D541C85D26508E83_334333216;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1979335866 = varB4EAC82CA7396A68D541C85D26508E83_399201918;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1979335866 = varB4EAC82CA7396A68D541C85D26508E83_331304189;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1979335866 = varB4EAC82CA7396A68D541C85D26508E83_640519074;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1979335866.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1979335866;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.585 -0400", hash_original_method = "388160589FFEE2126FAAE5CBAFC89998", hash_generated_method = "1F63985DCB41E23C9CE6B06C0505E746")
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
            boolean var8AD88F416FDBC789F76B74DE1C37B0E1_1400673608 = (!observer.isAlive());
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.574 -0400", hash_original_method = "6C01974BA3CD333428484527C9FBE54F", hash_generated_method = "7735159C9C0C0374FB59C8A30B38341A")
            public boolean onPreDraw() {
                //DSFIXME:  CODE0009: Possible callback target function detected
                parent.getViewTreeObserver().removeOnPreDrawListener(this);
                int count;
                count = layoutChangeListenerMap.size();
                {
                    Collection<View> views;
                    views = layoutChangeListenerMap.keySet();
                    {
                        Iterator<View> var6B1B56E78019197FFF75517BC796AC75_575504041 = (views).iterator();
                        var6B1B56E78019197FFF75517BC796AC75_575504041.hasNext();
                        View view = var6B1B56E78019197FFF75517BC796AC75_575504041.next();
                        {
                            View.OnLayoutChangeListener listener;
                            listener = layoutChangeListenerMap.get(view);
                            view.removeOnLayoutChangeListener(listener);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                layoutChangeListenerMap.clear();
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1581574648 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1581574648;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.595 -0400", hash_original_method = "5ECFD2D430BE870F40C042D01FD8A2D6", hash_generated_method = "CEE41014B49B701489653EF4BEF3638A")
    public void setAnimateParentHierarchy(boolean animateParentHierarchy) {
        mAnimateParentHierarchy = animateParentHierarchy;
        // ---------- Original Method ----------
        //mAnimateParentHierarchy = animateParentHierarchy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.667 -0400", hash_original_method = "108854515942B7EF6A63499B84E31466", hash_generated_method = "BAE766841CDAC85EBBF9D485C68D12C3")
    private void setupChangeAnimation(final ViewGroup parent, final int changeReason,
            Animator baseAnimator, final long duration, final View child) {
        {
            boolean varA6A7315ADDDC59C70ED73956C763A706_598106775 = (layoutChangeListenerMap.get(child) != null);
        } //End collapsed parenthetic
        Animator anim;
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.622 -0400", hash_original_method = "81B18D5FBD0385E26F1E055D2C44BFFA", hash_generated_method = "5A5AED5D7799D8D31962A97F09B49A74")
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
        View.OnLayoutChangeListener listener;
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
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_2115323691 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_2115323691.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_2115323691.next();
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.644 -0400", hash_original_method = "06655B4777E7383270776E7CEC1CCF7E", hash_generated_method = "16F2B3561150327735D9155EF6C6B5A6")
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:36.659 -0400", hash_original_method = "DE5B5D0FB75885026A5DD6EBE7BC56A2", hash_generated_method = "87696B60C5A7CF409AFE900FA86FA6B4")
            @Override
            public void onAnimationEnd(Animator animator) {
                //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.216 -0400", hash_original_method = "7222BE89A56886A0CF62DC8766C00475", hash_generated_method = "71A9B15C1CFFC0E8163F69A91BF9D221")
    public void startChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy;
        currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        {
            Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1724331754 = (currentAnimCopy.values()).iterator();
            var77A69CCC7893588B99D9F323E4F0D0AD_1724331754.hasNext();
            Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1724331754.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.377 -0400", hash_original_method = "7BA742550F1E1298AB8FE77F45C4383D", hash_generated_method = "3C7A139897596860ADAC04F3E1732D8B")
    public void endChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy;
        currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        {
            Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_66174066 = (currentAnimCopy.values()).iterator();
            var77A69CCC7893588B99D9F323E4F0D0AD_66174066.hasNext();
            Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_66174066.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.394 -0400", hash_original_method = "8C9364165F532DD8BD43415668542398", hash_generated_method = "728E5CCAE28B011CE3C312B25BA0CB6B")
    public boolean isChangingLayout() {
        boolean var4077384608DE00EFE78F41629DE0A95B_1920039651 = ((currentChangingAnimations.size() > 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065199517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065199517;
        // ---------- Original Method ----------
        //return (currentChangingAnimations.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.404 -0400", hash_original_method = "7F683046BB72ECC23A172B1D3B81B266", hash_generated_method = "489505E105D4D41FAEBCA0A907F89691")
    public boolean isRunning() {
        boolean var987B4F52345B82CBBAB6F416FA45A0C5_1741257217 = ((currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 ||
                currentDisappearingAnimations.size() > 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_11433893 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_11433893;
        // ---------- Original Method ----------
        //return (currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 ||
                //currentDisappearingAnimations.size() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.705 -0400", hash_original_method = "2E46A59670A61A0AF64FD97BDAF7B728", hash_generated_method = "8C29A6A8ADDB02B89B97DDA20CBDB130")
    public void cancel() {
        {
            boolean var33AE39A73D9B32AC5849C5A957F93302_1237850735 = (currentChangingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_329244848 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_329244848.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_329244848.next();
                    {
                        anim.cancel();
                    } //End block
                } //End collapsed parenthetic
                currentChangingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var581E5FE1178D7616A969479C9EF98728_807912381 = (currentAppearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1681709079 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1681709079.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1681709079.next();
                    {
                        anim.end();
                    } //End block
                } //End collapsed parenthetic
                currentAppearingAnimations.clear();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var08F255EDB4B7971930CFAED58C7D7CB3_1294414177 = (currentDisappearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1463166774 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1463166774.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1463166774.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.285 -0400", hash_original_method = "19B870791205108BA3B602A2E8CB5138", hash_generated_method = "F1DCCF4904FE6D2E2E6E69E4866C61F9")
    public void cancel(int transitionType) {
        //Begin case CHANGE_APPEARING CHANGE_DISAPPEARING 
        {
            boolean var33AE39A73D9B32AC5849C5A957F93302_1385861123 = (currentChangingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_273383490 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_273383490.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_273383490.next();
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
            boolean var581E5FE1178D7616A969479C9EF98728_1302758661 = (currentAppearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_1184266613 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_1184266613.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_1184266613.next();
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
            boolean var08F255EDB4B7971930CFAED58C7D7CB3_1767136968 = (currentDisappearingAnimations.size() > 0);
            {
                LinkedHashMap<View, Animator> currentAnimCopy;
                currentAnimCopy = (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                {
                    Iterator<Animator> var77A69CCC7893588B99D9F323E4F0D0AD_702932746 = (currentAnimCopy.values()).iterator();
                    var77A69CCC7893588B99D9F323E4F0D0AD_702932746.hasNext();
                    Animator anim = var77A69CCC7893588B99D9F323E4F0D0AD_702932746.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.509 -0400", hash_original_method = "071036D6A0EA050ACF09A35752DC1D52", hash_generated_method = "6D5E1AB25155B5C7C013DC4BFE2559F3")
    private void runAppearingTransition(final ViewGroup parent, final View child) {
        Animator currentAnimation;
        currentAnimation = currentDisappearingAnimations.get(child);
        {
            currentAnimation.cancel();
        } //End block
        {
            {
                {
                    Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1958176593 = (mListeners).iterator();
                    var027539751E49B70605583F80C9C40859_1958176593.hasNext();
                    TransitionListener listener = var027539751E49B70605583F80C9C40859_1958176593.next();
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.508 -0400", hash_original_method = "494D571A7E2D39F79DD71B48D4E2ACB8", hash_generated_method = "15BCAD45E89B43612A56E07CB1F342DC")
                @Override
                public void onAnimationEnd(Animator anim) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    currentAppearingAnimations.remove(child);
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1451023190 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_1451023190.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_1451023190.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.933 -0400", hash_original_method = "202CDBACC5F0926CC1D7E1540267464D", hash_generated_method = "880984D09465FAABB305F668650510DB")
    private void runDisappearingTransition(final ViewGroup parent, final View child) {
        Animator currentAnimation;
        currentAnimation = currentAppearingAnimations.get(child);
        {
            currentAnimation.cancel();
        } //End block
        {
            {
                {
                    Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_361957095 = (mListeners).iterator();
                    var027539751E49B70605583F80C9C40859_361957095.hasNext();
                    TransitionListener listener = var027539751E49B70605583F80C9C40859_361957095.next();
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.923 -0400", hash_original_method = "29C17A3026C40266B26AB145A51034B4", hash_generated_method = "B13227CBF2D496C4B38273538D45F762")
                @Override
                public void onAnimationEnd(Animator anim) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    currentDisappearingAnimations.remove(child);
                    {
                        Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1770650449 = (mListeners).iterator();
                        var027539751E49B70605583F80C9C40859_1770650449.hasNext();
                        TransitionListener listener = var027539751E49B70605583F80C9C40859_1770650449.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.171 -0400", hash_original_method = "05533C05F33D5C5B655A5BABA4CC6F65", hash_generated_method = "66CE3ED665DB8311329EA369A7F16EDF")
    public void addChild(ViewGroup parent, View child) {
        cancel(DISAPPEARING);
        cancel(CHANGE_APPEARING);
        {
            {
                Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1052276916 = (mListeners).iterator();
                var027539751E49B70605583F80C9C40859_1052276916.hasNext();
                TransitionListener listener = var027539751E49B70605583F80C9C40859_1052276916.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.182 -0400", hash_original_method = "5867E97EE566113A4AD2D7416A9B4CB1", hash_generated_method = "95C99C73B2C8A5095E34435724B28DE6")
    public void showChild(ViewGroup parent, View child) {
        addChild(parent, child);
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //addChild(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.362 -0400", hash_original_method = "E23F457F66AC508EC3728A00193F4832", hash_generated_method = "1E12F39E192CD6138EC6052BDAF3B2EB")
    public void removeChild(ViewGroup parent, View child) {
        cancel(APPEARING);
        cancel(CHANGE_DISAPPEARING);
        {
            {
                Iterator<TransitionListener> var027539751E49B70605583F80C9C40859_1360265459 = (mListeners).iterator();
                var027539751E49B70605583F80C9C40859_1360265459.hasNext();
                TransitionListener listener = var027539751E49B70605583F80C9C40859_1360265459.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.366 -0400", hash_original_method = "59CF94EEC1336BEEB8FFF5467E6ED5F9", hash_generated_method = "A29FAFF27DDBC6B66F44D8F3E67BE879")
    public void hideChild(ViewGroup parent, View child) {
        removeChild(parent, child);
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //removeChild(parent, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.381 -0400", hash_original_method = "167EED27AB5F7469F2545513C43EBDC4", hash_generated_method = "33DF80809CD54F9F80083D96E59EE66F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.394 -0400", hash_original_method = "CD0DE6419C69039B8FDEE8C2D5BC497D", hash_generated_method = "1088A5954536D6AEF84349B370DCD872")
    public void removeTransitionListener(TransitionListener listener) {
        mListeners.remove(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //return;
        //}
        //mListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.396 -0400", hash_original_method = "F0DD3EC0CE94CE6304D7C3009A3E39A6", hash_generated_method = "2018BA79DD4F39A7181A0FA8862B4D6F")
    public List<TransitionListener> getTransitionListeners() {
        List<TransitionListener> varB4EAC82CA7396A68D541C85D26508E83_1949429142 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1949429142 = mListeners;
        varB4EAC82CA7396A68D541C85D26508E83_1949429142.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1949429142;
        // ---------- Original Method ----------
        //return mListeners;
    }

    
    public interface TransitionListener {

        
        public void startTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);

        
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.397 -0400", hash_original_field = "D65A82112F44124A2B9FDE00A6246728", hash_generated_field = "E63A0521AAA8C6DC4279BA44E098FD23")

    public static final int CHANGE_APPEARING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.398 -0400", hash_original_field = "6F62B99E30E6B4CA586C12E8B13A3B4A", hash_generated_field = "A5E247EB4D6439D9A98E49F907931252")

    public static final int CHANGE_DISAPPEARING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.399 -0400", hash_original_field = "1C2C691552DB12B6637FB16180CB8DEE", hash_generated_field = "F22B7CC5AA7D7298C87C59E48B6986CB")

    public static final int APPEARING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.399 -0400", hash_original_field = "26D6A6E008A00E881DA7073368B3FBCA", hash_generated_field = "2B4B660177B7589D2F5A7A330CB80759")

    public static final int DISAPPEARING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.421 -0400", hash_original_field = "F62AE2A917606476AA59A24B61225594", hash_generated_field = "F23425A4D82261A0713821E518F1C782")

    private static ObjectAnimator defaultChangeIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.421 -0400", hash_original_field = "8FE2012C5D3B66F186AE3B5608F5506B", hash_generated_field = "383D2DB6CC8BE4F70A8FC6AE24EF0892")

    private static ObjectAnimator defaultChangeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.422 -0400", hash_original_field = "9AB47D0B11CFD6785DD53FD6A9B89AC3", hash_generated_field = "9FE642298321DB1BFB3B90AC8C413400")

    private static ObjectAnimator defaultFadeIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.423 -0400", hash_original_field = "32DE7577E5C8E88AE24A2E7B696BED9F", hash_generated_field = "25D149E4F7D04D3FBA535A38951E6CA0")

    private static ObjectAnimator defaultFadeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.423 -0400", hash_original_field = "2588F8D6DA58076995259889823B1880", hash_generated_field = "B0EA698E636B3BDA7398DDB39E975802")

    private static long DEFAULT_DURATION = 300;
}

