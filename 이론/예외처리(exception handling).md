# 예외처리(exception handling)

## 1. 프로그램 오류

프로그램이 실행 중 어떤 원인에 의해서 오작동을 하거나 비정상적으로 종료되는 경우 이러한 결과를 초래하는 원인을 에러 또는 오류라고 하는데

이를 발생 시점에따라 에러를 나눌 수있다.

`'컴파일 에러(compile-time error)'`란 컴파일 시에 발생하는 에러이고

`'런타임 에러(runtime error)'`란 실행 시에 발생하는 에러이다.

`'논리적 에러(logical error)'`란 실행은 되지만, 의도와 다르게 동작하는 것이다.

<br>

소스코드를 컴파일 하면 컴파일러가 소스코드(.java)에 대해 오타나 잘못된 구문, 자료형 체크 등의 기본적인 검사를 수행하여 오류가 있는지를 알려준다. 컴파일러가 알려 준 에러들을 모두 수정해서 컴파일을 성공적으로 마치고 나면, 클래스 파일(*.class)이 생성되고, 생성된 클래스 파일을 실행할 수 있게 되는 것이다.

하지만 컴파일 에러가 없다고 해서 프로그램의 실행 시에도 에러가 발생하지 않는 것은 아니다.

실행 도중 발생할 수 있는 잠재적인 오류는 컴파일시 걸러줄 수 없기 때문에  실행 도중 발생하는 런타임 에러를 방지하기 위해서는 프로그램의 실행 도중 발생할 수 있는 모든 경우의 수를 고려하여 이에대한 대비를 하는 것이 필요하다.

자바에서는 실행 시(runtime)발생할 수 있는 프로그램 오류를 `'에러(error)'`와 `'예외(exception)'` 두 가지로 구분한다.

`'에러(error)'`는 프로그램 코드에 의해서 수습될 수 없는 심각한 오류

ex) 메모리 부족(OutOfMemoryError)나 스택오버플로우(StackOverflowError)이다.

`'예외(exception)'` 는 발생하더라고 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류이다.

<br>

<br>

## 2. 예외 클래스의 계층구조

자바에서는 실행시 발생할 수 있는 오류(Exception과 Error)를 클래스로 정의하였다.

모든 클래스의 조상은 Object클래스이므로 Exception과 Error클래스 역시 Object클래스의 자손들이다.

![Exception_Error_hierarchical_structure](https://user-images.githubusercontent.com/32161395/76871671-ae887c80-68ae-11ea-9e3e-e259bd9b89b4.png)

그림 1) 예외 클래스 계층도

<br>

<img width="270" alt="Exception_hierarchical_structure" src="https://user-images.githubusercontent.com/32161395/76872158-63229e00-68af-11ea-8384-18210a1426ae.png">

그림 2) Exception 클래스 계층도

`'Exception클래스'`들은 사용자의 실수와 같은 외적 요인에 의해 발생하는 예외이다.

`'RuntimeException클래스'`들은 프로그래머의 실수로 발생하는 예외이다.

ex) 배열의 범위를 벗어난다던가(ArrayIndexOutOfBoundsException),

값이 null인 참조변수의 멤버를 호출하려 했다던가(ClassCastException),

정수를 0으로 나누려고(ArithmeticException)하는 경우에 발생한다.

<br>

## 3. 예외처리하기 - try-catch문

프로그램의 실행도중에 발생하는 에러는 어쩔 수 없지만, 예외는 프로그래머가 잉 대한 처리를 미리 해주어야 한다.

`'예외처리(Exception handling)'의`

정의 - 프로그램 실행 시 발생할 수 있는 예외에 대비한 코드를 작성하는 것

목적 - 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것

발생한 예외를 처리하지 못하면, 프로그램은 비정상적으로 종료되며, 처리되지 못한 예외(uncaught exception)는 JVM의 '예외처리기(UncaughtExceptionHandler)'가 받아서 예외의 원인을 화면에 출력한다.

**예외를 처리하기 위해서는 try-catch문을 사용하며 구조는 다음과 같다**

```java
try{
	// 예외가 발생할 가능성이 있는 문장들을 넣는다.
} catch (Exception e1) {
	// Exception1이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
} catch (Exception e2) {
	// Exception2이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
} catch (Exception eN) {
	// ExceptionN이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
}
```

