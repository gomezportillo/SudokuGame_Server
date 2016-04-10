package com.sudokus.dominio;

import org.json.JSONException;
import org.json.JSONObject;

import edu.uclm.esi.common.jsonMessages.JSONMessage;
import edu.uclm.esi.common.jsonMessages.JSONable;

public class SudokuMovementAnnouncementMessage  extends JSONMessage{
	
	@JSONable
	private int row;
    @JSONable
    private int col;
	
    public SudokuMovementAnnouncementMessage(int row, int col) {
		super(false);
		this.setRow(row);
		this.setCol(col);		
	}
    
    public SudokuMovementAnnouncementMessage (JSONObject jso) throws JSONException {
        this(jso.getInt("row"), jso.getInt("col"));
    }
    
	public int getRow() { return row; }

	public void setRow(int row) { this.row = row; }

	public int getCol() { return col; }

	public void setCol(int col) { this.col = col; }

}
