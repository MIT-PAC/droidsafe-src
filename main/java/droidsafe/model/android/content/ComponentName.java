/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package droidsafe.model.android.content;

import droidsafe.model.java.lang.String;
import droidsafe.model.ModeledClass;

import java.lang.Comparable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * Identifier for a specific application component
 * ({@link android.app.Activity}, {@link android.app.Service},
 * {@link android.content.BroadcastReceiver}, or
 * {@link android.content.ContentProvider}) that is available.  Two
 * pieces of information, encapsulated here, are required to identify
 * a component: the package (a String) it exists in, and the class (a String)
 * name inside of that package.
 * 
 */
public final class ComponentName extends ModeledClass implements Comparable<ComponentName> {

  private final static Logger logger = LoggerFactory.getLogger(ComponentName.class);

  private final droidsafe.model.java.lang.String mPackage;
  private final droidsafe.model.java.lang.String mClass;

  public ComponentName(AllocNode allocNode) {
    super(allocNode);
    this.mPackage = new String();
    this.mClass = new String();
  }

  /**
   * Create a new component identifier.
   * 
   * @param pkg The name of the package that the component exists in.  Can
   * not be null.
   * @param cls The name of the class inside of <var>pkg</var> that
   * implements the component.  Can not be null.
   */
  public ComponentName(droidsafe.model.java.lang.String pkg, droidsafe.model.java.lang.String cls) {
      if (pkg == null) throw new NullPointerException("package name is null");
      if (cls == null) throw new NullPointerException("class name is null");
      mPackage = pkg;
      mClass = cls;
  }

  /**
   * Create a new component identifier from a Context and class name.
   * 
   * @param pkg A Context for the package implementing the component,
   * from which the actual package name will be retrieved.
   * @param cls The name of the class inside of <var>pkg</var> that
   * implements the component.
   */
  public ComponentName(droidsafe.model.android.content.Context pkg, droidsafe.model.java.lang.String cls) {
      if (cls == null) throw new NullPointerException("class name is null");
      mPackage = pkg.getPackageName();
      mClass = cls;
  }

  /**
   * Create a new component identifier from a Context and Class object.
   * 
   * @param pkg A Context for the package implementing the component, from
   * which the actual package name will be retrieved.
   * @param cls The Class object of the desired component, from which the
   * actual class name will be retrieved.
   */
  public ComponentName(droidsafe.model.android.content.Context pkg, Class<?> cls) {
      mPackage = pkg.getPackageName();
      mClass = new droidsafe.model.java.lang.String(cls.getName());
  }

  public ComponentName clone() {
      return new ComponentName(mPackage, mClass);
  }

  /**
   * Return the package name of this component.
   */
  public droidsafe.model.java.lang.String getPackageName() {
      return mPackage;
  }
  
  /**
   * Return the class name of this component.
   */
  public droidsafe.model.java.lang.String getClassName() {
      return mClass;
  }
  
  /**
   * Return the class name, either fully qualified or in a shortened form
   * (with a leading '.') if it is a suffix of the package.
   */
  /*
  public String getShortClassName() {
      if (mClass.startsWith(mPackage)) {
          int PN = mPackage.length();
          int CN = mClass.length();
          if (CN > PN && mClass.charAt(PN) == '.') {
              return mClass.substring(PN, CN);
          }
      }
      return mClass;
  }
  */

  /**
   * Return a String that unambiguously describes both the package and
   * class names contained in the ComponentName.  You can later recover
   * the ComponentName from this string through
   * {@link #unflattenFromString(String)}.
   * 
   * @return Returns a new String holding the package and class names.  This
   * is represented as the package name, concatenated with a '/' and then the
   * class name.
   * 
   * @see #unflattenFromString(String)
   */
  /*
  public String flattenToString() {
      return mPackage + "/" + mClass;
  }
  */
  
  /**
   * The same as {@link #flattenToString()}, but abbreviates the class
   * name if it is a suffix of the package.  The result can still be used
   * with {@link #unflattenFromString(String)}.
   * 
   * @return Returns a new String holding the package and class names.  This
   * is represented as the package name, concatenated with a '/' and then the
   * class name.
   * 
   * @see #unflattenFromString(String)
   */
  /*
  public String flattenToShortString() {
      return mPackage + "/" + getShortClassName();
  }
  */
   
  /**
   * Recover a ComponentName from a String that was previously created with
   * {@link #flattenToString()}.  It splits the string at the first '/',
   * taking the part before as the package name and the part after as the
   * class name.  As a special convenience (to use, for example, when
   * parsing component names on the command line), if the '/' is immediately
   * followed by a '.' then the final class name will be the concatenation
   * of the package name with the string following the '/'.  Thus
   * "com.foo/.Blah" becomes package="com.foo" class="com.foo.Blah".
   * 
   * @param str The String that was returned by flattenToString().
   * @return Returns a new ComponentName containing the package and class
   * names that were encoded in <var>str</var>
   * 
   * @see #flattenToString()
   */
  /*
  public static ComponentName unflattenFromString(String str) {
      int sep = str.indexOf('/');
      if (sep < 0 || (sep+1) >= str.length()) {
          return null;
      }
      String pkg = str.substring(0, sep);
      String cls = str.substring(sep+1);
      if (cls.length() > 0 && cls.charAt(0) == '.') {
          cls = pkg + cls;
      }
      return new ComponentName(pkg, cls);
  }
  */

  /**
   * Return string representation of this class without the class's name
   * as a prefix.
   */
  /*
  public String toShortString() {
      return "{" + mPackage + "/" + mClass + "}";
  }
  */
   
  public int compareTo(ComponentName that) {
    int v;
    v = this.mPackage.compareTo(that.mPackage);
    if (v != 0) {
      return v;
    }
    return this.mClass.compareTo(that.mClass);
  } 
  
  //public int describeContents() {return 0}

  //public void writeToParcel(Parcel out, int flags) {}

  //public static void writeToParcel(ComponentName c, Parcel out) {}
 
  /* 
  public static ComponentName readFromParcel(Parcel in) {
      String pkg = in.readString();
      return pkg != null ? new ComponentName(pkg, in) : null;
  }
  */
  /*
  public static final Parcelable.Creator<ComponentName> CREATOR
          = new Parcelable.Creator<ComponentName>() {
      public ComponentName createFromParcel(Parcel in) {
          return new ComponentName(in);
      }

      public ComponentName[] newArray(int size) {
          return new ComponentName[size];
      }
  };
  */
  /**
   * Instantiate a new ComponentName from the data in a Parcel that was
   * previously written with {@link #writeToParcel(Parcel, int)}.  Note that you
   * must not use this with data written by
   * {@link #writeToParcel(ComponentName, Parcel)} since it is not possible
   * to handle a null ComponentObject here.
   * 
   * @param in The Parcel containing the previously written ComponentName,
   * positioned at the location in the buffer where it was written.
   */
  /*
  public ComponentName(Parcel in) {
      mPackage = in.readString();
      if (mPackage == null) throw new NullPointerException(
              "package name is null");
      mClass = in.readString();
      if (mClass == null) throw new NullPointerException(
              "class name is null");
  }

  private ComponentName(String pkg, Parcel in) {
      mPackage = pkg;
      mClass = in.readString();
    }
    */
}
