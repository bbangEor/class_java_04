package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetCliment {

	public static void main(String[] args) {

		// 자바 기본코드로 http 요청을 만들기 !

		// http 통신을 하기위한 준비물
		// 서버 주소 or 경로 준비
		String urlString = "https://jsonplaceholder.typicode.com/todos/5";

		// 1. URL 클래스 만들기
		// 2. Connection 객체를 만들기 (URL -> 멤버로 connection 객체를 뽑을 수 있다)
		try {
			URL url = new URL(urlString);
			// url.openConnection() 연결요청 진행
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// 추가 설정
			// METHOD 방식 설정 (약속) -- GET 요청은 해당서버의 자원요청이다!
			conn.setRequestMethod("GET");

			// HTTP 응답 메시지에서 데이터를 추출할 수 있다.
			int responseCode = conn.getResponseCode();
			System.out.println("HTTP CODE :" + responseCode);

			BufferedReader brIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String inputLine;
			StringBuffer responseBuffer = new StringBuffer();

			while ((inputLine = brIn.readLine()) != null) {
				responseBuffer.append(inputLine);
			}
			brIn.close(); // 자원 닫기

			// System.out.println(responseBuffer.toString());
			String[] strHtmls = responseBuffer.toString().split("\\s");
			System.out.println("index count : " + strHtmls.length);

			for (String word : strHtmls) {
				System.out.println(word);

			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
