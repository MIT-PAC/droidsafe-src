package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.Arrays;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;

public class StateListDrawable extends DrawableContainer {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawable";
    private static final boolean DEFAULT_DITHER = true;
    private final StateListState mStateListState;
    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.182 -0400", hash_original_method = "2C05F8B66F3CA072BC0F3CED1F3E988B", hash_generated_method = "57BDC9932C72BB7F89F2D35B0EA8E519")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StateListDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.182 -0400", hash_original_method = "90179FAF2CD102672779F3C6B59674D6", hash_generated_method = "A37468667581AB0BBDA7559E1C90E851")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StateListDrawable(StateListState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        StateListState as;
        as = new StateListState(state, this, res);
        mStateListState = as;
        setConstantState(as);
        onStateChange(getState());
        // ---------- Original Method ----------
        //StateListState as = new StateListState(state, this, res);
        //mStateListState = as;
        //setConstantState(as);
        //onStateChange(getState());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.182 -0400", hash_original_method = "AF6407614B20F66E7E774377847CB658", hash_generated_method = "A9C902C0F6BA1D0F0B46D3D6A4DE3936")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addState(int[] stateSet, Drawable drawable) {
        dsTaint.addTaint(stateSet);
        dsTaint.addTaint(drawable.dsTaint);
        {
            mStateListState.addStateSet(stateSet, drawable);
            onStateChange(getState());
        } //End block
        // ---------- Original Method ----------
        //if (drawable != null) {
            //mStateListState.addStateSet(stateSet, drawable);
            //onStateChange(getState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.183 -0400", hash_original_method = "DFB1FDC7F6EFB1E210EFD5F6F91EF45F", hash_generated_method = "EB21AB6AE4E195FC4556C6CA3C08562D")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isStateful() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.183 -0400", hash_original_method = "3B1FAED12170A69A129A87EF9824D4D4", hash_generated_method = "EBFE73A503D8BE839E59D6FF74FD61B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onStateChange(int[] stateSet) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(stateSet);
        int idx;
        idx = mStateListState.indexOfStateSet(stateSet);
        android.util.Log.i(TAG, "onStateChange " + this + " states "
                + Arrays.toString(stateSet) + " found " + idx);
        {
            idx = mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        } //End block
        {
            boolean var3E2B49468750734D46A6120849432D6B_1817206907 = (selectDrawable(idx));
        } //End collapsed parenthetic
        boolean var6096784E4C4CB866A4D8B9C324F426C5_961092814 = (super.onStateChange(stateSet));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int idx = mStateListState.indexOfStateSet(stateSet);
        //if (DEBUG) android.util.Log.i(TAG, "onStateChange " + this + " states "
                //+ Arrays.toString(stateSet) + " found " + idx);
        //if (idx < 0) {
            //idx = mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        //}
        //if (selectDrawable(idx)) {
            //return true;
        //}
        //return super.onStateChange(stateSet);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.184 -0400", hash_original_method = "60A0EEC92FC73D4C3C226304BAFE6ED2", hash_generated_method = "487B36C462A7CC40945D2B7720810017")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser,
            AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        TypedArray a;
        a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.StateListDrawable);
        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.StateListDrawable_visible);
        mStateListState.setVariablePadding(a.getBoolean(
                com.android.internal.R.styleable.StateListDrawable_variablePadding, false));
        mStateListState.setConstantSize(a.getBoolean(
                com.android.internal.R.styleable.StateListDrawable_constantSize, false));
        mStateListState.setEnterFadeDuration(a.getInt(
                com.android.internal.R.styleable.StateListDrawable_enterFadeDuration, 0));
        mStateListState.setExitFadeDuration(a.getInt(
                com.android.internal.R.styleable.StateListDrawable_exitFadeDuration, 0));
        setDither(a.getBoolean(com.android.internal.R.styleable.StateListDrawable_dither,
                               DEFAULT_DITHER));
        a.recycle();
        int type;
        final int innerDepth;
        innerDepth = parser.getDepth() + 1;
        int depth;
        {
            boolean var5C2AD857B4870B6E82338097BA87AA78_686090254 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth
                || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_1604125632 = (depth > innerDepth || !parser.getName().equals("item"));
                } //End collapsed parenthetic
                int drawableRes;
                drawableRes = 0;
                int i;
                int j;
                j = 0;
                final int numAttrs;
                numAttrs = attrs.getAttributeCount();
                int[] states;
                states = new int[numAttrs];
                {
                    i = 0;
                    {
                        final int stateResId;
                        stateResId = attrs.getAttributeNameResource(i);
                        {
                            drawableRes = attrs.getAttributeResourceValue(i, 0);
                        } //End block
                        {
                            states[j++] = attrs.getAttributeBooleanValue(i, false)
                            ? stateResId
                            : -stateResId;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                states = StateSet.trimStateSet(states, j);
                Drawable dr;
                {
                    dr = r.getDrawable(drawableRes);
                } //End block
                {
                    {
                        boolean var16E7483EB4C069010E58346DA2B7701B_582749432 = ((type = parser.next()) == XmlPullParser.TEXT);
                    } //End collapsed parenthetic
                    {
                        throw new XmlPullParserException(
                            parser.getPositionDescription()
                                    + ": <item> tag requires a 'drawable' attribute or "
                                    + "child tag defining a drawable");
                    } //End block
                    dr = Drawable.createFromXmlInner(r, parser, attrs);
                } //End block
                mStateListState.addStateSet(states, dr);
            } //End block
        } //End collapsed parenthetic
        onStateChange(getState());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.184 -0400", hash_original_method = "C30AAB7A53F4234B41E4C7F0859B0584", hash_generated_method = "D6D7E3BB5A925FB4604F74F0E1C31DAE")
    @DSModeled(DSC.SAFE)
     StateListState getStateListState() {
        return (StateListState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mStateListState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.184 -0400", hash_original_method = "D9E3394F970F5413D258086831B5CB36", hash_generated_method = "91FF7517D6B84DA075402D372265EC0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStateCount() {
        int var11CFE54020BD6DC70972CFC97D6175DA_1742320964 = (mStateListState.getChildCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStateListState.getChildCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.184 -0400", hash_original_method = "55D68A9E9C260DCF60D1CBBC77B3FC0F", hash_generated_method = "F765AD00E0D1DF7A3BC8919208DCCA1F")
    @DSModeled(DSC.SAFE)
    public int[] getStateSet(int index) {
        dsTaint.addTaint(index);
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mStateListState.mStateSets[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.184 -0400", hash_original_method = "266BB2A523416F0BDAD03984AE85B606", hash_generated_method = "06AC6AFF2C9F3C7DE1F6371506472866")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getStateDrawable(int index) {
        dsTaint.addTaint(index);
        Drawable var4D2933E8B473DAEA8ABC6C3F4184D7F9_238592858 = (mStateListState.getChildren()[index]);
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mStateListState.getChildren()[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.184 -0400", hash_original_method = "410013485164C1DC2E995A85C1D3348C", hash_generated_method = "EE590F393F92C80305229471599B0E87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStateDrawableIndex(int[] stateSet) {
        dsTaint.addTaint(stateSet);
        int var32B7534748596CE25EEA3B111D541A0E_1377782507 = (mStateListState.indexOfStateSet(stateSet));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStateListState.indexOfStateSet(stateSet);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.185 -0400", hash_original_method = "92CD1CD82DD5DEA6E7693E9ED80EE90B", hash_generated_method = "ED5AD4C4F9A9EC989F72F61A3ECD588C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_246826483 = (!mMutated && super.mutate() == this);
            {
                final int[][] sets;
                sets = mStateListState.mStateSets;
                final int count;
                count = sets.length;
                mStateListState.mStateSets = new int[count][];
                {
                    int i;
                    i = 0;
                    {
                        final int[] set;
                        set = sets[i];
                        {
                            mStateListState.mStateSets[i] = set.clone();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //final int[][] sets = mStateListState.mStateSets;
            //final int count = sets.length;
            //mStateListState.mStateSets = new int[count][];
            //for (int i = 0; i < count; i++) {
                //final int[] set = sets[i];
                //if (set != null) {
                    //mStateListState.mStateSets[i] = set.clone();
                //}
            //}
            //mMutated = true;
        //}
        //return this;
    }

    
    static final class StateListState extends DrawableContainerState {
        int[][] mStateSets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.185 -0400", hash_original_method = "51F130A45558C85B3D3E7CFC8D91F8BC", hash_generated_method = "E042BD7E7FD9ED17F9B78FE71FC8BFA2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         StateListState(StateListState orig, StateListDrawable owner, Resources res) {
            super(orig, owner, res);
            dsTaint.addTaint(res.dsTaint);
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(orig.dsTaint);
            {
                mStateSets = orig.mStateSets;
            } //End block
            {
                mStateSets = new int[getChildren().length][];
            } //End block
            // ---------- Original Method ----------
            //if (orig != null) {
                //mStateSets = orig.mStateSets;
            //} else {
                //mStateSets = new int[getChildren().length][];
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.185 -0400", hash_original_method = "E4505B2AE7EA07FF537AEC799B3546D0", hash_generated_method = "3F417263D062E2BDCC565A717F2CBE5B")
        @DSModeled(DSC.SAFE)
         int addStateSet(int[] stateSet, Drawable drawable) {
            dsTaint.addTaint(stateSet);
            dsTaint.addTaint(drawable.dsTaint);
            final int pos;
            pos = addChild(drawable);
            mStateSets[pos] = stateSet;
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //final int pos = addChild(drawable);
            //mStateSets[pos] = stateSet;
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.185 -0400", hash_original_method = "A182AEBDD3B8E6EFB499434DA2A68669", hash_generated_method = "B5EF8F93F111AA945A724834B942DE15")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int indexOfStateSet(int[] stateSet) {
            dsTaint.addTaint(stateSet);
            final int[][] stateSets;
            stateSets = mStateSets;
            final int N;
            N = getChildCount();
            {
                int i;
                i = 0;
                {
                    {
                        boolean var6FDC262EEEF0E02068C5811E55176A45_1144595156 = (StateSet.stateSetMatches(stateSets[i], stateSet));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //final int[][] stateSets = mStateSets;
            //final int N = getChildCount();
            //for (int i = 0; i < N; i++) {
                //if (StateSet.stateSetMatches(stateSets[i], stateSet)) {
                    //return i;
                //}
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.185 -0400", hash_original_method = "56C51D0FF73BF2A3F52E87DDE967AFF6", hash_generated_method = "6D7DE045809C7E40CE06200A0A3ED968")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable() {
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new StateListDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.185 -0400", hash_original_method = "DF4CF834DF74C8FC36C20E482CEB7672", hash_generated_method = "901E7F817897F2588D726C9A618787FF")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new StateListDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.185 -0400", hash_original_method = "CF45914111E05D752375948053626E9D", hash_generated_method = "EA9DF54E5E3AFBA00F5765C3293ED9AB")
        @DSModeled(DSC.SAFE)
        @Override
        public void growArray(int oldSize, int newSize) {
            dsTaint.addTaint(oldSize);
            dsTaint.addTaint(newSize);
            super.growArray(oldSize, newSize);
            final int[][] newStateSets;
            newStateSets = new int[newSize][];
            System.arraycopy(mStateSets, 0, newStateSets, 0, oldSize);
            mStateSets = newStateSets;
            // ---------- Original Method ----------
            //super.growArray(oldSize, newSize);
            //final int[][] newStateSets = new int[newSize][];
            //System.arraycopy(mStateSets, 0, newStateSets, 0, oldSize);
            //mStateSets = newStateSets;
        }

        
    }


    
}


