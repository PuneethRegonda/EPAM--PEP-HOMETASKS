import java.util.Arrays;

public class CustomList<E> {
	private int size=0;
	private static final int DEFAULT_SIZE=10;
	private Object container[];
	public CustomList()
	{
		this.container=new Object[DEFAULT_SIZE];
	}
	public void add(E value)
	{
		if(this.size==this.container.length)
		{
			increaseCapacity();
		}
		this.container[size++]=value;
	}

	public void set(Integer index,E value)
	{
		if(this.size<index || index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			if(this.size==index)
			{
				if(this.size==this.container.length)
				{
					increaseCapacity();
				}
				increaseCapacity();
				this.container[size++]=value;
			}
			else
			{
				E valueToBePlaced=value;
				for(Integer traverse=index;traverse<size;traverse++)
				{
					E temp=(E)this.container[traverse];
					this.container[traverse]=valueToBePlaced;
					valueToBePlaced=temp;
				}
				this.add(valueToBePlaced);	
			}
		}
	}

	public E get(Integer index)
	{
		if(this.size<=index || index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			return (E)this.container[index];
		}
	}

	public E remove(Integer index)
	{
		if(this.size<=index || index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			E valueToBeReturned=(E)this.container[index];
			for(Integer traverse=index;traverse<this.size-1;traverse++)
			{
				this.container[traverse]=this.container[traverse+1];
			}				
			this.size--;
			return valueToBeReturned;
		}
	}

	private void increaseCapacity()
	{
		Integer newSize=this.container.length*2;
		this.container=Arrays.copyOf(this.container, newSize);
	}

	// returns "[...]" string
	public String toString()
	{
		String s="[";
		for(Integer traverse=0;traverse<this.size;traverse++)
		{
			s=s+this.container[traverse].toString();
			if(traverse!=this.size-1)
				s+=",";
		}
		s=s+"]";
		return s;
	}
}