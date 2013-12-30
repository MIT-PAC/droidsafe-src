package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Rect;





public class Gravity {

    /**
     * Apply a gravity constant to an object. This suppose that the layout direction is LTR.
     * 
     * @param gravity The desired placement of the object, as defined by the
     *                constants in this class.
     * @param w The horizontal size of the object.
     * @param h The vertical size of the object.
     * @param container The frame of the containing space, in which the object
     *                  will be placed.  Should be large enough to contain the
     *                  width and height of the object.
     * @param outRect Receives the computed frame of the object in its
     *                container.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.329 -0500", hash_original_method = "A674BAD38D7705D0D440DD3B391B22D6", hash_generated_method = "57E295F129CEDA9FA962B11B19569ABC")
    
public static void apply(int gravity, int w, int h, Rect container, Rect outRect) {
        apply(gravity, w, h, container, 0, 0, outRect);
    }

    /**
     * Apply a gravity constant to an object and take care if layout direction is RTL or not.
     *
     * @param gravity The desired placement of the object, as defined by the
     *                constants in this class.
     * @param w The horizontal size of the object.
     * @param h The vertical size of the object.
     * @param container The frame of the containing space, in which the object
     *                  will be placed.  Should be large enough to contain the
     *                  width and height of the object.
     * @param outRect Receives the computed frame of the object in its
     *                container.
     * @param layoutDirection The layout direction.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.332 -0500", hash_original_method = "48714A437D8A9113BC5943C1BF674836", hash_generated_method = "2A6EC70C28CF56F4B80C25920A682A8B")
    
public static void apply(int gravity, int w, int h, Rect container,
            Rect outRect, int layoutDirection) {
        int absGravity = getAbsoluteGravity(gravity, layoutDirection);
        apply(absGravity, w, h, container, 0, 0, outRect);
    }

    /**
     * Apply a gravity constant to an object.
     * 
     * @param gravity The desired placement of the object, as defined by the
     *                constants in this class.
     * @param w The horizontal size of the object.
     * @param h The vertical size of the object.
     * @param container The frame of the containing space, in which the object
     *                  will be placed.  Should be large enough to contain the
     *                  width and height of the object.
     * @param xAdj Offset to apply to the X axis.  If gravity is LEFT this
     *             pushes it to the right; if gravity is RIGHT it pushes it to
     *             the left; if gravity is CENTER_HORIZONTAL it pushes it to the
     *             right or left; otherwise it is ignored.
     * @param yAdj Offset to apply to the Y axis.  If gravity is TOP this pushes
     *             it down; if gravity is BOTTOM it pushes it up; if gravity is
     *             CENTER_VERTICAL it pushes it down or up; otherwise it is
     *             ignored.
     * @param outRect Receives the computed frame of the object in its
     *                container.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.337 -0500", hash_original_method = "90A08A9DD00D03BD7934A3A8059C60AE", hash_generated_method = "AD0067790C40DF14C2A78239349B23A0")
    
public static void apply(int gravity, int w, int h, Rect container,
            int xAdj, int yAdj, Rect outRect) {
        switch (gravity&((AXIS_PULL_BEFORE|AXIS_PULL_AFTER)<<AXIS_X_SHIFT)) {
            case 0:
                outRect.left = container.left
                        + ((container.right - container.left - w)/2) + xAdj;
                outRect.right = outRect.left + w;
                if ((gravity&(AXIS_CLIP<<AXIS_X_SHIFT))
                        == (AXIS_CLIP<<AXIS_X_SHIFT)) {
                    if (outRect.left < container.left) {
                        outRect.left = container.left;
                    }
                    if (outRect.right > container.right) {
                        outRect.right = container.right;
                    }
                }
                break;
            case AXIS_PULL_BEFORE<<AXIS_X_SHIFT:
                outRect.left = container.left + xAdj;
                outRect.right = outRect.left + w;
                if ((gravity&(AXIS_CLIP<<AXIS_X_SHIFT))
                        == (AXIS_CLIP<<AXIS_X_SHIFT)) {
                    if (outRect.right > container.right) {
                        outRect.right = container.right;
                    }
                }
                break;
            case AXIS_PULL_AFTER<<AXIS_X_SHIFT:
                outRect.right = container.right - xAdj;
                outRect.left = outRect.right - w;
                if ((gravity&(AXIS_CLIP<<AXIS_X_SHIFT))
                        == (AXIS_CLIP<<AXIS_X_SHIFT)) {
                    if (outRect.left < container.left) {
                        outRect.left = container.left;
                    }
                }
                break;
            default:
                outRect.left = container.left + xAdj;
                outRect.right = container.right + xAdj;
                break;
        }
        
        switch (gravity&((AXIS_PULL_BEFORE|AXIS_PULL_AFTER)<<AXIS_Y_SHIFT)) {
            case 0:
                outRect.top = container.top
                        + ((container.bottom - container.top - h)/2) + yAdj;
                outRect.bottom = outRect.top + h;
                if ((gravity&(AXIS_CLIP<<AXIS_Y_SHIFT))
                        == (AXIS_CLIP<<AXIS_Y_SHIFT)) {
                    if (outRect.top < container.top) {
                        outRect.top = container.top;
                    }
                    if (outRect.bottom > container.bottom) {
                        outRect.bottom = container.bottom;
                    }
                }
                break;
            case AXIS_PULL_BEFORE<<AXIS_Y_SHIFT:
                outRect.top = container.top + yAdj;
                outRect.bottom = outRect.top + h;
                if ((gravity&(AXIS_CLIP<<AXIS_Y_SHIFT))
                        == (AXIS_CLIP<<AXIS_Y_SHIFT)) {
                    if (outRect.bottom > container.bottom) {
                        outRect.bottom = container.bottom;
                    }
                }
                break;
            case AXIS_PULL_AFTER<<AXIS_Y_SHIFT:
                outRect.bottom = container.bottom - yAdj;
                outRect.top = outRect.bottom - h;
                if ((gravity&(AXIS_CLIP<<AXIS_Y_SHIFT))
                        == (AXIS_CLIP<<AXIS_Y_SHIFT)) {
                    if (outRect.top < container.top) {
                        outRect.top = container.top;
                    }
                }
                break;
            default:
                outRect.top = container.top + yAdj;
                outRect.bottom = container.bottom + yAdj;
                break;
        }
    }

    /**
     * Apply additional gravity behavior based on the overall "display" that an
     * object exists in.  This can be used after
     * {@link #apply(int, int, int, Rect, int, int, Rect)} to place the object
     * within a visible display.  By default this moves or clips the object
     * to be visible in the display; the gravity flags
     * {@link #DISPLAY_CLIP_HORIZONTAL} and {@link #DISPLAY_CLIP_VERTICAL}
     * can be used to change this behavior.
     * 
     * @param gravity Gravity constants to modify the placement within the
     * display.
     * @param display The rectangle of the display in which the object is
     * being placed.
     * @param inoutObj Supplies the current object position; returns with it
     * modified if needed to fit in the display.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.342 -0500", hash_original_method = "4DADE2ED4614B557691AD1421788BDE3", hash_generated_method = "2C545D1FB947278F2E1C4B6DDA29EF0B")
    
public static void applyDisplay(int gravity, Rect display, Rect inoutObj) {
        if ((gravity&DISPLAY_CLIP_VERTICAL) != 0) {
            if (inoutObj.top < display.top) inoutObj.top = display.top;
            if (inoutObj.bottom > display.bottom) inoutObj.bottom = display.bottom;
        } else {
            int off = 0;
            if (inoutObj.top < display.top) off = display.top-inoutObj.top;
            else if (inoutObj.bottom > display.bottom) off = display.bottom-inoutObj.bottom;
            if (off != 0) {
                if (inoutObj.height() > (display.bottom-display.top)) {
                    inoutObj.top = display.top;
                    inoutObj.bottom = display.bottom;
                } else {
                    inoutObj.top += off;
                    inoutObj.bottom += off;
                }
            }
        }
        
        if ((gravity&DISPLAY_CLIP_HORIZONTAL) != 0) {
            if (inoutObj.left < display.left) inoutObj.left = display.left;
            if (inoutObj.right > display.right) inoutObj.right = display.right;
        } else {
            int off = 0;
            if (inoutObj.left < display.left) off = display.left-inoutObj.left;
            else if (inoutObj.right > display.right) off = display.right-inoutObj.right;
            if (off != 0) {
                if (inoutObj.width() > (display.right-display.left)) {
                    inoutObj.left = display.left;
                    inoutObj.right = display.right;
                } else {
                    inoutObj.left += off;
                    inoutObj.right += off;
                }
            }
        }
    }
    
    /**
     * <p>Indicate whether the supplied gravity has a vertical pull.</p>
     *
     * @param gravity the gravity to check for vertical pull
     * @return true if the supplied gravity has a vertical pull
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.347 -0500", hash_original_method = "1F47EE467986BB0FFF0B9D8C3E5BF63C", hash_generated_method = "7832ED6601F42177E105964EB06301A4")
    
public static boolean isVertical(int gravity) {
        return gravity > 0 && (gravity & VERTICAL_GRAVITY_MASK) != 0;
    }

    /**
     * <p>Indicate whether the supplied gravity has an horizontal pull.</p>
     *
     * @param gravity the gravity to check for horizontal pull
     * @return true if the supplied gravity has an horizontal pull
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.352 -0500", hash_original_method = "0E7A1CD360B45111318BE8F6B32E8E98", hash_generated_method = "F62683C44332C899647B093DB2541D5A")
    
public static boolean isHorizontal(int gravity) {
        return gravity > 0 && (gravity & RELATIVE_HORIZONTAL_GRAVITY_MASK) != 0;
    }

    /**
     * <p>Convert script specific gravity to absolute horizontal value.</p>
     *
     * if horizontal direction is LTR, then START will set LEFT and END will set RIGHT.
     * if horizontal direction is RTL, then START will set RIGHT and END will set LEFT.
     *
     *
     * @param gravity The gravity to convert to absolute (horizontal) values.
     * @param layoutDirection The layout direction.
     * @return gravity converted to absolute (horizontal) values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.357 -0500", hash_original_method = "37EF9EE7320B485FC2AA136E992B8620", hash_generated_method = "436CE65F63BDA46BD9A23D7B3143408A")
    
public static int getAbsoluteGravity(int gravity, int layoutDirection) {
        int result = gravity;
        // If layout is script specific and gravity is horizontal relative (START or END)
        if ((result & RELATIVE_LAYOUT_DIRECTION) > 0) {
            if ((result & Gravity.START) == Gravity.START) {
                // Remove the START bit
                result &= ~START;
                if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                    // Set the RIGHT bit
                    result |= RIGHT;
                } else {
                    // Set the LEFT bit
                    result |= LEFT;
                }
            } else if ((result & Gravity.END) == Gravity.END) {
                // Remove the END bit
                result &= ~END;
                if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                    // Set the LEFT bit
                    result |= LEFT;
                } else {
                    // Set the RIGHT bit
                    result |= RIGHT;
                }
            }
            // Don't need the script specific bit any more, so remove it as we are converting to
            // absolute values (LEFT or RIGHT)
            result &= ~RELATIVE_LAYOUT_DIRECTION;
        }
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.247 -0500", hash_original_field = "A9A7BB7EF388477F115C8C2ADA57C231", hash_generated_field = "390CB23372FC422A26F70D8CAA3787AE")

    public static final int NO_GRAVITY = 0x0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.250 -0500", hash_original_field = "471B389FEEF12C218565080915241ED9", hash_generated_field = "8978B1B8922D9D459B4196E16A71EB1A")

    public static final int AXIS_SPECIFIED = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.253 -0500", hash_original_field = "CB2D75A3E867CC97A6694276CFC491C0", hash_generated_field = "CE35F444D19571BBF6AF333D2602B8F0")

    public static final int AXIS_PULL_BEFORE = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.255 -0500", hash_original_field = "CED9A096BC0DBCE427ED8139B47E2CBB", hash_generated_field = "F522FAD8644313F78DCC58FF24E0BBF9")

    public static final int AXIS_PULL_AFTER = 0x0004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.258 -0500", hash_original_field = "4083866067AE6E578600D26E837FE72E", hash_generated_field = "93F6D549C98ECD2D78B9ED26DCC83C5F")

    public static final int AXIS_CLIP = 0x0008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.260 -0500", hash_original_field = "7DEB8A8B4756FA543301318FFE36F7EB", hash_generated_field = "6842EB52A3DD780729DC815D258B02C3")

    public static final int AXIS_X_SHIFT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.263 -0500", hash_original_field = "13E75054027F6BAC5C2FE0D49BA0341C", hash_generated_field = "E2A70E5A0ED91CEBE7E165584A1CFAC9")

    public static final int AXIS_Y_SHIFT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.266 -0500", hash_original_field = "15E2535A973C5E5B4FF2A88963C109CF", hash_generated_field = "4543CF1E6C1998A4DC4212D7AA76F4E5")

    public static final int TOP = (AXIS_PULL_BEFORE|AXIS_SPECIFIED)<<AXIS_Y_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.269 -0500", hash_original_field = "29C1E4806A4F1B03D1E50FDAE2422AA5", hash_generated_field = "6482F45E29957FD4A1BAAA262B4A0224")

    public static final int BOTTOM = (AXIS_PULL_AFTER|AXIS_SPECIFIED)<<AXIS_Y_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.271 -0500", hash_original_field = "988A709EDED4C5E995253963F84849AB", hash_generated_field = "94FA706DC7C7F16A4EEF7E1D96B66CFC")

    public static final int LEFT = (AXIS_PULL_BEFORE|AXIS_SPECIFIED)<<AXIS_X_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.274 -0500", hash_original_field = "59A1C0A7A6F71CBF6009476F70B387E5", hash_generated_field = "55F9F16F230137BA797030C6549658A0")

    public static final int RIGHT = (AXIS_PULL_AFTER|AXIS_SPECIFIED)<<AXIS_X_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.276 -0500", hash_original_field = "6354CAF0AD8C98621942D9ADE7879963", hash_generated_field = "DC249D4AF2F5F57172D9BBCDB08ADB70")

    public static final int CENTER_VERTICAL = AXIS_SPECIFIED<<AXIS_Y_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.279 -0500", hash_original_field = "BA998419ED120A2A6EB1D6FDCA434239", hash_generated_field = "68CED1E5D4862B20B89F5265817A81FC")

    public static final int FILL_VERTICAL = TOP|BOTTOM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.281 -0500", hash_original_field = "F8CDBE1517F087976E836650DF57DAE8", hash_generated_field = "5DCBC025165DD0ADD592A9825770EA09")

    public static final int CENTER_HORIZONTAL = AXIS_SPECIFIED<<AXIS_X_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.286 -0500", hash_original_field = "710D571CEADDF01D9EEF6A9F3B31C0AE", hash_generated_field = "2F3A963F3BBC49447711EB2AB15492D2")

    public static final int FILL_HORIZONTAL = LEFT|RIGHT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.291 -0500", hash_original_field = "7F2A4879F7198C4816718A2D58685C05", hash_generated_field = "1EA247B4FBEEDBF774D1F9E6BC25FE7B")

    public static final int CENTER = CENTER_VERTICAL|CENTER_HORIZONTAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.293 -0500", hash_original_field = "CDE70247360D0F1C13BE33A89BFA0391", hash_generated_field = "624E4ECF6AF63A78B4AAC5C10141CE60")

    public static final int FILL = FILL_VERTICAL|FILL_HORIZONTAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.297 -0500", hash_original_field = "514804D2FDA70F1F175B6EFA7EF6E975", hash_generated_field = "6D2EA4D67AE0F464C066B7C53E70822C")

    public static final int CLIP_VERTICAL = AXIS_CLIP<<AXIS_Y_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.301 -0500", hash_original_field = "3710BA23C7BF19E64019F4FF15744FBE", hash_generated_field = "7A169A7667F3BA5C61B2181C9B881A80")

    public static final int CLIP_HORIZONTAL = AXIS_CLIP<<AXIS_X_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.304 -0500", hash_original_field = "C578C91BD8760FF8962DE1CEBE458715", hash_generated_field = "244F6F66FA77B1BA261012A1DB3B883F")

    public static final int RELATIVE_LAYOUT_DIRECTION = 0x00800000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.308 -0500", hash_original_field = "87C16A7D04671D6CAC2932C0046CD041", hash_generated_field = "1C56FBD8CA95A9E98FCA4FF47C24D04F")

    public static final int HORIZONTAL_GRAVITY_MASK = (AXIS_SPECIFIED |
            AXIS_PULL_BEFORE | AXIS_PULL_AFTER) << AXIS_X_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.311 -0500", hash_original_field = "43E64E43C460006BB03979F378F05DA6", hash_generated_field = "44998F3F040B027230058CC6F3114A95")

    public static final int VERTICAL_GRAVITY_MASK = (AXIS_SPECIFIED |
            AXIS_PULL_BEFORE | AXIS_PULL_AFTER) << AXIS_Y_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.314 -0500", hash_original_field = "3E749CA0783B34FE30BCF93388FC7D45", hash_generated_field = "DEC6074C673D2089C0B0FB2418871762")

    public static final int DISPLAY_CLIP_VERTICAL = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.318 -0500", hash_original_field = "74C25B2D4AC1A5E725E20EA1240049B0", hash_generated_field = "CD222F7DEC3C187C417094586EC9F381")

    public static final int DISPLAY_CLIP_HORIZONTAL = 0x01000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.321 -0500", hash_original_field = "6BE4719C1B858960E6D31CDB095E2060", hash_generated_field = "29F1BD0637D8F7679C75FF7412266658")

    public static final int START = RELATIVE_LAYOUT_DIRECTION | LEFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.324 -0500", hash_original_field = "E755FE9074209C53F39DF74623196172", hash_generated_field = "37E79D6AC565BF5673CD41E5C4943161")

    public static final int END = RELATIVE_LAYOUT_DIRECTION | RIGHT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.327 -0500", hash_original_field = "2BE0CDDC90FBE4CA1BB317ED9C6D3BB3", hash_generated_field = "8FE6AB1D802BBC04FC5F75B277F16533")

    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = START | END;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.407 -0400", hash_original_method = "C8FD8F8974FEA261C49D0525477D6D45", hash_generated_method = "C8FD8F8974FEA261C49D0525477D6D45")
    public Gravity ()
    {
        //Synthesized constructor
    }
}

