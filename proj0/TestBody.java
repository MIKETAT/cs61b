public class TestBody {
	public static void main(String[] args) {
		Body b1 = new Body(0,0,1,1,5,"fake");
		Body b2 = new Body(1,1,0,1,10,"xiaohu");
		double force = b1.calcForceExertedBy(b2);
		System.out.println("The Force Between b1 and b2 :" + force);
	}
}