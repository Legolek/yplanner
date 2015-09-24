package pl.plask.team.yplanner.web.message;

import java.io.Serializable;

public class ReturnMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8744892641199818781L;

	private boolean success;
	private String message;

	public static ReturnMessage success(String message) {
		ReturnMessage rm = new ReturnMessage();
		rm.setMessage(message);
		rm.setSuccess(true);
		return rm;
	}
	
	public static ReturnMessage failure(String message) {
		ReturnMessage rm = new ReturnMessage();
		rm.setMessage(message);
		rm.setSuccess(false);
		return rm;
	}

	private ReturnMessage() {

	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
