package knight.su.dawn.chain.external_chain;

import java.io.Serializable;

/**
 * 
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class ReqDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3605578439783378176L;
	private String device;
	private String user;
	private String version;

	public String getDevice() {
		return device;
	}

	public ReqDto setDevice(String device) {
		this.device = device;
		return this;
	}

	public String getUser() {
		return user;
	}

	public ReqDto setUser(String user) {
		this.user = user;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public ReqDto setVersion(String version) {
		this.version = version;
		return this;
	}

}
