package droidsafe.analyses.attr.models.android.content;

import droidsafe.analyses.attr.ModeledClass;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;
import droidsafe.analyses.attr.models.java.lang.String;

public class Intent extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(Intent.class);

  droidsafe.analyses.attr.models.java.lang.String mAction;
  droidsafe.analyses.attr.models.java.lang.String mType;
  droidsafe.analyses.attr.models.java.lang.String mPackage;
  droidsafe.analyses.attr.models.android.net.Uri mData;
  droidsafe.analyses.attr.models.android.os.Bundle mExtras;
  droidsafe.analyses.attr.models.android.content.ComponentName mComponent;
  private Integer mFlags;

  public Intent(AllocNode allocNode) {
    super(allocNode);
    this.mAction = new droidsafe.analyses.attr.models.java.lang.String();
    this.mType = new droidsafe.analyses.attr.models.java.lang.String();
    this.mPackage = new droidsafe.analyses.attr.models.java.lang.String();
  }
  
  public void _init_(){
  }

  public void _init_(droidsafe.analyses.attr.models.java.lang.String action){
    this.setAction(action);
  } 
 
  public void _init_(droidsafe.analyses.attr.models.java.lang.String action, droidsafe.analyses.attr.models.android.net.Uri uri){
    this.setAction(action);
    this.setData(uri);
  } 
 
  public void _init_(droidsafe.analyses.attr.models.android.test.mock.MockContext context, droidsafe.analyses.attr.models.java.lang.String cls) {
    // TODO: check the android source code for this constructor
    this.setAction(cls);
  }
  
  public void _init_(droidsafe.analyses.attr.models.android.content.Context context, java.lang.Class cls) {
  }

  public droidsafe.analyses.attr.models.android.content.Intent setAction(droidsafe.analyses.attr.models.java.lang.String mAction){
    this.mAction.incorporateString(mAction);
    return this;
  }

  public droidsafe.analyses.attr.models.android.content.Intent setData(droidsafe.analyses.attr.models.android.net.Uri mUri) {
    this.mData = mUri;
    return this;
  }

  public droidsafe.analyses.attr.models.android.content.Intent setComponent(droidsafe.analyses.attr.models.android.content.ComponentName component) {
    this.mComponent = component;
    return this;
  }

  public droidsafe.analyses.attr.models.android.content.Intent setType(droidsafe.analyses.attr.models.java.lang.String mType){
    this.mType.incorporateString(mType);
    return this;
  }
  
  public droidsafe.analyses.attr.models.android.content.Intent setPackage(droidsafe.analyses.attr.models.java.lang.String mPackage){
    this.mPackage.incorporateString(mPackage);
    return this;
  }

  public Intent setFlags(Integer flags){
    mFlags = flags;
    return this;
  }

  public droidsafe.analyses.attr.models.java.lang.String getAction() {
    return this.mAction;
  }

  public droidsafe.analyses.attr.models.java.lang.String getPackage() {
    return this.mPackage;
  }

  public droidsafe.analyses.attr.models.java.lang.String getType() {
    return this.mType;
  }

  public droidsafe.analyses.attr.models.android.net.Uri getData() {
    return this.mData;
  }

  public void getStringExtra(droidsafe.analyses.attr.models.java.lang.String name) {
  }

  public droidsafe.analyses.attr.models.android.content.Intent putExtras(droidsafe.analyses.attr.models.android.os.Bundle extras) {
    if(this.mExtras == null){
      this.mExtras = new droidsafe.analyses.attr.models.android.os.Bundle();
    }
    this.mExtras.putAll(extras);
    return this;
  }

  public droidsafe.analyses.attr.models.android.os.Bundle getExtras() {
    return (mExtras != null) ? new droidsafe.analyses.attr.models.android.os.Bundle(mExtras) : null;
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
  public Intent putExtra(String name, boolean value) {
      if (mExtras == null) {
          mExtras = new droidsafe.analyses.attr.models.android.os.Bundle();
      }
      mExtras.putBoolean(name, value);
      return this;
  }

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
  public Intent putExtra(String name, byte value) {
      if (mExtras == null) {
          mExtras = new droidsafe.analyses.attr.models.android.os.Bundle();
      }
      mExtras.putByte(name, value);
      return this;
  }

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
  public Intent putExtra(String name, char value) {
      if (mExtras == null) {
          mExtras = new droidsafe.analyses.attr.models.android.os.Bundle();
      }
      mExtras.putChar(name, value);
      return this;
  }

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
  public Intent putExtra(String name, short value) {
      if (mExtras == null) {
          mExtras = new droidsafe.analyses.attr.models.android.os.Bundle();
      }
      mExtras.putShort(name, value);
      return this;
  }

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
  public Intent putExtra(String name, int value) {
      if (mExtras == null) {
          mExtras = new droidsafe.analyses.attr.models.android.os.Bundle();
      }
      mExtras.putInt(name, value);
      return this;
  }

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
  public Intent putExtra(String name, long value) {
      if (mExtras == null) {
          mExtras = new droidsafe.analyses.attr.models.android.os.Bundle();
      }
      mExtras.putLong(name, value);
      return this;
  }

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
  public Intent putExtra(String name, float value) {
      if (mExtras == null) {
          mExtras = new droidsafe.analyses.attr.models.android.os.Bundle();
      }
      mExtras.putFloat(name, value);
      return this;
  }

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
  public Intent putExtra(String name, double value) {
      if (mExtras == null) {
          mExtras = new droidsafe.analyses.attr.models.android.os.Bundle();
      }
      mExtras.putDouble(name, value);
      return this;
  }

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
  public Intent putExtra(String name, String value) {
      if (mExtras == null) {
          mExtras = new droidsafe.analyses.attr.models.android.os.Bundle();
      }
      mExtras.putString(name, value);
      return this;
  }

  @Override
  public java.lang.String toString(){
    java.lang.String str = "<modeled Intent" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
      ArrayList<java.lang.String> attrs = new ArrayList();
      if(this.mAction.getPossibleValues().size() > 0)
        attrs.add("action: " + this.mAction);
      if(this.mType.getPossibleValues().size() > 0)
        attrs.add("type: " + this.mType);
      if(this.mData != null)
        attrs.add("data: " + this.mData);
      if(this.mPackage.getPossibleValues().size() > 0)
        attrs.add("package: " + this.mPackage);
      str = str + StringUtils.join(attrs.toArray(), ", ");
    }
    return str + "}";
  }
}
