package _08제네릭클래스;

import java.util.Arrays;

/*
 * 1. 추가 : add(value) 
 * 2. 삭제 : remove(idx) , remove(value) 
 * 3. 삽입 : add(idx, value) 
 * 4. 수정 : set(idx, value) 
 * 5. 갯수 : size 
 * 6. 값읽기 : get(idx) : 해당 인덱스의 값을 읽기
 * 7. 전체 삭제 : clear()
 */
class MyVector <T>{
	int[] arr;
	int size;
	int capacity;

	MyVector() {
		arr = new int[10];
		capacity = 10;
	}

	int size() {
		return size;
	}

	int capacity() {
		return capacity;
	}

	int get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return arr[idx];
	}

	void add(int val) {
		if (size >= capacity) {
			int[] temp = arr;
			arr = new int[capacity + 10];
			capacity += 10;
			for (int i = 0; i < size; i += 1) {
				arr[i] = temp[i];
			}
		}

		arr[size] = val;
		size += 1;
	}

	void add(int idx, int val) {
		if (idx < 0 || idx >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (size >= capacity) {
			int[] temp = arr;
			arr = new int[capacity + 10];
			capacity += 10;
			for (int i = 0; i < size; i += 1) {
				arr[i] = temp[i];
			}
		}
		for (int i = size; i > idx; i--) {
			arr[i] = arr[i - 1];
		}
		arr[idx] = val;
		size += 1;
	}

	void set(int idx, int val) {
		if (idx < 0 || idx >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		arr[idx] = val;
	}

	void remove(int idx) {
		if (idx < 0 || idx >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for (int i = idx; i < size; i++) {
			arr[i] = arr[i + 1];
		}
		arr[size] = 0;
		size -= 1;
	}

	void clear() {
		size = 0;
		arr = new int[capacity];
	}

	@Override
	public String toString() {
		if (size == 0)
			return "[]";
		String data = "[";
		for (int i = 0; i < size; i += 1) {
			data += arr[i] + ",";
		}
		data = data.substring(0, data.length() - 1);
		data += "]";
		return data;
	}
}

public class _02벡터클래스구현2 {
	public static void main(String[] args) {
		MyVector v1 = new MyVector();
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());

		for (int i = 0; i < 10; i += 1) {
			v1.add((i + 1) * 10);
		}

		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println(v1.get(1));

		v1.set(1, 1000);
		System.out.println(v1);

		v1.add(1, 20);
		System.out.println(v1);

		v1.remove(3);
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());

		v1.clear();
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
	}

}
