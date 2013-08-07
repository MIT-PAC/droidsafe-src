package android.view.animation;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Xml;





public class AnimationUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.854 -0400", hash_original_method = "356F4D62C52EA54268D4026A2BB604AB", hash_generated_method = "356F4D62C52EA54268D4026A2BB604AB")
    @DSModeled(DSC.SAFE)
    public AnimationUtils ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static long currentAnimationTimeMillis() {
        return SystemClock.uptimeMillis();
    }

    
    @DSModeled(DSC.SAFE)
    public static Animation loadAnimation(Context context, int id) throws NotFoundException {
        XmlResourceParser parser = null;
        try {
            parser = context.getResources().getAnimation(id);
            return createAnimationFromXml(context, parser);
        } catch (XmlPullParserException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } finally {
            if (parser != null) parser.close();
        }
    }

    
    @DSModeled(DSC.BAN)
    private static Animation createAnimationFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        return createAnimationFromXml(c, parser, null, Xml.asAttributeSet(parser));
    }

    
    @DSModeled(DSC.BAN)
    private static Animation createAnimationFromXml(Context c, XmlPullParser parser,
            AnimationSet parent, AttributeSet attrs) throws XmlPullParserException, IOException {
        Animation anim = null;
        int type;
        int depth = parser.getDepth();
        while (((type=parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
               && type != XmlPullParser.END_DOCUMENT) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }
            String  name = parser.getName();
            if (name.equals("set")) {
                anim = new AnimationSet(c, attrs);
                createAnimationFromXml(c, parser, (AnimationSet)anim, attrs);
            } else if (name.equals("alpha")) {
                anim = new AlphaAnimation(c, attrs);
            } else if (name.equals("scale")) {
                anim = new ScaleAnimation(c, attrs);
            }  else if (name.equals("rotate")) {
                anim = new RotateAnimation(c, attrs);
            }  else if (name.equals("translate")) {
                anim = new TranslateAnimation(c, attrs);
            } else {
                throw new RuntimeException("Unknown animation name: " + parser.getName());
            }
            if (parent != null) {
                parent.addAnimation(anim);
            }
        }
        return anim;
    }

    
    @DSModeled(DSC.SPEC)
    public static LayoutAnimationController loadLayoutAnimation(Context context, int id) throws NotFoundException {
        XmlResourceParser parser = null;
        try {
            parser = context.getResources().getAnimation(id);
            return createLayoutAnimationFromXml(context, parser);
        } catch (XmlPullParserException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } finally {
            if (parser != null) parser.close();
        }
    }

    
    @DSModeled(DSC.BAN)
    private static LayoutAnimationController createLayoutAnimationFromXml(Context c,
            XmlPullParser parser) throws XmlPullParserException, IOException {
        return createLayoutAnimationFromXml(c, parser, Xml.asAttributeSet(parser));
    }

    
    @DSModeled(DSC.BAN)
    private static LayoutAnimationController createLayoutAnimationFromXml(Context c,
            XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        LayoutAnimationController controller = null;
        int type;
        int depth = parser.getDepth();
        while (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                && type != XmlPullParser.END_DOCUMENT) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if ("layoutAnimation".equals(name)) {
                controller = new LayoutAnimationController(c, attrs);
            } else if ("gridLayoutAnimation".equals(name)) {
                controller = new GridLayoutAnimationController(c, attrs);
            } else {
                throw new RuntimeException("Unknown layout animation name: " + name);
            }
        }
        return controller;
    }

    
    @DSModeled(DSC.SAFE)
    public static Animation makeInAnimation(Context c, boolean fromLeft) {
        Animation a;
        if (fromLeft) {
            a = AnimationUtils.loadAnimation(c, com.android.internal.R.anim.slide_in_left);
        } else {
            a = AnimationUtils.loadAnimation(c, com.android.internal.R.anim.slide_in_right);
        }
        a.setInterpolator(new DecelerateInterpolator());
        a.setStartTime(currentAnimationTimeMillis());
        return a;
    }

    
    @DSModeled(DSC.SAFE)
    public static Animation makeOutAnimation(Context c, boolean toRight) {
        Animation a;
        if (toRight) {
            a = AnimationUtils.loadAnimation(c, com.android.internal.R.anim.slide_out_right);
        } else {
            a = AnimationUtils.loadAnimation(c, com.android.internal.R.anim.slide_out_left);
        }
        a.setInterpolator(new AccelerateInterpolator());
        a.setStartTime(currentAnimationTimeMillis());
        return a;
    }

    
    @DSModeled(DSC.SAFE)
    public static Animation makeInChildBottomAnimation(Context c) {
        Animation a;
        a = AnimationUtils.loadAnimation(c, com.android.internal.R.anim.slide_in_child_bottom);
        a.setInterpolator(new AccelerateInterpolator());
        a.setStartTime(currentAnimationTimeMillis());
        return a;
    }

    
    @DSModeled(DSC.SAFE)
    public static Interpolator loadInterpolator(Context context, int id) throws NotFoundException {
        XmlResourceParser parser = null;
        try {
            parser = context.getResources().getAnimation(id);
            return createInterpolatorFromXml(context, parser);
        } catch (XmlPullParserException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } finally {
            if (parser != null) parser.close();
        }
    }

    
    @DSModeled(DSC.BAN)
    private static Interpolator createInterpolatorFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        Interpolator interpolator = null;
        int type;
        int depth = parser.getDepth();
        while (((type=parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
               && type != XmlPullParser.END_DOCUMENT) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }
            AttributeSet attrs = Xml.asAttributeSet(parser);
            String  name = parser.getName();
            if (name.equals("linearInterpolator")) {
                interpolator = new LinearInterpolator(c, attrs);
            } else if (name.equals("accelerateInterpolator")) {
                interpolator = new AccelerateInterpolator(c, attrs);
            } else if (name.equals("decelerateInterpolator")) {
                interpolator = new DecelerateInterpolator(c, attrs);
            }  else if (name.equals("accelerateDecelerateInterpolator")) {
                interpolator = new AccelerateDecelerateInterpolator(c, attrs);
            }  else if (name.equals("cycleInterpolator")) {
                interpolator = new CycleInterpolator(c, attrs);
            } else if (name.equals("anticipateInterpolator")) {
                interpolator = new AnticipateInterpolator(c, attrs);
            } else if (name.equals("overshootInterpolator")) {
                interpolator = new OvershootInterpolator(c, attrs);
            } else if (name.equals("anticipateOvershootInterpolator")) {
                interpolator = new AnticipateOvershootInterpolator(c, attrs);
            } else if (name.equals("bounceInterpolator")) {
                interpolator = new BounceInterpolator(c, attrs);
            } else {
                throw new RuntimeException("Unknown interpolator name: " + parser.getName());
            }
        }
        return interpolator;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.857 -0400", hash_original_field = "C1FCEF32161A7BF89FDA53D614301098", hash_generated_field = "490BA40ECAC7401230E37F6CEBA3BA68")

    private static final int TOGETHER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.857 -0400", hash_original_field = "B568DA5D545ECA4D1ECFB6CD119EC659", hash_generated_field = "44AD87916965B5BF828EB108EEBE456E")

    private static final int SEQUENTIALLY = 1;
}

