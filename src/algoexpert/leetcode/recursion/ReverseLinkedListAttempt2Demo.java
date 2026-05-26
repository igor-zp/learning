package algoexpert.leetcode.recursion;

public class ReverseLinkedListAttempt2Demo {

	public static void main(String[] args) {
		ListNode2 listNode = new ListNode2(
			1, new ListNode2(
				2, new ListNode2(
					3, new ListNode2(
						4, new ListNode2(5, null)))));
		ListNode2 result = reverseList(listNode);
		System.out.println("List: " + result);
	}

	public static ListNode2 reverseList(ListNode2 head) {
		if (head.next == null) {
			return head;
		}

		ListNode2 newHead = reverseList(head.next);  // ← frame заморожується тут

		head.next.next = head; // ← продовжується тільки після повернення
		//4.next -> 3
		//3.next -> 2
		//відсутнійсть викликає StackOverflowError на toString коли System.out.printl 2⇄1
		//1 викликає toString у 2
		//2 викликає toString у 1
		// і так по кругу
		head.next = null;

		return newHead;

	}

}

class ListNode2 {
	int val;
	ListNode2 next;

	ListNode2() {}

	ListNode2(int val) {
		this.val = val;
	}

	ListNode2(
		int val,
		ListNode2 next
	) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		//викликає StackOverflowError у разі відсутносіті head.next = null; ( буде 2⇄1 )
		/*
		* Java викликає toString() на вузлі 4, який викликає toString() на вузлі 3,
		* який викликає на 2, який викликає на 1, який викликає на 2...
		* 2⇄1
		* 1⇄2
		* 2⇄1
		* StackOverflowError
		*
		* */

		return "ListNode2{" +
			"val=" + val +
			", next=" + next +
			'}';
	}
}

