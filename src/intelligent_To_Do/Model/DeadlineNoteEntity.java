package intelligent_To_Do.Model;

import java.sql.Time;
import java.sql.Timestamp;

import org.json.simple.JSONObject;

public class DeadlineNoteEntity extends NoteEntity {

	
	private int progressPercentage;
	private String deadLineTitle;
	private Timestamp deadLineDate;

	public int getProgressPercentage() {
		return progressPercentage;
	}

	

	public void setProgressPercentage(int progressPercentage) {
		this.progressPercentage = progressPercentage;
	}

	public String getDeadLineTitle() {
		return deadLineTitle;
	}

	public void setDeadLineTitle(String deadLineTitle) {
		this.deadLineTitle = deadLineTitle;
	}

	public Timestamp getDeadLineDate() {
		return deadLineDate;
	}

	public void setDeadLineDate(Timestamp deadLineDate) {
		this.deadLineDate = deadLineDate;
	}

	public DeadlineNoteEntity() {
		super();
	}

	public DeadlineNoteEntity(
			 
			int progressPercentage, 
			String deadLineTitle,
			Timestamp deadLineDate, 
			String noteID, 
			String userID, 
			Timestamp creationDate, 
			boolean isDone,
			boolean isTextCategorized, 
			String noteType) {
		super(noteID, userID, creationDate, isDone, isTextCategorized, noteType);
		
		this.progressPercentage = progressPercentage;
		this.deadLineTitle = deadLineTitle;
		this.deadLineDate = deadLineDate;
	}
	
	

}
