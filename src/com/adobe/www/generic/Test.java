package generic;

import generic.dao.IDeptDAO;
import generic.dao.IEmpDAO;
import generic.dao.impl.DeptDAOImpl;
import generic.dao.impl.EmpDAOImpl;
import generic.domain.Dept;
import generic.domain.Emp;

public class Test {
	public static void main(String[] args) {
		
		IDeptDAO deptDao = new DeptDAOImpl();
		Dept dept   = deptDao.get(123);
		System.out.println(dept);
		IEmpDAO empDao = new EmpDAOImpl();
		Emp emp  = empDao.get(222);
		System.out.println(emp);
	}
}
