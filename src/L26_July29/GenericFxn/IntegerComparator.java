package L26_July29.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Jul-2019
 *
 */

public class IntegerComparator  implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1 ;
	}

}
