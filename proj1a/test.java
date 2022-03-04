public class test {
	public static void main(String[] args) {
		ArrayDeque<Integer> ld = new ArrayDeque<>();
		for(int i = 0; i < 10; i ++) {
			ld.addLast(i);
		}
		System.out.print(ld.get(0));
		ld.removeLast();
		ld.printDeque();
		//System.out.print(ld.sentinel.next.item);
	}
}