package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final int[][] EMPTY = new int[][] { new int[0] };
    private static final SparseArray<WeakReference<ColorStateList>> sCache =
                            new SparseArray<WeakReference<ColorStateList>>();
    public static final Parcelable.Creator<ColorStateList> CREATOR = new Parcelable.Creator<ColorStateList>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.244 -0400", hash_original_method = "64FF1FD2247EB9835068885DC70066CC", hash_generated_method = "00A52C26146553C8E4A892514770B6A4")
        @DSModeled(DSC.SAFE)
        public ColorStateList[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ColorStateList[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ColorStateList[size];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.244 -0400", hash_original_method = "99D1C755B99765C149DCD766D7B3653A", hash_generated_method = "84C48826BB86D50B81F61DF1F44DB909")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ColorStateList createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            final int N;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.245 -0400", hash_original_method = "A1B9AA8D55CC71F4C566F389AC3D8BBC", hash_generated_method = "34C7AD0E3345C45675A0BED9A73A3C9D")
    @DSModeled(DSC.SAFE)
    private ColorStateList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.245 -0400", hash_original_method = "16DE5E515D4E313298C804E12AA820B9", hash_generated_method = "C4EA759C925149BC9168708DEA22D354")
    @DSModeled(DSC.SAFE)
    public ColorStateList(int[][] states, int[] colors) {
        dsTaint.addTaint(colors);
        dsTaint.addTaint(states.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.245 -0400", hash_original_method = "FCCF2821DEC9011A455F9F98CACE9BF9", hash_generated_method = "54908EBA630F5091972F57B4712DB8AF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.245 -0400", hash_original_method = "5986A0E2205D2782A4018155A452F4C2", hash_generated_method = "B6AA7295315B18C55E48EAB77A84A116")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.245 -0400", hash_original_method = "29461E82F281519D72B414C160880677", hash_generated_method = "2A1176A16A76E420F38B3ECB1167F71E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.246 -0400", hash_original_method = "C02A6B069CD8C9360FEC8CA407C14B4A", hash_generated_method = "D1FF3CDBC7923719470952129EB1F93B")
    @DSModeled(DSC.SAFE)
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
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int[] colors = new int[mColors.length];
        //int len = colors.length;
        //for (int i = 0; i < len; i++) {
            //colors[i] = (mColors[i] & 0xFFFFFF) | (alpha << 24);
        //}
        //return new ColorStateList(mStateSpecs, colors);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.248 -0400", hash_original_method = "096D4D4F0EE82FD61B43B813E755281E", hash_generated_method = "D9D20A28D5D3D144F9DF02839575BEB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        int type;
        final int innerDepth;
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
            boolean varF60F42190EBD36C414D066F0689226DF_1595536554 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && ((depth=parser.getDepth()) >= innerDepth
                   || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_247924692 = (depth > innerDepth || !parser.getName().equals("item"));
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
                final int numAttrs;
                numAttrs = attrs.getAttributeCount();
                int[] stateSpec;
                stateSpec = new int[numAttrs];
                {
                    i = 0;
                    {
                        final int stateResId;
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
                    throw new XmlPullParserException(
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
                listSize++;
            } //End block
        } //End collapsed parenthetic
        mColors = new int[listSize];
        mStateSpecs = new int[listSize][];
        System.arraycopy(colorList, 0, mColors, 0, listSize);
        System.arraycopy(stateSpecList, 0, mStateSpecs, 0, listSize);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.248 -0400", hash_original_method = "1C923E0661B9E6FB6B4C6C1FDCEBD767", hash_generated_method = "F9301553A5C55255DE505F8D1CFD16A1")
    @DSModeled(DSC.SAFE)
    public boolean isStateful() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStateSpecs.length > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.248 -0400", hash_original_method = "4327A241B2C451B5F5DDB6DF79352F03", hash_generated_method = "779C144A8CDC2572672FD75DFF3E9AE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColorForState(int[] stateSet, int defaultColor) {
        dsTaint.addTaint(stateSet);
        dsTaint.addTaint(defaultColor);
        final int setLength;
        setLength = mStateSpecs.length;
        {
            int i;
            i = 0;
            {
                int[] stateSpec;
                stateSpec = mStateSpecs[i];
                {
                    boolean var0BC14A81E745300E188A9AE767EF71BA_1818944849 = (StateSet.stateSetMatches(stateSpec, stateSet));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.249 -0400", hash_original_method = "28A9CB761E85FC98D00C67A51FDC0266", hash_generated_method = "DC7641F3FF81398B493E272305FEAB77")
    @DSModeled(DSC.SAFE)
    public int getDefaultColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDefaultColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.249 -0400", hash_original_method = "1483B624C0E3738F481F261D24FE0627", hash_generated_method = "20238D489AB2A136154EDE1374A182B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var5CE206CEBA5D7B0739473F0643A3116B_919273719 = ("ColorStateList{" +
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.249 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.249 -0400", hash_original_method = "E1B2D8F50F6285FEE430316C6FD92D49", hash_generated_method = "D8BADC3626ACAB3BB04F4A7A52C14940")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        final int N;
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

    
}


