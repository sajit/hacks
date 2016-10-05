package design.book;

public interface BookReader {
	
	Page turnPage();
	void saveState();
	Page goToPage();

}
