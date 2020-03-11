# 다형성(polymorphism)

## 1. 다형성이란?

객체지향개념에서 다형성이란 '여러 가지 형태를 가질 수 있는 능력'을 의미하며, 자바에서는 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함으로써 다형성을 프로그램적으로 구현하였다.

이를 더 구체적으로 말하자면, **조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있도록 하였다.**

예제를 통해 자세히 알아보자

```java
class Tv{
	boolean power;	// 전원사애(on/off)
	int channel;	// 채널
	
	void power()		{	power = !power}
	void channelUp()	{	++channel;	}
	void channelDown()	{	--channel;	}
}
class CaptionTv extends Tv{
	String text;	// 캡션을 보여 주기 위한 문자열
	void caption()	{	/*내용생략*/}
}
```

Tv클래스와 CaptionTv클래스가 이와 같이 정의되어 있을 때, 두 클래스간의 관계를 그림으로 나타내면 아래와 같다.

<br>

![다형성그림1](https://user-images.githubusercontent.com/32161395/75988292-b05c5280-5f34-11ea-9c7f-5d31794d4861.jpg)

<br>

지금까지 우리는 생성된 인스턴스를 다루기 위해서, 인스턴스의 타입과 일치하는 참조변수만 사용했으나 이처럼 CaptionTv 인스턴스를 다루기 위해서는 CaptionTv타입의 참조변수를 사용했다.

```java
CaptionTv c = new CaptionTv();	// 인스턴스의 타입과 일치하는 참조변수 사용
Tv		  t = new CaptionTv();	// 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조
```

**★ 위 둘의 차이는? ★**

우선 참조변수 t로는 CaptionTv인스턴스의 모든 멤버를 사용할 수 없다.

Tv타입의 참조변수(t)로는 CaptionTv인스턴스 중에서 Tv클래스의 멤버들(상속받은 멤버포함)만 사용할 수 있다.

따라서 CaptionTv인스턴스 중에서 Tv클래스의 멤버들(상속받은 멤버포함)만 사용할 수 있다.

즉, t.text() 또는 t.caption()과 같이 할 수 없다.

둘 다 같은 타입의 인스턴스지만 참조변수의 타입에 따라 사용할 수 있는 멤버의 개수가 달라진다.



\- **반대로 아래와 같이 자손타입의 참조변수로 조상타입의 인스턴스를 참조하는 것은 가능할까?**

```java
CaptionTv c = new Tv();
```

그렇지 않다. 위 코드를 컴파일 하면 에러가 발생한다.

**그 이유**는 실제 인스턴스인 Tv의 멤버 개수보다 참조변수 c가 사용할 수 있는 멤버 개수가 더 많기 때문이다.

참조변수가 사용할 수 있는 멤버의 개수는 인스턴스의 개수보다 같거나 적어야한다.



**그렇다면 인스턴스 타입의 타입과 일치하는 참조변수를 사용하면 인스턴스의 멤버들을 모두 사용할 수 있을텐데 왜 조상타입의 참조변수를 사용해서 인스터스 일부 멤버만 을 사용하도록 할까?**

이는 곧 올라오는 자료에서 확인할 수 있다.

<br>

<br>

## 2. 참조변수의 형변환

```java
자손타입 -> 조상타입(Up-casting)	: 형변환 생략가능
자손타입 <- 조상타입(Down-casting)	: 형변환 생략불가
```

그 이유는  자손타입에서 조상타입으로 형변환할 때는 조상타입이 사용할 수 있는 멤버의 수가 더 적기 때문에

하지만 조상타입에서 자손타입으로 형변환할 때는 자손타입에서 사용할 수 있는 멤버가 더 많기 때문에

**참고로 형변환은 참조변수의 타입을 반환하는 것이지 인스턴스를 반환하는 것은 아니기 때문에 참조변수의 형변환은 인스턴스에 아무런 영향을 미치지 않는다.**

**단지 참조변수의 형변환을 통해서, 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 범위(개수)를 조절하는 것뿐이다.**

<br>

참고로

조상 : Tv

자손 : CaptionTv 에서

```java
Tv t = new CaptionTv(); // 는
Tv t = (Tv)new CaptionTv();	// 의 생략된 형태이다.
// 이는 아래 두 줄과 같다
CaptionTv c = new CaptionTv();
Tv t = (Tv)c;
```

<br>

아래 코드를 보자

```java
class CastingTest1 {
	public static void main(String args[]) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();
		car = fe;    // car =(Car)fe;에서 형변환이 생략된 형태다.
//		car.water(); // 컴파일 에러!!! Car타입의 참조변수로 water()를 호출할 수 없다.
		fe2 = (FireEngine)car; // 자손타입 ← 조상타입
		fe2.water();
	}
}

class Car {
	String color;
	int door;

	void drive() { 		// 운전하는 기능
		System.out.println("drive, Brrrr~");
	}

	void stop() {		// 멈추는 기능	
		System.out.println("stop!!!");	
	}
}

class FireEngine extends Car {	// 소방차
	void water() {		// 물을 뿌리는 기능
		System.out.println("water!!!");
	}
}
```

<br>

<br>

- 서로 상속관계에 있는 타입간의 형변환은 양방향으로 자유롭게 수행될 수 있으나, **참조변수가 가리키는 인스턴스의 자손타입으로 형변환은 허용되지 않는다.** 그래서 참조변수가 가리키는 인스턴스의 타입이 무엇인지 확인하는 것이 중요하다.

```java
class CastingTest2 {
	public static void main(String args[]) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;
  
		car.drive();
		fe = (FireEngine)car;		// 8번째 줄. 컴파일은 OK. 실행 시 에러가 발생
		fe.drive();
		car2 = fe;
		car2.drive();
	}
}
```

에러가 발생한 이유는 참조변수 car가 참조하고 있는 인스턴스가 Car타입의 인스턴스라는데 있다.

위에서 배운것 처럼 조상타입의 인스턴스를 자손타입의 참조변수로 참조하는 것은 허용되지 않는다.

<br>

<br>

## 3. instanceof 연산자

참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 instanceof연산자를 사용한다.

주로 조건문에 사용되며, instanceof의 왼쪽에는 참조변수를 오른쪽에는 타입(클래스명)이 피연산자로 위치한다.

그리고 연산의 결과로 boolean값인 true와 false 중의 하나를 반환한다.

instanceof를 이용한 연산결과로 true를 얻었다는 것은 참조변수가 검사한 타입으로 형변환이 가능하다는 것을 뜻한다.

ex)

```java
void doWork(Car c){
	if ( c instanceof FireEngine){
		FireEngine fe = (FireEngine)c;
		fe.water();
		...
	} else if(c instanceof Ambulance){
		Ambulance a = (Ambulance)c;
		a.siren();
		...
	}
	...
}
```

