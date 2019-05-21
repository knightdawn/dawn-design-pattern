package knight.su.dawn.chain.inner_chain;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class HandleResp {

	private String resp;

	public HandleResp(String resp) {
		this.resp = resp;
	}

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}

	@Override
	public String toString() {
		return this.resp;
	}

}
