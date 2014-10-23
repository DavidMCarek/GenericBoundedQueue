package queue;

public class Queue<T>
{
	final private int DEFAULT_ARRAY_SIZE  = 10;
	
	T[] queueArray;
	int frontOfQueue = -1;
	int rearOfQueue = -1;
	int currentArraySize;
	
	public Queue()
	{
		queueArray = (T[]) new Object[DEFAULT_ARRAY_SIZE];
		currentArraySize = DEFAULT_ARRAY_SIZE;
	}
	
	public Queue(int arraySize)
	{
		queueArray = (T[]) new Object[arraySize];
		currentArraySize = arraySize;
	}
	
	public boolean isFull()
	{
		return ((rearOfQueue + 1) % currentArraySize) == frontOfQueue;
	}
	
	public boolean isEmpty()
	{
		return (frontOfQueue == -1);
	}
	
	public void enqueue(T newInfo) throws QueueOverflowException
	{
		if (isEmpty())
		{
			frontOfQueue = 0;
			rearOfQueue = 0;
			queueArray[frontOfQueue] = newInfo;
		}
		else if(isFull())
		{
			throw new QueueOverflowException("Cannot enqueue a full queue");
		}
		else
		{
			queueArray[(rearOfQueue + 1) % currentArraySize] = newInfo;
			rearOfQueue = (rearOfQueue + 1) % currentArraySize;
		}
	}
	
	public T dequeue() throws QueueUnderflowException
	{
		if (!isEmpty())
		{
			T frontSlotData = queueArray[frontOfQueue];
			
			if (frontOfQueue == rearOfQueue)
			{
				frontOfQueue = -1;
				rearOfQueue = -1;
			}
			else
				frontOfQueue = (frontOfQueue + 1) % currentArraySize;
			
			return frontSlotData;
		}
		else
			throw new QueueUnderflowException("Cannot dequeue an empty queue");
	}
}
