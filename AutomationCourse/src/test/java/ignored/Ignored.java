package ignored;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Ignored {

	@Test
	void t1() {

		System.out.println("t1 printed");
	}

	@Ignore // this will ignored by this
	@Test
	void t2() {

		System.out.println("t2 printed");
	}

	@Test
	void t3() {

		System.out.println("t3 printed");
	}

}
