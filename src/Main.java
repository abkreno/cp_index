import java.io.File;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws UnknownHostException {
		File folder = new File("test_problem/");
		File[] listOfFiles = folder.listFiles();
		LinkedList<Chapter> chapterFiles = new LinkedList<>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				chapterFiles.add(new Chapter("test_problem", listOfFiles[i].getName()));
			}
		}
		Collections.sort(chapterFiles);
		int totalProblems = 0;
		for (Chapter chapter : chapterFiles) {
			totalProblems += chapter.getProblemsCount();
		}
		DBHandler dbHandler = new DBHandler();
		dbHandler.insertDataToDB(chapterFiles);

		System.out.println(chapterFiles);
		System.out.println(totalProblems);
	}

}
