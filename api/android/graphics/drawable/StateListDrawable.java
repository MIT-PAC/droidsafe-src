package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Arrays;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;

public class StateListDrawable extends DrawableContainer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.095 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.097 -0500", hash_original_field = "43433DB49965F9E2E7AFA4D9EE6B888C", hash_generated_field = "344FFFED067AA98CA906512A50739761")

    private static final String TAG = "StateListDrawable";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.099 -0500", hash_original_field = "338D1FBCBD429EAFEF0B800F32A31DDD", hash_generated_field = "17A3499D3AE1DB6784657D5E8AE3951F")

    private static final boolean DEFAULT_DITHER = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.102 -0500", hash_original_field = "21F3B94EB5C15D37BBE3E888B6438BE0", hash_generated_field = "980C8FFE9150BE923FD62F944FCAAAEC")

    private  StateListState mStateListState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.104 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.106 -0500", hash_original_method = "2C05F8B66F3CA072BC0F3CED1F3E988B", hash_generated_method = "CAC778B770A2571E154C8C827BD90DFE")
    
public StateListDrawable() {
        this(null, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.153 -0500", hash_original_method = "90179FAF2CD102672779F3C6B59674D6", hash_generated_method = "B3DA6FA6C2C9CCC9F55E65629565B08F")
    
private StateListDrawable(StateListState state, Resources res) {
        StateListState as = new StateListState(state, this, res);
        mStateListState = as;
        setConstantState(as);
        onStateChange(getState());
    }

    /**
     * Add a new image/string ID to the set of images.
     *
     * @param stateSet - An array of resource Ids to associate with the image.
     *                 Switch to this image by calling setState().
     * @param drawable -The image to show.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.108 -0500", hash_original_method = "AF6407614B20F66E7E774377847CB658", hash_generated_method = "FBE12C8DC4EE2A8564D85027E19564BE")
    
public void addState(int[] stateSet, Drawable drawable) {
        if (drawable != null) {
            mStateListState.addStateSet(stateSet, drawable);
            // in case the new state matches our current state...
            onStateChange(getState());
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.111 -0500", hash_original_method = "DFB1FDC7F6EFB1E210EFD5F6F91EF45F", hash_generated_method = "4487ED542301ADB966FCFEE9954EA5D4")
    
@Override
    public boolean isStateful() {
        return true;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.113 -0500", hash_original_method = "3B1FAED12170A69A129A87EF9824D4D4", hash_generated_method = "1CBF5E5B65D18CEA27C53CD9EBB977CC")
    
@Override
    protected boolean onStateChange(int[] stateSet) {
        int idx = mStateListState.indexOfStateSet(stateSet);
        if (DEBUG) android.util.Log.i(TAG, "onStateChange " + this + " states "
                + Arrays.toString(stateSet) + " found " + idx);
        if (idx < 0) {
            idx = mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        }
        if (selectDrawable(idx)) {
            return true;
        }
        return super.onStateChange(stateSet);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.117 -0500", hash_original_method = "60A0EEC92FC73D4C3C226304BAFE6ED2", hash_generated_method = "881AEE96865DF1F601FB754CA0BA5763")
    
@Override
    public void inflate(Resources r, XmlPullParser parser,
            AttributeSet attrs)
            throws XmlPullParserException, IOException {

        TypedArray a = r.obtainAttributes(attrs,
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

        final int innerDepth = parser.getDepth() + 1;
        int depth;
        while ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth
                || type != XmlPullParser.END_TAG)) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }

            if (depth > innerDepth || !parser.getName().equals("item")) {
                continue;
            }

            int drawableRes = 0;

            int i;
            int j = 0;
            final int numAttrs = attrs.getAttributeCount();
            int[] states = new int[numAttrs];
            for (i = 0; i < numAttrs; i++) {
                final int stateResId = attrs.getAttributeNameResource(i);
                if (stateResId == 0) break;
                if (stateResId == com.android.internal.R.attr.drawable) {
                    drawableRes = attrs.getAttributeResourceValue(i, 0);
                } else {
                    states[j++] = attrs.getAttributeBooleanValue(i, false)
                            ? stateResId
                            : -stateResId;
                }
            }
            states = StateSet.trimStateSet(states, j);

            Drawable dr;
            if (drawableRes != 0) {
                dr = r.getDrawable(drawableRes);
            } else {
                while ((type = parser.next()) == XmlPullParser.TEXT) {
                }
                if (type != XmlPullParser.START_TAG) {
                    throw new XmlPullParserException(
                            parser.getPositionDescription()
                                    + ": <item> tag requires a 'drawable' attribute or "
                                    + "child tag defining a drawable");
                }
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            }

            mStateListState.addStateSet(states, dr);
        }

        onStateChange(getState());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.119 -0500", hash_original_method = "C30AAB7A53F4234B41E4C7F0859B0584", hash_generated_method = "C30AAB7A53F4234B41E4C7F0859B0584")
    
StateListState getStateListState() {
        return mStateListState;
    }

    /**
     * Gets the number of states contained in this drawable.
     *
     * @return The number of states contained in this drawable.
     * @hide pending API council
     * @see #getStateSet(int)
     * @see #getStateDrawable(int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.122 -0500", hash_original_method = "D9E3394F970F5413D258086831B5CB36", hash_generated_method = "0078239649DED5D4DAD52FF650246FE7")
    
public int getStateCount() {
        return mStateListState.getChildCount();
    }

    /**
     * Gets the state set at an index.
     *
     * @param index The index of the state set.
     * @return The state set at the index.
     * @hide pending API council
     * @see #getStateCount()
     * @see #getStateDrawable(int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.124 -0500", hash_original_method = "55D68A9E9C260DCF60D1CBBC77B3FC0F", hash_generated_method = "66AB8B6A85B55405B13EB6F1DBA41E83")
    
public int[] getStateSet(int index) {
        return mStateListState.mStateSets[index];
    }
    
    static final class StateListState extends DrawableContainerState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.133 -0500", hash_original_field = "108E8057EC0E2571E1A7E53C160D9BCF", hash_generated_field = "108E8057EC0E2571E1A7E53C160D9BCF")

        int[][] mStateSets;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.136 -0500", hash_original_method = "51F130A45558C85B3D3E7CFC8D91F8BC", hash_generated_method = "51F130A45558C85B3D3E7CFC8D91F8BC")
        
StateListState(StateListState orig, StateListDrawable owner, Resources res) {
            super(orig, owner, res);

            if (orig != null) {
                mStateSets = orig.mStateSets;
            } else {
                mStateSets = new int[getChildren().length][];
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.138 -0500", hash_original_method = "E4505B2AE7EA07FF537AEC799B3546D0", hash_generated_method = "E4505B2AE7EA07FF537AEC799B3546D0")
        
int addStateSet(int[] stateSet, Drawable drawable) {
            final int pos = addChild(drawable);
            mStateSets[pos] = stateSet;
            return pos;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.141 -0500", hash_original_method = "A182AEBDD3B8E6EFB499434DA2A68669", hash_generated_method = "D64FD17DD7405A33F3CB0F78E5709DE5")
        
private int indexOfStateSet(int[] stateSet) {
            final int[][] stateSets = mStateSets;
            final int N = getChildCount();
            for (int i = 0; i < N; i++) {
                if (StateSet.stateSetMatches(stateSets[i], stateSet)) {
                    return i;
                }
            }
            return -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.143 -0500", hash_original_method = "56C51D0FF73BF2A3F52E87DDE967AFF6", hash_generated_method = "7BA121C3C79045A5A9E794AF881AD1A4")
        
@Override
        public Drawable newDrawable() {
            return new StateListDrawable(this, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.146 -0500", hash_original_method = "DF4CF834DF74C8FC36C20E482CEB7672", hash_generated_method = "6167AB90CFC44C91224149FFF4F6EA61")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new StateListDrawable(this, res);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.148 -0500", hash_original_method = "CF45914111E05D752375948053626E9D", hash_generated_method = "DB8631F608D962E1CC5946A6A27F962A")
        
@Override
        public void growArray(int oldSize, int newSize) {
            super.growArray(oldSize, newSize);
            final int[][] newStateSets = new int[newSize][];
            System.arraycopy(mStateSets, 0, newStateSets, 0, oldSize);
            mStateSets = newStateSets;
        }
        
    }

    /**
     * Gets the drawable at an index.
     *
     * @param index The index of the drawable.
     * @return The drawable at the index.
     * @hide pending API council
     * @see #getStateCount()
     * @see #getStateSet(int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.126 -0500", hash_original_method = "266BB2A523416F0BDAD03984AE85B606", hash_generated_method = "9D08CC0A657EEDE0C0474D4E388F1A07")
    
public Drawable getStateDrawable(int index) {
        return mStateListState.getChildren()[index];
    }
    
    /**
     * Gets the index of the drawable with the provided state set.
     * 
     * @param stateSet the state set to look up
     * @return the index of the provided state set, or -1 if not found
     * @hide pending API council
     * @see #getStateDrawable(int)
     * @see #getStateSet(int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.128 -0500", hash_original_method = "410013485164C1DC2E995A85C1D3348C", hash_generated_method = "A49D72CF031B64EEE2017098206BB732")
    
public int getStateDrawableIndex(int[] stateSet) {
        return mStateListState.indexOfStateSet(stateSet);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.130 -0500", hash_original_method = "92CD1CD82DD5DEA6E7693E9ED80EE90B", hash_generated_method = "05DE6CC5FD086CD20355979CB63690F6")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            final int[][] sets = mStateListState.mStateSets;
            final int count = sets.length;
            mStateListState.mStateSets = new int[count][];
            for (int i = 0; i < count; i++) {
                final int[] set = sets[i];
                if (set != null) {
                    mStateListState.mStateSets[i] = set.clone();
                }
            }
            mMutated = true;
        }
        return this;
    }
}

