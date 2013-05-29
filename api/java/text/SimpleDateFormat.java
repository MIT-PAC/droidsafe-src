package java.text;

import java.util.Date;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class SimpleDateFormat extends DateFormat {
	
	@DSModeled(DSC.SAFE)
	public SimpleDateFormat(String pattern) {
		dsTaint.addTaint(pattern);
	}

	@Override
	@DSModeled(DSC.SAFE)
	public StringBuffer format(Date date, StringBuffer toAppendTo,
			FieldPosition fieldPosition) {
		dsTaint.addTaint(date.toString());
		dsTaint.addTaint(toAppendTo.toString());
		return new StringBuffer();
	}

	@Override
	@DSModeled(DSC.SAFE)
	public Date parse(String source, ParsePosition pos) {
		dsTaint.addTaint(source);
		return new Date();
	}

	@Override
	public StringBuffer format(Object obj, StringBuffer toAppendTo,
			FieldPosition pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object parseObject(String source, ParsePosition pos) {
		// TODO Auto-generated method stub
		return null;
	}

}
