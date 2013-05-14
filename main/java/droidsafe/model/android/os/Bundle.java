package droidsafe.model.android.os;

import droidsafe.model.ModeledClass;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public class Bundle extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(Bundle.class);

  Map<droidsafe.model.java.lang.String, Object> mMap;

  private boolean mHasFds = false;
  private boolean mFdsKnown = true;
  private boolean mAllowFds = true;

  public Bundle() {
    mMap = new HashMap<droidsafe.model.java.lang.String, Object>();
  }

  public Bundle(Bundle b) {
    putAll(b);
    mHasFds = b.mHasFds;
    mFdsKnown = b.mFdsKnown;
  } 

  public Bundle(AllocNode allocNode) {
    super(allocNode);
    this.mMap = new HashMap<droidsafe.model.java.lang.String, Object>();
  }

  public void _init_(){
  }


  public void putAll(droidsafe.model.android.os.Bundle b) {
    mMap.putAll(b.mMap);

    // fd state is now known if and only if both bundles already knew
    mHasFds |= b.mHasFds;
    mFdsKnown = mFdsKnown && b.mFdsKnown;
  }

  @Override
  public String toString(){
    String str = "<modeled Bundle" + this.getId() + "> {";
    if (invalidated) {
      str += "invalidated";
    } else {
      ArrayList<String> attrs = new ArrayList();
      if(mMap.size() > 0)
        attrs.add("mMap: " + this.mMap);
      attrs.add("mHasFds: " + this.mHasFds);
      attrs.add("mFdsKnown: " + this.mFdsKnown);
      attrs.add("mAllowFds: " + this.mAllowFds);
      str += StringUtils.join(attrs.toArray(), ", ");
    }
    return str + "}";
  }
}
