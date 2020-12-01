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

public class Main {

	public static void main(String[] args) {
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
		driver.get("https://unsplash.com/");
		
		
		//imgDownloads라는 폴더가 없을 경우 생성
		File downloadsFolder = new File("imgDownloads");
		
		if ( downloadsFolder.exists() == false ) {
			downloadsFolder.mkdir();
		}
		
		//원하는 엘리먼트들 가져오기
		//엘리먼트들의 계보를 확인해서 css선택자 방식으로 원하는 엘리먼트 지정
		List<WebElement> elements = driver.findElements(By.cssSelector("[data-test=\"masonry-grid-count-three\"] img"));
	
		//로딩 시간 부여
		//설정된 millis초 단위 만큼 쉬는 것
		Util.sleep(1000);
		
		for(WebElement element : elements) {
			String src = element.getAttribute("src"); 
			 				//getAttribute = 원하는 속성을 가져오기
							//getText = 글자를 가져온다 등
			
			//만약 images.unsplash.com/photo-라는 내용이 없으면 가져오기 X(즉, 이미지만 가져오기 위한 걸러내기)
			if (src.contains("images.unsplash.com/photo-") == false) {
				continue;
			}
			
			//System.out.println(src);
			
			
			
			//이미지 엘리먼트 다운로드
			BufferedImage saveImage = null;
			
			try {
				saveImage = ImageIO.read(new URL(src));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(saveImage != null) {
				try {
			//이미지 주소 : https://images.unsplash.com/photo-1602524815375-a54449bb00fb?ixid=MXwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHw5fHx8ZW58MHx8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80
			//"/"기준으로 1차 분할
			//1차 분할 결과 중 "?"기준으로 2차 분할
			//결과 : photo-1602524815375-a54449bb00fb
					String fileName = src.split("/")[3];
					fileName = fileName.split("\\?")[0];
					ImageIO.write(saveImage, "jpg", new File("imgDownloads/"+ fileName + ".jpg"));
					//write: 저장하다
				} catch (IOException e) {
					// TODO: handle exception
				}
			}
			
			System.out.println(src);
			
		}
		
		
		
	}

}
