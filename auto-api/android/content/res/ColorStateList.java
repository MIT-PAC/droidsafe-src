package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.StateSet;
import android.util.Xml;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ColorStateList implements Parcelable {
    private int[][] mStateSpecs;
    private int[] mColors;
    private int mDefaultColor = 0xffff0000;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.121 -0400", hash_original_method = "A1B9AA8D55CC71F4C566F389AC3D8BBC", hash_generated_method = "B853D9FA4CC0F774905FDCA69D04F16F")
    @DSModeled(DSC.SAFE)
    private ColorStateList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.122 -0400", hash_original_method = "16DE5E515D4E313298C804E12AA820B9", hash_generated_method = "6E78FA3C57ADE4DF77F34C3805B2A589")
    @DSModeled(DSC.SAFE)
    public ColorStateList(int[][] states, int[] colors) {
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(states[0][0]);
        {
            mDefaultColor = colors[0];
            {
                int i;
                i = 0;
                {
                    {
                        mDefaultColor = colors[i];
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //mStateSpecs = states;
        //mColors = colors;
        //if (states.length > 0) {
            //mDefaultColor = colors[0];
            //for (int i = 0; i < states.length; i++) {
                //if (states[i].length == 0) {
                    //mDefaultColor = colors[i];
                //}
            //}
        //}
    }

    
        public static ColorStateList valueOf(int color) {
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

    
        public static ColorStateList createFromXml(Resources r, XmlPullParser parser) throws XmlPullParserException, IOException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.123 -0400", hash_original_method = "C02A6B069CD8C9360FEC8CA407C14B4A", hash_generated_method = "90007747FC466C8DBD9FBDBFF51FA4C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ColorStateList withAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        int[] colors;
        colors = new int[mColors.length];
        int len;
        len = colors.length;
        {
            int i;
            i = 0;
            {
                colors[i] = (mColors[i] & 0xFFFFFF) | (alpha << 24);
            } //End block
        } //End collapsed parenthetic
        ColorStateList var046556C5BA034F99615EE7AAEFD80427_1482605133 = (new ColorStateList(mStateSpecs, colors));
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int[] colors = new int[mColors.length];
        //int len = colors.length;
        //for (int i = 0; i < len; i++) {
            //colors[i] = (mColors[i] & 0xFFFFFF) | (alpha << 24);
        //}
        //return new ColorStateList(mStateSpecs, colors);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.124 -0400", hash_original_method = "096D4D4F0EE82FD61B43B813E755281E", hash_generated_method = "F57CBF45134B5AA5CE7EB799E81D5AB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        int type;
        int innerDepth;
        innerDepth = parser.getDepth()+1;
        int depth;
        int listAllocated;
        listAllocated = 20;
        int listSize;
        listSize = 0;
        int[] colorList;
        colorList = new int[listAllocated];
        int[][] stateSpecList;
        stateSpecList = new int[listAllocated][];
        {
            boolean varF60F42190EBD36C414D066F0689226DF_699665833 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && ((depth=parser.getDepth()) >= innerDepth
                   || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_2005928810 = (depth > innerDepth || !parser.getName().equals("item"));
                } //End collapsed parenthetic
                int colorRes;
                colorRes = 0;
                int color;
                color = 0xffff0000;
                boolean haveColor;
                haveColor = false;
                int i;
                int j;
                j = 0;
                int numAttrs;
                numAttrs = attrs.getAttributeCount();
                int[] stateSpec;
                stateSpec = new int[numAttrs];
                {
                    i = 0;
                    {
                        int stateResId;
                        stateResId = attrs.getAttributeNameResource(i);
                        {
                            colorRes = attrs.getAttributeResourceValue(i, 0);
                            {
                                color = attrs.getAttributeIntValue(i, color);
                                haveColor = true;
                            } //End block
                        } //End block
                        {
                            stateSpec[j++] = attrs.getAttributeBooleanValue(i, false)
                                  ? stateResId
                                  : -stateResId;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                stateSpec = StateSet.trimStateSet(stateSpec, j);
                {
                    color = r.getColor(colorRes);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <item> tag requires a 'android:color' attribute.");
                } //End block
                {
                    mDefaultColor = color;
                } //End block
                {
                    listAllocated = ArrayUtils.idealIntArraySize(listSize + 1);
                    int[] ncolor;
                    ncolor = new int[listAllocated];
                    System.arraycopy(colorList, 0, ncolor, 0, listSize);
                    int[][] nstate;
                    nstate = new int[listAllocated][];
                    System.arraycopy(stateSpecList, 0, nstate, 0, listSize);
                    colorList = ncolor;
                    stateSpecList = nstate;
                } //End block
                colorList[listSize] = color;
                stateSpecList[listSize] = stateSpec;
            } //End block
        } //End collapsed parenthetic
        mColors = new int[listSize];
        mStateSpecs = new int[listSize][];
        System.arraycopy(colorList, 0, mColors, 0, listSize);
        System.arraycopy(stateSpecList, 0, mStateSpecs, 0, listSize);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.125 -0400", hash_original_method = "1C923E0661B9E6FB6B4C6C1FDCEBD767", hash_generated_method = "11FE0A4041EEBD34B1ED186D48DC51C2")
    @DSModeled(DSC.SAFE)
    public boolean isStateful() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStateSpecs.length > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.125 -0400", hash_original_method = "4327A241B2C451B5F5DDB6DF79352F03", hash_generated_method = "932BEAEA22A412CB2E69DB219E0CB847")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColorForState(int[] stateSet, int defaultColor) {
        dsTaint.addTaint(stateSet[0]);
        dsTaint.addTaint(defaultColor);
        int setLength;
        setLength = mStateSpecs.length;
        {
            int i;
            i = 0;
            {
                int[] stateSpec;
                stateSpec = mStateSpecs[i];
                {
                    boolean var0BC14A81E745300E188A9AE767EF71BA_1934885157 = (StateSet.stateSetMatches(stateSpec, stateSet));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int setLength = mStateSpecs.length;
        //for (int i = 0; i < setLength; i++) {
            //int[] stateSpec = mStateSpecs[i];
            //if (StateSet.stateSetMatches(stateSpec, stateSet)) {
                //return mColors[i];
            //}
        //}
        //return defaultColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.126 -0400", hash_original_method = "28A9CB761E85FC98D00C67A51FDC0266", hash_generated_method = "3A0FB854E03A022A3BA13394CAFE2961")
    @DSModeled(DSC.SAFE)
    public int getDefaultColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDefaultColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.127 -0400", hash_original_method = "1483B624C0E3738F481F261D24FE0627", hash_generated_method = "623C2A10C03E896B55F5F91EDCA18183")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var5CE206CEBA5D7B0739473F0643A3116B_1880737698 = ("ColorStateList{" +
               "mStateSpecs=" + Arrays.deepToString(mStateSpecs) +
               "mColors=" + Arrays.toString(mColors) +
               "mDefaultColor=" + mDefaultColor + '}');
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ColorStateList{" +
               //"mStateSpecs=" + Arrays.deepToString(mStateSpecs) +
               //"mColors=" + Arrays.toString(mColors) +
               //"mDefaultColor=" + mDefaultColor + '}';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.128 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.128 -0400", hash_original_method = "E1B2D8F50F6285FEE430316C6FD92D49", hash_generated_method = "00F26585C3B31D040B199C50B98D5AF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        int N;
        N = mStateSpecs.length;
        dest.writeInt(N);
        {
            int i;
            i = 0;
            {
                dest.writeIntArray(mStateSpecs[i]);
            } //End block
        } //End collapsed parenthetic
        dest.writeIntArray(mColors);
        // ---------- Original Method ----------
        //final int N = mStateSpecs.length;
        //dest.writeInt(N);
        //for (int i=0; i<N; i++) {
            //dest.writeIntArray(mStateSpecs[i]);
        //}
        //dest.writeIntArray(mColors);
    }

    
    private static final int[][] EMPTY = new int[][] { new int[0] };
    private static final SparseArray<WeakReference<ColorStateList>> sCache =
                            new SparseArray<WeakReference<ColorStateList>>();
    public static final Parcelable.Creator<ColorStateList> CREATOR = new Parcelable.Creator<ColorStateList>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.129 -0400", hash_original_method = "64FF1FD2247EB9835068885DC70066CC", hash_generated_method = "107881D5DE4A87732A4D60AB3085756E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ColorStateList[] newArray(int size) {
            dsTaint.addTaint(size);
            ColorStateList[] var2EFB302CE56736D03F9DA278C8859BA4_187360377 = (new ColorStateList[size]);
            return (ColorStateList[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ColorStateList[size];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.129 -0400", hash_original_method = "99D1C755B99765C149DCD766D7B3653A", hash_generated_method = "A23A4FE00F76FE3E97236E0A3ED2EBB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ColorStateList createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            int N;
            N = source.readInt();
            int[][] stateSpecs;
            stateSpecs = new int[N][];
            {
                int i;
                i = 0;
                {
                    stateSpecs[i] = source.createIntArray();
                } //End block
            } //End collapsed parenthetic
            int[] colors;
            colors = source.createIntArray();
            ColorStateList var68041828BDE6AAA7C173D24BF6CAA1CB_624562718 = (new ColorStateList(stateSpecs, colors));
            return (ColorStateList)dsTaint.getTaint();
            // ---------- Original Method ----------
            //final int N = source.readInt();
            //int[][] stateSpecs = new int[N][];
            //for (int i=0; i<N; i++) {
                //stateSpecs[i] = source.createIntArray();
            //}
            //int[] colors = source.createIntArray();
            //return new ColorStateList(stateSpecs, colors);
        }

        
}; //Transformed anonymous class
}

