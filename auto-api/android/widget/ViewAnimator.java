package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ViewAnimator extends FrameLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.395 -0400", hash_original_field = "EA21F533229388AA4B2EFE079FA29356", hash_generated_field = "A4199CA8B30F98AAF67F6FDF10E09266")

    int mWhichChild = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.396 -0400", hash_original_field = "819CF91F91F67E3ABFDBBF304392B421", hash_generated_field = "319BF9E49F2FBE9453A9508A3A60521D")

    boolean mFirstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.396 -0400", hash_original_field = "FDE1980A01124F9ECAD446EEE35F7267", hash_generated_field = "11022FC94DBD000AF0F23EE6D44DA07A")

    boolean mAnimateFirstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.396 -0400", hash_original_field = "69EE9328057C3731E3E5851972F2D1BA", hash_generated_field = "29299F27489816D586AD948F6D96C9C1")

    Animation mInAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.396 -0400", hash_original_field = "00AD3937DA6C2650F811216846F50E5C", hash_generated_field = "9E3A714F1340062D6D1C605D96F85572")

    Animation mOutAnimation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.396 -0400", hash_original_method = "66F6B937748E2D301A30C8F3ECD323BD", hash_generated_method = "F5891BCB82E2B84720B2BE366B889266")
    public  ViewAnimator(Context context) {
        super(context);
        initViewAnimator(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //initViewAnimator(context, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.397 -0400", hash_original_method = "F8EF7A2A27A81BBBD9162F58F1DAF59B", hash_generated_method = "2683784F75A8075DC36441AAD7E88BD5")
    public  ViewAnimator(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ViewAnimator);
        int resource;
        resource = a.getResourceId(com.android.internal.R.styleable.ViewAnimator_inAnimation, 0);
        {
            setInAnimation(context, resource);
        } //End block
        resource = a.getResourceId(com.android.internal.R.styleable.ViewAnimator_outAnimation, 0);
        {
            setOutAnimation(context, resource);
        } //End block
        boolean flag;
        flag = a.getBoolean(com.android.internal.R.styleable.ViewAnimator_animateFirstView, true);
        setAnimateFirstView(flag);
        a.recycle();
        initViewAnimator(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ViewAnimator);
        //int resource = a.getResourceId(com.android.internal.R.styleable.ViewAnimator_inAnimation, 0);
        //if (resource > 0) {
            //setInAnimation(context, resource);
        //}
        //resource = a.getResourceId(com.android.internal.R.styleable.ViewAnimator_outAnimation, 0);
        //if (resource > 0) {
            //setOutAnimation(context, resource);
        //}
        //boolean flag = a.getBoolean(com.android.internal.R.styleable.ViewAnimator_animateFirstView, true);
        //setAnimateFirstView(flag);
        //a.recycle();
        //initViewAnimator(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.397 -0400", hash_original_method = "6B106D21A6B322E95178F19E05B7CE37", hash_generated_method = "DC597F3BE1127793C34CBB2DC0AD1CF6")
    private void initViewAnimator(Context context, AttributeSet attrs) {
        {
            mMeasureAllChildren = true;
        } //End block
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.FrameLayout);
        boolean measureAllChildren;
        measureAllChildren = a.getBoolean(
                com.android.internal.R.styleable.FrameLayout_measureAllChildren, true);
        setMeasureAllChildren(measureAllChildren);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //if (attrs == null) {
            //mMeasureAllChildren = true;
            //return;
        //}
        //final TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.FrameLayout);
        //final boolean measureAllChildren = a.getBoolean(
                //com.android.internal.R.styleable.FrameLayout_measureAllChildren, true);
        //setMeasureAllChildren(measureAllChildren);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.398 -0400", hash_original_method = "886E9E30E7E0F1B550AD6251245A0536", hash_generated_method = "F73A7BF777AFA0C76CB036E807489DD7")
    @android.view.RemotableViewMethod
    public void setDisplayedChild(int whichChild) {
        mWhichChild = whichChild;
        {
            boolean var80A6E6A3EF2FA6F6EBD0DBBCBDE74B1B_705993463 = (whichChild >= getChildCount());
            {
                mWhichChild = 0;
            } //End block
            {
                mWhichChild = getChildCount() - 1;
            } //End block
        } //End collapsed parenthetic
        boolean hasFocus;
        hasFocus = getFocusedChild() != null;
        showOnly(mWhichChild);
        {
            requestFocus(FOCUS_FORWARD);
        } //End block
        // ---------- Original Method ----------
        //mWhichChild = whichChild;
        //if (whichChild >= getChildCount()) {
            //mWhichChild = 0;
        //} else if (whichChild < 0) {
            //mWhichChild = getChildCount() - 1;
        //}
        //boolean hasFocus = getFocusedChild() != null;
        //showOnly(mWhichChild);
        //if (hasFocus) {
            //requestFocus(FOCUS_FORWARD);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.398 -0400", hash_original_method = "EEFA4D3ABF985412351A1BD0CB5D6161", hash_generated_method = "E25E84E3083D945209AB611FE293A462")
    public int getDisplayedChild() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053902538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053902538;
        // ---------- Original Method ----------
        //return mWhichChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.398 -0400", hash_original_method = "EFCC34AA69F6F34103211EDFAD5FB56A", hash_generated_method = "3385562BAE55ABDC097B8B20904F2D01")
    @android.view.RemotableViewMethod
    public void showNext() {
        setDisplayedChild(mWhichChild + 1);
        // ---------- Original Method ----------
        //setDisplayedChild(mWhichChild + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.399 -0400", hash_original_method = "F846DD3340718784FB63764FD5BBF0F3", hash_generated_method = "67432F7150CA193FAF87FB8FB63A56B3")
    @android.view.RemotableViewMethod
    public void showPrevious() {
        setDisplayedChild(mWhichChild - 1);
        // ---------- Original Method ----------
        //setDisplayedChild(mWhichChild - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.414 -0400", hash_original_method = "821F94AAA9585776C884C184A81B321A", hash_generated_method = "8D15B66FB87576CBDB5B08DA0CF60B66")
     void showOnly(int childIndex, boolean animate) {
        int count;
        count = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    {
                        child.startAnimation(mInAnimation);
                    } //End block
                    child.setVisibility(View.VISIBLE);
                    mFirstTime = false;
                } //End block
                {
                    {
                        boolean var81139745BF79BA5868ED75871099FE0F_735999478 = (animate && mOutAnimation != null && child.getVisibility() == View.VISIBLE);
                        {
                            child.startAnimation(mOutAnimation);
                        } //End block
                        {
                            boolean var9D463B5B995FDD88822E7995879A0558_452665372 = (child.getAnimation() == mInAnimation);
                            child.clearAnimation();
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    child.setVisibility(View.GONE);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(childIndex);
        addTaint(animate);
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //for (int i = 0; i < count; i++) {
            //final View child = getChildAt(i);
            //if (i == childIndex) {
                //if (animate && mInAnimation != null) {
                    //child.startAnimation(mInAnimation);
                //}
                //child.setVisibility(View.VISIBLE);
                //mFirstTime = false;
            //} else {
                //if (animate && mOutAnimation != null && child.getVisibility() == View.VISIBLE) {
                    //child.startAnimation(mOutAnimation);
                //} else if (child.getAnimation() == mInAnimation)
                    //child.clearAnimation();
                //child.setVisibility(View.GONE);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.414 -0400", hash_original_method = "F76460515723C04BD015D3AE7F75A8EE", hash_generated_method = "63AFD19546DD049111522D74A3DD1521")
     void showOnly(int childIndex) {
        boolean animate;
        animate = (!mFirstTime || mAnimateFirstTime);
        showOnly(childIndex, animate);
        addTaint(childIndex);
        // ---------- Original Method ----------
        //final boolean animate = (!mFirstTime || mAnimateFirstTime);
        //showOnly(childIndex, animate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.419 -0400", hash_original_method = "B6265928EFB656804D99665538BC6B35", hash_generated_method = "42B93D76B6BB055CBD921854F0CA38F6")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        {
            boolean varA3E1D8A572B26FFC00DB96AA0A476440_1321741694 = (getChildCount() == 1);
            {
                child.setVisibility(View.VISIBLE);
            } //End block
            {
                child.setVisibility(View.GONE);
            } //End block
        } //End collapsed parenthetic
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //super.addView(child, index, params);
        //if (getChildCount() == 1) {
            //child.setVisibility(View.VISIBLE);
        //} else {
            //child.setVisibility(View.GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.426 -0400", hash_original_method = "2876DED6BDEBD13B29080CE11E9063E4", hash_generated_method = "BCAA78D61167CAAC0C5353EF23AEBF73")
    @Override
    public void removeAllViews() {
        super.removeAllViews();
        mWhichChild = 0;
        mFirstTime = true;
        // ---------- Original Method ----------
        //super.removeAllViews();
        //mWhichChild = 0;
        //mFirstTime = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.427 -0400", hash_original_method = "96F6E7BCEF91AFFF9BCD877C8E22A578", hash_generated_method = "614744C74953FE53740E6EB11A03D37C")
    @Override
    public void removeView(View view) {
        int index;
        index = indexOfChild(view);
        {
            removeViewAt(index);
        } //End block
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //final int index = indexOfChild(view);
        //if (index >= 0) {
            //removeViewAt(index);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.427 -0400", hash_original_method = "39615E53633A229D459BCD129C9447D8", hash_generated_method = "585D73E65CAA692CED682D5A12C86998")
    @Override
    public void removeViewAt(int index) {
        super.removeViewAt(index);
        int childCount;
        childCount = getChildCount();
        {
            mWhichChild = 0;
            mFirstTime = true;
        } //End block
        {
            setDisplayedChild(childCount - 1);
        } //End block
        {
            setDisplayedChild(mWhichChild);
        } //End block
        addTaint(index);
        // ---------- Original Method ----------
        //super.removeViewAt(index);
        //final int childCount = getChildCount();
        //if (childCount == 0) {
            //mWhichChild = 0;
            //mFirstTime = true;
        //} else if (mWhichChild >= childCount) {
            //setDisplayedChild(childCount - 1);
        //} else if (mWhichChild == index) {
            //setDisplayedChild(mWhichChild);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.427 -0400", hash_original_method = "E39155B01A3404328E46119B32BA0220", hash_generated_method = "484291967760BFA5EB0E8C909C473FEE")
    public void removeViewInLayout(View view) {
        removeView(view);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //removeView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.428 -0400", hash_original_method = "E3FA5900F02B916C2065C9EFA9728FDF", hash_generated_method = "4AE4982D19671926BB76749CBF4B2BFB")
    public void removeViews(int start, int count) {
        super.removeViews(start, count);
        {
            boolean varF370735710C80808B6618BA2D491D045_1185998408 = (getChildCount() == 0);
            {
                mWhichChild = 0;
                mFirstTime = true;
            } //End block
            {
                setDisplayedChild(mWhichChild);
            } //End block
        } //End collapsed parenthetic
        addTaint(start);
        addTaint(count);
        // ---------- Original Method ----------
        //super.removeViews(start, count);
        //if (getChildCount() == 0) {
            //mWhichChild = 0;
            //mFirstTime = true;
        //} else if (mWhichChild >= start && mWhichChild < start + count) {
            //setDisplayedChild(mWhichChild);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.435 -0400", hash_original_method = "76C75A4C2363189C0B16150C5B7ECE1A", hash_generated_method = "B7F52FCBC6084063169C91E64F516765")
    public void removeViewsInLayout(int start, int count) {
        removeViews(start, count);
        addTaint(start);
        addTaint(count);
        // ---------- Original Method ----------
        //removeViews(start, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.439 -0400", hash_original_method = "844041B2553847C9CC4B36B79F20B7EC", hash_generated_method = "3169E8D469B5A54DEDE2D1507A2D92F3")
    public View getCurrentView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1163114135 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1163114135 = getChildAt(mWhichChild);
        varB4EAC82CA7396A68D541C85D26508E83_1163114135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1163114135;
        // ---------- Original Method ----------
        //return getChildAt(mWhichChild);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.440 -0400", hash_original_method = "9649A93AAEAC388E07F52DE503C0F001", hash_generated_method = "0E290C79D1EEF481A9FB34B4C906429E")
    public Animation getInAnimation() {
        Animation varB4EAC82CA7396A68D541C85D26508E83_1202624951 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1202624951 = mInAnimation;
        varB4EAC82CA7396A68D541C85D26508E83_1202624951.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1202624951;
        // ---------- Original Method ----------
        //return mInAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.440 -0400", hash_original_method = "3A3CF51D7EEDC43DA48CCA94EBF1692F", hash_generated_method = "E7E7233C13774685AA7A36D3ECAD7F34")
    public void setInAnimation(Animation inAnimation) {
        mInAnimation = inAnimation;
        // ---------- Original Method ----------
        //mInAnimation = inAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.454 -0400", hash_original_method = "966AEDC04CB1C3738AA44B09B913030C", hash_generated_method = "67852A5293203DCEA16579862865A700")
    public Animation getOutAnimation() {
        Animation varB4EAC82CA7396A68D541C85D26508E83_871648872 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_871648872 = mOutAnimation;
        varB4EAC82CA7396A68D541C85D26508E83_871648872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_871648872;
        // ---------- Original Method ----------
        //return mOutAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.454 -0400", hash_original_method = "E7C95EC2E63D184B364637DD8AD18F73", hash_generated_method = "7702771938195AF2F91DFC7114BC7EB4")
    public void setOutAnimation(Animation outAnimation) {
        mOutAnimation = outAnimation;
        // ---------- Original Method ----------
        //mOutAnimation = outAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.455 -0400", hash_original_method = "4B14A90FDB2491821F3B7183A1AB7EB4", hash_generated_method = "72F8B46EC4F0CB25C563959F022D0D41")
    public void setInAnimation(Context context, int resourceID) {
        setInAnimation(AnimationUtils.loadAnimation(context, resourceID));
        addTaint(context.getTaint());
        addTaint(resourceID);
        // ---------- Original Method ----------
        //setInAnimation(AnimationUtils.loadAnimation(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.455 -0400", hash_original_method = "C68FA8DD73709498CDF74B32AA0794E0", hash_generated_method = "D7127FF4992BC359B69996AA480B662A")
    public void setOutAnimation(Context context, int resourceID) {
        setOutAnimation(AnimationUtils.loadAnimation(context, resourceID));
        addTaint(context.getTaint());
        addTaint(resourceID);
        // ---------- Original Method ----------
        //setOutAnimation(AnimationUtils.loadAnimation(context, resourceID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.455 -0400", hash_original_method = "8FC95409534ABC48E92905DC8C518CE2", hash_generated_method = "B8F320B30FC7DD41541BCFCAA6FCA367")
    public void setAnimateFirstView(boolean animate) {
        mAnimateFirstTime = animate;
        // ---------- Original Method ----------
        //mAnimateFirstTime = animate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.456 -0400", hash_original_method = "0B91CAAE76789C8A4B2B18C9D0AAF852", hash_generated_method = "17A60DA24123924D03F897BEE50770D2")
    @Override
    public int getBaseline() {
        {
            boolean var58F8C7D88FB1D1DD9A5513FB3A54B5BC_1397310189 = ((getCurrentView() != null));
            Object varA7D65C03FD7AD29B41A2824896EF9900_159732123 = (getCurrentView().getBaseline());
            Object varEC5F70FA49520212A319ACA653FC0209_1665772155 = (super.getBaseline());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244655286 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244655286;
        // ---------- Original Method ----------
        //return (getCurrentView() != null) ? getCurrentView().getBaseline() : super.getBaseline();
    }

    
}

