import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class ToDoList {
	private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask(Task task) {
		// Add code here
		if (task != null) {
			tasks.put(task.getDescription(), task);
		}
	}

	public void completeTask(String description) {
		// Add code here
		Task task = tasks.get(description);
		task.setComplete(true);
		tasks.put(task.getDescription(), task);

	}

	public boolean getStatus(String description) {
		// Add code here
		return tasks.get(description).isComplete();
	}

	public Task getTask(String description) {
		// Add code here
		return tasks.get(description);
	}

	public Task removeTask(String description) {
		// Add code here
		Task task = tasks.get(description);
		tasks.remove(description);
		return task;
	}

	public Collection<Task> getAllTasks() {
		return tasks.values();
	}

	public Collection<Task> getCompletedTasks() {
		// Add code here
		Collection<Task> result = new HashSet<Task>();
		for (Task task : getAllTasks()) {
			if (task.isComplete()) {
				result.add(task);
			}
		}
		return result;
	}
	
	public int getPriority(String description) {
		return tasks.get(description).getPriority();
	}
	
	public Collection<Task> filterPriority(int priority) {
		if (priority < 0 || priority > 5 ) {
			return null;
		}
		Collection<Task> result = new HashSet<Task>();
		for (Task task : getAllTasks()) {
			if (task.getPriority() == priority) {
				result.add(task);
			}
		}
		return result;
	}
}
