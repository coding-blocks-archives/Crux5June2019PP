package L26_July29.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Jul-2019
 *
 */

public class CarColorComparator implements Comparator<Car>{

	@Override
	public int compare(Car t, Car o) {
		return t.color.compareTo(o.color) ;
	}

	
}
