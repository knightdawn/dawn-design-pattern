package knight.su.dawn.chain.input_output_chain;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class CacheStore {

	private ConcurrentHashMap<String, Tuple<Float, Float>> cache = new ConcurrentHashMap<>();

	public CacheStore() {
		cache.put("a", new Tuple<>(38.6855097600F, 94.0869140625F));
		cache.put("b", new Tuple<>(28.9216312824F, 110.0390625000F));
		cache.put("c", new Tuple<>(26.1159859253F, 103.1835937500F));
		cache.put("d", new Tuple<>(27.3717673005F, 113.7304687500F));
	}

	/**
	 * get tuple
	 * 
	 * @param key
	 * @return
	 */
	public Tuple<Float, Float> get(String key) {
		return cache.get(key);
	}

	/**
	 * put tuple cache
	 * 
	 * @param key
	 * @param v1
	 * @param v2
	 */
	public void put(String key, Float v1, Float v2) {
		cache.put(key, new Tuple<Float, Float>(v1, v2));
	}
}
