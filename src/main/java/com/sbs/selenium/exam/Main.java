package com.sbs.selenium.exam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sbs.selenium.exam.dto.Article;

public class Main {

	public static void main(String[] args) {
		//getSomeArticleListTestModel();
		underKgSiteArticleCrawling();
	}
	
	
	private static void underKgSiteArticleCrawling() {
				Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe");

				System.setProperty("webdriver.chrome.driver", path.toString());

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");  
				options.addArguments("disable-popup-blocking");  
				options.addArguments("disable-defult-apps");  

				ChromeDriver driver = new ChromeDriver(options);   
				
				//빈 탭 생성
//				driver.executeScript("window.open('about:blank','_blank');");
				
				//열린 탭 리스트 가져오기
//				List<String> tabs = new ArrayList<>(driver.getWindowHandles());

				//첫번째 탭으로 전환
//				driver.switchTo().window(tabs.get(0));
				
				//원하는 사이트 주소 입력
				driver.get("http://underkg.co.kr/freeboard");

				
				
				List<WebElement> elements = driver.findElements(By.cssSelector(".board_list tbody"));
			
				//로딩 시간 부여
				Util.sleep(1000);
				
				System.out.println("번호 / 제목 / 글쓴이 / 날짜 / 조회수 / 추천수");
				
				for(WebElement element : elements) {
					String no = element.findElement(By.cssSelector(".no")).getText();
//					String title = element.findElement(By.cssSelector("tr:not(.notice) td.title > a:first-child")).getText().trim();
//					String writer = element.findElement(By.cssSelector("tr:not(.notice) td.author  > a:first-child")).getText().trim();
//					String dateTime = element.findElement(By.cssSelector("tr:not(.notice) .time")).getText().trim();
//					int hit = Integer.parseInt(element.findElement(By.cssSelector("tr:not(.notice).readNum")).getText());
//					int recommand = Integer.parseInt(element.findElement(By.cssSelector("tr:not(.notice) .voteNum")).getText());

					System.out.println(no);
//					System.out.println(title);
//					Article article = new Article(no, title);
						
				}
				
		
	}


	private static void getSomeArticleListTestModel() {

	//운영체제 수준에서의 변수를 가져온다	
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe");
	//System.getProperty("user.dir")
	//시스템 변수
	//운영체제 수준에서의 변수를 가져온다
	//user.dir = "C:\work\sts-4.8.0.RELEASE-workspace\java-selenium-exam"

		//WebDriver 경로 설정
		System.setProperty("webdriver.chrome.driver", path.toString());
		//운영체제 수준에서 변수를 굽는다???
		
		//WebDriver 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");  //전체화면으로 실행
		options.addArguments("disable-popup-blocking");  //팝업 무시
		options.addArguments("disable-defult-apps");  //기본앱 사용 안함 ex)인터넷익스플로러, 엣지 등 기본앱 사용 x

		//WebDriver 객체 생성
		ChromeDriver driver = new ChromeDriver(options);   //설정된 옵션 값 주입
		
		//빈 탭 생성
		driver.executeScript("window.open('about:blank','_blank');");
		
		//열린 탭 리스트 가져오기
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());

		//첫번째 탭으로 전환
		driver.switchTo().window(tabs.get(0));
		
		//원하는 사이트 주소 입력
		driver.get("https://codeup.kr/problemsetsol.php?psid=23");
		
		
		//원하는 엘리먼트들 가져오기
		//엘리먼트들의 계보를 확인해서 css선택자 방식으로 원하는 엘리먼트 지정
		List<WebElement> elements = driver.findElements(By.cssSelector("[id=\"problemset\"] [class=\"left\"] a"));
	
		//로딩 시간 부여
		//설정된 millis초 단위 만큼 쉬는 것
		Util.sleep(1000);
		
		for(WebElement element : elements) {
			String src = element.getText(); 
			
			System.out.println(src);
			
		}
		
		
		
	}

}
