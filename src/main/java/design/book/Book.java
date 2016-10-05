package design.book;

import java.util.List;

public class Book {
	
	public final String title;
	public final List<String> authors;
	private List<Chapter> chapters;
	
	public Book(String title,List<String> authors){
		this.title = title;
		this.authors = authors;
	}
	
	public List<Chapter> chapters(){
		return this.chapters;
	}
	
	public void addChapter(Chapter chapter){
		chapters.add(chapter);
	}
	
	public Page getPage(int num){
		for(Chapter chapter : chapters){
			int endNum = chapter.getEndPageNum();
			int startNum = chapter.getStartPageNum();
			if(num>= startNum && num <= endNum){
				return chapter.getPages().get(num-startNum-1);
			}
		}
		return null;
	}

}
