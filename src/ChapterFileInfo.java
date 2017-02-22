public class ChapterFileInfo implements Comparable<ChapterFileInfo> {
	String fileName;
	String chapterName;
	int chapterNumber;

	public ChapterFileInfo(String fileName) {
		this.fileName = fileName;
		String[] splitted = fileName.split("_");
		this.chapterName = getChapterName(splitted[1]);
		this.chapterNumber = Integer.parseInt(splitted[0]);
	}

	private String getChapterName(String string) {
		String[] splitted = string.split("-");
		StringBuilder name = new StringBuilder();
		for (int i = 0; i < splitted.length; i++) {
			String s = splitted[i];
			name.append(s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
			if (i != splitted.length - 1)
				name.append(" ");
		}
		return name.toString();
	}

	@Override
	public int compareTo(ChapterFileInfo o) {
		return Integer.compare(chapterNumber, o.chapterNumber);
	}

	@Override
	public String toString() {
		return this.chapterNumber + "-" + this.chapterName;
	}
}
