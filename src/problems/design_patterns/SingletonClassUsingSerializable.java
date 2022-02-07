package problems.design_patterns;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SingletonClassUsingSerializable implements Serializable {

	private static final long serialVersionUID = -911919191919L;
	private static SingletonClassUsingSerializable mSingletonClassUsingSerializable;

	public static SingletonClassUsingSerializable getSingletonClassUsingSerializable() {
		if (null == mSingletonClassUsingSerializable) {
			synchronized (SingletonClassUsingSerializable.class) {
				mSingletonClassUsingSerializable = new SingletonClassUsingSerializable();
			}
		}
		return mSingletonClassUsingSerializable;
	}

	private Object readResolve() {
		return mSingletonClassUsingSerializable;
	}

	private void readObject(ObjectInputStream ois) {
		try {
			ois.defaultReadObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		mSingletonClassUsingSerializable = this;
	}

}
