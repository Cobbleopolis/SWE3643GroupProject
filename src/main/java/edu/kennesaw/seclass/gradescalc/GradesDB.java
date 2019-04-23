package edu.kennesaw.seclass.gradescalc;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.HashSet;

/**
 * A class that represents all the grades from the database
 */
public class GradesDB {

    XSSFWorkbook workbook = null;

    /**
     * Creates a GradesDB class.
     * @param dbPath The path of the db excel file.
     * @throws IOException
     */
    public GradesDB(String dbPath) throws IOException {
        workbook = new XSSFWorkbook(dbPath);
    }

    /**
     * Gets the number of students in the database.
     * @return The number of students.
     */
    public int getNumStudents() {
        return -1; //TODO Actually count the number of students.
    }

    /**
     * Gets the number of assignments in the database.
     * @return The number of assignments.
     */
    public int getNumAssignments() {
        return -1; //TODO Actually count the number of assignments.
    }

    /**
     * Gets the number of projects in the database.
     * @return The number of projects.
     */
    public int getNumProjects() {
        return -1; //TODO Actually count the number of projects.
    }

    /**
     * Gets the all the students in the database.
     * @return All the students in the database.
     */
    public HashSet<Student> getStudents() {
        return new HashSet<>(); //TODO Actually get students.
    }

    /**
     * Gets a specific student from the database.
     * @param studentName The name of the student to find
     * @return Returns the student with the matching name, null if the student could not be found.
     */
    public Student getStudentByName(String studentName) {
        return null; //TODO actually get a student.
    }

    /**
     * Gets a specific student from the database.
     * @param studentId The id of the student to find
     * @return Returns the student with the matching id, null if the student could not be found.
     */
    public Student getStudentByID(String studentId) {
        return null; //TODO actually get the student.
    }
    
    

}
