import java.util.ArrayList;
import java.util.Collection;

public class Task {
	private String description = null;
	private boolean isComplete = false;
	private int priority = 3;
	private ArrayList<Tag> list = new ArrayList<Tag>();
	
	public Task(String description) {
		super();
		this.description = description;
	}
	
	public Task(String description, boolean isComplete) {
		super();
		this.description = description;
		this.isComplete = isComplete;
	}
	
	public Task(String description, boolean isComplete, int priority) {
		if (priority < 1) {
			priority = 1;
		}
		if (priority > 5) {
			priority = 5;
		}
		this.description = description;
		this.isComplete = isComplete;
		this.priority = priority;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public void addTag(String name) {
		Tag tag = new Tag().getTag(name);
		list.add(tag);		
	}
	
	public void removeTag(String name) {
		Tag tag = new Tag().getTag(name);
		list.remove(tag);
	}
	public Collection<Tag> getTags(){
		return list;
	}

}
