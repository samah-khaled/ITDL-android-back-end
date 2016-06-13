package intelligent_To_Do.Model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import org.json.simple.JSONObject;

public class MeetingNoteEntity extends NoteEntity {

	

	protected Date meetingNoteDate; 
	protected Time estimatedTransportTime;	
	protected String meetingTitle;
	protected String meetingPlace;
	protected String meetingAgenda;
	
	
	
	

	public MeetingNoteEntity() {
		super();
	}
	
	public MeetingNoteEntity(
			Date meetingNoteDate, 
			Time estimatedTransportTime, 
			String meetingTitle,
			String meetingPlace, 
			String meetingAgenda, 
			String noteID,
			String userID, 
			Timestamp creationDate,
			boolean isDone, 
			boolean isTextCategorized,
			String noteType) {
		super(noteID,userID,creationDate,isDone,isTextCategorized,noteType);
		this.meetingNoteDate = meetingNoteDate;
		this.estimatedTransportTime = estimatedTransportTime;
		this.meetingTitle = meetingTitle;
		this.meetingPlace = meetingPlace;
		this.meetingAgenda = meetingAgenda;
		
	}

	public Date getmeetingNoteDate() {
		return meetingNoteDate;
	}
	public void setmeetingNoteDate(Date meetingNoteDate) {
		this.meetingNoteDate = meetingNoteDate;
	}
	public Time getEstimatedTransportTime() {
		return estimatedTransportTime;
	}
	public void setEstimatedTransportTime(Time estimatedTransportTime) {
		this.estimatedTransportTime = estimatedTransportTime;
	}
	public String getMeetingTitle() {
		return meetingTitle;
	}
	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}
	public String getMeetingPlace() {
		return meetingPlace;
	}
	public void setMeetingPlace(String meetingPlace) {
		this.meetingPlace = meetingPlace;
	}
	public String getMeetingAgenda() {
		return meetingAgenda;
	}
	public void setMeetingAgenda(String meetingAgenda) {
		this.meetingAgenda = meetingAgenda;
	}

	
	

}
