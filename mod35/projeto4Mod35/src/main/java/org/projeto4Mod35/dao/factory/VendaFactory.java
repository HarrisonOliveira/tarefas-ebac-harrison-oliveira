package org.projeto4Mod35.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.projeto4Mod35.domain.ClienteJpa;
import org.projeto4Mod35.domain.VendaJpa;

public class VendaFactory {

	public static VendaJpa convert(ResultSet rs) throws SQLException {
		ClienteJpa cliente = ClienteFactory.convert(rs);
        VendaJpa venda = new VendaJpa();
		venda.setCliente(cliente);
		venda.setId(rs.getLong("ID_VENDA"));
		venda.setCodigo(rs.getString("CODIGO"));
		venda.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
		venda.setDataVenda(rs.getTimestamp("DATA_VENDA").toInstant());
		venda.setStatus(VendaJpa.Status.getByName(rs.getString("STATUS_VENDA")));
		return venda;
	}
}
