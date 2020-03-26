package Class_And_Object;

public class EqualTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "hello";
		String b = a;
		String c = new String("hello");
		String d = new String("hello");
		
		Value3 v1 = new Value3(10);
		Value3 v2 = new Value3(10);
		/* 
		String 클래스는 equals 메서드를 오버라이딩 해서 사용하고 있다.
		'equals'는 객체가 가리키는 내용 자체를 비교하고
		 '==' 는 비교하고자 하는 대상의 주소값을 비교한다.
		
		★ 하지만 Value는 equals 메서드를 오버라이딩 하지 않았기 때문에 Object 클래스의 equals를 사용한다
		 
		Object 클래스의 equals 메서드의 실제 정의는 아래와 같다.
		
		 public boolean equals (Object obj) {
		 	return (this == obj);
		 }
 		 즉, 두 객체의 같고 다름을 참조변수의 값으로 판단한다. 그렇기 때문에 서로 다른 두 객체를 equals 메서드로 비교하면 항상 false를 얻는다.
 		★  하지만 String 클래스의 eqauls는 참조주소가 아니라 문자열 자체가 같은지를 비교한다.
		 */
		System.out.println(a.equals(b));	// true
		System.out.println(a == b);			// true
		System.out.println(a == c);			// false
		System.out.println(a.equals(c));	// true
		System.out.println(c.equals(d));	// true
		// 출력 값은
		System.out.println("v1 : " + v1 + "v1.value : " + v1.value);
		System.out.println("----------Value 비교----------");
		System.out.println(v1.equals(v2));		// false
		System.out.println(v1 == v2);			// false
		System.out.println(v1.value == v2.value);// true
		System.out.println("v2 = v1 이후");			
		v2 = v1;
		System.out.println(v1.equals(v2));	// true
		System.out.println(v1 == v2);		// true
	}
}
class Value3{
	int value;
	
	Value3(int value)
	{
		this.value = value;
	}
}
