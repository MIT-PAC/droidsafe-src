package java.text;

import java.util.Date;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class SimpleDateFormat extends DateFormat {
	
	@DSModeled(DSC.SAFE)
	public SimpleDateFormat(String pattern) {
		taint.addTaint(pattern);
	}

	@Override
	@DSModeled(DSC.SAFE)
	public StringBuffer format(Date date, StringBuffer toAppendTo,
			FieldPosition fieldPosition) {
		taint.addTaints(date, toAppendTo, fieldPosition);
		return new StringBuffer();
	}

	@Override
	@DSModeled(DSC.SAFE)
	public Date parse(String source, ParsePosition pos) {
		taint.addTaints(source, pos);
		return new Date();
	}

}