\- 하나의 try블럭 다음에는 여러 종류의 예외를 처리할 수 있도록 하나 이상의 catch블럭이 올 수 있으며, 이 중 발생한 예외의 종류와 일치하는 단 한개의 catch블럭만 수행된다.

\- 발생한 예외의 종류와 일치하는 catch블럭이 없으면 예외는 처리되지 않는다.

<br>

```java
class ExceptionEX1{
	public static void main(String[] args){
        try {
            try{	} catch (Exception e) {	}
        } catch (Exception e){
            try{	} catch (Exception e) {	}	// 에러, 변수 e가 중복 선언되었다.
        } // try - catch의 끝
        
        try {
            
        } catch( Exception e) {
            
        } // try-catch의 끝
    } // main메서드의 끝
}
```

\- 한개의 method 내에서 여러개의 try-catch문이 사용될 수 있으며, try블럭 또는 catch블럭에 또다른 try-catch가 포함될 수 있다.

\- 그러나 catch블럭 내에 또 하나의 try-catch문이 포함된 경우, 같은 이름의 참조변수를 사용해서는 안 된다.

(각 catch블럭에 선언된 두 참조변수의 영역이 서로 겹치므로 다른 이름을 사용해야만 서로 구별되기 때문이다.)

<br>

## 4. try-catch문에서의 흐름

try - catch문에서, 예외가 발생한 경우와 발생하지 않았을 때의 흐름(문장의 실행순서)

​	▶ **try 블럭 내에서 예외가 발생한 경우**

		1. 발생한 예외와 일치하는 catch블럭이 있는지 확인한다.
  		2. 일치하는 catch 블럭을 찾게 되면, 그 catch 블럭 내의 문장들을 수행하고 전체 try-catch 문을 빠져나가서 그 다음 문장을 계속해서 수행한다. 만일 일치하는 catch 블럭을 찾지 못하면, 예외는 처리되지 못한다.

​	▶ **try 블럭 내에서 예외가 발생하지 않은 경우**

	1. catch블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.

<br>

## 5. 예외의 발생과 catch블럭

```java
class ExceptionEx7 {
	public static void main(String args[]) {
		System.out.println(1);			
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	// 0으로 나눠서 ArithmeticException을 발생시킨다.
			System.out.println(4); 		// 실행되지 않는다.
		} catch (ArithmeticException ae)	{
			if (ae instanceof ArithmeticException) 
				System.out.println("true");	
			System.out.println("ArithmeticException");
		} catch (Exception e)	{ // ArithmeticException 에러  
			System.out.println("Exception");
		}	// try-catch의 끝
		System.out.println(6);
	}	// main메서드의 끝
}
```

```java
// 실행결과
1
2
3
true
ArithmeticException
6
```

<br>

### - printStackTrace()와 getMessage()

예외가 발생했을 때 생성되는 예외 클래스의 인스턴스에는 발생한 예외에 대한 정보가 담겨 있다.

**getStackTrace()** : 예외발생 당시의 호출스택(Call Stack)에 있었던 메소드의 정보와 예외 메시지를 화면에 출력한다.

**getMessage()** : 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.

```java
class ExceptionEx8 {
	public static void main(String args[]) {
		System.out.println(1);			
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); // 예외발생!!!
			System.out.println(4); 	 // 실행되지 않는다.
		} catch (ArithmeticException ae)	{
			ae.printStackTrace(); // 참조변수 ae를 통해, 생성된 ArithmeticException인스턴스에 접근할 수 있다.
			System.out.println("예외메시지 : " + ae.getMessage());
		}	// try-catch의 끝
		System.out.println(6);
	}	// main메서드의 끝
}
```

```java
// 실행결과
1
2
3
java.lang.ArithmeticException: / by zero
	at ExceptionEx8.main(ExceptionEx8.java:7)
예외메시지 : / by zero
6
```

<br>

### - 멀티 catch 블럭

JDK1.7부터 여러 catch블럭을 '|' 기호를 이용해서 하나의 catch블럭으로 합칠수 있게 되었으며, 이를 '멀티 catch블럭'이라 한다.

