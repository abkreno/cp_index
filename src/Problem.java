import java.net.URL;

/*
 * Example of a problem data entry => 
 * 1. UVa 00272 - TEX Quotes (replace all double quotes to TEX() style quotes)
 * 
 */
public class Problem {
	String name;
	String hint;
	String judgeName;
	int id;
	int indexInSubChapter;
	int indexInChapter;
	URL link;

	Problem(String dataEntry, int indexInChapter, int indexInSubChapter, String fileName) {
		String splitted[] = dataEntry.split("-");
		if (splitted.length < 2) {
			System.out.println(fileName);
			System.out.println(dataEntry);
		}
		this.hint = splitted[1];
		String searchQuery = splitted[0].split("\\.")[1];
	}

}
