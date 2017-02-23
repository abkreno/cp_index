import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * Example of a problem data entry =>
 * 1. UVa 00272 - TEX Quotes (replace all double quotes to TEX() style quotes)
 *
 */
public class Problem {

	private String name;
	private String hint;
	private String judgeName;
	private int id;
	private int indexInSubChapter;
	private int indexInChapter;
	private String problemLink;
	private LinkedList<String> problemSolutionsLink;

	Problem(String dataEntry, int indexInChapter, int indexInSubChapter) {
		String splitted[] = dataEntry.split("-");
		this.hint = splitted[1];
		String searchQuery = splitted[0].split("\\.")[1];
		try {
			readProblemData(searchQuery);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readProblemData(String searchQuery) throws UnsupportedEncodingException, IOException {
		String google = "http://www.google.com/search?q=";
		String search = searchQuery;
		String charset = "UTF-8";
		String userAgent = "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)";
		Elements links = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get()
				.select(".g>.r>a");

		for (Element link : links) {
			String title = link.text();
			String url = link.absUrl("href"); // Google returns URLs in format
												// "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
			url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

			if (!url.startsWith("http")) {
				continue; // Ads/news/etc.
			}

			System.out.println("Title: " + title);
			System.out.println("URL: " + url);
		}
	}

	// ************* GETTERS AND SETTERS ****************
	public String getName() {
		return name;
	}

	public String getHint() {
		return hint;
	}

	public String getJudgeName() {
		return judgeName;
	}

	public int getId() {
		return id;
	}

	public int getIndexInSubChapter() {
		return indexInSubChapter;
	}

	public int getIndexInChapter() {
		return indexInChapter;
	}

	public String getProblemLink() {
		return problemLink;
	}

	public LinkedList<String> getProblemSolutionsLink() {
		return problemSolutionsLink;
	}

}
