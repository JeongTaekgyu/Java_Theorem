# package와 import

## 1. package

\- 패키지란, 클래스의 묶음이다. 패키지에는 클래스 또는 인터페이스를 포함시킬 수 있으며, 서로 관련된 클래스들끼리 그룹 단위로 묶어 놓음으로써 클래스를 효율적으로 관리할 수 있다.

\- 같은 이름의 클래스 일지라도 서로 다른 패키지에 존재하는 것이 가능하므로, 자신만의 패키지 체계를 유지함으로써 다른 개발자가 개발한 클래스 라이브러리의 클래스와 이름이 충돌하는 것을 피할 수 있다.

<br>

## 2. import

\-소스코드를 작성할 때 다른 패키지의 클래스를 사용하려면 패키지명이 포함된 클래스 이름을 사용해야 한다.

하지만, 매번 패키지명을 붙여서 작성하기란 여간 불편한 일이 아니다.

클래스의 코드를 작성하기 전에 import문으로 사용하고자 하는 클래스의 패키지를 미리 명시해주면 소스코드에 사용되는 클래스이름에서 패키지명은 생략할 수 있다.

\- eclipse 단축키 : crtl + shift + o (자동으로 import문을 추가해준다.)

\- 클래스 이름을 지정해주는 대신 '*' 을 사용하면, 컴파일러는 해당 패키지에서 일치하는 클래스이름을 찾아야 하는 수고를 더 해야 할 것이다. **실행 시 성능상의 차이는 전혀 없다.**

ex)

import java.util.Calender;
import java.util.Date;
import java.util.ArrayList;

이처럼 import문을 여러 번 사용하는 대신 아래와 같이 한 문장으로 처리할 수 있다.

import java.util.*;

\- 하지만 import 하는 패키지의 수가 많을 때는 어느 클래스가 어느 패키지에 속하는지 구별하기 어렵다는 단점이 있다.

\- 한 가지 더 알아두어야 할 것은 import문에서 클래스의 이름 대신 '*'을 사용하는 것이 하위 패키지의 클래스까지 포함하는 것은 아니라는 것이다.

import java.util.\*;
import java.text.\*;

그래서 위의 두 문장 대신 다음과 같이 할 수 는 없다.

import java.\*;

<br>

## 3. static import문

import문을 사용하면 클래스의 패키지명을 생략할 수 있는 것과 같이 static import문을 사용하면 static 멤버를 호출할 때 클래스 이름을 생략할 수 있다.

특정 클래스의 static 멤버를 자줒 사용할 때 편리하다. 그리고 코드도 간결해 진다.

ex)

import static java.lang.Integer.*;			// Integer클래스의 모든 static 메소드
import static java.lang.Math.randon;	// Math.random()만. 괄호 안붙임.
import static java.lang.System.out;		// System.out을 out만으로 참조가능