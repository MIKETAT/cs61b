public class test {
	public static void main(String[] args) {
		ArrayDeque<Integer> ld = new ArrayDeque<>();
		ld.addFirst(0);
		ld.addLast(1);
		ld.addLast(2);
		ld.removeFirst();
		ld.removeLast();

		System.out.println(ld.get(0));
		ld.addLast(3);
		ld.addLast(4);
		ld.removeLast();
		ld.printDeque();
		//System.out.print(ld.sentinel.next.item);
	}
}