package droidsafe.analyses.attr.models.droidsafe.helpers;

import droidsafe.analyses.attr.ModeledClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DSUtils extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(DSUtils.class);

  public static void translateIntent(droidsafe.analyses.attr.models.android.content.Intent request, droidsafe.analyses.attr.models.android.content.Intent result){
    result.setAction(request.getAction());
		result.setType(request.getType());
    result.setPackage(request.getPackage());

		if (request.getData() == null){
			result.setData(new droidsafe.analyses.attr.models.android.net.Uri.StringUri(request.getType()));
    } else {
			result.setData(request.getData());
    }
  }
}
