package droidsafe.model.droidsafe.helpers;

import droidsafe.model.ModeledClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DSUtils extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(DSUtils.class);

  public static void translateIntent(droidsafe.model.android.content.Intent request, droidsafe.model.android.content.Intent result){
    result.setAction(request.getAction());
		result.setType(request.getType());
    result.setPackage(request.getPackage());

		if (request.getData() == null){
			result.setData(new droidsafe.model.android.net.Uri.StringUri(request.getType()));
    } else {
			result.setData(request.getData());
    }
  }
}
