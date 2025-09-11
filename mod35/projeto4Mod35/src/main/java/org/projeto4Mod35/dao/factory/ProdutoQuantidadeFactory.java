package org.projeto4Mod35.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.projeto4Mod35.domain.ProdutoJpa;
import org.projeto4Mod35.domain.ProdutoQuantidadeJpa;

public class ProdutoQuantidadeFactory {

	public static ProdutoQuantidadeJpa convert(ResultSet rs) throws SQLException {
		ProdutoJpa prod = ProdutoFactory.convert(rs);
        ProdutoQuantidadeJpa prodQ = new ProdutoQuantidadeJpa();
		prodQ.setProduto(prod);
		prodQ.setId(rs.getLong("ID"));
		prodQ.setQuantidade(rs.getInt("QUANTIDADE"));
		prodQ.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
		return prodQ;
	}
}
