import java.io.File;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		File folder = new File("problems/");
		File[] listOfFiles = folder.listFiles();
		LinkedList<ChapterFileInfo> chapterFiles = new LinkedList<>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				chapterFiles.add(new ChapterFileInfo(listOfFiles[i].getName()));
			}
		}
		Collections.sort(chapterFiles);
		System.out.println(chapterFiles);
	}
}
