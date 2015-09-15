package pl.plask.team.yplanner.bc.model.ds.helper;

import java.util.Iterator;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import pl.plask.team.yplanner.bc.model.ds.UserDS;

public class UserDSQueryBuilder {
	
	private static final String DEFAULT_SORT_COL = UserDS.ID_COL;
	private static final String DEFAULT_SORT_DIR = Sort.Direction.ASC.name();
	
	public static final String PAGE_START_PARAM = "start";
	public static final String PAGE_END_PARAM = "end";
	
	public static final String buildPagedQuery(Pageable page) {
		StringBuilder sb = new StringBuilder("SELECT ");
		sb.append(UserDS.ID_COL + ",");
		sb.append(UserDS.FIRST_NAME_COL + ",");
		sb.append(UserDS.LAST_NAME_COL + ",");
		sb.append(UserDS.ADMIN_COL + ",");
		sb.append(UserDS.LOGIN_COL + ",");
		sb.append(UserDS.PASSWORD_COL + ",");
		sb.append(UserDS.EMAIL_COL);
		sb.append(" FROM (SELECT u.*, rownum ind FROM ");
		sb.append(UserDS.TABLE_NAME);
		sb.append(" u ");
		if (page.getSort() != null) {
			for (Iterator<Order> it = page.getSort().iterator(); it.hasNext();) {
				Order o = it.next();
				sb.append(o.getProperty());
				sb.append(" ");
				sb.append(o.getDirection());
				sb.append(" ");
			}
		} else {
			sb.append("ORDER BY ");
			sb.append(DEFAULT_SORT_COL);
			sb.append(" ");
			sb.append(DEFAULT_SORT_DIR);
		}
		sb.append(") WHERE ind >= :" + PAGE_START_PARAM + " AND ind <= :");
		sb.append(PAGE_END_PARAM);
		return sb.toString();
	}
}
