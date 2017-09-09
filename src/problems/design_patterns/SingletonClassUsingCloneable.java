package problems.design_patterns;
import java.io.Serializable;

public class SingletonClassUsingCloneable implements Cloneable {

	private static SingletonClassUsingCloneable mSingletonClassUsingSerializable;

	private SingletonClassUsingCloneable(){
		//
	}
	
	public static SingletonClassUsingCloneable getSingletonClassUsingSerializable() {
		if (null == mSingletonClassUsingSerializable) {
			synchronized (SingletonClassUsingCloneable.class) {
				mSingletonClassUsingSerializable = new SingletonClassUsingCloneable();
			}
		}
		return mSingletonClassUsingSerializable;
	}

	@Override
	protected Object clone()  {
		return getSingletonClassUsingSerializable();
	}
	
	public void doSomething(){
		System.out.println("doSomething()");
	}

}
