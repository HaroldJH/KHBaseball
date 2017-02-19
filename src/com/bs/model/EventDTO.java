/**
 * 
 */
package com.bs.model;

/**
 * @author YJH
 *
 */
public class EventDTO {
	private int eventId;
	private int playerEventId;
	private int playerId;
	private int inning;
	private String playerName;
	private String playerEvent;
	private int playerSeq;
	
	public int getPlayerSeq() {
		return playerSeq;
	}
	public void setPlayerSeq(int playerSeq) {
		this.playerSeq = playerSeq;
	}
	public String getPlayerEvent() {
		return playerEvent;
	}
	public void setPlayerEvent(String playerEvent) {
		this.playerEvent = playerEvent;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getPlayerEventId() {
		return playerEventId;
	}
	public void setPlayerEventId(int playerEventId) {
		this.playerEventId = playerEventId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getInning() {
		return inning;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
}
