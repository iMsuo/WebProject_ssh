package service.system;

import java.util.List;

import model.system.Words;

import dao.system.WordsDao;

public class WordsService {
	private WordsDao wordsDao;
	
	public WordsDao getWordsDao() {
		return wordsDao;
	}

	public void setWordsDao(WordsDao wordsDao) {
		this.wordsDao = wordsDao;
	}

	public List<Words> testwordsservices()
	{
		return wordsDao.testwordsdao();
	}
}
