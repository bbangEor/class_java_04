package ch03;

public class  Plastic extends Material {

	@Override
	public String toString() {
		return " 재료는 플라스틱 입니다.";
	}
	
	public void doPrinting() {
		System.out.println("플라스틱 재료로 출력합니다.");
	}
}
