package personalOrganiser;

import java.util.ArrayList;

/**
 * Defines a TodoList object. Used to store and track {@link Task} objects.
 * @author Alexander
 * @version 1.0
 */
public class TodoList {
	
	private ArrayList<Task> tasks = new ArrayList<Task>();
	
	public TodoList(Task task) {
		this.tasks.add(task);
	}
	
	public TodoList() {
		
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}
	
	public ArrayList<Task> getTasks() {
		return this.tasks;
	}
	
	public Task getTask(int taskNumber) {
		return this.tasks.get(taskNumber);
	}
	
	public void removeTask(Task task) {
		this.tasks.remove(task);
	}
	
	public void removeTask(int taskNumber) {
		try {
			this.tasks.remove(taskNumber);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("No Such Task Exists");
		}
	}
	
	public String toString() {
		String temp = "";
		for (int index = 0; index < this.tasks.size(); index++) {
			temp += this.tasks.get(index).toString() + "\n";
		}
		return temp;
	}
}