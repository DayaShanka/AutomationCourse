package AccessModifier;

//we can access variable & methods whithin the package/class with the help of craeting object 
//we can not access variable & methods outside the class/package.

public class PrivateModifier {

	private int i = 100;

	private void Test() {
		System.out.println("This is private");
	}

	public static void main(String[] args) {

		PrivateModifier t = new PrivateModifier();
		System.out.println(t.i);
		t.Test();

	}

}
