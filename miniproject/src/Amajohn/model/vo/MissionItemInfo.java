package Amajohn.model.vo;

public class MissionItemInfo {
	// 메인 게임 생성물
	
	private boolean isTrash;		// 쓰레기 or 진열물품
	private boolean isOn;			// 맵 상 존재여부
	private int itemCtn;
	private final int ITEM_MAX=3;	// 최대 개수
	private int itemPosX;
	private int itemPosY;
	private int itemWholeLifetime;		// 생존시간
	private int itemRestLifetime;		// 남은 생존시간
	private int itemExp;
	
	// 생성자
	// setter & getter
}
