package knight.su.dawn.chain.inner_chain;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class HandleReq {

	private String user;
	private String userType;

	public HandleReq(String user, String userType) {
		this.user = user;
		this.userType = userType;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
