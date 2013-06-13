package droidsafe.analyses.attr.models.android.content;

import com.google.common.collect.Sets;

import droidsafe.analyses.attr.AttrModeledClass;
import droidsafe.analyses.attr.AttrModelingSet;
import droidsafe.analyses.attr.models.android.content.ComponentName;
import droidsafe.analyses.attr.models.android.net.Uri;
import droidsafe.analyses.attr.models.android.os.Bundle;

import java.util.HashSet;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public class Intent extends AttrModeledClass {

    public Set<String> mAction = new AttrModelingSet<String>();
    public Uri mData;
    public Set<String> mType = new AttrModelingSet<String>();
    public Set<String> mPackage = new AttrModelingSet<String>();
    public ComponentName mComponent;
    public Set<Integer> mFlags = new AttrModelingSet<Integer>();
    public Bundle mExtras;

    public Intent(AllocNode allocNode) {
        super(allocNode);
    }
    
    /**
     * Create an empty intent.
     */ 
    public void _init_(){
    
    }

    /**
     * Create an intent with a given action.  All other fields (data, type,
     * class) are null.  Note that the action <em>must</em> be in a
     * namespace because Intents are used globally in the system -- for
     * example the system VIEW action is android.intent.action.VIEW; an
     * application's custom action would be something like
     * com.google.app.myapp.CUSTOM_ACTION.
     *
     * @param action The Intent action, such as ACTION_VIEW.
     */
    public void _init_(Set<String> action){
        this.setAction(action);
    } 

    /**
     * Create an intent with a given action and for a given data url.  Note
     * that the action <em>must</em> be in a namespace because Intents are
     * used globally in the system -- for example the system VIEW action is
     * android.intent.action.VIEW; an application's custom action would be
     * something like com.google.app.myapp.CUSTOM_ACTION.
     *
     * <p><em>Note: scheme and host name matching in the Android framework is
     * case-sensitive, unlike the formal RFC.  As a result,
     * you should always ensure that you write your Uri with these elements
     * using lower case letters, and normalize any Uris you receive from
     * outside of Android to ensure the scheme and host is lower case.</em></p>
     *
     * @param action The Intent action, such as ACTION_VIEW.
     * @param uri The Intent data URI.
     */
    public void _init_(Set<String> action, Uri uri){
        this.setAction(action);
        this.setData(uri);
    } 

    /**
     * Create an intent for a specific component.  All other fields (action, data,
     * type, class) are null, though they can be modified later with explicit
     * calls.  This provides a convenient way to create an intent that is
     * intended to execute a hard-coded class name, rather than relying on the
     * system to find an appropriate class for you; see {@link #setComponent}
     * for more information on the repercussions of this.
     *
     * @param packageContext A Context of the application package implementing
     * this class.
     * @param cls The component class that is to be used for the intent.
     *
     * @see #setClass
     * @see #setComponent
     * @see #Intent(String, android.net.Uri , Context, Class)
     */
    public void _init_(Context packageContext, Class cls) {
        this.mComponent = new ComponentName(packageContext, cls);
    }

    /**
     * Set the general action to be performed.
     *
     * @param action An action name, such as ACTION_VIEW.  Application-specific
     *               actions should be prefixed with the vendor's package name.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #getAction
     */
    public Intent setAction(Set<String> mAction){
        this.mAction.addAll(mAction);
        return this;
    }

    /**
     * Set the data this intent is operating on.  This method automatically
     * clears any type that was previously set by {@link #setType}.
     *
     * <p><em>Note: scheme and host name matching in the Android framework is
     * case-sensitive, unlike the formal RFC.  As a result,
     * you should always ensure that you write your Uri with these elements
     * using lower case letters, and normalize any Uris you receive from
     * outside of Android to ensure the scheme and host is lower case.</em></p>
     *
     * @param data The URI of the data this intent is now targeting.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #getData
     * @see #setType
     * @see #setDataAndType
     */
    public Intent setData(Uri mUri) {
        this.mData = mUri;
        return this;
    }


    /**
     * (Usually optional) Explicitly set the component to handle the intent.
     * If left with the default value of null, the system will determine the
     * appropriate class to use based on the other fields (action, data,
     * type, categories) in the Intent.  If this class is defined, the
     * specified class will always be used regardless of the other fields.  You
     * should only set this value when you know you absolutely want a specific
     * class to be used; otherwise it is better to let the system find the
     * appropriate class so that you will respect the installed applications
     * and user preferences.
     *
     * @param component The name of the application component to handle the
     * intent, or null to let the system find one for you.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #setClass
     * @see #setClassName(Context, String)
     * @see #setClassName(String, String)
     * @see #getComponent
     * @see #resolveActivity
     */
    public Intent setComponent(ComponentName component) {
        this.mComponent = component;
        return this;
    }


    /**
     * Set an explicit MIME data type.  This is used to create intents that
     * only specify a type and not data, for example to indicate the type of
     * data to return.  This method automatically clears any data that was
     * previously set by {@link #setData}.
     *
     * <p><em>Note: MIME type matching in the Android framework is
     * case-sensitive, unlike formal RFC MIME types.  As a result,
     * you should always write your MIME types with lower case letters,
     * and any MIME types you receive from outside of Android should be
     * converted to lower case before supplying them here.</em></p>
     *
     * @param type The MIME type of the data being handled by this intent.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #getType
     * @see #setData
     * @see #setDataAndType
     */
    public Intent setType(Set<String> mType){
        this.mType.addAll(mType);
        return this;
    }

    /**
     * (Usually optional) Set an explicit application package name that limits
     * the components this Intent will resolve to.  If left to the default
     * value of null, all components in all applications will considered.
     * If non-null, the Intent can only match the components in the given
     * application package.
     *
     * @param packageName The name of the application package to handle the
     * intent, or null to allow any application package.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #getPackage
     * @see #resolveActivity
     */
    public Intent setPackage(Set<String> packageName){
        this.mPackage.addAll(mPackage);
        return this;
    }

    /**
     * Set special flags controlling how this intent is handled.  Most values
     * here depend on the type of component being executed by the Intent,
     * specifically the FLAG_ACTIVITY_* flags are all for use with
     * {@link Context#startActivity Context.startActivity()} and the
     * FLAG_RECEIVER_* flags are all for use with
     * {@link Context#sendBroadcast(Intent) Context.sendBroadcast()}.
     *
     * <p>See the
     * <a href="{@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html">Tasks and Back
     * Stack</a> documentation for important information on how some of these options impact
     * the behavior of your application.
     *
     * @param flags The desired flags.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #getFlags
     * @see #addFlags
     *
     * @see #FLAG_GRANT_READ_URI_PERMISSION
     * @see #FLAG_GRANT_WRITE_URI_PERMISSION
     * @see #FLAG_DEBUG_LOG_RESOLUTION
     * @see #FLAG_FROM_BACKGROUND
     * @see #FLAG_ACTIVITY_BROUGHT_TO_FRONT
     * @see #FLAG_ACTIVITY_CLEAR_TASK
     * @see #FLAG_ACTIVITY_CLEAR_TOP
     * @see #FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET
     * @see #FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
     * @see #FLAG_ACTIVITY_FORWARD_RESULT
     * @see #FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY
     * @see #FLAG_ACTIVITY_MULTIPLE_TASK
     * @see #FLAG_ACTIVITY_NEW_TASK
     * @see #FLAG_ACTIVITY_NO_ANIMATION
     * @see #FLAG_ACTIVITY_NO_HISTORY
     * @see #FLAG_ACTIVITY_NO_USER_ACTION
     * @see #FLAG_ACTIVITY_PREVIOUS_IS_TOP
     * @see #FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
     * @see #FLAG_ACTIVITY_REORDER_TO_FRONT
     * @see #FLAG_ACTIVITY_SINGLE_TOP
     * @see #FLAG_ACTIVITY_TASK_ON_HOME
     * @see #FLAG_RECEIVER_REGISTERED_ONLY
     */
    public Intent setFlags(Set<Integer> flags) {
        mFlags.addAll(flags);
        return this;
    }

    /**
     * Retrieve the general action to be performed, such as
     * {@link #ACTION_VIEW}.  The action describes the general way the rest of
     * the information in the intent should be interpreted -- most importantly,
     * what to do with the data returned by {@link #getData}.
     *
     * @return The action of this intent or null if none is specified.
     *
     * @see #setAction
     */
    public Set<String> getAction() {
        return this.mAction;
    }

    /**
     * Retrieve the application package name this Intent is limited to.  When
     * resolving an Intent, if non-null this limits the resolution to only
     * components in the given application package.
     *
     * @return The name of the application package for the Intent.
     *
     * @see #resolveActivity
     * @see #setPackage
     */
    public Set<String> getPackage() {
        return this.mPackage;
    }

    /**
     * Retrieve any explicit MIME type included in the intent.  This is usually
     * null, as the type is determined by the intent data.
     *
     * @return If a type was manually set, it is returned; else null is
     *         returned.
     *
     * @see #resolveType(ContentResolver)
     * @see #setType
     */
    public Set<String> getType() {
        return this.mType;
    }
    /**
     * Retrieve data this intent is operating on.  This URI specifies the name
     * of the data; often it uses the content: scheme, specifying data in a
     * content provider.  Other schemes may be handled by specific activities,
     * such as http: by the web browser.
     *
     * @return The URI of the data this intent is targeting or null.
     *
     * @see #getScheme
     * @see #setData
     */
    public Uri getData() {
        return this.mData;
    }
    
    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no String value was found.
     *
     * @see #putExtra(String, String)
     */
    public Set<String> getStringExtra(Set<String> names) {
        Set<String> results = new AttrModelingSet<String>(new HashSet<String>());
        for(String name : names) {
            results.addAll(this.mExtras.getString(name));
        }
        return results;
    }

    /**
     * Add a set of extended data to the intent.  The keys must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param extras The Bundle of extras to add to this intent.
     *
     * @see #putExtra
     * @see #removeExtra
     */
    public Intent putExtras(Bundle extras) {
        if(this.mExtras == null){
            this.mExtras = new Bundle();
        }
        this.mExtras.putAll(extras);
        return this;
    }

    /**
     * Retrieves a map of extended data from the intent.
     *
     * @return the map of all extras previously added with putExtra(),
     * or null if none have been added.
     */
    public Bundle getExtras() {
        return this.mExtras;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The boolean data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getBooleanExtra(String, boolean)
     */
    public <T> Intent putExtra(Set<String> names, Set<T> values) {
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        for(String name : names) {
            for(T value : values) {
                if      (value instanceof String) mExtras.putString(new AttrModelingSet(Sets.newHashSet(name)), 
                                                                    new AttrModelingSet(Sets.newHashSet(value)));
                else if (value instanceof Boolean) mExtras.putBoolean(new AttrModelingSet(Sets.newHashSet(name)), 
                                                                      new AttrModelingSet(Sets.newHashSet(value)));
                else if (value instanceof Byte) mExtras.putByte(new AttrModelingSet(Sets.newHashSet(name)),
                                                                new AttrModelingSet(Sets.newHashSet(value)));
                else if (value instanceof Character) mExtras.putChar(new AttrModelingSet(Sets.newHashSet(name)), 
                                                                     new AttrModelingSet(Sets.newHashSet(value)));
                else if (value instanceof Double) mExtras.putDouble(new AttrModelingSet(Sets.newHashSet(name)), 
                                                                    new AttrModelingSet(Sets.newHashSet(value)));
                else if (value instanceof Float) mExtras.putFloat(new AttrModelingSet(Sets.newHashSet(name)), 
                                                                  new AttrModelingSet(Sets.newHashSet(value)));
                else if (value instanceof Integer) mExtras.putInt(new AttrModelingSet(Sets.newHashSet(name)), 
                                                                  new AttrModelingSet(Sets.newHashSet(value)));
                else if (value instanceof Long) mExtras.putLong(new AttrModelingSet(Sets.newHashSet(name)), 
                                                                new AttrModelingSet(Sets.newHashSet(value)));
                else if (value instanceof Short) mExtras.putShort(new AttrModelingSet(Sets.newHashSet(name)),
                                                                  new AttrModelingSet(Sets.newHashSet(value)));
            }
        }
        return this;
    }
    /*
    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The byte data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getByteExtra(String, byte)
     */
    /*
    public Intent putExtra(Set<String> names, Set<Byte> values) {
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        for(String name : names) {
            for(Byte value : values) {   
                mExtras.putByte(name, value);
            }
        }
        return this;
    }
    */
    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The char data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getCharExtra(String, char)
     */
    /*
    public Intent putExtra(Set<String> names, Set<Character> values) {
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        for(String name : names) {
            for(Character value : values) {
                mExtras.putChar(name, value);
            }
        }
        return this;
    }
    */
    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The short data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getShortExtra(String, short)
     */
    /**
    public Intent putExtra(Set<String> names, Set<Short> values) {
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        for(String name : names) {
            for(Short value : values) {
                mExtras.putShort(name, value);
            }
        }
        return this;
    }
    */
    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The integer data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getIntExtra(String, int)
     */
    /**
    public Intent putExtra(Set<String> names, Set<Integer> values) {
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        for(String name : names) {
            for(Integer value : values) {
                 mExtras.putInt(name, value);
            }
        }
        return this;
    }
    */
    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The long data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getLongExtra(String, long)
     */
    /**
    public Intent putExtra(Set<String> names, Set<Long> values) {
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        for(String name : names) {
            for(Long value : values) {
                mExtras.putLong(name, value);
            }
        }
        return this;
    }
    */
    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The float data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getFloatExtra(String, float)
     */
    /**
    public Intent putExtra(Set<String> names, Set<Float> values) {
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        for (String name : names) {
            for(Float value : values) {
                mExtras.putFloat(name, value);
            }
        }
        return this;
    }
    */
    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The double data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getDoubleExtra(String, double)
     */
    /**
    public Intent putExtra(Set<String> names, Set<Double> values) {
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        for(String name : names) {
            for(Double value : values) {
                mExtras.putDouble(name, value);
            }
        }
        return this;
    }
    */

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The String data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getStringExtra(String)
     */
    /**
    public Intent putExtra(Set<String> names, Set<String> values) {
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        for(String name : names) {
          for(String value : values) {
            mExtras.putString(name, value);
          }
        }
        return this;
    }
    */
}
