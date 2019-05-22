package knight.su.dawn.chain.input_output_chain;

/**
 * 
 *
 * Date:     2019年5月21日<br/> 
 * @author   sugengbin
 */
public class Tuple<T1, T2> {
    
    public T1 _1;
    public T2 _2;
    
    public Tuple() {}
    
    public Tuple(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_1 == null) ? 0 : _1.hashCode());
        result = prime * result + ((_2 == null) ? 0 : _2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tuple<?, ?> other = (Tuple<?, ?>) obj;
        if (_1 == null) {
            if (other._1 != null)
                return false;
        } else if (!_1.equals(other._1))
            return false;
        if (_2 == null) {
            if (other._2 != null)
                return false;
        } else if (!_2.equals(other._2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tuple2 [_1=" + _1 + ", _2=" + _2 + "]";
    }
}