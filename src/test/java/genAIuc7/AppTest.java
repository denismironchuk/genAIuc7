package genAIuc7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    private StudentConverter studentConverter;

    @BeforeEach
    public void setup() {
        studentConverter = new StudentConverter();
    }

    @Test
    public void testHonorRollForStudentsAbove21AndGradeAbove90() {
        // Given: A student of age 21 or above with a grade above 90
        Student student1 = new Student();
        student1.setName("John");
        student1.setAge(22);
        student1.setGrade(95);

        List<Student> students = Arrays.asList(student1);

        // When: We call the convertStudents method
        List<Student> convertedStudents = studentConverter.convertStudents(students);

        // Then: The returned list should contain a student object with HonorRoll = true
        assertEquals(1, convertedStudents.size());
        assertTrue(convertedStudents.get(0).isHonorRoll());
    }

    @Test
    public void testExceptionalForStudentsBelow21AndGradeAbove90() {
        // Given: A student of age less than 21 with a grade above 90
        Student student1 = new Student();
        student1.setName("Jane");
        student1.setAge(20);
        student1.setGrade(92);

        List<Student> students = Arrays.asList(student1);

        // When: We call the convertStudents method
        List<Student> convertedStudents = studentConverter.convertStudents(students);

        // Then: The returned list should contain a student object with Exceptional = true
        assertEquals(1, convertedStudents.size());
        assertTrue(convertedStudents.get(0).isExceptional());
    }

    @Test
    public void testPassedForStudentsWithGradeBetween71And90() {
        // Given: A student with a grade between 71 and 90
        Student student1 = new Student();
        student1.setName("Jim");
        student1.setAge(19);
        student1.setGrade(85);

        List<Student> students = Arrays.asList(student1);

        // When: We call the convertStudents method
        List<Student> convertedStudents = studentConverter.convertStudents(students);

        // Then: The returned list should contain a student object with Passed = true
        assertEquals(1, convertedStudents.size());
        assertTrue(convertedStudents.get(0).isPassed());
    }

    @Test
    public void testNotPassedForStudentsWithGrade70OrLess() {
        // Given: A student with a grade of 70 or less
        Student student1 = new Student();
        student1.setName("Emily");
        student1.setAge(18);
        student1.setGrade(60);

        List<Student> students = Arrays.asList(student1);

        // When: We call the convertStudents method
        List<Student> convertedStudents = studentConverter.convertStudents(students);

        // Then: The returned list should contain a student object with Passed = false
        assertEquals(1, convertedStudents.size());
        assertFalse(convertedStudents.get(0).isPassed());
    }

    @Test
    public void testEmptyListReturnsEmptyList() {
        // Given: An empty list of students
        List<Student> students = Collections.emptyList();

        // When: We call the convertStudents method
        List<Student> convertedStudents = studentConverter.convertStudents(students);

        // Then: The returned list should be empty
        assertTrue(convertedStudents.isEmpty());
    }

    @Test
    public void testNullInputThrowsError() {
        // Given: A null list
        List<Student> students = null;

        // When/Then: We call the convertStudents method, it should throw an exception
        assertThrows(NullPointerException.class, () -> studentConverter.convertStudents(students));
    }
}
