/**
 * 
 */
package com.bs.model;

/**
 * @author YJH
 *
 */
public class KindEventDTO {
	private int PlayerEventId;
	private String PlayerEvent;
	private char kind;
	
	public int getPlayerEventId() {
		return PlayerEventId;
	}
	public void setPlayerEventId(int playerEventId) {
		PlayerEventId = playerEventId;
	}
	public String getPlayerEvent() {
		return PlayerEvent;
	}
	public void setPlayerEvent(String playerEvent) {
		PlayerEvent = playerEvent;
	}
	public char getKind() {
		return kind;
	}
	public void setKind(char kind) {
		this.kind = kind;
	}
}
