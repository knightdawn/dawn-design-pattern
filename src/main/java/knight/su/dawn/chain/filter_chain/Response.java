package knight.su.dawn.chain.filter_chain;

/**
 *
 * Date: 2019年5月20日<br/>
 * 
 * @author sugengbin
 */
public class Response {
	private String resp;

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}

	@Override
	public String toString() {
		return "resp:" + this.resp;
	}
}
