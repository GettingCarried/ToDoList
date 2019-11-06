import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;
import java.util.Set;
import java.util.HashSet;

public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	private ToDoList toDoList;
	private Task task1;
	private Task task2;

	
	public ToDoListTest() {
		super();
		toDoList = new ToDoList();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		task1 = new Task("task1", false);
		task2 = new Task("task2", false);
	}
	@After
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
		toDoList = new ToDoList();
	}

	@Test
	public void testAddTask() {
		assertTrue(toDoList.getAllTasks().isEmpty());
		toDoList.addTask(task1);
		assertFalse(toDoList.getAllTasks().isEmpty());
		assertEquals(toDoList.getTask(task1.getDescription()), task1);
	}
	@Test
	public void testGetStatus() {
		toDoList.addTask(task1);
		boolean status = toDoList.getStatus(task1.getDescription());
		assertEquals(status, task1.isComplete());
		toDoList.completeTask(task1.getDescription());
		assertEquals(true, toDoList.getStatus(task1.getDescription()));
	}
	@Test
	public void testRemoveTask() {
		toDoList.addTask(task1);
		assertNotNull(toDoList.getTask(task1.getDescription()));
		toDoList.removeTask(task1.getDescription());
		assertNull(toDoList.getTask(task1.getDescription()));
	}
	
	@Test
	public void testModifyTask() {
		assertTrue(toDoList.getAllTasks().isEmpty());
		try {
		toDoList.modifyTask("task1", "task2");
		fail();
		}
		catch (NullPointerException ex) {
		}
		toDoList.addTask(task1);
		assertEquals(toDoList.getTask("task1"), task1);
		try {
			toDoList.modifyTask("task1", "task2");
			}
			catch (NullPointerException ex) {
			fail();
			}
		assertEquals(toDoList.getTask("task2"), task1);
	}
	@Test
	public void testGetCompletedTasks() {
		toDoList.addTask(task1);
		toDoList.addTask(task2);
		Set<Task> result = (Set<Task>) toDoList.getCompletedTasks();
		assertTrue(result.isEmpty());
		for (Task task : result) {
			if (!task.isComplete()) {
				fail();
			}
		}
		task1.setComplete(true);
		toDoList.addTask(task1);
		result = (Set<Task>) toDoList.getCompletedTasks();
		assertFalse(result.isEmpty());
		for (Task task : result) {
			if (!task.isComplete()) {
				fail();
			}
		}
	}
}
