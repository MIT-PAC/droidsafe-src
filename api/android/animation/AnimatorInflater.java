package android.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;

public class AnimatorInflater {

    /**
     * Loads an {@link Animator} object from a resource
     *
     * @param context Application context used to access resources
     * @param id The resource id of the animation to load
     * @return The animator object reference by the specified id
     * @throws android.content.res.Resources.NotFoundException when the animation cannot be loaded
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.801 -0500", hash_original_method = "867C489934B793819C9588902A365D13", hash_generated_method = "EEB112F6BC658F8BBAC093C2FF604E3F")
    @DSVerified
    @DSSafe(DSCat.ANDROID_ANIMATION)
public static Animator loadAnimator(Context context, int id)
            throws NotFoundException {

        XmlResourceParser parser = null;
        try {
            parser = context.getResources().getAnimation(id);
            return createAnimatorFromXml(context, parser);
        } catch (XmlPullParserException ex) {
            Resources.NotFoundException rnf =
                    new Resources.NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex) {
            Resources.NotFoundException rnf =
                    new Resources.NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } finally {
            if (parser != null) parser.close();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.803 -0500", hash_original_method = "7F7EA310E666B8E19447863365BDF46E", hash_generated_method = "C62519A7EB69E1240EEEEA6CBC44ADD6")
    
private static Animator createAnimatorFromXml(Context c, XmlPullParser parser)
            throws XmlPullParserException, IOException {

        return createAnimatorFromXml(c, parser, Xml.asAttributeSet(parser), null, 0);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.806 -0500", hash_original_method = "0F6E721FE23D631E8AAECB95FEB62E01", hash_generated_method = "4F6E63F01B981F64B6F855BE1323A4D1")
    
private static Animator createAnimatorFromXml(Context c, XmlPullParser parser,
            AttributeSet attrs, AnimatorSet parent, int sequenceOrdering)
            throws XmlPullParserException, IOException {

        Animator anim = null;
        ArrayList<Animator> childAnims = null;

        // Make sure we are on a start tag.
        int type;
        int depth = parser.getDepth();

        while (((type=parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
               && type != XmlPullParser.END_DOCUMENT) {

            if (type != XmlPullParser.START_TAG) {
                continue;
            }

            String  name = parser.getName();

            if (name.equals("objectAnimator")) {
                anim = loadObjectAnimator(c, attrs);
            } else if (name.equals("animator")) {
                anim = loadAnimator(c, attrs, null);
            } else if (name.equals("set")) {
                anim = new AnimatorSet();
                TypedArray a = c.obtainStyledAttributes(attrs,
                        com.android.internal.R.styleable.AnimatorSet);
                int ordering = a.getInt(com.android.internal.R.styleable.AnimatorSet_ordering,
                        TOGETHER);
                createAnimatorFromXml(c, parser, attrs, (AnimatorSet) anim,  ordering);
                a.recycle();
            } else {
                throw new RuntimeException("Unknown animator name: " + parser.getName());
            }

            if (parent != null) {
                if (childAnims == null) {
                    childAnims = new ArrayList<Animator>();
                }
                childAnims.add(anim);
            }
        }
        if (parent != null && childAnims != null) {
            Animator[] animsArray = new Animator[childAnims.size()];
            int index = 0;
            for (Animator a : childAnims) {
                animsArray[index++] = a;
            }
            if (sequenceOrdering == TOGETHER) {
                parent.playTogether(animsArray);
            } else {
                parent.playSequentially(animsArray);
            }
        }

        return anim;

    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.809 -0500", hash_original_method = "E9BE17E1756C0F9FBDB33E7DB58F62ED", hash_generated_method = "CC986DE9F94EA317F16E7242BD770100")
    
private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attrs)
            throws NotFoundException {

        ObjectAnimator anim = new ObjectAnimator();

        loadAnimator(context, attrs, anim);

        TypedArray a =
                context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.PropertyAnimator);

        String propertyName = a.getString(com.android.internal.R.styleable.PropertyAnimator_propertyName);

        anim.setPropertyName(propertyName);

        a.recycle();

        return anim;
    }

    /**
     * Creates a new animation whose parameters come from the specified context and
     * attributes set.
     *
     * @param context the application environment
     * @param attrs the set of attributes holding the animation parameters
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.814 -0500", hash_original_method = "1948BDF01397223EDF19839C0F7A1A0C", hash_generated_method = "152B565EDC78596A805BD7DF2E407430")
    
private static ValueAnimator loadAnimator(Context context, AttributeSet attrs, ValueAnimator anim)
            throws NotFoundException {

        TypedArray a =
                context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.Animator);

        long duration = a.getInt(com.android.internal.R.styleable.Animator_duration, 0);

        long startDelay = a.getInt(com.android.internal.R.styleable.Animator_startOffset, 0);

        int valueType = a.getInt(com.android.internal.R.styleable.Animator_valueType,
                VALUE_TYPE_FLOAT);

        if (anim == null) {
            anim = new ValueAnimator();
        }
        TypeEvaluator evaluator = null;

        int valueFromIndex = com.android.internal.R.styleable.Animator_valueFrom;
        int valueToIndex = com.android.internal.R.styleable.Animator_valueTo;

        boolean getFloats = (valueType == VALUE_TYPE_FLOAT);

        TypedValue tvFrom = a.peekValue(valueFromIndex);
        boolean hasFrom = (tvFrom != null);
        int fromType = hasFrom ? tvFrom.type : 0;
        TypedValue tvTo = a.peekValue(valueToIndex);
        boolean hasTo = (tvTo != null);
        int toType = hasTo ? tvTo.type : 0;

        if ((hasFrom && (fromType >= TypedValue.TYPE_FIRST_COLOR_INT) &&
                (fromType <= TypedValue.TYPE_LAST_COLOR_INT)) ||
            (hasTo && (toType >= TypedValue.TYPE_FIRST_COLOR_INT) &&
                (toType <= TypedValue.TYPE_LAST_COLOR_INT))) {
            // special case for colors: ignore valueType and get ints
            getFloats = false;
            anim.setEvaluator(new ArgbEvaluator());
        }

        if (getFloats) {
            float valueFrom;
            float valueTo;
            if (hasFrom) {
                if (fromType == TypedValue.TYPE_DIMENSION) {
                    valueFrom = a.getDimension(valueFromIndex, 0f);
                } else {
                    valueFrom = a.getFloat(valueFromIndex, 0f);
                }
                if (hasTo) {
                    if (toType == TypedValue.TYPE_DIMENSION) {
                        valueTo = a.getDimension(valueToIndex, 0f);
                    } else {
                        valueTo = a.getFloat(valueToIndex, 0f);
                    }
                    anim.setFloatValues(valueFrom, valueTo);
                } else {
                    anim.setFloatValues(valueFrom);
                }
            } else {
                if (toType == TypedValue.TYPE_DIMENSION) {
                    valueTo = a.getDimension(valueToIndex, 0f);
                } else {
                    valueTo = a.getFloat(valueToIndex, 0f);
                }
                anim.setFloatValues(valueTo);
            }
        } else {
            int valueFrom;
            int valueTo;
            if (hasFrom) {
                if (fromType == TypedValue.TYPE_DIMENSION) {
                    valueFrom = (int) a.getDimension(valueFromIndex, 0f);
                } else if ((fromType >= TypedValue.TYPE_FIRST_COLOR_INT) &&
                        (fromType <= TypedValue.TYPE_LAST_COLOR_INT)) {
                    valueFrom = a.getColor(valueFromIndex, 0);
                } else {
                    valueFrom = a.getInt(valueFromIndex, 0);
                }
                if (hasTo) {
                    if (toType == TypedValue.TYPE_DIMENSION) {
                        valueTo = (int) a.getDimension(valueToIndex, 0f);
                    } else if ((toType >= TypedValue.TYPE_FIRST_COLOR_INT) &&
                            (toType <= TypedValue.TYPE_LAST_COLOR_INT)) {
                        valueTo = a.getColor(valueToIndex, 0);
                    } else {
                        valueTo = a.getInt(valueToIndex, 0);
                    }
                    anim.setIntValues(valueFrom, valueTo);
                } else {
                    anim.setIntValues(valueFrom);
                }
            } else {
                if (hasTo) {
                    if (toType == TypedValue.TYPE_DIMENSION) {
                        valueTo = (int) a.getDimension(valueToIndex, 0f);
                    } else if ((toType >= TypedValue.TYPE_FIRST_COLOR_INT) &&
                        (toType <= TypedValue.TYPE_LAST_COLOR_INT)) {
                        valueTo = a.getColor(valueToIndex, 0);
                    } else {
                        valueTo = a.getInt(valueToIndex, 0);
                    }
                    anim.setIntValues(valueTo);
                }
            }
        }

        anim.setDuration(duration);
        anim.setStartDelay(startDelay);

        if (a.hasValue(com.android.internal.R.styleable.Animator_repeatCount)) {
            anim.setRepeatCount(
                    a.getInt(com.android.internal.R.styleable.Animator_repeatCount, 0));
        }
        if (a.hasValue(com.android.internal.R.styleable.Animator_repeatMode)) {
            anim.setRepeatMode(
                    a.getInt(com.android.internal.R.styleable.Animator_repeatMode,
                            ValueAnimator.RESTART));
        }
        if (evaluator != null) {
            anim.setEvaluator(evaluator);
        }

        final int resID =
                a.getResourceId(com.android.internal.R.styleable.Animator_interpolator, 0);
        if (resID > 0) {
            anim.setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        }
        a.recycle();

        return anim;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.787 -0500", hash_original_field = "31840C65EBCC9B611F2D04F9CD2949C0", hash_generated_field = "490BA40ECAC7401230E37F6CEBA3BA68")

    private static final int TOGETHER = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.789 -0500", hash_original_field = "A210847C0A06CE4FC0BB17DB93B5E26D", hash_generated_field = "44AD87916965B5BF828EB108EEBE456E")

    private static final int SEQUENTIALLY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.791 -0500", hash_original_field = "A6F462C5EAE714D6348E8DA2CBD708BB", hash_generated_field = "A27617DD31601E2EB156A76530E8379C")

    private static final int VALUE_TYPE_FLOAT       = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.793 -0500", hash_original_field = "73143FA054095D5564BA085C7AF6288D", hash_generated_field = "6D21C1ED6B4C00EAB281850A3EBEE6B8")

    private static final int VALUE_TYPE_INT         = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.795 -0500", hash_original_field = "97D0936CEE70AC481C0C794DE5E68EC8", hash_generated_field = "238B1727D7604A09A087EB88A85EC858")

    private static final int VALUE_TYPE_COLOR       = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.797 -0500", hash_original_field = "1BE817A8943CC13D3B5E3B4DC58A3131", hash_generated_field = "1D53AE501AADB1CB9CB4D59D5FF93934")

    private static final int VALUE_TYPE_CUSTOM      = 5;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.942 -0400", hash_original_method = "755519606CB6AC3A2C6456CA27261C19", hash_generated_method = "755519606CB6AC3A2C6456CA27261C19")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    public AnimatorInflater ()
    {
        //Synthesized constructor
    }
}

