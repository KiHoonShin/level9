package 상속_개념;

abstract class Shape{
	abstract void draw();
}

class Line extends Shape{
	@Override
	void draw() {
		System.out.println("선을 긋는다");
	}
}

class Circle extends Shape{
	@Override
	void draw() {
		System.out.println("원을 그린다");
	}
}

class Point extends Shape{
	@Override
	void draw() {
			System.out.println("점을 찍는다");
	}
}

class Rect extends Shape{
	@Override
	void draw() {
		System.out.println("사각형을 그린다");
	}
}

class TriAngle extends Shape{
	@Override
	void draw() {
		System.out.println("삼각형을 그린다");
	}
}


public class _08추상클래스3 {

	public static void main(String[] args) {

		Rect[] menolist = new Rect[2]; // Rect 클래스만 올 수 있다.
		
		Shape[] list = {new Line(), new Circle(), new Point(), new Rect(), new TriAngle()};
		
		for(Shape shape : list) {
			shape.draw();
		}
	
		
		
		
	}

}
