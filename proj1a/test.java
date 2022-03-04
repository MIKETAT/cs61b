public class test {
	public static void main(String[] args) {
		LinkedListDeque<Integer> ld = new LinkedListDeque<>();
		ld.addFirst(0);
		ld.addFirst(1);
		ld.removeLast();
		ld.printDeque();
		//System.out.print(ld.sentinel.next.item);
	}
}