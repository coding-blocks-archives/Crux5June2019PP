package L35_Aug12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Aug-2019
 *
 */

public class STMax implements SegmentTreeI{

	@Override
	public int operation(int a, int b) {
		return Math.max(a, b) ;
	}

	@Override
	public int defaultValue() {
		return Integer.MIN_VALUE;
	}

	
}
