
package pro.littleworld.webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  String task;

  public Todo() {}

  public Todo(int id, String task) {
    this.id = id;
    this.task = task;  }
  public int getId() { return id; }
  public void setId(int id)  { this.id = id; } 
  public String getTask() { return task; }
  public void setTask(String task)  { this.task = task; }  
  @Override 
  public String toString() {
    return "Todo: [" + "id: " + id + ", " + "task: " + task + "]";
  }
}

