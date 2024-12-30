package ignored;

import org.testng.annotations.Test;

//@Test(enabled = false)  //it will false for all tests
public class Enabled {

	@Test(enabled = false) // this will also ignored by this
	void t1() {

		System.out.println("t1 printed");
	}

	@Test
	void t2() {

		System.out.println("t2 printed");
	}

	@Test
	void t3() {

		System.out.println("t3 printed");
	}

}
