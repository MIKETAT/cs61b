public class test {
	public static void main(String[] args) {
		ArrayDeque<Integer> ld = new ArrayDeque<>();
		for(int i = 0; i < 10; i++) {
			ld.addFirst(i);
		}
		for(int j = 0; j < 10; j++) {
			ld.removeFirst();
		}
		for(int k = 0; k < 10; k++) {
			ld.addFirst(k);
		}
		//System.out.print(ld.sentinel.next.item);
	}
}