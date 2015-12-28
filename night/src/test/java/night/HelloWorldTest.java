package night;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void test(){
		
		HelloWorld helloWorld = new HelloWorld();
		
		String result = helloWorld.sayHello();
		
		System.out.println(result);
	}
	
}
