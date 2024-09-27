package spring.service.dice.test;
//'new'라는 키워드가 없음
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import spring.service.dice.play.Player02;
public class DiceTestAppUseSpring {
	public static void main(String[] args) {
		//ClassPathXmlApplicationContext
		/*
		BeanFactory factory = 
				new XmlBeanFactory(new FileSystemResource("./src/main/resources/config/diceservice.xml"));
		*/
		ClassPathXmlApplicationContext factory = 
				new ClassPathXmlApplicationContext("./config/diceservice.xml");
		/*
		::spring.service.dice.impl.DiceAImpl 생성자...
		::spring.service.dice.impl.DiceBImpl 생성자...
		::spring.service.dice.impl.DiceCImpl 생성자...
		이 부분이 미리 뜸 (프리 로딩 방식)
		 */
		
		//xml 하나씩 하면서 이곳에서 하나씩 테스트한다...
		//player01 빈은 A 주사위를 가지고 노는 빈...setter로 주입
		Player02 player01 = (Player02)factory.getBean("player01");
		player01.playDice(3);
		System.out.println("======================");
		System.out.println("선택된 주사위 수의 통합은 :"+ player01.getTotalValue());
		System.out.println("=============\n\n");
		
		
		Player02 player02 = (Player02)factory.getBean("player02");
		player02.playDice(3);
		System.out.println("======================");
		System.out.println("선택된 주사위 수의 통합은 :"+ player02.getTotalValue());
		System.out.println("=============\n\n");
		
		
		Player02 player03 = (Player02)factory.getBean("player03");
		player03.playDice(3);
		System.out.println("======================");
		System.out.println("선택된 주사위 수의 통합은 :"+ player03.getTotalValue());
		System.out.println("=============\n\n");
		
		
		Player02 player04 = (Player02)factory.getBean("player04");
		player04.playDice(3);
		System.out.println("======================");
		System.out.println("선택된 주사위 수의 통합은 :"+ player04.getTotalValue());
		System.out.println("=============\n\n");
	}
	
}//end of class