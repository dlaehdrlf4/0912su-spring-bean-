import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.GoodDao;
import dao.GoodDaoFactory;
import vo.GoodsVO;

public class Main {

	public static void main(String[] args) {
		//GoodDao 인스턴스를 생성
		//GoodDao dao = new GoodDao(); // 이제는 객체 생성을 못하도록한다.
		
		//GoodDao dao = GoodDaoFactory.create();
		
		//스프링을 이용해서 객체를 생성 - 싱글톤 패턴이 자동으로 적용
		GenericXmlApplicationContext  context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		GoodDao dao = context.getBean("goodDao", GoodDao.class);
		System.out.println(dao.hashCode());
		//필요한 메소드 호출
		List<GoodsVO> list = dao.getGood();
		//메소드 호출 결과 출력
		for(GoodsVO vo : list) {
			System.out.println(vo);
		}
		 
		dao = context.getBean("goodDao", GoodDao.class);
		System.out.println(dao.hashCode());
		context.close();
		
		
		

	}

}
