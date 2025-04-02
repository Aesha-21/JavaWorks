package spring.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;

public class CounterAdvice implements MethodBeforeAdvice{

	private Map<String, Integer> counter;
	
	public void any() {
		System.out.println("Initiating counter...");
		counter = new HashMap<String, Integer>();
		
	}
	
	
	public void any1() {
		
		System.out.println("Counters..."+counter);
	}
	
	
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Method="+method.getName()+"with agrs= "+Arrays.toString(args));
		
		String methodName =method.getName();
		if(counter.containsKey(methodName))
		{
			counter.put(methodName, counter.get(methodName)+1);
		}else
		{
			counter.put(methodName, 1);
		}
		
	}

}
