package knight.su.dawn.chain.input_output_chain;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public enum CacheEnum {

	CACHE;
	private CacheStore instance;

	private CacheEnum() {
		instance = new CacheStore();
	}
	
	public CacheStore getInstance() {
		return this.instance;
	}
}
