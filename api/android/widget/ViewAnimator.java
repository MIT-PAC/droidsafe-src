package android.widget;

// Droidsafe Imports
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ViewAnimator extends FrameLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.203 -0400", hash_original_field = "EA21F533229388AA4B2EFE079FA29356", hash_generated_field = "A4199CA8B30F98AAF67F6FDF10E09266")

    int mWhichChild = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.203 -0400", hash_original_field = "819CF91F91F67E3ABFDBBF304392B421", hash_generated_field = "319BF9E49F2FBE9453A9508A3A60521D")

    boolean mFirstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.203 -0400", hash_original_field = "FDE1980A01124F9ECAD446EEE35F7267", hash_generated_field = "11022FC94DBD000AF0F23EE6D44DA07A")

    boolean mAnimateFirstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.204 -0400", hash_original_field = "69EE9328057C3731E3E5851972F2D1BA", hash_generated_field = "29299F27489816D586AD948F6D96C9C1")

    Animation mInAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.204 -0400", hash_original_field = "00AD3937DA6C2650F811216846F50E5C", hash_generated_field = "9E3A714F1340062D6D1C605D96F85572")

    Animation mOutAnimation;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.204 -0400", hash_original_method = "66F6B937748E2D301A30C8F3ECD323BD", hash_generated_method = "03C6B7C68A925262E4CD3D5DC2B4A625")
    public  ViewAnimator(Context context) {
        super(context);
        addTaint(context.getTaint());
        initViewAnimator(context, null);
        // ---------- Original Method ----------
        //initViewAnimator(context, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.205 -0400", hash_original_method = "F8EF7A2A27A81BBBD9162F58F1DAF59B", hash_generated_method = "5292DC58EC78DF5F1572327AD67AFBA2")
    public  ViewAnimator(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ViewAnimator);
        int resource = a.getResourceId(com.android.internal.R.styleable.ViewAnimator_inAnimation, 0);
        if(resource > 0)        
        {
            setInAnimation(context, resource);
        } //End block
        resource = a.getResourceId(com.android.internal.R.styleable.ViewAnimator_outAnimation, 0);
        if(resource > 0)        
        {
            setOutAnimation(context, resource);
        } //End block
        boolean flag = a.getBoolean(com.android.internal.R.styleable.ViewAnimator_animateFirstView, true);
        setAnimateFirstView(flag);
        a.recycle();
        initViewAnimator(context, attrs);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.205 -0400", hash_original_method = "6B106D21A6B322E95178F19E05B7CE37", hash_generated_method = "213B99B199BEBC90733945C14C617525")
    private void initViewAnimator(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        if(attrs == null)        
        {
            mMeasureAllChildren = true;
            return;
        } //End block
        final TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.FrameLayout);
        final boolean measureAllChildren = a.getBoolean(
                com.android.internal.R.styleable.FrameLayout_measureAllChildren, true);
        setMeasureAllChildren(measureAllChildren);
        a.recycle();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.206 -0400", hash_original_method = "886E9E30E7E0F1B550AD6251245A0536", hash_generated_method = "B0B1E86F2BB8BE1005DD6B1D7F77B1D9")
    @android.view.RemotableViewMethod
    public void setDisplayedChild(int whichChild) {
        mWhichChild = whichChild;
        if(whichChild >= getChildCount())        
        {
            mWhichChild = 0;
        } //End block
        else
        if(whichChild < 0)        
        {
            mWhichChild = getChildCount() - 1;
        } //End block
        boolean hasFocus = getFocusedChild() != null;
        showOnly(mWhichChild);
        if(hasFocus)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.207 -0400", hash_original_method = "EEFA4D3ABF985412351A1BD0CB5D6161", hash_generated_method = "3923A6FFC40B0E6C25BAA19D9EED0901")
    public int getDisplayedChild() {
        int varDB5BE583416C3068C849D51E047EB136_696773621 = (mWhichChild);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_66829446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_66829446;
        // ---------- Original Method ----------
        //return mWhichChild;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.207 -0400", hash_original_method = "EFCC34AA69F6F34103211EDFAD5FB56A", hash_generated_method = "3385562BAE55ABDC097B8B20904F2D01")
    @android.view.RemotableViewMethod
    public void showNext() {
        setDisplayedChild(mWhichChild + 1);
        // ---------- Original Method ----------
        //setDisplayedChild(mWhichChild + 1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.207 -0400", hash_original_method = "F846DD3340718784FB63764FD5BBF0F3", hash_generated_method = "67432F7150CA193FAF87FB8FB63A56B3")
    @android.view.RemotableViewMethod
    public void showPrevious() {
        setDisplayedChild(mWhichChild - 1);
        // ---------- Original Method ----------
        //setDisplayedChild(mWhichChild - 1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.208 -0400", hash_original_method = "821F94AAA9585776C884C184A81B321A", hash_generated_method = "A02DD7BC39815085257A8E1C4DF61279")
     void showOnly(int childIndex, boolean animate) {
        addTaint(animate);
        addTaint(childIndex);
        final int count = getChildCount();
for(int i = 0;i < count;i++)
        {
            final View child = getChildAt(i);
            if(i == childIndex)            
            {
                if(animate && mInAnimation != null)                
                {
                    child.startAnimation(mInAnimation);
                } //End block
                child.setVisibility(View.VISIBLE);
                mFirstTime = false;
            } //End block
            else
            {
                if(animate && mOutAnimation != null && child.getVisibility() == View.VISIBLE)                
                {
                    child.startAnimation(mOutAnimation);
                } //End block
                else
                if(child.getAnimation() == mInAnimation)                
                child.clearAnimation();
                child.setVisibility(View.GONE);
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.208 -0400", hash_original_method = "F76460515723C04BD015D3AE7F75A8EE", hash_generated_method = "767C9C9F31BCC47F5AA881D850F3D21A")
     void showOnly(int childIndex) {
        addTaint(childIndex);
        final boolean animate = (!mFirstTime || mAnimateFirstTime);
        showOnly(childIndex, animate);
        // ---------- Original Method ----------
        //final boolean animate = (!mFirstTime || mAnimateFirstTime);
        //showOnly(childIndex, animate);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.209 -0400", hash_original_method = "B6265928EFB656804D99665538BC6B35", hash_generated_method = "5D8367EE6F1497F146AAEB734F9CD82F")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
        super.addView(child, index, params);
        if(getChildCount() == 1)        
        {
            child.setVisibility(View.VISIBLE);
        } //End block
        else
        {
            child.setVisibility(View.GONE);
        } //End block
        // ---------- Original Method ----------
        //super.addView(child, index, params);
        //if (getChildCount() == 1) {
            //child.setVisibility(View.VISIBLE);
        //} else {
            //child.setVisibility(View.GONE);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.210 -0400", hash_original_method = "2876DED6BDEBD13B29080CE11E9063E4", hash_generated_method = "BCAA78D61167CAAC0C5353EF23AEBF73")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.210 -0400", hash_original_method = "96F6E7BCEF91AFFF9BCD877C8E22A578", hash_generated_method = "A7B4988A2710D09B3F767BF86D8D0CB0")
    @Override
    public void removeView(View view) {
        addTaint(view.getTaint());
        final int index = indexOfChild(view);
        if(index >= 0)        
        {
            removeViewAt(index);
        } //End block
        // ---------- Original Method ----------
        //final int index = indexOfChild(view);
        //if (index >= 0) {
            //removeViewAt(index);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.211 -0400", hash_original_method = "39615E53633A229D459BCD129C9447D8", hash_generated_method = "3CF38E7B673C1B62368A850130F6539B")
    @Override
    public void removeViewAt(int index) {
        addTaint(index);
        super.removeViewAt(index);
        final int childCount = getChildCount();
        if(childCount == 0)        
        {
            mWhichChild = 0;
            mFirstTime = true;
        } //End block
        else
        if(mWhichChild >= childCount)        
        {
            setDisplayedChild(childCount - 1);
        } //End block
        else
        if(mWhichChild == index)        
        {
            setDisplayedChild(mWhichChild);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.212 -0400", hash_original_method = "E39155B01A3404328E46119B32BA0220", hash_generated_method = "5F148F7815F600867821DC7CB521B775")
    public void removeViewInLayout(View view) {
        addTaint(view.getTaint());
        removeView(view);
        // ---------- Original Method ----------
        //removeView(view);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.212 -0400", hash_original_method = "E3FA5900F02B916C2065C9EFA9728FDF", hash_generated_method = "8B08F6DFC7318AAE929F06884EF6D751")
    public void removeViews(int start, int count) {
        addTaint(count);
        addTaint(start);
        super.removeViews(start, count);
        if(getChildCount() == 0)        
        {
            mWhichChild = 0;
            mFirstTime = true;
        } //End block
        else
        if(mWhichChild >= start && mWhichChild < start + count)        
        {
            setDisplayedChild(mWhichChild);
        } //End block
        // ---------- Original Method ----------
        //super.removeViews(start, count);
        //if (getChildCount() == 0) {
            //mWhichChild = 0;
            //mFirstTime = true;
        //} else if (mWhichChild >= start && mWhichChild < start + count) {
            //setDisplayedChild(mWhichChild);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.213 -0400", hash_original_method = "76C75A4C2363189C0B16150C5B7ECE1A", hash_generated_method = "E57F4172B992AF809E66F308997DA084")
    public void removeViewsInLayout(int start, int count) {
        addTaint(count);
        addTaint(start);
        removeViews(start, count);
        // ---------- Original Method ----------
        //removeViews(start, count);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.213 -0400", hash_original_method = "844041B2553847C9CC4B36B79F20B7EC", hash_generated_method = "5511E056CD17DA0976485F9DCF7A5B3B")
    public View getCurrentView() {
View var2EFE567B1041312ACA3B581D96281BE7_365652205 =         getChildAt(mWhichChild);
        var2EFE567B1041312ACA3B581D96281BE7_365652205.addTaint(taint);
        return var2EFE567B1041312ACA3B581D96281BE7_365652205;
        // ---------- Original Method ----------
        //return getChildAt(mWhichChild);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.213 -0400", hash_original_method = "9649A93AAEAC388E07F52DE503C0F001", hash_generated_method = "0875DA766A2B161A8325779CDF2204B4")
    public Animation getInAnimation() {
Animation var4B5C05D2D2A95AF947FC9E803E337EB1_1991237944 =         mInAnimation;
        var4B5C05D2D2A95AF947FC9E803E337EB1_1991237944.addTaint(taint);
        return var4B5C05D2D2A95AF947FC9E803E337EB1_1991237944;
        // ---------- Original Method ----------
        //return mInAnimation;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.213 -0400", hash_original_method = "3A3CF51D7EEDC43DA48CCA94EBF1692F", hash_generated_method = "E7E7233C13774685AA7A36D3ECAD7F34")
    public void setInAnimation(Animation inAnimation) {
        mInAnimation = inAnimation;
        // ---------- Original Method ----------
        //mInAnimation = inAnimation;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.213 -0400", hash_original_method = "966AEDC04CB1C3738AA44B09B913030C", hash_generated_method = "1BE106FFFBC0CDD2EE2AD0ABD0E08D96")
    public Animation getOutAnimation() {
Animation var12545A6CD44F5F92DFAF41C046B9E960_911871511 =         mOutAnimation;
        var12545A6CD44F5F92DFAF41C046B9E960_911871511.addTaint(taint);
        return var12545A6CD44F5F92DFAF41C046B9E960_911871511;
        // ---------- Original Method ----------
        //return mOutAnimation;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.213 -0400", hash_original_method = "E7C95EC2E63D184B364637DD8AD18F73", hash_generated_method = "7702771938195AF2F91DFC7114BC7EB4")
    public void setOutAnimation(Animation outAnimation) {
        mOutAnimation = outAnimation;
        // ---------- Original Method ----------
        //mOutAnimation = outAnimation;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.214 -0400", hash_original_method = "4B14A90FDB2491821F3B7183A1AB7EB4", hash_generated_method = "A028A2D55E1E0E360872480B0EB9C0EF")
    public void setInAnimation(Context context, int resourceID) {
        addTaint(resourceID);
        addTaint(context.getTaint());
        setInAnimation(AnimationUtils.loadAnimation(context, resourceID));
        // ---------- Original Method ----------
        //setInAnimation(AnimationUtils.loadAnimation(context, resourceID));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.214 -0400", hash_original_method = "C68FA8DD73709498CDF74B32AA0794E0", hash_generated_method = "2D772FA38A74DF4CE5F92F31E9029652")
    public void setOutAnimation(Context context, int resourceID) {
        addTaint(resourceID);
        addTaint(context.getTaint());
        setOutAnimation(AnimationUtils.loadAnimation(context, resourceID));
        // ---------- Original Method ----------
        //setOutAnimation(AnimationUtils.loadAnimation(context, resourceID));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.214 -0400", hash_original_method = "8FC95409534ABC48E92905DC8C518CE2", hash_generated_method = "B8F320B30FC7DD41541BCFCAA6FCA367")
    public void setAnimateFirstView(boolean animate) {
        mAnimateFirstTime = animate;
        // ---------- Original Method ----------
        //mAnimateFirstTime = animate;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.214 -0400", hash_original_method = "0B91CAAE76789C8A4B2B18C9D0AAF852", hash_generated_method = "33726DF4D4524AD511BD4A7F3D751F82")
    @Override
    public int getBaseline() {
        int var4702CD21947610980ED4BFE44C6C48B3_989332730 = ((getCurrentView() != null) ? getCurrentView().getBaseline() : super.getBaseline());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129357100 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129357100;
        // ---------- Original Method ----------
        //return (getCurrentView() != null) ? getCurrentView().getBaseline() : super.getBaseline();
    }

    
}

