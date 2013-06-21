package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intent implements Parcelable, Cloneable {
    private String mAction;
    private Uri mData;
    private String mType;
    private String mPackage;
    private ComponentName mComponent;
    private int mFlags;
    private HashSet<String> mCategories;
    private Bundle mExtras;
    private Rect mSourceBounds;
    private Intent mSelector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.492 -0400", hash_original_method = "5C0F2C7B56AA3A635FE64462CDD8279E", hash_generated_method = "2F40AB6E2EC88F714802FB672BF7EC58")
    @DSModeled(DSC.SAFE)
    public Intent() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.499 -0400", hash_original_method = "3FAB664599EE7924CC36F277EFA522C8", hash_generated_method = "83F165E56777A8456D0B403054E2F67E")
    @DSModeled(DSC.SPEC)
    public Intent(Intent o) {
        dsTaint.addTaint(o.dsTaint);
        this.mAction = o.mAction;
        this.mData = o.mData;
        this.mType = o.mType;
        this.mPackage = o.mPackage;
        this.mComponent = o.mComponent;
        this.mFlags = o.mFlags;
        {
            this.mCategories = new HashSet<String>(o.mCategories);
        } //End block
        {
            this.mExtras = new Bundle(o.mExtras);
        } //End block
        {
            this.mSourceBounds = new Rect(o.mSourceBounds);
        } //End block
        {
            this.mSelector = new Intent(o.mSelector);
        } //End block
        // ---------- Original Method ----------
        //this.mAction = o.mAction;
        //this.mData = o.mData;
        //this.mType = o.mType;
        //this.mPackage = o.mPackage;
        //this.mComponent = o.mComponent;
        //this.mFlags = o.mFlags;
        //if (o.mCategories != null) {
            //this.mCategories = new HashSet<String>(o.mCategories);
        //}
        //if (o.mExtras != null) {
            //this.mExtras = new Bundle(o.mExtras);
        //}
        //if (o.mSourceBounds != null) {
            //this.mSourceBounds = new Rect(o.mSourceBounds);
        //}
        //if (o.mSelector != null) {
            //this.mSelector = new Intent(o.mSelector);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.503 -0400", hash_original_method = "C1E3B3E9040DD8E1371895A668D56796", hash_generated_method = "2F12DE5D61AE2B33800766E354AFE8CC")
    @DSModeled(DSC.SPEC)
    private Intent(Intent o, boolean all) {
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(all);
        this.mAction = o.mAction;
        this.mData = o.mData;
        this.mType = o.mType;
        this.mPackage = o.mPackage;
        this.mComponent = o.mComponent;
        {
            this.mCategories = new HashSet<String>(o.mCategories);
        } //End block
        // ---------- Original Method ----------
        //this.mAction = o.mAction;
        //this.mData = o.mData;
        //this.mType = o.mType;
        //this.mPackage = o.mPackage;
        //this.mComponent = o.mComponent;
        //if (o.mCategories != null) {
            //this.mCategories = new HashSet<String>(o.mCategories);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.505 -0400", hash_original_method = "D5ECE127B03D5F5367AC94B767F0584E", hash_generated_method = "2A7EE197BFA05B8D67898C9016E636ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Intent(String action) {
        dsTaint.addTaint(action);
        setAction(action);
        // ---------- Original Method ----------
        //setAction(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.506 -0400", hash_original_method = "FF213ACFD5B7DFA2C83F432472B13960", hash_generated_method = "A373881FDA106962D3D652666461BC44")
    @DSModeled(DSC.SPEC)
    public Intent(String action, Uri uri) {
        dsTaint.addTaint(action);
        dsTaint.addTaint(uri.dsTaint);
        setAction(action);
        // ---------- Original Method ----------
        //setAction(action);
        //mData = uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.508 -0400", hash_original_method = "8A8F598E2C7B57A58F1379D7AFC8B81F", hash_generated_method = "1B52B7612850510BAB01ACC5DC5BD235")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Intent(Context packageContext, Class<?> cls) {
        dsTaint.addTaint(packageContext.dsTaint);
        dsTaint.addTaint(cls.dsTaint);
        mComponent = new ComponentName(packageContext, cls);
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, cls);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.510 -0400", hash_original_method = "780AF3DA4D357977F460A8077F315476", hash_generated_method = "EC3EBBA9DA694B1CD8011DF73A73F81A")
    @DSModeled(DSC.SPEC)
    public Intent(String action, Uri uri,
            Context packageContext, Class<?> cls) {
        dsTaint.addTaint(packageContext.dsTaint);
        dsTaint.addTaint(cls.dsTaint);
        dsTaint.addTaint(action);
        dsTaint.addTaint(uri.dsTaint);
        setAction(action);
        mComponent = new ComponentName(packageContext, cls);
        // ---------- Original Method ----------
        //setAction(action);
        //mData = uri;
        //mComponent = new ComponentName(packageContext, cls);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.511 -0400", hash_original_method = "BDABA8F9DB7F141DA2E5B48F186347CF", hash_generated_method = "6FF796ABBE12684DA875E858E43FA929")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Intent(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    public static Intent createChooser(Intent target, CharSequence title) {
        Intent intent = new Intent(ACTION_CHOOSER);
        intent.putExtra(EXTRA_INTENT, target);
        if (title != null) {
            intent.putExtra(EXTRA_TITLE, title);
        }
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.516 -0400", hash_original_method = "0DE1E082CFAE738C657D3967F7BD3FA4", hash_generated_method = "32403DFE939FE17F299364005524B597")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        Object var0157F89395D7677BFF5A09AAD966491F_322805719 = (new Intent(this));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Intent(this);
    }

    
    @DSModeled // Marked as SPEC per the original implementation from MIT
    public Intent cloneFilter() {
        return new Intent(this, false);
    }

    
    public static Intent makeMainActivity(ComponentName mainActivity) {
        Intent intent = new Intent(ACTION_MAIN);
        intent.setComponent(mainActivity);
        intent.addCategory(CATEGORY_LAUNCHER);
        return intent;
    }

    
    public static Intent makeMainSelectorActivity(String selectorAction,
            String selectorCategory) {
        Intent intent = new Intent(ACTION_MAIN);
        intent.addCategory(CATEGORY_LAUNCHER);
        Intent selector = new Intent();
        selector.setAction(selectorAction);
        selector.addCategory(selectorCategory);
        intent.setSelector(selector);
        return intent;
    }

    
    public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        Intent intent = makeMainActivity(mainActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    
    @Deprecated
    public static Intent getIntent(String uri) throws URISyntaxException {
        return parseUri(uri, 0);
    }

    
    public static Intent parseUri(String uri, int flags) throws URISyntaxException {
        int i = 0;
        try {
            if ((flags&URI_INTENT_SCHEME) != 0) {
                if (!uri.startsWith("intent:")) {
                    Intent intent = new Intent(ACTION_VIEW);
                    try {
                        intent.setData(Uri.parse(uri));
                    } catch (IllegalArgumentException e) {
                        throw new URISyntaxException(uri, e.getMessage());
                    }
                    return intent;
                }
            }
            i = uri.lastIndexOf("#");
            if (i == -1) return new Intent(ACTION_VIEW, Uri.parse(uri));
            if (!uri.startsWith("#Intent;", i)) return getIntentOld(uri);
            Intent intent = new Intent(ACTION_VIEW);
            Intent baseIntent = intent;
            String data = i >= 0 ? uri.substring(0, i) : null;
            String scheme = null;
            i += "#Intent;".length();
            while (!uri.startsWith("end", i)) {
                int eq = uri.indexOf('=', i);
                if (eq < 0) eq = i-1;
                int semi = uri.indexOf(';', i);
                String value = eq < semi ? Uri.decode(uri.substring(eq + 1, semi)) : "";
                if (uri.startsWith("action=", i)) {
                    intent.setAction(value);
                }
                else if (uri.startsWith("category=", i)) {
                    intent.addCategory(value);
                }
                else if (uri.startsWith("type=", i)) {
                    intent.mType = value;
                }
                else if (uri.startsWith("launchFlags=", i)) {
                    intent.mFlags = Integer.decode(value).intValue();
                }
                else if (uri.startsWith("package=", i)) {
                    intent.mPackage = value;
                }
                else if (uri.startsWith("component=", i)) {
                    intent.mComponent = ComponentName.unflattenFromString(value);
                }
                else if (uri.startsWith("scheme=", i)) {
                    scheme = value;
                }
                else if (uri.startsWith("sourceBounds=", i)) {
                    intent.mSourceBounds = Rect.unflattenFromString(value);
                }
                else if (semi == (i+3) && uri.startsWith("SEL", i)) {
                    intent = new Intent();
                }
                else {
                    String key = Uri.decode(uri.substring(i + 2, eq));
                    if (intent.mExtras == null) intent.mExtras = new Bundle();
                    Bundle b = intent.mExtras;
                    if      (uri.startsWith("S.", i)) b.putString(key, value);
                    else if (uri.startsWith("B.", i)) b.putBoolean(key, Boolean.parseBoolean(value));
                    else if (uri.startsWith("b.", i)) b.putByte(key, Byte.parseByte(value));
                    else if (uri.startsWith("c.", i)) b.putChar(key, value.charAt(0));
                    else if (uri.startsWith("d.", i)) b.putDouble(key, Double.parseDouble(value));
                    else if (uri.startsWith("f.", i)) b.putFloat(key, Float.parseFloat(value));
                    else if (uri.startsWith("i.", i)) b.putInt(key, Integer.parseInt(value));
                    else if (uri.startsWith("l.", i)) b.putLong(key, Long.parseLong(value));
                    else if (uri.startsWith("s.", i)) b.putShort(key, Short.parseShort(value));
                    else throw new URISyntaxException(uri, "unknown EXTRA type", i);
                }
                i = semi + 1;
            }
            if (intent != baseIntent) {
                baseIntent.setSelector(intent);
                intent = baseIntent;
            }
            if (data != null) {
                if (data.startsWith("intent:")) {
                    data = data.substring(7);
                    if (scheme != null) {
                        data = scheme + ':' + data;
                    }
                }
                if (data.length() > 0) {
                    try {
                        intent.mData = Uri.parse(data);
                    } catch (IllegalArgumentException e) {
                        throw new URISyntaxException(uri, e.getMessage());
                    }
                }
            }
            return intent;
        } catch (IndexOutOfBoundsException e) {
            throw new URISyntaxException(uri, "illegal Intent URI format", i);
        }
    }

    
    public static Intent getIntentOld(String uri) throws URISyntaxException {
        Intent intent;
        int i = uri.lastIndexOf('#');
        if (i >= 0) {
            String action = null;
            final int intentFragmentStart = i;
            boolean isIntentFragment = false;
            i++;
            if (uri.regionMatches(i, "action(", 0, 7)) {
                isIntentFragment = true;
                i += 7;
                int j = uri.indexOf(')', i);
                action = uri.substring(i, j);
                i = j + 1;
            }
            intent = new Intent(action);
            if (uri.regionMatches(i, "categories(", 0, 11)) {
                isIntentFragment = true;
                i += 11;
                int j = uri.indexOf(')', i);
                while (i < j) {
                    int sep = uri.indexOf('!', i);
                    if (sep < 0) sep = j;
                    if (i < sep) {
                        intent.addCategory(uri.substring(i, sep));
                    }
                    i = sep + 1;
                }
                i = j + 1;
            }
            if (uri.regionMatches(i, "type(", 0, 5)) {
                isIntentFragment = true;
                i += 5;
                int j = uri.indexOf(')', i);
                intent.mType = uri.substring(i, j);
                i = j + 1;
            }
            if (uri.regionMatches(i, "launchFlags(", 0, 12)) {
                isIntentFragment = true;
                i += 12;
                int j = uri.indexOf(')', i);
                intent.mFlags = Integer.decode(uri.substring(i, j)).intValue();
                i = j + 1;
            }
            if (uri.regionMatches(i, "component(", 0, 10)) {
                isIntentFragment = true;
                i += 10;
                int j = uri.indexOf(')', i);
                int sep = uri.indexOf('!', i);
                if (sep >= 0 && sep < j) {
                    String pkg = uri.substring(i, sep);
                    String cls = uri.substring(sep + 1, j);
                    intent.mComponent = new ComponentName(pkg, cls);
                }
                i = j + 1;
            }
            if (uri.regionMatches(i, "extras(", 0, 7)) {
                isIntentFragment = true;
                i += 7;
                final int closeParen = uri.indexOf(')', i);
                if (closeParen == -1) throw new URISyntaxException(uri,
                        "EXTRA missing trailing ')'", i);
                while (i < closeParen) {
                    int j = uri.indexOf('=', i);
                    if (j <= i + 1 || i >= closeParen) {
                        throw new URISyntaxException(uri, "EXTRA missing '='", i);
                    }
                    char type = uri.charAt(i);
                    i++;
                    String key = uri.substring(i, j);
                    i = j + 1;
                    j = uri.indexOf('!', i);
                    if (j == -1 || j >= closeParen) j = closeParen;
                    if (i >= j) throw new URISyntaxException(uri, "EXTRA missing '!'", i);
                    String value = uri.substring(i, j);
                    i = j;
                    if (intent.mExtras == null) intent.mExtras = new Bundle();
                    try {
                        switch (type) {
                            case 'S':
                                intent.mExtras.putString(key, Uri.decode(value));
                                break;
                            case 'B':
                                intent.mExtras.putBoolean(key, Boolean.parseBoolean(value));
                                break;
                            case 'b':
                                intent.mExtras.putByte(key, Byte.parseByte(value));
                                break;
                            case 'c':
                                intent.mExtras.putChar(key, Uri.decode(value).charAt(0));
                                break;
                            case 'd':
                                intent.mExtras.putDouble(key, Double.parseDouble(value));
                                break;
                            case 'f':
                                intent.mExtras.putFloat(key, Float.parseFloat(value));
                                break;
                            case 'i':
                                intent.mExtras.putInt(key, Integer.parseInt(value));
                                break;
                            case 'l':
                                intent.mExtras.putLong(key, Long.parseLong(value));
                                break;
                            case 's':
                                intent.mExtras.putShort(key, Short.parseShort(value));
                                break;
                            default:
                                throw new URISyntaxException(uri, "EXTRA has unknown type", i);
                        }
                    } catch (NumberFormatException e) {
                        throw new URISyntaxException(uri, "EXTRA value can't be parsed", i);
                    }
                    char ch = uri.charAt(i);
                    if (ch == ')') break;
                    if (ch != '!') throw new URISyntaxException(uri, "EXTRA missing '!'", i);
                    i++;
                }
            }
            if (isIntentFragment) {
                intent.mData = Uri.parse(uri.substring(0, intentFragmentStart));
            } else {
                intent.mData = Uri.parse(uri);
            }
            if (intent.mAction == null) {
                intent.mAction = ACTION_VIEW;
            }
        } else {
            intent = new Intent(ACTION_VIEW, Uri.parse(uri));
        }
        return intent;
    }

    
    @DSModeled(DSC.SAFE) // Marked as SPEC per the original implementation from MIT
	public String getAction() {
		return dsTaint.getTaintString();
        //return mAction;
    }

    
    @DSModeled(value = DSC.SAFE)
	public Uri getData() {
		return (Uri)dsTaint.getTaint();
        //return mData;
    }

    
    @DSModeled(value = DSC.SAFE)
	public String getDataString() {
		return dsTaint.getTaintString();
        //return mData != null ? mData.toString() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.537 -0400", hash_original_method = "773226227E17626211D04D8FDBCEC473", hash_generated_method = "9A719C808E33EA41DDBD583A32B5A622")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getScheme() {
        {
            Object var5BCE5BCE4346F17AB3B3FBE72E945FBA_479440910 = (mData.getScheme());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mData != null ? mData.getScheme() : null;
    }

    
    @DSModeled(DSC.SAFE) // Marked as SPEC per the original implementation from MIT
	public String getType() {
		return dsTaint.getTaintString();
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.549 -0400", hash_original_method = "BE275DDE2732AB3F4C79CA9D98784573", hash_generated_method = "8F705A243EFB485BFB450EC5084D4B6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String resolveType(Context context) {
        dsTaint.addTaint(context.dsTaint);
        String var503AC6ADE9C234A4016D6D0E552F860D_677844166 = (resolveType(context.getContentResolver()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return resolveType(context.getContentResolver());
    }

    
    @DSModeled(value = DSC.SAFE)
	public String resolveType(ContentResolver resolver) {
		/*
        if (mType != null) {
            return mType;
        }
        if (mData != null) { 
            if ("content".equals(mData.getScheme())) {
                return resolver.getType(mData);
            }
        }
        return null;
        */
		return getType();  //At the end of the day, it's a string, and we are doing static analysis
    }

    
    @DSModeled(value = DSC.SAFE)
	public String resolveTypeIfNeeded(ContentResolver resolver) {
		/*
		if (mComponent != null) {
		    return getType();
		}
		return resolveType(resolver);
		*/
		return getType();  //At the end of the day, it's a string, and we are doing static analysis
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.551 -0400", hash_original_method = "3612221F73372432993CCD6954A20D1D", hash_generated_method = "C575820E10CB55EFF4D24B391F66C4F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasCategory(String category) {
        dsTaint.addTaint(category);
        boolean varC2460535E11742A1B298C090C684A3C7_1681651163 = (mCategories != null && mCategories.contains(category));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCategories != null && mCategories.contains(category);
    }

    
    @DSModeled(value = DSC.SAFE)
	public Set<String> getCategories() {
		/*
		 * Since the initial tainting of the category data happens through
		 * the controlled method "addCategory", this (hopefully) will produce
		 * an effective model for a tainted string returned as a part of a Set
		 * object
		 */
		HashSet<String> mCategories = new HashSet<String>();
		mCategories.add(dsTaint.getTaintString());
		return mCategories;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.553 -0400", hash_original_method = "0EFF867FD71A8B842E16179807F3AE79", hash_generated_method = "3F315408D8E01570F371FB15B5B81BDC")
    @DSModeled(DSC.SPEC)
    public Intent getSelector() {
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSelector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.555 -0400", hash_original_method = "C5389CB5192CD8E55615D6E62222251D", hash_generated_method = "4E53B26E491AF9EA178D0C349AE1D184")
    @DSModeled(DSC.BAN)
    public void setExtrasClassLoader(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        {
            mExtras.setClassLoader(loader);
        } //End block
        // ---------- Original Method ----------
        //if (mExtras != null) {
            //mExtras.setClassLoader(loader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.557 -0400", hash_original_method = "820997F7D9BF8A8B37DA5723F540EC8D", hash_generated_method = "3A00ED7CD989C143EBCA31294D372FD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasExtra(String name) {
        dsTaint.addTaint(name);
        boolean var8D5EC6D3C753A94FA222F4E5ACC81591_1371538029 = (mExtras != null && mExtras.containsKey(name));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mExtras != null && mExtras.containsKey(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.558 -0400", hash_original_method = "A4A187292984F1C3EE73C7C78931040C", hash_generated_method = "7F7875223B1A0DE7E0762532C790D2BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasFileDescriptors() {
        boolean var0C8CC71D26B004C46DB7A137664B7280_1320178793 = (mExtras != null && mExtras.hasFileDescriptors());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mExtras != null && mExtras.hasFileDescriptors();
    }

    
    @DSModeled(value = DSC.SAFE)
	public void setAllowFds(boolean allowFds) {
		// NOTE:  mExtras is a Bundle, perhaps it is best to push the taint down to that level
		dsTaint.addTaint(allowFds);
		/*
        if (mExtras != null) {
            mExtras.setAllowFds(allowFds);
        }
        */
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.560 -0400", hash_original_method = "4C23C66584C2E08F8D8923DC65F21B8A", hash_generated_method = "5F7FEDD911AFFE4DF28DFB85C0ED81B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Object getExtra(String name) {
        dsTaint.addTaint(name);
        Object var0CC9BB07BDA119320AB72AB3E2F2B839_2146594714 = (getExtra(name, null));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getExtra(name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.563 -0400", hash_original_method = "6C77EA53DBDF6A732015829C63BCD454", hash_generated_method = "FF0E93B597C899F2BE9FA57A4729E66F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBooleanExtra(String name, boolean defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object var441345A13C50B96F36B1BDDFE386B01D_1529887536 = (mExtras.getBoolean(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getBoolean(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.565 -0400", hash_original_method = "7FB23DDD0BCB246CA49844E5ABE7B23C", hash_generated_method = "018A23277FEF0E325143A51B3BF0A997")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte getByteExtra(String name, byte defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object var5E722E48E6374BC3181BB0395ED7280C_1404000004 = (mExtras.getByte(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getByte(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.566 -0400", hash_original_method = "7EF2CF350AA07FA1327C85A618EDDBDF", hash_generated_method = "61A0CE03FF3BC49E2B25634AFCD63263")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShortExtra(String name, short defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object var1F19702B4265707BAB9F4C74EAFD2129_2101523526 = (mExtras.getShort(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getShort(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.568 -0400", hash_original_method = "49AA93250C5B660485540E34F899D621", hash_generated_method = "31A51513E85E6F1D61A4F6E14D98C8FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getCharExtra(String name, char defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object varF0573B87D0C0746DE636734AFBFD1074_1349182272 = (mExtras.getChar(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getChar(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.569 -0400", hash_original_method = "E0513A91E6CBAE3AB1C6E2298E28F4E9", hash_generated_method = "8BE75364C6BF4B6A857AB5A44A352E78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIntExtra(String name, int defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object var005750265D68679C9436FF96E8585426_47641495 = (mExtras.getInt(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getInt(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.570 -0400", hash_original_method = "C094BEE2071DFD73ABD25F184B7F6CE5", hash_generated_method = "C59514F2F11CB64CC07B7C4BC3EB73FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLongExtra(String name, long defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object varB55020DEBF1224039DDEA4A270305BFE_1874149313 = (mExtras.getLong(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getLong(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.572 -0400", hash_original_method = "468C9940FDAFD3DDCC0968AC84566FDC", hash_generated_method = "3F087714379929E093A624D401FA5DB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloatExtra(String name, float defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object varFEEC99C4EF3B173D2F91E923C717FD9F_209241 = (mExtras.getFloat(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getFloat(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.573 -0400", hash_original_method = "9D513802316CA501D261DB0FDD177D9E", hash_generated_method = "837AC6B2956C10A33F8936D37DEC703A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDoubleExtra(String name, double defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        {
            Object varA815D167050171A219111346DF8F615D_1350984764 = (mExtras.getDouble(name, defaultValue));
        } //End flattened ternary
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getDouble(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.579 -0400", hash_original_method = "8063ECA9F5AA2AEF21F6A345FFE2B7E6", hash_generated_method = "2D49E3D9C8E77F6833482D76F356BC85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getStringExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var1622D96888E465ACF80D3A57986BFDFE_763313533 = (mExtras.getString(name));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getString(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.586 -0400", hash_original_method = "1694F41DCC8D039EBF419B4A0F2C4125", hash_generated_method = "592154FECD90392F24ED05E71DB11D3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getCharSequenceExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var5672E25D88AFE052A79EA0E194E775D5_976091028 = (mExtras.getCharSequence(name));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequence(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.590 -0400", hash_original_method = "1C448816D9B902054FE9E8A698247DA2", hash_generated_method = "8EFFF915213D02AC65D57C375BED088B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T extends Parcelable> T getParcelableExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var84CE23EFB0C83F07AD4EA4A8539308EB_1944923310 = (mExtras.<T>getParcelable(name));
        } //End flattened ternary
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.<T>getParcelable(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.592 -0400", hash_original_method = "28D360BBB773D3DC39CC6E8B3FB095BE", hash_generated_method = "6748DB8BC3BFCAFFF96041EE02986796")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Parcelable[] getParcelableArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object varFBDECE06B1B4BE422B8E6EC2652F817C_1171706255 = (mExtras.getParcelableArray(name));
        } //End flattened ternary
        return (Parcelable[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getParcelableArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.594 -0400", hash_original_method = "BB02D0F500EDCAC2282F912174ECF594", hash_generated_method = "2CD6F2CD595A6C4FAA2D5F7A7B3DCABF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object varBA321941515735152C2CD0B588355AF9_643701538 = (mExtras.<T>getParcelableArrayList(name));
        } //End flattened ternary
        return (ArrayList<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.<T>getParcelableArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.596 -0400", hash_original_method = "9F4D1ACCAA6C6918CB97F661FEDB7260", hash_generated_method = "6C5F0B900C19A91C8C44B192E7922DA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Serializable getSerializableExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var20491745DB4E37C390B78A9E8DB4DC1F_1158385 = (mExtras.getSerializable(name));
        } //End flattened ternary
        return (Serializable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getSerializable(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.598 -0400", hash_original_method = "E5A5C9C6BF01CEEFEAABCB20BBD32323", hash_generated_method = "5699BBA34E2F8BD4563763EBA83FB721")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<Integer> getIntegerArrayListExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var4E9B562AE2B2856C288023B12FFCEF54_62137898 = (mExtras.getIntegerArrayList(name));
        } //End flattened ternary
        return (ArrayList<Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIntegerArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.599 -0400", hash_original_method = "D8E538521D5877A04B9E1243CFFC8BD3", hash_generated_method = "819B6B61A42AC6E7619425309C3987C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<String> getStringArrayListExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var436943B2F8A26196132E8BBF463A0E93_1341528410 = (mExtras.getStringArrayList(name));
        } //End flattened ternary
        return (ArrayList<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getStringArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.600 -0400", hash_original_method = "3C0B0EF6206949D4005752F37A471C32", hash_generated_method = "8386E32BA3BD3043DB878D84E953F1D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var29715E4749394A863D018F3D99834D7E_444709074 = (mExtras.getCharSequenceArrayList(name));
        } //End flattened ternary
        return (ArrayList<CharSequence>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequenceArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.602 -0400", hash_original_method = "FE55BFBE9F4BF617BE3A0BE7101EDA89", hash_generated_method = "43E28CD2F43AC84E450F531051A0FB3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] getBooleanArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var00FB540837D005E34C6B04656181AAF7_270031568 = (mExtras.getBooleanArray(name));
        } //End flattened ternary
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getBooleanArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.603 -0400", hash_original_method = "8982B2CEDDCF3062481CA9400546FBDD", hash_generated_method = "12935BCADDA5CDD11397B0479E38A756")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getByteArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var322B50C01B0B62460932D61E8C8FF801_511912383 = (mExtras.getByteArray(name));
        } //End flattened ternary
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getByteArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.604 -0400", hash_original_method = "CD9B24503F7344F42640A5B885850704", hash_generated_method = "1BFF4C3A2A2C1671E802117A901E04FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short[] getShortArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var04AD7917A8202994626E7AF890795D1F_1927918298 = (mExtras.getShortArray(name));
        } //End flattened ternary
        short[] retVal = new short[1];
        retVal[0] = (short)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getShortArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.612 -0400", hash_original_method = "CC419D577155763512853EA59FC750C3", hash_generated_method = "06F588FD5C7A9B443F0A1636EF10E587")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] getCharArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object varD9F1732DD887AB31EBCB5E5E8A0BEC70_1599231278 = (mExtras.getCharArray(name));
        } //End flattened ternary
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.613 -0400", hash_original_method = "0A82189594F324AE308815E53494E5B0", hash_generated_method = "BFD1485FD46A8E26BC3588A7752FDC32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int[] getIntArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object varDE084C3791D41A1082090562E4AEDD61_285695411 = (mExtras.getIntArray(name));
        } //End flattened ternary
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIntArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.615 -0400", hash_original_method = "2B191C1241796E74336A46C43420CA80", hash_generated_method = "A383FEDC92FE8EC3BCA5CBC541B9C7FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long[] getLongArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var57E54E068A5207CC6FCC89D5EA86074A_1350837922 = (mExtras.getLongArray(name));
        } //End flattened ternary
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getLongArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.617 -0400", hash_original_method = "8DC240B1B74093D697F56B17354B0D80", hash_generated_method = "CB49F9ABDA66347300C55CFCB0ECA12C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float[] getFloatArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var02187F0ED2F1F083AB042B5328108502_497986176 = (mExtras.getFloatArray(name));
        } //End flattened ternary
        float[] retVal = new float[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getFloatArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.619 -0400", hash_original_method = "3975857C05E9D537152AB546E3F37275", hash_generated_method = "1C8437DC22E33D6B0A4DB05287028ED7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double[] getDoubleArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var28E231FBCD466F21C98163F52E08EB15_1187453124 = (mExtras.getDoubleArray(name));
        } //End flattened ternary
        double[] retVal = new double[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getDoubleArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.621 -0400", hash_original_method = "63A5C80C2A9C3E397356915A6EC07B98", hash_generated_method = "61B0D66FE0530193B31C6A7E31BF63F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getStringArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object varF0EE54AF34C58A189447A057DAC31617_1249886420 = (mExtras.getStringArray(name));
        } //End flattened ternary
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getStringArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.622 -0400", hash_original_method = "9443A9A4C1E608DAA4A110E653269318", hash_generated_method = "310CB54112C487E65A02AA7DA5E58C72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence[] getCharSequenceArrayExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var84E624D09DE97FCF75ABD64672F382A8_1014334416 = (mExtras.getCharSequenceArray(name));
        } //End flattened ternary
        CharSequence[] retVal = new CharSequence[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequenceArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.630 -0400", hash_original_method = "913345623B540CBB75EA0BDD1C78C162", hash_generated_method = "93780026B9981376A6E08349D1A223EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle getBundleExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var2604CD42EA36E682E7F86DC90D8B51F9_1675174132 = (mExtras.getBundle(name));
        } //End flattened ternary
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getBundle(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.635 -0400", hash_original_method = "657BCF405F69BF4C38A0897E9F672C84", hash_generated_method = "25F3434749FE452C0D202B9D529BCD66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public IBinder getIBinderExtra(String name) {
        dsTaint.addTaint(name);
        {
            Object var973B5B5DACA29B673F3D52DAC3457957_432445746 = (mExtras.getIBinder(name));
        } //End flattened ternary
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIBinder(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.639 -0400", hash_original_method = "EF34C6BD33619501EBC4FFC15D7C460E", hash_generated_method = "5B3200958BD92E74C771C8D30CF9F23E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Object getExtra(String name, Object defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue.dsTaint);
        Object result;
        result = defaultValue;
        {
            Object result2;
            result2 = mExtras.get(name);
            {
                result = result2;
            } //End block
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object result = defaultValue;
        //if (mExtras != null) {
            //Object result2 = mExtras.get(name);
            //if (result2 != null) {
                //result = result2;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.641 -0400", hash_original_method = "6E509C3CEA63C12F8DB889EF86C70010", hash_generated_method = "3DFB11446AA8DF8295AA6F66A966E989")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle getExtras() {
        {
            Object var6D7B32F8E53E46CFEDD8FAAB2EE5E59E_1635034392 = (new Bundle(mExtras));
        } //End flattened ternary
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (mExtras != null)
                //? new Bundle(mExtras)
                //: null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.650 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "DCA5119FF28B26AD9D6F7E29978E11F1")
    @DSModeled(DSC.SAFE)
    public int getFlags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.652 -0400", hash_original_method = "35A271981CF0FB3B138FC227A1ADE9BA", hash_generated_method = "C4A9EAE9C1FF546F83B92F5CBB4DC296")
    @DSModeled(DSC.SAFE)
    public boolean isExcludingStopped() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags&(FLAG_EXCLUDE_STOPPED_PACKAGES|FLAG_INCLUDE_STOPPED_PACKAGES))
                //== FLAG_EXCLUDE_STOPPED_PACKAGES;
    }

    
    @DSModeled(value = DSC.SAFE)
	public String getPackage() {
		//return mPackage;
        return dsTaint.getTaintString();
    }

    
    @DSModeled(value = DSC.SAFE)
	public ComponentName getComponent() {
		return (ComponentName)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.654 -0400", hash_original_method = "418D2917B5B7B0B035ED428CB7C119CA", hash_generated_method = "28A210BCC26E91CC88A42FE041A370EE")
    @DSModeled(DSC.SAFE)
    public Rect getSourceBounds() {
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSourceBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.657 -0400", hash_original_method = "CDA09128651728DC4DB1AA79DEAE44CB", hash_generated_method = "C7D8870E5C6CBFAB7EB627D66A3AAE69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName resolveActivity(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        ResolveInfo info;
        info = pm.resolveActivity(
            this, PackageManager.MATCH_DEFAULT_ONLY);
        {
            ComponentName var8511460FE6EFFBDEF9D61C0296E4AECD_990528545 = (new ComponentName(
                    info.activityInfo.applicationInfo.packageName,
                    info.activityInfo.name));
        } //End block
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mComponent != null) {
            //return mComponent;
        //}
        //ResolveInfo info = pm.resolveActivity(
            //this, PackageManager.MATCH_DEFAULT_ONLY);
        //if (info != null) {
            //return new ComponentName(
                    //info.activityInfo.applicationInfo.packageName,
                    //info.activityInfo.name);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.660 -0400", hash_original_method = "4C4C454D517012EF1DC091F981BC8CF0", hash_generated_method = "EC5AEEC5FD151E38B7861241E8D11408")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActivityInfo resolveActivityInfo(PackageManager pm, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(pm.dsTaint);
        ActivityInfo ai;
        ai = null;
        {
            try 
            {
                ai = pm.getActivityInfo(mComponent, flags);
            } //End block
            catch (PackageManager.NameNotFoundException e)
            { }
        } //End block
        {
            ResolveInfo info;
            info = pm.resolveActivity(
                this, PackageManager.MATCH_DEFAULT_ONLY | flags);
            {
                ai = info.activityInfo;
            } //End block
        } //End block
        return (ActivityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ActivityInfo ai = null;
        //if (mComponent != null) {
            //try {
                //ai = pm.getActivityInfo(mComponent, flags);
            //} catch (PackageManager.NameNotFoundException e) {
            //}
        //} else {
            //ResolveInfo info = pm.resolveActivity(
                //this, PackageManager.MATCH_DEFAULT_ONLY | flags);
            //if (info != null) {
                //ai = info.activityInfo;
            //}
        //}
        //return ai;
    }

    
    @DSModeled(value = DSC.SAFE)
	public Intent setAction(String action) {
		dsTaint.addTaint(action);
        //mAction = action != null ? action.intern() : null;
        return this;
    }

    
    @DSModeled(value = DSC.SAFE)
	public Intent setData(Uri data) {
        mData = data;
		/*
        mType = null;
        */
        return this;
    }

    
    @DSModeled(value = DSC.SAFE)
	public Intent setType(String type) {
		dsTaint.addTaint(type);
        //mData = null;
        //mType = type;
        return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.662 -0400", hash_original_method = "43AA0CE5E260B0FA5B26C9FC36ABF327", hash_generated_method = "69E1CA0DBFF3F62D626EB512412768DA")
    @DSModeled(DSC.SPEC)
    public Intent setDataAndType(Uri data, String type) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(type);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mData = data;
        //mType = type;
        //return this;
    }

    
    public Intent addCategory(String category) {
		dsTaint.addTaint(category);
		/*
        if (mCategories == null) {
            mCategories = new HashSet<String>();
        }
        mCategories.add(category.intern());
        */
        return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.664 -0400", hash_original_method = "CFCF8DDC5EB4FA9E7ADB1DEB9CFAFA89", hash_generated_method = "B28B854ADEA70BAB940943B4B5312DC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeCategory(String category) {
        dsTaint.addTaint(category);
        {
            mCategories.remove(category);
            {
                boolean varF3E827929A4D5BB767FBFDA33518C46A_2037200078 = (mCategories.size() == 0);
                {
                    mCategories = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mCategories != null) {
            //mCategories.remove(category);
            //if (mCategories.size() == 0) {
                //mCategories = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.665 -0400", hash_original_method = "4143B41199E8262105CB671C15097E99", hash_generated_method = "20C393BCD98FCCEB012CEE6AC582357A")
    @DSModeled(DSC.SPEC)
    public void setSelector(Intent selector) {
        dsTaint.addTaint(selector.dsTaint);
        {
            boolean var3775AC94E687E01878B10DC95B8A223E_496525737 = (selector == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Intent being set as a selector of itself");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Can't set selector when package name is already set");
        } //End block
        // ---------- Original Method ----------
        //if (selector == this) {
            //throw new IllegalArgumentException(
                    //"Intent being set as a selector of itself");
        //}
        //if (selector != null && mPackage != null) {
            //throw new IllegalArgumentException(
                    //"Can't set selector when package name is already set");
        //}
        //mSelector = selector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.667 -0400", hash_original_method = "E358DED697FF080F831811D5D578FEBC", hash_generated_method = "6B1F707BC75D4BCD24B5C62B61DC5BED")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, boolean value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBoolean(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBoolean(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.668 -0400", hash_original_method = "983951350B18B30CD357EFC4A5F8C533", hash_generated_method = "6A033B8B65A3AC26724F3BA8867EFBF1")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, byte value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putByte(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putByte(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.671 -0400", hash_original_method = "44F743D0FCF3A3B09735F92996DFB8B8", hash_generated_method = "6D55E261E1F1F2F2FE1C1F79B50D2315")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, char value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putChar(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putChar(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.672 -0400", hash_original_method = "D504428E6A64263CB337167E8E11D24B", hash_generated_method = "0E300C43B01AC080694D1070B06D748B")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, short value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putShort(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putShort(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.677 -0400", hash_original_method = "0F8D3938F71F1CBC0AF93312AEF5DBAF", hash_generated_method = "11B3718AF1805963765DDCDA139A764A")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, int value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putInt(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putInt(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.679 -0400", hash_original_method = "210CE6920B09DE82954A1910A2E05BDA", hash_generated_method = "20F9D260712C4121DACF0E43C4A7095B")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, long value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putLong(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putLong(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.680 -0400", hash_original_method = "5563D3D5FF8C4FA36F1584B48F1347B6", hash_generated_method = "91B4C11B7CE9CF21B925793C12804ADB")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, float value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putFloat(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putFloat(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.682 -0400", hash_original_method = "FDAB0726590DA4887C7F048C162A9588", hash_generated_method = "08A688A0B85A4573EAAF8D965BD82820")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, double value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putDouble(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putDouble(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.684 -0400", hash_original_method = "FFA94FE476B4FC82FDFAB8191F06F76A", hash_generated_method = "612BFA236E4596BBB10AD287AED036F0")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, String value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putString(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putString(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.688 -0400", hash_original_method = "C3AAC0183A1B956AD55E80A8556AFB71", hash_generated_method = "A08CE990C673CDE7B1273BB7C70711C9")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, CharSequence value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequence(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequence(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.690 -0400", hash_original_method = "49EBB52F87B2F24E715C34795BBE3213", hash_generated_method = "0C253579FFCB94BC6668E197CD98AEED")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, Parcelable value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelable(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelable(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.691 -0400", hash_original_method = "478D5F3649CF3C1019BEE6D895BDE15B", hash_generated_method = "6FAEDDD94A4F933D8D8134EC0AE80F17")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, Parcelable[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0].dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelableArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelableArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.701 -0400", hash_original_method = "7056A89E2AB58239EE1F715B825304C9", hash_generated_method = "7F3D0A00C8DE94C1B46F14F7649FC37D")
    @DSModeled(DSC.SPEC)
    public Intent putParcelableArrayListExtra(String name, ArrayList<? extends Parcelable> value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelableArrayList(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelableArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.703 -0400", hash_original_method = "25611C5EA858F4B01007B3F78DCCE949", hash_generated_method = "614AE4B28C7C31B4723C8F1F03CCDF31")
    @DSModeled(DSC.SPEC)
    public Intent putIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIntegerArrayList(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIntegerArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.705 -0400", hash_original_method = "FCCCC0193355017A3AB410227E2B8C63", hash_generated_method = "BF908D77BFF6886C310853CAC5A27EA2")
    @DSModeled(DSC.SPEC)
    public Intent putStringArrayListExtra(String name, ArrayList<String> value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putStringArrayList(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putStringArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.706 -0400", hash_original_method = "56169BFB83B473D5686B58CC3B07DAC6", hash_generated_method = "99B7D23668AF94FE8082ED1023CBC7CB")
    @DSModeled(DSC.SPEC)
    public Intent putCharSequenceArrayListExtra(String name, ArrayList<CharSequence> value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequenceArrayList(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequenceArrayList(name, value);
        //return this;
    }

    
    @DSModeled(value = DSC.SAFE)
	public Intent putExtra(String name, Serializable value) {
        mExtras = new Bundle();
        mExtras.putSerializable(name, value);
        return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.708 -0400", hash_original_method = "6C30326EEBD8635124BFC9218A6B6422", hash_generated_method = "FC6299478030E715D8F7574D708C54FB")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, boolean[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0]);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBooleanArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBooleanArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.709 -0400", hash_original_method = "4D4788E50F7779B1D72BD45B4E76C775", hash_generated_method = "81E53CE7D2925A8DC853BF2E11CD3068")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, byte[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0]);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putByteArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putByteArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.711 -0400", hash_original_method = "521E65BC95668B6A66CE17103975D2B1", hash_generated_method = "948EF5E0D97A59BA391011BFBA492460")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, short[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0]);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putShortArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putShortArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.712 -0400", hash_original_method = "CEC6E945D8554F36BF71D2D38B61B7EF", hash_generated_method = "37C1AD3B132AB83B9404D2B9C531F3B8")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, char[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0]);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.714 -0400", hash_original_method = "AD8C8F2DD7A3862E32E54CE0FBFF67CE", hash_generated_method = "9D43B8687CA08D5F5836B084B5B25EDB")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, int[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0]);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIntArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIntArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.715 -0400", hash_original_method = "EEA209751D515DE89BAC56042276C483", hash_generated_method = "2962FA35454838736917D1FB849BA2FE")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, long[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0]);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putLongArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putLongArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.720 -0400", hash_original_method = "F6CA728A57FEA4C77AF7294872C7D495", hash_generated_method = "865CA52B6CECED46FC1BB9F7C8D8C034")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, float[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0]);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putFloatArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putFloatArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.723 -0400", hash_original_method = "3F155E9B232579FD3DCD2D3FAECEA79F", hash_generated_method = "4D01722654FDF3FBC807C5746958CAB7")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, double[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0]);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putDoubleArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putDoubleArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.731 -0400", hash_original_method = "4105C6229BFDC8C2B450D57FAD8A78CA", hash_generated_method = "DC31C9F892E756119961914EBB3A63B3")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, String[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0]);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putStringArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putStringArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.733 -0400", hash_original_method = "5B5979B9E2BB6EA8D0974FC96788F02A", hash_generated_method = "1D8BEE95E3D916F3675177D371708936")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, CharSequence[] value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value[0]);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequenceArray(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequenceArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.734 -0400", hash_original_method = "79076492A33BAA4B69A022CE305E32E8", hash_generated_method = "D356FD0D067E1E53BAE775976E31B32E")
    @DSModeled(DSC.SPEC)
    public Intent putExtra(String name, Bundle value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBundle(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBundle(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.738 -0400", hash_original_method = "1AE089536D0C6059F1731DCA673BC867", hash_generated_method = "4513098BBB7F3C7BBD71551CF8F1742B")
    @DSModeled(DSC.SPEC)
    @Deprecated
    public Intent putExtra(String name, IBinder value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIBinder(name, value);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIBinder(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.742 -0400", hash_original_method = "49B5D5019DC4C58D3432134ADBF206CE", hash_generated_method = "DE00D7421D216460B803978322998546")
    @DSModeled(DSC.SPEC)
    public Intent putExtras(Intent src) {
        dsTaint.addTaint(src.dsTaint);
        {
            {
                mExtras = new Bundle(src.mExtras);
            } //End block
            {
                mExtras.putAll(src.mExtras);
            } //End block
        } //End block
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (src.mExtras != null) {
            //if (mExtras == null) {
                //mExtras = new Bundle(src.mExtras);
            //} else {
                //mExtras.putAll(src.mExtras);
            //}
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.745 -0400", hash_original_method = "300503D60C48D249178D35D7CDB92339", hash_generated_method = "C64DA9FA980E92234FA394521133516C")
    @DSModeled(DSC.SPEC)
    public Intent putExtras(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putAll(extras);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putAll(extras);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.747 -0400", hash_original_method = "9273ED8AEDE591E5D2100B41909C8A11", hash_generated_method = "C8D6F00AD1E4547244AD8221BFF68A9A")
    @DSModeled(DSC.SPEC)
    public Intent replaceExtras(Intent src) {
        dsTaint.addTaint(src.dsTaint);
        mExtras = src.mExtras != null ? new Bundle(src.mExtras) : null;
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mExtras = src.mExtras != null ? new Bundle(src.mExtras) : null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.748 -0400", hash_original_method = "CBF42E478CC456FFD10D6777F319F0BD", hash_generated_method = "412F6B7A4B76976DC8168983F3ECCB8B")
    @DSModeled(DSC.SPEC)
    public Intent replaceExtras(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        mExtras = extras != null ? new Bundle(extras) : null;
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mExtras = extras != null ? new Bundle(extras) : null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.751 -0400", hash_original_method = "84A47E40481CBF5586A9CCDD8AD7D655", hash_generated_method = "1290AA6AE9F62C0E81DEF08031DA1BE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeExtra(String name) {
        dsTaint.addTaint(name);
        {
            mExtras.remove(name);
            {
                boolean var7E8DAB3F8FE8420FBC71F6F461E1A32B_2021691775 = (mExtras.size() == 0);
                {
                    mExtras = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mExtras != null) {
            //mExtras.remove(name);
            //if (mExtras.size() == 0) {
                //mExtras = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.753 -0400", hash_original_method = "240F6D2BBC198957F28DF199FF71FA51", hash_generated_method = "026725BC1A27B8E7EB1FB2DA8AD6737F")
    @DSModeled(DSC.SPEC)
    public Intent setFlags(int flags) {
        dsTaint.addTaint(flags);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = flags;
        //return this;
    }

    
    @DSModeled(value = DSC.SAFE)
	public Intent addFlags(int flags) {
        dsTaint.addTaint(flags);
        return this;
    }

    
    @DSModeled(value = DSC.SAFE)
	public Intent setPackage(String packageName) {
		dsTaint.addTaint(packageName);
		/*
        if (packageName != null && mSelector != null) {
            throw new IllegalArgumentException(
                    "Can't set package name when selector is already set");
        }
        mPackage = packageName;
        */
        return this;
    }

    
    @DSModeled(value = DSC.SAFE)
	public Intent setComponent(ComponentName component) {
        mComponent = component;
        return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.762 -0400", hash_original_method = "A7E573A4994CE22857A73F3E6FF16052", hash_generated_method = "BB6F7E7BF9A3F452479EB63B3EFB75A8")
    @DSModeled(DSC.SPEC)
    public Intent setClassName(Context packageContext, String className) {
        dsTaint.addTaint(packageContext.dsTaint);
        dsTaint.addTaint(className);
        mComponent = new ComponentName(packageContext, className);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, className);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.764 -0400", hash_original_method = "0DAD204BCD083F4BEBCC949C19CA4443", hash_generated_method = "2D6BE3003090180FE72C19793686AD95")
    @DSModeled(DSC.SPEC)
    public Intent setClassName(String packageName, String className) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(className);
        mComponent = new ComponentName(packageName, className);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageName, className);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.765 -0400", hash_original_method = "07D0BC1863460C70C46D0D4DB8E842CD", hash_generated_method = "2FF4471E461AE6306CA38C8A33CE8197")
    @DSModeled(DSC.SPEC)
    public Intent setClass(Context packageContext, Class<?> cls) {
        dsTaint.addTaint(packageContext.dsTaint);
        dsTaint.addTaint(cls.dsTaint);
        mComponent = new ComponentName(packageContext, cls);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, cls);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.767 -0400", hash_original_method = "2A55D148D28C14A8FD18A3C56EB5208F", hash_generated_method = "6895986377550697731F3A80744166DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSourceBounds(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        {
            mSourceBounds = new Rect(r);
        } //End block
        {
            mSourceBounds = null;
        } //End block
        // ---------- Original Method ----------
        //if (r != null) {
            //mSourceBounds = new Rect(r);
        //} else {
            //mSourceBounds = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.786 -0400", hash_original_method = "E5580C6082A47C0EDDA03A45ABBBF7D7", hash_generated_method = "05B25ADB7992E911251DD7ABF223D919")
    @DSModeled(DSC.SPEC)
    public int fillIn(Intent other, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(other.dsTaint);
        int changes;
        changes = 0;
        {
            mAction = other.mAction;
            changes |= FILL_IN_ACTION;
        } //End block
        {
            mData = other.mData;
            mType = other.mType;
            changes |= FILL_IN_DATA;
        } //End block
        {
            {
                mCategories = new HashSet<String>(other.mCategories);
            } //End block
            changes |= FILL_IN_CATEGORIES;
        } //End block
        {
            {
                mPackage = other.mPackage;
                changes |= FILL_IN_PACKAGE;
            } //End block
        } //End block
        {
            {
                mSelector = new Intent(other.mSelector);
                mPackage = null;
                changes |= FILL_IN_SELECTOR;
            } //End block
        } //End block
        {
            mComponent = other.mComponent;
            changes |= FILL_IN_COMPONENT;
        } //End block
        mFlags |= other.mFlags;
        {
            mSourceBounds = new Rect(other.mSourceBounds);
            changes |= FILL_IN_SOURCE_BOUNDS;
        } //End block
        {
            {
                mExtras = new Bundle(other.mExtras);
            } //End block
        } //End block
        {
            try 
            {
                Bundle newb;
                newb = new Bundle(other.mExtras);
                newb.putAll(mExtras);
                mExtras = newb;
            } //End block
            catch (RuntimeException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.798 -0400", hash_original_method = "B6E4053A3570119C1E3D361525D403A8", hash_generated_method = "64DB437E2B55563EBFFE7E1C094A8FB4")
    @DSModeled(DSC.SPEC)
    public boolean filterEquals(Intent other) {
        dsTaint.addTaint(other.dsTaint);
        {
            {
                {
                    boolean var34A6740CF00C4CE99E014DB52800A86C_86727207 = (!mAction.equals(other.mAction));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varAEFDA509D1872F11467FB8BDF0BEF91F_1355893091 = (!other.mAction.equals(mAction));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var1B3E4D86DDEB4D4A831A6326700A0F0B_1907234943 = (!mData.equals(other.mData));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varB9280F5A87CB7471F1F68ACAD9FF512A_1460994236 = (!other.mData.equals(mData));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var6E90D3CB216BAFFC33A8A7351B637345_476240590 = (!mType.equals(other.mType));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var49F589FDF6BAFD9349A39C37D467C96C_1916891594 = (!other.mType.equals(mType));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var0FF5A23B099AB3A4E4889633C3DF81A9_1205907628 = (!mPackage.equals(other.mPackage));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var7A82FF7EACC0A9829485BCB718ACD023_1790488765 = (!other.mPackage.equals(mPackage));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var8978EFF033EC0F607CC0AB6AE0299151_204515578 = (!mComponent.equals(other.mComponent));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var384CAB8913950049F62446B39911719F_424218971 = (!other.mComponent.equals(mComponent));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean varAE538A113FE5A591A0CC1368E43F8DD6_1689533391 = (!mCategories.equals(other.mCategories));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varE14E437DACF017225A5A506C3E8F03FE_1855981624 = (!other.mCategories.equals(mCategories));
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.802 -0400", hash_original_method = "8096117DA4698C90A65D3667512D1D4C", hash_generated_method = "6F56B4F21FF3E7D6367F6A06F6FFC3F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int filterHashCode() {
        int code;
        code = 0;
        {
            code += mAction.hashCode();
        } //End block
        {
            code += mData.hashCode();
        } //End block
        {
            code += mType.hashCode();
        } //End block
        {
            code += mPackage.hashCode();
        } //End block
        {
            code += mComponent.hashCode();
        } //End block
        {
            code += mCategories.hashCode();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int code = 0;
        //if (mAction != null) {
            //code += mAction.hashCode();
        //}
        //if (mData != null) {
            //code += mData.hashCode();
        //}
        //if (mType != null) {
            //code += mType.hashCode();
        //}
        //if (mPackage != null) {
            //code += mPackage.hashCode();
        //}
        //if (mComponent != null) {
            //code += mComponent.hashCode();
        //}
        //if (mCategories != null) {
            //code += mCategories.hashCode();
        //}
        //return code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.824 -0400", hash_original_method = "A07DFF04DF4B6FC888385D304C4BCF4A", hash_generated_method = "1579326C41E997EB11B40F85109D6973")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder b;
        b = new StringBuilder(128);
        b.append("Intent { ");
        toShortString(b, true, true, true);
        b.append(" }");
        String varAFA387FFE5FA21CB2784F303FB8FD58D_1752757579 = (b.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //b.append("Intent { ");
        //toShortString(b, true, true, true);
        //b.append(" }");
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.826 -0400", hash_original_method = "561478671997B5BD9B57800B6A20BE68", hash_generated_method = "D57F566BFC6ABBAEF7AEB453D03D5338")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toInsecureString() {
        StringBuilder b;
        b = new StringBuilder(128);
        b.append("Intent { ");
        toShortString(b, false, true, true);
        b.append(" }");
        String varAFA387FFE5FA21CB2784F303FB8FD58D_2051766295 = (b.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //b.append("Intent { ");
        //toShortString(b, false, true, true);
        //b.append(" }");
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.827 -0400", hash_original_method = "78E0A44749B0E137B37BE3EA0840E73D", hash_generated_method = "CFE46AAED551B37CD478700F79200B09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString(boolean secure, boolean comp, boolean extras) {
        dsTaint.addTaint(comp);
        dsTaint.addTaint(secure);
        dsTaint.addTaint(extras);
        StringBuilder b;
        b = new StringBuilder(128);
        toShortString(b, secure, comp, extras);
        String varAFA387FFE5FA21CB2784F303FB8FD58D_263404854 = (b.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //toShortString(b, secure, comp, extras);
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.835 -0400", hash_original_method = "084143D5D45481DE69737429FAF260F9", hash_generated_method = "23B4A595DEE071224DA8BB20CFB30B70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void toShortString(StringBuilder b, boolean secure, boolean comp, boolean extras) {
        dsTaint.addTaint(comp);
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(secure);
        dsTaint.addTaint(extras);
        boolean first;
        first = true;
        {
            b.append("act=").append(mAction);
            first = false;
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("cat=[");
            Iterator<String> i;
            i = mCategories.iterator();
            boolean didone;
            didone = false;
            {
                boolean varD8B5E52A597500CBD863E52A46B42708_1357723680 = (i.hasNext());
                {
                    b.append(",");
                    didone = true;
                    b.append(i.next());
                } //End block
            } //End collapsed parenthetic
            b.append("]");
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("dat=");
            {
                b.append(mData.toSafeString());
            } //End block
            {
                b.append(mData);
            } //End block
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("typ=").append(mType);
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("flg=0x").append(Integer.toHexString(mFlags));
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("pkg=").append(mPackage);
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("cmp=").append(mComponent.flattenToShortString());
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("bnds=").append(mSourceBounds.toShortString());
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("(has extras)");
        } //End block
        {
            b.append(" sel={");
            mSelector.toShortString(b, secure, comp, extras);
            b.append("}");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.856 -0400", hash_original_method = "A1DA43CBB31EA268C3AC25819B92FFB9", hash_generated_method = "2AB13DE98F0D6CC16A693ED1CAF301F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String toURI() {
        String var45B38A796CB009C694F24FDA957E527A_555754386 = (toUri(0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toUri(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:46.859 -0400", hash_original_method = "E005DA59F987D9130CC4868A94C4C496", hash_generated_method = "E154ECA293E56A9BFEF281544B2B1ADA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toUri(int flags) {
        dsTaint.addTaint(flags);
        StringBuilder uri;
        uri = new StringBuilder(128);
        String scheme;
        scheme = null;
        {
            String data;
            data = mData.toString();
            {
                int N;
                N = data.length();
                {
                    int i;
                    i = 0;
                    {
                        char c;
                        c = data.charAt(i);
                        {
                            scheme = data.substring(0, i);
                            uri.append("intent:");
                            data = data.substring(i+1);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            uri.append(data);
        } //End block
        {
            uri.append("intent:");
        } //End block
        uri.append("#Intent;");
        toUriInner(uri, scheme, flags);
        {
            uri.append("SEL;");
            mSelector.toUriInner(uri, null, flags);
        } //End block
        uri.append("end");
        String var9492102A459355C54E108EA1266B741C_1999116865 = (uri.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.287 -0400", hash_original_method = "C6B01852F6499829AE05E1CED618D6B2", hash_generated_method = "5118900CC4D1A441F51E48D72A10937C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void toUriInner(StringBuilder uri, String scheme, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(uri.dsTaint);
        {
            uri.append("scheme=").append(scheme).append(';');
        } //End block
        {
            uri.append("action=").append(Uri.encode(mAction)).append(';');
        } //End block
        {
            {
                Iterator<String> varC5C97730832E94B972365D2927406D4C_100695400 = (mCategories).iterator();
                varC5C97730832E94B972365D2927406D4C_100695400.hasNext();
                String category = varC5C97730832E94B972365D2927406D4C_100695400.next();
                {
                    uri.append("category=").append(Uri.encode(category)).append(';');
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            uri.append("type=").append(Uri.encode(mType, "/")).append(';');
        } //End block
        {
            uri.append("launchFlags=0x").append(Integer.toHexString(mFlags)).append(';');
        } //End block
        {
            uri.append("package=").append(Uri.encode(mPackage)).append(';');
        } //End block
        {
            uri.append("component=").append(Uri.encode(
                    mComponent.flattenToShortString(), "/")).append(';');
        } //End block
        {
            uri.append("sourceBounds=")
                    .append(Uri.encode(mSourceBounds.flattenToString()))
                    .append(';');
        } //End block
        {
            {
                Iterator<String> varC3DCE956407274DC1E5507689933E9CE_1248134253 = (mExtras.keySet()).iterator();
                varC3DCE956407274DC1E5507689933E9CE_1248134253.hasNext();
                String key = varC3DCE956407274DC1E5507689933E9CE_1248134253.next();
                {
                    Object value;
                    value = mExtras.get(key);
                    char entryType;
                    entryType = 's';
                    entryType = '\0';
                    {
                        uri.append(entryType);
                        uri.append('.');
                        uri.append(Uri.encode(key));
                        uri.append('=');
                        uri.append(Uri.encode(value.toString()));
                        uri.append(';');
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.374 -0400", hash_original_method = "D9DA92F04D8A96D9F8D7CC23CBDB1396", hash_generated_method = "86F24777040D505D5350AC5AE5CFA990")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeString(mAction);
        Uri.writeToParcel(out, mData);
        out.writeString(mType);
        out.writeInt(mFlags);
        out.writeString(mPackage);
        ComponentName.writeToParcel(mComponent, out);
        {
            out.writeInt(1);
            mSourceBounds.writeToParcel(out, flags);
        } //End block
        {
            out.writeInt(0);
        } //End block
        {
            out.writeInt(mCategories.size());
            {
                Iterator<String> varC5C97730832E94B972365D2927406D4C_1799890006 = (mCategories).iterator();
                varC5C97730832E94B972365D2927406D4C_1799890006.hasNext();
                String category = varC5C97730832E94B972365D2927406D4C_1799890006.next();
                {
                    out.writeString(category);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            out.writeInt(0);
        } //End block
        {
            out.writeInt(1);
            mSelector.writeToParcel(out, flags);
        } //End block
        {
            out.writeInt(0);
        } //End block
        out.writeBundle(mExtras);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.378 -0400", hash_original_method = "275963C0D40D3AED4795057AE368B460", hash_generated_method = "B269F7176A94F12714C016753F586965")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        setAction(in.readString());
        mData = Uri.CREATOR.createFromParcel(in);
        mType = in.readString();
        mFlags = in.readInt();
        mPackage = in.readString();
        mComponent = ComponentName.readFromParcel(in);
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_928736091 = (in.readInt() != 0);
            {
                mSourceBounds = Rect.CREATOR.createFromParcel(in);
            } //End block
        } //End collapsed parenthetic
        int N;
        N = in.readInt();
        {
            mCategories = new HashSet<String>();
            int i;
            {
                i=0;
                {
                    mCategories.add(in.readString().intern());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mCategories = null;
        } //End block
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_403420697 = (in.readInt() != 0);
            {
                mSelector = new Intent(in);
            } //End block
        } //End collapsed parenthetic
        mExtras = in.readBundle();
        // ---------- Original Method ----------
        //setAction(in.readString());
        //mData = Uri.CREATOR.createFromParcel(in);
        //mType = in.readString();
        //mFlags = in.readInt();
        //mPackage = in.readString();
        //mComponent = ComponentName.readFromParcel(in);
        //if (in.readInt() != 0) {
            //mSourceBounds = Rect.CREATOR.createFromParcel(in);
        //}
        //int N = in.readInt();
        //if (N > 0) {
            //mCategories = new HashSet<String>();
            //int i;
            //for (i=0; i<N; i++) {
                //mCategories.add(in.readString().intern());
            //}
        //} else {
            //mCategories = null;
        //}
        //if (in.readInt() != 0) {
            //mSelector = new Intent(in);
        //}
        //mExtras = in.readBundle();
    }

    
    public static Intent parseIntent(Resources resources, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        Intent intent = new Intent();
        TypedArray sa = resources.obtainAttributes(attrs,
                com.android.internal.R.styleable.Intent);
        intent.setAction(sa.getString(com.android.internal.R.styleable.Intent_action));
        String data = sa.getString(com.android.internal.R.styleable.Intent_data);
        String mimeType = sa.getString(com.android.internal.R.styleable.Intent_mimeType);
        intent.setDataAndType(data != null ? Uri.parse(data) : null, mimeType);
        String packageName = sa.getString(com.android.internal.R.styleable.Intent_targetPackage);
        String className = sa.getString(com.android.internal.R.styleable.Intent_targetClass);
        if (packageName != null && className != null) {
            intent.setComponent(new ComponentName(packageName, className));
        }
        sa.recycle();
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }
            String nodeName = parser.getName();
            if (nodeName.equals("category")) {
                sa = resources.obtainAttributes(attrs,
                        com.android.internal.R.styleable.IntentCategory);
                String cat = sa.getString(com.android.internal.R.styleable.IntentCategory_name);
                sa.recycle();
                if (cat != null) {
                    intent.addCategory(cat);
                }
                XmlUtils.skipCurrentTag(parser);
            } else if (nodeName.equals("extra")) {
                if (intent.mExtras == null) {
                    intent.mExtras = new Bundle();
                }
                resources.parseBundleExtra("extra", attrs, intent.mExtras);
                XmlUtils.skipCurrentTag(parser);
            } else {
                XmlUtils.skipCurrentTag(parser);
            }
        }
        return intent;
    }

    
    public static class ShortcutIconResource implements Parcelable {
        public String packageName;
        public String resourceName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.380 -0400", hash_original_method = "A47D26CCBE00365A9383864662904659", hash_generated_method = "A47D26CCBE00365A9383864662904659")
                public ShortcutIconResource ()
        {
        }


        public static ShortcutIconResource fromContext(Context context, int resourceId) {
            ShortcutIconResource icon = new ShortcutIconResource();
            icon.packageName = context.getPackageName();
            icon.resourceName = context.getResources().getResourceName(resourceId);
            return icon;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.380 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.381 -0400", hash_original_method = "A078CBD5399741F593957325C4A01342", hash_generated_method = "F21A5522FEC44EC7468CF22292FAD50B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeString(packageName);
            dest.writeString(resourceName);
            // ---------- Original Method ----------
            //dest.writeString(packageName);
            //dest.writeString(resourceName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.382 -0400", hash_original_method = "8D66F7367028E1EB1EA87D8477E02D6C", hash_generated_method = "DA7F6DD5F0691FA2CD323CD31802F49E")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return resourceName;
        }

        
        public static final Parcelable.Creator<ShortcutIconResource> CREATOR = new Parcelable.Creator<ShortcutIconResource>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.386 -0400", hash_original_method = "E5EFB41AF12EFD491D45E99DE4F055C4", hash_generated_method = "6A5E402DCAE8712467EC0D8F258BDBF2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public ShortcutIconResource createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                ShortcutIconResource icon;
                icon = new ShortcutIconResource();
                icon.packageName = source.readString();
                icon.resourceName = source.readString();
                return (ShortcutIconResource)dsTaint.getTaint();
                // ---------- Original Method ----------
                //ShortcutIconResource icon = new ShortcutIconResource();
                //icon.packageName = source.readString();
                //icon.resourceName = source.readString();
                //return icon;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.390 -0400", hash_original_method = "3C31821CAA714EDAC90B580A2669C2C0", hash_generated_method = "7CA587F20CEF8FA4428F24E42589D967")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public ShortcutIconResource[] newArray(int size) {
                dsTaint.addTaint(size);
                ShortcutIconResource[] varA7885FF5CB1639CC5B4F70D7A9C8B89A_1939075557 = (new ShortcutIconResource[size]);
                return (ShortcutIconResource[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new ShortcutIconResource[size];
            }

            
}; //Transformed anonymous class
    }


    
    public static final class FilterComparison {
        private Intent mIntent;
        private int mHashCode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.393 -0400", hash_original_method = "2099CA9774C8964FCB84A0C5BA5EC3C6", hash_generated_method = "4B60BD33DD46FBEDD03012612A33204D")
        @DSModeled(DSC.SPEC)
        public FilterComparison(Intent intent) {
            dsTaint.addTaint(intent.dsTaint);
            mHashCode = intent.filterHashCode();
            // ---------- Original Method ----------
            //mIntent = intent;
            //mHashCode = intent.filterHashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.394 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "22770DE3BF38836C28544CA3834587CE")
        @DSModeled(DSC.SPEC)
        public Intent getIntent() {
            return (Intent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mIntent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.396 -0400", hash_original_method = "57E0DE3F426C34FAD2C087D7985C733F", hash_generated_method = "927BD03646D98502F693C1D473493895")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            {
                Intent other;
                other = ((FilterComparison)obj).mIntent;
                boolean varE65638074C2BB312154E364F2332F00A_643686768 = (mIntent.filterEquals(other));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (obj instanceof FilterComparison) {
                //Intent other = ((FilterComparison)obj).mIntent;
                //return mIntent.filterEquals(other);
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.397 -0400", hash_original_method = "D7D5E8B622FC6A9CB6E203DCD79B8799", hash_generated_method = "299AB68DDC3147F06079A7D1A7DCDD71")
        @DSModeled(DSC.SAFE)
        @Override
        public int hashCode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mHashCode;
        }

        
    }


    
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_MAIN = "android.intent.action.MAIN";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_VIEW = "android.intent.action.VIEW";
    public static final String ACTION_DEFAULT = ACTION_VIEW;
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_ATTACH_DATA = "android.intent.action.ATTACH_DATA";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_EDIT = "android.intent.action.EDIT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_INSERT_OR_EDIT = "android.intent.action.INSERT_OR_EDIT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_PICK = "android.intent.action.PICK";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_CREATE_SHORTCUT = "android.intent.action.CREATE_SHORTCUT";
    public static final String EXTRA_SHORTCUT_INTENT = "android.intent.extra.shortcut.INTENT";
    public static final String EXTRA_SHORTCUT_NAME = "android.intent.extra.shortcut.NAME";
    public static final String EXTRA_SHORTCUT_ICON = "android.intent.extra.shortcut.ICON";
    public static final String EXTRA_SHORTCUT_ICON_RESOURCE =
            "android.intent.extra.shortcut.ICON_RESOURCE";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_CHOOSER = "android.intent.action.CHOOSER";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_GET_CONTENT = "android.intent.action.GET_CONTENT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_DIAL = "android.intent.action.DIAL";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_CALL = "android.intent.action.CALL";
    public static final String ACTION_CALL_EMERGENCY = "android.intent.action.CALL_EMERGENCY";
    public static final String ACTION_CALL_PRIVILEGED = "android.intent.action.CALL_PRIVILEGED";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SENDTO = "android.intent.action.SENDTO";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SEND = "android.intent.action.SEND";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SEND_MULTIPLE = "android.intent.action.SEND_MULTIPLE";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_ANSWER = "android.intent.action.ANSWER";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_INSERT = "android.intent.action.INSERT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_PASTE = "android.intent.action.PASTE";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_DELETE = "android.intent.action.DELETE";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_RUN = "android.intent.action.RUN";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SYNC = "android.intent.action.SYNC";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_PICK_ACTIVITY = "android.intent.action.PICK_ACTIVITY";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SEARCH = "android.intent.action.SEARCH";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SYSTEM_TUTORIAL = "android.intent.action.SYSTEM_TUTORIAL";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_WEB_SEARCH = "android.intent.action.WEB_SEARCH";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_ALL_APPS = "android.intent.action.ALL_APPS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SET_WALLPAPER = "android.intent.action.SET_WALLPAPER";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_BUG_REPORT = "android.intent.action.BUG_REPORT";
    public static final String ACTION_FACTORY_TEST = "android.intent.action.FACTORY_TEST";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_CALL_BUTTON = "android.intent.action.CALL_BUTTON";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_VOICE_COMMAND = "android.intent.action.VOICE_COMMAND";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SEARCH_LONG_PRESS = "android.intent.action.SEARCH_LONG_PRESS";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_APP_ERROR = "android.intent.action.APP_ERROR";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_POWER_USAGE_SUMMARY = "android.intent.action.POWER_USAGE_SUMMARY";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_UPGRADE_SETUP = "android.intent.action.UPGRADE_SETUP";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_MANAGE_NETWORK_USAGE =
            "android.intent.action.MANAGE_NETWORK_USAGE";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_INSTALL_PACKAGE = "android.intent.action.INSTALL_PACKAGE";
    public static final String EXTRA_INSTALLER_PACKAGE_NAME
            = "android.intent.extra.INSTALLER_PACKAGE_NAME";
    public static final String EXTRA_NOT_UNKNOWN_SOURCE
            = "android.intent.extra.NOT_UNKNOWN_SOURCE";
    public static final String EXTRA_ALLOW_REPLACE
            = "android.intent.extra.ALLOW_REPLACE";
    public static final String EXTRA_RETURN_RESULT
            = "android.intent.extra.RETURN_RESULT";
    public static final String EXTRA_INSTALL_RESULT
            = "android.intent.extra.INSTALL_RESULT";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_UNINSTALL_PACKAGE = "android.intent.action.UNINSTALL_PACKAGE";
    public static final String METADATA_SETUP_VERSION = "android.SETUP_VERSION";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_USER_PRESENT = "android.intent.action.USER_PRESENT";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_TIME_TICK = "android.intent.action.TIME_TICK";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_TIME_CHANGED = "android.intent.action.TIME_SET";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_DATE_CHANGED = "android.intent.action.DATE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_TIMEZONE_CHANGED = "android.intent.action.TIMEZONE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_CLEAR_DNS_CACHE = "android.intent.action.CLEAR_DNS_CACHE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_ALARM_CHANGED = "android.intent.action.ALARM_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_SYNC_STATE_CHANGED
            = "android.intent.action.SYNC_STATE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
    @Deprecated @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PACKAGE_INSTALL = "android.intent.action.PACKAGE_INSTALL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PACKAGE_REPLACED = "android.intent.action.PACKAGE_REPLACED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MY_PACKAGE_REPLACED = "android.intent.action.MY_PACKAGE_REPLACED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PACKAGE_FULLY_REMOVED
            = "android.intent.action.PACKAGE_FULLY_REMOVED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PACKAGE_CHANGED = "android.intent.action.PACKAGE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_QUERY_PACKAGE_RESTART = "android.intent.action.QUERY_PACKAGE_RESTART";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PACKAGE_RESTARTED = "android.intent.action.PACKAGE_RESTARTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PACKAGE_DATA_CLEARED = "android.intent.action.PACKAGE_DATA_CLEARED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_UID_REMOVED = "android.intent.action.UID_REMOVED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PACKAGE_FIRST_LAUNCH = "android.intent.action.PACKAGE_FIRST_LAUNCH";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PACKAGE_NEEDS_VERIFICATION = "android.intent.action.PACKAGE_NEEDS_VERIFICATION";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_WALLPAPER_CHANGED = "android.intent.action.WALLPAPER_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_CONFIGURATION_CHANGED = "android.intent.action.CONFIGURATION_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_LOCALE_CHANGED = "android.intent.action.LOCALE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_BATTERY_CHANGED = "android.intent.action.BATTERY_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_BATTERY_LOW = "android.intent.action.BATTERY_LOW";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_BATTERY_OKAY = "android.intent.action.BATTERY_OKAY";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_POWER_DISCONNECTED =
            "android.intent.action.ACTION_POWER_DISCONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";
    public static final String ACTION_REQUEST_SHUTDOWN = "android.intent.action.ACTION_REQUEST_SHUTDOWN";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_DEVICE_STORAGE_LOW = "android.intent.action.DEVICE_STORAGE_LOW";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_DEVICE_STORAGE_OK = "android.intent.action.DEVICE_STORAGE_OK";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_DEVICE_STORAGE_FULL = "android.intent.action.DEVICE_STORAGE_FULL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_DEVICE_STORAGE_NOT_FULL = "android.intent.action.DEVICE_STORAGE_NOT_FULL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MANAGE_PACKAGE_STORAGE = "android.intent.action.MANAGE_PACKAGE_STORAGE";
    @Deprecated public static final String ACTION_UMS_CONNECTED = "android.intent.action.UMS_CONNECTED";
    @Deprecated public static final String ACTION_UMS_DISCONNECTED = "android.intent.action.UMS_DISCONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_REMOVED = "android.intent.action.MEDIA_REMOVED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_UNMOUNTED = "android.intent.action.MEDIA_UNMOUNTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_CHECKING = "android.intent.action.MEDIA_CHECKING";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_NOFS = "android.intent.action.MEDIA_NOFS";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_MOUNTED = "android.intent.action.MEDIA_MOUNTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_SHARED = "android.intent.action.MEDIA_SHARED";
    public static final String ACTION_MEDIA_UNSHARED = "android.intent.action.MEDIA_UNSHARED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_BAD_REMOVAL = "android.intent.action.MEDIA_BAD_REMOVAL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_UNMOUNTABLE = "android.intent.action.MEDIA_UNMOUNTABLE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_EJECT = "android.intent.action.MEDIA_EJECT";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_SCANNER_STARTED = "android.intent.action.MEDIA_SCANNER_STARTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_SCANNER_FINISHED = "android.intent.action.MEDIA_SCANNER_FINISHED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_SCANNER_SCAN_FILE = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_MEDIA_BUTTON = "android.intent.action.MEDIA_BUTTON";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_CAMERA_BUTTON = "android.intent.action.CAMERA_BUTTON";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_GTALK_SERVICE_CONNECTED =
            "android.intent.action.GTALK_CONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_GTALK_SERVICE_DISCONNECTED =
            "android.intent.action.GTALK_DISCONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_INPUT_METHOD_CHANGED =
            "android.intent.action.INPUT_METHOD_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_AIRPLANE_MODE_CHANGED = "android.intent.action.AIRPLANE_MODE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_PROVIDER_CHANGED =
            "android.intent.action.PROVIDER_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_HEADSET_PLUG =
            "android.intent.action.HEADSET_PLUG";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_USB_ANLG_HEADSET_PLUG =
            "android.intent.action.USB_ANLG_HEADSET_PLUG";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_USB_DGTL_HEADSET_PLUG =
            "android.intent.action.USB_DGTL_HEADSET_PLUG";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_HDMI_AUDIO_PLUG =
            "android.intent.action.HDMI_AUDIO_PLUG";
    public static final String ACTION_ADVANCED_SETTINGS_CHANGED
            = "android.intent.action.ADVANCED_SETTINGS";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_NEW_OUTGOING_CALL =
            "android.intent.action.NEW_OUTGOING_CALL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_REBOOT =
            "android.intent.action.REBOOT";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_DOCK_EVENT =
            "android.intent.action.DOCK_EVENT";
    public static final String ACTION_REMOTE_INTENT =
            "com.google.android.c2dm.intent.RECEIVE";
    public static final String ACTION_PRE_BOOT_COMPLETED =
            "android.intent.action.PRE_BOOT_COMPLETED";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_DEFAULT = "android.intent.category.DEFAULT";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_BROWSABLE = "android.intent.category.BROWSABLE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_ALTERNATIVE = "android.intent.category.ALTERNATIVE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_SELECTED_ALTERNATIVE = "android.intent.category.SELECTED_ALTERNATIVE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_TAB = "android.intent.category.TAB";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_INFO = "android.intent.category.INFO";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_HOME = "android.intent.category.HOME";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_PREFERENCE = "android.intent.category.PREFERENCE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_DEVELOPMENT_PREFERENCE = "android.intent.category.DEVELOPMENT_PREFERENCE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_EMBED = "android.intent.category.EMBED";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_APP_MARKET = "android.intent.category.APP_MARKET";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_MONKEY = "android.intent.category.MONKEY";
    public static final String CATEGORY_TEST = "android.intent.category.TEST";
    public static final String CATEGORY_UNIT_TEST = "android.intent.category.UNIT_TEST";
    public static final String CATEGORY_SAMPLE_CODE = "android.intent.category.SAMPLE_CODE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_OPENABLE = "android.intent.category.OPENABLE";
    public static final String CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST =
            "android.intent.category.FRAMEWORK_INSTRUMENTATION_TEST";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_CAR_DOCK = "android.intent.category.CAR_DOCK";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_DESK_DOCK = "android.intent.category.DESK_DOCK";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_LE_DESK_DOCK = "android.intent.category.LE_DESK_DOCK";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_HE_DESK_DOCK = "android.intent.category.HE_DESK_DOCK";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_CAR_MODE = "android.intent.category.CAR_MODE";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_APP_BROWSER = "android.intent.category.APP_BROWSER";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_APP_CALCULATOR = "android.intent.category.APP_CALCULATOR";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_APP_CALENDAR = "android.intent.category.APP_CALENDAR";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_APP_CONTACTS = "android.intent.category.APP_CONTACTS";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_APP_EMAIL = "android.intent.category.APP_EMAIL";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_APP_GALLERY = "android.intent.category.APP_GALLERY";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_APP_MAPS = "android.intent.category.APP_MAPS";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_APP_MESSAGING = "android.intent.category.APP_MESSAGING";
    @SdkConstant(SdkConstantType.INTENT_CATEGORY) public static final String CATEGORY_APP_MUSIC = "android.intent.category.APP_MUSIC";
    public static final String EXTRA_TEMPLATE = "android.intent.extra.TEMPLATE";
    public static final String EXTRA_TEXT = "android.intent.extra.TEXT";
    public static final String EXTRA_STREAM = "android.intent.extra.STREAM";
    public static final String EXTRA_EMAIL       = "android.intent.extra.EMAIL";
    public static final String EXTRA_CC       = "android.intent.extra.CC";
    public static final String EXTRA_BCC      = "android.intent.extra.BCC";
    public static final String EXTRA_SUBJECT  = "android.intent.extra.SUBJECT";
    public static final String EXTRA_INTENT = "android.intent.extra.INTENT";
    public static final String EXTRA_TITLE = "android.intent.extra.TITLE";
    public static final String EXTRA_INITIAL_INTENTS = "android.intent.extra.INITIAL_INTENTS";
    public static final String EXTRA_KEY_EVENT = "android.intent.extra.KEY_EVENT";
    public static final String EXTRA_KEY_CONFIRM = "android.intent.extra.KEY_CONFIRM";
    public static final String EXTRA_DONT_KILL_APP = "android.intent.extra.DONT_KILL_APP";
    public static final String EXTRA_PHONE_NUMBER = "android.intent.extra.PHONE_NUMBER";
    public static final String EXTRA_UID = "android.intent.extra.UID";
    public static final String EXTRA_PACKAGES = "android.intent.extra.PACKAGES";
    public static final String EXTRA_DATA_REMOVED = "android.intent.extra.DATA_REMOVED";
    public static final String EXTRA_REPLACING = "android.intent.extra.REPLACING";
    public static final String EXTRA_ALARM_COUNT = "android.intent.extra.ALARM_COUNT";
    public static final String EXTRA_DOCK_STATE = "android.intent.extra.DOCK_STATE";
    public static final int EXTRA_DOCK_STATE_UNDOCKED = 0;
    public static final int EXTRA_DOCK_STATE_DESK = 1;
    public static final int EXTRA_DOCK_STATE_CAR = 2;
    public static final int EXTRA_DOCK_STATE_LE_DESK = 3;
    public static final int EXTRA_DOCK_STATE_HE_DESK = 4;
    public static final String METADATA_DOCK_HOME = "android.dock_home";
    public static final String EXTRA_BUG_REPORT = "android.intent.extra.BUG_REPORT";
    public static final String EXTRA_REMOTE_INTENT_TOKEN =
            "android.intent.extra.remote_intent_token";
    @Deprecated public static final String EXTRA_CHANGED_COMPONENT_NAME =
            "android.intent.extra.changed_component_name";
    public static final String EXTRA_CHANGED_COMPONENT_NAME_LIST =
            "android.intent.extra.changed_component_name_list";
    public static final String EXTRA_CHANGED_PACKAGE_LIST =
            "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST =
            "android.intent.extra.changed_uid_list";
    public static final String EXTRA_CLIENT_LABEL =
            "android.intent.extra.client_label";
    public static final String EXTRA_CLIENT_INTENT =
            "android.intent.extra.client_intent";
    public static final String EXTRA_LOCAL_ONLY =
        "android.intent.extra.LOCAL_ONLY";
    public static final int FLAG_GRANT_READ_URI_PERMISSION = 0x00000001;
    public static final int FLAG_GRANT_WRITE_URI_PERMISSION = 0x00000002;
    public static final int FLAG_FROM_BACKGROUND = 0x00000004;
    public static final int FLAG_DEBUG_LOG_RESOLUTION = 0x00000008;
    public static final int FLAG_EXCLUDE_STOPPED_PACKAGES = 0x00000010;
    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 0x00000020;
    public static final int FLAG_ACTIVITY_NO_HISTORY = 0x40000000;
    public static final int FLAG_ACTIVITY_SINGLE_TOP = 0x20000000;
    public static final int FLAG_ACTIVITY_NEW_TASK = 0x10000000;
    public static final int FLAG_ACTIVITY_MULTIPLE_TASK = 0x08000000;
    public static final int FLAG_ACTIVITY_CLEAR_TOP = 0x04000000;
    public static final int FLAG_ACTIVITY_FORWARD_RESULT = 0x02000000;
    public static final int FLAG_ACTIVITY_PREVIOUS_IS_TOP = 0x01000000;
    public static final int FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS = 0x00800000;
    public static final int FLAG_ACTIVITY_BROUGHT_TO_FRONT = 0x00400000;
    public static final int FLAG_ACTIVITY_RESET_TASK_IF_NEEDED = 0x00200000;
    public static final int FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY = 0x00100000;
    public static final int FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET = 0x00080000;
    public static final int FLAG_ACTIVITY_NO_USER_ACTION = 0x00040000;
    public static final int FLAG_ACTIVITY_REORDER_TO_FRONT = 0X00020000;
    public static final int FLAG_ACTIVITY_NO_ANIMATION = 0X00010000;
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 0X00008000;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 0X00004000;
    public static final int FLAG_RECEIVER_REGISTERED_ONLY = 0x40000000;
    public static final int FLAG_RECEIVER_REPLACE_PENDING = 0x20000000;
    public static final int FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT = 0x10000000;
    public static final int FLAG_RECEIVER_BOOT_UPGRADE = 0x08000000;
    public static final int IMMUTABLE_FLAGS =
            FLAG_GRANT_READ_URI_PERMISSION
            | FLAG_GRANT_WRITE_URI_PERMISSION;
    public static final int URI_INTENT_SCHEME = 1<<0;
    public static final int FILL_IN_ACTION = 1<<0;
    public static final int FILL_IN_DATA = 1<<1;
    public static final int FILL_IN_CATEGORIES = 1<<2;
    public static final int FILL_IN_COMPONENT = 1<<3;
    public static final int FILL_IN_PACKAGE = 1<<4;
    public static final int FILL_IN_SOURCE_BOUNDS = 1<<5;
    public static final int FILL_IN_SELECTOR = 1<<6;
    public static final Parcelable.Creator<Intent> CREATOR = new Parcelable.Creator<Intent>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.411 -0400", hash_original_method = "F9E3C09B709E0EDEDA66B8BB83B427D5", hash_generated_method = "0DFC62217A7FBECCA3615E499D1FB063")
        @DSModeled(DSC.SPEC)
        public Intent createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Intent var64525EC96865DE0363F86CE12688FF8C_1869735700 = (new Intent(in));
            return (Intent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Intent(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.412 -0400", hash_original_method = "44BCAE850DE57DDD4EABB7D1FBBBB969", hash_generated_method = "38AAF7C9F3D85CAEA856B6BF89590E80")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Intent[] newArray(int size) {
            dsTaint.addTaint(size);
            Intent[] var97C996FE35E6C6511E700283085F724A_356170878 = (new Intent[size]);
            return (Intent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Intent[size];
        }

        
}; //Transformed anonymous class
}

