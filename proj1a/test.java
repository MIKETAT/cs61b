public class test {
	public static void main(String[] args) {
		LinkedListDeque<Integer> ld = new LinkedListDeque<>();
		ld.addLast(0);
		ld.addLast(1);
        ld.addLast(2);
		ld.removeLast();
		ld.printDeque();
		//System.out.print(ld.sentinel.next.item);
	}
}