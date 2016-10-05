package design.book;

import java.util.Optional;

public class SimpleBookReader implements BookReader {

	int currentPage;
	Book book;
	public SimpleBookReader(Book book,Optional<Integer> savedPage){
	  this.book = book;
	  this.currentPage = savedPage.map(Integer::intValue).orElse(0);
	  
	}
	@Override
	public Page turnPage() {
		this.currentPage +=1;
		return goToPage();

	}

	@Override
	public void saveState() {
		System.out.println("Saving in console.log " + this.currentPage);
		// TODO Auto-generated method stub

	}

	@Override
	public Page goToPage() {
		
		return this.book.getPage(currentPage);
	}

}
