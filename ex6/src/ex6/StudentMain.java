/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex6;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;
import model.StudentTable;

/**
 *
 * @author ACER
 */
public class StudentMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Student std1 = new Student(1, "John", 3.7);
       Student std2 = new Student(2, "Marry", 3.5);
       StudentTable.insertStudent(std1);
       StudentTable.insertStudent(std2);
       
       Student std3 = new Student(3, "microphone", 3.4);
       StudentTable.updateStudent(std3);
       
       StudentTable.removeStudent(std3);
       
    }
    
    public static void printAllStudent(List<Student> studentList) {
        for(Student std : studentList) {
            System.out.print(std.getId() + " ");
            System.out.print(std.getName() + " ");
            System.out.println(std.getGpa() + " ");
       }
    
    
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex6PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
