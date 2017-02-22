import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Chapter implements Comparable<Chapter> {
	private String fileName;
	private String chapterName;
	private int chapterNumber;
	private LinkedList<Problem> chapterProblems;

	public Chapter(String folderName,String fileName) {
		this.fileName = fileName;
		String[] splitted = fileName.split("_");
		this.chapterName = getChapterName(splitted[1]);
		this.chapterNumber = Integer.parseInt(splitted[0]);
		this.chapterProblems = new LinkedList<>();
		try {
			generateChapterProblems(folderName+"/" + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void generateChapterProblems(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner sc = new Scanner(file);
		int indexInChapter = 1;
		int indexInSubChapter = 1;
		while (sc.hasNextLine()) {
			String l = sc.nextLine();
			if (l.length() == 0 || l.charAt(0) == ' ') {
				// New line Separator => New sub chapter
				indexInSubChapter = 1;
				continue;
			}
			this.chapterProblems.push(new Problem(l, indexInChapter, indexInSubChapter));
			indexInChapter++;
			indexInSubChapter++;
		}
		sc.close();
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
	public int compareTo(Chapter o) {
		return Integer.compare(chapterNumber, o.chapterNumber);
	}

	@Override
	public String toString() {
		return this.chapterNumber + "-" + this.chapterName + " " + chapterProblems.size();
	}

	public int getProblemsCount() {
		return this.chapterProblems.size();
	}

}
