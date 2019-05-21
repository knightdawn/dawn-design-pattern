package knight.su.dawn.chain.filter_chain;

/**
 *
 * Date: 2019年5月20日<br/>
 * 
 * @author sugengbin
 */
public class Request {
	private String req;

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	@Override
	public String toString() {
		return "req:" + this.req;
	}
}
