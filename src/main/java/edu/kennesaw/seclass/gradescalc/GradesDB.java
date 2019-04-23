package edu.kennesaw.seclass.gradescalc;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A class that represents all the grades from the database
 */
public class GradesDB {

    private HashSet<Student> students = new HashSet<>();
    private HashMap<String, String[]> teams = new HashMap<>();
    private HashMap<String, Double> attendance = new HashMap<>();
    private HashMap<String, HashMap<String, Double>> individualGrades;
    private HashMap<String, HashMap<String, Double>> individualContrib;
    private HashMap<String, HashMap<String, Double>> teamGrades;


    /**
     * Creates a GradesDB class.
     *
     * @param dbPath The path of the db excel file.
     * @throws IOException            If reading the stream fails.
     * @throws InvalidFormatException If the specified file doesn't exist, and a parsing error occur.
     */
    public GradesDB(String dbPath) throws IOException, InvalidFormatException {
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(dbPath)).getFile());
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Read the student info into the DB
        XSSFSheet studentInfoSheet = workbook.getSheet("StudentsInfo");
        List<Integer> studentInfoBreaks = getSheetBreaks(studentInfoSheet);
        for (int i = studentInfoSheet.getFirstRowNum() + 1; i <= studentInfoSheet.getLastRowNum(); i++) {
            if (studentInfoBreaks.contains(i))
                continue;
            XSSFRow row = studentInfoSheet.getRow(i);
            XSSFCell sixthCell = row.getCell(6);
            students.add(new Student(
                    row.getCell(0).getStringCellValue(),
                    Integer.toString((int) row.getCell(1).getNumericCellValue()),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getNumericCellValue(),
                    row.getCell(4).getNumericCellValue(),
                    row.getCell(5).getNumericCellValue(),
                    sixthCell != null && !sixthCell.getStringCellValue().equals("N"),
                    this
            ));
        }

        // Read the team info into the DB
        XSSFSheet teamsSheet = workbook.getSheet("Teams");
        List<Integer> teamsBreaks = getSheetBreaks(teamsSheet);
        for (int i = teamsSheet.getFirstRowNum() + 1; i <= teamsSheet.getLastRowNum(); i++) {
            if (teamsBreaks.contains(i))
                continue;
            XSSFRow row = teamsSheet.getRow(i);
            String teamName = row.getCell(0).getStringCellValue();
            List<String> membersList = new ArrayList<>();
            for (int j = row.getFirstCellNum() + 1; j <= row.getLastCellNum(); j++) {
                XSSFCell cell = row.getCell(j);
                if (cell == null)
                    continue;
                membersList.add(cell.getStringCellValue());
            }
            teams.put(teamName, membersList.toArray(new String[0]));
        }


        // Read the attendance info into the DB
        XSSFSheet attendanceSheet = workbook.getSheet("Attendance");
        List<Integer> attendanceBreaks = getSheetBreaks(attendanceSheet);
        for (int i = attendanceSheet.getFirstRowNum() + 1; i <= studentInfoSheet.getLastRowNum(); i++) {
            if (attendanceBreaks.contains(i))
                continue;
            XSSFRow row = attendanceSheet.getRow(i);
            attendance.put(row.getCell(0).getStringCellValue(), row.getCell(1).getNumericCellValue());
        }

        // Read the individual grades into the DB
        XSSFSheet individualGradesSheet = workbook.getSheet("IndividualGrades");
        individualGrades = get2DHashMapFromSheet(individualGradesSheet);


        // Read the individual contributions into the DB
        XSSFSheet individualContribSheet = workbook.getSheet("IndividualContribs");
        individualContrib = get2DHashMapFromSheet(individualContribSheet);


        // Read the team grades into the DB
        XSSFSheet teamGradesSheet = workbook.getSheet("TeamGrades");
        teamGrades = get2DHashMapFromSheet(teamGradesSheet);

        workbook.close();
    }

    private List<Integer> getSheetBreaks(XSSFSheet sheet) {
        return Arrays.stream(sheet.getRowBreaks()).boxed().collect(Collectors.toList());
    }

    private String[] getHeaders(XSSFSheet sheet) {
        List<String> headersList = new ArrayList<>();
        sheet.getRow(sheet.getFirstRowNum()).cellIterator().forEachRemaining(
                (cell) -> headersList.add(cell.getStringCellValue())
        );
        return headersList.toArray(new String[0]);
    }

    private HashMap<String, HashMap<String, Double>> get2DHashMapFromSheet(XSSFSheet sheet) {
        HashMap<String, HashMap<String, Double>> finalHashMap = new HashMap<>();
        List<Integer> sheetBreaks = getSheetBreaks(sheet);
        String[] headers = getHeaders(sheet);
        for(int i = 1; i < headers.length; i++)
            finalHashMap.put(headers[i], new HashMap<>());
        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
            if (sheetBreaks.contains(i))
                continue;
            XSSFRow row = sheet.getRow(i);
            String name = "";
            HashMap<String, Double> assignmentGrades = new HashMap<>();
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                if (j < 0)
                    continue;
                XSSFCell cell = row.getCell(j);
                if (cell == null)
                    continue;
                if (cell.getCellType() == CellType.STRING)
                    name = cell.getStringCellValue();
                else if (cell.getCellType() == CellType.NUMERIC)
                    assignmentGrades.put(headers[j], cell.getNumericCellValue());
            }
            for(String assignment: assignmentGrades.keySet())
                finalHashMap.getOrDefault(assignment, new HashMap<>()).put(name, assignmentGrades.getOrDefault(assignment, -1d));
        }
        return finalHashMap;
    }

    /**
     * Gets the number of students in the database.
     *
     * @return The number of students.
     */
    public int getNumStudents() {
        return students.size();
    }

    /**
     * Gets the number of assignments in the database.
     *
     * @return The number of assignments.
     */
    public int getNumAssignments() {
        return individualGrades.size();
    }

    /**
     * Gets the number of projects in the database.
     *
     * @return The number of projects.
     */
    public int getNumProjects() {
        return teamGrades.size();
    }

    /**
     * Gets the all the students in the database.
     *
     * @return All the students in the database.
     */
    public HashSet<Student> getStudents() {
        return students;
    }

    /**
     * Gets a specific student from the database.
     *
     * @param studentName The name of the student to find.
     * @return Returns the student with the matching name, null if the student could not be found.
     */
    public Student getStudentByName(String studentName) {
        for(Student student : students)
            if (student.getName().compareTo(studentName) == 0)
                return student;
        return null;
    }

    /**
     * Gets a specific student from the database.
     *
     * @param studentId The id of the student to find.
     * @return Returns the student with the matching id, null if the student could not be found.
     */
    public Student getStudentByID(String studentId) {
        for(Student student : students)
            if (student.getId().compareTo(studentId) == 0)
                return student;
        return null;
    }

    /**
     * Gets a student's attendance.
     * @param studentName The name of the student to get the attendance for.
     * @return The attendance of the student. Returns -1 if the student is not found.
     */
    public Double getStudentAttendance(String studentName) {
        return attendance.getOrDefault(studentName, -1d);
    }


}
