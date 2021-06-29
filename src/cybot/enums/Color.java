package cybot.enums;

public enum Color {

	RESET("\033[0m"),
	RED("\033[0;31m"),
	GREEN("\033[0;32m"),
	YELLOW("\033[0;33m");
	
	private String color;
	
	Color(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public static String set(Color colorType, String message) {
		return colorType.getColor() + message + Color.RESET.getColor();
	}
	
	public static String get(Color colorType) {
		return colorType.getColor();
	}
	
}
