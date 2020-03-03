# 제어자(modifier)

제어자(modifier)는 클래스, 변수 또는 메소드의 선언부에 함께 사용되어 부가적인 의미를 부여한다.

접근 제어자 - public, protected, default, private

그 외			 - static, final, abstract, native, transient, synchronized, volatile, strictfp

제어자는 클래스나 멤버변수와 메소드에 주로 사용되며, 하나의 대상에 대해서 여러 제어자를 조합하여 사용하는 것이 가능하다.

단, 접근 제어자는 한 번에 네 가지 중하나만 선택해서 사용할 수 있다.



### 1. static - 클래스의, 공통적인

인스턴스 변수는 하나의 클래스로부터 생성되었더라도 각기 다른 값을 유지하지만, 클래스변수(static 멤버변수)는 인스턴스에 관계없이 같은 값을 갖는다. 그 이유는 하나의 변수를 모든 인스턴스가 공유하기 때문이다.

static이 붙은 멤버변수와 메서드, 그리고 초기화 블럭인 인스턴스가 아닌 클래스에 관계된 것이기 때문에 인스턴스를 생성하지 안고도 사용할 수 있다.

인스턴스메소드와 static메소드의 근본적인 차이는 메소드 내에서 인스턴스 멤버를 사용하는가의 여부에 있다.

(static 메소드 내에서는 인스턴스 멤버들을 직접 사용할 수 없다.)

static이 사용될 수 있는 곳 - 멤버변수, 메소드, 초기화 블록

| 제어자 | 대상     | 의미                                                         |
| ------ | -------- | ------------------------------------------------------------ |
| static | 멤버변수 | - 모든 인스턴스에 공통적으로 사용되는 클래스변수가 된다.<br />- 클래스변수는 인스턴스를 생성하지 않고도 사용가능하다.<br />- 클래스가 메모리에 로드될 때 생성된다 |
| static | 메소드   | - 인스턴스를 생성하지 않고도 호출이 가능한 static 메소드가 된다.<br />- static메소드 내에서는 인스턴스멤버들을 직접 사용할 수 없다. |

ex)

class StaticTest{
	static int width = 200;		// 클래스 변수(static변수)
	static int height = 200;	// 클래스 변수(static변수)

​	static {
​		// static변수의 복잡한 초기화 수행
​	}
​	static int max(int a, int b) {	// 클래스 메소드(static메소드)
​		return a > b ? a : b;
​	}
}

<br>

## 2. final - 마지막의, 변경될 수 없는

final이 변수에 사용되면 값을 변경할 수 없는 상수가 되며, 메소드에 사용되면 오버라이딩을 할 수 없게되고, 클래스에 사용되면 자신을 확장하는 자손클래스를 정의하지 못하게 된다.

| 제어자 | 대상     | 의미                                                         |
| ------ | -------- | ------------------------------------------------------------ |
| final  | 클래스   | - 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다.<br />- 그래서 final로 지정된 클래스는 다른 클래스의 조상이 될 수 없다. |
| final  | 메소드   | - 변경될 수 없는 메소드, final로 지정된 메소드는 오버라이딩을 통해 재정의 될 수 없다. |
| final  | 멤버변수 | - 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다. |
| final  | 지역변수 | - 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다. |

ex)

final class FianlTest{				// 조상이 될 수 없는 클래스
	final int MAX_SIZE = 10;		// 값을 변경할 수 없는 멤버변수 (상수)

​	final void getMaxSize() {		// 오버라이딩할 수 없는 메소드 (변경불가)
​		final int LV = MAX_SIZE;	// 값을 변경할 수 없는 지역변수 (상수)
​		return MAX_SIZE;
​	}
}

<br>

생성자를 이용한 final멤버 변수의 초기화

final이 붙은 변수는 상수이므로 일반적으로 선언과 초기화를 동시에 하지만, 인스턴스변수의 경우 생성자에서 초기화 되도록 할 수 있다.

클래스 내에 매개변수를 갖는 생성자를 선언하여, 인스턴스를 생성할 때 final이 붙은 멤버변수를 초기화하는데 필요한 값을 생성자의 매개변수로부터 제공받는 것이다.

이 기능을 활용하면 각 인스턴스 마다 final 이 붙은 멤버변수가 다른 값을 갖도록 하는 것이 가능하다.

ex)

class Card {
	final int NUMBER;		// 상수지만 선언과 함께 초기화 하지 않고
	final String KIND;		// 생성자에서 단 한번만 초기화할 수 있다.
	static int width  = 100;	
	static int height = 250;

​	Card(String kind, int num) {	
​		KIND = kind;
​		NUMBER = num;
​	}

​	Card() {
​		this("HEART", 1);
​	}

​	public String toString() {
​		return KIND +" "+ NUMBER;
​	}
}

class FinalCardTest {
	public static void main(String args[]) {
		Card c = new Card("HEART", 10);
//		c.NUMBER = 5;	// 이렇게 하면 에러 발생함(cannot assign a value to fianl variable NUMBER)
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c); // System.out.println(c.toString());
	}
}

<br>

## 3. abstract - 추상의, 미완성의

abstract가 사용될 수 있는 곳 - 클래스, 메소드

| 제어자   | 대상   | 의미                                                         |
| -------- | ------ | ------------------------------------------------------------ |
| abstract | 클래스 | 클래스 내에 추상 메소드가 선언되어 있음을 의미한다.          |
| abstract | 메소드 | 선언부만 작성하고 구현부는 작성하지 않은 추상 메소드임을 알린다. |

