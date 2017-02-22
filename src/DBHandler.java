import java.net.UnknownHostException;
import java.util.LinkedList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DBHandler {
	private MongoClient mongo;
	private DB db;
	private DBCollection chaptersCollection, problemsCollection;

	public DBHandler() throws UnknownHostException {
		this.mongo = new MongoClient("localhost", 27017);
		this.db = mongo.getDB("cp_index");
		this.chaptersCollection = db.getCollection("chapters");
		this.problemsCollection = db.getCollection("problems");
	}

	public void insertDataToDB(LinkedList<Chapter> chapterFiles) {

	}
}
