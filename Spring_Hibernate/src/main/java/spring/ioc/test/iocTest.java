package spring.ioc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.naming.factory.BeanFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.SimpleInterface;
import spring.ioc.UtilsBean;

class iocTest {

	@Test
	void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc.xml");

		SimpleInterface si = (SimpleInterface) ctx.getBean("si");
		assertEquals(200, si.compute(200, 20, 5));

		System.out.println(ctx.getBean("p"));
		System.out.println(ctx.getBean("p1"));
		System.out.println(ctx.getBean("line"));
		System.out.println(ctx.getBean("line1"));
		System.out.println(ctx.getBean("line2"));

		ctx.close();
	}

	@Test
	void parentchild() {
		ClassPathXmlApplicationContext parent = new ClassPathXmlApplicationContext("parent.xml");
		ClassPathXmlApplicationContext child = new ClassPathXmlApplicationContext(new String[] { "child.xml" }, parent);

		System.out.println(child.getBean("line"));

	}

	@Test
	void utilesTest() {
		ClassPathXmlApplicationContext utils = new ClassPathXmlApplicationContext("utils.xml");
		UtilsBean bean = (UtilsBean) utils.getBean("utils");
		bean.getPoints().forEach(t -> System.out.println(t));
		System.out.println(bean.getNames());

		System.out.println(bean.getNumbers());
		
		System.out.println(bean.getProps());
		
//		try {
//			SimpleInterface si = (SimpleInterface) utils.getBean("siAbs");
//			System.out.println(si.compute(100, 20, 30));
//			fail("No exception");
//		} catch (BeansException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		
		SimpleInterface si = (SimpleInterface) utils.getBean("si");
		System.out.println(si.compute(100, 20, 30));

	}

}
