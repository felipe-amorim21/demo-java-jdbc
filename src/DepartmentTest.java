import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("---------- Department insert ---------");
        Department department = new Department(null, "Foods");
        departmentDao.insert(department);

        System.out.println("---------- Department update ---------");
        department = departmentDao.findById(1);
        department.setName("Music");
        departmentDao.update(department);

        System.out.println("---------- Department findById ---------");
        department = departmentDao.findById(4);
        System.out.println(department);

        System.out.println("---------- Department findAll ---------");
        List<Department> list = departmentDao.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }

        System.out.println("---------- Department delete by id ---------");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete Completed");
    }
}
