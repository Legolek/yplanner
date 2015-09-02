package pl.plask.team.yplanner.bc.model.ds.helper;

public enum YesNoEnum {
	Y, N;
	
	public boolean toBoolean() {
		return equals(Y);
	}
	
	public static YesNoEnum get(boolean value) {
		if (value) {
			return Y;
		} else {
			return N;
		}
	}
}
