package model;

import java.io.IOException;

import java.sql.SQLException;
import mobile.Lorann;

public class LorannModel implements IModel{
	
	private IMap map;
	
	private IMobile lorann;
	
	public LorannModel(final int level, final int lorannX, final int lorannY) throws IOException, SQLException{
		this.setMap(new Map(level));
		this.setLorann(new Lorann(lorannX, lorannY, this.getMap()));
	}

	@Override
	public void getLevelById(int id) throws SQLException {

	}

    public IMobile getLorann() {
        return this.lorann;
    }
    
    private void setLorann(Lorann lorann) {
        this.lorann = (IMobile) lorann;
    }
	
	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}


}