```java
try{
    ...
} catch ( ExceptionA e) {
    e.printStackTrace();
} catch ( ExceptionB e2) {
    e2.printStackTrace();
}
```

를 아래와 같이 바꿀 수 있다.

```java
try {
	...
} catch ( ExceptionA | ExceptionB e) {
	e.printStackTrace();
}
```

만일 멀티 catch 블럭의 '|' 기호로 연결된 예외 클래스가 조상과 자손의 관계에 있다면 컴파일 에러가 발생한다.

```
try {
	...
} catch (ParentException | ChildException e) { // 에러 !
	e.printStackTrace();
}
```

왜냐하면, 두 예외 클래스가 조상과 자손의 관계에 있다면, 그냥 다음과 같이 조상 클래스만 써주는 것과 똑같기 때문이다.

```java
try {
    ...
} catch (ParentException e) {
    e.printStackTrace();
}
```

<br>

## 6 예외 발생시키기

프로그래머가 고의로 예외를 발생시킬 수 있는 방법이다.

1. 먼저, 연산자 new를 이용해서 발생시키는 예외 클래스의 객체를 만든 다음 Exception e = new Exception("고의로 발생시켰음");
2. 키워드 throw를 이용해서 예외를 발생시킨다.

<br>

## 7. 메서드에 예외 선언하기

예외를 처리하는 방법에는 지금까지 배워 온 try-catch문을 사용하는 것 외에 예외를 메서드에 선언하는 방법이 있다.

메서드에 예외를 선언하려면, 메서드의 선언부에 키워드 throws를 사용해서 메서드 내에서 발생할 수 있는 예외를 적어주기만 하면 된다. 그리고 예외가 여러 개일 경우에는 쉽표(,)로 구분한다.

```java
void method() throws Exceptoin1, Exception2, ... ExceptionN {
	// 메서드의 내용
}
```

만일 아래와 같이 모든 예외의 최고조상인 Exception클래스를 메서드에 선언하면, 이 메서드는 모든 종류의 예외가 발생할 가능성이 있다는 뜻이다.

```java
void method() throws Exception {
	// 메서드의 내용
}
```

이렇게 예외를 선언하면, 이 예외뿐만 아니라 그 자손타입의 예외까지도 발생할 수 있다는 점에 주의하자

오바러아딩에서 살펴본 것과 같이, 오버라이딩할 때는 단순히 선언된 예외의 개수가 아니라 상속관계까지 고려해야한다.

메서드의 선언부에 예외를 선언함으로써 메서드를 사용하려는 사람이 메서드의 선언부를 보았을 때, 이 메서드를 사용하기 위해서는 어떠한 예외들이 처리되어져야 하는지 쉽게 알 수 있다.

<br>

## 8. finally 블럭

finally 블럭은 예외의 발생여부에 상관없이 실행되어야할 코드를 포함시킬 목적으로 사용된다.

```java
try {
    // 예외가 발생할 가능
} catch ( Exception1 e1)
{
    // 예외처리를 위한 문장을 적는다.
} finally {
    // 예외의 발생여부에 관계없이 항상 수행되어야하는 문장들을 넣는다.
    // finally 블럭은 try-catch문의 맨 마지막에 위치해야 한다.
}
```

<br>

**참고로 try블럭이나 catch블럭 문장 수행중에 return문이 실행되는 경우에도 fianally 블럭의 문장들이 먼저 실행된 후에, 현재 실행 중인 메서드를 종료한다.**

```java
class FinallyTest3 {
	public static void main(String args[]) {
		// method1()은 static메서드이므로 인스턴스 생성없이 직접 호출이 가능하다.
		FinallyTest3.method1();		
        System.out.println("method1()의 수행을 마치고 main메서드로 돌아왔습니다.");
	}	// main메서드의 끝

	static void method1() {
		try {
			System.out.println("method1()이 호출되었습니다.");
			return;		// 현재 실행 중인 메서드를 종료한다.
		}	catch (Exception e)	{
			e.printStackTrace();
		} finally {
			System.out.println("method1()의 finally블럭이 실행되었습니다.");
		}
	}	// method1메서드의 끝
}
```



