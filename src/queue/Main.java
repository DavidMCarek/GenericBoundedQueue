package queue;

public class Main
{

	public static void main(String[] args)
	{
		Queue<String> test = new Queue<String>();
		
		test.enqueue("Hello ");
		test.enqueue("my ");
		System.out.print(test.dequeue());
		System.out.print(test.dequeue());
		test.enqueue("name ");
		test.enqueue("is ");
		test.enqueue("David ");
		System.out.print(test.dequeue());
		System.out.print(test.dequeue());
		System.out.print(test.dequeue());	
	}

}
