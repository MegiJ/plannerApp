package pl.project.plannerapp.testexample;

import java.util.List;
public class CampOrganisation {
    private final List<String> students;

    public CampOrganisation(List<String> students) {
        this.students = students;
    }

    /**
     * @param newStudentFirstName
     * @param newStudentLastName
     * @return
     */
    public boolean addStudent(String newStudentFirstName, String newStudentLastName
    ) {
        if (newStudentFirstName == null || newStudentLastName == null) {
            throw new IllegalArgumentException("names cannot be null!");
        }
        String transformedName = transformName(newStudentFirstName, newStudentLastName);
        if (students.contains(transformedName)) {
            return false;
        }
        this.students.add(transformedName);
        return true;
    }

    public String transformName(String newStudentFirstName, String newStudentLastName) {
        return newStudentFirstName + " " + newStudentLastName;
    }

    public String getStudent(String name) {
        return this.students.stream()
                .filter(s -> s.contains(name))
                .findFirst()
                .orElse("");
    }
}
