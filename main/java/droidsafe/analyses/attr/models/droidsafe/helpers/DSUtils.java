package droidsafe.analyses.attr.models.droidsafe.helpers;

import droidsafe.analyses.attr.AttrModeledClass;
import droidsafe.analyses.attr.models.android.content.Intent;
import droidsafe.analyses.attr.models.android.net.Uri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DSUtils extends AttrModeledClass {

    public static void translateIntent(Intent request, Intent result){
        result.setAction(request.getAction());
        result.setType(request.getType());
        result.setPackage(request.getPackage());

        if (request.getData() == null){
            result.setData(new Uri.StringUri(request.getType()));
        } else {
            result.setData(request.getData());
        }
    }
}
