package org.driss.ougrimper.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.site.Pays;
import org.springframework.jdbc.core.RowMapper;

public class PaysRM implements RowMapper<Pays> {

	@Override
	public Pays mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pays vPays = new Pays();
		vPays.setNom(rs.getString("nom"));
		return vPays;
	}

}
