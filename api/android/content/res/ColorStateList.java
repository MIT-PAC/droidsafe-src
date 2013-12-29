package android.content.res;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.StateSet;
import android.util.Xml;

import com.android.internal.util.ArrayUtils;






public class ColorStateList implements Parcelable {

    /**
     * Creates or retrieves a ColorStateList that always returns a single color.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.321 -0500", hash_original_method = "FCCF2821DEC9011A455F9F98CACE9BF9", hash_generated_method = "6429859492A4AC149B8E87DEC540F761")
    public static ColorStateList valueOf(int color) {
        // TODO: should we collect these eventually?
        synchronized (sCache) {
            WeakReference<ColorStateList> ref = sCache.get(color);
            ColorStateList csl = ref != null ? ref.get() : null;

            if (csl != null) {
                return csl;
            }

            csl = new ColorStateList(EMPTY, new int[] { color });
            sCache.put(color, new WeakReference<ColorStateList>(csl));
            return csl;
        }
    }

    /**
     * Create a ColorStateList from an XML document, given a set of {@link Resources}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.322 -0500", hash_original_method = "5986A0E2205D2782A4018155A452F4C2", hash_generated_method = "B6AA7295315B18C55E48EAB77A84A116")
    public static ColorStateList createFromXml(Resources r, XmlPullParser parser)
            throws XmlPullParserException, IOException {

        AttributeSet attrs = Xml.asAttributeSet(parser);

        int type;
        while ((type=parser.next()) != XmlPullParser.START_TAG
                   && type != XmlPullParser.END_DOCUMENT) {
        }

        if (type != XmlPullParser.START_TAG) {
            throw new XmlPullParserException("No start tag found");
        }

        return createFromXmlInner(r, parser, attrs);
    }

    /* Create from inside an XML document.  Called on a parser positioned at
     * a tag in an XML document, tries to create a ColorStateList from that tag.
     * Returns null if the tag is not a valid ColorStateList.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.323 -0500", hash_original_method = "29461E82F281519D72B414C160880677", hash_generated_method = "2A1176A16A76E420F38B3ECB1167F71E")
    private static ColorStateList createFromXmlInner(Resources r, XmlPullParser parser,
            AttributeSet attrs) throws XmlPullParserException, IOException {

        ColorStateList colorStateList;

        final String name = parser.getName();

        if (name.equals("selector")) {
            colorStateList = new ColorStateList();
        } else {
            throw new XmlPullParserException(
                parser.getPositionDescription() + ": invalid drawable tag " + name);
        }

        colorStateList.inflate(r, parser, attrs);
        return colorStateList;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.317 -0500", hash_original_field = "AA519415D3F808B36EDC91E01115D423", hash_generated_field = "41F1B900ACFD3D3CE9828C8FBA43A76D")


    private static final int[][] EMPTY = new int[][] { new int[0] };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.318 -0500", hash_original_field = "CFA1A0BCF45178ECF2FCC8D939250361", hash_generated_field = "63E4E9738983D663C4BF9E32C63A6A40")

    private static final SparseArray<WeakReference<ColorStateList>> sCache =
                            new SparseArray<WeakReference<ColorStateList>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.111 -0400", hash_original_field = "1BBFF86921A48C3AD8A7B5472F436B50", hash_generated_field = "C7405A28A73CE53110DBA3CB822ABCA2")

    public static final Parcelable.Creator<ColorStateList> CREATOR =
            new Parcelable.Creator<ColorStateList>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.331 -0500", hash_original_method = "64FF1FD2247EB9835068885DC70066CC", hash_generated_method = "97E97F02581C5C08879DD53AE552333C")
        public ColorStateList[] newArray(int size) {
            return new ColorStateList[size];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.332 -0500", hash_original_method = "99D1C755B99765C149DCD766D7B3653A", hash_generated_method = "BEE2963FE0C61AAC6280C5B1BD6628DB")
        public ColorStateList createFromParcel(Parcel source) {
            final int N = source.readInt();
            int[][] stateSpecs = new int[N][];
            for (int i=0; i<N; i++) {
                stateSpecs[i] = source.createIntArray();
            }
            int[] colors = source.createIntArray();
            return new ColorStateList(stateSpecs, colors);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.315 -0500", hash_original_field = "8D7D8C0B29FD466C99A91A529FE41679", hash_generated_field = "7D52F505B14BC667C4ED1C5AB261B59A")


    private int[][] mStateSpecs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.315 -0500", hash_original_field = "8BCB86BAF7C31D49B3DD83C851FBAC85", hash_generated_field = "53BCC056E3008A06A88375FEB8668D58")

    private int[] mColors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.316 -0500", hash_original_field = "749B752E6FA5DF5F967C2E039068DD6A", hash_generated_field = "57E8521AC9CBFD385A5C49D98FB81CDC")

    private int mDefaultColor = 0xffff0000;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.319 -0500", hash_original_method = "A1B9AA8D55CC71F4C566F389AC3D8BBC", hash_generated_method = "7CABE0A9DC84A186FEE9ADFA234E2A75")
    private ColorStateList() { }

    /**
     * Creates a ColorStateList that returns the specified mapping from
     * states to colors.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.320 -0500", hash_original_method = "16DE5E515D4E313298C804E12AA820B9", hash_generated_method = "B6069869652BA6429DACB728FA845152")
    public ColorStateList(int[][] states, int[] colors) {
        mStateSpecs = states;
        mColors = colors;

        if (states.length > 0) {
            mDefaultColor = colors[0];

            for (int i = 0; i < states.length; i++) {
                if (states[i].length == 0) {
                    mDefaultColor = colors[i];
                }
            }
        }
    }

    /**
     * Creates a new ColorStateList that has the same states and
     * colors as this one but where each color has the specified alpha value
     * (0-255).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.323 -0500", hash_original_method = "C02A6B069CD8C9360FEC8CA407C14B4A", hash_generated_method = "16AFC75FFEF1B596CE842ACE5B0194B4")
    public ColorStateList withAlpha(int alpha) {
        int[] colors = new int[mColors.length];

        int len = colors.length;
        for (int i = 0; i < len; i++) {
            colors[i] = (mColors[i] & 0xFFFFFF) | (alpha << 24);
        }

        return new ColorStateList(mStateSpecs, colors);
    }

    /**
     * Fill in this object based on the contents of an XML "selector" element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.325 -0500", hash_original_method = "096D4D4F0EE82FD61B43B813E755281E", hash_generated_method = "C56BAAE3C8CF809F5B6303E13BAA4F9F")
    private void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
        throws XmlPullParserException, IOException {

        int type;

        final int innerDepth = parser.getDepth()+1;
        int depth;

        int listAllocated = 20;
        int listSize = 0;
        int[] colorList = new int[listAllocated];
        int[][] stateSpecList = new int[listAllocated][];

        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && ((depth=parser.getDepth()) >= innerDepth
                   || type != XmlPullParser.END_TAG)) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }

            if (depth > innerDepth || !parser.getName().equals("item")) {
                continue;
            }

            int colorRes = 0;
            int color = 0xffff0000;
            boolean haveColor = false;

            int i;
            int j = 0;
            final int numAttrs = attrs.getAttributeCount();
            int[] stateSpec = new int[numAttrs];
            for (i = 0; i < numAttrs; i++) {
                final int stateResId = attrs.getAttributeNameResource(i);
                if (stateResId == 0) break;
                if (stateResId == com.android.internal.R.attr.color) {
                    colorRes = attrs.getAttributeResourceValue(i, 0);

                    if (colorRes == 0) {
                        color = attrs.getAttributeIntValue(i, color);
                        haveColor = true;
                    }
                } else {
                    stateSpec[j++] = attrs.getAttributeBooleanValue(i, false)
                                  ? stateResId
                                  : -stateResId;
                }
            }
            stateSpec = StateSet.trimStateSet(stateSpec, j);

            if (colorRes != 0) {
                color = r.getColor(colorRes);
            } else if (!haveColor) {
                throw new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <item> tag requires a 'android:color' attribute.");
            }

            if (listSize == 0 || stateSpec.length == 0) {
                mDefaultColor = color;
            }
            
            if (listSize + 1 >= listAllocated) {
                listAllocated = ArrayUtils.idealIntArraySize(listSize + 1);

                int[] ncolor = new int[listAllocated];
                System.arraycopy(colorList, 0, ncolor, 0, listSize);

                int[][] nstate = new int[listAllocated][];
                System.arraycopy(stateSpecList, 0, nstate, 0, listSize);

                colorList = ncolor;
                stateSpecList = nstate;
            }

            colorList[listSize] = color;
            stateSpecList[listSize] = stateSpec;
            listSize++;
        }

        mColors = new int[listSize];
        mStateSpecs = new int[listSize][];
        System.arraycopy(colorList, 0, mColors, 0, listSize);
        System.arraycopy(stateSpecList, 0, mStateSpecs, 0, listSize);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.326 -0500", hash_original_method = "1C923E0661B9E6FB6B4C6C1FDCEBD767", hash_generated_method = "F2CE60EC24AACBB277BF7C8F4AAEEF0C")
    public boolean isStateful() {
        return mStateSpecs.length > 1;
    }
    
    /**
     * Return the color associated with the given set of {@link android.view.View} states.
     *
     * @param stateSet an array of {@link android.view.View} states
     * @param defaultColor the color to return if there's not state spec in this
     * {@link ColorStateList} that matches the stateSet.
     *
     * @return the color associated with that set of states in this {@link ColorStateList}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.327 -0500", hash_original_method = "4327A241B2C451B5F5DDB6DF79352F03", hash_generated_method = "AF80748142B2E1C3FDE33ED320874FF5")
    public int getColorForState(int[] stateSet, int defaultColor) {
        final int setLength = mStateSpecs.length;
        for (int i = 0; i < setLength; i++) {
            int[] stateSpec = mStateSpecs[i];
            if (StateSet.stateSetMatches(stateSpec, stateSet)) {
                return mColors[i];
            }
        }
        return defaultColor;
    }

    /**
     * Return the default color in this {@link ColorStateList}.
     *
     * @return the default color in this {@link ColorStateList}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.327 -0500", hash_original_method = "28A9CB761E85FC98D00C67A51FDC0266", hash_generated_method = "BD5C97F2F8B496BA1D776C974B2636D0")
    public int getDefaultColor() {
        return mDefaultColor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.328 -0500", hash_original_method = "1483B624C0E3738F481F261D24FE0627", hash_generated_method = "016A1A88E69F99946CF20AE7F12AADB0")
    public String toString() {
        return "ColorStateList{" +
               "mStateSpecs=" + Arrays.deepToString(mStateSpecs) +
               "mColors=" + Arrays.toString(mColors) +
               "mDefaultColor=" + mDefaultColor + '}';
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.329 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:08.330 -0500", hash_original_method = "E1B2D8F50F6285FEE430316C6FD92D49", hash_generated_method = "0530E4E50B75C95A5742A162A769E34F")
    public void writeToParcel(Parcel dest, int flags) {
        final int N = mStateSpecs.length;
        dest.writeInt(N);
        for (int i=0; i<N; i++) {
            dest.writeIntArray(mStateSpecs[i]);
        }
        dest.writeIntArray(mColors);
    }
    // orphaned legacy method
    public ColorStateList createFromParcel(Parcel source) {
            final int N = source.readInt();
            int[][] stateSpecs = new int[N][];
            for (int i=0; i<N; i++) {
                stateSpecs[i] = source.createIntArray();
            }
            int[] colors = source.createIntArray();
            return new ColorStateList(stateSpecs, colors);
        }
    
    // orphaned legacy method
    public ColorStateList[] newArray(int size) {
            return new ColorStateList[size];
        }
    
}

