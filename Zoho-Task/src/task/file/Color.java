package task.file;

public enum Color {
	VIOLET(1),
    INDIGO(2),
    BLUE(3),
    GREEN(4),
    YELLOW(5),
    ORANGE(6),
    RED(7);
	
	private final int colorCode;

    Color(int colorCode) {
        this.colorCode = colorCode;
    }
    

    public int getColorCode() {
        return colorCode;
    }
}
