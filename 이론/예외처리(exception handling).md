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

