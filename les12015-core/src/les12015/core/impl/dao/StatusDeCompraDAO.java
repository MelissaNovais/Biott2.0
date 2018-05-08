package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.EntidadeDominio;
import les12015.dominio.StatusDeCompra;

public class StatusDeCompraDAO extends AbstractJdbcDAO {

	public StatusDeCompraDAO() {
		super("status_compra", "sco_id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		PreparedStatement pst = null;
		
		StatusDeCompra status = (StatusDeCompra) entidade;
		String sql=null;
		
		if(status.getNomeStatus() == null){
			status.setNomeStatus("");
		}
		
		if (status.getId() == null && status.getNomeStatus().equals("")){
			sql = "SELECT * FROM status_compra";
		}else if(status.getId() != null ){
			sql = "SELECT * FROM status_compra WHERE sco_id=?";
		}else if(status.getId() == null && !status.getNomeStatus().equals("")){
			sql = "SELECT * FROM status_compra WHERE sco_status like ?";
		
		}
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			
			if(status.getId() != null ){
				pst.setInt(1, status.getId());
			}else if(status.getId() == null && ! status.getNomeStatus().equals("")){
				pst.setString(1, "%"+ status.getNomeStatus()+"%");			
			}
		
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> statuses = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				StatusDeCompra sta = new StatusDeCompra();
				sta.setId(rs.getInt("sco_id"));
				sta.setNomeStatus(rs.getString("sco_status"));
				statuses.add(sta);
			}
			return statuses;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
