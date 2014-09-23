package com.google.android.gms.drive.query;

public class ComparisonFilter implements Filter {
	
	enum Operator {
		LessThan,
		Equal,
		GreaterThan,
		Other
	}
	
	Object leftHand;
	Object rightHand;
	
	public ComparisonFilter(Operator op, Object left, Object right) {
		leftHand = left;
		rightHand = right;
	}
	

}
