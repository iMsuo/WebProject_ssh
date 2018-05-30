package model.system;

/**
 * Listensub entity. @author MyEclipse Persistence Tools
 */
public class Listensub extends AbstractListensub implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Listensub() {
	}

	/** full constructor */
	public Listensub(Mp3 mp3, String listenoptionA, String listenoptionB,
			String listenoptionC, String listenoptionD, String trueAnswer) {
		super(mp3, listenoptionA, listenoptionB, listenoptionC, listenoptionD,
				trueAnswer);
	}

}
