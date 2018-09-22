import java.util.Scanner;
import java.util.Arrays;
import java.lang.*;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
class Task {
	private String taskTitle;
	private String nameOfPerson;
	private int timeMin;
	private String impOrNot;
	private String urgentOrNot;
	private String pendingOrNot;

	public Task(String title, String name, int time, String imp, String urgent, String pending) {
		this.taskTitle = title;
		this.nameOfPerson = name;
		this.timeMin = time;
		this.impOrNot = imp;
		this.urgentOrNot = urgent;
		this.pendingOrNot = pending;
	}
	public String getTitle() {
		if(this.taskTitle == "") {
			return "Title not privided";
		} else {
		return this.taskTitle;
	}
}
	public String getPersonName() {
		return this.nameOfPerson;
	}
	public int getTime() {
		if (timeMin < 0) {
			return this.timeMin ;
		} else {
		return this.timeMin;
	}
}
	public String getImpOrNot() {
		if (this.impOrNot.equals("y")) {
			return "Important";
		}
			else {
				return "Not Important";

			}
		}


	public String getUrgentOrNot() {
		 if (this.urgentOrNot.equals("y")){
		 	return "Urgent";
		 }
		 else {
		 	return "Not Urgent";
		 }
	}
	public String getPendingorNot() {
		if (this.pendingOrNot.equals("todo") || this.pendingOrNot.equals("done")) {
		if(this.pendingOrNot.equals("todo")) {
			return "todo";
		}
		else {
			return "done";
		}
	}
	else {
		return "Invalid status" + this.pendingOrNot;
		}
	}
	public String toString() {
		return getTitle() + ", " + getPersonName() + ", " +getTime() + ", " + getImpOrNot() + ", " +getUrgentOrNot() + ", " + getPendingorNot();
	}
}
class Todoist {
	private List<Task>taskList;
	public Todoist() {
		taskList = new List<Task>();
	}

	public void addATask(Task t) {
		taskList.add(t);
	}
	public void testTask() {
		for (int i = 0;i<taskList.size(); i++) {
			System.out.println(taskList.get(i).toString());
		}
	}
	public void testAddTask(Task t) {
		taskList.add(t);
	}
	public void printAll() {
		for (int i =0 ; i<taskList.size(); i++) {
			System.out.println(taskList.get(i).toString());
		}
	}



}
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void main(String[] args) {


    //public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                Task t = new Task(tokens[1], tokens[2], Integer.parseInt(tokens[3]), tokens[4], tokens[5], tokens[6]);
                todo.addATask(t);
                todo.testTask();
                break;
                case "add-task":
                todo.testAddTask(new Task(tokens[1], tokens[2], Integer.parseInt(tokens[3]), tokens[4], tokens[5], tokens[6]));
                break;
                case "print-todoist":
                todo.printAll();
                // break;
                // case "get-next":
                //     System.out.println(todo.getNextTask(tokens[1]));
                // break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
                default:
                break;
            }
        }
    }

//     /**
//      * method to test add task.
//      *
//      * @param      todo    The todo
//      * @param      tokens  The tokens
//      */
//     public static void testAddTask(final Todoist todo, final String[] tokens) {
//         try {
//             todo.addTask(createTask(tokens));
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//     }

//     /**
//      * method to test the creation of task object.
//      *
//      * @param      tokens  The tokens
//      */
//     public static void testTask(final String[] tokens) {
//         try {
//             System.out.println(createTask(tokens));
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//     }

//     /**
//      * Creates a task object.
//      *
//      * @param      tokens     The tokens
//      *
//      * @return     Task object
//      *
//      * @throws     Exception  if task inputs are invalid
//      */
//     public static Task createTask(final String[] tokens) throws Exception {
//         String title = tokens[1];
//         String assignedTo = tokens[2];
//         int timeToComplete = Integer.parseInt(tokens[3]);
//         boolean important = tokens[4].equals("y");
//         boolean urgent = tokens[5].equals("y");
//         String status = tokens[6];
//         return new Task(
//             title, assignedTo, timeToComplete, important, urgent, status);
//     }

//     /**
//      * main method.
//      *
//      * @param      args  The command line arguments
//      */
//     public static void main(final String[] args) {
//         startTest();
//     }
}
